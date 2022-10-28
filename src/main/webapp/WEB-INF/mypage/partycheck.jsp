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
<script src="https://cdnjs.cloudflare.com/ajax/libs/xdomain/0.8.2/xdomain.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<!-- 카카오 메시지 -->
<script type="text/JavaScript" src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');
* {
	font-family: SUIT;
}


.main {
	display: flex;
	justify-content: center;
	margin-top: 40px;
	margin-bottom: 50px;
	gap: 30px;	
}

.situation {
	display: flex;
	padding-top: 20px;
	padding-left: 230px;
}

.invitation {
	display: flex;
	justify-content: center;
}

#party {
	width: 240px;
	height: 270px;
/* 	margin: 20px; */
/* 	paddig: 20px; */
	border: 1px solid #000;		
}

#party ul {
	padding: 5px;
}

li {
    display: flex;
    flex-direction: row;
    list-style: none;
    margin: 0px;
    padding: 0px;
}
</style>

<%@ include file="../layout/header.jsp" %>

<body>

<div class="situation">
내가 만든 파티
</div>

<div class="invitation">
    <input type="button" onClick="sendLinkCustom();" value="초대하기"/>
</div>
<!--     <input type="button" onClick="sendLinkDefault();" value="친구선택"/> -->

<script type="text/javascript">
<%-- $(document).ready(function() {
	
	$("#btnPartyOut").click(function() {
		$(location).attr('href', './delete?partyno=<%=partyList.getPartyNo() %>')
	})
	
}) --%>

    function sendLinkCustom() {
        Kakao.init("5e3445a388e682bf93a131b9d9a3a8e2");
        Kakao.Link.sendCustom({
            templateId: 84625 
        });
    }
</script>



<div class="main">
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
			<li id="party_no" hidden><%=partyList.get(i).getPartyNo() %></li>
			<button id="#btnPartyOut">나가기</button>
		</ul>
	</div>
	<% } %>
</div>

<div style="text-align: center;">
	<ul class="pagination">
		<% for(int i=paging.getStartPage(); i <= paging.getEndPage(); i++) { %>
		<li><a href="./partycheck?curPage=<%=i %>"><%=i %></a></li>
		<% } %>
	</ul>
</div>
<hr>


<div class="situation">
참여중인 파티
</div>


<div id="submenu">
	<ul>
	</ul>
</div>
<div class="main">
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


<script>
	let party_no = document.querySelector("#party_no");
	let submit = document.querySelector("#btnPartyOut");
	
	console.log(party_no)
	
	
	
	submit.addEventListener("click", () => {
		axios.post('redirect', party_no.innerText);
		
	})
	
</script>


</body>
</html>