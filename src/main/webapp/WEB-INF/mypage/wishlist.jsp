<%@page import="wishListCheck.dto.WishListCheck"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<WishListCheck> wishList = (List) request.getAttribute("wishList"); %>

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
	display: flex;
	padding-top: 20px;
	padding-left: 260px;
}

#wishlist {
	display: flex;
	width: 230px;
/* 	height: 250px; */
/* 	margin: 20px; */
	padding-bottom: 20px;
	border: 1px solid #000;		
}

#wishlist ul {
	padding-left: 15px;
	padding-bottom: 20px;
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
찜 목록 조회
</div>
<hr align="center" style=" height: 1px; background-color: black; width: 75%;">


<div class="main">
	<% for(int i = 0; i < wishList.size(); i++) { %>
	<div id="wishlist">
		<a href="./roomboard?partyno=<%=wishList.get(i).getPartyNo() %>"><%=wishList.get(i).getPartyNo() %><ul>
			<div style="border: 1px solid #000; text-align: center; margin-top: 10px; border-radius: 5px;">
				<%=wishList.get(i).getPartyKind() %>
			</div>
			<div style="text-align: center; margin: 5px; margin-top: 15px;">
				<%=wishList.get(i).getPartyName() %>
			</div>
			<hr style="height: 1px; background-color: black;">
			<li>파티장 : <%=wishList.get(i).getPartyLeader() %></li>
			<li>파티 만료일 : <%=wishList.get(i).getPartyEnddate() %></li>
			<li>모집 인원 : <%=wishList.get(i).getPartyMember() %></li>
			<hr style="height: 1px; background-color: black;">
			<li>참여 금액 : <%=wishList.get(i).getPaymentamount() %> 원</li>
		</ul></a>
	</div>
	<% } %>
</div>


<%@ include file="../layout/footer.jsp" %>