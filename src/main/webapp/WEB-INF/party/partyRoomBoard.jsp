<%@page import="partyBoard.dto.PartyBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%--모델값 전달받기 --%>
<% List<PartyBoard> partyBoardList = (List) request.getAttribute("partyBoardList"); %>
<% List<PartyBoard> headList = (List) request.getAttribute("headList"); %>

</head>
<body>
	<h1>파티방</h1>

<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
	<!-- 계정공유기간 & 인원수 파티테이블에서 불러와야하는데 -->
	<table>
			<% for(int i=0; i<headList.size(); i++){ %>
		<td>계정공유기간</td>
<%-- 		<th><%=headList.get(i).getpartyPeriod() %></th> --%>
		<td>인원수</td>
	</table>
		<%} %>
		
	<h3>게시글</h3>
	<table>
		<tr>
			<th>글 번호</th>
			<th>작성자</th>
			<th>제목</th>
			<% for(int i=0; i<partyBoardList.size(); i++){ %>
		
		<tr>
			<td><%=partyBoardList.get(i).getPartyBoardNo() %></td>
			<td><%=partyBoardList.get(i).getPartyBoardWriter() %></td>
			<td><%=partyBoardList.get(i).getPartyBoardTitle() %></td>
		</tr>
	<%} %>
	</table>
	<hr>
	<!--  검색 시작  -->
	<form action="getBoardList.jsp" method="get">
		<table cellpadding="0" cellspacing="0" width="700">
			<tr>
				<td align="right"><select id="searchCondition"
					name="searchCondition">
						<option value="TITLE">제목</option>
						<option value="CONTENT">내용</option>
						<option value="IdNick">아이디(닉네임)</option>
				</select> <input id="searchKeyword" name="searchKeyword" type="text">
					<input type="submit" value="검색 "></td>
			</tr>
		</table>
	</form>
	<!-- 검색 종료  -->

	<hr>
	<button>파티탈퇴</button>
	<hr>
	<br>
	<br>
	<br>
	제목<input type="text"><br>
	내용<input type="text">
	<button id="btnWrite">등록</button>
</body>
</html>