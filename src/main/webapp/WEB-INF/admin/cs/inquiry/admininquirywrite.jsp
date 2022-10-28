<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="admin.cs.inquiry.dto.Inquiry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
// 	System.out.println(formatter.format(date));
	%>
	
<%	Inquiry viewinquiry = (Inquiry) request.getAttribute("viewinquiry"); %>
<!-- 답변자 getAttribute -->

<%@ include file="/WEB-INF/admin/layout/header.jsp" %>

<style type="text/css">
.info, .warning {
	font-size: 16px;
}

</style>

<h1 style="margin: 30px 0; margin-left: 560px;">1:1 문의 - 답변하기</h1>

<form action="./adinquirywrite" method="POST">

<table class="table table-bordered text-center" style="width: 800px; margin: 30px auto; margin-bottom: 50px;">

<tr>
	<td class="info" style="width: 30%; font-weight: bold;">글 번호</td>
	<td style="width: 70%"><input class="text-center" type="text" name="inquiryArticleNumber" 
		value="<%=viewinquiry.getInquiryArticleNumber() %>" readonly style="border: 0px;"></td>
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
	<td class="warning" colspan="2" style="font-weight: bold;">문의 내용</td>
</tr>

<tr>
	<td colspan="4"><%=viewinquiry.getInquiryContent() %></td>
</tr>

</table>

<hr style="width: 1000px; margin: 0 auto;">

<h3 style="margin: 30px 0; margin-left: 560px;">답변작성</h3>

<table class="table table-bordered text-center" style="width: 800px; margin: 30px auto; ">
<tr>
	<td class="info" style="width: 30%; font-weight: bold;">답변자</td>
	<td style="width: 70%"><input class="text-center" type="text" name="answer_writer" 
		value="관리자" readonly style="border: 0px;"></td>
</tr>
<tr>
	<td class="info" style="font-weight: bold;">답변 작성일</td>
	<td ><%=formatter.format(date) %></td>
</tr>
<tr>
	<td class="warning" colspan="2" style="font-weight: bold;">답변 내용</td>
</tr>
<tr>
	<td colspan="2"><textarea id="answer_content" name="answer_content" style="width: 100%;"></textarea></td>
</tr>
</table>
</form>

<div class="text-center" style="margin-bottom: 50px;">
	<button id="btnList" class="btn btn-primary" style="margin-right: 20px;">목록</button>
	<button id="btnAnswer" class="btn btn-info">답변하기</button>
	<button id="btnCancel" class="btn btn-default">취소</button>
	<button id="btnDelete" class="btn btn-danger">삭제하기</button>
</div>

</body>

<!-- 부트스트랩3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- 스마트 에디터2 설치 -->
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	//목록버튼
	$("#btnList").click(function() {
// 		$(location).attr("href", "./adinquirylist")
		history.go(-2)
	})
	
	//작성버튼
	$("#btnAnswer").click(function() {
		
		//작성된 내용을 <textarea>에 적용하기
		updateContents()

		$("form").submit();
	})
	
	//취소버튼
	$("#btnCancel").click(function() {
		history.go(-1)
	})
	
	//삭제하기 버튼
	$("#btnDelete").click(function() {
		$(location).attr('href', './adinquirydelete?inquiryArticleNumber=<%=viewinquiry.getInquiryArticleNumber() %>')
	})
	
})

function updateContents() {
	//스마트 에디터에 작성된 내용을 #content에 반영한다
	oEditors.getById["answer_content"].exec("UPDATE_CONTENTS_FIELD", [])
}
</script>

<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "answer_content", //에디터가 적용될 <textarea>의 id 적기
	sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
})
</script>

<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');
body {
	font-family: 'SUIT';
}
</style>

</html>