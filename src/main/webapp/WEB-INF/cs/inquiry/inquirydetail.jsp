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

function update(){
		console.log("수정하기")
	alert("수정하시겠습니까?")
	location.href="/homett/inquiryupdate?inquiryNo=<%=inquiryDetail.getInquiryArticleNumber()%>";
	}
	
function deleteinquiry(){
	
	console.log("삭제하기")
	confirm("삭제 하시겠습니까?")
	location.href="/homett/inquirydelete?inquiryNo=<%=inquiryDetail.getInquiryArticleNumber()%>";

}
</script>

<body>

<%if(inquiryDetail.getAnswercontent() == null ) {%>
<table>

<tr>
	<td>글번호</td>
	<td><%=inquiryDetail.getInquiryArticleNumber() %>

	<td>작성일자</td>
	<td><%=inquiryDetail.getInquiryDate() %>


</tr>
<tr>
	<td>닉네임</td>
	<td><%=inquiryDetail.getUserNick() %></td>
</tr>


<tr>
	<td>제목</td>
	<td><%=inquiryDetail.getInquiryArticleTitle() %></td>
</tr>

<tr>
	<td>문의사항</td>
	<td><%=inquiryDetail.getInquiryContent() %></td>


</tr>


</table>

<div>

	<button id="btnList" onclick="back()">목록</button>
	<button id="btnUpdate" onclick="update()">수정</button>
	<button id="btnDelete" onclick="deleteinquiry()">삭제</button>


</div>
<%} else {%>

<table>

<tr>
	<td>글번호</td>
	<td><%=inquiryDetail.getInquiryArticleNumber() %>

	<td>작성일자</td>
	<td><%=inquiryDetail.getInquiryDate() %>


</tr>
<tr>
	<td>닉네임</td>
	<td><%=inquiryDetail.getUserNick() %></td>
</tr>


<tr>
	<td>제목</td>
	<td><%=inquiryDetail.getInquiryArticleTitle() %></td>
</tr>

<tr>
	<td>문의사항</td>
	<td><%=inquiryDetail.getInquiryContent() %></td>


</tr>


</table>

<div>



<div>

	<table>
	
		<tr>
			<td>답변일</td>
			<td><%=inquiryDetail.getAnswerdate()%></td>
			<td>답변자</td>
			<td><%=inquiryDetail.getAnswerWriter() %></td>
		</tr>
		<tr>	
			<td>답변 사항</td>
			<td><%=inquiryDetail.getAnswercontent() %></td>
		</tr>
	
	</table>
	<button id="btnList" onclick="back()">목록</button>




</div>




<%} %>
</body>
</html>