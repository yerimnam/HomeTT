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


// // $(function(){
// //    $('#datepicker').datepicker();
  
   
// // })

// function getFormatDate(startdate){
//     var year = startdate.getFullYear();              //yyyy
//     var month = (1 + startdate.getMonth());          //M
//     month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
//     var day = startdate.getDate();                   //d
//     day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
//     return  year + '/' + month + '/' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
// }

// function getFormatDate(enddate){
//     var year = enddate.getFullYear();              //yyyy
//     var month = (1 + enddate.getMonth());          //M
//     month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
//     var day = enddate.getDate();                   //d
//     day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
//     return  year + '/' + month + '/' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
// }

// function chkpay(){
	
// // 	var startdate = $('#startdate').val();
// // 	var enddate = $('#enddate').val()
// // 	console.log(startdate)
// // 	console.log(enddate)



// 	var startdate = new Date($('#startdate').val());
// 	startdate = getFormateDate();

// 	var enddate = new Date($('#enddate').val());
// 	enddate = getFormateDate(enddate);
	
// 	$.ajax( {
		
// 			url : "/homett/paymentlistview",
// 			type : "post",
// 			data: { //요청 파라미터
// 				startdate : startdate,
// 				enddate : enddate
				
// 			}
// 			,dataType : "html"
// 			, success : function(res) {
// 				console.log("성공");
// 				$("#paymentlist").html(res)
				
// 			}, error : function() {
				
// 				console.log("실패 ");
// 				$("#paymentlist").html("결제내역이 없습니다")
				
// 			}
		
	
// 	});
	
// }



$(document).ready(function(){
	
	$("#btnchkpay").click(function(){
		
		$("#selectdate_form").submit();
		console.log("클릭")
		
		
		
		
		
	});
	

})





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
<form action ="<%=request.getContextPath() %>/homett/paymentlist" method ="post" id="selectdate_form">
	<input type="date" id="startdate" >
	<input type="date" id="enddate"   >
	<button type="button" id="btnchkpay" > 조회 </button> 
<hr>


<!-- 데이트 피터 -->
<!-- <input type="text" id="datepicker" placeholder="날짜선택해주세요"> -->
  
</form>

</div>
<div >


게시판 영역
<table>
	<thead>
		<tr>
			<th>결제번호</th>
			<th>주문번호</th>
			<th>회원번호</th>
			<th>결제수단</th>
			<th>결제금액</th>
		</tr>
	</thead>
<!-- 	<tbody  id="paymentlist">  -->
<%-- 	<% for(int i=0; i<paymentList.size();i++)  {%> --%>
<!-- 	<tr> -->
<%-- 		<td><%=paymentList.get(i).getPayNo() %></td> --%>
<%-- 		<td><%=paymentList.get(i).getOrderNo() %></td> --%>
<%-- 		<td><%=paymentList.get(i).getUserNo() %></td> --%>
<%-- 		<td><%=paymentList.get(i).getPaymentMethod() %></td> --%>
<%-- 		<td><%=paymentList.get(i).getPaymentAmount() %></td> --%>

<!-- 	</tr> -->
	
	
<%-- <%} %>	 --%>
 </tbody>	 
	

</table>



</div>





</body>
</html>