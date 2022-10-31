<%@page import="inquiry.dto.InquiryBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/layout/header.jsp" />

<% InquiryBoard inquiryDetail = (InquiryBoard) request.getAttribute("inquiryDetail"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<style type="text/css">
#inquiryBoard {
	justify-content: center;
	text-align: center;
	width: 1100px;
	height: 60px;
	border: 1px solid #00221b;
	margin-top: 25px;
	background-color: #fffcee;
	border-radius: 10px;
}

#inquiryBoard thead {
	font-weight: 600; 
	font-size: large; 
	color: #ff8c11;
}

#inquiryBoard tbody {
	font-weight: 500; 
	font-size: medium; 
	color: #002541;
}

table { 
	table-layout:fixed;
	border-collapse: collapse;
}

tr {
	border-top: 1px solid #00221b;
	border-bottom: 1px solid #00221b;
}

#tableBox {
	display: flex; 
	justify-content: center;
	margin-left: 660px;
	width: 585px;
}

#titleBox {
	display: flex; 
	justify-content: flex-end; 
	margin-right: 370px;
}

#titleBox h2 {
	font-weight: 900; 
	font-size: xx-large; 
	color: #ff8c11;
}

#th {
	text-align: center;
	padding: 5px;
	background-color: #f4df93;
	border: 1px solid #00221b;
}

#td {
	text-align: center;
	padding: 7px;
	padding-left: 3px;
}

#linktd {
	text-decoration: none !important;
	color: black;
}

#linktd:link{
	color: black;
	background-color: #fffcee; 
    transition : 0.5s; /* 속성 변경할 때 효과의 속도 조절 */
}

#linktd:visited{
	color: black;
	background-color: #fffcee; 
}

#linktd:hover { 
	color: #ff8c11;
	background-color: #fffcee; 
	text-decoration: none;
	font-size: x-large;
	font-weight: 900px;
	transition : 0.4s;
}

#linktd:active {
	color: black;
	background-color: #fffcee; 
	text-decoration: none;
}

#writeBtnBox {
	justify-content: flex-end; 
	margin-right: 715px; 
	display: flex; 
	margin-top: 40px;
}

#btn {
	border-top-left-radius: 5px;
	border-bottom-right-radius: 5px;
	margin-right: -4;
	border: 1px solid #ffeaa6;
	background-color: rgba(0,0,0,0);
	color: #585a72;
	padding: 5px;
	font-weight: 700;
	font-size: medium;
	width: 160px;
	height: 40px;
}

#btn:hover {
	color: #ff8c11;
	background-color: #fffcee;
	transition: 0.5s;	
}

</style>
</head>
<body>

<%if(inquiryDetail.getAnswercontent() == null ) {%>

<div id="tableBox">
<table id="inquiryBoard">
	
	<tr>
		<td id="td" style="width: 20%;">글번호</td>
		<td id="td"><%=inquiryDetail.getInquiryArticleNumber() %></td>
	</tr>
	
	<tr>
		<td id="td">작성일자</td>
		<td id="td"><%=inquiryDetail.getInquiryDate() %></td>
	</tr>
	
	<tr>
		<td id="td">닉네임</td>
		<td id="td"><%=inquiryDetail.getUserNick() %></td>
	</tr>
		
	<tr>
		<td id="td">제목</td>
		<td id="td"><%=inquiryDetail.getInquiryArticleTitle() %></td>
	</tr>
	
	<tr>
		<td id="td">문의사항</td>
		<td id="td"><%=inquiryDetail.getInquiryContent() %></td>
	</tr>
		
</table>
</div> <!-- tableBox div end -->

<div id="writeBtnBox">	
	<button id="btn" onclick="back()">목록</button>
	<button id="btn" onclick="update()">수정</button>
	<button id="btn" onclick="deleteinquiry()">삭제</button>		
</div>
<%} else {%>

<div id="tableBox">
<table id="inquiryBoard">	
	<tr>
		<td id="td">글번호</td>
		<td id="td"><%=inquiryDetail.getInquiryArticleNumber() %></td>
	</tr>
	
	<tr>
		<td id="td">작성일자</td>
		<td id="td"><%=inquiryDetail.getInquiryDate() %></td>	
	</tr>
	
	<tr>
		<td id="td">닉네임</td>
		<td id="td"><%=inquiryDetail.getUserNick() %></td>
	</tr>
		
	<tr>
		<td id="td">제목</td>
		<td id="td"><%=inquiryDetail.getInquiryArticleTitle() %></td>
	</tr>
	
	<tr>
		<td id="td">문의사항</td>
		<td id="td"><%=inquiryDetail.getInquiryContent() %></td>
	</tr>	
</table>
</div> <!-- tableBox div end -->


<div id="tableBox">
<table id="inquiryBoard">		
	<tr>
		<td id="td">답변일</td>
		<td id="td"><%=inquiryDetail.getAnswerdate()%></td>
	</tr>
			
	<tr>
		<td id="td">답변자</td>
		<td id="td"><%=inquiryDetail.getAnswerWriter() %></td>
	</tr>
			
	<tr>	
		<td id="td">답변 사항</td>
		<td id="td"><%=inquiryDetail.getAnswercontent() %></td>
	</tr>		
</table>
</div>


<div id="writeBtnBox">
	<button id="btnList" onclick="back()">목록</button>	
</div>
<% } %>




<jsp:include page="/WEB-INF/layout/footer.jsp" />




