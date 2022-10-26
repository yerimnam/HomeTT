<%@page import="util.Paging"%>
<%@page import="java.util.List"%>
<%@page import="inquiry.dto.InquiryBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%List<InquiryBoard> inquiryBoard = (List)request.getAttribute("inquiryview"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<header>

<h2>Homett Hearder Area</h2>
</header>

<div>

<h2>1:1문의 게시판</h2>
<hr>
</div>

<div>
	<form action="/homett/inquirycreate"  method="get">
	<button type="button" id="btnwrite" name="btnwrite" onclick ="location.href='/homett/inquirycreate'">글쓰기</button>
</form>
</div>

<div>
	<table id="inquiryBoard" >
	
		<thead>
			<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>작성일자</th>
					<th>제목</th>
			</tr>
		</thead>
		
		<tbody>
			<%for(int i=0;i<inquiryBoard.size();i++) { %>
				<tr>
					<td><%=inquiryBoard.get(i).getInquiryArticleNumber() %></td>
					<td><a href="./inquirydetail?inquiryTitle=<%=inquiryBoard.get(i).getInquiryArticleTitle()%>"><%=inquiryBoard.get(i).getInquiryArticleTitle() %></a></td>		<!--  상세보기 링크 걸기-->		
					<td><%=inquiryBoard.get(i).getUserNick() %></td>
					<td><%=inquiryBoard.get(i).getInquiryDate() %></td>
				</tr>
		
		
		<%} %>	
<!-- 		</tbody> -->
	</table>




		<%@ include file="./inquirypaging.jsp" %><%-- 페이징 --%>
</div>





<hr>
<footer>
<h2>footer area</h2>
</footer>



</body>
</html>