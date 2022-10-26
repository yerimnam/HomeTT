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
	
	
	$("#dropUserBtn").click(function() {
		console.log("#dropUserBtn 클릭")

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/dropuser"	//요청 URL
			, data: {		//요청 파라미터
				userPw : $("#userPw").val()	
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			 window.location.href='/homett/dropuserok';
			
		}
		, error: function() {
			console.log("AJAX 실패")
			alert("회원님의 비밀번호와 일치하지 않습니다");
			$("#userPw").focus()
			$("#userPw").val("")
			
		}			
			
		})
	})
	
	
})
</script>

</head>
<body>

<h4>탈퇴 시에는 개인정보가 모두 삭제되어 복구 불가능하오니 신중을 기해주세요.</h4>

<ul>
	<li>회원님의 개인정보 보호를 위해 비밀번호를 한번 더 입력해 주세요.</li>
</ul>
<hr>

<p>아이디 :  <%=session.getAttribute("userId") %></p>
<p>비밀번호 : <input type="text" id="userPw"name="userPw"></p>
<button id="dropUserBtn">탈퇴 하기</button>
<button onclick="location.href='/homett/main'">메인페이지</button><br><br>

</body>
</html>