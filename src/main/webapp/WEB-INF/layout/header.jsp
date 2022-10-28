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



<!-- ------------------------------------- 스크립트 시작 ------------------------------------ -->

<script type="text/javascript">
$(document).ready(function(){
	
	$(".gnb > a").mouseover(function(){
// 		alert("마우스 Over");
// 		$(this).css("color", "#ffffff");
		event.target.style.color = "#ffffff";
		});
	
	$(".gnb").mouseout(function(){
		event.target.style.color = "#666666";
	});
	
	
})




// function mover() {
	
// 	 $(this).attr("color", "#ffffff");
//  alert("마우스가 오버 됩니다.");
	
// }


</script>



<!-- ------------------------------------- 스크립트 끝 ------------------------------------ -->

<!-- 스타일 -->
<style type="text/css">

html, body, pre, h1, h2, h3, h4, h5, h6, dl, dt, dd, ul, li, ol, th, td, p, blockquote, form, fieldset, legend, menu, nav, section, hgroup, article, header, aside, footer, input, select, textarea, button {
    margin: 0;
    padding: 0;
    font-family: 'Nanum Gothic', 'Noto Sans KR', monospace, Corbel, Dotum, AppleGothic, Helvetica, sans-serif;
}

#header{
	height: 110px;
	margin: 0 auto;
	position: relative;
}

#hdTopright{
	background-color: #ffde59;
	float: right;
	width: 72%;
	height: 110px;
	border-radius: 0 0 0 90px;
	position: absolute;
	right: 0;
}

#hdTopleft{
	width: 28%;
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


.inner {
	width: 1600px;
	margin: auto;
	right: 160px;
	position: absolute;
}

.bottom {

}


#topMenu {
	width: 100%;
	height: 34px;
	line-height: 40px;
}

#topMenu > a {
	float: right;
	display: inline;
	margin: 0 10px 0 15px;
}

#bottomMenu {
	height: 76px;
	width: 1600px;
	margin-top: 42px;
}

#bottomMenu > ul {
	float: right;
	line-height: 44px;
}

#bottomMenu > ul > li {
	margin: 0 34px 0 34px;
	float: right;
}

#bottomMenu > ul > li > a {
	font-weight: 600;
    font-family: 'Noto Sans KR';
    font-size: 19px;
    color: #444444;
    text-decoration-line: none;
    position: relative;
	
}


#bottomMenu :nth-child(2) {
 	margin-right: 46px !important; 
}

#mypageBtn {
	margin-right: 0 !important;
}

#mypageBtn a.mypage {
	display: inline-block;
    font-size: 18px;
    font-weight: 600;
    font-family: 'Noto Sans KR';
    width: 184px;
    height: 44px;
    line-height: 44px;
    border-radius: 30px;
    text-align: center;
    color: #444444;
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
		
		<div class="inner top">
			<div id="topMenu">
				<a href="">로그인</a>
				<a href="">회원가입</a>
			</div><!-- topMenu end -->
		</div>	
		
		<div class="inner bottom">
			<div id="bottomMenu">
				<ul>
					<li id="mypageBtn">
						<a href="" class="mypage">마이페이지</a>
					</li>
					
					<li class="gnb">
						<a href="">파티만들기 </a>
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


	</div><!-- hdTopright -->
		
	</header>

<br><br><br><br>











