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
$(document).ready(function() {
	$("#btnlogout").click(function() {
		console.log("#btnlogout 클릭")

</script>

<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');
header {
	font-family: 'SUIT';
}
</style>

</head>
<body>

<header>
	<div id="log" style="width: 1600px; margin: 20px 0 10px -40px;" class="text-right">
		<button id="homettmain" class="btn" style="margin-right: 10px; font-weight: bold;" 
			onclick="location.href='/homett/main'">HommTT 사이트로 가기</button>
		<button id="btnlogout" class="btn" style="font-weight: bold;" 
			onclick="location.href='/homett/adminlogout'">로그아웃</button>
	</div>

	<div style="display: flex; justify-content: center; height: 50px; font-size: 18px; font-weight: bold;">
		<ul class="nav nav-pills">
	  		<li role="presentation" class="active text-center" style="margin-right: 50px;"><a href="./adminmain">HomeTT ADMIN</a></li>
	        <li role="presentation"class="dropdown" style="margin-right: 50px;">
	    		<a style="color:black;" class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
	      				PARTY <span class="caret"></span></a>
	    	  	<ul class="dropdown-menu" role="menu">
		    	  	<li><a href="./adpartylist">PARTY 관리</a></li>
		            <li><a href="./reviewlist">후기 관리</a></li>
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
		    	  	<li><a href="./noticelist">공지사항</a></li>
		            <li><a href="./eventlist">이벤트</a></li>
		            <li><a href="./faqlist">FAQ</a></li>
		            <li><a href="./adinquirylist">1:1문의</a></li>
		        </ul>
	        </li>
	       	<li role="presentation" style="margin-right: 50px;"><a style="color:black;" href="./adpaymentlist">결제 관리</a></li>
	        <li role="presentation"><a style="color:black;" href="./adreportlist">신고 관리</a></li>
		</ul>
	</div>
	
</header>

