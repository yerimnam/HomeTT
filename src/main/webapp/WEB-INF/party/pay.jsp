<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제하기</title>
<style type="text/css">




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
<body>

<h1>결제 정보</h1>
<hr>

<div>
<h3> 주문 /결제 </h3>

<table id="payinfo" >
	
	<tr>
			<th>파티이름</th>
			<th>파티장</th>
			<th>파티 만료일</th>
			<th>모집 인원</th>
			<th>참여 금액</th>
	</tr>
	<tr>
		<td>파티이름</td>
		<td>파티장</td>
		<td>파티 만료일</td>
		<td>모집 인원</td>
		<td>참여 금액</td>
		
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

</body>
</html>