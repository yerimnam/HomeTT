<%@page import="reviewBoard.dto.ReviewBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/layout/header.jsp" />
    
   <% ReviewBoard updatecotentReviewBoard = (ReviewBoard)request.getAttribute("updatecontent");  %>    
<!DOCTYPE html>
<html>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- bootstrap -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src="./summernote-lite.js"></script>
<script src="./summernote-ko-KR.js"></script>
<link rel="stylesheet" href="./summernote-lite.css">

<script type="text/javascript">

$(document).ready(function(){

	$('#content').summernote({
        	height: 500,
        	lang: 'ko-KR',
		    tollbar: [
		    ['style', ['bold', 'italic', 'underline', 'clear']],
		    ['font', ['strikethrough', 'superscript', 'subscript']],
		    ['fontname',['fontname']],
		    ['fontsize', ['fontsize']],
		    ['color', ['color']],
		    ['para', ['ul', 'ol', 'paragraph']],
		    ['height', ['height']]
		  ]
		});
	
		//textarea#note에 웹 에디터 적용
		$("#content").summernote()
		$("user_id").summernote()
						
	})
			
</script>

<script type="text/javascript">
$(document).ready(function(){

	$("#btinwrite").click(function(){
		
		$("#create").submit();
	})		
	
})

</script>

<style type="text/css">

body{
	width: 1600px;
	margin: 0 auto;
}

#content {
	width:  1000x;
	hieght: 1000px;
}

#title {
	justify-content: flex-start; 
	height: 50px; 
 	width: 600px;
	margin-left: 10px; 
	margin-bottom: -50px; 
	padding-left: 10px; 
	padding-top: 15px;
}

#subtitlebox {
	text-align: center; 
	border: 1px solid #ff9d76;
	border-top-left-radius: 5px;
	border-bottom-right-radius: 5px; 
	margin: 5px; 
	height: 100px; 
	background-color: #ffeaa6;
}

#allBtn {
	display: flex; 
	justify-content: center; 
	margin-top: -30px; 
	gap: 10px;
}

.mybtn {
	width: 75px;
	height: 55px;
	border-top-left-radius: 5px;
	border-bottom-right-radius: 5px;
	margin-right: -4;
	border: 1px solid #ffeaa6;
	background-color: rgba(0,0,0,0);
	color: #585a72;
	padding: 5px;
}

.mybtn:hover {
	color: #a9cd72;
	background-color: #ffeaa6;
}

.btn {
	width: 96px;
	height: 60px;
	border-top-left-radius: 5px;
	border-bottom-right-radius: 5px;
	margin-right: -4;
	border: 1px solid #585a72;
	background-color: #fffcee;
	color: #585a72;
	padding: 5px;
}
#e0e0c4

.btn:hover {
	color: #ffeaa6;
	background-color: #ffd925;
}

</style>

<body>

<div id="subtitlebox">
	<h2 style="padding-top: 15px; font-weight: 200; ">고객센터 / 1:1문의</h2>
</div>
<hr style="margin-bottom: 0px;">

<form action="/homett/inquirycreate" method="post" id="create">

	<br><br> <!-- 나중에 마진 패딩 적용하기  -->
	<span style="font-weight: bold; color: #ffd925; font-size: x-large; font-weight: bold; margin-left: 20px;">1:1문의</span><br>
	<div id="title">
		<label for="inquiryTitle">	
		<span style="font-weight: bold; font-size: large; font-weight: bold; ">제목<span>
		<input type="text" id="inquiryTitle" name="inquiryTitle" style="width: 300px;">
		</label>
	</div>
	
	
	<br><br><br>
	<textarea id="content" name="content"></textarea><br><br>

<div id="allBtn">
<button type="button" class="mybtn" id="btinwrite">작성완료</button>
<button type="button" class="mybtn" id="cancelwriter" onclick="history.back()">취소</button>
<button type="button" class="mybtn" id="returnBList">목록</button>
</div>
</form>



</script>







<jsp:include page="/WEB-INF/layout/footer.jsp" />