<%@page import="inquiry.dto.InquiryBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% InquiryBoard inquiryDetail = (InquiryBoard) request.getAttribute("inquiryDetail"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

function back (){
	
	location.href="/homett/inquirylist";
	console.log ("이전으로")
	
}



</script>

<body>


<table>

<tr>
	<td>글번호</td>
	<td><%=inquiryDetail.getInquiryArticleNumber() %>

	<td>작성일</td>
	<td><%=inquiryDetail.getInquiryDate() %>

</tr>
<tr>
	<td>닉네임</td>
	<td><%=inquiryDetail.getUserNick() %></td>
</tr>


<tr>
	<td>제목</td>
	<td><%=inquiryDetail.getInquiryArticleTitle() %>
</tr>

<tr>
	<td>문의사항</td>
	<td><%=inquiryDetail.getInquiryContent() %></td>


</tr>


</table>

<div>

	<button id="btnList" onclick="back()">목록</button>
	<button id="btnUpdate">수정</button>
	<button id="btnDelete">삭제</button>
	


</div>


</body>
</html>