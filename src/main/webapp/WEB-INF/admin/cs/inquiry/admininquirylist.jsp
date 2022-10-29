<%@page import="admin.cs.inquiry.dto.Inquiry"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	List<Inquiry> inquiryList = (List) request.getAttribute("inquiryList"); %>

<%@ include file="/WEB-INF/admin/layout/header.jsp" %>

<style type="text/css">
th, td {
	text-align: center;
	border: 1px solid #ccc;
}

th {
	font-size: 16px;
}

* {
	margin: 0 auto;
}
</style>

</head>
<body>

<div style="margin: 30px 0; margin-left: 360px;">
	<h1>1:1 문의 목록</h1>
</div>

<table style="width: 1200px;" class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 5%; text-align: center">글 번호</th>
	<th style="width: 15%; text-align: center">작성자</th>
	<th style="width: 10%; text-align: center">작성일</th>
	<th style="width: 20%; text-align: center">제목</th>
	<th style="width: 30%; text-align: center">내용</th>
	<th style="width: 10%; text-align: center">답변일</th>
	<th style="width: 10%; text-align: center">처리 상태</th>
</tr>

<%	for(int i=0; i<inquiryList.size(); i++) { %>
<tr>
	<td><%=inquiryList.get(i).getInquiryArticleNumber() %></td>
	<td><%=inquiryList.get(i).getInquiryWriter() %></td>
	<td><%=inquiryList.get(i).getInquiryDate() %></td>
	<td><%=inquiryList.get(i).getInquiryArticleTitle() %></td>
	<%	String content = inquiryList.get(i).getInquiryContent();
		if( content.length() > 15 ) { 
		content = content.substring(0, 15) + "...";
		} %>
	<td>
		<a href="./adinquiryview?inquiryArticleNumber=<%=inquiryList.get(i).getInquiryArticleNumber() %>">
			<%=content %>
		</a>
	</td>
	<td><% if ( inquiryList.get(i).getAnswerDate() != null ) { %>
			<%=inquiryList.get(i).getAnswerDate() %>
		<%	} else { %>
			-
		<%	} %>
	</td>
	<td><% if ( inquiryList.get(i).getAnswerDate() != null ) { %>
				답변 완료
			<% } else {  %>
				답변 대기
			<% };%>
	</td>
	
</tr>
<%	} %>

</table>

<%@ include file="/WEB-INF/admin/layout/inquirypaging.jsp" %>

<%@ include file="/WEB-INF/admin/layout/inquirysearch.jsp" %>

</body>

<!-- 부트스트랩3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');
body {
	font-family: 'SUIT';
}
</style>

</html>