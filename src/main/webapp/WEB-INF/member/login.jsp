<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
// 	$("form").submit(function(){
// 		console.log("submit event")
		
// 		//유효성 검증 후 submit
// 		if( validate() ) {
			
// 			$(this).submit();
// 		}
// 		//submit 중단시키기(새로고침 되는거 방지)
// 		alert("회원정보를 전부 입력해주세요")
// 		return false;
// 	})
	

	//아이디 입력창에 포커스주기
	$("input").eq(0).focus()
	
	//패스워드 입력창에 엔터키 입력 시 submit
	$("input").eq(1).keydown(function(e) {
		if( e.keyCode == 13 ) { //엔터키
			$("#btnLogin").click();
		}
	})
	
	//회원가입 버튼
	$("#btnLogin").click(function() {
		$(this).parents("form").submit();
	})
	
	
})

</script>

</head>
<body>
<h1>로그인</h1>
<hr>

<form action="/homett/login" method="post">

	<div>
		<label for="userid">아이디</label> <input type="text" id="userid" name="userid" placeholder="아이디">
	</div>

	<div>
		<label for="userpw">비밀번호</label> <input type="text" id="userpw" name="userpw">
	</div>

	<div>
		<button type="button" id="btnLogin">로그인</button>
	</div>

	<div>
		<button type="button" id="kakaoLogin">카카오 로그인</button>
	</div>

</form>

</body>
</html>