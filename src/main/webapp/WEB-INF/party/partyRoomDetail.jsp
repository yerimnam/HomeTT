<%@page import="party.dto.Party"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Party viewParty = (Party) request.getAttribute("viewParty");%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
ul{
	list-style:none;
}
</style>
</head>
<body>

	<h1>파티방 정보 상세보기</h1>

<ul>
	<% if(viewParty ==null){%>
	<% System.out.println("잘못된 값입니다"); %>
	<%}else{ %>
	
	<li>파티종류 : OTT <%=viewParty.getPartyKind()%></li>
	<li>파티제목 : <%=viewParty.getPartyName() %></li>
	<li>파티방 번호 : <%=viewParty.getPartyRoomNo() %></li>
	<li>파티장 정보 : <%=viewParty.getPartyLeader()%></li>
	<li>파티 종료일 : <%=viewParty.getPartyEndDate()%></li>
	<li>모집 인원 : <%=viewParty.getPartyMember()%></li>
	<li>결제 금액 : <%=viewParty.getPaymentAmount()%></li>
	<%} %>
	</ul>
	<button onclick="location.href='./payamount'">가입하기</button>
<!-- 	<button onclick="location.href='./joinparty'">가입하기</button> -->
	<button onclick="location.href='./partymodify'">목록으로</button>
		
</body>
</html>

