<%@page import="partyCheck.dto.PartyCheckOwner"%>
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
	display: flex;
	padding-top: 20px;
	padding-left: 320px;
	margin-bottom: -15px;
}

.situation h4 {
	color: #1E3269;
	font-weight: 700;
}

.invitation {
	display: flex;
	justify-content: center;
}

#party {
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
	color: #ffd925;
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
	width: 195px;
	height: 40px;
}

#btn:hover {
	color: #a9cd72;
	background-color: #ffeaa6;
}

</style>

<%@ include file="../layout/header.jsp" %>

<body>


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

<!-- <div style="width: 240px; text-align: center; "> -->
<!-- <span style="width: 240px; font-weight: 900; font-size: x-large; color: #ff8c11; ">반갑습니다 000님</span><br> -->
<!-- <span style="width: 240px; font-weigth: 600; font-size: large; color: #ff8c11 ">ID : Trevi</span> -->
<!-- </div><br> -->

<%-- <%@ include file="../layout/sidemenu.jsp" %> --%>

<div id="test" style="margin-top: -130px;">
<div class="situation">
	<h4>내 정보</h4>
</div>
<hr align="center" style=" height: 1px; background-color: black; width: 60%;">

<div style=" display: flex; justify-content: center;">
<div style="border: 1px solid black; width: 830px; padding: 10px; height: 210px; background-color: #fffcee;
	font-weight: 600; font-size: medium; color: #1E3269;">
<span><%=session.getAttribute("userNick") %>님,환영합니다</span>
<span>이메일 :  <%=session.getAttribute("userEmail") %></span>
<span>아이디 :  <%=session.getAttribute("userId") %></span>
<span>이름 :  <%=session.getAttribute("userName") %></span>
<span>가입한 파티방 수 :  <%=ownerPartyList.size() %></span>
</div>
</div><br><br><br><br>


<div class="situation">
	<h4>가입한 파티</h4>
</div>
<hr align="center" style=" height: 1px; background-color: black; width: 60%;">

<div class="main">
	<% for(int i = 0; i < ownerPartyList.size(); i++) { %>
	<div id="party">
		<a href="./roomboard?partyno=<%=partyList.get(i).getPartyNo() %>"><ul>
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
		</ul></a>
	</div>
	<% } %>
</div>

<div class="invitation">
    <input type="button" id="btn" onClick="sendLinkCustom();" value="초대하기"/>
</div>

<div style=" display: flex; justify-content: center; gap: 50px; text-align: center; height: 120px; border: 1px solid white;
	padding-top: 30px; margin-top: 105px; margin-bottom: -145px;">
	<div style="border: 1px solid black; width: 220px; height: 90px; padding-top: 9px; 	border-radius: 5px;
		border: 1px solid #ff8c11; background-color: #fffcee;">
	<a href="./noticelist"><span style="font-size: medium; font-weight: 400">공지사항을 먼저 확인해주세요</span><br><br>
	<span style="font-size: large; font-weight: 600">공지사항 보러가기</span></a>
	</div>
	
	<div style="border: 1px solid black; width: 220px; height: 90px; padding-top: 9px;	border-radius: 5px;
		border: 1px solid #ff8c11; background-color: #fffcee;">
	<a href="./faqview"><span style="font-size: medium; font-weight: 400">궁금한 사항이 있으시나요?</span><br><br>
	<span style="font-size: large; font-weight: 600">FAQ 보러가기</span></a>
	</div>
</div>

</div> <!-- test div -->


<%@ include file="../layout/footer.jsp" %>