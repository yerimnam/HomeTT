<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>관리자 로그인성공 테스트</h1>


<p>관리자 번호 :  <%=session.getAttribute("adminNo") %></p>
<p>관리자 아이디 :  <%=session.getAttribute("adminId") %></p>



</body>
</html>