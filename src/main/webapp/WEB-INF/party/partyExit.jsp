<%@page import="partyExit.dto.PartyExit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% PartyExit viewPartyExit = (PartyExit) request.getAttribute("viewPartyExit"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>partyExit</title>

<script type="text/javascript">
//삭제버튼
$("#btnDelete").click(function() {
	$(location).attr('href', './delete?partyNo=<%=viewPartyExit.getPartyNo() %>')
})
</script>

</head>
<body>

<h1>파티방 나가기</h1>
<hr>

<div class="text-center">
	<button id="btnDelete" class="btn btn-danger">파티방 나가기</button>
</div>

</body>
</html>