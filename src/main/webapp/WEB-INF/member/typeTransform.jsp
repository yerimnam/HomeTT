<%@page import="user.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Member member = (Member) request.getAttribute("result"); %>
<jsp:include page="/WEB-INF/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	
	//로그인 버튼
	$("#typeTransBtn").click(function() {
		$(this).parents("form").submit();
	})

// 	$("#typeTransBtn").click(function() {
// 		console.log("#typeTransBtn 클릭")

// 		$.ajax({
// 			type:"post"			//요청 메소드
// 			, url: "/homett/type"		//요청 URL
// 			, data: {		//요청 파라미터
<%-- 				userId : "<%=session.getAttribute("userId") %>" --%>
<%-- 				, userName : "<%=session.getAttribute("userName") %>" --%>
				
// 			}
// 		, dataType: "html"		//응답 데이터 형식
// 		, success: function( res ) {
// 			console.log("AJAX 성공")
// 			alert("회원권한이 파티장으로 변경되었습니다");
// 			location.href='/homett/main';
			
// 		}
// 		, error: function() {
// 			console.log("AJAX 실패")
			
// 		}
	
// 		})
// 	})
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
	height: 500px;
	margin: 0 auto;
	text-align: center;
	background-color: #fffdf5;
	padding: 80px 0 80px 0;
}

#icon {
	margin-bottom: 30px;
}

#mainTxt{
	font-size: 28px;
	color: #222222;
	font-weight: 500;
	margin-bottom: 10px;
}

#mainTxt > span{
	font-weight: 800;
	color: #ffd925;
}

/* 버튼~ */
#btnDiv {
	width: 380px;
	height: 54px;
	margin: 0 auto;
	position: relative;
	text-align: center;
}


#btnMain {
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
}


#typeTransBtn {
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
}

#yellowBox {
	margin: 0 auto;
	width: 460px;
	height: 50px;
	border: 2px solid #ffd925;
	background-color: #ffffff;
	line-height: 50px;
}

#yellowBox > p {
	font-size: 19px;
	font-weight: 600;
	color: #ffd925;
}

#info {
	width: 260px;
	margin: 0 auto;
	font-size: 17px;
	font-weight: 400;
	color: #666666;
	margin-top: 20px;
	margin-bottom: 30px;
}

</style>

</head>
<body>


<%-- 파티장 상태 --%>
<%	if( (Integer)session.getAttribute("masterNo") == 1 ) { %>

<div id="backBg">
	<div id="textArea">
	
		<img alt="logo" src="/resources/img/sucsess.png " id="icon" >
		
		<p id="mainTxt">회원님은<span>이미 파티장</span>입니다.</p>
		
		<div id="btnDiv">
			<button id="btnMain" onclick="location.href='/homett/main'">메인페이지</button>
		</div>
	</div> <!-- textArea -->
</div><!-- backBg -->


<%	} %>




<%-- 파티원 상태 --%>
<%	if( (Integer)session.getAttribute("masterNo") == 2 ) { %>


<form action="/homett/type" method="post" id="submitporm" >

<div id="backBg">
	<div id="textArea">

		<p id="mainTxt">공지를 잘 읽어보시고 파티장 변경하기를 눌러주세요</p>
		
		<div id="info">
			<p>아이디 :  <%=session.getAttribute("userId") %></p>
			<p>이름 :  <%=session.getAttribute("userName") %></p>
			<p>이메일 :  <%=session.getAttribute("userEmail") %></p>
			<p>휴대폰번호 :  0<%= session.getAttribute("userPhone") %></p>
		</div>
			
		<div id="yellowBox">
			<p>파티원 모집시 0%의 판매 수수료가 발생됩니다.</p>
		</div>
		
		<div id="btnDiv">
			<button id="typeTransBtn">파티장 변경하기</button>
		</div>
	</div>
</div>

</form>



<%	} %>



<jsp:include page="/WEB-INF/layout/footer.jsp" />