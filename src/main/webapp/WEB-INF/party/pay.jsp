<%@page import="java.text.DecimalFormat"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.util.List"%>
<%@page import="party.dto.Party"%>
<%@page import="user.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="../layout/header.jsp"  %> 
    
   <% Member member = (Member)request.getAttribute("userinfo");%>
   <% Party party = (Party)request.getAttribute("partyinfo");  %>
   
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
 IMP.init("imp41280154"); 
	 	var paid_at = new Date();
	 	
	
 function requestPay() {

     // IMP.request_pay(param, callback) 결제창 호출
     IMP.request_pay({ // param
         pg: "html5_inicis",
         pay_method: "card",
         merchant_uid : 'merchant_' +  new Date().getTime(),
          name: "HomeTT",
          paid_at: paid_at,
          
         buyer_email: "<%=member.getUserEmail()%>",
         buyer_name: "<%=member.getUserName()%>",
         amount: <%=party.getPaymentAmount()%>,
         buyer_tel: "<%=member.getUserPhone()%>",
         user_no:<%=member.getUserNo()%>
     
     },function (rsp) { // callback
    	 
    	 console.log(rsp)
         if (rsp.success) { // 결제 성공 시: 
				

        	 
				console.log('결제성공')
				console.log('paycomplete 로 DB에 저장할 정보를 전달함 ')
				
        	 // jQuery로 HTTP 요청
             jQuery.ajax({
                 url: "/homett/paycomplete", // 예: https://www.myservice.com/payments/complete
                 method: "post", // POST method
//                  headers: { "Content-Type": "application/json" },
                 headers: { "Content-Type": "application/x-www-form-urlencoded" },
     
                 data: {
                	 
                	 //rsp == 아임포트 결제 결과 정보
                     imp_uid: rsp.imp_uid, //결제번호
                     merchant_uid: rsp.merchant_uid,  //주문번호
                	 pay_method: rsp.pay_method, //결제수단
                	 card_name:rsp.card_name, //카드 이름
                	 card_number:rsp.card_number,//카드 번호 
                	 paid_at:rsp.paid_at ,//결제 시각

                	 //개발 사이트 정보?
                	paid_amount: <%=party.getPaymentAmount()%>, //결제 금액
                     party_no : <%=party.getPartyNo() %>, //파티 넘버
                	 user_no: <%=member.getUserNo() %>,//유저 번호
                	 user_email: '<%=member.getUserEmail() %>', //이메일
                	 user_name: '<%=member.getUserName() %>', //유저이름
                	 user_phone: '<%=member.getUserPhone() %>' //유저 전화번호
                     
                 }
                 , dataType: "html"
         		, success: function( result ) {
         			console.log('결제 정보 DB저장 AJAX 성공')
         			
         			//결제 정보 DB에 저장 성공하면 수행할 작업 작성
         			//	-> 리다이렉트?
         			
         					$("#pay").css("display","none"),
         					$("#payresult").html(result)
         					
         		}
         		, error: function() {
         			console.log('결제 정보 DB저장 AJAX 실패')
         		}

             });	 
//             	 
				
           } else {
             alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
        		console.log('결제 실패 ')
             console.log(buyer_name)
           }
           
         });
     
	}
     

     

 
 </script>


<style type="text/css">

@import url('https://webfontworld.github.io/sunn/SUIT.css');
html, body, pre, h1, h2, h3, h4, h5, h6, dl, dt, dd, ul, li, ol, th, td, p, blockquote, form, fieldset, legend, menu, nav, section, hgroup, article, header, aside, footer, input, select, textarea, button {
    margin: 0;
    padding: 0;
    font-family: 'SUIT';
}
#payresult {

	height: 0;
}
div{

	height: 300px;
	width: 1600px;
}

table{

	text-decoration: none;
}

footer{
	border: 1px solid black;
    position: relative;
    top: 1300px;
  }


#pay{
	position: relative;
	 margin: 0 auto;
}


#partyinfotitle{

	width: 200px;
    height: 58px;
    text-align: center;
    background-color: #ffd925;
    border-radius: 20px;
}

#partyinfotitle span{
	font-size: 40px;
	background-color: #ffd925;
	color:white;
	

}

#partyinfo {
    width: 1130px;
    height: 250px;
    margin: 0 auto;
    position: absolute;
    left: 7px;
    top: 30px;
    left: 100px;
    font-size: 20px;
    color: #666666;
    font-weight: 500;
    
}


.party .partyvalue{
    position: relative;
}

#partyinfoarea{
border-top: 1px solid #666666;
border-bottom:1px solid #666666;
    position: relative;
    top: 49px;
}


#payinfotitle{
    width: 200px;
    height: 58px;
    text-align: center;
    background-color: #ffd925;
    border-radius: 20px;
    position: relative;
    top: 123px;

}

