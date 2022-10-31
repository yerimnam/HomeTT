<%@page import="util.PrPaging"%>
<%@page import="party.dto.Party"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/layout/header.jsp" />
<!-- SweetAlert2 -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css"> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>  -->



<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 Bootstrap3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>




<%--모델값 전달받기 --%>
<%List<Party> partyListS = (List) request.getAttribute("partyListS"); %>
<%
List<Party> partyList = (List) request.getAttribute("partyList");
%>
<%
PrPaging paging = (PrPaging) request.getAttribute("paging");
%>
<%	String searchType = request.getParameter("searchType");
	String keyword = request.getParameter("keyword"); %>


<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');

.top {
	padding: 10px;
	/* 	border-bottom: 1px solid #333; */
	/* 	margin-bottom: 40px; */
	text-align: center;
}

ul {
	margin: 0;
	padding: 10px;
	list-style: none;
}

ul li {
	padding: 3px;
}

.round-box {
	border: 1px solid #000;
	border-radius: 5px;
}

.part-area {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	margin: 50px 50px 90px 50px;
	/* column-gap: 50px; */
	gap: 50px 50px;
}

.party {
	position: relative;
	flex: 1 1 30%;
	border: 1px solid #000;
	margin-top: 5px;
	padding: 15px;
	text-align: center;
	width: 100px;
	z-index: 100;
	flex: 1 1 30%;
}

.notice {
	border: 1px solid #333;
	padding: 15px;
}

.notice h3 {
	display: inline-block;
	width: 90%;
	text-align: center;
}

.notice .round-box {
	border-color: red;
	color: red;
}

.heart-area {
	position: absolute;
	right: 10px;
	bottom: 10px;
	z-index: 999;
	text-align: right;
	z-index: 999;
	botton: 10px;
}

.heart-area :hover {
	font-family: bold;
	font-size: 18px;
	z-index: 999;
}

a.heart {
	text-decoration: none;
}

.on {
	color: red;
	/* 이미지 넣을 경우 url */
}

.off {
	color: inherit;
	/* 이미지 넣을 경우 url */
}

.search-area {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	padding: 25px;
}

.form-item {
	padding: 10px;
}

.form-item * {
	height: 30px;
	padding: 4px;
}
</style>

</head>

