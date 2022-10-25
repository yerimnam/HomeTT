<%@page import="util.PbPaging"%>
<%@page import="payment.dto.Payment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		console.log($("#paymentlist").val());
		
	})
	
	
	
	
	
});


// $(function(){
	
// 	$("#btnchkpay").on("click",chkpaymentlist);
	
// })

// function chkpaymentlist(){
	
		
// 	$.ajax( {
		
// 		url : "/homett/paymentlist",
// 		type : "post",
// 		data: { //요청 파라미터
// 			startdate : $("#startdate").val(),
// 			enddate : $("#enddate").val(),
		
// 		}
// 		,dataType : "html"
// 		, success : function(res) {
// 			console.log("성공");
// 			$("#paymentlist").html(res)
			
// 		}, error : function() {
			
// 			console.log("실패 ");
// 			$("#paymentlist").html("결제내역이 없습니다")
			
// 		}
	

// });
	
// }








</script>






<style type="text/css">

body {
	width: 1600px;
	margin: 0 auto;

}

</style>

</head>
<body>



<h2>결제내역 조회하기</h2>
<hr>

<div id="selectdate">
 <form action="/homett/paymentlist" method="post" id="paymentlist" name="paymentlist">
 
	<input type="date" id="startdate" name="startdate" > 
	<input type="date" id="enddate" name="enddate"   > 
	<button type="button" id="btnchkpay" onclick="chkpaymentlist()"> 조회 </button> 

</form>
</div>
<div id="paymentlist"></div>


</body>


<div class="text-center">
   <ul class="pagination">
   
      <%-- 첫 페이지로 이동 --%>
      <%   if( paging.getCurPage() != 1) { %>
      <li><a href="/homett/paymentlist" id="firstlist">&larr;처음</a></li>
      <%  } %>
      
   
      <%-- 이전 페이지로 이동 --%>
      <%   if( paging.getCurPage() != 1) { %>
      <li><a href="/homett/paymentlist?curPage=<%=paging.getCurPage() - 1 %>" id="beforelist">&lt;</a></li>
      <%   } %>
   
   
      <%   for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
      <%      if( i == paging.getCurPage() ) { %>
      <li class="active"><a href="/homett/paymentlist?curPage=<%=i %>" id="curpage"><%=i %></a></li>
      <%      } else { %>
      <li><a href="/homett/paymentlist?curPage=<%=i %>"><%=i %></a></li>
      <%      } %>
      <%   } %>
      
      <%-- 다음 페이지로 이동 --%>
      <%   if( paging.getCurPage() != paging.getTotalPage() ) { %>
      <li><a href="/homett/paymentlist?curPage=<%=paging.getCurPage() + 1 %>" id="nextpage">&gt;</a></li>
      <%   } %>
      
      <%-- 마지막 페이지로 이동 --%>
      <%   if( paging.getCurPage() != paging.getTotalPage() ) { %>
      <li><a href="/homett/paymentlist?curPage=<%=paging.getTotalPage() %>" id="lastpage">&rarr;끝</a></li>
      <%   } %>
      
   </ul>
</div>

</html>