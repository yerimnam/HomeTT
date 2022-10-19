<%@page import="party.dto.Party"%>
<%@page import="user.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <% Member member = (Member)request.getAttribute("userinfo");%>
   <% Party party = (Party)request.getAttribute("partyinfo");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제하기</title>
<style type="text/css">

body {

	width: 1000px;
	margin:0 auto;
}


table, input{
	width: 1000px;
	height: 200px;
	border: 1px solid black;

}

td {
	text-align: center;	
	

}

</style>




</head>


<header>

	HOME TT
</header>
<body>

<h1>결제 정보</h1>
<hr>

<div>
<h3> 주문 /결제 </h3>

<table id="payinfo" >
	
	<tr>
			<th>회원 아이디</th>
			<th>회원 이름</th>
			<th>파티이름</th>
			<th>파티장 </th>
			<th>참여 금액</th>
	</tr>
	<tr>
		<td><%=member.getUserId() %></td>
		<td><%=member.getUserName() %></td>
		<td><%=party.getPartyName() %></td>
		<td><%=party.getPartyLeader() %></td>
		<td><%=party.getPaymentAmount() %> 원</td>
		
	</tr>

</table>
</div>

<div>
<h3>쿠폰 및 포인트</h3>
	<table id="point_coupon" >
	<tr>
		<th>보유 포인트</th>
		<td>보유 포인트</td>
	</tr>
	<tr>
		<th>쿠폰</th>
		<td>쿠폰</td>
	</tr>

	</table>

</div>


<div>

<h3>총 결제 금액</h3>
	<input type="text" id="payment" >

</div>

<div>
	<button type="button" id="btnpay">결제하기</button>
	<button type="button" id="btnpointcharge">포인트 충전하기</button>


</div>

<footer>

사업자 정보 

</footer>

</body>
</html>