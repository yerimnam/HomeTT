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

	//아이디 입력창에 포커스주기
	$("input").eq(0).focus()
	
	//닉네임 입력창에 엔터키 입력 시 submit
	$("input").eq(2).keydown(function(e) {
		if( e.keyCode == 13 ) { //엔터키
			$("#btnJoin").click();
		}
	})
	
	//회원가입 버튼
	$("#btnJoin").click(function() {
		$(this).parents("form").submit();
	})
	
	//취소 버튼
	$("#btnCancel").click(function() {
// 		history.go(-1) //뒤로가기
		$(location).attr('href', '/') //메인으로 가기
	})
	
})

</script>

<style type="text/css">

label {
	float: left;
	width: 110px;
}

</style>



</head>
<body>

<h1>회원가입</h1>
<hr>

<form action="/homett/join" method="post">

	<div>
		<label for="userid">아이디</label>
		<input type="text" id="userid" name="userid" >
	</div>

	<div>
		<label for="userpw" >비밀번호</label>
		<input type="text" id="userpw" name="userpw" >
	</div>
	
	<div>
		<label for="userpw_check" >비밀번호 확인</label>
		<input type="text" id="userpw_check" name="userpw" >
	</div>

	<div>
		<label for="username" >이름</label>
		<input type="text" id="username" name="username">
	</div>
	
	<div>
		<label for="usernick" >닉네임</label>
		<input type="text" id="usernick" name="usernick">
	</div>
	 
	<div>
		<label for="useremail" >이메일</label>
		<input type="text" id="useremail" name="useremail">
	</div>
	
	<div>
		<label for="userphone" >휴대폰 번호</label>
		<input type="text" id="userphone" name="userphone">
	</div>
	
<!-- 	<div> -->
<!-- 		<label for="masterno" >회원권한</label> -->
<!-- 		<input type="radio" id="masterno" name="masterno" value="1" checked onclick="return(false);">파티원 -->
<!-- 		<input type="radio" id="masterno" name="masterno" value="2" onclick="return(false);">파티장 -->
<!-- 	</div> -->

	<br>
	<div>
		<button type="button" id="btnJoin">회원가입</button>
		<button type="button" id="btnCancel">가입취소</button>
	</div>

</form>

</body>
</html>