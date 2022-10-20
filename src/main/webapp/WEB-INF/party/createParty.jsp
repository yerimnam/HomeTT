<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파티 생성 페이지</title>

<script type="text/javascript">


</script>
</head>
<body>


<h1>파티 만들기</h1>
<hr>

<form action="/homett/createparty" method="post">

<div style="border: 2px solid black;" >
<label for="shareott">
<input type="hidden" id ="shareott"> OTT 선택
<ul>
	<li><a href="">넷플릭스</a></li>
	<li><a href="">디즈니 플러스</a></li>
	<li><a href="">티빙</a></li>
	<li><a href="">애플</a></li>
	<li><a href="">웨이브</a></li>
	<li><a href="">왓챠</a></li>
	<li><a href="">라프텔</a></li>
</ul>
</label> <br>

<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>

<label for="memberselect">모집 멤버</label>
<input type="number" id="memberselect"> <br>
<!-- <button type="button" id="btnnext" onclick="">다음</button><Br> -->
</div><br><br>

<div style="border: 2px solid black;">
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="startDate">
<input type="date" id="shareperiod" name="endDate">

<!-- <button type="button" id="btnperiod" onclick="">확인</button> -->



<label for="partyrule">계정 공유 규칙</label><br>
<input type="text" id="partyrule" name="partyrule">

<!-- <button type="button" id="btnrule" onclick="">확인</button> -->
</div>

<br>
<button>다음 화면으로</button>

</form>


</body>
</html>