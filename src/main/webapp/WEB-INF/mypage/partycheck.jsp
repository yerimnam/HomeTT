<%@page import="partyCheck.dto.PartyCheck"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	List<PartyCheck> partyList = (List) request.getAttribute("boardList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Party Check</title>

<style type="text/css">
#party {
	border: 1px solid #000
	
}

li {
    display: flex;
    flex-direction: row;
    list-style: none;
    margin: 0px;
    padding: 0px;
}
</style>

</head>
<body>

<h1>파티 목록 조회</h1>
<hr>

<div id="party">
	<ul>
		<li>OTT 이름</li>
		<li>파티 제목</li>
		<hr>
		<li>파티장</li>
		<li>파티만료일</li>
		<li>파티 남은 기간</li>
		<li>모집인원</li>
		<hr>
		<li>참여금액</li>
	</ul>
</div>

<% for(int i = 0; i < partyList.size(); i++) { %>
<div id="party">
	<ul>
		<li><%=partyList.get(i).getPartyKind() %></li>
		<li><%=partyList.get(i).getPartyName() %></li>
		<hr>
		<li><%=partyList.get(i).getPartyLeader() %></li>
		<li><%=partyList.get(i).getPartyEnddate() %></li>
		<li><%=partyList.get(i).getPartyMember() %></li>
		<hr>
		<li><%=partyList.get(i).getPaymentamount() %></li>
	</ul>
</div>
<% } %>



</body>
</html>