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

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xdomain/0.8.2/xdomain.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>


<style type="text/css">
#inquiryBoard {
	justify-content: center;
	text-align: center;
	width: 1100px;
	height: 60px;
	border: 1px solid #00221b;
	margin-top: 25px;
	background-color: #fffcee;
	border-radius: 10px;
}

#inquiryBoard thead {
	font-weight: 600; 
	font-size: large; 
	color: #ff8c11;
}

#inquiryBoard tbody {
	font-weight: 500; 
	font-size: medium; 
	color: #002541;
}

table { 
	table-layout:fixed;
	border-collapse: collapse;
}

tr {
	border-top: 1px solid #00221b;
	border-bottom: 1px solid #00221b;
}

#tableBox {
	display: flex; 
	justify-content: center;
}

#titleBox {
	display: flex; 
	justify-content: flex-end; 
	margin-right: 370px;
}

#titleBox h2 {
	font-weight: 900; 
	font-size: xx-large; 
	color: #ff8c11;
}

#th {
	text-align: center;
	padding: 5px;
	background-color: #f4df93;
	border: 1px solid #00221b;
}

#td {
	text-align: center;
	padding: 10px;
}

#linktd {
	text-decoration: none !important;
	color: black;
}

#linktd:link{
	color: black;
	background-color: #fffcee; 
    transition : 0.5s; /* 속성 변경할 때 효과의 속도 조절 */
}

#linktd:visited{
	color: black;
	background-color: #fffcee; 
}

#linktd:hover { 
	color: #ff8c11;
	background-color: #fffcee; 
	text-decoration: none;
	font-size: x-large;
	font-weight: 900px;
	transition : 0.4s;
}

#linktd:active {
	color: black;
	background-color: #fffcee; 
	text-decoration: none;
}

#writeBtnBox {
	justify-content: flex-end; 
	margin-right: 355px; 
	display: flex; 
	margin-top: 15px;
}

#btn {
	border-top-left-radius: 5px;
	border-bottom-right-radius: 5px;
	margin-right: -4;
	border: 1px solid #ffeaa6;
	background-color: rgba(0,0,0,0);
	color: #585a72;
	padding: 5px;
	font-weight: 700;
	font-size: medium;
	width: 210px;
	height: 40px;
}

#btn:hover {
	color: #ff8c11;
	background-color: #fffcee;
	transition: 0.5s;	
}




</style>


</head>
<jsp:include page="/WEB-INF/layout/header.jsp" />

<body>

<div id="contatiner" style="margin-left: 120px;">
<div id="titleBox">
	<h2>1:1문의 게시판</h2>
</div>
<hr style="width: 60%; height: 2px; background-color: #ff8c11;">

<<<<<<< HEAD
<div id="tableBox">
<table id="inquiryBoard" >	
	<thead>
		<tr>
			<th style="width: 5%;" id="th">번호</th>
			<th style="width: 15%;" id="th">작성자</th>
			<th style="width: 15%;" id="th">작성일자</th>
			<th style="width: 20%;" id="th">제목</th>
			<th style="width: 20%;" id="th">문의 답변</th>
			<th style="width: 15%;" id="th">답변일자</th>
			<th style="width: 10%;" id="th">답변자</th>
		</tr>
	</thead>
				
	<tbody>
		<%for(int i=0;i<inquiryBoard.size();i++) { %>
		<tr>
			<td id="td"><%=inquiryBoard.get(i).getInquiryArticleNumber() %></td>
			<td id="td"><%=inquiryBoard.get(i).getUserNick() %></td>
			<td id="td"><%=inquiryBoard.get(i).getInquiryDate() %></td>
			<td id="td"><a id="linktd" href="./inquirydetail?inquiryTitle=<%=inquiryBoard.get(i).getInquiryArticleTitle()%>"><%=inquiryBoard.get(i).getInquiryArticleTitle() %></a></td>		<!--  상세보기 링크 걸기-->		
				
			<% if ( inquiryBoard.get(i).getAnswercontent() != null && !"".equals(inquiryBoard.get(i).getAnswercontent())) { %>
				<td id="td"><a id="linktd" href="./inquirydetail?inquiryTitle=<%=inquiryBoard.get(i).getInquiryArticleTitle()%>&<%=inquiryBoard.get(i).getAnswercontent() %>">
			<%if(inquiryBoard.get(i).getAnswercontent().length() > 20) { %>
			<%=inquiryBoard.get(i).getAnswercontent().substring(0,20)+"..." %></a></td>
						
			<% }else { %>
				<%=inquiryBoard.get(i).getAnswercontent()%>
			<% } %>					
				<td id="td"> 답변예정</td>
				<td id="td"> 답변예정</td>
				<td id="td"> 미정</td>
			<% } %>
			</tr>
		<%} %>	
	</tbody>
</table>
</div> <!-- test div end -->

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
               <td><a href="./inquirydetail?inquiryTitle=<%=inquiryBoard.get(i).getInquiryArticleTitle()%>"><%=inquiryBoard.get(i).getInquiryArticleTitle() %></a></td>      <!--  상세보기 링크 걸기-->      
            
            <% if ( inquiryBoard.get(i).getAnswercontent() != null && !"".equals(inquiryBoard.get(i).getAnswercontent()))  { %>
               <td><a href="./inquirydetail?inquiryTitle=<%=inquiryBoard.get(i).getInquiryArticleTitle()%>&content=<%=inquiryBoard.get(i).getAnswercontent() %>">
                  <%if(inquiryBoard.get(i).getAnswercontent().length() > 20) {%>
                  
                     <%=inquiryBoard.get(i).getAnswercontent().substring(0,20)+"..." %>
                     
                     <% }else {%>
                        <%=inquiryBoard.get(i).getAnswercontent()%>
                     <%} %>   </a></td>
                     <td><%=inquiryBoard.get(i).getAnswerdate() %></td>
                     <td><%=inquiryBoard.get(i).getAnswerWriter() %></td>
                  
                  <% } else{ %>                
                  <td> 답변예정</td>          
                  <td> 미정</td> 
            <%} %>
            </tr>
      
      
      <%} %>   
       </tbody> 
   </table>

<div id="writeBtnBox">
	<form action="/homett/inquirycreate"  method="get">
		<button type="button" id="btn" name="btnwrite" onclick ="location.href='/homett/inquirycreate'">글쓰기</button>
	</form>
</div>
</div> <!-- container div end -->
	<%@ include file="./inquirypaging.jsp" %><%-- 페이징 --%>


<jsp:include page="/WEB-INF/layout/footer.jsp" />