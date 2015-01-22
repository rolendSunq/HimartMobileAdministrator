package himart.mobile.admin.controller;


import himart.mobile.admin.common.Constants;
import himart.mobile.admin.dao.UserInfoDao;
import himart.mobile.admin.util.StringUtil;
import himart.mobile.admin.vo.UserInfoVO;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	private Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserInfoDao userInfoDao;

	/**
	 * 초기 접속 등으로 로그인 화면으로 이동
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userLogin.do")
	public String initLogin(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");
		String returnPage = "user/login";

		// 이미 로그인을 했을 경우에는 로그인화면이 아닌 초기화면으로 이동
		if (req.getSession(false) != null) {
			UserInfoVO userInfo = (UserInfoVO) req.getSession(false).getAttribute(Constants.SESSION_LOGIN_INFO);

			if (userInfo != null) {
				returnPage = "forward:/main.do";
			}
		}

		return returnPage;
	}

	/**
	 * 로그인 처리 후 결과 리턴
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userLoginProc.do")
	public ModelAndView processLogin(HttpServletRequest req, HttpServletResponse res, UserInfoVO paramVO, BindingResult result, ModelMap resultMap) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		resultMap.clear();

		Map<String, String> returnMap = new HashMap<String, String>();

		try {
			// 사원번호 입력여부 체크
			if (StringUtil.isNull(paramVO.getEmpNo())) {
				returnMap.put("code", "999");
				returnMap.put("message", "사원번호를 입력하세요.");
			}
			// 비밀번호 입력여부 체크
			else if (StringUtil.isNull(paramVO.getPwd())) {
				returnMap.put("code", "999");
				returnMap.put("message", "비밀번호를 입력하세요.");
			}
			else {
				// 입력된 값으로 사원정보 조회
				UserInfoVO userInfoVO = userInfoDao.getUserInfo(paramVO);

				if (userInfoVO == null) {
					returnMap.put("code", "999");
					returnMap.put("message", "등록되지 않은 사원번호입니다.");
				}
				else if ("N".equals(userInfoVO.getValidPwd())) {
					returnMap.put("code", "999");
					returnMap.put("message", "올바르지 않은 비밀번호입니다.");
				}
				else {
					// 세션에 사용자 정보 보관
					req.getSession().setAttribute(Constants.SESSION_LOGIN_INFO, userInfoVO);

					returnMap.put("code", "000");
					returnMap.put("message", "로그인이 성공하였습니다.");
				}
			}
		} catch (Exception e) {
			logger.error(e);

			returnMap.put("code", "999");
			returnMap.put("message", "로그인 중 오류가 발생하였습니다.");
		}

		resultMap.put("result", returnMap);

		return new ModelAndView(Constants.JSONVIEW);
	}

	/**
	 * 로그아웃 처리 후 로그인 화면으로 이동
	 * @param req
	 * @param res
	 * @throws Exception
	 */
	@RequestMapping(value = "/userLogoutProc.do")
	public void processLogout(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.debug("==> PAGE [" + req.getRequestURI() + "]");

		HttpSession _session = req.getSession(false);

		if (_session != null) {
			_session.invalidate();
		}

		req.getRequestDispatcher(req.getContextPath() + "/userLogin.do").forward(req, res);
	}
}
