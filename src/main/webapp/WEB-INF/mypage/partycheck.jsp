<%@page import="java.text.DecimalFormat"%>
<%@page import="util.Paging5"%>
<%@page import="partyCheck.dto.PartyCheck"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<PartyCheck> partyList = (List) request.getAttribute("partyList"); %>
<% List<PartyCheck> ownerPartyList = (List) request.getAttribute("ownerPartyList"); %>
<% Paging5 paging5 = (Paging5) request.getAttribute("paging"); %>
<% DecimalFormat format = new DecimalFormat("###,###"); %>
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
	padding-left: 455px;
}

.situation h4 {
	color: #1E3269;
	font-weight: 700;
}

.invitation {
	display: flex;
	justify-content: center;
}

#party_My {
	/* width: 240px; */
	height: 270px;
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
	margin-top: 5px;
	text-align: center; 
	border-radius: 5px;
}

#partyName {
	text-align: center; 
	margin: 5px; 
	margin-top: 15px;
}

#party_My ul {
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
#listHover:link{
	color: black;
	background-color: #fffcee; 
    transition : 0.5s; /* 속성 변경할 때 효과의 속도 조절 */
}
#listHover:visited{
	color: black;
	background-color: #fffcee; 
}
#listHover:hover { 
	color: #ff8022;
	background-color: #eff2e0; 
	text-decoration: none;
}
#listHover:active {
	color: black;
	background-color: #fffcee; 
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
	font-weight: 700;
	font-size: medium;
	width: 210px;
	height: 40px;
}

#btn:hover {
/* 	color: #a9cd72; */
	color: #ff8c11;
/* 	background-color: #ffeaa6; */
	background-color: #fffcee;
	transition: 1s;
	
}

</style>

<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidemenu.jsp" %>
<body>

<div id="topMain" style="margin-top: 40px; margin-left: 70px;">
	<div class="situation">
		<h4>가입한 파티 목록</h4>
	</div>
	<hr align="center" style=" height: 1px; background-color: black; width: 55%;">
	
	<!--     <input type="button" onClick="sendLinkDefault();" value="친구선택"/> -->
	
	<script type="text/javascript">
	    function sendLinkCustom() {
	        Kakao.init("5e3445a388e682bf93a131b9d9a3a8e2");
	        Kakao.Link.sendCustom({
	            templateId: 84625 
	        });
	    }
	</script>
	
	
	
	<div class="main">
		<% for(int i = 0; i < ownerPartyList.size(); i++) { %>
		<div id="party_My">
			<a id="listHover" href="./roomboard?partyno=<%=partyList.get(i).getPartyNo() %>"><ul>
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
				<li>참여 금액 : <%=format.format(ownerPartyList.get(i).getPaymentamount())%> 원</li>
			</ul></a>
		</div>
		<% } %>
	</div>
	
	<div class="invitation">
	    <input type="button" id="btn" onClick="sendLinkCustom();" value="초대하기"/>
	</div>
	
	
	
	
	<div id="topMain" style="margin-top: 40px; margin-left: 70px;">
	<div class="situation" style="padding-left: 388px;">
		<h4>전체 파티 목록</h4>
	</div>
	<hr align="center" style=" height: 1px; background-color: black; width: 62%;">
	
	
	<div id="submenu">
		<ul>
		</ul>
	</div>
	<div class="main">
		<% for(int i = 0; i < partyList.size(); i++) { %>
		<div id="party_My">
			<a id="listHover" href="partyroomdetail?partyNo=<%=partyList.get(i).getPartyNo() %>"><ul>
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
				<li>참여 금액 : <%=format.format(partyList.get(i).getPaymentamount())%> 원</li>
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