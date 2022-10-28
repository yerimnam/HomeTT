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

<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');
header {
	font-family: 'SUIT';
}
</style>

<style type="text/css">

</style>

</head>
<body>

<header>
	<div id="log" style="width: 1600px; margin: 20px auto; margin-right: 320px;" class="text-right">
		<button id="login">로그인</button>
		<button id="logout">로그아웃</button>
	</div>

	<div style="display: flex; justify-content: center; height: 50px; font-size: 18px; font-weight: bold;">
		<ul class="nav nav-pills">
	  		<li role="presentation" class="active text-center" style="margin-right: 50px;"><a href="./adminmain">HomeTT ADMIN</a></li>
	        <li role="presentation"class="dropdown" style="margin-right: 50px;">
	    		<a style="color:black;" class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
	      				PARTY <span class="caret"></span></a>
	    	  	<ul class="dropdown-menu" role="menu">
		    	  	<li><a href="#">PARTY 관리</a></li>
		            <li><a href="#">후기 관리</a></li>
		        </ul>
	        </li>
	        <li role="presentation"class="dropdown" style="margin-right: 50px;">
	    		<a style="color:black;" class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
	      				회원정보 <span class="caret"></span></a>
	    	  	<ul class="dropdown-menu" role="menu">
		    	  	<li><a href="./aduserdetails">회원 정보 관리</a></li>
		            <li><a href="./addropuserdetails">탈퇴 회원 관리</a></li>
		        </ul>
	        </li>
	        <li role="presentation"class="dropdown" style="margin-right: 50px;">
	    		<a style="color:black;" class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
	      				통계 <span class="caret"></span></a>
	    	  	<ul class="dropdown-menu" role="menu">
		    	  	<li><a href="./dailystatistics">일별 통계</a></li>
		            <li><a href="./monthlystatistics">월별 통계</a></li>
		        </ul>
	        </li>
	        <li role="presentation"class="dropdown" style="margin-right: 50px;">
	    		<a style="color:black;" class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
	      				고객센터 <span class="caret"></span></a>
	    	  	<ul class="dropdown-menu" role="menu">
		    	  	<li><a href="#">공지사항</a></li>
		            <li><a href="#">이벤트</a></li>
		            <li><a href="#">FAQ</a></li>
		            <li><a href="./adinquirylist">1:1문의</a></li>
		        </ul>
	        </li>
	       	<li role="presentation" style="margin-right: 50px;"><a style="color:black;" href="./adpaymentlist">결제 관리</a></li>
	        <li role="presentation"><a style="color:black;" href="./adreportlist">신고 관리</a></li>
		</ul>
	</div>
	
</header>

