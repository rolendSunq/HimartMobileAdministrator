<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="page" uri="taglib" %>
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/common/pop-up.js"></script>
	<title>HI-MART MOBILE ADMIN</title>
</head>
<body>
	<div id="container">
		<div id="contentWrap">
			<form id="frmCommon" name="frmCommon" action="/commonMbcomList.do" method="post">
				<input type="hidden" id="schGb" name="schGb" value="${schGb}" />
				<input type="hidden" id="schStr" name="schStr" value="${schStr}" />
				<input type="hidden" id="allowAll" name="allowAll" value="${allowAll}" />
				<input type="hidden" id="pageSize" name="pageSize" value="${pageSize}" />
				<input type="hidden" id="pageNo" name="pageNo" value="${pageNo}" />
				<input type="hidden" id="totalCnt" name="totalCnt" value="${totalCnt}" />
			</form>
			<div class="date-btn">
				<div class="date">
					<strong class="strong">검색구분</strong>
					<div class="calendar-search2">
						<input type="radio" class="radio" id="schGb1" name="schGbCond" value="C" title="코드"  /><label for="schGb1">코드</label>
						<input type="radio" class="radio" id="schGb2" name="schGbCond" value="N" title="통신사" /><label for="schGb2">통신사</label>
					</div>
					<strong class="strong">검색어</strong>
					<div class="calendar-search">
						<input type="text" class="wd201" id="schStrCond" name="schStrCond" title="검색어" />
					</div>
				</div>
				<div class="btn">
					<a href="#"><img id="btnLookup" src="<%=request.getContextPath()%>/resources/assets/image/btn_lookup.gif" alt="조회" /></a>
				</div>
			</div>
			<table summary="통신사 검색" class="board-list">
				<colgroup>
					<col style="width:10%" />
					<col style="width:30%" />
					<col style="width:60%" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col">순번</th>
						<th scope="col">코드</th>
						<th scope="col">통신사</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${fn:length(list) gt 0}">
					<c:forEach items="${list}" var="mbcom">
					<tr class="curPointer" onclick="javascript:choiceCode(this);" data="${mbcom.itemCd1}|${mbcom.itemNm1}">
						<td class="txt_ac"><fmt:parseNumber value="${mbcom.seq}" var="seqFmt"  type="number"/>${seqFmt}</td>
						<td class="txt_ac">${mbcom.itemCd2}</td>
						<td class="txt_ac">${mbcom.itemNm2}</td>
					</tr>
					</c:forEach>
					</c:if>
					<c:if test="${fn:length(list) le 0}">
					<tr>
						<td colspan="4" class="txt_ac">조회된 자료가 존재하지 않습니다.</td>
					</tr>
					</c:if>
				</tbody>
			</table>
			<page:paging pageSize="${pageSize}" pageNo="${pageNo}" totalCnt="${totalCnt}" pageCnt="5" urlImg="${pageContext.request.contextPath}/resources/assets/image/"></page:paging>
		</div>
	</div>
</body>
</html>