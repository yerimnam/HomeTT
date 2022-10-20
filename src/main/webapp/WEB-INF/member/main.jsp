<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="text-center">
<h1>메인페이지랍니다~</h1>
<hr>

<%-- 비로그인 상태 --%>
<%	if( session.getAttribute("login") == null ) { %>
<h1>로그인을 해</h1>
<hr><br>

<button class="btn" onclick="location.href='/homett/join'">회원가입</button>
<button class="btn" onclick="location.href='/homett/login'">로그인</button>
<%	} %>

<%-- 로그인 상태 --%>
<%	if( session.getAttribute("login") != null && (boolean) session.getAttribute("login") ) { %>
<strong><%=session.getAttribute("userNick") %>님,환영합니다</strong><br><br>
<p>회원권한 :  <%=session.getAttribute("masterNo") %></p>
<p>아이디 :  <%=session.getAttribute("userId") %></p>
<p>닉네임 :  <%=session.getAttribute("userNick") %></p>

<button class="btn" onclick="location.href='./member/logout'">로그아웃</button>
<%	} %>

</div>


</body>
</html>