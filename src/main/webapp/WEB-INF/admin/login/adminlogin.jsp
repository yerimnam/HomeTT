<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnAdminLogin").click(function() {
		console.log("#btnAdminLogin 클릭")

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/adminlogin"		//요청 URL
			, data: {		//요청 파라미터
				id : $("#userid").val()	
				, pw : $("#userpw").val()
				
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			alert("[TEST] 로그인에 성공했습니다.");

// 			 window.location.href='/homett/main';
			
		}
		, error: function() {
			console.log("AJAX 실패")
			alert("입력하신 회원정보가 일치하지 않습니다");
			$("#userid").focus()
			
		}			
			
		})
	})
	
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
	
// 	//로그인 버튼
// 	$("#btnLogin").click(function() {
// 		$("#loginform").submit();
// 	})

})
</script>



<style>
li{
	list-style:none;
}

</style>

</head>
<body>
<h1>관리자 로그인</h1>
<hr>

<!-- <form action="/homett/login" method="post" id="loginform"> -->

	<div>
		<label for="userid">아이디</label>
		<input type="text" id="userid"name="userid" placeholder="아이디">
	</div>

	<div>
		<label for="userpw">비밀번호</label>
		<input type="text" id="userpw"name="userpw">
	</div>

	<div>
		<button id="btnAdminLogin">로그인</button>
	</div>

<!-- </form> -->


    
    
</body>
</html>



