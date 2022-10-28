<%@page import="faq.dto.FaqBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%-- 모델값 전달받기 --%>
<%	List<FaqBoard> boardList = (List) request.getAttribute("faqboardList"); %>


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table class="table table-striped table-hover table-condensed">

<tr>
	<th style="width: 15%;">글번호</th>
	<th style="width: 30%;">제목</th>
	<th style="width: 20%;">작성자</th>
	<th style="width: 15%;">조회수</th>
	<th style="width: 20%;">작성일</th>
</tr>

<%	for(int i=0; i<boardList.size(); i++) { %>
<tr>
	<td><%=boardList.get(i).getFaqArticlenumber() %></td>
	<td>
		<a href="./faq_view?faqArticlenumber=<%=boardList.get(i).getFaqArticlenumber() %>">
			<%=boardList.get(i).getFaqArticletitle() %>
		</a>
	</td>
	<td><%=boardList.get(i).getFaqWriter() %></td>
	<td><%=boardList.get(i).getHit() %></td>
	<td><%=boardList.get(i).getFaqDate() %></td>
</tr>
<%	} %>

</table>


<table>
<tr>
	<td colspan="6">
		<input type="submit" value="삭제">
		<input type="button" value="글쓰기" oncancel="event_write.jsp">
	</td>
</tr>
</table>



</body>
</html>