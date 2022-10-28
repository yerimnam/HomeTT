<%@page import="reviewBoard.dto.ReviewBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% ReviewBoard viewBoard = (ReviewBoard) request.getAttribute("viewBoard"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
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
	
 function deleteevent(){
	
 	console.log("삭제하기")
 	confirm("삭제 하시겠습니까?")
 	location.href="/homett/reviewdelete?reviewNo=<%=viewBoard.getReviewArticlenumber()%>"; 

 }
</script> 
<title>Insert title here</title>
</head>
<body>

<h1>게시글 상세보기</h1>
<hr>



<table>

<tr>
	<td>글번호</td>
	<td><%=viewBoard.getReviewArticlenumber() %>

	<td>작성일</td>
	<td><%=viewBoard.getReviewDate() %>

</tr>
<tr>
	<td>작성자</td>
	<td><%=viewBoard.getReviewWriter() %></td>
</tr>


<tr>
	<td>제목</td>
	<td><%=viewBoard.getReviewArticletitle() %>
</tr>

<tr>
	<td>이벤트내용</td>
	<td><%=viewBoard.getReviewContent() %></td>


</tr>


</table>

<div>

	<button id="btnList" onclick="back()" >목록</button>
	<button id="btnUpdate" onclick="update()">수정</button>
	<button id="btnDelete" onclick="deleteevent()">삭제</button>


</div>


</body>
</html>