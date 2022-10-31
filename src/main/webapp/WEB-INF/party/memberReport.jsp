<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/layout/header.jsp" />

<script type="text/javascript">
	$(document).ready(function() {

		//작성버튼
		$("#btnWrite").click(function() {

			$("form").submit();
		})

		//취소버튼
		$("#btnCancel").click(function() {
			history.go(-1)
		})

	})
</script>

<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');

.container {
	border: 1px solid black;
	margin: auto;
	width: 750px;
	height: 470px;
}

table {
	/* 테이블 중앙 배치 */
	margin: auto;
}

input{
	vertical-align: 30px;
	horizontal-align: 10px;
}

#btnWrite, #btnCancel {
	display: inline-block;
	text-align: center;
	padding: 1px 15px;
	margin-right: 10px;
	margin-left: 10px;
}

body {
	line-height: 230%;
	font-size: 17px;
}
</style>
</head>
<body>


	<h2 style="text-align: center">🔔신고하기</h2>
	<br>
	<hr>
	<br>

	<form action="./mbrreport" method="post">

		<div class="container">
			<table>
<!-- 				<tr> -->
<!-- 					<td>작성자</td> -->
<%-- 					<td><%=session.getAttribute("userid")%></td> --%>
<!-- 				</tr> -->


				<tr>
					<td>신고 대상</td>
					<td><input type="text" name="reporttarget" style="width: 100%;"></td>
				</tr>

				<tr>
					<td>신고할 파티명</td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td colspan="2">신고 내용</td>
				</tr>
				<br>
				<tr>
					<td colspan="5"><textarea id="content" name="reportcontent" style="width: 100%;"></textarea></td>
				</tr>
			</table>
			<br>
			<div style="text-align: center">
				<button id="btnWrite">작성</button>
				<button id="btnCancel">취소</button>
			</div>
		</div>
	</form>


<jsp:include page="/WEB-INF/layout/footer.jsp" />