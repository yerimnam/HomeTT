<%@page import="admin.report.dto.Report"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	List<Report> reportList = (List) request.getAttribute("reportList"); %>

<%@ include file="../layout/header.jsp" %>

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

<div style="margin: 30px 0; margin-left: 160px;">
	<h1>신고 관리 - 신고 목록</h1>
</div>

<table style="width: 1600px;" class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 10%; text-align: center">신고 번호</th>
	<th style="width: 15%; text-align: center">신고 날짜</th>
	<th style="width: 30%; text-align: center">신고 내용</th>
	<th style="width: 15%; text-align: center">신고자</th>
	<th style="width: 15%; text-align: center">신고 대상자</th>
	<th style="width: 20%; text-align: center">신고 파티명</th>
</tr>

<%	for(int i=0; i<reportList.size(); i++) { %>
<tr>
	<td><%=reportList.get(i).getReportNo() %></td>
	<td><%=reportList.get(i).getReportDate() %></td>
	<td>
		<a href="./adreportview?reportno=<%=reportList.get(i).getReportNo() %>">
			<%=reportList.get(i).getReportContent() %>
		</a>
	</td>
	<td><%=reportList.get(i).getReporter() %></td>
	<td><%=reportList.get(i).getReportTarget() %></td>
	<td><%=reportList.get(i).getReportParty() %></td>
</tr>
<%	} %>

</table>

<%@ include file="../layout/paging.jsp" %>

<%@ include file="../layout/reportsearch.jsp" %>

</body>

<!-- 부트스트랩3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</html>