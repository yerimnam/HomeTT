<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/layout/header.jsp" />



<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');


html, body, pre, h1, h2, h3, h4, h5, h6, dl, dt, dd, ul, li, ol, th, td, p, blockquote, form, fieldset, legend, menu, nav, section, hgroup, article, header, aside, footer, input, select, textarea, button {
    margin: 0;
    padding: 0;
    font-family: ‘SUIT Variable’, sans-serif;
}

li{
	list-style:none;
}

a{
	color: #666666;
}


#main {
    margin: 10px 10px 10px 493px;
    font-weight: 600;
    width: 380px;
    height: 50px;
    text-align: center;
    font-size: 38px;
    font-family: 'SUIT';
    color: #ffde59;

}
#create {
    width: 100px;
    height: 50px;
    background-color: #ffde59;
    border: none;
    border-radius: 10px;
    font-size: 16px;
    color: #ffffff;
    font-weight: 600;
    text-align: center;
    line-height: 54px;
    float: none;
    margin: -10px 33px -139px 470px
}

form {
	margin: 50px 10px 60px 500px;
	right: 50px;
}

.formdiv {
	margin: 79px 49px 68px 214px;
    text-align: center;
    padding: 34px 10px 10px 10px;

}

#ott {
    color: #666666;
    font-size: 20px;
    font-weight: 600;
    margin: 10px 10px 10px 10px;
}

#ottMent > li > a {
	color: #666666;
    font-size: 20px;
    font-weight: 600;
    margin: 10px 10px 10px 10px;

}


.partyinfo {
	display: none;
    border: none;
    border-radius: 4px;
    background-color: #FFEEAA;
    padding: 47px 26px 65px 153px;
    margin: 81px 116px 49px 215px;
    width: 600px;
    
	}
	
.partyname {
	font-size: 20px;
	
}


</style>



<!-- 부트스트랩 Bootstrap3 -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"> -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> -->


<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">



