<%@page import="util.Paging5"%>
<%@page import="partyCheck.dto.PartyCheck"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<PartyCheck> partyList = (List) request.getAttribute("partyList"); %>
<% List<PartyCheck> ownerPartyList = (List) request.getAttribute("ownerPartyList"); %>
<% Paging5 paging5 = (Paging5) request.getAttribute("paging"); %>

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
	padding-top: 20px;
	padding-left: 430px;
}

.invitation {
	display: flex;
	justify-content: center;
}

#party {
	/* width: 240px; */
	height: 300px;
/* 	margin: 20px; */
/* 	paddig: 20px; */
	border-radius: 5px;
	border: 1px solid #e5dcb1;
	background-color: #eff2e0;	
}

#partyKind {
	border: 1px solid #585a72; 
	height: 45px;
	padding-top:10px;
	text-align: center; 
	border-radius: 5px;
}

#partyName {
	text-align: center; 
	margin: 5px; 
	margin-top: 15px;
}

#party ul {
	text-align: center;
	padding: 5px;
}


li {
    list-style: none;
    margin: 0px;
    padding: 0px;
    font-weight: 300;
}

a {
	text-decoration: none !important;
	color: black;
	font-weight: 600;
}
a:link{
	color:black;
    transition : 1s; /* 속성 변경할 때 효과의 속도 조절 */
}
a:visited{
	color: black;
}
a:hover { 
	color:white;
	text-decoration: none;
}
a:active {
	color:black;
	text-decoration: none;
}

#btn {
	border-top-left-radius: 5px;
	border-bottom-right-radius: 5px;
	margin-right: -4;
	border: 1px solid #ffeaa6;
	background-color: rgba(0,0,0,0);
	color: #585a72;
	padding: 5px;
}

#btn:hover {
	color: #a9cd72;
	background-color: #ffeaa6;
}

</style>

<%@ include file="../layout/header.jsp" %>

<body>

<div class="situation">
<h4>내가 만든 파티</h4>
</div>
<hr align="center" style=" height: 1px; background-color: black; width: 60%;">

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
	<% for(int i = 0; i < ownerPartyList.size(); i++) { %>
	<div id="party">
		<a href="./roomboard?partyno=<%=partyList.get(i).getPartyNo() %>"><%=partyList.get(i).getPartyNo() %><ul>
			<div id="partyKind">
				<%=ownerPartyList.get(i).getPartyKind() %>
			</div>
			<div id="partyName">
				<%=ownerPartyList.get(i).getPartyName() %>
			</div>
			<hr style="background-color: black; border-style: dashed; width: 100px;">
			<li>파티장 : <%=ownerPartyList.get(i).getPartyLeader() %></li>
			<li>파티 만료일 : <%=ownerPartyList.get(i).getPartyEnddate() %></li>
			<li>모집 인원 : <%=ownerPartyList.get(i).getPartyMember() %></li>
			<hr style="background-color: black; border-style: dashed; width: 150px;">
			<li>참여 금액 : <%=ownerPartyList.get(i).getPaymentamount() %> 원</li>
			<li id="party_no" hidden><%=ownerPartyList.get(i).getPartyNo() %></li>
		</ul></a>
	</div>
	<% } %>
</div>

<div class="invitation">
    <input type="button" id="btn" onClick="sendLinkCustom();" value="초대하기"/>
</div>

<hr>


<div class="situation">
<h4>전체 파티 목록</h4>
</div>
<hr align="center" style=" height: 1px; background-color: black; width: 60%;">


<div id="submenu">
	<ul>
	</ul>
</div>
<div class="main">
	<% for(int i = 0; i < partyList.size(); i++) { %>
	<div id="party">
		<a href="./roomboard?partyno=<%=partyList.get(i).getPartyNo() %>"><%=partyList.get(i).getPartyNo() %><ul>
			<div id="partyKind">
				<%=partyList.get(i).getPartyKind() %>
			</div>
			<div id="partyName">
				<%=partyList.get(i).getPartyName() %>
			</div>
			<hr style="background-color: black; border-style: dashed; width: 100px;">
			<li>파티장 : <%=partyList.get(i).getPartyLeader() %></li>
			<li>파티 만료일 : <%=partyList.get(i).getPartyEnddate() %></li>
			<li>모집 인원 : <%=partyList.get(i).getPartyMember() %></li>
			<hr style="background-color: black; border-style: dashed; width: 150px;">
			<li>참여 금액 : <%=partyList.get(i).getPaymentamount() %> 원</li>
		</ul></a>
	</div>
	<% } %>
</div>

<div class="invitation">
    <input type="button" id="btn" onClick="sendLinkCustom();" value="초대하기"/>
</div>

<div style="text-align: center;">
	<ul class="pagination">
		<% for(int i=paging5.getStartPage(); i <= paging5.getEndPage(); i++) { %>
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


<%@ include file="../layout/footer.jsp" %>