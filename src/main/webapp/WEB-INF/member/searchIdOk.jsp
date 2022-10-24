<%@page import="user.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Member member = (Member) request.getAttribute("member"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>아이디 찾기 완료</h1>
<hr>

회원님의 아이디는 <%=member.getUserId() %> 입니다


</body>
</html>