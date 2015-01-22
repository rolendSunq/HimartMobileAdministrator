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
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/jquery.fileDownload.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/common.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/log/counsel.js"></script>
	<title>HI-MART MOBILE ADMIN</title>
</head>
<body>
	<div id="container">
		<div id="contentWrap">
			<form id="frmLog" name="frmLog" action="/logCounsel.do" method="post">
				<input type="hidden" id="pageSize" name="pageSize" value="${pageSize}" />
				<input type="hidden" id="pageNo" name="pageNo" value="${pageNo}" />
				<input type="hidden" id="totalCnt" name="totalCnt" value="${totalCnt}" />
				<table summary="기간,제조사,통신사,모델코드,지점,등록사번,순서로 안내합니다." class="board-type">
					<colgroup>
						<col style="width:10%;" />
						<col style="width:40%;" />
						<col style="width:10%;" />
						<col style="width:40%;" />
					</colgroup>
					<tbody>
						<tr>
							<th>기간</th>
							<td>
								<input type="text" class="wd113" name="cnslDtFrom" title="시작일자" value="${params.cnslDtFrom}" readonly="readonly"/><input type="image" id="btnCnslDtFrom" class="calendar" src="<%=request.getContextPath()%>/resources/assets/image/icon_calendar.gif" alt="달력" title="달력" /> ~
								<input type="text" class="wd113" name="cnslDtTo" title="종료일자" value="${params.cnslDtTo}" readonly="readonly"/><input type="image" id="btnCnslDtTo" class="calendar" src="<%=request.getContextPath()%>/resources/assets/image/icon_calendar.gif" alt="달력" title="달력" />
							</td>
							<th>통신사</th>
							<td><input type="hidden" name="mbcomCd" value="${params.mbcomCd}" /><input type="text" class="wd281" id="mbcomCdNm" name="mbcomCdNm" value="${params.mbcomCdNm}" title="통신사" readonly="readonly"/><input type="image" class="search" src="<%=request.getContextPath()%>/resources/assets/image/btn_search.gif" onclick="javascript:popupMbcom(); return false;" alt="찾기" title="찾기" /></td>
						</tr>
						<tr>
							<th>제조사</th>
							<td><input type="hidden" name="mkrId" value="${params.mkrId}" /><input type="text" class="wd281" id="mkrNm" name="mkrNm" value="${params.mkrNm}" title="제조사" readonly="readonly"/><input type="image" class="search" src="<%=request.getContextPath()%>/resources/assets/image/btn_search.gif" onclick="javascript:popupMkr(); return false;" alt="찾기" title="찾기" /></td>
							<th>모델코드</th>
							<td><input type="hidden" name="cnslPrdCdNm" value="${params.cnslPrdCdNm}" /><input type="text" class="wd281" id="cnslPrdCd" name="cnslPrdCd" value="${params.cnslPrdCd}" title="모델코드" readonly="readonly"/><input type="image" class="search" src="<%=request.getContextPath()%>/resources/assets/image/btn_search.gif" onclick="javascript:popupCnslPrd(); return false;" alt="찾기" title="찾기" /></td>
						</tr>
						<tr>
							<th>지점</th>
							<td><input type="hidden" name="brchId" value="${params.brchId}" /><input type="text" class="wd281" id="brchIdNm" name="brchIdNm" value="${params.brchIdNm}" title="상담지점" readonly="readonly"/><input type="image" class="search" src="<%=request.getContextPath()%>/resources/assets/image/btn_search.gif" onclick="javascript:popupBrch(); return false;" alt="찾기" title="찾기" /></td>
							<th>권유자</th>
							<td><input type="hidden" name="ivtmnId" value="${params.ivtmnId}" /><input type="text" class="wd281" id="ivtmnIdNm" name="ivtmnIdNm" value="${params.ivtmnIdNm}" title="등록사번" readonly="readonly"/><input type="image" class="search" src="<%=request.getContextPath()%>/resources/assets/image/btn_search.gif" onclick="javascript:popupIvtmn(); return false;" alt="찾기" title="찾기" /></td>
						</tr>
					</tbody>
				</table>
			</form>
			<div class="btn-right">
				<a href="#"><img id="btnLookup" src="<%=request.getContextPath()%>/resources/assets/image/btn_lookup.gif" alt="조회" /></a>
				<a href="#"><img id="btnExcel" src="<%=request.getContextPath()%>/resources/assets/image/btn_excel.gif" alt="엑셀 다운로드" /></a>
			</div>
			<table summary="" class="board-list board-list2">
				<colgroup>
					<col style="width:4%;" />
					<col style="width:17%;" />
					<col style="width:6%;" />
					<col style="width:4%;" />
					<col style="width:4%;" />
					<col style="width:4%;" />
					<col style="width:6%;" />
					<col style="width:6%;" />
					<col style="width:6%;" />
					<col style="width:4%;" />
					<col style="width:6%;" />
					<col style="width:8%;" />
					<col style="width:7%;" />
					<col style="width:6%;" />
					<col style="width:7%;" />
					<col style="width:6%;" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col" rowspan="2">순번</th>
						<th scope="col" rowspan="2">지점명<br/>(코드)</th>
						<th scope="col" rowspan="2">상담일자</th>
						<th scope="col" rowspan="2">발생<br/>순번</th>
						<th scope="col" rowspan="2">상세<br/>순번</th>
						<th scope="col" rowspan="2">메뉴<br/>CH</th>
						<th scope="col" rowspan="2">상담시간</th>
						<th scope="col" rowspan="2">권유자명<br/>(사번)</th>
						<th scope="col" rowspan="2">연령대</th>
						<th scope="col" rowspan="2">성별</th>
						<th scope="col" rowspan="2">통신사</th>
						<th scope="col" rowspan="2">상담모델</th>
						<th scope="col" colspan="2">상담조건</th>
						<th scope="col" colspan="2">희망조건</th>
					</tr>
					<tr>
						<th scope="col">가입구분</th>
						<th scope="col">판매가</th>
						<th scope="col">가입구분</th>
						<th scope="col">판매가</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${fn:length(list) gt 0}">
					<c:forEach items="${list}" var="log">
					<tr>
						<td class="txt_ac">${log.seq}</td>
						<td class="txt_ac">${log.brchIdNm}<br/>(${log.brchId})</td>
						<td class="txt_ac"><fmt:parseDate value="${log.cnslDt}" var="cnslDtFmt" pattern="yyyyMMdd"/><fmt:formatDate value="${cnslDtFmt}" pattern="yyyy-MM-dd" /></td>
						<td class="txt_ac">${log.occrSeq}</td>
						<td class="txt_ac">${log.dtlSeq}</td>
						<td class="txt_ac">${log.mnCfCd}</td>
						<td class="txt_ac"><fmt:parseDate value="${log.cnslStrtTm}" var="cnslStrtTmFmt" pattern="HHmmss"/><fmt:formatDate value="${cnslStrtTmFmt}" pattern="HH:mm:ss" /></td>
						<td class="txt_ac">${log.ivtmnIdNm}<br/>(${log.ivtmnId})</td>
						<td class="txt_ac">${log.ags}</td>
						<td class="txt_ac">${log.sexNm}</td>
						<td class="txt_ac">${log.mbcomCdNm}</td>
						<td class="txt_ac">${log.cnslPrdCd}</td>
						<td class="txt_ac">${log.cnslJnCfCdNm}</td>
						<td class="txt_ar"><fmt:formatNumber value="${log.cnslSlprc}" type="number"/></td>
						<td class="txt_ac">${log.hopeJnCfCdNm}</td>
						<td class="txt_ar"><fmt:formatNumber value="${log.hopeSlprc}" type="number"/></td>
					</tr>
					</c:forEach>
					</c:if>
					<c:if test="${fn:length(list) le 0 and pageNo != '0'}">
					<tr>
						<td colspan="16" class="txt_ac">조회된 자료가 존재하지 않습니다.</td>
					</tr>
					</c:if>
				</tbody>
			</table>
			<page:paging pageSize="${pageSize}" pageNo="${pageNo}" totalCnt="${totalCnt}" pageCnt="10" urlImg="<%=request.getContextPath()%>/resources/assets/image/"></page:paging>
		</div>
	</div>
</body>
</html>