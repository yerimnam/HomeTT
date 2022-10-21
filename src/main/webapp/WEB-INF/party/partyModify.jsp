<%@page import="util.PrPaging"%>
<%@page import="party.dto.Party"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 Bootstrap3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<%--모델값 전달받기 --%>
<% List<Party> partyList = (List) request.getAttribute("partyList"); %>
<% PrPaging paging = (PrPaging) request.getAttribute("paging"); %>

<style type="text/css">
table{
	1px solid black;
}
</style>
</head>
<body>

<h1>방목록</h1>
<hr>

<% for(int i=0; i<partyList.size(); i++){ %>
<table>
<tr>
	<th>파티 번호</th>
	<td><%=partyList.get(i).getPartyNo() %></td>
</tr>

<tr>
	<th>파티 종류</th>
	<td><%=partyList.get(i).getPartyKind() %></td>
</tr>

<tr>
	<th>파티 이름</th>
	<td><a href="./roomboard?partyNo=<%=partyList.get(i).getPartyNo() %>"><%=partyList.get(i).getPartyName() %></a></td>
</tr>

<tr>
	<th>파티장 정보</th>
	<td><%=partyList.get(i).getPartyLeader() %></td>
</tr>

<tr>	
	<th>파티 생성일</th>
	<td><%=partyList.get(i).getPartyCreDate() %></td>
</tr>	

<tr>	
	<th>파티 종료일</th>
	<td><%=partyList.get(i).getPartyEndDate() %></td>
</tr>	

<tr>	
	<th>계정공유기간</th>
	<td><%=partyList.get(i).getPartyPeriod() %></td>
</tr>	

<tr>	
	<th>모집 인원</th>
	<td><%=partyList.get(i).getPartyMember() %></td>
</tr>	

<tr>	
	<th>결제 금액</th>
	<td><%=partyList.get(i).getPaymentAmount() %></td>
</tr>	

</table>
<br><br><br><br><br><br><%} %>

<div class="text-center">
	<ul class="pagination">
	
	<%--첫 페이지로 이동 --%>
	<% if(paging.getCurPage() != 1){ %>
	<li><a href="./partymodify">&larr;처음</a></li>
	<%} %>


	
	<%--이전 페이지로 이동 --%>
	<% if(paging.getCurPage() != 1){ %>
	<li><a href="./partymodify?curPage=<%=paging.getCurPage() - 1%>">&lt;</a></li>
	<%} %>
	
	
	
	<%--페이지 번호 리스트 --%>
	<% for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++){ %>
	
	<%		if(i == paging.getCurPage()){ %>
	<li class = "active"><a href="./partymodify?curPage=<%=i%>"><%=i %></a></li>
	<%}else{ %>
		<li><a href="./partymodify?curPage=<%=i%>"><%=i %></a></li>
		<%		} %>
		<%} %>
		
	
	<%--다음 페이지로 이동 --%>
	<% if(paging.getCurPage() != paging.getTotalPage()) {%>
	<li><a href="./partymodify?curPage=<%=paging.getCurPage() + 1%>">&gt;</a></li>
	<% } %>
	
	
	<%--마지막 페이지로 이동 --%>
	<% if(paging.getCurPage() != paging.getTotalPage()) {%>
	<li><a href="./partymodify?curPage=<%=paging.getTotalPage()%>">&rarr;끝</a></li>
	<%} %>
	</ul>
</div>    

<!--  검색 시작  -->
	<form action="getBoardList.jsp" method="get">
		<table cellpadding="0" cellspacing="0" width="700">
			<tr>
				<td align="right">
					<select id="searchCondition" name="searchCondition">
						<option value="TITLE">제목</option>
						<option value="CONTENT">내용</option>
						<option value="IdNick">아이디(닉네임)</option>
					</select>
					<input id="searchKeyword" name="searchKeyword" type="text">						<input type="submit" value="검색 ">
				</td>
			</tr>		
		</table>
	</form>
<!-- 검색 종료  -->
		
		
	
</body>
</html>