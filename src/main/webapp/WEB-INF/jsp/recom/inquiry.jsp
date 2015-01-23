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
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/recom/inquiry.js"></script>
	<title>HI-MART MOBILE ADMIN</title>
</head>
<body>
	<div id="container">
		<div id="contentWrap">
			<form id="frmSearch" name="frmSearch" action="/recomHofficeReg.do" method="post">
				<input type="hidden" id="pageSize" name="pageSize" value="${pageSize}" />
				<input type="hidden" id="pageNo" name="pageNo" value="${pageNo}" />
				<input type="hidden" id="totalCnt" name="totalCnt" value="${totalCnt}" />
				<div class="date-btn">
					<div class="date">
						<strong class="strong">기준일자</strong>
						<div class="calendar-search">
							<input type="text" class="wd201 txt_ac" id="regDt" name="regDt" value="${params.regDt}" title="기준일자" readonly="readonly"/>
						</div>
						<strong class="strong2">통신사</strong>
						<div class="calendar-search">
							<input type="hidden" name="mbcomCd" value="${params.mbcomCd}" /><input type="text" class="wd201" id="mbcomCdNm" name="mbcomCdNm" value="${params.mbcomCdNm}" title="통신사" readonly="readonly"/><input type="image" class="icld" src="<%=request.getContextPath()%>/resources/assets/image/btn_search.gif" onclick="javascript:popupMbcom(); return false;" alt="찾기" title="찾기" />
						</div>
						<strong class="strong2">차수</strong>
						<div class="calendar-search">
							<input type="text" class="wd201 txt_ac" id="mobDgr" name="mobDgr" value="${params.mobDgr}" title="차수" readonly="readonly" />
						</div>
					</div>
					<div class="btn">
						<a href="#"><img id="btnLookup" src="<%=request.getContextPath()%>/resources/assets/image/btn_lookup.gif" alt="조회" /></a>
					</div>
				</div>
			</form>
			<form id="frmSave" name="frmSave" action="/recomHofficeRegProc.do" method="post" target="frameProc">
				<table summary="" class="board-list">
					<colgroup>
						<col style="width:12%;" />
						<col style="width:12%;" />
						<col style="width:8%;" />
						<col style="width:8%;" />
						<col style="width:12%;" />
						<col style="width:8%;" />
						<col style="width:8%;" />
						<col style="width:8%;" />
						<col style="width:8%;" />
						<col style="width:8%;" />
						<col style="width:8%;" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">닉네임</th>
							<th scope="col">모델명</th>
							<th scope="col">출고가</th>
							<th scope="col">통신사</th>
							<th scope="col">상위요금제</th>
							<c:choose>
							<c:when test="${params.mbcomCd == '01'}">
							<th scope="col" title="11">010신규</th>
							<th scope="col" title="24">AMNP신규</th>
							<th scope="col" title="17">일반기변</th>
							<th scope="col" title="16">보상기변</th>
							<th scope="col" title="19">우수기변1</th>
							<th scope="col" title="22">우수기변2</th>
							</c:when>
							<c:when test="${params.mbcomCd == '02'}">
							<th scope="col" title="11">010신규</th>
							<th scope="col" title="24">AMNP신규</th>
							<th scope="col" title="25">BMNP신규</th>
							<th scope="col" title="16">보상기변</th>
							<th scope="col" title="19">우수기변1</th>
							<th scope="col" title="22">우수기변2</th>
							</c:when>
							<c:when test="${params.mbcomCd == '03'}">
							<th scope="col" title="11">010신규</th>
							<th scope="col" title="25">BMNP신규</th>
							<th scope="col" title="16">보상기변</th>
							<th scope="col">&nbsp;</th>
							<th scope="col">&nbsp;</th>
							<th scope="col">&nbsp;</th>
							</c:when>
							<c:when test="${params.mbcomCd == '04'}">
							<th scope="col" title="11">010신규</th>
							<th scope="col" title="24">AMNP신규</th>
							<th scope="col" title="25">BMNP신규</th>
							<th scope="col">&nbsp;</th>
							<th scope="col">&nbsp;</th>
							<th scope="col">&nbsp;</th>
							</c:when>
							</c:choose>
						</tr>
					</thead>
					<tbody>
						<c:if test="${fn:length(list) gt 0}">
							<c:set var="currNicCd" scope="page" value="" />
							<c:set var="currMkrPrdCd" scope="page" value="" />
							<c:forEach items="${list}" var="price">
							<c:choose>
							<c:when test="${price.nicCd == currNicCd && price.mkrPrdCd == currMkrPrdCd}">
                        <tr class="subitem">
							<td class="txt_ac"><input type="hidden" name="regDt" value="${params.regDt}" /><input type="hidden" name="nicCd" value="${price.nicCd}" /></td>
							<td class="txt_ac"><input type="hidden" name="mkrPrdCd" value="${price.mkrPrdCd}" /></td>
							<td class="txt_ac"><fmt:formatNumber value="${price.shoPrc}" var="shoPrcFmt" type="number"/></td>
							<td class="txt_ac"><input type="hidden" name="mbcomCd" value="${params.mbcomCd}" /></td>
							</c:when>
							<c:otherwise>
							<c:set var="currNicCd" scope="page" value="${price.nicCd}" />
							<c:set var="currMkrPrdCd" scope="page" value="${price.mkrPrdCd}" />
                        <tr class="mainitem">
							<td class="txt_al"><input type="hidden" name="regDt" value="${params.regDt}" /><input type="hidden" name="nicCd" value="${price.nicCd}" />${price.nicCdNm}</td>
							<td class="txt_al"><input type="hidden" name="mkrPrdCd" value="${price.mkrPrdCd}" />${price.mkrPrdCd}</td>
							<td class="txt_ar"><fmt:formatNumber value="${price.shoPrc}" var="shoPrcFmt" type="number"/>${shoPrcFmt}</td>
							<td class="txt_ac"><input type="hidden" name="mbcomCd" value="${params.mbcomCd}" />${params.mbcomCdNm}</td>
							</c:otherwise>
							</c:choose>
							<td class="txt_al"><input type="hidden" name="clpnCd" value="${price.clpnCd}" />${price.clpnCdNm}</td>
							<c:choose>
							<c:when test="${params.mbcomCd == '01'}">
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc11" value="" title="${price.salePrc11}" /><fmt:formatNumber value="${price.salePrc11}" var="salePrc11Fmt" type="number"/>${salePrc11Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc24" value="" title="${price.salePrc24}" /><fmt:formatNumber value="${price.salePrc24}" var="salePrc24Fmt" type="number"/>${salePrc24Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc17" value="" title="${price.salePrc17}" /><fmt:formatNumber value="${price.salePrc17}" var="salePrc17Fmt" type="number"/>${salePrc17Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc16" value="" title="${price.salePrc16}" /><fmt:formatNumber value="${price.salePrc16}" var="salePrc16Fmt" type="number"/>${salePrc16Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc19" value="" title="${price.salePrc19}" /><fmt:formatNumber value="${price.salePrc19}" var="salePrc19Fmt" type="number"/>${salePrc19Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc22" value="" title="${price.salePrc22}" /><fmt:formatNumber value="${price.salePrc22}" var="salePrc22Fmt" type="number"/>${salePrc22Fmt}<input type="hidden" name="salePrc25" /></td>
							</c:when>
							<c:when test="${params.mbcomCd == '02'}">
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc11" value="" title="${price.salePrc11}" /><fmt:formatNumber value="${price.salePrc11}" var="salePrc11Fmt" type="number"/>${salePrc11Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc24" value="" title="${price.salePrc24}" /><fmt:formatNumber value="${price.salePrc24}" var="salePrc24Fmt" type="number"/>${salePrc24Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc25" value="" title="${price.salePrc25}" /><fmt:formatNumber value="${price.salePrc25}" var="salePrc25Fmt" type="number"/>${salePrc25Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc16" value="" title="${price.salePrc16}" /><fmt:formatNumber value="${price.salePrc16}" var="salePrc16Fmt" type="number"/>${salePrc16Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc19" value="" title="${price.salePrc19}" /><fmt:formatNumber value="${price.salePrc19}" var="salePrc19Fmt" type="number"/>${salePrc19Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc22" value="" title="${price.salePrc22}" /><fmt:formatNumber value="${price.salePrc22}" var="salePrc22Fmt" type="number"/>${salePrc22Fmt}<input type="hidden" name="salePrc17" /></td>
							</c:when>
							<c:when test="${params.mbcomCd == '03'}">
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc11" value="" title="${price.salePrc11}" /><fmt:formatNumber value="${price.salePrc11}" var="salePrc11Fmt" type="number"/>${salePrc11Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc25" value="" title="${price.salePrc25}" /><fmt:formatNumber value="${price.salePrc25}" var="salePrc25Fmt" type="number"/>${salePrc25Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc16" value="" title="${price.salePrc16}" /><fmt:formatNumber value="${price.salePrc16}" var="salePrc16Fmt" type="number"/>${salePrc16Fmt}</td>
							<td><input type="hidden" name="salePrc17" /><input type="hidden" name="salePrc19" /><input type="hidden" name="salePrc22" /><input type="hidden" name="salePrc24" /></td>
							<td></td>
							<td></td>
							</c:when>
							<c:when test="${params.mbcomCd == '04'}">
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc11" value="" title="${price.salePrc11}" /><fmt:formatNumber value="${price.salePrc11}" var="salePrc11Fmt" type="number"/>${salePrc11Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc24" value="" title="${price.salePrc24}" /><fmt:formatNumber value="${price.salePrc24}" var="salePrc24Fmt" type="number"/>${salePrc24Fmt}</td>
							<td class="txt_ar curPointer"><input type="hidden" name="salePrc25" value="" title="${price.salePrc25}" /><fmt:formatNumber value="${price.salePrc25}" var="salePrc25Fmt" type="number"/>${salePrc25Fmt}</td>
							<td><input type="hidden" name="salePrc16" /><input type="hidden" name="salePrc17" /><input type="hidden" name="salePrc19" /><input type="hidden" name="salePrc22" /></td>
							<td></td>
							<td></td>
							</c:when>
							</c:choose>
						</tr>
							</c:forEach>
						</c:if>
						<c:if test="${fn:length(list) le 0 and pageNo != '0'}">
						<tr>
							<td colspan="11" class="txt_ac">조회된 자료가 존재하지 않습니다.</td>
						</tr>
						</c:if>
					</tbody>
				</table>
			</form>
			<page:paging pageSize="${pageSize}" pageNo="${pageNo}" totalCnt="${totalCnt}" pageCnt="10" urlImg="${pageContext.request.contextPath}/resources/assets/image/"></page:paging>
			<iframe id="frameProc" name="frameProc" class="proc_hidden"></iframe>
			<div class="btn-right"><a href="#"><img id="btnSave" src="${pageContext.request.contextPath}/resources/assets/image/btn_save.gif" alt="저장" /></a></div>
		</div>
	</div>
</body>
</html>