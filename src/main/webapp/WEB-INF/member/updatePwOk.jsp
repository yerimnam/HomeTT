<%@page import="user.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Member member = (Member) request.getAttribute("result"); %>
<jsp:include page="/WEB-INF/layout/header.jsp" />


<style type="text/css">

@import url('https://webfontworld.github.io/sunn/SUIT.css');

html, body, pre, h1, h2, h3, h4, h5, h6, dl, dt, dd, ul, li, ol, th, td, p, blockquote, form, fieldset, legend, menu, nav, section, hgroup, article, header, aside, footer, input, select, textarea, button {
    margin: 0;
    padding: 0;
    font-family: 'SUIT';
}


#backBg {
	width: 1600px;
	height: 450px;
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

#subTxt {
	font-size: 17px;
	color: #888888;
	font-weight: 200px;
	margin-bottom: 46px;
}

#subTxt > span{
	font-weight: 700;
	color: #ffd925;
}


/* 버튼~ */
#btnDiv {
	width: 380px;
	height: 54px;
	margin: 0 auto;
	position: relative;
}


#btnMain {
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
	left: 0;
}

#btnLogin {
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


<div id="backBg">
	<div id="textArea">
	
		<img alt="logo" src="/resources/img/sucsess.png " id="icon" >
		
		<p id="mainTxt">비밀번호 변경완료</p>
		
		<P id="subTxt"><span><%=session.getAttribute("userId") %></span>님의 비밀번호가 변경되었습니다.</P>
		
		<div id="btnDiv">
			<button id="btnMain" onclick="location.href='/homett/login'">메인페이지</button>
			<button id="btnLogin" onclick="location.href='/homett/login'">로그인</button>
		</div>
	</div> <!-- textArea -->
</div><!-- backBg -->


<jsp:include page="/WEB-INF/layout/footer.jsp" />


