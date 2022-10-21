<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 스마트 에디터 2 라이브러리 -->
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>

<!-- jQuery 2.2.4 라이브러리 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	//작성 버튼 클릭
	$("#btnWrite").click(function() {
		
		//스마트 에디터에 작성된 내용을 <textarea>에 적용하기
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", [])
		
		//폼 제출
		$("form").submit()
		
	})
	
})
</script>

</head>
<body>
<h1>파티게시판</h1>
<hr>
<div>
<label>카테고리</label>
<input list="cat" id="category" name="category">
</div>

<datalist id="cat">
	<option>일반</option>
	<option>공지사항</option>
	<option>공유할 OTT계정 작성</option>
</datalist>

<br>
<form action="./partyRoomBoard" method="post">
	<textarea id="content" name="data"></textarea>
</form>

<button id="btnWrite">작성</button>

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
						<input id="searchKeyword" name="searchKeyword" type="text">
						<input type="submit" value="검색 ">
					</td>
				</tr>		
			</table>
		</form>
		<!-- 검색 종료  -->
		
		
			<br><br><br><br><br><br>
		<button>파티탈퇴</button>
		


<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "content", //에디터가 적용될 <textarea>의 id 적기
	sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
})
</script>

</body>
</html>