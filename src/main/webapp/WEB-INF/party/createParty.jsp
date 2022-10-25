<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파티 생성 페이지</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">




$(document).ready(function() {
 $("#ottMenu a").click(function() {
	 
	 $(".partyinfo").hide()
	 
	 var cl = $(this).attr("class")
	 $("#"+cl).show()
 })
 
 
})

// $(document).readt(function() {
// 	 $("#btnnext").click(function() {

// 		 $(".optionbox").hide()
		 
// 		 var c2 = $(this).attr("class")
// 		 $("#"+c2).show()
// 	 })
	
// })

</script>

<style>
.partyinfo {
	display: none;
}


</style>
</head>
<body>


<h1>파티 만들기</h1>
<hr>

<form action="/homett/createparty" method="post">

<div style="border: 2px solid black;" >


<label for="partykind">
<input type="hidden" id ="partykind"> OTT 선택
</label>

<ul id="ottMenu">
	<li><a class="nf" name="partykind">넷플릭스</a></li>
	<li><a class="df" name="partykind">디즈니 플러스</a></li>
	<li><a class="tv" name="partykind">티빙</a></li>
	<li><a class="ap" name="partykind">애플</a></li>
	<li><a class="wv" name="partykind">웨이브</a></li>
	<li><a class="wa" name="partykind">왓챠</a></li>
	<li><a class="la" name="partykind">라프텔</a></li>
<!-- 	<li><a href="" >넷플릭스</a></li> -->
<!-- 	<li><a href="">디즈니 플러스</a></li> -->
<!-- 	<li><a href="">티빙</a></li> -->
<!-- 	<li><a href="">애플</a></li> -->
<!-- 	<li><a href="">웨이브</a></li> -->
<!-- 	<li><a href="">왓챠</a></li> -->
<!-- 	<li><a href="">라프텔</a></li> -->
</ul>

</div>


<div class="partyinfo" id="nf">

<div>
<label for="partyname">Netflix</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="number" id="partymember" name="partymember"> <br>
<!-- <button type="button" id="btnnext">다음</button><Br> -->
</div>

<div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="endtDate">
</div>

<div>
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>


<div class="partyinfo" id="df">

<div>
<label for="partyname">Disney Plus</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="number" id="partymember" name="partymember"> <br>
<!-- <button type="button" id="btnnext" onclick="btnclick()">다음</button><Br> -->
</div>

<div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="endtDate">
</div>

<div>
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>


<div class="partyinfo" id="tv">
<div>
<label for="partyname">TVING</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="number" id="partymember" name="partymember"> <br>
<!-- <button type="button" id="btnnext" onclick="btnclick()">다음</button><Br> -->
</div>

<div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="endtDate">
</div>

<div>
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>


<div class="partyinfo" id="ap">
<div>
<label for="partyname">Apple TV</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="number" id="partymember" name="partymember"> <br>
<!-- <button type="button" id="btnnext" onclick="btnclick()">다음</button><Br> -->
</div>

<div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="endtDate">
</div>

<div>
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>



<div class="partyinfo" id="wv">
<div>
<label for="partyname">Wave</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="number" id="partymember" name="partymember"> <br>
<!-- <button type="button" id="btnnext" onclick="btnclick()">다음</button><Br> -->
</div>

<div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="endtDate">
</div>

<div>
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>



<div class="partyinfo" id="wa">
<div>
<label for="partyname">WATCHA</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="number" id="partymember" name="partymember"> <br>
<!-- <button type="button" id="btnnext" onclick="btnclick()">다음</button><Br> -->
</div>

<div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="endtDate">
</div>

<div>
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>



<div class="partyinfo" id="la">
<div>
<label for="partyname">LAFTEL</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="number" id="partymember" name="partymember"> <br>
<!-- <button type="button" id="btnnext" onclick="btnclick()">다음</button><Br> -->
</div>

<div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="endtDate">
</div>

<div>
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>

<hr>


</div>

<br>
<button>다음 화면으로</button>

</form>


</body>
</html>