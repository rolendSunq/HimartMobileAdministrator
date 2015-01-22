<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/main/main.js"></script>
	<title>HI-MART MOBILE ADMIN</title>
</head>
<body>
	<div id="container">
		<div id="headerWrap">
			<h1><img src="<%=request.getContextPath()%>/resources/assets/image/logo.gif" alt="HI-MART MOBILE" /></h1>
			<div class="log-menu">
				<div class="log">
					<div class="log-btn"><img class="curPointer" onclick="javascript:logout();" src="<%=request.getContextPath()%>/resources/assets/image/btn_logout.gif" alt="logout" /></div>
					<p class="log-txt"><strong>${userInfo.empKname}</strong>님 방문을 환영합니다.</p>					
				</div>
				<ul class="menu">
					<li><img id="btnRecomHoffice" onclick="javascript:moveRecomHoffice();" src="<%=request.getContextPath()%>/resources/assets/image/btn_hq_on.png" alt="본사추천" /></li>
					<li><img id="btnImageUpload" class="curPointer" onclick="javascript:moveImageUpload();" src="<%=request.getContextPath()%>/resources/assets/image/btn_img.png" alt="이미지" /></li>
					<li><img id="btnLogCounsel" class="curPointer" onclick="javascript:moveLogCounsel();" src="<%=request.getContextPath()%>/resources/assets/image/btn_counsel.png" alt="상담로그" /></li>
					<li><img id="btnThumbnailUpload" class="curPointer" onclick="javascript:moveThumbnailUpload();" src="<%=request.getContextPath()%>/resources/assets/image/btn_thumbnail.png" alt="섬네일" /></li>
				</ul>
			</div>
		</div>
		<div id="frameWrap">
		  <iframe id="contentArea" name="contentArea" src="/recomHoffice.do" frameborder="0" />
        </div>
	</div>
</body>
</html>