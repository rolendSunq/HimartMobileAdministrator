package himart.mobile.admin.controller;


import himart.mobile.admin.dao.LogCounselDao;
import himart.mobile.admin.util.DateUtil;
import himart.mobile.admin.vo.LogCounselVO;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LogController {
	private Logger logger = Logger.getLogger(LogController.class);

	@Autowired
	private LogCounselDao logCounselDao;

	/**
	 * 상담로그 목록화면
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logCounsel.do")
	public ModelAndView initLogCounsel(HttpServletRequest req, HttpServletResponse res, LogCounselVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		// 상담로그 목록 조회
		resultMap.put("list", new ArrayList<LogCounselVO>());

		if (paramVO.getCnslDtFrom() == null || "".equals(paramVO.getCnslDtFrom()) || paramVO.getCnslDtTo() == null || "".equals(paramVO.getCnslDtTo())) {
			resultMap.put("pageNo", "0");
			resultMap.put("pageSize", "10");
			resultMap.put("totalCnt", "0");

			// 상담일자 기본값
			paramVO.setCnslDtFrom(DateUtil.getFormatedDate(DateUtil.getPreviousDate(new Date(), 30), "yyyy-MM-dd"));
			paramVO.setCnslDtTo(DateUtil.getFormatedDate(new Date(), "yyyy-MM-dd"));
		}
		else {
			paramVO.setCnslDtFrom(paramVO.getCnslDtFrom().replaceAll("[^0-9]", ""));
			paramVO.setCnslDtTo(paramVO.getCnslDtTo().replaceAll("[^0-9]", ""));

			// 상담로그 총건수 조회
			resultMap.put("pageNo", String.valueOf(paramVO.getPageNo()));
			resultMap.put("pageSize", String.valueOf(paramVO.getPageSize()));
			resultMap.put("totalCnt", String.valueOf(logCounselDao.getLogCounselTotCount(paramVO)));

			// 상담로그 목록 조회
			if (Integer.parseInt((String) resultMap.get("totalCnt")) > 0) {
				resultMap.put("list", logCounselDao.getLogCounselViewList(paramVO));
			}

			paramVO.setCnslDtFrom(paramVO.getCnslDtFrom().replaceAll("([0-9]{4})([0-9]{2})([0-9]{2})", "$1-$2-$3"));
			paramVO.setCnslDtTo(paramVO.getCnslDtTo().replaceAll("([0-9]{4})([0-9]{2})([0-9]{2})", "$1-$2-$3"));
		}

		resultMap.put("params", paramVO);

		return new ModelAndView("log/counsel");
	}

	/**
	 * 상담로그 목록화면
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logCounselExcel.do")
	public ModelAndView downloadLogCounselExcel(HttpServletRequest req, HttpServletResponse res, LogCounselVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		paramVO.setCnslDtFrom(paramVO.getCnslDtFrom().replaceAll("[^0-9]", ""));
		paramVO.setCnslDtTo(paramVO.getCnslDtTo().replaceAll("[^0-9]", ""));

		resultMap.put("list", logCounselDao.getLogCounselExcelList(paramVO));

		resultMap.put("target", "counsel");

		resultMap.put("fileName", "상담로그_" + paramVO.getCnslDtFrom() + "-" + paramVO.getCnslDtTo());

		return new ModelAndView("excelDownloadView");
	}
}
