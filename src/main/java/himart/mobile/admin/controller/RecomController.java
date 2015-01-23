package himart.mobile.admin.controller;


import himart.mobile.admin.common.Constants;
import himart.mobile.admin.dao.RecomHofficeDao;
import himart.mobile.admin.util.DateUtil;
import himart.mobile.admin.util.StringUtil;
import himart.mobile.admin.vo.RecomHofficeVO;
import himart.mobile.admin.vo.SalePriceBoardMultiVO;
import himart.mobile.admin.vo.SalePriceBoardVO;
import himart.mobile.admin.vo.UserInfoVO;

import java.io.File;
import java.io.FileInputStream;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RecomController {
	private Logger logger = Logger.getLogger(RecomController.class);

	@Autowired
	private RecomHofficeDao recomHofficeDao;

	@Value("#{config['image_path']}")
	private String IMAGE_PATH;

	/**
	 * 본사추천 목록화면
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recomHoffice.do")
	public ModelAndView initRecomHoffice(HttpServletRequest req, HttpServletResponse res, RecomHofficeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		// 본사추천 목록 조회
		resultMap.put("list", new ArrayList<RecomHofficeVO>());

		if (paramVO.getRegDt() == null || "".equals(paramVO.getRegDt())) {
			// 본사추천 최종등록일자 조회
			String lastRegDate = recomHofficeDao.getLastRegDate();

			if (StringUtil.isNull(lastRegDate)) {
				resultMap.put("lastRegDate", "");
			}
			else {
				resultMap.put("lastRegDate", recomHofficeDao.getLastRegDate().replaceAll("([0-9]{4})([0-9]{2})([0-9]{2})", "$1-$2-$3"));
			}

			resultMap.put("pageNo", "0");
			resultMap.put("pageSize", "15");
			resultMap.put("totalCnt", "0");
		}
		else {
			// 본사추천 등록일
			resultMap.put("lastRegDate", paramVO.getRegDt());

			paramVO.setRegDt(paramVO.getRegDt().replaceAll("[^0-9]", ""));

			// 본사추천 총건수 조회
			resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
			resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));
			resultMap.put("totalCnt", String.valueOf(recomHofficeDao.getRecomHofficeTotCount(paramVO)));

			// 본사추천 목록 조회
			if (Integer.parseInt((String) resultMap.get("totalCnt")) > 0) {
				resultMap.put("list", recomHofficeDao.getRecomHofficeTotList(paramVO));
			}
		}

		resultMap.put("params", paramVO);

		return new ModelAndView("recom/hoffice");
	}

	/**
	 * 본사추천 목록 삭제 후 결과 리턴
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recomHofficeDelete.do")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { DataAccessException.class, Exception.class })
	public ModelAndView deleteRecomHoffice(HttpServletRequest req, HttpServletResponse res, RecomHofficeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		Map<String, String> returnMap = new HashMap<String, String>();

		try {
			if (StringUtil.isNull(paramVO.getSeq())) {
				returnMap.put("code", "999");
				returnMap.put("message", "삭제할 자료를 선택하세요.");
			}
			else {
				paramVO.setRegDt(paramVO.getRegDt().replaceAll("[^0-9]", ""));

				List<String> seqList = new ArrayList<String>(Arrays.asList(paramVO.getSeq().split("\\|")));

				paramVO.setSeqList(seqList);

				recomHofficeDao.deleteRecomHoffice(paramVO);

				returnMap.put("code", "000");
				returnMap.put("message", "정상적으로 삭제되었습니다.");
			}
		} catch (Exception e) {
			logger.error(e);

			returnMap.put("code", "999");
			returnMap.put("message", "삭제 중 오류가 발생하였습니다.");
		}

		resultMap.put("result", returnMap);
		resultMap.put("params", paramVO);

		return new ModelAndView(Constants.JSONVIEW);
	}

	/**
	 * 본사추천 배경이미지 목록 조회
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recomHofficeBGList.do")
	public ModelAndView getRecomHofficeBGList(HttpServletRequest req, HttpServletResponse res, RecomHofficeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		// 기존 선택한 배경이미지
		resultMap.put("imgOrigFileNm", paramVO.getImgOrigFileNm());

		// 배경이미지 목록 조회
		resultMap.put("imgList", recomHofficeDao.getRecomHofficeBGList());

		return new ModelAndView("recom/imgSelect");
	}

	/**
	 * 본사추천 배경이미지 변경 후 결과 리턴
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recomHofficeUpdate.do")
	public ModelAndView updateRecomHoffice(HttpServletRequest req, HttpServletResponse res, RecomHofficeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		Map<String, String> returnMap = new HashMap<String, String>();

		try {
			UserInfoVO userInfo = (UserInfoVO) req.getSession(false).getAttribute(Constants.SESSION_LOGIN_INFO);

			if (userInfo == null) {
				throw new Exception();
			}

			paramVO.setEmpNo(userInfo.getEmpNo());
			paramVO.setRegDt(paramVO.getRegDt().replaceAll("[^0-9]", ""));

			if (updateRecomHoffice(paramVO) == 1) {
				returnMap.put("code", "000");
				returnMap.put("message", "정상적으로 변경되었습니다.");
			}
			else {
				returnMap.put("code", "999");
				returnMap.put("message", "변경 중 오류가 발생하였습니다.");
			}
		} catch (Exception e) {
			logger.error(e);

			returnMap.put("code", "999");
			returnMap.put("message", "변경 중 오류가 발생하였습니다.");
		}

		resultMap.put("result", returnMap);

		return new ModelAndView(Constants.JSONVIEW);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { DataAccessException.class, Exception.class })
	private int updateRecomHoffice(RecomHofficeVO paramVO) throws Exception {
		int result = 0;

		try {
			result = recomHofficeDao.updateRecomHoffice(paramVO);
		} catch (Exception ex) {
			throw new Exception(ex);
		}

		return result;
	}

	/**
	 * 본사추천 배경이미지 리턴
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/recomHofficeImageView.do")
	public byte[] viewRecomHofficeImage(HttpServletRequest req, HttpServletResponse res, RecomHofficeVO paramVO, BindingResult result) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		if (paramVO.getImgSaveFileNm().toLowerCase().endsWith(".png")) {
			res.setContentType(MediaType.IMAGE_PNG_VALUE);
		}
		else if (paramVO.getImgSaveFileNm().toLowerCase().endsWith(".jpeg") || paramVO.getImgSaveFileNm().toLowerCase().endsWith(".jpg")) {
			res.setContentType(MediaType.IMAGE_JPEG_VALUE);
		}

		File file = null;

		if ("Y".equalsIgnoreCase(paramVO.getImgSaveThumb())) {
			file = new File(IMAGE_PATH + paramVO.getImgSavePath() + paramVO.getImgSaveFileNm().replaceAll("(?i)[.](jpeg|jpg|png)$", "_thumb.$1"));

			if (file == null || !file.exists()) {
				file = new File(IMAGE_PATH + paramVO.getImgSavePath() + paramVO.getImgSaveFileNm());
			}
		}
		else {
			file = new File(IMAGE_PATH + paramVO.getImgSavePath() + paramVO.getImgSaveFileNm());
		}

		if (file == null || !file.exists() || !file.isFile()) {
			return null;
		}

		InputStream in = new FileInputStream(file);

		return IOUtils.toByteArray(in);
	}

	/**
	 * 본사추천 등록 화면
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recomHofficeReg.do")
	public ModelAndView initRecomHofficeReg(HttpServletRequest req, HttpServletResponse res, SalePriceBoardVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getRegDt() == null || "".equals(paramVO.getRegDt())) {
			// 등록화면 최초 로딩시

			resultMap.put("pageNo", "0");
			resultMap.put("pageSize", "15");
			resultMap.put("totalCnt", "0");

			// 기준일자는 현재일자로 세팅
			paramVO.setRegDt(DateUtil.getFormatedCurrentDate("yyyy-MM-dd"));

			// 통신사는 SKT를 기본값으로 세팅
			paramVO.setMbcomCd("01");
			paramVO.setMbcomCdNm("SKT");

			// SKT의 판매가격표 최종차수 조회
			paramVO.setMobDgr(recomHofficeDao.getLastMobDgr(paramVO));
		}
		else {
			resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
			resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));
			resultMap.put("totalCnt", String.valueOf(recomHofficeDao.getSalePriceBoardTotCount(paramVO)));

			// 등록화면에서 조회 시
			List<SalePriceBoardVO> list = recomHofficeDao.getSalePriceBoardList(paramVO);

			if (list == null) {
				list = new ArrayList<SalePriceBoardVO>();
			}

			resultMap.put("list", list);
		}

		resultMap.put("params", paramVO);

		return new ModelAndView("recom/inquiry");
	}

	/**
	 * 본사추천 등록 시 통신사별 최종차수
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recomHofficeRegMobDgr.do")
	public ModelAndView getRecomHofficeRegMobDgr(HttpServletRequest req, HttpServletResponse res, SalePriceBoardVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getMbcomCd() == null || "".equals(paramVO.getMbcomCd())) {
			resultMap.put("mobDgr", -1);
		}
		else {
			resultMap.put("mobDgr", recomHofficeDao.getLastMobDgr(paramVO));
		}

		return new ModelAndView(Constants.JSONVIEW);
	}

	/**
	 * 본사추천 등록 처리
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recomHofficeRegProc.do")
	public String processRecomHofficeReg(HttpServletRequest req, HttpServletResponse res, SalePriceBoardMultiVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		try {
			UserInfoVO userInfo = (UserInfoVO) req.getSession(false).getAttribute(Constants.SESSION_LOGIN_INFO);

			if (userInfo == null) {
				throw new Exception();
			}

			// 실제 파일 저장 처리
			processRecomHofficeReg(paramVO, userInfo.getEmpNo());

			return "recom/inquirySuccess";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "recom/inquiryFailure";
		}
	}

	/**
	 * 요청 처리
	 * 
	 * @param paramVO
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { DataAccessException.class, Exception.class })
	private void processRecomHofficeReg(SalePriceBoardMultiVO paramVO, String empNo) throws Exception {
		try {
			for (int i = 0; i < paramVO.getRegDt().length; i++) {
				RecomHofficeVO vo = new RecomHofficeVO();
				vo.setRegDt(paramVO.getRegDt()[i].replaceAll("[^0-9]", ""));
				vo.setMkrPrdCd(paramVO.getMkrPrdCd()[i]);
				vo.setMbComCd(paramVO.getMbcomCd()[i]);
				vo.setStpnCd(paramVO.getClpnCd()[i]);
				vo.setEmpNo(empNo);
				if (!StringUtil.isNull(paramVO.getSalePrc11()[i]) && Integer.parseInt(paramVO.getSalePrc11()[i]) > 0) {
					vo.setMobJnCfCd("11");
					vo.setSalePrc(Integer.parseInt(paramVO.getSalePrc11()[i]));
					if (recomHofficeDao.updateRecomHofficeSalePrc(vo) <= 0) {
						throw new Exception("저장 중 오류가 발생하였습니다.");
					}
				}

				if (!StringUtil.isNull(paramVO.getSalePrc16()[i]) && Integer.parseInt(paramVO.getSalePrc16()[i]) > 0) {
					vo.setMobJnCfCd("16");
					vo.setSalePrc(Integer.parseInt(paramVO.getSalePrc16()[i]));

					if (recomHofficeDao.updateRecomHofficeSalePrc(vo) <= 0) {
						throw new Exception("저장 중 오류가 발생하였습니다.");
					}
				}

				if (!StringUtil.isNull(paramVO.getSalePrc17()[i]) && Integer.parseInt(paramVO.getSalePrc17()[i]) > 0) {
					vo.setMobJnCfCd("17");
					vo.setSalePrc(Integer.parseInt(paramVO.getSalePrc17()[i]));

					if (recomHofficeDao.updateRecomHofficeSalePrc(vo) <= 0) {
						throw new Exception("저장 중 오류가 발생하였습니다.");
					}
				}

				if (!StringUtil.isNull(paramVO.getSalePrc19()[i]) && Integer.parseInt(paramVO.getSalePrc19()[i]) > 0) {
					vo.setMobJnCfCd("19");
					vo.setSalePrc(Integer.parseInt(paramVO.getSalePrc19()[i]));

					if (recomHofficeDao.updateRecomHofficeSalePrc(vo) <= 0) {
						throw new Exception("저장 중 오류가 발생하였습니다.");
					}
				}

				if (!StringUtil.isNull(paramVO.getSalePrc22()[i]) && Integer.parseInt(paramVO.getSalePrc22()[i]) > 0) {
					vo.setMobJnCfCd("22");
					vo.setSalePrc(Integer.parseInt(paramVO.getSalePrc22()[i]));

					if (recomHofficeDao.updateRecomHofficeSalePrc(vo) <= 0) {
						throw new Exception("저장 중 오류가 발생하였습니다.");
					}
				}

				if (!StringUtil.isNull(paramVO.getSalePrc24()[i]) && Integer.parseInt(paramVO.getSalePrc24()[i]) > 0) {
					vo.setMobJnCfCd("24");
					vo.setSalePrc(Integer.parseInt(paramVO.getSalePrc24()[i]));

					if (recomHofficeDao.updateRecomHofficeSalePrc(vo) <= 0) {
						throw new Exception("저장 중 오류가 발생하였습니다.");
					}
				}

				if (!StringUtil.isNull(paramVO.getSalePrc25()[i]) && Integer.parseInt(paramVO.getSalePrc25()[i]) > 0) {
					vo.setMobJnCfCd("25");
					vo.setSalePrc(Integer.parseInt(paramVO.getSalePrc25()[i]));

					if (recomHofficeDao.updateRecomHofficeSalePrc(vo) <= 0) {
						throw new Exception("저장 중 오류가 발생하였습니다.");
					}
				}
			}
		} catch (Exception ex) {
			logger.error(ex);

			throw new Exception(ex);
		}
	}
}
