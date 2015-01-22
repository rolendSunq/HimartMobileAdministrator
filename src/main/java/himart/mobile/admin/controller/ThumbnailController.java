package himart.mobile.admin.controller;


import himart.mobile.admin.common.Constants;
//import himart.mobile.admin.dao.ImageUploadDao;
import himart.mobile.admin.dao.ThumbnailUploadDao;
import himart.mobile.admin.util.DateUtil;
import himart.mobile.admin.util.StringUtil;
import himart.mobile.admin.vo.ImageUploadMultiVO;
import himart.mobile.admin.vo.ImageUploadVO;
//import himart.mobile.admin.vo.ThumbnailUploadVO;
import himart.mobile.admin.vo.RecomHofficeVO;
import himart.mobile.admin.vo.UserInfoVO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ThumbnailController {
	private Logger logger = Logger.getLogger(ThumbnailController.class);

	@Value("#{config['image_path']}")
	private String IMAGE_PATH;

//	private final String IMG_UPLOAD_PATH = "/upload/";
	private final String IMG_UPLOAD_PATH = "/bg/";

	@Autowired
	private ThumbnailUploadDao thumbnailUploadDao;

	/**
	 * Thumbnail 이미지 목록화면
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/moveThumbnailUpload.do")
	public ModelAndView initImageUpload(HttpServletRequest req, HttpServletResponse res, ImageUploadVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		//  Thumbnail 이미지 목록 조회
		resultMap.put("list", new ArrayList<ImageUploadVO>());

		if (paramVO.getImgCfCd() == null || "".equals(paramVO.getImgCfCd())) {
			resultMap.put("pageNo", "0");
			resultMap.put("pageSize", "10");
			resultMap.put("totalCnt", "0");
		}
		else {
			//  Thumbnail 이미지 총건수 조회
			resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
			resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));
			resultMap.put("totalCnt", String.valueOf(thumbnailUploadDao.getImageUploadTotCount(paramVO)));
		//차후 삭제
			resultMap.put("totalCnt",  "10");

			//  Thumbnail 이미지 목록 조회
//			if (Integer.parseInt((String) resultMap.get("totalCnt")) > 0) {
				resultMap.put("list", thumbnailUploadDao.getImageUploadTotList(paramVO));
//			}
		}

		resultMap.put("params", paramVO);

		return new ModelAndView("thumbnail/upload");
	}

	/**
	 *  Thumbnail 이미지 등록화면
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/thumbnailUploadReg.do")
	public String initImageUploadReg(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		return "thumbnail/register";
	}

	/**
	 *  Thumbnail 이미지 등록 처리
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/thumbnailUploadRegProc.do")
	public String processImageUploadReg(HttpServletRequest req, HttpServletResponse res, ImageUploadMultiVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		try {
			UserInfoVO userInfo = (UserInfoVO) req.getSession(false).getAttribute(Constants.SESSION_LOGIN_INFO);

			if (userInfo == null) {
				throw new Exception();
			}
			// 실제 파일 저장 처리
			processImageUploadReg(paramVO, userInfo.getEmpNo());

			return "thumbnail/registerSuccess";
		} catch (Exception ex) {
			
			if (paramVO.getImgCfCd().length > 0) {
				if ("reg".equals(paramVO.getImgUploadType()[0])) {
					return "thumbnail/registerFailureBG";
				}
			}
			return "thumbnail/registerFailure";
		}
	}

	/**
	 * 섬네일 업로드 요청 처리
	 * 
	 * @param paramVO
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { DataAccessException.class, Exception.class })
	private void processImageUploadReg(ImageUploadMultiVO paramVO, String empNo) throws Exception {
		try {
			
			for (int i = 0; i < paramVO.getImgCfCd().length; i++) {
				// 저장파일명
		 
				String saveFileNm = getNewFilename(paramVO.getImgCfCd()[i], paramVO.getPrdNicNm()[i], paramVO.getImgPstCfCd()[i], paramVO.getImgOrigFile()[i].getOriginalFilename());
				// DB 등록 처리
				ImageUploadVO vo = new ImageUploadVO();

				vo.setImgUploadType( paramVO.getImgUploadType()[i]   );
				
				vo.setImgCfCd(paramVO.getImgCfCd()[i]);
				vo.setPrdNicNm(paramVO.getPrdNicNm()[i]);
			
				if (StringUtil.isNull(paramVO.getAccPrdId()[i])) {
					vo.setAccPrdId("0000000000"); // 액세서리가 아닐 경우
				}
				else {
					vo.setAccPrdId(paramVO.getAccPrdId()[i]);
				}
				vo.setImgPstCfCd(paramVO.getImgPstCfCd()[i]);
				vo.setImgOrigFileNm(paramVO.getImgOrigFile()[i].getOriginalFilename());
				vo.setImgSaveFileNm(saveFileNm);
				vo.setImgSavePath(IMG_UPLOAD_PATH);
				vo.setEmpNo(empNo);
				vo.setUpdDt(DateUtil.getFormatedCurrentDate("yyyyMMddHHmmss"));
				
				// 배경이미지(7) 순번 재설정. 
				if("reg".equals(vo.getImgUploadType()) && "7".equals(vo.getImgCfCd())){
					vo.setImgPstCfCd(getImgPstCfCd(vo, i)  );
				}
				
				// 본사, 지점 (5/6) 등록 갯수 체크. 
				if("reg".equals(vo.getImgUploadType()) && ("5".equals(vo.getImgCfCd()) || "6".equals(vo.getImgCfCd())) ){
					int cnt = thumbnailUploadDao.getBackImgTotCount(vo);
					System.out.println("cnt==="+ cnt);
					if (cnt > 0) {
						throw new Exception("본사/지점 이미지는 한개 이상 저장 하지 못합니다.");
					}  
				}
				
				// DB 저장 및 파일 저장
				if (thumbnailUploadDao.updateImageUpload(vo) <= 0 || !saveFile(paramVO.getImgOrigFile()[i], IMAGE_PATH + IMG_UPLOAD_PATH, saveFileNm)) {
					throw new Exception("파일 저장 중 오류가 발생하였습니다.");
				}
			}
		} catch (Exception ex) {
			logger.error(ex);

			throw new Exception(ex);
		}
	}
	
	/**
	 *  배경이미지 순번 재설정.
	 * 
	 * @param ImageUploadVO
	 * @return ImgpstCfCd
	 */
	private String getImgPstCfCd(ImageUploadVO vo, int cnt) throws Exception {

		try {
			
			String pstCfCd = "01";

			cnt = thumbnailUploadDao.getBackImgTotCount(vo);

			if (cnt < 5) {
				pstCfCd = String.format("%02d", cnt + 1);
			} else {
				throw new Exception("배경이미지는 5개 이상 저장 하지 못합니다.");
			}

			return pstCfCd;
		} catch (Exception ex) {
			logger.error(ex);

			throw new Exception(ex);
		}
	}

	/**
	 * 저장파일명 생성
	 * 
	 * @param imgCfCdNm
	 * @param prdNicNm
	 * @param imgPstCfCd
	 * @param originalFilename
	 * @return
	 */
	private String getNewFilename(String imgCfCdNm, String prdNicNm, String imgPstCfCd, String originalFilename) {
		if (originalFilename.lastIndexOf(".") >= 0) {
			return imgCfCdNm + "_" + prdNicNm + "_" + imgPstCfCd + "_" + DateUtil.getFormatedCurrentDate("yyyyMMddHHmmssSSS") + originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
		}
		else {
			return imgCfCdNm + "_" + prdNicNm + "_" + imgPstCfCd + "_" + DateUtil.getFormatedCurrentDate("yyyyMMddHHmmssSSS") + originalFilename;
		}
	}

	/**
	 * 파일 저장
	 * 
	 * @param file
	 * @param filepath
	 * @param fileName
	 * @return 저장성공여부
	 */
	private boolean saveFile(MultipartFile file, String filepath, String fileName) {
		FileOutputStream fos = null;

		try {
			byte fileData[] = file.getBytes();

			File saveFile = new File(filepath + fileName);

			// 상위 디렉토리 생성
			saveFile.getParentFile().mkdirs();

			fos = new FileOutputStream(saveFile);

			fos.write(fileData);
			fos.flush();
		} catch (Exception ex) {
			logger.error(ex);

			return false;
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception ignore) {
				}
			}
		}

		return true;
	}

	/**
	 *  Thumbnail 이미지 목록 삭제 후 결과 리턴
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/thumbnailUploadDelete.do")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { DataAccessException.class, Exception.class })
	public ModelAndView deleteImageUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam(value = "data", required = true) String params, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		Map<String, String> returnMap = new HashMap<String, String>();

		try {
			if (StringUtil.isNull(params)) {
				returnMap.put("code", "999");
				returnMap.put("message", "삭제할 자료를 선택하세요.");
			}
			else {
				deleteImageUpload(params);

				returnMap.put("code", "000");
				returnMap.put("message", "정상적으로 삭제되었습니다.");
			}
		} catch (Exception e) {
			logger.error(e);

			returnMap.put("code", "999");
			returnMap.put("message", "삭제 중 오류가 발생하였습니다.");
		}

		resultMap.put("result", returnMap);

		return new ModelAndView(Constants.JSONVIEW);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { DataAccessException.class, Exception.class })
	public void deleteImageUpload(String params) throws Exception {
		try {
			logger.debug(params);
			List<String> keyList = new ArrayList<String>(Arrays.asList(params.split("\\|")));

			for (int i = 0; i < keyList.size(); i++) {
				String[] keyArr = keyList.get(i).split("\\^");

				if (keyArr.length != 4) {
					throw new Exception("삭제 중 오류가 발생하였습니다.");
				}

				ImageUploadVO vo = new ImageUploadVO();

				vo.setImgCfCd(keyArr[0]);
				vo.setPrdNicNm(keyArr[1]);
				vo.setAccPrdId(keyArr[2]);
				vo.setImgPstCfCd(keyArr[3]);

				if (thumbnailUploadDao.deleteImageUpload(vo) != 1) {
					throw new Exception("삭제 중 오류가 발생하였습니다.");
				}
			}
		} catch (Exception ex) {
			logger.error(ex);

			throw new Exception(ex);
		}
	}

	/**
	 *  Thumbnail 이미지 수정화면
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/thumbnailUploadMod.do")
	public ModelAndView initImageUploadMod(HttpServletRequest req, HttpServletResponse res, ImageUploadVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		resultMap.put("params", paramVO);

		return new ModelAndView("thumbnail/modify");
	}

	/**
	 *  Thumbnail 이미지 미리보기 화면
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/thumbnailUploadPreview.do")
	public ModelAndView previewImageUpload(HttpServletRequest req, HttpServletResponse res, ImageUploadVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		resultMap.put("params", paramVO);

		return new ModelAndView("thumbnail/preview");
	}

	/**
	 *  Thumbnail 이미지 파일 다운로드
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/thumbnailUploadView.do")
	public byte[] viewImageUpload(HttpServletRequest req, HttpServletResponse res, RecomHofficeVO paramVO, BindingResult result) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		if (paramVO.getImgSaveFileNm().toLowerCase().endsWith(".png")) {
			res.setContentType(MediaType.IMAGE_PNG_VALUE);
		}
		else if (paramVO.getImgSaveFileNm().toLowerCase().endsWith(".jpeg") || paramVO.getImgSaveFileNm().toLowerCase().endsWith(".jpg")) {
			res.setContentType(MediaType.IMAGE_JPEG_VALUE);
		}

		InputStream in = new FileInputStream(IMAGE_PATH + paramVO.getImgSavePath() + paramVO.getImgSaveFileNm());

		return IOUtils.toByteArray(in);
	}
}
