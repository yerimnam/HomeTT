<%@page import="user.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Member member = (Member) request.getAttribute("result"); %>
<jsp:include page="/WEB-INF/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	
	$("#userpwchk").click(function() {
		console.log("#userpwchk 클릭")

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/typepwchk"		//요청 URL
			, data: {		//요청 파라미터
				userPw : $("#userpw").val()	
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			window.location.href='/homett/type';
			
		}
		, error: function() {
			console.log("AJAX 실패")
			alert("입력하신 비밀번호가 일치하지 않습니다");
			$("#username").focus()
			
		}			
			
		})
	})
		
})
</script>

<style type="text/css">

@import url('https://webfontworld.github.io/sunn/SUIT.css');

html, body, pre, h1, h2, h3, h4, h5, h6, dl, dt, dd, ul, li, ol, th, td, p, blockquote, form, fieldset, legend, menu, nav, section, hgroup, article, header, aside, footer, input, select, textarea, button {
    margin: 0;
    padding: 0;
    font-family: 'SUIT';
}


#backBg {
	width: 1600px;
	height: 350px;
	margin: 0 auto;
	text-align: center;
	background-color: #fffdf5;
	padding: 90px 0 90px 0;
}


#mainTxt{
	font-size: 28px;
	color: #222222;
	font-weight: 500;
	margin-bottom: 10px;
}



#subContent {
	font-size: 17px;
	color: #888888;
	font-weight: 200px;
	margin-bottom: 30px;
}

#subContent > span {
	color: #333333;
	font-weight: 700;
}


#inputDiv{
	width: 310px;
	height: 38px;
	margin: 0 auto;
	position: relative;
}

/* input 박스 */ 
div > input {
	width: 200px;
	height: 38px;
	border: 1px solid #dddddd;
	border-radius: 4px;
	padding-left: 10px;
	margin-right: 10px;
	position: absolute;
	left: 0;
}


#userpwchk {
	width: 100px;
	height: 38px;
	background-color: #ffd925;
	border: none;
	border-radius: 4px;
	font-size: 18px;
	color: #ffffff;
	font-weight: 600;
	text-align: center;
	line-height: 36px;
	position: absolute;
	right: 0;
}



</style>

</head>
<body>

<div id="backBg">
	<div id="textArea">
		
		<p id="mainTxt">비밀번호 확인</p>
		
		<p id="subContent"><span>·<%=session.getAttribute("userId") %>·</span>님의 회원정보를 안전하기 보호하기 위해
		비밀번호를 한번 더 확인해 주세요.</p>
		
		 
		<div id="inputDiv">
			<input type="text" id="userpw" name="userpw">
			<button id="userpwchk">확인</button>
		</div>
	</div>
</div>	

	
	
	

<jsp:include page="/WEB-INF/layout/footer.jsp" />