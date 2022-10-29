<%@page import="event.dto.EventBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 모델값 전달받기 --%>
<% List<EventBoard> eventboardList = (List)request.getAttribute("eventboardList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home TT</title>
<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>



<style>

.eventmain {
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
            location.href = "./eventcreate"
        })
    })
</script>


</head>
<body>

<h1> 이벤트 페이지</h1>

<!-- ---------------------------------------------------------------------------- -->
<!-- <div class="eventmain"> -->
<!--   <div class="list2"> -->
<!--     <div class="list"> -->
<!-- 		<div> -->
<!-- 			<img> -->
<!-- 		</div> -->
<!-- 		<img src="/HomeTT/adEvent/image/01.jpg"class="text"> -->
<!--   	 	<p class="letter">박스밑에 가야할 글</p> -->
<!--     </div> -->
    
<!--     <div class="list"> -->
<!-- 		<div> -->
<!-- 			<img> -->
<!-- 		</div> -->
<!-- 		<img src="/HomeTT/adEvent/image/01.jpg"class="text"> -->
<!-- 		<p class="letter">박스밑에 가야할 글</p> -->
<!--     </div> -->
<!--   </div> -->
  
<!--   <div class="list2"> -->
<!--     <div class="list"> -->

<!--     </div> -->
<!--     <div class="list"> -->

<!--     </div> -->
<!--   </div> -->
<!-- </div> -->
<!-- ---------------------------------------------------------------------------- -->

<table>

<tr>
	<th style="width: 15%;">글번호</th>
	<th style="width: 30%;">제목</th>
	<th style="width: 20%;">작성자</th>
	<th style="width: 15%;">조회수</th>
	<th style="width: 20%;">작성일</th>
</tr>

<%	for(int i=0; i<eventboardList.size(); i++) { %>
<tr>
	<td><%=eventboardList.get(i).getEventArticlenumber() %></td>
	<td>
		<a href="./eventview?eventArticlenumber=<%=eventboardList.get(i).getEventArticlenumber() %>">
			<%=eventboardList.get(i).getEventArticletitle() %>
		</a>
	</td>
	<td><%=eventboardList.get(i).getUserName() %></td>
	<td><%=eventboardList.get(i).getHit() %></td>
	<td><%=eventboardList.get(i).getEventDate() %></td>
</tr>
<%	} %>
</table>

 
<div id="btnBox">
	<button id="btnWrite" class="btn">글쓰기</button>
</div>


</body>
</html>