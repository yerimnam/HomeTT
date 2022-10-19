<%@page import="java.util.List"%>
<%@page import="coupon.dto.Coupon"%>
<%@page import="party.dto.Party"%>
<%@page import="user.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <% Member member = (Member)request.getAttribute("userinfo");%>
   <% Party party = (Party)request.getAttribute("partyinfo");  %>
   <%List< Coupon> coupon = (List)request.getAttribute("couponinfo"); %>
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


table, #couponarea{
	width: 1000px;
	height: 200px;
	border: 1px solid black;

}

td {
	text-align: center;	
	

}
#couponarea {
	border: 1px solid black;
	margin-top:210px;
	margin-bottom: 70px;
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

<form  action="/homett/payment" method="post">
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

<h3 style="margin-top:70px;">쿠폰</h3>
<div id="couponarea">

<h2>사용가능 쿠폰</h2>
		
		
	<% for(int i =0; i<coupon.size();i++) { %>
	<input type="checkbox" name="useCoupon" value="useCoupone"	>
		<%=coupon.get(i).getCouponUsable() %>
		
		<%} %>

</div>


<div>

<h3>총 결제 금액</h3>
	<table id="pay">
		<% int totalPayment = party.getPaymentAmount();
		%>
		<tr>
		<th><%=totalPayment %>원</th>
		</tr>
	</table>

</div>

</form>



<div>
	<button type="button" id="btnpay">결제하기</button>
	<button type="button" id="btncancel">취소하기</button>


</div>

<footer>

사업자 정보 

</footer>

</body>
</html>