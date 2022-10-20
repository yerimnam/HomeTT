<%@page import="java.util.List"%>
<%@page import="coupon.dto.Coupon"%>
<%@page import="party.dto.Party"%>
<%@page import="user.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <% Member member = (Member)request.getAttribute("userinfo");%>
   <% Party party = (Party)request.getAttribute("partyinfo");  %>
   <%List< Coupon> coupon = (List)request.getAttribute("couponinfo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제하기</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js" ></script>
  <!-- iamport.payment.js -->
 <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
 
 
 <script type="text/javascript">
 

	//결제 준비하기
	 var IMP = window.IMP; // 생략 가능
 IMP.init("imp41280154"); 
	 
 function requestPay() {
     // IMP.request_pay(param, callback) 결제창 호출
     IMP.request_pay({ // param
         pg: "html5_inicis",
         pay_method: "card",
         merchant_uid: "ORD20180131-0000011",
         name: "HomeTT",
         amount: 8000,
         buyer_email: "dpfla725@naver.com",
         buyer_name: "남예림",
         buyer_tel: "010-3507-42177",
         buyer_addr: "서울특별시 강남구 신사동",
         buyer_postcode: "01181"
     },function (rsp) { // callback
         if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
             // jQuery로 HTTP 요청
             jQuery.ajax({
                 url: "{/homett/paymodule}", // 예: https://www.myservice.com/payments/complete
                 method: "POST",
                 headers: { "Content-Type": "application/json" },
                 data: {
                     imp_uid: rsp.imp_uid,
                     merchant_uid: rsp.merchant_uid
                 }
             }).done(function (data) {
                 // 가맹점 서버 결제 API 성공시 로직
             })
           } else {
             alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
           }
         });

 }
 
 
 
 </script>


<style type="text/css">

body {

	width: 1000px;
	margin:0 auto;
}
span{
	padding: 7px;
	maring: 50px;
}

table, #payment{
	width: 1000px;
	height: 200px;
	border: 1px solid black;

}

td {
	text-align: center;	
	

}
#payment {
	border: 1px solid black;
	margin-top:20px;
	margin-bottom: 70px;
	text-align: center;
}

</style>




</head>


<body>
<header>

	HOME TT
</header>

<h1>결제 정보</h1>
<hr>

<div>
<h3> 주문 /결제 </h3>


<table id="payinfo" >
	
	<tr>
			<th>회원 아이디</th>
			<th>회원 이름</th>
			<th>파티이름</th>
			<th>파티장 </th>
			<th>참여 금액</th>
	</tr>
	<tr>
		<td><%=member.getUserId() %></td>
		<td><%=member.getUserName() %></td>
		<td><%=party.getPartyName() %></td>
		<td><%=party.getPartyLeader() %></td>
		<td id="partypayment"><%=party.getPaymentAmount() %> 원</td>
		
	</tr>

</table>
</div>


<form  action="/homett/payment" method="post">

<div>
<h3>총 결제 금액</h3>
</div>

<div id="payment">

   <span id="willpay">결제할 금액 </span>
   
	<span id="totalPayment"> <%=party.getPaymentAmount() %>원</span>



</div>

</form>



<div>
	<button type="button" id="btnpay" onclick="requestPay()">결제하기</button>
	<button type="button" id="btncancel">취소하기</button>


</div>

<footer>

사업자 정보 

</footer>

</body>
</html>