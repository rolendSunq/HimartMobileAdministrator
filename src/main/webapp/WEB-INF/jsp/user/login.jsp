<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.clear();
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0" />
	<meta name="format-detection" content="telephone=no, email=no, address=no" />
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/style.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/jquery.blockUI.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/common.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/user/login.js"></script>
	<title>HI-MART MOBILE ADMIN</title>
</head>
<body>
    <div id="container">
		<div id="login-page">
			<h1><img src="<%=request.getContextPath()%>/resources/assets/image/logo.gif" alt="HI-MART MOBILE" /></h1>
			<div class="login-box">
				<ul class="input-type">
					<li class="sta">
						<span class="txt"><img src="<%=request.getContextPath()%>/resources/assets/image/member_txt.gif" alt="사원번호" /></span>
						<input type="text" id="empNo" name="empNo" maxlength="7" />
						<span class="icon"><img src="<%=request.getContextPath()%>/resources/assets/image/icon_person.gif" alt="사원번호" /></span>
					</li>
					<li>
						<span class="txt"><img src="<%=request.getContextPath()%>/resources/assets/image/password_txt.gif" alt="비밀번호" /></span>
						<input type="password" id="pwd" name="pwd" maxlength="20" />
						<span class="key"><img src="<%=request.getContextPath()%>/resources/assets/image/icon_key.gif" alt="비밀번호" /></span>
					</li>
				</ul>
				<div class="login-btn"><input type="image" id="btnLogin" src="<%=request.getContextPath()%>/resources/assets/image/login_key.gif" alt="로그인" title="로그인"  /></div>
			</div>
		</div>
    </div>
</body>
</html>