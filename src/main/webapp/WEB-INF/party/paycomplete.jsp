<%@page import="payment.dto.Payment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
    <%@page import="java.text.SimpleDateFormat" %>
    
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

<span>닉네임 : </span>
<span><%=paycomplete.getUserNick() %>
</span>
</div>
<div>

<span>이메일 : </span>
<span><%=paycomplete.getUserEmail() %>
</span>
</div>
<div>

<span>가입 PARTY : </span>
<span><%=paycomplete.getPartyName() %>
</span>
</div>




<div>

<span>결제일자 : </span>

<span><%=paycomplete.getPaymentDate()%></span>

</div>

<div>

<span>결제카드 정보 : </span>

<span><%=paycomplete.getUserCardCom()%></span>

</div>



<div>
	<span>결제 금액</span>
	<span><%=paycomplete.getPaymentAmount() %></span>
</div>

<button type="button">메인으로</button>

</body>
</html>