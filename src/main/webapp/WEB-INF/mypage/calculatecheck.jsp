<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculate Check</title>

<script>
  document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10);;
</script>

</head>
<body>

<h1>정산 내역 확인</h1>
<hr>

<div style="justify-content: flex-end;">
 <form>
      <p><input type="date" id=""></p> ~ <p><input type="date" id=""></p>
      <p><input type="submit" value="검색"></p>
</form>
</div>



</body>
</html>