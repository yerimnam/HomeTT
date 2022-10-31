<%@page import="party.dto.Party"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Party viewParty = (Party) request.getAttribute("viewParty");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/layout/header.jsp" />
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#payBtn").click(function() {
			$("#payform").submit();
		})

	})
</script>


<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');

.container {
	border: 1px solid black;
	margin: auto;
	width: 750px;
	height: 450px;
}

body {
	line-height: 230%;
	font-size: 17px;
}

ul {
	list-style: none;
}

#payBtn, #partyBack {
	display: inline-block;
	text-align: center;
	padding: 1px 15px;
	margin-right: 10px;
	margin-left: 10px;
}
</style>

</head>
<body>

	<h2 style="text-align: center;">파티방 정보 상세보기</h2>
	<br>
	<hr>
	<br>
	<div class="container" style="text-align: center;">
		<br>
		<ul>
			<%
			if (viewParty == null) {
			%>
			<%
			System.out.println("잘못된 값입니다");
			%>
			<%
			} else {
			%>

			<li>파티종류 : OTT <%=viewParty.getPartyKind()%></li>
			<li>파티제목 : <%=viewParty.getPartyName()%></li>
			<li>파티방 번호 : <%=viewParty.getPartyNo()%></li>
			<li>파티장 정보 : <%=viewParty.getPartyLeader()%></li>
			<li>파티 종료일 : <%=viewParty.getPartyEndDate()%></li>
			<li>모집 인원 : <%=viewParty.getPartyMember()%></li>
			<li>결제 금액 : <%=viewParty.getPaymentAmount()%></li>
			<%
			}
			%>
		</ul>
		<br>
		<div style="text-align: center">
			<form action="/homett/payamount" method="get" id="payform">
				<button id="payBtn">가입하기</button>
				<!-- 	<button onclick="location.href='./joinparty'">가입하기</button> -->
				<button id="partyBack" onclick="location.href='./partymodify'">목록으로</button>
			</form>
		</div>
	</div>
</body>
</html>
<jsp:include page="/WEB-INF/layout/footer.jsp" />
