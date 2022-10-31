<%@page import="notice.dto.NoticeBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <% List<NoticeBoard> noticeboardList = (List)request.getAttribute("noticeboardList"); %>
 
 <jsp:include page="/WEB-INF/layout/header.jsp" />


<style>

.noticemain {
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
		location.href = "./noticecreate"
	})
})
</script>

</head>
<body>

<div id="big">
<h2>공지사항 목록</h2>
<br>
<table class="table table-bordered">

<tr id = "main">
	<th style="width: 15%;">글번호</th>
	<th style="width: 30%;">제목</th>
	<th style="width: 20%;">작성자</th>
	<th style="width: 15%;">조회수</th>
	<th style="width: 20%;">작성일</th>
</tr>

<%	for(int i=0; i<noticeboardList.size(); i++) { %>
<tr>
	<td><%=noticeboardList.get(i).getNoticeArticlenumber() %></td>
	<td>
		<a href="./noticeview?noticeArticlenumber=<%=noticeboardList.get(i).getNoticeArticlenumber() %>">
			<%=noticeboardList.get(i).getNoticeArticletitle() %>
		</a>
	</td>
	<td>관리자</td>
	<td><%=noticeboardList.get(i).getHit() %></td>
	<td><%=noticeboardList.get(i).getNoticeDate() %></td>
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
			<form action="./noticelist" method="post" name="search">
				<table class="pull-right">
					<tr>
						<td><select class="form-control" name="searchType">
<!-- 								<option value="#">선택</option> -->
								<option value="notice_articletitle">제목</option>
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

<%@ include file="../../layout/noticepaging.jsp" %>

<jsp:include page="/WEB-INF/layout/footer.jsp" />