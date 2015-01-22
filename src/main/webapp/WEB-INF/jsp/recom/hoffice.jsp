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
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/jquery-ui.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/jquery.blockUI.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/common.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/recom/hoffice.js"></script>
	<title>HI-MART MOBILE ADMIN</title>
</head>
<body>
	<div id="container">
		<div id="contentWrap">
			<form id="frmRecom" name="frmRecom" action="/recomHoffice.do" method="post">
				<input type="hidden" id="regDt" name="regDt" value="${lastRegDate}" />
				<input type="hidden" id="seq" name="seq" value="" />
				<input type="hidden" id="pageSize" name="pageSize" value="${pageSize}" />
				<input type="hidden" id="pageNo" name="pageNo" value="${pageNo}" />
				<input type="hidden" id="totalCnt" name="totalCnt" value="${totalCnt}" />
				<input type="hidden" id="selTdId" name="selTdId" value="" />
			</form>
			<div class="date-btn">
				<div class="date">
					<strong class="strong">등록일</strong>
					<div class="calendar-search"><input type="text" class="wd201" id="regDtCond" title="등록일" value="${lastRegDate}" readonly="readonly" /><input type="image" id="btnRegDtCond" class="icld" src="<%=request.getContextPath()%>/resources/assets/image/icon_calendar.gif" alt="달력" title="달력" /></div>
				</div>
				<div class="btn">
					<a href="#"><img id="btnLookup" src="<%=request.getContextPath()%>/resources/assets/image/btn_lookup.gif" alt="조회" /></a>
					<a href="#"><img id="btnEnrolment" src="<%=request.getContextPath()%>/resources/assets/image/btn_enrolment.gif" alt="등록" /></a>
					<a href="#"><img id="btnDelete" src="<%=request.getContextPath()%>/resources/assets/image/btn_delete.gif" alt="삭제" /></a>
				</div>
			</div>
			<table summary="본사추천목록" class="board-list">
				<colgroup>
					<col style="width:4%;" />
					<col style="width:6%;" />
					<col style="width:12%;" />
					<col style="width:12%;" />
					<col style="width:8%;" />
					<col style="width:14%;" />
					<col style="width:18%;" />
					<col style="width:8%;" />
					<col style="width:18%;" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col"><input type="checkbox" id="checkAll" /></th>
						<th scope="col">순번</th>
						<th scope="col">등록일</th>
						<th scope="col">타사상품코드</th>
						<th scope="col">통신사</th>
						<th scope="col">가입유형</th>
						<th scope="col">요금제</th>
						<th scope="col">판매가</th>
						<th scope="col">배경이미지</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${fn:length(list) gt 0}">
					<c:forEach items="${list}" var="item">
					<tr data="${item.seq}">
						<td class="txt_ac"><input type="checkbox" name="checkItem" /></td>
						<td class="txt_ac"><fmt:parseNumber value="${item.seq}" var="seqFmt"  type="number"/>${seqFmt}</td>
						<td class="txt_ac"><fmt:parseDate value="${item.regDt}" var="dateFmt" pattern="yyyyMMdd"/><fmt:formatDate value="${dateFmt}" pattern="yyyy-MM-dd" /></td>
						<td class="txt_ac">${item.mkrPrdCd}</td>
						<td class="txt_ac">${item.mbComCdNm}</td>
						<td class="txt_ac">${item.mobJnCfCdNm}</td>
						<td class="txt_ac">${item.stpnCdNm}</td>
						<td class="txt_ar"><fmt:formatNumber value="${item.salePrc}" type="number"/></td>
						<td id="btnChgBG_${item.seq}" class="curPointer txt_ac" onclick="javascript:chgImage(this, '${item.seq}');">
						  <c:choose>
                              <c:when test="${item.imgOrigFileNm == null or item.imgOrigFileNm == ''}">선택</c:when>
                              <c:otherwise>${item.imgOrigFileNm}</c:otherwise>
						  </c:choose>
						</td>
					</tr>
					</c:forEach>
					</c:if>
					<c:if test="${fn:length(list) le 0 and pageNo != '0'}">
					<tr>
						<td colspan="9" class="txt_ac">조회된 자료가 존재하지 않습니다.</td>
					</tr>
					</c:if>
				</tbody>
			</table>
			<page:paging pageSize="${pageSize}" pageNo="${pageNo}" totalCnt="${totalCnt}" pageCnt="10" urlImg="<%=request.getContextPath()%>/resources/assets/image/"></page:paging>
		</div>
	</div>
</body>
</html>