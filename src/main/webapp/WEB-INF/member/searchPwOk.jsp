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
	
	$("#newPwchk").click(function() {
		$(this).parents("form").submit()
	})
	
})
</script>


</head>
<body>

<h1>비밀번호 재설정하기</h1>
<p>새로운 비밀번호를 입력해주세요.</p>

<form action="/homett/updatepw" method="post">

<div>
	<label for="newPw">새로운 비밀번호</label>
	<input type="text" id="newPw"name="newPw">
	<button id="newPwchk">인증 확인</button>
</div>


<!-- <div> -->
<!-- 	<label for="username">새로운 비밀번호 확인</label> -->
<!-- 	<input type="text" id="username"name="username"> -->
<!-- </div> -->

</form>

</body>
</html>