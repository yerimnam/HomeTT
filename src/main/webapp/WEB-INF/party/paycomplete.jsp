<%@page import="payment.dto.Payment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
    <%@page import="java.text.SimpleDateFormat" %>
  <%@ include file="../layout/header.jsp"  %> 
    
  <% Payment paycomplete =(Payment)request.getAttribute("paycomplete");  %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">



#paycomplete{

	width:1600px;
	margin:0 auto;
}

#payresult{

	width:1600px;
	font-size: 20px;
    color: #666666;
    height: 939px;
    margin-top: 30px;
    font-size: 20px;
    font-weight: 600;

}



button{
	 width: 174px;
    height: 42px;
    border-radius: 18px;
	margin-right: 77px;
}

#gotoparty{
	border: none;
	background-color: #ff8c11 ;

}


#gotoparty span{
		color: white;
    font-size: 20px;
	
}


#paycomplete{

    height: 90px;
    font-size: 50px;
    font-size: 50px;
    color: #ffd925;
    font-weight: 600;
}



#paylist{

    height: 1040px;
    margin-top: 32px;
    font-size: 30px;
    font-weight: 400;
    border-top: 1px solid #666666;
    border-bottom: 1px solid #666666;
    padding: 40px;
    position:absolute;
    top:647px;
}





#payinfo{

	height: 600px;
    margin-top: 30px;

}
#btnarea{

    position: relative;
    top: 1100px;
    width: 180px;
    height: 50px;
    left: 725px;
}

#listtitle{
    height: 116px;
    font-size: 36px;
    margin: 20px;

}

</style>


</head>
<body>


	<div id="paycomplete">
		<span>결제 성공</span>
	</div>
	
	
		<div id="listtitle">	
			<span>결제내역</span>
		</div>
		
			<div id="paylist">
				<table id="payresult">
				
						<tr id="username">
							<td>이름</td>
							<td class="value"><%=paycomplete.getUserName() %></td>
						</tr>
					
					<tr id='nick'>
						<td>닉네임</td>
						<td class="value"><%=paycomplete.getUserNick() %></td>
					</tr>
					
					<tr>
						<td id="email">이메일</td>
						<td class="value"><%=paycomplete.getUserEmail() %></td>
					</tr>
					
					<tr id="joinparty">
						<td id="joinparty">가입 PARTY</td>
						<td class="value"><%=paycomplete.getPartyName() %></td>
					</tr>
					
					
					<tr id="paydate">
						<td>결제일자</td>
						<td class="value"><%=paycomplete.getPaymentDate()%></td>
					
					</tr>
					
					<tr id="cardinfo">
						<td>결제카드 정보</td>
						<td id="value"><%=paycomplete.getUserCardCom()%></td>
					</tr>
					
					
					<tr id="payamount">
						<td >결제 금액</td>
						<td class='value'><%=paycomplete.getPaymentAmount() %></td>
					</tr>
				
				</table>
		</div>
	<div id="btnarea">
		<button type="button" onclick="location.href='/homett/roomboard?partyNo=<%=paycomplete.getPartyNo()%>'" id="gotoparty"><span>파티로 가기</span></button>
	</div>
</body>
</html>