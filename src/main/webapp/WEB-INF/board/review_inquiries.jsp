<%@page import="reviewBoard.dto.ReviewBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <% List<ReviewBoard> reviewboardList = (List)request.getAttribute("reviewboardList"); %>
 
 <jsp:include page="/WEB-INF/layout/header.jsp" />


<style>

.reviewmain {
width: 68%;
    height: 750px;
    /* border: 1px solid #000; */
    margin-top: 12%;
    margin-left: 12%;
}
.list {
    width: 32%;
    height: 273px;
    list-style: none;
    border: 1px solid #000;
    float: left;
    margin-bottom: 29px;
    margin-block: 44px;
    margin-block-end: 24px;
    /* margin-block-start: 136px; */
    margin-top: 77px;
    /* margin-left: -15%; */
    /* margin-inline: 292px; */
    margin-inline-end: -224px;
    margin-inline-start: 274px;
}

.letter {
	position: relative;
/* 	left: 0; */
	top: 250px;
}

#main{
	background-color: #ffde59;
}
#big{
	width: 1600px;
	margin: 0 auto;
}

</style>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnWrite").click(function() {
		location.href = "./reviewcreate"
	})
})
</script>

</head>
<body>

<div id="big">
<table class="table table-bordered">

<tr id = "main">
	<th style="width: 15%;">글번호</th>
	<th style="width: 30%;">제목</th>
	<th style="width: 20%;">작성자</th>
	<th style="width: 15%;">조회수</th>
	<th style="width: 20%;">작성일</th>
</tr>

<%	for(int i=0; i<reviewboardList.size(); i++) { %>
<tr>
	<td><%=reviewboardList.get(i).getReviewArticlenumber() %></td>
	<td>
		<a href="./reviewview?reviewArticlenumber=<%=reviewboardList.get(i).getReviewArticlenumber() %>">
			<%=reviewboardList.get(i).getReviewArticletitle() %>
		</a>
	</td>
	<td><%=reviewboardList.get(i).getReviewWriter() %></td>
	<td><%=reviewboardList.get(i).getHit() %></td>
	<td><%=reviewboardList.get(i).getReviewDate() %></td>
</tr>
<%	} %>
</table>

<div id="btnBox" class="pull-left">
	<button id="btnWrite" class="btn btn-info">글쓰기</button>
<div class="container">
</div>
</div>


<!-- ------------- -->

		<div class="row">
			<form action="./reviewlist" method="post" name="search">
				<table class="pull-right">
					<tr>
						<td><select class="form-control" name="searchType">
<!-- 								<option value="#">선택</option> -->
								<option value="review_articletitle">제목</option>
								<option value="user_nick">작성자</option>
						</select></td>
						<td><input type="text" class="form-control"
							placeholder="검색어 입력" name="keyword" maxlength="100"></td>
						<td><button type="submit" class="btn btn-success">검색</button></td>
					</tr>

				</table>
			</form>
		</div>
	</div>

<!-- ------------- -->

<%-- <%@ include file="../layout/reviewpaging.jsp" %> --%>

<jsp:include page="/WEB-INF/layout/footer.jsp" />