$(document).ready(function() {
 $("#ottMenu .nf").click(function() {
	 
	 $(".partyinfo").hide()
	 
	 var cl = $(this).attr("class")
	$(".01").attr("id", cl);
	 
	 	 $("#"+cl).show()
	 	$(".partykind").attr("value", "넷플릭스");
	 	 

 })
 
  $("#ottMenu .dp").click(function() {
	 
		 $(".partyinfo").hide()
		 
		 var cl = $(this).attr("class")
		$(".02").attr("id", cl);
		 	 $("#"+cl).show()
		 	$(".partykind").attr("value", "디즈니플러스");

	 })
 
  $("#ottMenu .tv").click(function() {
	 
		 $(".partyinfo").hide()
		 
		 var cl = $(this).attr("class")
		$(".partyinfo 03").attr("id", cl);
		 	 $("#"+cl).show()
		 	$(".partykind").attr("value", "티빙");

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

		$(".today").html(today)
		

		
		
		// 개월수 선택
		$(".selectMonth").change(function() {
			var value = $(".selectMonth option:selected").val();
			var endDate = new Date()
			endDate = new Date(endDate.setMonth(endDate.getMonth() + parseInt(value)));
			var parseEndDate = parseDate(endDate)
			
			// 종료일
			$(".endDate").html(parseEndDate)
			
			$(".endDateinput").attr('value', parseEndDate)
			
			
			// 결제 금액 
			var cost = 4000
			var pay = cost * value
			$(".pay").html(pay)
			
			$('.payInput').attr('value', pay);
			
			
			
			//이렇게 하면 12월 지났을때 년도가 올라가지 않는다..
			//var endMonth = parseInt(month) + parseInt(value)
			//endDate = year+"/"+endMonth+"/"+date
			
		})

	})
</script>

<style>



</style>
</head>
<body>


<h1 id="main" style="color: ffde59;">파티 만들기</h1>
<hr>

<form action="/homett/createparty" method="post">

<div class= "formdiv" style="border: 2px solid #666666; width: 600px; " >


<label for="partykind">
<input type="hidden" id ="partykind" name="partykind" value=""> <span id="ott">OTT 선택</span>

<ul id="ottMenu">
	<li><a class="nf" data-value="넷플릭스">넷플릭스</a></li>
	<li><a class="dp" data-value="디즈니플러스">디즈니 플러스</a></li>
	<li><a class="tv" data-value="티빙">티빙</a></li>
	<li><a class="ap" data-value="애플">애플</a></li>
	<li><a class="wv" data-value="웨이브">웨이브</a></li>
	<li><a class="wa" data-value="왓챠">왓챠</a></li>
	<li><a class="la" data-value="라프텔">라프텔</a></li>

</ul>

</label>

</div>


<div class="partyinfo 01" id="nf">

<div class="partyname">
<label for="partyname">Netflix</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="text" id="partymember" name="partymember"> <br>
</div>

<!-- <div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="endtDate">
</div> -->


<div class="today">
오늘 날짜는<div class="today"></div> 입니다.
</div>

<br>

<div>
<select name="selectMonth" class="selectMonth">
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
종료일은 <span class="endDate"></span> 입니다.
<input type="hidden" class="endDateinput" name="endDate"> </div>

<br>

<div> 결제 금액은 <span class="pay"></span>원 입니다.
<input type="hidden" class="payInput" name="pay"> </div>


<div class="rule">
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>



<!-- 디즈니 -->
<div class="partyinfo 02" id="dp">

<div class="partyname">
<label for="partyname">Disney Plus</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="text" id="partymember" name="partymember"> <br>
</div>

<div>
오늘 날짜는 <div class="today"></div> 입니다.
</div>

<br>

<div>
<select name="selectMonth" class="selectMonth">
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
종료일은 <span class="endDate"></span> 입니다.
<input type="hidden" class="endDateinput" name="endDate"> </div>

<br>

<div> 결제 금액은 <span class="pay"></span>원 입니다.
<input type="hidden" class="payInput" name="pay"> </div>


<div>
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>





<!-- 티빙 -->
<div class="partyinfo 03" id="tv">

<div class="partyname">
<label for="partyname">TVING</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="text" id="partymember" name="partymember"> <br>
</div>


<div>
오늘 날짜는 <div class="today"></div> 입니다.
</div>

<br>

<div>
<select name="selectMonth" class="selectMonth">
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
종료일은 <span class="endDate"></span> 입니다.
<input type="hidden" class="endDateinput" name="endDate"> </div>

<br>

<div> 결제 금액은 <span class="pay"></span>원 입니다.
<input type="hidden" class="payInput" name="pay"> </div>


<div>
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>


<!-- 애플 -->

<div class="partyinfo" id="ap">
<div class="partyname">
<label for="partyname">Apple TV</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="text" id="partymember" name="partymember"> <br>
</div>

<!-- <div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="endtDate">
</div> -->

<div>
오늘 날짜는 <div class="today"></div> 입니다.
</div>

<br>

<div>
<select name="selectMonth" class="selectMonth">
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
종료일은 <span class="endDate"></span> 입니다.
<input type="hidden" class="endDateinput" name="endDate"> </div>

<br>

<div> 결제 금액은 <span class="pay"></span>원 입니다.
<input type="hidden" class="payInput" name="pay"> </div>


<div>
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>



<!-- 웨이브 -->


<div class="partyinfo" id="wv">
<div class="partyname">
<label for="partyname">Wave</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="text" id="partymember" name="partymember"> <br>
</div>

<!-- <div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="endtDate">
</div> -->

<div>
오늘 날짜는 <div class="today"></div> 입니다.
</div>

<br>

<div>
<select name="selectMonth" class="selectMonth">
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
종료일은 <span class="endDate"></span> 입니다.
<input type="hidden" class="endDateinput" name="endDate"> </div>

<br>

<div> 결제 금액은 <span class="pay"></span>원 입니다.
<input type="hidden" class="payInput" name="pay"> </div>


<div>
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>



<!-- 왓챠 -->

<div class="partyinfo" id="wa">
<div class="partyname">
<label for="partyname">WATCHA</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="text" id="partymember" name="partymember"> <br>
</div>

<!-- <div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="endtDate">
</div> -->

<div>
오늘 날짜는 <div class="today"></div> 입니다.
</div>

<br>

<div>
<select name="selectMonth" class="selectMonth">
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
종료일은 <span class="endDate"></span> 입니다.
<input type="hidden" class="endDateinput" name="endDate"> </div>

<br>

<div> 결제 금액은 <span class="pay"></span>원 입니다.
<input type="hidden" class="payInput" name="pay"> </div>


<div>
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>



<!-- 라프텔 -->

<div class="partyinfo" id="la">
<div class="partyname">
<label for="partyname">LAFTEL</label>
</div>

<div>
<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>
</div>

<div>
<label for="partymember">모집 멤버</label>
<input type="text" id="partymember" name="partymember"> <br>
</div>

<!-- <div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label><br>
<input type="date" id="shareperiod" name="endtDate">
</div> -->

<div>
오늘 날짜는 <div class="today"></div> 입니다.
</div>

<br>

<div>
<select name="selectMonth" class="selectMonth">
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
종료일은 <span class="endDate"></span> 입니다.
<input type="hidden" class="endDateinput" name="endDate"> </div>

<br>

<div> 결제 금액은 <span class="pay"></span>원 입니다.
<input type="hidden" class="payInput" name="pay"> </div>


<div>
<label for="partyrule">계정 공유 규칙</label><br>
<textarea id="partyrule" name="partyrule"> </textarea>
</div>

</div>



<br>
<button id="create">만들기</button>

</form>


</body>

<jsp:include page="/WEB-INF/layout/footer.jsp" />
