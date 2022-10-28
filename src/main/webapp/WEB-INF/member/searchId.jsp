<%@page import="user.dto.MailSmsOk"%>
<%@page import="user.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% MailSmsOk ranNum = (MailSmsOk) request.getAttribute("ranNum"); %>
    

  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnCalc").click(function() {
		console.log("#btnCalc 클릭")

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/searchid"		//요청 URL
			, data: {		//요청 파라미터
				name : $("#username").val()	
				, email : $("#useremail").val()
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			$("#okHide").css('display', 'block')
			$("#btnCalc").css('display','none')
			alert("회원님의 이메일로 인증번호를 발송하였습니다");
			
			
		}
		, error: function() {
			console.log("AJAX 실패")
			alert("입력하신 회원정보가 일치하지 않습니다");
			$("#username").focus()
			
		}			
			
		})
	})
	
	$("#remail").click(function() {
		console.log("#remail 클릭")

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/searchid"		//요청 URL
			, data: {		//요청 파라미터
				name : $("#username").val()	
				, email : $("#useremail").val()
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			alert("인증메일을 재전송 하였습니다");
// 			console.log(ranNum)
			
			
		}
		, error: function() {
			console.log("AJAX 실패")			
		}			
			
		})
	})
	
	
	
	$("#mailchk").click(function() {
		console.log("#mailchk 클릭")

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/emailok"	//요청 URL
			, data: {		//요청 파라미터
				mailOk : $("#emailOk").val()	
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			 window.location.href='/homett/emailok';
			
		}
		, error: function() {
			console.log("AJAX 실패")
			alert("입력하신 인증번호가 일치하지 않습니다");
		}			
			
		})
	})
	

	
	
})
</script>



</head>
<body>

<h2>아이디 찾기</h2>

	<div>
		<label for="username">이름</label>
		<input type="text" id="username"name="username">
	</div>

	<div>
		<label for="useremail">이메일</label>
		<input type="text" id="useremail"name="useremail">
	</div>
	
	<div id="okHide" style=" display: none">
		<label for="emailOk">인증번호 확인</label>
		<input type="text" id="emailOk"name="emailOk"><button id="remail">재전송</button>
		<button id="mailchk">인증 확인</button>
	</div>
	
	
	<button id="btnCalc" style="display:block">아이디 찾기</button>



</body>
</html>