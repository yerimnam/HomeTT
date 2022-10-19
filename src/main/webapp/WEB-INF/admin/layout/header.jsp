<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomeTT Admin</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js"></script>

<script type="text/javascript">

</script>

</head>
<body>

<header>
	<div style="height: 20px"></div>
	<div id="log">
		<button id="login">로그인</button>
		<button id="logout">로그아웃</button>
	</div>
	
	<div style="display: flex; justify-content: center; height: 50px;">
		<ul class="nav nav-pills">
	  		<li role="presentation" class="active text-center""><a href="#">HomeTT ADMIN</a></li>
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
	      				포인트/결제 <span class="caret"></span></a>
	    	  	<ul class="dropdown-menu" role="menu">
		    	  	<li><a href="#">포인트</a></li>
		            <li><a href="#">결제 관리</a></li>
		            <li><a href="#">쿠폰 관리</a></li>
		        </ul>
	        </li>
	        <li role="presentation"><a href="#">신고 관리</a></li>
		</ul>
	</div>
	
</header>

