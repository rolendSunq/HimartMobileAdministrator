<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0" />
	<meta name="format-detection" content="telephone=no, email=no, address=no" />
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/style.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/common.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/assets/js/error/error.js"></script>
	<title>HI-MART MOBILE ADMIN</title>
</head>
<body>
	<div id="error-page">
		<h1><img src="<%=request.getContextPath()%>/resources/assets/image/logo.gif" alt="HI-MART MOBILE" /></h1>
		<div class="error-box">
			<table summary="에러페이지" class="error-type">
				<colgroup>
					<col style="width:20%;" />
					<col style="width:80%;" />
				</colgroup>
				<tbody>
					<tr>
						<td class="error-msg" colspan="2">
							하이마트 모바일서비스 관리자 시스템 이용 중<br/>다음과 같이 오류가 발생하였습니다.<br/>
							계속해서 오류가 발생할 경우 시스템 담당자에게 문의하세요.
						</td>
					</tr>
					<tr>
						<th>에러코드</th>
						<td>401 (Unauthorized)</td>
					</tr>
					<tr>
						<th>에러내용</th>
						<td>서버에 로그온하려는 요청사항이 서버에 들어있는 권한과 비교했을 시<br/>맞지 않을 경우 발생합니다.<br/>
						    이 경우 요청한 자원에 접근할 수 있는 권한을 부여받기 위해서<br/>시스템 담당자에게 요청해야 합니다.</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>