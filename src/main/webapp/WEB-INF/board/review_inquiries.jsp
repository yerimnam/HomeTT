<%@page import="reviewBoard.dto.ReviewBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <% List<ReviewBoard> reviewboardList = (List)request.getAttribute("reviewboardList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>하이</title>
<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style>

.reviewmain {
width: 68%;
    height: 750px;
    /* border: 1px solid #000; */
    margin-top: 12%;
    margin-left: 12%;
}
.list {
    width: 32%;
    height: 273px;
    list-style: none;
    border: 1px solid #000;
    float: left;
    margin-bottom: 29px;
    margin-block: 44px;
    margin-block-end: 24px;
    /* margin-block-start: 136px; */
    margin-top: 77px;
    /* margin-left: -15%; */
    /* margin-inline: 292px; */
    margin-inline-end: -224px;
    margin-inline-start: 274px;
}

.letter {
	position: relative;
/* 	left: 0; */
	top: 250px;
}


</style>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnWrite").click(function() {
		location.href = "./reviewcreate"
	})
})
</script>

</head>
<body>
<table>

<tr>
	<th style="width: 15%;">글번호</th>
	<th style="width: 30%;">제목</th>
	<th style="width: 20%;">작성자</th>
	<th style="width: 15%;">조회수</th>
	<th style="width: 20%;">작성일</th>
</tr>

<%	for(int i=0; i<reviewboardList.size(); i++) { %>
<tr>
	<td><%=reviewboardList.get(i).getReviewArticlenumber() %></td>
	<td>
		<a href="./reviewview?reviewArticlenumber=<%=reviewboardList.get(i).getReviewArticlenumber() %>">
			<%=reviewboardList.get(i).getReviewArticletitle() %>
		</a>
	</td>
	<td><%=reviewboardList.get(i).getUserName() %></td>
	<td><%=reviewboardList.get(i).getHit() %></td>
	<td><%=reviewboardList.get(i).getReviewDate() %></td>
</tr>
<%	} %>
</table>

<div id="btnBox">
	<button id="btnWrite" class="btn">글쓰기</button>
</div>

</body>
</html>