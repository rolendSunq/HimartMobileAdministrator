package himart.mobile.admin.controller;


import himart.mobile.admin.common.Constants;
import himart.mobile.admin.vo.UserInfoVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	private Logger logger = Logger.getLogger(MainController.class);
	/**
	 * 메인화면
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	
	/*
	 * test rolend 14-12-22
	 */
	@RequestMapping(value = "/main.do")
	public ModelAndView initMain(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("hi");
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		UserInfoVO userInfoVO = null;

		if (req.getSession(false) != null) {
			userInfoVO = (UserInfoVO) req.getSession(false).getAttribute(Constants.SESSION_LOGIN_INFO);
		}
		else {
			userInfoVO = new UserInfoVO();
		}

		return new ModelAndView("main/main", "userInfo", userInfoVO);
	}

	/**
	 * 세션유지를 위해 주기적으로 호출되는 서비스
	 * @param req
	 * @param res
	 * @throws Exception
	 */
	@RequestMapping(value = "/mainKeepSessionProc.do")
	public ModelAndView processKeepSession(HttpServletRequest req, HttpServletResponse res, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		resultMap.put("empNo", "");

		// 이미 로그인을 했을 경우에는 로그인화면이 아닌 초기화면으로 이동
		if (req.getSession(false) != null) {
			UserInfoVO userInfo = (UserInfoVO) req.getSession(false).getAttribute(Constants.SESSION_LOGIN_INFO);

			if (userInfo != null) {
				resultMap.put("empNo", userInfo.getEmpNo());
			}
		}

		return new ModelAndView(Constants.JSONVIEW);
	}
}
