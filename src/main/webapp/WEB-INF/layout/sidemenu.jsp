<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xdomain/0.8.2/xdomain.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<style type="text/css">
#sMenuT {
  list-style-type: none;
  padding: 0px;
  margin: 0px;
  width: 240px;
  background: #fffcee;
  height: 100%;
  overflow: auto;
  position: fixed;
}

#sMenu a {
  text-decoration: none;
  padding: 10px;
  display: block;
  color: #000;
  font-weight: bold;
}

#sMenu span {
  text-decoration: none;
  padding: 10px;
  display: block;
  color: #000;
  font-weight: bold;
}

#sMenu a:hover {
  background: #ffd925;
  color: #fff;
}

#sMenu span.home {
  background : #ffd925;
  color: #fff;
}


</style>

</head>

<body>

<div id="sMenuContainer">
	<ul id="sMenuT">
	  <li id="sMenu"><span class="home">결제/포인트 관리</span></li>
	  <li id="sMenu"><a href="#">결제 수단 관리</a></li>
	  <li id="sMenu"><a href="#">결제 내역</a></li>
	  <li id="sMenu"><a href="#">정산 등록</a></li>
	  <li id="sMenu"><a href="#">정산 내역</a></li>
	  <li id="sMenu"><a href="#">포인트 충전</a></li>
	  <li id="sMenu"><a href="#">포인트 내역</a></li>
	  <li id="sMenu"><span class="home">찜하기 관리</span></li>
	  <li id="sMenu"><a href="#">찜 목록 조회</a></li>
	  <li id="sMenu"><span class="home">1:1 문의</span></li>
	  <li id="sMenu"><a href="#">1:1 문의하기</a></li>
	  <li id="sMenu"><a href="#">1:1 문의 내역</a></li>
	  <li id="sMenu"><span class="home">신고 관리</span></li>
	  <li id="sMenu"><a href="#">파티장 신고 관리</a></li>
	  <li id="sMenu"><a href="#">파티원 신고 관리</a></li>
	</ul>
</div>

</body>
</html>