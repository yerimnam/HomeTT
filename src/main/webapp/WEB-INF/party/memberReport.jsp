<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼
	$("#btnWrite").click(function() {
		
		$("form").submit();
	})
	
	//취소버튼
	$("#btnCancel").click(function() {
		history.go(-1)
	})
	
})

</script>

</head>
<body>


<h1>신고하기</h1>
<hr>

<form action="./mbrreport" method="post">

<table>
<tr><td >작성자</td><td><%=session.getAttribute("userid") %></td></tr>


<tr><td>신고 닉네임</td><td><input type="text" name="title" style="width:100%;"></td></tr>

<tr><td colspan="2">신고 내용</td></tr>
<tr><td colspan="5"><textarea id="content" name="reportcontent" style="width: 100%;"></textarea></td></tr>
</table>

	<button id="btnWrite" >작성</button>
	<button id="btnCancel">취소</button>

</form>


</body>
</html>