<%@page import="calculate.dto.Calculate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
  request.setAttribute("minDate", "2022-04-10");
  request.setAttribute("maxDate", "2022-10-25");
%>

<%-- 모델값 전달받기 --%>
<%	List<Calculate> calculateList = (List) request.getAttribute("calculateList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculate Check</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<script type="text/javascript">
window.onload = function() {
	today = new Date();
	console.log("today.toISOString() >>>" + today.toISOString());
	today = today.toISOString().slice(0, 10);
	console.log("today >>>> " + today);
	bir = document.getElementById("todaybirthday");
	bir.value = today;
}

var now_utc = Date.now() // 지금 날짜를 밀리초로
//getTimezoneOffset()은 현재 시간과의 차이를 분 단위로 반환
var timeOff = new Date().getTimezoneOffset()*60000; // 분단위를 밀리초로 변환
//new Date(now_utc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
var today = new Date(now_utc-timeOff).toISOString().split("T")[0];
document.getElementById("Date").setAttribute("max", today);

</script>

<style type="text/css">
.container {
	display: flex;
	justify-content: center;
	margin-top: 50px;
	margin-bottom: 90px;
	/* column-gap: 50px; */
	gap: 50px;	
}

.dateform {
	display: inline-block;
	float: right; 

}

</style>

</head>
<body>

<h1>정산 내역</h1>
<hr>


<h3 style="float: left;">정산 내역 조회</h3><br>
<hr style="font-weight: 1px;">

<form action="" class="dateform">

<label>
	<input type="date" id="todaybirthday"></input>
</label>
 ~ 
<label>
    <input type="date" min="${minDate}" max="${maxDate}">
</label>


<table>
	<tr>
	<td valgn="top">
		<select name="items1">
			<option value="week">7일</option>
			<option value="1month">1개월</option>
			<option value="3month">3개월</option>
			<option value="6month">6개월</option>
		</select>
	</td>
    </tr>
</table>
<button type="submit" value="검색하기"></button>

</form>


<table class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 30%;">정산일</th>
	<th style="width: 30%;">정산금액</th>
	<th style="width: 40%;">정산파티</th>
</tr>

<%	for(int i = 0; i < calculateList.size(); i++) { %>
<tr>
	<td><%=calculateList.get(i).getCalculateDate() %></td>
	<td><%=calculateList.get(i).getPaymentAmount() %></td>
	<td><%=calculateList.get(i).getPartyNo() %></td>
</tr>
<%	} %>





</body>
</html>