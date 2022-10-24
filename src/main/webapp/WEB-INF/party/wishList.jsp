<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

</script>
</head>
<body>

	<form id="like_form">

		<table id="list">
			<input type="hidden" name="command" value="like_it">
			<input type="hidden" name="board_num" value="${board.num}">
			<tr>
				<input type="button" value="좋아요!" onclick="return like()">
			</tr>
			<tr>
				<div id="like_result">${board.like_it}</div>
			</tr>
		</table>
	</form>


</body>
</html>