<body>

	<div class="top">
		<h2>
			<a href="./partymodify">파티찾기</a>
		</h2>
	</div>

	<div class="container">
		<div class="notice">
			<span class="round-box">공지사항</span>
			<h3>공지사항</h3>
		</div>
		<div class="part-area">
			<%
			for (int i = 0; i < partyList.size(); i++) {
			%>

			<div class="party">
				<div class="part-title">
					<div class="round-box">
						<%=partyList.get(i).getPartyKind()%>
					</div>

					<div style="text-align: center; margin: 5px; margin-top: 15px;">
						<%=partyList.get(i).getPartyName()%>
					</div>
					<hr>
				</div>
				<ul class="part-contents">

<%-- 										<%if((Integer.parseInt(partyList.get(i).getPartyNo())){ %> --%>
					<li><a href="./partyroomdetail?partyNo=<%=partyList.get(i).getPartyNo()%>">파티방 번호 : <%=partyList.get(i).getPartyNo()%></a></li>
<%-- 										<%}else{ %> --%>
<%-- 										<a href="./partyroomdetail?partyNo=<%=partyList.get(i).getPartyNo()%>"></a> --%>
<%-- 										<%} %> --%>
<%-- 					<li>파티장 : <%=partyList.get(i).getPartyLeader()%></li> --%>
					<li>파티 만료일 : <%=partyList.get(i).getPartyEndDate()%></li>
					<li>모집 인원 : <%=partyList.get(i).getPartyMember()%></li>
					<li style="border-bottom: 1px solid #333;">참여 금액 : <%=partyList.get(i).getPaymentAmount()%></li>
					<li>참여 금액 : <%=partyList.get(i).getPaymentAmount()%> 원
					</li>
				</ul>

				<%-- 				<a href="./wishlist?wishNo=<%=wishList.get(i).getWishNo()%>"> --%>
				<span class="heart-area"> <span class="heart on"> 🧡 하트 </span>

				</span>
				<!-- 				</a> -->
			</div>
			<%
				}
				%>
			<!-- #party end -->

		</div>
	</div>
	<!-- .container end -->
	<div class="text-center">
		<ul class="pagination">
			<% if ( keyword != null && !"".equals(keyword) ) { %>
			<%--검색 했을 때 paging 결과 --%>

			<%-- 첫 페이지로 이동 --%>
			<%	if( paging.getCurPage() != 1) { %>
			<li><a href="./partymodify?curPage=<%=paging.getStartPage()%>
				&searchType=<%=searchType %>&keyword=<%=keyword %>">&lt;&lt;</a></li>
			<%	} %>


			<%-- 이전 페이지로 이동 --%>
			<%	if( paging.getCurPage() != 1) { %>
			<li><a href="./partymodify?curPage=<%=paging.getCurPage() - 1 %>
					&searchType=<%=searchType %>&keyword=<%=keyword %>">&lt;</a></li>
			<%	} %>


			<%-- 페이지 번호 리스트 --%>
			<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
			<%		if( i == paging.getCurPage() ) { %>
			<li class="active"><a href="./partymodify?curPage=<%=i %>
					&searchType=<%=searchType %>&keyword=<%=keyword %>"><%=i %></a></li>
			<%		} else { %>
			<li><a href="./partymodify?curPage=<%=i %>
					&searchType=<%=searchType %>&keyword=<%=keyword %>"><%=i %></a></li>
			<%		} %>
			<%	} %>


			<%-- 다음 페이지로 이동 --%>
			<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
			<li><a href="./partymodify?curPage=<%=paging.getCurPage() + 1 %>
					&searchType=<%=searchType %>&keyword=<%=keyword %>">&gt;</a></li>
			<%	} %>


			<%-- 마지막 페이지로 이동 --%>
			<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
			<li><a href="./partymodify?curPage=<%=paging.getTotalPage() %>
					&searchType=<%=searchType %>&keyword=<%=keyword %>">&gt;&gt;</a></li>
			<%	} %>

			<%	} else { %>
			<%--검색하지 않았을 때 paging 결과 --%>

			<%-- 첫 페이지로 이동 --%>
			<%	if( paging.getCurPage() != 1) { %>
			<li><a href="./partymodify?curPage=<%=paging.getStartPage()%>">&lt;&lt;</a></li>
			<%	} %>


			<%-- 이전 페이지로 이동 --%>
			<%	if( paging.getCurPage() != 1) { %>
			<li><a href="./partymodify?curPage=<%=paging.getCurPage() - 1 %>">&lt;</a></li>
			<%	} %>


			<%-- 페이지 번호 리스트 --%>
			<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
			<%		if( i == paging.getCurPage() ) { %>
			<li class="active"><a href="./partymodify?curPage=<%=i %>"><%=i %></a></li>
			<%		} else { %>
			<li><a href="./partymodify?curPage=<%=i %>"><%=i %></a></li>
			<%		} %>
			<%	} %>


			<%-- 다음 페이지로 이동 --%>
			<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
			<li><a href="./partymodify?curPage=<%=paging.getCurPage() + 1 %>">&gt;</a></li>
			<%	} %>


			<%-- 마지막 페이지로 이동 --%>
			<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
			<li><a href="./partymodify?curPage=<%=paging.getTotalPage() %>">&gt;&gt;</a></li>
			<%	} %>
			<%	} %>

		</ul>
	</div>

	<form action="/homett/partymodify" method="POST">
		<!--  검색 시작  -->
		<div class="search-area">
			<div class="form-item">
				<select class="form-control" name="searchType" id="searchType">
					<option value="party_boardtitle">제목</option>
					<option value="partyLeader">파티장</option>
				</select>
			</div>
			<div class="form-item">
				<input type="text" class="form-control" name="keyword" id="keywordInput" >
			</div>
			<div class="form-item">
				<input type="submit" value="검색 ">
			</div>
		</div>
		<!-- 검색 종료  -->
	</form>



</body>
</html>
<jsp:include page="/WEB-INF/layout/footer.jsp" />