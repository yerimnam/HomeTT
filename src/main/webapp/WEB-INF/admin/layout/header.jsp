<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomeTT Admin</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.js"></script>

<script type="text/javascript">

</script>

<style type="text/css">

/* li { */
/* 	list-style:none */
/* } */

/* a { */
/* 	text-decoration:none; */
/* 	font-size:14px */
/* } */

/* .menu { */
/*   width: 1200px; */
/*   overflow: hidden; */
/*   margin: 20px auto; */
/*   margin-bottom: 30px; */
/* } */

/* .menu > li { */
/*   width: 12%; /*20*5=100%*/ */
/*   float: left; */
/*   text-align: center; */
/*   line-height: 40px; */
/*   background-color: #5778ff; */
  
/* } */

/* .menu a { */
/*   color: #fff; */
/* } */

/* .submenu > li { */
/*   line-height: 50px; */
/*   background-color: #94a9ff; */
/* } */

/* ul { */
/* 	margin: 0; */
/* 	padding: 0; */
	
/* } */

/* .submenu { */
/*   height: 0; /*ul의 높이를 안보이게 처리*/ */
/*   overflow: hidden; */
/* } */

/* .menu > li:hover { */
/*   background-color: #94a9ff; */
/*   transition-duration: 0.5s; */
/* } */

/* .menu > li:nth-child(3):hover .submenu { */
/*   height: 100px;  */
/*   transition-duration: 1s; */
/* } */

/* .menu > li:nth-child(4):hover .submenu { */
/*   height: 100px; */
/*   transition-duration: 1s; */
/* } */

/* .menu > li:nth-child(5):hover .submenu { */
/*   height: 100px; */
/*   transition-duration: 1s; */
/* } */

/* .menu > li:nth-child(6):hover .submenu { */
/*   height: 200px; */
/*   transition-duration: 1s; */
/* } */

/* .menu > li:nth-child(7):hover .submenu { */
/*   height: 100px;  */
/*   transition-duration: 1s; */
/* } */

</style>

</head>
<body>

<header>
	<div id="log" style="width: 1600px; margin: 20px auto; margin-right: 320px;" class="text-right">
		<button id="login">로그인</button>
		<button id="logout">로그아웃</button>
	</div>

<!-- <ul class="menu"> -->
<!-- 	<li> -->
<!-- 	<a href="#">HomeTT ADMIN</a> -->
<!-- 	</li> -->
<!-- 	<li> -->
<!-- 	<a href="#">관리자 계정</a> -->
<!-- 	</li> -->
<!-- 	<li> -->
<!--     <a href="#">PARTY</a> -->
<!--     <ul class="submenu"> -->
<!--     	<li><a href="#">PARTY 관리</a></li> -->
<!--     	<li><a href="#">후기 관리</a></li> -->
<!--     </ul> -->
<!-- 	</li> -->
<!-- 	<li> -->
<!-- 	<a href="#">회원정보</a> -->
<!-- 	<ul class="submenu"> -->
<!-- 		<li><a href="#">회원 정보 관리</a></li> -->
<!-- 		<li><a href="#">탈퇴 회원 관리</a></li> -->
<!-- 	</ul> -->
<!-- 	</li> -->
<!-- 	<li> -->
<!-- 	<a href="#">통계</a> -->
<!-- 	<ul class="submenu"> -->
<!-- 		<li><a href="#">일 통계</a></li> -->
<!-- 		<li><a href="#">월 통계</a></li> -->
<!-- 	</ul> -->
<!-- 	</li> -->
<!-- 	<li> -->
<!-- 	<a href="#">고객센터</a> -->
<!-- 	<ul class="submenu"> -->
<!-- 		<li><a href="#">공지사항</a></li> -->
<!--         <li><a href="#">이벤트</a></li> -->
<!--         <li><a href="#">FAQ</a></li> -->
<!--         <li><a href="#">1:1문의</a></li> -->
<!-- 	</ul> -->
<!-- 	</li> -->
<!-- 	<li> -->
<!-- 	<a href="#">결제</a> -->
<!-- 	<ul class="submenu"> -->
<!-- 		<li><a href="#">결제 관리</a></li> -->
<!-- 		<li><a href="#">쿠폰 관리</a></li> -->
<!-- 	</ul> -->
<!-- 	</li> -->
<!-- 	<li> -->
<!-- 	<a href="#">신고 관리</a> -->
<!-- 	</li> -->
<!-- </ul> -->

	<div style="display: flex; justify-content: center; height: 50px;">
		<ul class="nav nav-pills">
	  		<li role="presentation" class="active text-center"><a href="#">HomeTT ADMIN</a></li>
	  		<li role="presentation"><a href="#">관리자 계정</a></li>
	        <li role="presentation"class="dropdown">
	    		<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
	      				PARTY <span class="caret"></span></a>
	    	  	<ul class="dropdown-menu" role="menu">
		    	  	<li><a href="#">PARTY 관리</a></li>
		            <li><a href="#">후기 관리</a></li>
		        </ul>
	        </li>
	        <li role="presentation"class="dropdown">
	    		<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
	      				회원정보 <span class="caret"></span></a>
	    	  	<ul class="dropdown-menu" role="menu">
		    	  	<li><a href="#">회원 정보 관리</a></li>
		            <li><a href="#">탈퇴 회원 관리</a></li>
		        </ul>
	        </li>
	        <li role="presentation"class="dropdown">
	    		<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
	      				통계 <span class="caret"></span></a>
	    	  	<ul class="dropdown-menu" role="menu">
		    	  	<li><a href="#">일별 통계</a></li>
		            <li><a href="#">월별 통계</a></li>
		        </ul>
	        </li>
	        <li role="presentation"class="dropdown">
	    		<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
	      				고객센터 <span class="caret"></span></a>
	    	  	<ul class="dropdown-menu" role="menu">
		    	  	<li><a href="#">공지사항</a></li>
		            <li><a href="#">이벤트</a></li>
		            <li><a href="#">FAQ</a></li>
		            <li><a href="#">1:1문의</a></li>
		        </ul>
	        </li>
	        <li role="presentation"class="dropdown">
	    		<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
	      				결제 <span class="caret"></span></a>
	    	  	<ul class="dropdown-menu" role="menu">
		            <li><a href="#">결제 관리</a></li>
		            <li><a href="#">쿠폰 관리</a></li>
		        </ul>
	        </li>
	        <li role="presentation"><a href="/homett/adreportlist">신고 관리</a></li>
		</ul>
	</div>
	
</header>

