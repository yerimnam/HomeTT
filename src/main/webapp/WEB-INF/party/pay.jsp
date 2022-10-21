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
         merchant_uid: "<%=party.getPartyNo() %>",
         name: "HomeTT",
         amount: <%=party.getPaymentAmount()%>,
         buyer_email: "<%=member.getUserEmail()%>",
         buyer_name: "<%=member.getUserName()%>",
         buyer_tel: "<%=member.getUserPhone()%>",
         buyer_addr: "서울특별시 강남구 신사동",
         buyer_postcode: "01181",
         m_redirect_url:"homett/complete"
     
     },function (rsp) { // callback
         if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
            
        	 
        	 // jQuery로 HTTP 요청
             jQuery.ajax({
                 url: "/homett/paycomplete", // 예: https://www.myservice.com/payments/complete
                 method: "POST",
                 headers: { "Content-Type": "application/json" },
                 data: {
                     imp_uid: rsp.imp_uid, //결제번호
                     merchant_uid: rsp.merchant_uid,  //주문번호
                     amoun : rsp.amoun
                 }
             }).done(function (data) {
            	 switch(data.status) {
                 case: "vbankIssued":
                   // 가상계좌 발급 시 로직
                   break;
                 case: "success":
                   // 결제 성공 시 로직
                   break;
               }
             });
           } else {
             alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
        	 console.log(buyer_name)
           }
         });

     //HomeTT 서버 코드
     
     app.use(bodyParser.json());
     ...
     // "/payments/complete"에 대한 POST 요청을 처리
     app.post("/homett/paycomplete", async (req, res) => {
       try {
         const { imp_uid, merchant_uid } = req.body; // req의 body에서 imp_uid, merchant_uid 추출
         ...
         // 액세스 토큰(access token) 발급 받기
         const getToken = await axios({
           url: "https://api.iamport.kr/users/getToken",
           method: "post", // POST method
           headers: { "Content-Type": "application/json" }, // "Content-Type": "application/json"
           data: {
             imp_key: "4471785018183236", // REST API 키
             imp_secret: "rGwzfyAZ6DMwEfAhdocdSenuBgh52nOllQudG5TEMiONqlTwXyAfgRBoEKlsTq035VpgUpit3GglzVvq" // REST API Secret
           }
         });
         const { access_token } = getToken.data.response; // 인증 토큰
         ...
         // imp_uid로 아임포트 서버에서 결제 정보 조회
         const getPaymentData = await axios({
           url: `/homett/paycomplete/${"imp41280154"}`, // imp_uid 전달
           method: "get", // GET method
           headers: { "Authorization": access_token } // 인증 토큰 Authorization header에 추가
         });
         const paymentData = getPaymentData.data.response; // 조회한 결제 정보
         // DB에서 결제되어야 하는 금액 조회
         const order = await Orders.findById(paymentData.merchant_uid);
         const amountToBePaid = order.amount; // 결제 되어야 하는 금액
         ...
         // 결제 검증하기
         const { amount, status } = paymentData;
         if (amount === amountToBePaid) { // 결제금액 일치. 결제 된 금액 === 결제 되어야 하는 금액
           await Orders.findByIdAndUpdate(merchant_uid, { $set: paymentData }); // DB에 결제 정보 저장
           ...
           switch (status) {
             case "ready": // 가상계좌 발급
               // DB에 가상계좌 발급 정보 저장
               const { vbank_num, vbank_date, vbank_name } = paymentData;
               await Users.findByIdAndUpdate(<%=member.getUserId()%>, { $set: { vbank_num, vbank_date, vbank_name }});
               // 가상계좌 발급 안내 문자메시지 발송
               SMS.send({ text: \`가상계좌 발급이 성공되었습니다. 계좌 정보 \${vbank_num} \${vbank_date} \${vbank_name}\`});
               res.send({ status: "vbankIssued", message: "가상계좌 발급 성공" });
               break;
             case "paid": // 결제 완료
               res.send({ status: "success", message: "일반 결제 성공" });
               break;
           }
         } else { // 결제금액 불일치. 위/변조 된 결제
           throw { status: "forgery", message: "위조된 결제시도" };
         }
       } catch (e) {
         res.status(400).send(e);
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

<h1>결제하기</h1>
<hr>

<div>
<h3> 주문 사항 </h3>


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

<!-- <div id="userinfo"> -->

<!-- <label>회원 이름</label> -->
<%-- 	<input type="textarea" id="userName" name="userName" placeholder="<%=member.getUserName() %>"> --%>


<!-- </div> -->

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