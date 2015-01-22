package himart.mobile.admin.common.interceptor;


import himart.mobile.admin.common.Constants;
import himart.mobile.admin.vo.UserInfoVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SessionCheckInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 로그인 세션체크 예외 주소 처리
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		String requestURI = req.getRequestURI();

		if (requestURI.startsWith("/user")) {
			// 세션체크 예외페이지 (로그인화면/로그인처리/로그아웃처리)
			return true;
		}
		else {
			// 위의 예외페이지 외에는 세션값을 체크해서 있으면 그냥 페이지표시
			HttpSession session = req.getSession(false);

			if (session != null) {
				UserInfoVO userInfo = (UserInfoVO) session.getAttribute(Constants.SESSION_LOGIN_INFO);

				if (userInfo != null) {
					return true;
				}
			}
		}

		// 정상적인 세션정보가 없으면 로그인화면으로 이동
		req.getRequestDispatcher(/*req.getContextPath() + */"/userLogin.do").forward(req, res);

		return false;
	}
}
