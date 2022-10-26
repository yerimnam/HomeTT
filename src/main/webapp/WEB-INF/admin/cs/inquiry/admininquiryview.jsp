<%@page import="admin.cs.inquiry.dto.Inquiry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	Inquiry viewinquiry = (Inquiry) request.getAttribute("viewinquiry"); %>

<%@ include file="/WEB-INF/admin/layout/header.jsp" %>

<style type="text/css">
.info, .warning {
	font-size: 16px;
}

</style>

<h1 style="margin: 30px 0; margin-left: 560px;">1:1 문의</h1>

<table class="table table-bordered text-center" style="width: 800px; margin: 30px auto;">

<tr>
	<td class="info" style="width: 30%; font-weight: bold;">글 번호</td>
	<td style="width: 70%"><%=viewinquiry.getInquiryArticleNumber() %></td>
</tr>
<tr>
	<td class="info" style="font-weight: bold;">작성일</td>
	<td><%=viewinquiry.getInquiryDate() %></td>
</tr>
<tr>	
	<td class="info" style="font-weight: bold;">작성자</td>
	<td><%=viewinquiry.getInquiryWriter() %></td>
</tr>
<tr>	
	<td class="info" style="font-weight: bold;">제목</td>
	<td><%=viewinquiry.getInquiryArticleTitle() %></td>
</tr>
<tr>
	<td class="warning" colspan="4" style="font-weight: bold;">문의 내용</td>
</tr>

<tr>
	<td colspan="4"><%=viewinquiry.getInquiryContent() %></td>
</tr>

</table>

<%	if ( viewinquiry.getAnswerContent() != null ) { %>
<hr style="width: 1000px; margin: 0 auto;">

<h3 style="margin: 30px 0; margin-left: 560px;">답변내용</h3>

<table class="table table-bordered text-center" style="width: 800px; margin: 30px auto; ">
<tr>
	<td class="info" style="width: 30%; font-weight: bold;">답변자</td>
	<td style="width: 70%"><%=viewinquiry.getAnswerWriter() %></td>
</tr>
<tr>
	<td class="info" style="font-weight: bold;">답변 작성일</td>
	<td><%=viewinquiry.getAnswerDate() %></td>
</tr>
<tr>
	<td class="warning" colspan="2" style="font-weight: bold;">답변 내용</td>
</tr>
<tr>
	<td colspan="2"><%=viewinquiry.getAnswerContent() %></textarea></td>
</tr>
</table>

<%	} %>

<div class="text-center">
	<button id="btnList" class="btn btn-primary" onclick="history.back()" style="margin-right: 20px;">목록</button>
	<%	if (viewinquiry.getAnswerContent() == null) { %>
	<button id="btnAnswer" class="btn btn-info">답변하기</button>
	<%	}  %>
	<button id="btnDelete" class="btn btn-danger">삭제하기</button>
</div>

</body>

<!-- 부트스트랩3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
// 	$("#btnList").click(function() {
// 		$(location).attr("href", "./adinquirylist")
// 	})
	
	//답변하기 버튼
	$("#btnAnswer").click(function() {
		$(location).attr('href', './adinquirywrite?inquiryArticleNumber=<%=viewinquiry.getInquiryArticleNumber() %>')
	})

	//삭제하기 버튼
	$("#btnDelete").click(function() {
		$(location).attr('href', './adinquirydelete?inquiryArticleNumber=<%=viewinquiry.getInquiryArticleNumber() %>')
	})

})
</script>

</html>