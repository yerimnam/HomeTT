<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

		//아이디가 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("userid").value==""){
			alert("이름을 입력해주세요");
			$("input").eq(0).focus()
			return;
		} 
		
		
		//이름가 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("username").value==""){
			alert("이름을 입력해주세요");
			$("input").eq(1).focus()
 			return;
		}
		
		//휴대폰 번호가 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("userphone").value==""){
			alert("휴대폰 번호를 입력해주세요");
			$("input").eq(2).focus()
 			return;
		}
		
		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/searchpw"		//요청 URL
			, data: {		//요청 파라미터
				id : $("#userid").val()	
				, namepw : $("#username").val()
				, phone : $("#userphone").val()
				
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			$("#okHide").css('display', 'block')
			$("#btnCalc").css('display','none')
			alert("회원님의 휴대폰 번호로 인증번호를 발송하였습니다");
			
		}
		, error: function() {
			console.log("AJAX 실패")
			alert("입력하신 회원정보가 일치하지 않습니다");
			$("#userid").focus()
			
		}			
			
		})
	})
	
	
	$("#resms").click(function() {
		console.log("#resms 클릭")

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/searchpw"		//요청 URL
			, data: {		//요청 파라미터
				id : $("#userid").val()	
				, namepw : $("#username").val()
				, phone : $("#userphone").val()
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			alert("인증문자를 재전송 하였습니다");
			
			
		}
		, error: function() {
			console.log("AJAX 실패")			
		}			
			
		})
	})
	
	
	$("#smschk").click(function() {
		console.log("#smschk 클릭")

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/emailok"	//요청 URL
			, data: {		//요청 파라미터
				mailOk : $("#smsOk").val()	
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			 window.location.href='/homett/smsok';
			
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

<h2>비밀번호 찾기</h2>
	
	<div>
		<label for="userid">아이디</label>
		<input type="text" id="userid"name="userid">
	</div>

	<div>
		<label for="username">이름</label>
		<input type="text" id="username"name="username">
	</div>
	
	<div>
		<label for="userphone">휴대폰 번호</label>
		<input type="text" id="userphone"name="userphone">
	</div>
	
	
	<div id="okHide" style=" display: none">
		<label for="smsOk">인증번호 확인</label>
		<input type="text" id="smsOk"name="smsOk"><button id="resms">재전송</button>
		<button id="smschk">인증 확인</button>
	</div>
	
	
	<button id="btnCalc" style="display:block">비밀번호 찾기</button>

</body>
</html>