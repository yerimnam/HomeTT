<%@page import="util.Paging5"%>
<%@page import="wishListCheck.dto.WishListCheck"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<WishListCheck> wishList = (List) request.getAttribute("wishList"); %>
<%-- <% Paging5 paging5 = (Paging5) request.getAttribute("paging"); %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wish List Check</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');
* {
	font-family: SUIT;
}


.main {
	display: flex;
	justify-content: center;
	margin-top: 40px;
/* 	margin-bottom: 50px; */
	gap: 30px;	
}

.situation {
	padding-top: 20px;
	padding-left: 430px;
}

#wishlist {
	display: flex;
	width: 210px;
/* 	height: 250px; */
/* 	margin: 20px; */
	border-radius: 5px;
	padding-bottom: 20px;
	background-color: #eff2e0;
	border: 1px solid #e5dcb1;
			
}

#wishlist ul {
	text-align: center;
	padding-left: 30px;
	padding-bottom: 20px;
}

#partyKind {
	border: 1px solid #585a72; 
	height: 45px; 
	padding-top:10px; 
	text-align: center; 
	margin-top: 10px; 
	border-radius: 5px;
}

#partyName {
	text-align: center; 
	margin: 5px; 
	margin-top: 15px;
}


li {
    flex-direction: row;
    list-style: none; 
    margin: 0px; 
    font-weight: 300;
}

a {
	text-decoration: none !important;
	color: black;
	font-weight: bold;
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





</style>

<%@ include file="../layout/header.jsp" %>

<body>


<div class="situation">
<h4>찜 목록 조회</h4>
</div>
<hr align="center" style=" height: 1px; background-color: black; width: 60%;">


<div class="main">
	<% for(int i = 0; i < wishList.size(); i++) { %>
	<div id="wishlist">
		<a href="./roomboard?partyno=<%=wishList.get(i).getPartyNo() %>"><%=wishList.get(i).getPartyNo() %><ul>
			<div id="partyKind">
				<%=wishList.get(i).getPartyKind() %>
			</div>
			<div id="partyName">
				<%=wishList.get(i).getPartyName() %>
			</div>
			<hr style="background-color: black; border-style: dashed; width: 100px;">
			<li>파티장 : <%=wishList.get(i).getPartyLeader() %></li>
			<li>파티 만료일 : <%=wishList.get(i).getPartyEnddate() %></li>
			<li>모집 인원 : <%=wishList.get(i).getPartyMember() %></li>
			<hr style="background-color: black; border-style: dashed; width: 150px;">
			<li>참여 금액 : <%=wishList.get(i).getPaymentamount() %> 원</li>
		</ul></a>
	</div>
	<% } %>
</div>

<%-- <div style="text-align: center;">
	<ul class="pagination">
		<% for(int i=paging5.getStartPage(); i <= paging5.getEndPage(); i++) { %>
		<li><a href="./partycheck?curPage=<%=i %>"><%=i %></a></li> <!-- 파티장으로 참여중인 페이징 -->
		<% } %>
	</ul>
</div> --%>


<%@ include file="../layout/footer.jsp" %>