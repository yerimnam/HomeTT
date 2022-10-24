<%@page import="admin.report.dto.Report"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	Report viewreport = (Report) request.getAttribute("viewreport"); %>


<%@ include file="../layout/header.jsp" %>

<style type="text/css">
.info, .warning {
	font-size: 16px;
}

</style>

<h1 style="margin: 30px 0; margin-left: 560px;">신고 내용</h1>

<table class="table table-bordered text-center" style="width: 800px; margin: 30px auto;">

<tr>
	<td class="info" style="width: 30%; font-weight: bold;">신고 번호</td>
	<td style="width: 70%"><%=viewreport.getReportNo() %></td>
</tr>
<tr>
	<td class="info" style="font-weight: bold;">신고 날짜</td>
	<td><%=viewreport.getReportDate() %></td>
</tr>
<tr>	
	<td class="info" style="font-weight: bold;">신고자</td>
	<td><%=viewreport.getReporter() %></td>
</tr>
<tr>	
	<td class="info" style="font-weight: bold;">신고 대상자</td>
	<td><%=viewreport.getReportTarget() %></td>
</tr>
<tr>	
	<td class="info" style="font-weight: bold;">신고 파티명</td>
	<td><%=viewreport.getReportParty() %></td>
</tr>
<tr>
	<td class="warning" colspan="4" style="font-weight: bold;">신고 내용</td>
</tr>

<tr>
	<td colspan="4"><%=viewreport.getReportContent() %></td>
</tr>

</table>

<div class="text-center">
	<button class="btn btn-primary" onclick="history.back()" style="margin-right: 20px;">목록</button>
	<button id="btnadminuserinfo" class="btn btn-info">회원정보 조회하기</button>
</div>

<!-- <div id="btnList" class="pull-right text-center"></div> -->


</body>

<!-- 부트스트랩3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	//회원정보 조회하기 버튼
	$("#btnadminuserinfo").click(function() {
		$(location).attr('href', './adminuserinfo?ReportTarget=<%=viewreport.getReportTarget() %>')
	})
	
})
</script>

</html>