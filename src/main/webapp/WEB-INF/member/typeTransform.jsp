<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	//로그인 버튼
	$("#typeTransBtn").click(function() {
		$(this).parents("form").submit();
	})

// 	$("#typeTransBtn").click(function() {
// 		console.log("#typeTransBtn 클릭")

// 		$.ajax({
// 			type:"post"			//요청 메소드
// 			, url: "/homett/type"		//요청 URL
// 			, data: {		//요청 파라미터
<%-- 				userId : "<%=session.getAttribute("userId") %>" --%>
<%-- 				, userName : "<%=session.getAttribute("userName") %>" --%>
				
// 			}
// 		, dataType: "html"		//응답 데이터 형식
// 		, success: function( res ) {
// 			console.log("AJAX 성공")
// 			alert("회원권한이 파티장으로 변경되었습니다");
// 			location.href='/homett/main';
			
// 		}
// 		, error: function() {
// 			console.log("AJAX 실패")
			
// 		}
	
// 		})
// 	})
})
</script>


</head>
<body>
<h1>파티장 신청</h1>


<%-- 파티장 상태 --%>
<%	if( (Integer)session.getAttribute("masterNo") == 1 ) { %>
<h3>회원님은 이미 파티장입니다.</h3>
<hr><br>

<button class="btn" onclick="location.href='/homett/main'">메인페이지</button>
<%	} %>

<%-- 파티원 상태 --%>
<%	if( (Integer)session.getAttribute("masterNo") == 2 ) { %>

<form action="/homett/type" method="post" id="submitporm" >
<h3>공지를 잘 읽어보시고 파티장 변경하기를 눌러주세요</h3><br>
<p>아이디 :  <%=session.getAttribute("userId") %></p>
<p>판매자 이름 :  <%=session.getAttribute("userName") %></p>
<p>이메일 :  <%=session.getAttribute("userEmail") %></p>
<p>휴대폰번호 :  0<%= session.getAttribute("userPhone") %></p>

<h4>파티원 모집시 0%의 판매 수수료가 발생됩니다.</h4>

<button id="typeTransBtn">파티장 변경하기</button>

</form>

<button class="btn" onclick="location.href='/homett/main'">취소</button>

<%	} %>

</body>
</html>