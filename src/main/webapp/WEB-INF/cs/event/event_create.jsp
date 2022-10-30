<%@page import="event.dto.EventBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% EventBoard create = (EventBoard)request.getAttribute("eventInsert"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			    ['fontname', ['fontname']],
			    ['fontsize', ['fontsize']],
			    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
			    ['color', ['forecolor','color']],
			    ['table', ['table']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    ['height', ['height']],
			    ['view', ['fullscreen', 'help']]
			  ],
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
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

</head>
<body>
<form action="/homett/eventcreate" method="post" id="create">

	

	<div id="title">
	<span>제목</span>
	<input type="text" id="eventTitle" name="eventTitle">
	</div>
	
	<br><br><br>
	<textarea id="content" name="content"></textarea><br><br>

<button type="button" id="btinwrite" >작성완료</button>
<button type="button" id="cancelwriter" onclick="history.back()">취소</button>

</form>
</body>
</html>
