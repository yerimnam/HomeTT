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



$(function(){
	
	$("#btnchkpay").on("click",chkpaymentlist);
	
})


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
	<button type="button" id="btnchkpay" > 조회 </button> 
<hr>


<!--데이트 피커  --> 
<!--  	<input type="text" id="startDate" name="startDate"placeholder="시작날짜선택해주세요">  -->
<!-- 	<span>~</span>	 -->
<!-- 	<input type="text" id="endDate" name="endDate"placeholder="끝 날짜를 선택해주세요"> -->
  

</div>

<div id="paymentlist"></div>




</body>
</html>