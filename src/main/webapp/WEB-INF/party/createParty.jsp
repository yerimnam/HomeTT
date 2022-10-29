<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파티 만들기</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">




$(document).ready(function() {
 $("#ottMenu a").click(function() {
	 
	 $(".partyinfo").hide()
	 
	 var cl = $(this).attr("class")
	 $("#"+cl).show()
 })
 
 
	//현재날짜 구해오기
		var now = new Date();
	
 	// Date 객체 날짜 문자열로 변환
		function parseDate(date) {
			var year = date.getFullYear()
			var month = date.getMonth() + 1
			var date = date.getDate()
			return year + "/" + month + "/" + date
		}

		today = parseDate(now)

		$("#today").html(today)
		

		
		
		// 개월수 선택
		$("#selectMonth").change(function() {
			var value = $("#selectMonth option:selected").val();
			var endDate = new Date()
			endDate = new Date(endDate.setMonth(endDate.getMonth() + parseInt(value)));
			var parseEndDate = parseDate(endDate)
			
			// 종료일
			$("#endDate").html(parseEndDate)
			
			$("#endDateinput").attr('value', parseEndDate)
			
			
			// 결제 금액 
			var cost = 4000
			var pay = cost * value
			$("#pay").html(pay)
			
			$('#payInput').attr('value', pay);
			
			//이렇게 하면 12월 지났을때 년도가 올라가지 않는다..
			//var endMonth = parseInt(month) + parseInt(value)
			//endDate = year+"/"+endMonth+"/"+date
			
		})

	})
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
<input type="hidden" id ="partykind" name="partykind"> OTT 선택
<ul id="ottMenu">
	<li><a class="nf" data-value="1">넷플릭스</a></li>
	<li><a class="df" data-value="2">디즈니 플러스</a></li>
	<li><a class="tv" data-value="3">티빙</a></li>
	<li><a class="ap" data-value="4">애플</a></li>
	<li><a class="wv" data-value="5">웨이브</a></li>
	<li><a class="wa" data-value="6">왓챠</a></li>
	<li><a class="la" data-value="7">라프텔</a></li>
</ul>
</label>

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
</div>

<!-- <div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="endtDate">
</div> -->

<div>
<!-- <<<<<<< HEAD -->
오늘 날짜는 <div id="today"></div> 입니다.
<!-- ======= -->
<!-- 오늘은 -->
<!-- <div id="today"></div> 입니다. -->
<!-- >>>>>>> refs/remotes/origin/Jiwon -->
</div>

<br>

<div>
<select name="selectMonth" id="selectMonth">
  <option value="0" selected>선택</option>
  <option value="1">1개월</option>
  <option value="2">2개월</option>
  <option value="3">3개월</option>
  <option value="4">4개월</option>
  <option value="5">5개월</option>
  <option value="6">6개월</option>
</select>
<span>선택시</span>
</div>

<br>

<div>
종료일은 <span id="endDate"></span> 입니다.
<input type="hidden" id="endDateinput" name="endDate"> </div>

<br>

<div> 결제 금액은 <span id="pay"></span>원 입니다.
<input type="hidden" id="payInput" name="pay"> </div>


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


<br>
<button>만들기</button>

</form>


</body>
</html>