<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <jsp:include page="/WEB-INF/layout/header.jsp" />

<!-- summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script type="text/javascript">



$(document).ready(function(){

	
	
	
	
	$('#content').summernote({

		minHeight: 500,
	        maxHeight: null,
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

#noticeTitle{
	width : 30%;
}
</style>


</head>
<body>
<h3>공지사항 작성</h3>
<br>
<form action="/homett/noticecreate" method="post" id="create">

	

	<div id="title">

	<input type="text" id="noticeTitle" name="noticeTitle" placeholder="제목">
	</div>
	
	<textarea id="content" name="content"></textarea><br><br>

<button type="button" id="btinwrite"  class="btn btn-info" >작성완료</button>
<button type="button" id="cancelwriter" class="btn btn-danger" onclick="history.back()">취소</button>

</form>
 <jsp:include page="/WEB-INF/layout/footer.jsp" />
