<%@page import="admin.party.dto.Party"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	List<Party> partyList = (List) request.getAttribute("partyList"); %>

<%@ include file="../layout/header.jsp" %>

<style type="text/css">
th, td {
	text-align: center;
	border: 1px solid #ccc;
}

th {
	font-size: 16px;
}

* {
	margin: 0 auto;
}
</style>

</head>
<body>

<div style="margin: 30px 0; margin-left: 160px;">
	<h1>파티 관리 - 파티 목록</h1>
</div>

<table style="width: 1600px;" class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 5%; text-align: center">파티 번호</th>
	<th style="width: 8%; text-align: center">파티 방번호</th>
	<th style="width: 10%; text-align: center">OTT 분류</th>
	<th style="width: 15%; text-align: center">파티 이름</th>
	<th style="width: 10%; text-align: center">파티장</th>
	<th style="width: 8%; text-align: center">파티 개설일</th>
	<th style="width: 8%; text-align: center">파티 종료일</th>
	<th style="width: 5%; text-align: center">파티 인원</th>
	<th style="width: 10%; text-align: center">결제 금액</th>
	<th style="width: 10%; text-align: center">OTT ID</th>
	<th style="width: 10%; text-align: center">OTT PW</th>
</tr>

<%	for(int i=0; i<partyList.size(); i++) { %>
<tr>
	<td><%=partyList.get(i).getPartyNo() %></td>
	<td><%=partyList.get(i).getPartyRoomNo() %></td>
	<td><%=partyList.get(i).getPartyKind() %></td>
	<%	String partyname = partyList.get(i).getPartyName();
		if( partyname.length() > 10 ) { 
			partyname = partyname.substring(0, 10) + "...";
		} %>
	<td><a href="./partyroomdetail?partyNo=<%=partyList.get(i).getPartyNo() %>">
				<%=partyname %></a></td>
	<td><%=partyList.get(i).getPartyLeader() %></td>
	<td><%=partyList.get(i).getPartyCreDate() %></td>
	<td><%=partyList.get(i).getPartyEndDate() %></td>
	<td><%=partyList.get(i).getPartyMember() + "명" %></td>
	<td><%=partyList.get(i).getPaymentAmount() + "원" %></td>
	<td><%=partyList.get(i).getOttId() %></td>
	<td><%=partyList.get(i).getOttPw() %></td>
</tr>
<%	} %>

</table>

<%@ include file="../layout/partypaging.jsp" %>

<%@ include file="../layout/partysearch.jsp" %>

</body>

<!-- 부트스트랩3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');
body{
	font-family: 'SUIT';
}
</style>

</html>