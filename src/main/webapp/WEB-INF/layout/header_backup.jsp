<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> : : : HomeTT : : :</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<!-- 스타일 -->
<style type="text/css">

html, body, pre, h1, h2, h3, h4, h5, h6, dl, dt, dd, ul, li, ol, th, td, p, blockquote, form, fieldset, legend, menu, nav, section, hgroup, article, header, aside, footer, input, select, textarea, button {
    margin: 0;
    padding: 0;
    font-family: 'yg-jalnan', 'Noto Sans KR', monospace, Corbel, Dotum, AppleGothic, Helvetica, sans-serif;
}

#header{
	height: 110px;
	margin: 0 auto;
	position: relative;
}

#hdTopright{
	background-color: #ffde59;
	float: right;
	width: 76%;
	height: 110px;
	border-radius: 0 0 0 90px;
	position: absolute;
	right: 0;
}

#hdTopleft{
	width: 24%;
	height: 110px;
	float: left;
	position: relative;
}

#logoBg{
	width: 1600px;
	height: 110px;
	line-height: 110px;
	position: absolute;
	left: 160px;
}


#inner {
	width: 1600px;
	height: 110px;
	margin: auto;
	position: absolute;
	right: 160px;
}

#topMenu {
	float: right;
	height: 34px;
	line-height: 40px;
}

#bottomMenu {
	float: right;
	height: 76px;
	width: 1600px;
	padding-top: 10px;
}

#bottomMenu > ul {
	float: right;
	line-height: 44px;
}

#bottomMenu > ul > li {
	float: right;
	margin: 0 30px 0 30px;
	font-size: 20px;
	color: #111111;
}

#bottomMenu > ul > li > a {
	font-weight: bold;
	color: #ffffff;
}


#bottomMenu :nth-child(2) {
	margin-right: 140px !important;
}

#mypageBtn {
	margin-right: 0 !important;
}

#mypageBtn a.mypage {
	display: inline-block;
    font-size: 18px;
    font-weight: 600;
    font-family: 'Nanum Gothic';
    width: 184px;
    height: 44px;
    line-height: 44px;
    border-radius: 30px;
    text-align: center;
    color: #111111;
    background-color: #fff;
}

</style>

</head>
<body>

<header id="header">
	
	<div id="hdTopleft" >
		<div id="logoBg">
			<img alt="logo" src="/resources/img/homett_logo.png " id="logo">
		</div>
	</div>	
		
	<div id="hdTopright">
	<div id="borderline">
		<div id="inner">
			<div id="topMenu">
				<a href="">로그인</a>
				<a href="">회원가입</a>
			</div><!-- topMenu end -->
			
			<div id="bottomMenu">
				<ul>
					<li id="mypageBtn">
						<a href="" class="mypage">마이페이지</a>
					</li>
					
					<li class="gnb">
						<a href="">파티만들기</a>
					</li>
					
					<li class="gnb">
						<a href="">파티찾기</a>
					</li>
					
					<li class="gnb">
						<a href="">후기게시판</a>
					</li>
					
					<li class="gnb">
						<a href="">가이드</a>
					</li>
					
					<li class="gnb">
						<a href="">고객센터</a>
					</li>
				</ul>
				
			
			
			</div><!-- bottomMenu end -->
		</div>
	</div>
	</div><!-- hdTopright -->
		
	</header>

<br><br><br><br>











