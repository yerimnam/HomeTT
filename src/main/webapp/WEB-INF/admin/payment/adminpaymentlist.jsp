<%@page import="java.text.DecimalFormat"%>
<%@page import="util.PbPaging"%>
<%@page import="admin.payment.dto.Payment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	List<Payment> paymentList = (List) request.getAttribute("paymentList"); %>
<%	DecimalFormat format = new DecimalFormat("###,###"); %>

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

<div style="margin: 30px 0; margin-left: 360px;">
	<h1>결제 관리 - 전체 결제 내역</h1>
</div>
<div style="margin: -50px 0 0 1450px;">
	<button class="btn btn-info">
		<a style="color: white;" href='https://classic-admin.iamport.kr/' target="_blank">
			아임포트 접속</a></button>
</div>

<table style="width: 1200px; margin-top: 20px;" class="table table-striped table-hover table-condensed">
	<tr>
		<th style="width: 10%; text-align: center">결제 번호</th>
		<th style="width: 30%; text-align: center">주문 번호</th>
		<th style="width: 10%; text-align: center">결제 날짜</th>
		<th style="width: 10%; text-align: center">회원 번호</th>
		<th style="width: 10%; text-align: center">파티 번호</th>
		<th style="width: 15%; text-align: center">결제 수단</th>
		<th style="width: 15%; text-align: center">결제 금액</th>
	</tr>
	
	<%	for(int i=0; i<paymentList.size(); i++) { %>
	<tr>
		<td name="payNo"><%=paymentList.get(i).getPayNo() %></td>
		<td><%=paymentList.get(i).getOrderNo() %></td>
		<td><%=paymentList.get(i).getPaymentDate() %></td>
		<td><%=paymentList.get(i).getUserNo() %></td>
		<td><a href="./partyroomdetail?partyNo=<%=paymentList.get(i).getPartyNo() %>"><%=paymentList.get(i).getPartyNo() %></td>
		<td><%=paymentList.get(i).getPaymentMethod() %></td>
		<td><%=format.format(paymentList.get(i).getPaymentAmount())%>원</td>
	</tr>
	<%	} %>
</table>

<%@ include file="../layout/paymentpaging.jsp" %>

<%@ include file="../layout/paymentsearch.jsp" %>

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