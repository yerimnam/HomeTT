<%@page import="event.dto.EventBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% EventBoard updatecotent = (EventBoard)request.getAttribute("updatecontent");  %>    

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
	
	

$(document).ready(function(){

	$("#btnupdate").click(function(){
		
		console.log("click")
		$(this).parents("form").submit();
	})		
	
})



function updatedone(){
	
	console.log("완료")
		alert("수정완료")
	
}
			
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


<h2>이벤트 수정하기</h2>

<hr>
<form action="/homett/eventupdate" method="post" id="updateevent">

	<input type="text" hidden="" name="eventNo" value="<%=updatecotent.getEventArticlenumber() %>">
	
	
	<div id="title">
	<input type="text" id="eventTitle" name="eventTitle" value="<%=updatecotent.getEventArticletitle() %>" placeholder="제목">
	</div>
	

	<textarea id="content" name="content" ><%= updatecotent.getEventContent()%></textarea><br><br>

<button type="button" id="btnupdate"  class="btn btn-info" >수정완료</button>
<button type="button" id="cancelwriter" class="btn btn-danger" onclick="history.back()">취소</button>
</form>


 <jsp:include page="/WEB-INF/layout/footer.jsp" />