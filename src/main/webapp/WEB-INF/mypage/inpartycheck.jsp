<%@page import="partyCheck.dto.PartyCheck"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMETT</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
#header, #footer {
	text-align: center;
	background: #555ac0;
	color: #cddfe0;
}

#header h1 a {
	text-decoration: none;
	color: #555ac0;
}


</style>

</head>
<body>

<div class="container">


<header id="header">
	<h1>파티방 목록</h1>
</header>

<table class="table table-striped table-hover table-condensed">


<div
>
	<span>파티제목</span><br>
	<span>파티장</span><br>
	<span>파티 만료일</span><br>
	<span>모집인원</span><br>
	<span>참여금액</span>
</div>

<div id="party">
	<span>파티제목</span><br>
	<span>파티장</span><br>
	<span>파티 만료일</span><br>
	<span>모집인원</span><br>
	<span>참여금액</span>
</div>

<div id="party">
	<span>파티제목</span><br>
	<span>파티장</span><br>
	<span>파티 만료일</span><br>
	<span>모집인원</span><br>
	<span>참여금액</span>
</div>



</table>


</div><!-- .container end -->

<footer id="footer" class="text-center">
	<small>HOMETT is Funny~!</small>
</footer>

</body>
</html>