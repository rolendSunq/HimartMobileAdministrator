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
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/image/modify.js"></script>
	<title>HI-MART MOBILE ADMIN</title>
</head>
<body>
	<div id="container">
		<div id="contentWrap">
			<form id="frmModify" name="frmModify" action="/imageUploadRegProc.do" method="post" enctype="multipart/form-data" target="frameProc">
				<input type="hidden" id="imgCfCd" name="imgCfCd" value="${params.imgCfCd}" />
                <input type="hidden" id="prdNicNm" name="prdNicNm" value="${params.prdNicNm}" />
                <input type="hidden" id="accPrdId" name="accPrdId" value="${params.accPrdId}" />
				<input type="hidden" id="imgPstCfCd" name="imgPstCfCd" value="${params.imgPstCfCd}" />
				<table summary="이미지수정" class="board-img">
					<colgroup>
						<col style="width:10%;" />
                        <c:choose>
                        <c:when test="${params.imgCfCd == '4'}">
                        <col style="width:20%;" />
                        <col style="width:15%;" />
                        </c:when>
                        <c:otherwise>
                        <col style="width:35%;" />
                        </c:otherwise>
                        </c:choose>
						<col style="width:10%;" />
						<col style="width:40%;" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">구분</th>
							<c:choose>
							<c:when test="${params.imgCfCd == '2'}">
							<th scope="col">카드할인</th>
							</c:when>
							<c:otherwise>
		                        <c:choose>
		                        <c:when test="${params.imgCfCd == '4'}">
                            <th scope="col">닉네임</th>
                            <th scope="col">상품코드</th>
		                        </c:when>
		                        <c:otherwise>
                            <th scope="col">닉네임</th>
		                        </c:otherwise>
		                        </c:choose>
							</c:otherwise>
							</c:choose>
							<th scope="col">이미지구분</th>
							<th scope="col">파일명</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="txt_ac">${params.imgCfCdNm}</td>
                            <c:choose>
                            <c:when test="${params.imgCfCd == '4'}">
                            <td class="txt_ac">${params.prdNicNmNm}</td>
                            <td class="txt_ac">${params.accPrdCd}</td>
                            </c:when>
                            <c:otherwise>
                            <td class="txt_ac">${params.prdNicNmNm}</td>
                            </c:otherwise>
                            </c:choose>
							<td class="txt_ac">${params.imgPstCfCdNm}</td>
							<td class="txt_ac"><input type='hidden' id='imgOrigFileNm' title='파일명' /><input type="file"  class="wdfull" id="imgOrigFile" name="imgOrigFile" accept="image/*" onchange="javascript:changeFile(this);" /></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" name="submitMod" value="Click!" class="submit_hidden"/>
			</form>
			<iframe id="frameProc" name="frameProc" class="proc_hidden"></iframe>
			<div class="btn-right"><a href="#"><img id="btnSave" src="<%=request.getContextPath()%>/resources/assets/image/btn_save.gif" alt="저장" /></a></div>
		</div>
	</div>
</body>
</html>