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
	
	$("#userpwchk").click(function() {
		console.log("#userpwchk 클릭")

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/editprofilepwchk"		//요청 URL
			, data: {		//요청 파라미터
				userPw : $("#userpw").val()	
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			window.location.href='/homett/editprofile';
			
		}
		, error: function() {
			console.log("AJAX 실패")
			alert("입력하신 회원정보가 일치하지 않습니다");
			$("#username").focus()
			
		}			
			
		})
	})
		
	
	
})
</script>

</head>
<body>

<h1>비밀번호 확인</h1>
<p><%=session.getAttribute("userId") %>님의 회원정보를 안전하기 보호하기 위해<br>
비밀번호를 한번 더 확인해 주세요.</p>
<hr>

 
<div>
	<label for="userpw">비밀번호</label>
	<input type="text" id="userpw" name="userpw">
	<button id="userpwchk">확인</button>
</div>
	

</body>
</html>