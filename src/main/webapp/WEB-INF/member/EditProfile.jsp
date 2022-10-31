<%@page import="user.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Member member = (Member) request.getAttribute("result"); %>
<jsp:include page="/WEB-INF/layout/header.jsp" />

<jsp:include page="/WEB-INF/layout/sidemenu.jsp" />

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
			window.location.href='/homett/mypage'; //마이페이지 주소
			
			}
			, error: function() {
				console.log("AJAX 실패")
// 				alert("전화번호를 정확히 입력해주세요");
// 				$("#username").focus()
			}			
		})
	})
	
})
</script>

<!-- ------------------------------- 스타일 시작 ------------------------------- -->

<style type="text/css">

@import url('https://webfontworld.github.io/sunn/SUIT.css');

html, body, pre, h1, h2, h3, h4, h5, h6, dl, dt, dd, ul, li, ol, th, td, p, blockquote, form, fieldset, legend, menu, nav, section, hgroup, article, header, aside, footer, input, select, textarea, button {
    margin: 0;
    padding: 0;
    font-family: 'SUIT';
}

#backBg {
	width: 640px;
	height: 450px;
	margin: 0 auto;
/* 	background-color: #fafafa; */
	padding: 0px 0 80px 80px;
}


/* 인풋 글 작성시 */
input:focus{
	border: 2px solid #fffdf5;
    outline: none;
}

#mainTxt{
	font-size: 22px;
	color: #222222;
	font-weight: 500;
	margin-bottom: 20px;
}

hr{
	border-top : 2px solid #ffd925;
	margin: 0;
}

/* input 박스 */ 
div > input {
	width: 200px;
	height: 36px;
	border: 1px solid #dddddd;
	border-radius: 4px;
	padding-left: 10px;
}

.inputDiv {
	width: 560px;
	height: 60px;
	vertical-align: middle;
	line-height: 60px;
	border-bottom: 1px solid #eeeeee;	
}

label {
	width: 100px;
	margin-left: 6px;
}


/* 버튼 부분ㄱ*/
#btnDiv {
	clear: both;
	width: 380px;
	height: 54px;
	position: relative;
	margin: 20px 0 0 90px;
}

#btnCancel {
	width: 185px;
	height: 54px;
	border-radius: 4px;
	font-size: 18px;
	font-weight: 600;
	text-align: center;
	line-height: 54px;
	position: absolute;
	background-color: #ffffff;
	border: 1px solid #ffd925; 
	color: #ffde59; 
	position: absolute;
}

#editBtn {
	width: 185px;
	height: 54px;
	background-color: #ffd925;
	border: none;
	border-radius: 4px;
	font-size: 18px;
	color: #ffffff;
	font-weight: 600;
	text-align: center;
	line-height: 54px;
	position: absolute;
	float: right;
	right: 0;
}




</style>

</head>
<body>


<form action="/homett/editprofile" method="post">

<div id="backBg">

	<div id="textArea">
	
		<p id="mainTxt">회원정보 수정 <p>
		
		<hr>
			
		<div class="inputDiv">
			<label for="userid">아이디</label>
			<%=session.getAttribute("userId") %>
		</div>
		
		<div class="inputDiv">
			<label for="userpw" >비밀번호</label>
			<input type="text" id="userpw" name="userpw" >
		</div>
			
		<div class="inputDiv">
			<label for="userpw_check" >비밀번호 확인</label>
			<input type="text" id="userpw_check" name="userpw" >
		</div>
			
		<div class="inputDiv">
			<label for="usernick" >닉네임</label>
			<input type="text" id="usernick" name="usernick">
		</div>
			 
		<div class="inputDiv">
			<label for="useremail" >이메일</label>
			<input type="text" id="useremail" name="useremail">
		</div>
			
		<div class="inputDiv">
			<label for="userphone" >휴대폰 번호</label>
			<input type="text" id="userphone" name="userphone" value=<%="0" + session.getAttribute("userPhone")%>>
		</div>
		
			<br>
			<div id="btnDiv">
				<button type="button" id="btnCancel" >취소하기</button>
				<button type="button" id="editBtn">수정하기</button>
			</div>
			
	</div>	
</div>

</form>


<jsp:include page="/WEB-INF/layout/footer.jsp" />






