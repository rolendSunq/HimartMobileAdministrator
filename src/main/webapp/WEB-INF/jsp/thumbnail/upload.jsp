<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/thumbnail/upload.js"></script>
	<title>HI-MART MOBILE ADMIN</title>
</head>
<body>
	<div id="container">
		<div id="contentWrap">
			<form id="frmImage" name="frmImage" action="/moveThumbnailUpload.do" method="post">
				<input type="hidden" id="imgCfCd" name="imgCfCd" value="${params.imgCfCd}" />
				<input type="hidden" id="imgCfCdNm" name="imgCfCdNm" value="${params.imgCfCdNm}" />
				<input type="hidden" id="prdItemNm" name="prdItemNm" value="${params.prdItemNm}" />
				<input type="hidden" id="prdItemNmNm" name="prdItemNmNm" value="${params.prdItemNmNm}" />
				<input type="hidden" id="prdNicNm" name="prdNicNm" value="${params.prdNicNm}" />
				<input type="hidden" id="prdNicNmNm" name="prdNicNmNm" value="${params.prdNicNmNm}" />
				<input type="hidden" id="imgPstCfCd" name="imgPstCfCd" value="" />
				<input type="hidden" id="pageSize" name="pageSize" value="${pageSize}" />
				<input type="hidden" id="pageNo" name="pageNo" value="${pageNo}" />
				<input type="hidden" id="totalCnt" name="totalCnt" value="${totalCnt}" />
				<input type="hidden" id="selTrId" name="selTrId" value="" />
			</form>
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
<!-- 					<div id="itemGrp"> -->
<!-- 						<strong class="strong2">품목</strong> -->
<!-- 						<div class="calendar-search"> -->
<!-- 							<input type="hidden" id="itemCd" name="itemCd" title="품목코드" /><input type="text" class="wd301" id="itemNm" name="itemNm" title="품목명" readonly="readonly" /><input type="image" class="icld" src="<%=request.getContextPath()%>/resources/assets/image/btn_search.gif" alt="찾기" title="찾기" onclick="javascript:popupItem();" /> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div id="nicGrp"> -->
<!-- 						<strong class="strong2" id="selTitleNic">닉네임</strong> -->
<!-- 						<div class="calendar-search"> -->
<!-- 							<input type="hidden" id="nicCd" name="nicCd" title="닉네임코드/대표코드" /><input type="text" class="wd301" id="nicNm" name="nicNm" title="닉네임명/대표코드" readonly="readonly" /><input type="image" class="icld" src="<%=request.getContextPath()%>/resources/assets/image/btn_search.gif" alt="찾기" title="찾기" onclick="javascript:popupNic();" /> -->
<!-- 						</div> -->
<!-- 					</div> -->
				</div>
				<div class="btn">
					<a href="#"><img id="btnLookup" src="<%=request.getContextPath()%>/resources/assets/image/btn_lookup.gif" alt="조회" /></a>
					<a href="#"><img id="btnEnrolment" src="<%=request.getContextPath()%>/resources/assets/image/btn_enrolment.gif" alt="등록" /></a>
					<a href="#"><img id="btnDelete" src="<%=request.getContextPath()%>/resources/assets/image/btn_delete.gif" alt="삭제" /></a>
				</div>
			</div>
			<table summary="이미지목록" class="board-list">
				<colgroup>
					<col style="width:4%;" />
					<col style="width:6%;" />
					<c:choose>
						<c:when test="${params.imgCfCd == '8'}">
							<col style="width: 16%;" />
							<col style="width: 16%;" />
						</c:when>
											<c:otherwise>
						<%--                     <col style="width:32%;" /> --%>
											</c:otherwise>
					</c:choose>
					<col style="width:10%;" />
                    <col style="width:10%;" />
					<col style="width:10%;" />
					<col style="width:20%;" />
					<col style="width:8%;" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col"><input type="checkbox" id="checkAll" /></th>
						<th scope="col">구분</th>
						<c:choose>
							<c:when test="${params.imgCfCd == '8'}">
								<th scope="col">코드</th>
								<th scope="col">코드명</th>
							</c:when>
								                    <c:otherwise>
							<!--                         <th scope="col">닉네임</th> -->
								                    </c:otherwise>
						</c:choose>
						<th scope="col">순번</th>
                        <th scope="col">등록일자</th>
						<th scope="col">파일경로</th>
						<th scope="col">파일명</th>
						<th scope="col">수정</th>
					</tr>
				</thead>
				<thead>
					<c:if test="${fn:length(list) gt 0}">
					<c:forEach items="${list}" var="image">
					<tr data="${image.imgCfCd}^${image.prdNicNm}^${image.accPrdId}^${image.imgPstCfCd}">
						<td class="txt_ac"><input type="checkbox" name="checkItem" /></td>
						<td class="txt_ac" name="imgCfCdNm">${image.imgCfCdNm}</td>
							<%--   코드, 코드명 --%>
								<c:choose>
									<c:when test="${params.imgCfCd == '8'}">
										<td class="txt_ac" name="prdNicNm">${image.prdNicNm}</td>
										<td class="txt_ac" name="prdNicNmNm">${image.prdNicNmNm}</td>
									</c:when>
									<c:otherwise>
										<%--  <td class="txt_ac" name="prdNicNmNm">${image.prdNicNmNm}</td> --%>
									</c:otherwise>
								</c:choose>
						<%-- <td class="txt_ac" name="imgPstCfCdNm">${image.imgPstCfCdNm}</td> --%>
                        <td class="txt_ac" name="imgPstCfCdNm">${image.imgPstCfCd}</td>
						<td class="txt_ac" name="updDt">${image.updDt}</td>
						<td class="txt_al" name="imgSavePath">${image.imgSavePath}</td>
						<td class="txt_al curPointer" name="imgSaveFileNm" onclick="javascript:previewImage('${image.imgSavePath}', '${image.imgSaveFileNm}');">${image.imgSaveFileNm}</td>
						<td class="txt_ac"><a href="#"><img name="btnModify" src="<%=request.getContextPath()%>/resources/assets/image/btn_modi.gif" alt="수정" /></a></td>
					</tr>
					</c:forEach>
					</c:if>
					<c:if test="${fn:length(list) le 0 and pageNo != '0'}">
					<tr>
						<td colspan="9" class="txt_ac">조회된 자료가 존재하지 않습니다.</td>
					</tr>
					</c:if>
				</thead>
			</table>
			<page:paging pageSize="${pageSize}" pageNo="${pageNo}" totalCnt="${totalCnt}" pageCnt="10" urlImg="${pageContext.request.contextPath}/resources/assets/image/"></page:paging>
		</div>
	</div>
</body>
</html>