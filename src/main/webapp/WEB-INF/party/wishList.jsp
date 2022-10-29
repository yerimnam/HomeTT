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
  



<script type="text/javascript">

// #(document).ready(function(){

// 	$("#wishlist").click(function(){
// 		$("#wishlist_form").submit();
		
// 	})
	
// })



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
</head>

<body>


<!-- <h1>찜</h1> -->

<!-- 	<span class="heart on"> 🧡 하트 </span> -->


	<form action="homett/wishlist" method="post" id="wishlist_form">
		<button type="button" id="wishlist" name="wishlist">🤍</button>	
	</form>
	
</body>



</html>