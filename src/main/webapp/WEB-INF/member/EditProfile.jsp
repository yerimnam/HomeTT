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
	
	//가입취소 버튼 
	$("#btnCancel").click(function() {
		history.go(-2) //뒤로가기
	})
	
	
	$("#editBtn").click(function() {
		console.log("#editBtn 클릭")
		
		//비밀번호 확인이 비밀번호랑 같지 않을때~~~~~~~~~~~~~~~~~!
		if( !(document.getElementById("userpw_check").value == document.getElementById("userpw").value )){
			alert("비밀번호 확인을 비밀번호와 동일하게 입력해주세요.");
			$("input").eq(1).focus()
	 			return;
		}

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/editprofile"		//요청 URL
			, data: {		//요청 파라미터
				userPw : $("#userpw").val()	
				, userPw_check : $("#userpw_check").val()	
				, userNick : $("#usernick").val()	
				, userEmail : $("#useremail").val()	
				, userPhone : $("#userphone").val()	
			}
			, dataType: "html"		//응답 데이터 형식
			, success: function( res ) {
			console.log("AJAX 성공")
			alert("고객님의 회원정보가 수정되었습니다");
// 			window.location.href='/homett/editprofile'; //마이페이지 주소
			
			}
			, error: function() {
				console.log("AJAX 실패")
// 				alert("입력하신 회원정보가 일치하지 않습니다");
// 				$("#username").focus()
			}			
		})
	})
	
	
	
		
	
	
})
</script>

</head>
<body>

<h1>회원정보 변경</h1>
<hr>


<form action="/homett/join" method="post">

	<div>
		<label for="userid">아이디</label>
		<%=session.getAttribute("userId") %>
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
		<label for="usernick" >닉네임</label>
		<input type="text" id="usernick" name="usernick">
	</div>
	 
	<div>
		<label for="useremail" >이메일</label>
		<input type="text" id="useremail" name="useremail">
	</div>
	
	<div>
		<label for="userphone" >휴대폰 번호</label>
		<input type="text" id="userphone" name="userphone" value=<%="0" + session.getAttribute("userPhone")%>>
	</div>

	<br>
	<div>
		<button type="button" id="editBtn">수정하기</button>
		<button type="button" id="btnCancel" >취소하기</button>
	</div>

</form>


</body>
</html>