#payinfotitle span{
    font-size: 40px;
    background-color: #ffd925;
    color: white;
}



#userinfoarea{
    width: 1600px;
    height: 300px;
    position: relative;
    top: 177px;
    left: 6px;
    font-size: 20px;
    color: #666666;
    border-top: 1px solid #666666;
    border-bottom: 1px solid #666666;
}


#userinfo{
	font-weight: 500;
    width: 1130px;
    height: 250px;
    margin: 0 auto;
    position: absolute;
    left: 7px;
    top: 30px;
    left: 100px;
    font-size: 20px;
    color: #666666;

}





.uservalue{

	position: absolute;
    left: 550px;
}

#payarea{
	position: relative;
    top: 288px;
    width: 1600px;
    height: 300px;
    font-size: 20px;
    color: #666666;
    border-top: 1px solid #666666;
    border-bottom: 1px solid #666666;

}

#total_pay{

    width: 200px;
    height: 58px;
    text-align: center;
    background-color: #ffd925;
    border-radius: 20px;
    position: relative;
    top: 228px;

}

#total_pay span{
    font-size: 40px;
    background-color: #ffd925;
    color: white;
}

#payment{

	 width: 500px;
    height: 100px;
    position: absolute;
    top: 113px;
    font-size: 45px;
    font-weight: 600;
    left: 500px;

}

#willpay{
    padding-right: 80px;

}


#totalPayment{
 color: #ff8c11;

}


#btnarea{
 position: relative;
    top: 352px;
    width: 600px;
    height: 156px;
    left: 20px;
    margin: 0 auto;

}

button{
	 width: 174px;
    height: 42px;
    border-radius: 18px;
	margin-right: 77px;
}

#btnpay{
	border: none;
	background-color: #ff8c11 ;
}


#btnpay span,#btncancel span{
	color: white;
    font-size: 20px;

}

#btncancel{
	background-color: #ffd925;
	border: none;
	
}

#partyinfotitle, #payinfotitle,#total_pay{
	margin: 0px;

}
</style>

</head>


<body>


<div id="payresult"></div>

<% DecimalFormat format = new DecimalFormat("###,###"); %>

	<div id="pay">
		
		<div id="partyinfotitle">
			<span> 주문정보 </span>
			
		</div>
		<div id="partyinfoarea">	
			<table id="partyinfo" >
				
				<tr id="partyName">
					<td class="party">파티이름</td>
					<td class="partyvalue"><%=party.getPartyName() %></td>
				</tr>
					
<!-- 				<tr id="partyleader">		 -->
<!-- 					<td class="party">파티장 </td> -->
<%-- 					<td class="partyvalue"><%=party.getPartyLeader() %></td> --%>
<!-- 				</tr>		 -->
				
				<tr id="partypay">
					<td class="party">참여 금액</td>
					<td class="partyvalue"><%=format.format(party.getPaymentAmount()) %> 원</td>
				</tr>	
			
			</table>
		</div>
		
		
		<div id=payinfotitle>
			 
				 <span>결제 정보</span> 
		</div>			 
				 
 		 <div id="userinfoarea">  
				 
				<table id="userinfo">
					<tr>	
						<td><span class="user">회원 이름</span></td> 
						<td><span class="uservalue"><%=member.getUserName() %>  </span></td>
					</tr>	 
					<tr>	 
						<td><span class="user">회원 아이디</span></td>
						<td><span class="uservalue"><%=member.getUserId()%></span></td>
					</tr> 
				
					<tr>	 
						<td><span class="user">이메일</span></td>
						<td><span class="uservalue"><%=member.getUserEmail() %></span></td>
					</tr> 
				
				
 					<tr> 
						<td><span class="user">연락처</span></td> 
						<td><span class="uservalue">0<%=member.getUserPhone() %></span></td>
					</tr> 
				</table> 
		
		</div>
				<div id="total_pay"> 
 					<span>Total</span> 
				</div> 
		
 		<div id="payarea"> 		
 		<form  action="/homett/payment" method="post" id="payareaform"> 
			
	
 				<div id="payment"> 
				   <span id="willpay"><span>결제 금액</span></span> 
					<span id="totalPayment"> <%=format.format(party.getPaymentAmount()) %>원</span>
				</div> 
 			</form> 
 		</div> 
		
		
 		<div id="btnarea"> 
			<button type="button" id="btnpay" onclick="requestPay()"><span>결제하기</span></button> 
		<button type="button" id="btncancel" onclick="location.href='/homett/partymodify'"><span>취소하기</span></button> 
		</div> 

</div> 

<!-- <hr> -->
<!-- <footer> -->

<!-- 사업자 정보  -->

<!-- </footer> -->


</body>
</html>

