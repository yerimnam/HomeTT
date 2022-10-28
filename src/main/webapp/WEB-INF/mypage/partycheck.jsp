<%@page import="util.Paging"%>
<%@page import="partyCheck.dto.PartyCheck"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<PartyCheck> partyList = (List) request.getAttribute("partyList"); %>
<% Paging paging = (Paging) request.getAttribute("paging"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Party Check</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
.container {
	display: flex;
	justify-content: center;
	margin-top: 50px;
	margin-bottom: 90px;
	/* column-gap: 50px; */
	gap: 50px;	
}

.situation {
	display: flex;
	padding-top: 20px;
	padding-left: 200px;
}

#party {
	display: flex;
	width: 230px;
	height: 250px;
/* 	margin: 20px; */
/* 	paddig: 20px; */
	border: 1px solid #000;		
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

<h1 style="text-align: center; background-color: #7DA5E1">파티 목록 조회</h1>
<hr>

<div class="situation">
내가 만든 파티
</div>
<div class="container">
<% for(int i = 0; i < partyList.size(); i++) { %>
<div id="party">
	<ul>
		<div style="border: 1px solid #000; text-align: center; margin-top: 10px; border-radius: 5px;">
			<%=partyList.get(i).getPartyKind() %>
		</div>
		<div style="text-align: center; margin: 5px; margin-top: 15px;">
			<%=partyList.get(i).getPartyName() %>
		</div>
		<hr style="height: 1px; background-color: black;">
		<li>파티장 : <%=partyList.get(i).getPartyLeader() %></li>
		<li>파티 만료일 : <%=partyList.get(i).getPartyEnddate() %></li>
		<li>모집 인원 : <%=partyList.get(i).getPartyMember() %></li>
		<hr style="height: 1px; background-color: black;">
		<li>참여 금액 : <%=partyList.get(i).getPaymentamount() %> 원</li>
	</ul>
</div>
<% } %>

</div>

<div style="text-align: center;">
	<ul class="pagination">
		<% for(int i=paging.getStartPage(); i <= paging.getEndPage(); i++) { %>
		<li><a href="./partycheck?curPage=<%=i %>"><%=i %></a></li> <!-- 파티장으로 참여중인 페이징 -->
		<% } %>
	</ul>
</div>
<hr>


<div class="situation">
참여중인 파티
</div>
<div class="container">

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

<div style="text-align: center;">
	<ul class="pagination">
		<% for(int i=paging.getStartPage(); i <= paging.getEndPage(); i++) { %>
		<li><a href="./partycheck?curPage=<%=i %>"><%=i %></a></li> <!-- 파티원으로 참여중인 파티 페이 -->
		<% } %>
	</ul>
</div>

</div>



</body>
</html>