<%@page import="user.dto.MailSmsOk"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	
	
	//비밀번호 보여주는거
    $('#i1').on('click',function(){
        $('input').toggleClass('active');
        if($('input').hasClass('active')){
            $(this).attr('class',"fa-solid fa-eye-slash")
            .prev('#newPw').attr('type',"text");
        }else{
            $(this).attr('class',"fa-solid fa-eye")
            .prev('#newPw').attr('type','password');
        }
    });
    
    $('#i2').on('click',function(){
        $('input').toggleClass('active');
        if($('input').hasClass('active')){
            $(this).attr('class',"fa-solid fa-eye-slash")
            .prev('#newPw_check').attr('type',"text");
        }else{
            $(this).attr('class',"fa-solid fa-eye")
            .prev('#newPw_check').attr('type','password');
        }
    });
    
    
	
	$("#newPwchk").click(function() {
		
		//비밀번호가 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("newPw").value==""){
			alert("비밀번호를 입력해주세요");
			$("input").eq(0).focus()
 			return;
		}
		
		
		//비밀번호 확인이 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("newPw_check").value==""){
			alert("비밀번호 확인을 입력해주세요");
			$("input").eq(1).focus()
 			return;
		}
		
		
		//비밀번호 확인이 비밀번호랑 같지 않을때~~~~~~~~~~~~~~~~~!
		if( !(document.getElementById("newPw_check").value == document.getElementById("newPw").value )){
			alert("비밀번호 확인을 비밀번호와 동일하게 입력해주세요.");
			$("input").eq(1).focus()
 			return;
		}
		
		
		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/updatepw"		//요청 URL
			, data: {		//요청 파라미터
				newPw : $("#newPw").val()	
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			location.href='/homett/pwok';
			
		}
		, error: function() {
			console.log("AJAX 실패")
		}			
			
		})
		
	})
	
})
</script>


<style type="text/css">

@import url('https://webfontworld.github.io/sunn/SUIT.css');

html, body, pre, h1, h2, h3, h4, h5, h6, dl, dt, dd, ul, li, ol, th, td, p, blockquote, form, fieldset, legend, menu, nav, section, hgroup, article, header, aside, footer, input, select, textarea, button {
    margin: 0;
    padding: 0;
    font-family: 'SUIT';
}


#backBg {	
	width: 760px;
	height: 480px;
	margin: 0 auto;
	text-align: center;
	background-color: #fffcee;
	padding: 80px 0 80px 0;
	position: relative;
}

#mainTxt{
	font-size: 28px;
	color: #222222;
	font-weight: 500;
	margin-bottom: 4px;
}

#subTxt {
	font-size: 15px;
	color: #888888;
	font-weight: 300;
	margin-bottom: 46px;
}


/* input 박스 */
div > input {
	width: 380px;
	height: 54px;
	border: 1px solid #dddddd;
	border-radius: 4px;
	padding-left: 20px;
	margin-bottom: 10px;
}

#newPwchk {
	width: 380px;
	height: 54px;
	background-color: #ffd925;
	border: none;
	border-radius: 4px;
	font-size: 18px;
	color: #ffffff;
	font-weight: 600;
	text-align: center;
	line-height: 54px;
}
 
 
#i1{
	width: 32px;
	right: 200px;
	bottom: 250px;
	font-size: 22px;
	vertical-align: middle;
	text-align: center;
	color: #ffde59;
	position: absolute;
}

#i2{
	width: 32px;
	right: 200px;
	bottom: 186px;
	font-size: 22px;
	vertical-align: middle;
	text-align: center;
	color: #ffde59;
	position: absolute;
}

</style>




 


</head>
<body>




<!-- <form action="/homett/updatepw" method="post"> -->

<div id="backBg">	

	<p id="mainTxt">비밀번호 재설정</p>
			
	<P id="subTxt">기존 비밀번호를 변경해야합니다. 아래에 새 비밀번호를 입력해 주세요.</P>
	
	<div class="inputbox">
		<input type="password" id="newPw" name="newPw" placeholder="비밀번호">
		<i class="fa-solid fa-eye" id="i1"></i>
	</div>
	<div class="inputbox">
		<input type="password" id="newPw_check"name="newPw_check" placeholder="비밀번호 확인">
		<i class="fa-solid fa-eye" id="i2"></i>
	</div>
	
	<div class="re">
		<button id="newPwchk" >비밀번호 변경</button>
	</div>
	
</div>

<!-- <div> -->
<!-- 	<label for="username">새로운 비밀번호 확인</label> -->
<!-- 	<input type="text" id="username"name="username"> -->
<!-- </div> -->

<!-- </form> -->


<jsp:include page="/WEB-INF/layout/footer.jsp" />