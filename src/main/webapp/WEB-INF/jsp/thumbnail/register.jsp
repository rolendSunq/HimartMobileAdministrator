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
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/thumbnail/register.js"></script>
	<title>HI-MART MOBILE ADMIN</title>
</head>
<body>
	<div id="container">
		<div id="contentWrap">
			<input type="hidden" id="callbackPopup" name="callbackPopup" value="" />
			<div class="date-btn">
				<div class="date">
					<strong class="strong">프로모션 구분</strong>
					<div class="calendar-search2">
						<input type="radio" class="radio" id="imgCf1" name="imgCf" title="본사" value="5" checked="checked" /><label for="imgCf1">본사</label>
						<input type="radio" class="radio" id="imgCf2" name="imgCf" title="지점" value="6" /><label for="imgCf2">지점</label>
						<input type="radio" class="radio" id="imgCf3" name="imgCf" title="배경이미지" value="7" /><label for="imgCf3">배경이미지</label>
						<input type="radio" class="radio" id="imgCf4" name="imgCf" title="타이틀" value="8" /><label for="imgCf4">타이틀</label>
					</div>
				</div>
				<div class="btn">
					<a href="#"><img id="btnAdd" src="<%=request.getContextPath()%>/resources/assets/image/btn_add.gif" alt="추가" /></a>
				</div>
			</div>
			<form id="frmImage" name="frmImage" action="/thumbnailUploadRegProc.do" method="post" enctype="multipart/form-data" target="frameProc">
				<table summary="이미지등록" class="board-img">
					<colgroup>
						<col style="width:4%;" />
						<col style="width:12%;" />
						<col style="width:23%;" />
						<col style="width:15%;" />
						<col style="width:20%;" />
						<col style="width:26%;" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col" id="tdTitleGb">구분</th>
							<th scope="col"  id="tdTitleNic">코드</th>
							<th scope="col" id="tdTitleAcc">코드명</th>
							<th scope="col">순번</th>
							<th scope="col">파일명</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<input type="submit" name="submitReg" value="Click!" class="submit_hidden"/>
			</form>
			<iframe id="frameProc" name="frameProc" class="proc_hidden"></iframe>
			<div class="btn-right"><a href="#"><img id="btnSave" src="<%=request.getContextPath()%>/resources/assets/image/btn_save.gif" alt="저장" /></a></div>
		</div>
	</div>
</body>
</html>