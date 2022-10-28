<%@page import="faq.dto.FaqBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% FaqBoard viewBoard = (FaqBoard) request.getAttribute("viewBoard"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>게시글 상세보기</h1>
<hr>

<table class="table table-bordered">

<!-- <tr> -->
<!-- 	<td class="info">글번호</td> -->
<%-- 	<td><%=viewBoard.getfaq_articlenumber() %></td> --%>
	
<!-- 	<td class="info">작성일</td> -->
<%-- 	<td><%=viewBoard.getfaq_date() %></td> --%>
<!-- </tr> -->


<!-- <tr> -->
<!-- 	<td class="info">작성자</td> -->
<%-- 	<td><%=viewBoard.getfaq_writer() %></td> --%>
	
<!-- <!-- 	<td class="info">닉네임</td> --> -->
<%-- <%-- 	<td><%=request.getAttribute("writerNick") %></td> --%> --%>
<!-- </tr> -->

<!-- <tr> -->
<!-- 	<td class="info">조회수</td> -->
<%-- 	<td colspan="4"><%=viewBoard.getHit() %> --%>
<!-- </tr> -->

<!-- <tr> -->
<!-- 	<td class="info">제목</td> -->
<%-- 	<td colspan="3"><%=viewBoard.getTitle() %></td> --%>
<!-- </tr> -->

<!-- <tr> -->
<!-- 	<td class="info" colspan="4">본문</td> -->
<!-- </tr> -->

<!-- <tr> -->
<%-- 	<td colspan="4"><%=viewBoard.getContent() %></td> --%>
<!-- </tr> -->

</table>
</body>
</html>