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

<script src="https://kit.fontawesome.com/1f926ec3c7.js" crossorigin="anonymous"></script> <!-- 이거 지우지 마세여! -->



<!-- ------------------------------------- 스크립트 시작 ------------------------------------ -->

<script type="text/javascript">
$(document).ready(function(){
	
	$(".gnb > a").mouseover(function(){
		event.target.style.color = "#000000"
		event.target.nextElementSibling.style.display ="block";
		});
	
	$(".gnb > a").mouseout(function(){
		event.target.style.color = "#ffffff";
		event.target.nextElementSibling.style.display ="none";
	});
	
	$("#topMenu > a").mouseover(function(){
		event.target.style.fontWeight = "bold";
	});
	
	$("#topMenu > a").mouseout(function(){
		event.target.style.fontWeight = "500";
	});
	
	
	
	
})




</script>



<!-- ------------------------------------- 스크립트 끝 ------------------------------------ -->

<!-- 스타일 -->
<style type="text/css">

ul {
   list-style: none;
}

html, body, pre, h1, h2, h3, h4, h5, h6, dl, dt, dd, ul, li, ol, th, td, p, blockquote, form, fieldset, legend, menu, nav, section, hgroup, article, header, aside, footer, input, select, textarea, button {
    margin: 0;
    padding: 0;
    font-family: 'SUIT';
}


#hdYellowBg{ 
	width: 100% !important; 
	height: 110px;
	background-image: url( "/resources/img/yellowbg.png" );
	position: relative;
 } 

#header{
	width: 1600px;
	height: 110px;
	margin: 0 160px 0 160px;
	position: absolute;
	top: 0;
/* 	margin-left: 160px; */
}



/* #hdTopright{ */
/* 	background-color: #ffd925; */
/* 	float: right; */
/* 	width: 1300px; */
/* 	height: 110px; */
/* 	border-radius: 0 0 0 90px; */
/* 	position: absolute; */
/* 	right: 0; */
/* } */

#logoBg{
	width: 500px;
	height: 110px;
	line-height: 110px;
	z-index: 4;
}

#hdTopleft{
	z-index: 2;
	width: 220px;
	height: 110px;
}


.inner {
	width: 1400px;
	margin: auto;
	position: absolute;
	margin-left: 200px;
}

.top{
	top: 0;
}

.bottom{
	position: absolute;
	top: 40px;
}

.gnb{
	position: relative;
}

.gnb > p {
	position: absolute;
	top: 20px;
	left: 43%;
	font-size: 5px;
	color: #000000;
	
}


#topMenu {
	width: 100%;
	height: 34px;
	line-height: 40px;
	margin: 0 auto;
}

#topMenu > a {
	float: right;
	display: inline;
	margin: 0 10px 0 15px;
	text-decoration: none;
	font-weight: 500;
	color: #ffffff;
}

#bottomMenu {
	height: 70px;
	width: 1400px;
	margin-top: 2px;
	float: right;
}

#bottomMenu > ul {
	float: right;
	line-height: 48px;
}

#bottomMenu > ul > li {
	margin: 0 46px 0 46px;
	float: right;
}

#bottomMenu > ul > li > a {
	font-weight: 600;
    font-family: 'SUIT';
    font-size: 21px;
    color: #ffffff;
    text-decoration-line: none;
    position: relative;
	
}


#bottomMenu :nth-child(2) {
 	margin-right: 62px !important; 
}

/* 마이페이지 버튼 */
#mypageBtn {
	margin-right: 0 !important;
}

#mypageBtn a.mypage {
	display: inline-block;
    font-size: 16px;
    font-weight: 600;
    width: 174px;
    height: 42px;
    line-height: 42px;
    border-radius: 30px;
    text-align: center;
    color: #ffd925;
    background-color: #fff;
}

</style>

</head>


<%-- 비로그인 상태 --%>
<%	if( session.getAttribute("login") == null ) { %>

<div id="hdYellowBg">	
</div><!-- hdTopright -->

<header id="header">
	
		<div class="inner top">
			<div id="topMenu">
				<a href="/homett/login">로그인</a>
				<a href="/homett/join">회원가입</a>
			</div><!-- topMenu end -->
		</div>	
		
		<div class="inner bottom">
			<div id="bottomMenu">
				<ul>
					<li id="mypageBtn">
						<a href="/homett/login" class="mypage">마이페이지</a>
					</li>
					
					<li class="gnb">
						<a href="/homett/createparty">파티만들기 </a>
						<p style=" display: none">●</p>
					</li>
					
					<li class="gnb">
						<a href="/homett/partymodify">파티찾기</a>
						<p style=" display: none">●</p>
					</li>
					
					<li class="gnb">
						<a href="/homett/reviewlist">후기게시판</a>
						<p style=" display: none">●</p>
					</li>
					
					<li class="gnb">
						<a href="">가이드</a>
						<p style=" display: none">●</p>
					</li>
					
					<li class="gnb">
						<a href="">고객센터</a>
						<p style=" display: none">●</p>
					</li>
					
				</ul>
			
			</div><!-- bottomMenu end -->
		</div>

	<div id="hdTopleft" >
		<a href="/homett/main" id="logoBg">
			<img alt="logo" src="/resources/img/homett_logo.png " id="logo" >
		</a>
	</div>	
	
		
	</header>

<br><br><br><br>

<%	} %>


<%-- 로그인 상태 --%>
<%	if( session.getAttribute("login") != null && (boolean) session.getAttribute("login") ) { %>

<div id="hdYellowBg">	
</div><!-- hdTopright -->

<header id="header">
	
	
		<div class="inner top">
			<div id="topMenu">
				<a href="/homett/logout">로그아웃</a>
			</div><!-- topMenu end -->
		</div>	
		
		<div class="inner bottom">
			<div id="bottomMenu">
				<ul>
					<li id="mypageBtn">
						<a href="/homett/mypage" class="mypage">마이페이지</a>
					</li>
					
					<li class="gnb">
						<a href="/homett/createparty">파티만들기 </a>
						<p style=" display: none">●</p>
					</li>
					
					<li class="gnb">
						<a href="/homett/partymodify">파티찾기</a>
						<p style=" display: none">●</p>
					</li>
					
					<li class="gnb">
						<a href="">후기게시판</a>
						<p style=" display: none">●</p>
					</li>
					
					<li class="gnb">
						<a href="">가이드</a>
						<p style=" display: none">●</p>
					</li>
					
					<li class="gnb">
						<a href="">고객센터</a>
						<p style=" display: none">●</p>
					</li>
					
				</ul>
			
			</div><!-- bottomMenu end -->
		</div>

	<div id="hdTopleft" >
		<a href="/homett/main" id="logoBg">
			<img alt="logo" src="/resources/img/homett_logo.png " id="logo" >
		</a>
	</div>	
	
		
</header>

<br><br><br><br>

<%	} %>





