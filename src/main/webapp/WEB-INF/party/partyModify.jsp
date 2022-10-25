<%@page import="util.PrPaging"%>
<%@page import="party.dto.Party"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- SweetAlert2 -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css"> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>  -->



<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 Bootstrap3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<script type="text/javascript">

// $(function(){
	
// 	$('.part-title, .part-contents').not('.heart-area').on('click',function(e) {
// 	    swal({
// 	    	//여기에 파티 정보가 나오게했음 좋겠다
// 	    title: "해당 파티에 가입하시겠습니까?", 
// 	    type: "warning",
// 	    confirmButtonText: "가입",
// 	    showCancelButton: true
// 	    })
// 	      .then((result) => {
// 	      if (result.value) {
	    	  
// 			  window.location = '/homett/joinparty';
	      
// 	      //목록으로 라고 글자를 넣어도 안바뀐다
// 	      } else if (result.dismiss === 'cancel') {
// 	          swal(
// 	            'Cancelled',
// 	            'Your stay here :)',
// 	            'error'
// 	          )
// 	      }
// 	    })
// 	});
	
// 	$(document).on('click', '.heart', function(){
// 		// 하트 상태 DB 저장
// 		$(this).toggleClass('on off');
// 	});

// });



</script>

<%--모델값 전달받기 --%>
<%
List<Party> partyList = (List) request.getAttribute("partyList");
%>
<%
PrPaging paging = (PrPaging) request.getAttribute("paging");
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
		<h1>파티모집 게시판</h1>
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

					<li><a href="./partyroomdetail?partyRoomNo=<%=partyList.get(i).getPartyRoomNo()%>">파티방 번호 : <%=partyList.get(i).getPartyRoomNo() %></a></li>
					<li>파티장 : <%=partyList.get(i).getPartyLeader()%></li>
					<li>파티 만료일 : <%=partyList.get(i).getPartyEndDate()%></li>
					<li>모집 인원 : <%=partyList.get(i).getPartyMember()%></li>
					<li style="border-bottom: 1px solid #333;">참여 금액 : <%=partyList.get(i).getPaymentAmount()%></li>
					<li>참여 금액 : <%=partyList.get(i).getPaymentAmount()%> 원
					</li>
				</ul>
				<span class="heart-area"> <span class="heart on"> 🧡 하트 </span>

				</span>
			</div>
			<!-- #party end -->

			<%
			}
			%>
		</div>
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

	<form action="./partymodify" method="get">
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



</body>
</html>