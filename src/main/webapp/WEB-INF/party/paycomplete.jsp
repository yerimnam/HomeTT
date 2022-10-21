<%@page import="payment.dto.Payment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <% Payment paycomplete =(Payment)request.getAttribute("paycomplete");  %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

body {

	width: 1000px;
	margin:0 auto;
}


</style>


</head>
<body>



<h2>결제 성공</h2>
<hr>

<h3>결제내역</h3>

<div>
<span>이름 : </span>
<span><%=paycomplete.getUserName() %>
</span>
</div>

<div>

<span>결제일자 : </span>
<span><%=paycomplete.getPaymentDate() %></span>

</div>


<div>
	<span>결제 내용 </span>
	<span> <%=paycomplete.getPartyName() %></span>
</div>

<div>
	<span>결제 금액</span>
	<span><%=paycomplete.getPaymentAmount() %></span>
</div>

<button type="button">메인으로</button>

</body>
</html>