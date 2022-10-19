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

<div>
<label for="sharott">선택한 OTT</label> <br>

<label for="partyname">파티명</label>
<input type="text" id="partyname" name="partyname"><br>

<label for="memberselect">모집 멤버</label> <br>
<button type="button" id="btnnext" onclick="">다음</button><Br>
</div>

<div>
<label for="shareperiod"><a href="">계정 공유 기간</a></label>

<input type="text" id="startDate">
<input type="text" id="endDate">

<button type="button" id="btnperiod" onclick="">확인</button>


<label for="partyrule">계정 공유 규칙</label> 
<input type="text" id="partyrule" name="partyrule">

<button type="button" id="btnrule" onclick="">확인</button>
</div>

</form>

<button type="button" id="submitpay" onclick="">다음 화면으로</button>

</body>
</html>