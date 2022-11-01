<%@page import="reviewBoard.dto.ReviewBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% ReviewBoard viewBoard = (ReviewBoard) request.getAttribute("viewBoard"); %>
<jsp:include page="/WEB-INF/layout/header.jsp" />

<script type="text/javascript">

 function back (){
	
	 location.href="/homett/reviewlist";
 	console.log ("이전으로")
	
 }

 function update(){
		console.log("수정하기")
 	alert("수정하시겠습니까?")
 	location.href="/homett/reviewupdate?reviewNo=<%=viewBoard.getReviewArticlenumber()%>"; 
 	}
	
 function deletereview(){
	
 	console.log("삭제하기")
 	confirm("삭제 하시겠습니까?")
 	location.href="/homett/reviewdelete?reviewNo=<%=viewBoard.getReviewArticlenumber()%>"; 

 }
</script> 
<style>
.text {
	background-color: #ffde59;
}

#big{
	width: 1600px;
	margin: 0 auto;
}

#main {
	height:500px;
}

</style>


<title>Insert title here</title>
</head>
<body>



<div id="big">
<h1><%=viewBoard.getUserName() %> 님의 후기</h1>
<table class="table table-bordered">

<tr>
	<td class= "text">글번호</td>
	<td><%=viewBoard.getReviewArticlenumber() %>

	<td class= "text">작성일</td>
	<td><%=viewBoard.getReviewDate() %>

</tr>
<tr>
	<td class= "text">작성자</td>
	<td colspan="4"><%=viewBoard.getUserName() %></td>
</tr>
<tr>
	<td class = "text">조회수</td>
	<td colspan="4"><%=viewBoard.getHit() %>
</tr>

<tr>
	<td class= "text">제목</td>
	<td colspan="4"><%=viewBoard.getReviewArticletitle() %>
</tr>

<tr>
	<td class= "text" colspan="4">이벤트 내용</td>
</tr>
<tr>
	<td colspan="4" id="main"><%=viewBoard.getReviewContent() %></td>
</tr>


</table>
</div>

<div class="text-center">

	<button id="btnList" class="btn btn-primary" onclick="back()" >목록</button>
	<button id="btnUpdate" class="btn btn-info" onclick="update()">수정</button>
	<button id="btnDelete" class="btn btn-danger" onclick="deletereview()">삭제</button>


</div>
<jsp:include page="/WEB-INF/layout/footer.jsp" />
