<%@page import="user.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Member member = (Member) request.getAttribute("result"); %>
<jsp:include page="/WEB-INF/layout/header.jsp" />
<jsp:include page="/WEB-INF/layout/sidemenu.jsp" />

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
	padding: 0px 0 80px 0px;
}

 #inBox { 
	width: 640px; 
 	height: 120px;
 	background-color: #fafafa; 
 	padding: 30px 30px 30px 40px;;
 } 
 
#mainTxt{
	font-size: 22px;
	color: #222222;
	font-weight: 500;
	margin-bottom: 20px;
}


hr {
	border-top : 1px solid #ffd925;
}

#subTitle{
	font-size: 18px;
	color: #ff0000;
	font-weight: 600;
}

#subContent {
	font-size: 15px;
	color: #666666;
	font-weight: 400;
	margin-bottom: 14px;
}




/* input 박스 */
p > input {
	width: 180px;
	height: 30px;
/* 	background-color: #eeeeee; */
	border: 1px solid #dddddd;
	border-radius: 4px;
	padding-left: 10px;
	position: absolute;
	margin-left: 6px;
}

#pId {
	font-size: 16px;
	margin-bottom: 6px;
}

#pId > span {
	margin-left: 16px;
}

#pPw {
	font-size: 16px;
	line-height: 30px;
}



/* 버튼 */
#btnDiv {
	clear: both;
	width: 380px;
	height: 54px;
	position: relative;
}

#dropUserBtn {
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
	margin-top: 30px;
	position: absolute;
	float: right;
	right: 0;
}

/* 인풋 글 작성시 */
input:focus{
	border: 2px solid #ffd925;
    outline: none;
}


</style>

<!-- ------------------------------- 스타일 끝 ------------------------------- -->

</head>
<body>

<div id="backBg">
	<div id="textArea">

		<p id="mainTxt">탈퇴 시에는 개인정보 및 HomeTT에서 만들어진 모든 데이터가 삭제되어
		<br>복구 불가능하오니 신중을 기해주세요.</p>
		
		<hr>
		
		<p id="subTitle"> 유의사항</p>
		<p id="subContent">회원탈퇴 후에는 회원님의 개인정보를 복원할 수 없으며, 회원님의 로그인정보는 삭제됩니다.</p>
		
		<div id="inBox">
		
			<div id="idDiv">
				<p id="pId">아이디 : <span><%=session.getAttribute("userId") %></span></p>
			</div>
			<div id="pwDiv">
				<p id="pPw">비밀번호 : <input type="text" id="userPw"name="userPw"></p>
			</div>
			
		</div><!-- inBox -->
		<div id="btnDiv">
			<button id="dropUserBtn">탈퇴 하기</button>
		</div>
	</div><!-- textArea -->
</div><!-- backBg -->









<jsp:include page="/WEB-INF/layout/footer.jsp" />
