<%@page import="util.PbPaging"%>
<%@page import="payment.dto.Payment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ include file="../layout/header.jsp"  %>
    
 
 <% List<Payment> paymentList = (List)request.getAttribute("paymentList"); %>
 <% PbPaging paging = (PbPaging)request.getAttribute("paging"); %>
 
 
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

$(document).ready(function(){

	$("#btnchkpay").click(function(){
	
// 		$("#paymnetlist").submit();
		$(this).parents("form").submit();
		
	})
	
	
		
	
});








</script>






<style type="text/css">

body {
	width: 1600px;
	margin: 0 auto;

}

#title{

	width: 500px;
    position: relative;
    top: 80px;
    left: 530px;
    font-size: 50px;
    color: #ffd925;
}

#selectdate{
	position: relative;
    top: 113px;

}

#selectdate span{
	font-size: 30px;
    position: absolute;
    left: 214px;
}
#paymentlist{
   position: absolute;
    top: 0px;
    left: 1000px;
}

#startdate, #enddate{

    padding: 0 20px;
    margin-right: 56px;
    font-size: 19px;
    color: #666666;
    border:1px solid #666666;

}

#startdate:hover, #enddate:hover{

	color: #ff8c11 ;
}
.text-center{

    position: relative;
    top: 600px;
}

}

</style>

</head>
<body>

	
	<div id="title">
		<span>결제내역 조회하기</span>
	</div>
	
	<div id="selectdate">
	 <form action="/homett/paymentlist" method="get" id="paymentlist" name="paymentlist">
	 
		<input type="date" id="startdate" name="startdate" > 
		<span>~</span>
		<input type="date" id="enddate" name="enddate"   > 
		<button type="button" id="btnchkpay" onclick="chkpaymentlist()"> 조회 </button> 
	
	</form>
	</div>
	
	<div id="payresult">
	
	<table>
		<thead>
			<tr>
				<th>주문번호</th>
				<th>결제 날짜</th>
				<th>Party 이름</th>
				<th>결제수단</th>
				<th>결제금액</th>
			</tr>
		</thead>
		
		<tbody>
		
			<% for(int i=0; i<paymentList.size(); i++)  {%>
				<tr>  
					<td><%=paymentList.get(i).getOrderNo() %></td>
					<td><%=paymentList.get(i).getPaymentDate() %></td>
					<td><%=paymentList.get(i).getPartyName() %></td>
					<td><%=paymentList.get(i).getPaymentMethod() %></td>
					<td><%=paymentList.get(i).getPaymentAmount() %></td>
			 	</tr>  
					
			<%} %>
			
	 	</tbody>	 
	
	</table>
	
	</div>
	
	
	
	
	<%	String start = request.getParameter("startdate")==null ?"" :"&startdate="+request.getParameter("startdate") ;
		String end = request.getParameter("enddate")==null ?"" :"&enddate="+request.getParameter("enddate");
	%>
	
	
	
	
	<div class="text-center">
	   <ul class="pagination">
	   
	      <%-- 첫 페이지로 이동 --%>
	      <%   if( paging.getCurPage() != 1) { %>
	      <li><a href="/homett/paymentlist?curPage=1<%=start %><%=end %>" id="firstlist">&larr;처음</a></li>
	      <%  } %>
	      
	   
	      <%-- 이전 페이지로 이동 --%>
	      <%   if( paging.getCurPage() != 1) { %>
	      <li><a href="/homett/paymentlist?curPage=<%=paging.getCurPage() - 1 %><%=start %><%=end %>" id="beforelist">&lt;</a></li>
	      <%   } %>
	   
	   
	      <%   for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
		      <%      if( i == paging.getCurPage() ) { %>
		      <li class="active"><a href="/homett/paymentlist?curPage=<%=i %><%=start %><%=end %>" id="curpage"><%=i %></a></li>
		      <%      } else { %>
		      <li><a href="/homett/paymentlist?curPage=<%=i %><%=start %><%=end %>"><%=i %></a></li>
		      <%      } %>
		      <%   } %>
	      
	      <%-- 다음 페이지로 이동 --%>
	      <%   if( paging.getCurPage() != paging.getTotalPage() ) { %>
	      <li><a href="/homett/paymentlist?curPage=<%=paging.getCurPage() + 1 %><%=start %><%=end %>" id="nextpage">&gt;</a></li>
	      <%   } %>
	      
	      <%-- 마지막 페이지로 이동 --%>
	      <%   if( paging.getCurPage() != paging.getTotalPage() ) { %>
	      <li><a href="/homett/paymentlist?curPage=<%=paging.getTotalPage() %><%=start %><%=end %>" id="lastpage">&rarr;끝</a></li>
	      <%  } %>
	      
	   </ul>
	</div>

</body>
</html>