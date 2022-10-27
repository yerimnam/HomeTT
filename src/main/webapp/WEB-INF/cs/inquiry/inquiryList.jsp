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
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">





</script>
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
					<th>문의 답변</th>
					<th>답변 날짜</th>
					<th>답변자</th>
			</tr>
		</thead>
		
		
		
		<tbody>
			<%for(int i=0;i<inquiryBoard.size();i++) { %>
				<tr>
					<td><%=inquiryBoard.get(i).getInquiryArticleNumber() %></td>
					<td><%=inquiryBoard.get(i).getUserNick() %></td>
					<td><%=inquiryBoard.get(i).getInquiryDate() %></td>
					<td><a href="./inquirydetail?inquiryTitle=<%=inquiryBoard.get(i).getInquiryArticleTitle()%>"><%=inquiryBoard.get(i).getInquiryArticleTitle() %></a></td>		<!--  상세보기 링크 걸기-->		
				
				<% if ( inquiryBoard.get(i).getAnswercontent() != null && !"".equals(inquiryBoard.get(i).getAnswercontent()))  { %>
					<td><a href="./inquirydetail?inquiryTitle=<%=inquiryBoard.get(i).getInquiryArticleTitle()%>&<%=inquiryBoard.get(i).getAnswercontent() %>">
						<%if(inquiryBoard.get(i).getAnswercontent().length() > 20) {%>
						
						<%=inquiryBoard.get(i).getAnswercontent().substring(0,20)+"..." %></a></td>
						
						<% }else {%>
						<%=inquiryBoard.get(i).getAnswercontent()%>
						
						<% } %>
				
			
					
					<td> 답변예정</td>
					<td> 답변예정</td>
					<td> 미정</td>
				<%} %>
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