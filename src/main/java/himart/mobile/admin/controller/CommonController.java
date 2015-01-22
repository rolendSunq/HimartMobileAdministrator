package himart.mobile.admin.controller;


import himart.mobile.admin.dao.CommonCodeDao;
import himart.mobile.admin.vo.CommonCodeVO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CommonController {
	private Logger logger = Logger.getLogger(CommonController.class);
 
	@Autowired
	private CommonCodeDao commonCodeDao;

	/**
	 * 품목 검색
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonItemList.do")
	public ModelAndView getCommonItemList(HttpServletRequest req, HttpServletResponse res, CommonCodeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getSchGb() == null || "".equals(paramVO.getSchGb())) {
			paramVO.setSchGb("N");
			paramVO.setSchStr("");
			paramVO.setPageNo(1);
			paramVO.setPageSize(10);
		}

		resultMap.put("schGb", paramVO.getSchGb());
		resultMap.put("schStr", paramVO.getSchStr());
		resultMap.put("allowAll", paramVO.getAllowAll());

		resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
		resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));

		// 총수 조회
		resultMap.put("totalCnt", String.valueOf(commonCodeDao.getItemTotCount(paramVO)));

		// 목록 조회
		if (Integer.parseInt((String) resultMap.get("totalCnt")) <= 0) {
			resultMap.put("list", new ArrayList<CommonCodeVO>());
		}
		else {
			resultMap.put("list", commonCodeDao.getItemList(paramVO));
		}

		return new ModelAndView("common/item");
	}

	/**
	 * 닉네임 검색
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonNicList.do")
	public ModelAndView getCommonNicList(HttpServletRequest req, HttpServletResponse res, CommonCodeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getSchGb() == null || "".equals(paramVO.getSchGb())) {
			paramVO.setSchGb("N");
			paramVO.setSchStr("");
			paramVO.setPageNo(1);
			paramVO.setPageSize(10);
		}

		resultMap.put("schGb", paramVO.getSchGb());
		resultMap.put("schStr", paramVO.getSchStr());
		resultMap.put("schUpCd", paramVO.getSchUpCd());
		resultMap.put("allowAll", paramVO.getAllowAll());

		resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
		resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));

		
		if (paramVO.getSchUpCd() == null || "".equals(paramVO.getSchUpCd())) {
			// 총수 조회
			resultMap.put("totalCnt", 0);
			// 목록 조회
			resultMap.put("list", new ArrayList<CommonCodeVO>());
		}
		else {
			// 총수 조회
			resultMap.put("totalCnt", String.valueOf(commonCodeDao.getNicTotCount(paramVO)));
			// 목록 조회
			if (Integer.parseInt((String) resultMap.get("totalCnt")) <= 0) {
				resultMap.put("list", new ArrayList<CommonCodeVO>());
			}
			else {
				// 목록 조회
				resultMap.put("list", commonCodeDao.getNicList(paramVO));
			}
		}

		return new ModelAndView("common/nic");
	}

	/**
	 * 대표코드 검색
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonMstList.do")
	public ModelAndView getCommonMstList(HttpServletRequest req, HttpServletResponse res, CommonCodeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getSchGb() == null || "".equals(paramVO.getSchGb())) {
			paramVO.setSchGb("N");
			paramVO.setSchStr("");
			paramVO.setPageNo(1);
			paramVO.setPageSize(10);
		}

		resultMap.put("schGb", paramVO.getSchGb());
		resultMap.put("schStr", paramVO.getSchStr());
		resultMap.put("schUpCd", paramVO.getSchUpCd());
		resultMap.put("allowAll", paramVO.getAllowAll());

		resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
		resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));

		if (paramVO.getSchUpCd() == null || "".equals(paramVO.getSchUpCd())) {
			// 총수 조회
			resultMap.put("totalCnt", 0);

			// 목록 조회
			resultMap.put("list", new ArrayList<CommonCodeVO>());
		}
		else {
			// 총수 조회
			resultMap.put("totalCnt", String.valueOf(commonCodeDao.getMstTotCount(paramVO)));

			// 목록 조회
			if (Integer.parseInt((String) resultMap.get("totalCnt")) <= 0) {
				resultMap.put("list", new ArrayList<CommonCodeVO>());
			}
			else {
				resultMap.put("list", commonCodeDao.getMstList(paramVO));
			}
		}

		return new ModelAndView("common/mst");
	}

	/**
	 * 액세서리 검색
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonAccList.do")
	public ModelAndView getCommonAccList(HttpServletRequest req, HttpServletResponse res, CommonCodeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getSchGb() == null || "".equals(paramVO.getSchGb())) {
			paramVO.setSchGb("N");
			paramVO.setSchStr("");
			paramVO.setPageNo(1);
			paramVO.setPageSize(10);
		}

		resultMap.put("schGb", paramVO.getSchGb());
		resultMap.put("schStr", paramVO.getSchStr());
		resultMap.put("schUpCd", paramVO.getSchUpCd());
		resultMap.put("allowAll", paramVO.getAllowAll());

		resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
		resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));

		if (paramVO.getSchUpCd() == null || "".equals(paramVO.getSchUpCd())) {
			// 총수 조회
			resultMap.put("totalCnt", 0);

			// 목록 조회
			resultMap.put("list", new ArrayList<CommonCodeVO>());
		}
		else {
			// 총수 조회
			resultMap.put("totalCnt", String.valueOf(commonCodeDao.getAccTotCount(paramVO)));

			// 목록 조회
			if (Integer.parseInt((String) resultMap.get("totalCnt")) <= 0) {
				resultMap.put("list", new ArrayList<CommonCodeVO>());
			}
			else {
				resultMap.put("list", commonCodeDao.getAccList(paramVO));
			}
		}

		return new ModelAndView("common/acc");
	}

	//카드할인 리스트 생성.
	public List<CommonCodeVO> createCardList(int cnt) {
		
		List<CommonCodeVO> lst = new ArrayList<CommonCodeVO>();
		
		String sCd = "C00";
		String sCd1 = "C0";
		String sNm = "이미지#";
		
		for (int i=1; i <= cnt; i++){
			
			CommonCodeVO cmCd = new CommonCodeVO();
			
			cmCd.setSeq(i);
			if(i < 10){
				cmCd.setItemCd1(sCd+Integer.toString(i));
				cmCd.setItemCd2(sCd+Integer.toString(i));
			}else{
				cmCd.setItemCd1(sCd1+Integer.toString(i));
				cmCd.setItemCd2(sCd1+Integer.toString(i));
			}
		
			cmCd.setItemNm1(sNm + Integer.toString(i));
			cmCd.setItemNm2(sNm + Integer.toString(i));
			
			lst.add(cmCd);
			
			cmCd = null;
		}	
		return lst;
	}
	
	//카드할인 리스트 생성.
	public List<CommonCodeVO> createInsList(int cnt) {
		
		List<CommonCodeVO> lst = new ArrayList<CommonCodeVO>();
		
		String sCd1 = "S001";
		String sCd2 = "K001";
		String sCd3 = "L001";
		String sCd4 = "C001";
		String sCd5 = "D001";
		String sCd6 = "T001";
		
		String sNm1 = "SKT 보험상품";
		String sNm2 = "KT 보험상품";
		String sNm3 = "LGU 보험상품";
		String sNm4 = "CJ헬로비전 보험상품";
		String sNm5 = "D에스원 보험상품";
		String sNm6 = "KCT 보험상품";
		
		for (int i=1; i <= cnt; i++){
			CommonCodeVO cmCd = new CommonCodeVO();
			
			switch(i)
			{
			case 1:
				cmCd.setSeq(i);
				cmCd.setItemCd1(sCd1);
				cmCd.setItemCd2(sCd1);
				cmCd.setItemNm1(sNm1);
				cmCd.setItemNm2(sNm1);
			  break;
			case 2:
				cmCd.setSeq(i);
				cmCd.setItemCd1(sCd2);
				cmCd.setItemCd2(sCd2);
				cmCd.setItemNm1(sNm2);
				cmCd.setItemNm2(sNm2);
			  break;
			case 3:
				cmCd.setSeq(i);
				cmCd.setItemCd1(sCd3);
				cmCd.setItemCd2(sCd3);
				cmCd.setItemNm1(sNm3);
				cmCd.setItemNm2(sNm3);
			  break;
			case 4:
				cmCd.setSeq(i);
				cmCd.setItemCd1(sCd4);
				cmCd.setItemCd2(sCd4);
				cmCd.setItemNm1(sNm4);
				cmCd.setItemNm2(sNm4);
			  break;
			case 5:
				cmCd.setSeq(i);
				cmCd.setItemCd1(sCd5);
				cmCd.setItemCd2(sCd5);
				cmCd.setItemNm1(sNm5);
				cmCd.setItemNm2(sNm5);
			  break;
			case 6:
				cmCd.setSeq(i);
				cmCd.setItemCd1(sCd6);
				cmCd.setItemCd2(sCd6);
				cmCd.setItemNm1(sNm6);
				cmCd.setItemNm2(sNm6);
			  break;
			default:
			  
			}
 
			lst.add(cmCd);
			
			cmCd = null;
		}	
		return lst;
	}
	/**
	 * 카드할인 검색
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonCardList.do")
	public ModelAndView getCommonCardList(HttpServletRequest req, HttpServletResponse res, CommonCodeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getSchGb() == null || "".equals(paramVO.getSchGb())) {
			paramVO.setSchGb("N");
			paramVO.setSchStr("");
			paramVO.setPageNo(1);
			paramVO.setPageSize(10);
		}

		resultMap.put("schGb", paramVO.getSchGb());
		resultMap.put("schStr", paramVO.getSchStr());
		resultMap.put("allowAll", paramVO.getAllowAll());
		resultMap.put("cardGb", paramVO.getCardGb());

		resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
		resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));
		
		System.out.println("paramVO.getCardGb()====="+paramVO.getCardGb());
		if("Y".equals(paramVO.getCardGb())){
			//카드할인
			resultMap.put("totalCnt",10);
			resultMap.put("list", createCardList(10));
		} else if("B".equals(paramVO.getCardGb())){
			//보험상품
			resultMap.put("totalCnt",10);
			resultMap.put("list", createInsList(6));
		}
		else{
			// 총수 조회
			resultMap.put("totalCnt", String.valueOf(commonCodeDao.getCardTotCount(paramVO)));

			// 목록 조회
			if (Integer.parseInt((String) resultMap.get("totalCnt")) <= 0) {
				resultMap.put("list", new ArrayList<CommonCodeVO>());
			}
			else {
				resultMap.put("list", commonCodeDao.getCardList(paramVO));
			}
		}

		return new ModelAndView("common/card");
	}

	/**
	 * 이미지구분 검색
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonImgGbList.do")
	public ModelAndView getCommonImgGbList(HttpServletRequest req, HttpServletResponse res, CommonCodeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getSchGb() == null || "".equals(paramVO.getSchGb())) {
			paramVO.setSchGb("N");
			paramVO.setSchStr("");
			paramVO.setPageNo(1);
			paramVO.setPageSize(10);
		}

		resultMap.put("schGb", paramVO.getSchGb());
		resultMap.put("schStr", paramVO.getSchStr());
		resultMap.put("allowAll", paramVO.getAllowAll());

		resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
		resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));

		// 총수 조회
		resultMap.put("totalCnt", String.valueOf(commonCodeDao.getImgGbTotCount(paramVO)));

		// 목록 조회
		if (Integer.parseInt((String) resultMap.get("totalCnt")) <= 0) {
			resultMap.put("list", new ArrayList<CommonCodeVO>());
		}
		else {
			resultMap.put("list", commonCodeDao.getImgGbList(paramVO));
		}

		return new ModelAndView("common/imgGb");
	}

	/**
	 * 통신사 검색
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonMbcomList.do")
	public ModelAndView getCommonMbcomList(HttpServletRequest req, HttpServletResponse res, CommonCodeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getSchGb() == null || "".equals(paramVO.getSchGb())) {
			paramVO.setSchGb("N");
			paramVO.setSchStr("");
			paramVO.setPageNo(1);
			paramVO.setPageSize(10);
		}

		resultMap.put("schGb", paramVO.getSchGb());
		resultMap.put("schStr", paramVO.getSchStr());
		resultMap.put("allowAll", paramVO.getAllowAll());

		resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
		resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));

		// 총수 조회
		resultMap.put("totalCnt", String.valueOf(commonCodeDao.getMbcomTotCount(paramVO)));

		// 목록 조회
		if (Integer.parseInt((String) resultMap.get("totalCnt")) <= 0) {
			resultMap.put("list", new ArrayList<CommonCodeVO>());
		}
		else {
			resultMap.put("list", commonCodeDao.getMbcomList(paramVO));
		}

		return new ModelAndView("common/mbcom");
	}

	/**
	 * 제조사 검색
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonMkrList.do")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { DataAccessException.class, Exception.class })
	public ModelAndView getCommonMkrList(HttpServletRequest req, HttpServletResponse res, CommonCodeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getSchGb() == null || "".equals(paramVO.getSchGb())) {
			paramVO.setSchGb("N");
			paramVO.setSchStr("");
			paramVO.setPageNo(1);
			paramVO.setPageSize(10);
		}

		resultMap.put("schGb", paramVO.getSchGb());
		resultMap.put("schStr", paramVO.getSchStr());
		resultMap.put("allowAll", paramVO.getAllowAll());

		resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
		resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));

		// 총수 조회
		resultMap.put("totalCnt", String.valueOf(commonCodeDao.getMkrTotCount(paramVO)));

		// 목록 조회
		if (Integer.parseInt((String) resultMap.get("totalCnt")) <= 0) {
			resultMap.put("list", new ArrayList<CommonCodeVO>());
		}
		else {
			resultMap.put("list", commonCodeDao.getMkrList(paramVO));
		}

		return new ModelAndView("common/mkr");
	}

	/**
	 * 모델코드 검색
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonPrdCdList.do")
	public ModelAndView getCommonPrdCdList(HttpServletRequest req, HttpServletResponse res, CommonCodeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getSchGb() == null || "".equals(paramVO.getSchGb())) {
			paramVO.setSchGb("N");
			paramVO.setSchStr("");
			paramVO.setPageNo(1);
			paramVO.setPageSize(10);
		}

		resultMap.put("schGb", paramVO.getSchGb());
		resultMap.put("schStr", paramVO.getSchStr());
		resultMap.put("schUpCd", paramVO.getSchUpCd());
		resultMap.put("allowAll", paramVO.getAllowAll());

		resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
		resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));

		// 총수 조회
		resultMap.put("totalCnt", String.valueOf(commonCodeDao.getPrdCdTotCount(paramVO)));

		// 목록 조회
		if (Integer.parseInt((String) resultMap.get("totalCnt")) <= 0) {
			resultMap.put("list", new ArrayList<CommonCodeVO>());
		}
		else {
			resultMap.put("list", commonCodeDao.getPrdCdList(paramVO));
		}

		return new ModelAndView("common/prdCd");
	}

	/**
	 * 지점 검색
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonBrchList.do")
	public ModelAndView getCommonBrchList(HttpServletRequest req, HttpServletResponse res, CommonCodeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getSchGb() == null || "".equals(paramVO.getSchGb())) {
			paramVO.setSchGb("N");
			paramVO.setSchStr("");
			paramVO.setPageNo(1);
			paramVO.setPageSize(10);
		}

		resultMap.put("schGb", paramVO.getSchGb());
		resultMap.put("schStr", paramVO.getSchStr());
		resultMap.put("allowAll", paramVO.getAllowAll());

		resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
		resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));

		// 총수 조회
		resultMap.put("totalCnt", String.valueOf(commonCodeDao.getBrchTotCount(paramVO)));

		// 목록 조회
		if (Integer.parseInt((String) resultMap.get("totalCnt")) <= 0) {
			resultMap.put("list", new ArrayList<CommonCodeVO>());
		}
		else {
			resultMap.put("list", commonCodeDao.getBrchList(paramVO));
		}

		return new ModelAndView("common/brch");
	}

	/**
	 * 권유자 검색
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonIvtmnList.do")
	public ModelAndView getCommonIvtmnList(HttpServletRequest req, HttpServletResponse res, CommonCodeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getSchGb() == null || "".equals(paramVO.getSchGb())) {
			paramVO.setSchGb("N");
			paramVO.setSchStr("");
			paramVO.setPageNo(1);
			paramVO.setPageSize(10);
		}

		resultMap.put("schGb", paramVO.getSchGb());
		resultMap.put("schStr", paramVO.getSchStr());
		resultMap.put("schUpCd", paramVO.getSchUpCd());
		resultMap.put("allowAll", paramVO.getAllowAll());

		resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
		resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));

		// 총수 조회
		resultMap.put("totalCnt", String.valueOf(commonCodeDao.getEmpTotCount(paramVO)));

		// 목록 조회
		if (Integer.parseInt((String) resultMap.get("totalCnt")) <= 0) {
			resultMap.put("list", new ArrayList<CommonCodeVO>());
		}
		else {
			resultMap.put("list", commonCodeDao.getEmpList(paramVO));
		}

		return new ModelAndView("common/ivtmn");
	}
	
	/**
	 * 코드, 코드명 검색
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commonCodeList.do")
	public ModelAndView getCommonCodeList(HttpServletRequest req, HttpServletResponse res, CommonCodeVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		if (paramVO.getSchGb() == null || "".equals(paramVO.getSchGb())) {
			paramVO.setSchGb("N");
			paramVO.setSchStr("");
			paramVO.setPageNo(1);
			paramVO.setPageSize(10);
		}

		resultMap.put("schGb", paramVO.getSchGb());
		resultMap.put("schStr", paramVO.getSchStr());
		resultMap.put("schUpCd", paramVO.getSchUpCd());
		resultMap.put("allowAll", paramVO.getAllowAll());

		resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
		resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));


			if (paramVO.getSchUpCd() == null || "".equals(paramVO.getSchUpCd())) {
				// 총수 조회
				resultMap.put("totalCnt", 0);
				// 목록 조회
				resultMap.put("list", new ArrayList<CommonCodeVO>());
			}
			else {
				// 총수 조회
				resultMap.put("totalCnt", String.valueOf(commonCodeDao.getCodeTotCount(paramVO)));
				// 목록 조회
				if (Integer.parseInt((String) resultMap.get("totalCnt")) <= 0) {
					resultMap.put("list", new ArrayList<CommonCodeVO>());
				}
				else {
					// 목록 조회
					resultMap.put("list", commonCodeDao.getCodeList(paramVO));
				}
			}

		return new ModelAndView("common/title");
	}
	
}
