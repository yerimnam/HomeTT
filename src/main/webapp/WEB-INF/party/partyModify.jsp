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


<!-- SweetAlert2 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>


<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 Bootstrap3 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<script type="text/javascript">


// Alert Redirect to Another Link
$(document).on('click', '#link', function(e) {
    swal({
    title: "Are you sure?", 
    text: "You will be redirected to https://utopian.io", 
    type: "warning",
    confirmButtonText: "Yes, visit link!",
    showCancelButton: true
    })
      .then((result) => {
      if (result.value) {
          window.location = 'https://utopian.io';
      } else if (result.dismiss === 'cancel') {
          swal(
            'Cancelled',
            'Your stay here :)',
            'error'
          )
      }
    })
});</script>

<%--모델값 전달받기 --%>
<%
List<Party> partyList = (List) request.getAttribute("partyList");
%>
<%
PrPaging paging = (PrPaging) request.getAttribute("paging");
%>



<style type="text/css">
.container {
	display: flex;
	justify-content: center;
	margin-top: 50px;
	margin-bottom: 90px;
	/* column-gap: 50px; */
	gap: 50px 50px;
}
</style>
</head>
<body>
	<h1>파티모집 게시판</h1>
	<hr>
	<button id="link">Redirect to Utopian</button>
	<div class="container">
		<%
		for (int i = 0; i < partyList.size(); i++) {
		%>
		<div id="party">
			<ul>
				<div
					style="border: 1px solid #000; text-align: center; margin-top: 5px;">
					<div
						style="border: 1px solid #000; text-align: center; margin-top: 10px; border-radius: 5px;">
						<%=partyList.get(i).getPartyKind()%>
					</div>

					<div style="text-align: center; margin: 5px; margin-top: 15px;">
						<%=partyList.get(i).getPartyName()%>
					</div>
					<hr>
					<hr style="height: 1px; background-color: black;">
					<li>파티장 : <%=partyList.get(i).getPartyLeader()%></li>
					<li>파티 만료일 : <%=partyList.get(i).getPartyEndDate()%></li>
					<li>모집 인원 : <%=partyList.get(i).getPartyMember()%></li>
					<hr>
					<li>참여 금액 : <%=partyList.get(i).getPaymentAmount()%></li>
					<hr style="height: 1px; background-color: black;">
					<li>참여 금액 : <%=partyList.get(i).getPaymentAmount()%> 원
					</li>
				</div>
			</ul>
		</div>
		<!-- #party end -->

		<%
		}
		%>
	</div>
	<!-- .container end -->
	<div class="text-center">
		<ul class="pagination">

			<%--첫 페이지로 이동 --%>
			<%
			if (paging.getCurPage() != 1) {
			%>
			<li><a href="./partymodify">&larr;처음</a></li>
			<%
			}
			%>



			<%--이전 페이지로 이동 --%>
			<%
			if (paging.getCurPage() != 1) {
			%>
			<li><a href="./partymodify?curPage=<%=paging.getCurPage() - 1%>">&lt;</a></li>
			<%
			}
			%>



			<%--페이지 번호 리스트 --%>
			<%
			for (int i = paging.getStartPage(); i <= paging.getEndPage(); i++) {
			%>

			<%
			if (i == paging.getCurPage()) {
			%>
			<li class="active"><a href="./partymodify?curPage=<%=i%>"><%=i%></a></li>
			<%
			} else {
			%>
			<li><a href="./partymodify?curPage=<%=i%>"><%=i%></a></li>
			<%
			}
			%>
			<%
			}
			%>


			<%--다음 페이지로 이동 --%>
			<%
			if (paging.getCurPage() != paging.getTotalPage()) {
			%>
			<li><a href="./partymodify?curPage=<%=paging.getCurPage() + 1%>">&gt;</a></li>
			<%
			}
			%>


			<%--마지막 페이지로 이동 --%>
			<%
			if (paging.getCurPage() != paging.getTotalPage()) {
			%>
			<li><a href="./partymodify?curPage=<%=paging.getTotalPage()%>">&rarr;끝</a></li>
			<%
			}
			%>
		</ul>
	</div>

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



</body>
</html>