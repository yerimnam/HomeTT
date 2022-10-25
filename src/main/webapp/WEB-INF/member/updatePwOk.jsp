<%@page import="user.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%	Member member = (Member) request.getAttribute("member"); %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p><%=member.getUserId() %>님의 비밀번호가 변경되었습니다.</p>

<button class="btn" onclick="location.href='/homett/login'">로그인</button>




</body>
</html>