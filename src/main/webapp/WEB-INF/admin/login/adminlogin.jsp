<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../layout/header.jsp" />

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
			alert("로그인 성공!");
			 window.location.href='/homett/adminmain';
			
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
			$("#btnAdminLogin").click();
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

<div class="form-horizontal">
	<div class="form-group text-center" style="margin: 100px 400px;">
		<div class="text-center" style="margin-bottom: 20px;">
			<h1>관리자 로그인</h1>
		</div>
		
		<label for="userid" class="col-lg-5 control-label" style="margin: 10px 0;">아이디</label>
		<div class="col-lg-5">
			<input class="form-control" type="text" id="userid" name="userid" placeholder="아이디" style="width: 200px; margin: 10px 0;">
		</div>
	
		<label for="userpw" class="col-lg-5 control-label" style="margin: 10px 0;">비밀번호</label>
		<div class="col-lg-5">
			<input class="form-control" type="password" id="userpw" name="userpw" style="width: 200px; margin: 10px 0;">
		</div>
	
		<div class="col-lg-12">
			<button id="btnAdminLogin" class="btn btn-primary" style="margin: 10px 0;">로그인</button>
		</div>
	</div>
</div>


</body>

<!-- 부트스트랩3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');
body{
	font-family: 'SUIT';
}
</style>

</html>