<%@page import="util.PbPaging"%>
<%@page import="partyBoard.dto.PartyBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<!-- SweetAlert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 Bootstrap3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<%--모델값 전달받기 --%>
<%
List<PartyBoard> partyBoardList = (List) request.getAttribute("partyBoardList");
%>

<%
PbPaging paging = (PbPaging) request.getAttribute("paging");
%>

<style type="text/css">
.top {
	padding: 10px;
	border-bottom: 1px solid #333;
	margin-bottom: 40px;
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

button:hover {
	background: #cff3b4;
}

.round-box {
	border: 1px solid #000;
	border-radius: 5px;
}

.notice {
	border: 1px solid #333;
	padding: 40px;
}

.notice h3 {
	text-align: center;
	margin-bottom: 25px;
}

#notice-table {
	width: 100%;
	text-align: center;
}

#notice-table tr:first-child th {
	text-align: center;
	padding: 10px;
	border-bottom: 1px solid #333;
}

#notice-table tr th:first-child {
	width: 10%;
}

#notice-table tr th:nth-child(2) {
	width: 15%;
}

#notice-table tr td {
	padding: 5px;
}

.noData {
	margin: 30px;
	text-align: center;
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

.manage-area {
	margin-bottom: 80px;
}

.manage-top, .btn-area {
	display: flex;
	justify-content: space-between;
}

.p-btn {
	background: #333;
	color: #fff;
	border: none;
	padding: 10px 30px;
	border-radius: 15px;
	text-decoration: none;
	font-weight: 600;
	border: none;
}

.manage-body {
	margin-top: 20px;
	padding: 20px 30 px;
}

.write-area {
	border-radius: 10px;
	border: 2px solid #b3b3b3;
	padding: 20px;
	margin: 15px 30px;
}

.btn-area button, .writerId {
	font-size: 18px;
	font-weight: bold;
}

.btn-area button {
	border: none;
	background: inherit;
	color: #b3b3b3;
}

textarea {
	border: none;
	resize: none;
	padding: 10px;
	width: 100%;
	height: 80px;
}
</style>


</head>
<body>
	<div class="top">
		<h1>파티방</h1>
	</div>

	<div class="container">

		<div class="notice">
			<!-- 			<h3>공지사항</h3> -->
			<table id="notice-table">
				<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>제목</th>
				</tr>

				<%
				for (int i = 0; i < partyBoardList.size(); i++) {
				%>

				<tr>
					<td><%=partyBoardList.get(i).getPartyBoardNo()%></td>
					<td><%=partyBoardList.get(i).getPartyBoardWriter()%></td>
					<td><%=partyBoardList.get(i).getPartyBoardTitle()%></td>
				</tr>

				<%
				}
				%>
			</table>
		</div>


		<form action="getBoardList.jsp" method="get">
			<!--  검색 시작  -->
			<div class="search-area">
				<div class="form-item">
					<select id="searchCondition" name="searchCondition">
						<option value="TITLE">제목</option>
						<option value="CONTENT">내용</option>
						<option value="IdNick">아이디(닉네임)</option>
					</select>
				</div>
				<div class="form-item">
					<input id="searchKeyword" name="searchKeyword" type="text">
				</div>
				<div class="form-item">
					<input type="submit" value="검색 ">
				</div>
			</div>
			<!-- 검색 종료  -->
		</form>

		<div class="manage-area">
			<div class="manage-top">
				<h3>📌게시글 관리</h3>
				<button class="p-btn">파티탈퇴</button>
			</div>
			<div class="manage-body">
				<div class="write-area">
					<div class="writerId">작성자</div>
					<textarea name="party_boardtitle" placeholder="내용을 입력해주세요."></textarea>
					<div class="btn-area">
						<div>
							<button>😀</button>
							<button>🔒</button>
						</div>
						<div>
							<button id="btnWrite" onclick="writePartyBoard();">등록</button>
						</div>
					</div>
				</div>
			</div>
		</div>


		<%-- 글번호 : <%=partyBoardList.get(i).getPartyBoardNo() %> --%>

	</div>

</body>
<script type="text/javascript">
	function writePartyBoard() {
		var partyBoardTitle = $('textarea[name=party_boardtitle]').val();
		console.log(partyBoardTitle);

		var url = "/homett/roomboardwrite";
		// sendRequest("POST", url, partyBoardTitle, callback)

		$.ajax({
			type : 'post',
			url : url,
			dataType : 'json',
			data : {
				partyBoardTitle : partyBoardTitle,

			},
			success : function(result) {
				console.log(result);
				if (result) {
					location.reload();
				} else {
					Swal.fire({
						icon : 'error',
						title : '저장실패',
						text : '저장에 실패하였습니다.',
					});
				}
			}
		});

	}
</script>
</html>