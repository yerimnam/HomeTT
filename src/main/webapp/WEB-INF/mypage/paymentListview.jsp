<%@page import="payment.dto.Payment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <% List<Payment> paymentList = (List)request.getAttribute("paymentList"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!--jQuery 2.2.4.CDN  -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- jQuery UI 1.13.2 DN  -->
<script type="text/javascript" src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>


<!-- jQuery UI Base Theme CDN  -->
<link type="text/css" rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">

<script type="text/javascript">

</script>
</head>
<body>



<div >


게시판 영역
<table>
	<thead>
		<tr>
			<th>주문번호</th>
			<th>결제 날짜</th>
			<th>회원번호</th>
			<th>결제수단</th>
			<th>결제금액</th>
		</tr>
	</thead>
<!-- <!-- 	<tbody  id="paymentlist">  --> 
	<% for(int i=0; i<paymentList.size();i++)  {%>
	<tr>  
		<td><%=paymentList.get(i).getOrderNo() %></td>
		<td><%=paymentList.get(i).getPaymentDate() %></td>
		<td><%=paymentList.get(i).getUserNo() %></td>
		<td><%=paymentList.get(i).getPartyName() %></td>
		<td><%=paymentList.get(i).getPaymentMethod() %></td>
		<td><%=paymentList.get(i).getPaymentAmount() %></td>

 	</tr>  
	
	


<%} %>	
  </tbody>	 

</table>



</div>


</body>
</html>