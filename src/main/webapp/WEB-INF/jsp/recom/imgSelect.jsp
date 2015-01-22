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
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/recom/imgSelect.js"></script>
	<title>HI-MART MOBILE ADMIN</title>
</head>
<body>
	<div id="container">
		<div id="contentWrap">
			<form id="frmRecomImage" name="frmRecomImage" action="/recomHofficeUpdate.do" method="post">
				<input type="hidden" id="regDt" name="regDt" value="${regDt}" />
				<input type="hidden" id="seq" name="seq" value="${seq}" />
			</form>
			<table summary="" class="board-list">
				<colgroup>
					<col style="width:20%;" />
					<col style="width:20%;" />
					<col style="width:20%;" />
					<col style="width:20%;" />
					<col style="width:20%;" />
				</colgroup>
				<tbody>
					<c:set var="selected" scope="request" value=""/>
					<c:forEach items="${imgList}" var="item">
						<td class="txt_ac">
						<c:choose>
							<c:when test="${item.imgOrigFileNm eq imgOrigFileNm}">
								<img class="bg_preview selected" src="/recomHofficeImageView.do?imgSaveFileNm=${item.imgSaveFileNm}&imgSavePath=${item.imgSavePath}&imgSaveThumb=Y" data="${item.imgOrigFileNm}|${item.imgSaveFileNm}|${item.imgSavePath}"/> 
							</c:when>
							<c:otherwise>
								<img class="bg_preview" src="/recomHofficeImageView.do?imgSaveFileNm=${item.imgSaveFileNm}&imgSavePath=${item.imgSavePath}&imgSaveThumb=Y" data="${item.imgOrigFileNm}|${item.imgSaveFileNm}|${item.imgSavePath}" /> 
							</c:otherwise>
						</c:choose>
						</td>
					</c:forEach>
				</tbody>
			</table>
			<div class="btn-right"><a href="#" onclick="javascript:saveImage();"><img src="<%=request.getContextPath()%>/resources/assets/image/btn_save.gif" alt="저장" /></a></div>
		</div>
	</div>
</body>
</html>