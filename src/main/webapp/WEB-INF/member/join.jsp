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
	
	//회원가입 버튼
	$("#btnJoin").click(function() {
		$(this).parents("form").submit();
	})
	
	//가입취소 버튼
	$("#btnCancel").click(function() {
// 		history.go(-1) //뒤로가기
		$(location).attr('href', '/') //메인으로 가기
	})
	
})

//input 데이터의 유효성 검증
function validate() {
	
	//--- ID 유효성 검증 ---
	
	//아이디가 비어있을때 
	if( $("#userid").val() == '') {
		
// 		alert("아이디를 입력해주세요!")
		document.getElementById("idCheckMsg1").style.display = 'block';
		return false;
	} else {
		document.getElementById("idCheckMsg1").style.display = 'none';
	}
	
	//아이디 입력값 검증
	if( !/^[a-zA-Z0-9]{4,12}$/.test( $("#uid").val() ) ) {
		$('#uid_msg').html("아이디는 4~12글자의 영문자, 숫자가 가능합니다");
		
		return false;
	}
	
	//----------------------------
	
	//--- PASSWORD 유효성 검증 ---
	
	//패스워드를 입력하지 않았을 때
	if( $("#upw").val() == '' ) {
		$("#upw_msg").html("패스워드를 입력해주세요!")
		
		return false;
	}
	
	//패스워드 입력값 검증
	if( !/^[a-zA-Z]{4,8}$/.test( $("#upw").val() ) ) {
		$('#upw_msg').html("패스워드는 영어 대소문자 4~8자만 입력하세요!");
		
		return false;
	}
	
	if( $("#upw").val() != $("#upw_check").val() ) {
		$("#upw_check_msg").html("비밀번호 확인 입력이 동일하지 않흡니다")
		
		return false;
	}
	
	//----------------------------
	
	return true;
	
}

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
		<input type="text" id="userid" name="userid" placeholder="아이디입력하에">
	</div>
	<em class="msgInvalid" id="idCheckMsg1" style="display:none">4~20자의 영문, 숫자와 특수문자'_'만 사용해주세요.</em>

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

	<br>
	<div>
		<button type="button" id="btnJoin">가입하기</button>
		<button type="button" id="btnCancel">가입취소</button>
	</div>

</form>

</body>
</html>