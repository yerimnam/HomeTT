<%@page import="partyExit.dto.PartyExit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% PartyExit viewParty = (PartyExit) request.getAttribute("viewParty"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>party Exit</title>
</head>
<body>

<h1 style="text-align: center; background-color: #7DA5E1">파티 나가기</h1>
<hr>


<script type="text/javascript">
	$(document).ready(function() {
	
		// 삭제 버튼
		$("#btnDelete").click(function() {
			
			$(location).attr('href', './delete?partyNo=<%=viewParty.getPartyNo() %>')
		})
		
	})
</script>



<input type="button" onClick="partyexit();" value="파티나가기"/>



</body>
</html>