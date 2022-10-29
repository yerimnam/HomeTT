<%@page import="reviewBoard.dto.ReviewBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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

<script type="text/javascript">

$(document).ready(function(){

	$('#content').summernote({
		  toolbar: [
		    // [groupName, [list of button]]
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
	width:  300x;
	hieght: 1000px;

}

</style>


<body>

<h2>문의사항 작성하기</h2>

<hr>

<form action="/homett/inquirycreate" method="post" id="create">

	

	<br><br> <!-- 나중에 마진 패딩 적용하기  -->
	<div id="title">
	<span>제목</span>
	<input type="text" id="inquiryTitle" name="inquiryTitle">
	</div>
	
	<br><br><br>
	<textarea id="content" name="content"></textarea><br><br>

<button type="button" id="btinwrite" >작성완료</button>
<button type="button" id="cancelwriter" onclick="history.back()">취소</button>
</form>







</body>
</html>