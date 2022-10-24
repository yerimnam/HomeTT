<%@page import="util.PbPaging"%>
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

// $(document).ready(function(){

// 	$("#btnchkpay").click(function(){
	
// // 		$("#paymnetlist").submit();
// 		$(this).parents("form").submit();
// 		console.log($("#paymentlist").val());
		
// 	})
	
	
	
	
	
// });


// $(function(){
	
// 	$("#btnchkpay").on("click",chkpaymentlist);
	
// })

function chkpaymentlist(){
	
		
	$.ajax( {
		
		url : "/homett/paymentlist",
		type : "post",
		data: { //요청 파라미터
			startdate : $("#startdate").val(),
			enddate : $("#enddate").val()
			
		}
		,dataType : "html"
		, success : function(res) {
			console.log("성공");
			$("#paymentlist").html(res)
			
		}, error : function() {
			
			console.log("실패 ");
			$("#paymentlist").html("결제내역이 없습니다")
			
		}
	

});
	
}








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
	<input type="date" id="startdate" name="startdate" > 
	<input type="date" id="enddate" name="enddate"   > 
	<button type="button" id="btnchkpay" onclick="chkpaymentlist()"> 조회 </button> 

</div>
<div id="paymentlist"></div>

<!-- <form action="/homett/paymentlist" method="post" id="paymentlist" name="paymentlist"> -->
<!-- </form> -->

</body>
</html>