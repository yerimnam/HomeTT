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
	            .prev('#userpw').attr('type',"text");
	        }else{
	            $(this).attr('class',"fa-solid fa-eye")
	            .prev('#userpw').attr('type','password');
	        }
	    });
	    
	    $('#i2').on('click',function(){
	        $('input').toggleClass('active');
	        if($('input').hasClass('active')){
	            $(this).attr('class',"fa-solid fa-eye-slash")
	            .prev('#userpw_check').attr('type',"text");
	        }else{
	            $(this).attr('class',"fa-solid fa-eye")
	            .prev('#userpw_check').attr('type','password');
	        }
	    });
	

	
	$("#sameChk").click(function(){
		console.log("#sameChk 클릭")
		
		$.ajax({
			type : "post"
			, url : "/homett/joinidchk"
			, data : {
				userId : $("#userid").val()
			}
			, dataType : "html"
			, success : function( result ){
				if(result == 0){
					$("#checkIdBox").css('display', 'block')
					$("#checkId").html('사용할 수 없는 아이디입니다.');
					$("#checkId").attr('color','red');
					
				} else {
					$("#checkIdBox").css('display', 'block')
					$("#checkId").html('사용할 수 있는 아이디입니다.');
					$("#checkId").attr('color','green');
					$("#sameChk").val('2')
					
				} 
			},
			error : function(){
				alert("서버요청실패");
			}
		})
			 
	})
	
	
	$("#btnJoin").click(function() {
		
		//아이디가 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("userid").value==""){
			alert("아이디를 입력해주세요");
			$("input").eq(0).focus()
			return;
		} 
		
		
		//아이디가 중복일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("sameChk").value=="1"){
			alert("아이디 중복검사를 실행해주세요");
			$("#sameChk").focus()
			return;
		} 
		
		
		//비밀번호가 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("userpw").value==""){
			alert("비밀번호를 입력해주세요");
			$("input").eq(1).focus()
 			return;
		}
		
		
		//비밀번호 확인이 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("userpw_check").value==""){
			alert("비밀번호 확인을 입력해주세요");
			$("input").eq(2).focus()
 			return;
		}
		
		
		//비밀번호 확인이 비밀번호랑 같지 않을때~~~~~~~~~~~~~~~~~!
		if( !(document.getElementById("userpw_check").value == document.getElementById("userpw").value )){
			alert("비밀번호 확인을 비밀번호와 동일하게 입력해주세요.");
			$("input").eq(2).focus()
 			return;
		}
		
		
		//이름이 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("username").value==""){
			alert("이름을 입력해주세요");
			$("input").eq(3).focus()
 			return;
		}
		
		//닉네임이 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("usernick").value==""){
			alert("닉네임을 입력해주세요");
			$("input").eq(4).focus()
 			return;
		}
		
		//이메일이 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("useremail").value==""){
			alert("이메일을 입력해주세요");
			$("input").eq(5).focus()
 			return;
		}
		
		//휴대폰번호가 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("userphone").value=="" || (document.getElementById("userphone").value).length != 11){
			alert("휴대폰번호를 정확히 입력해주세요");
			$("input").eq(6).focus()
 			return;
		}
		
		
		    
		$(this).parents("form").submit();
		
	})
	
	
	
	
	//아이디 입력창에 포커스주기
	$("input").eq(0).focus()
	
	//가입취소 버튼
	$("#btnCancel").click(function() {
		history.go(-1) //뒤로가기
	})
	
})



</script>


<!-- --------------------------------- 스타일 시작 ---------------------------------  -->
<style type="text/css">

@import url('https://webfontworld.github.io/sunn/SUIT.css');


html, body, pre, h1, h2, h3, h4, h5, h6, dl, dt, dd, ul, li, ol, th, td, p, blockquote, form, fieldset, legend, menu, nav, section, hgroup, article, header, aside, footer, input, select, textarea, button {
    margin: 0;
    padding: 0;
    font-family: ‘SUIT Variable’, sans-serif;
}

li{
	list-style:none;
}

a{
	color: #666666;
}

/* 위치를 잡아줄 배경 */
#bg {

	width: 380px;
	margin: 0 auto;

}

/* 메인 텍스트 */
#mainTxt {
	width:380px;
	height:50px;
	text-align: center;
	font-size: 38px;
	font-family: 'SUIT';
	font-weight: 700;
	color: #ffde59;
}

/* 서브텍스트 */
#subTxt {
	font-size: 16px;
	text-align: center;
	margin: 10px 0 30px 0;
	color: #888888;
 	font-weight: 400;
 	font-family: 'SUIT';
}


/* input 상위 박스 */
.input {
	z-index:1;
	position: relative;
	width: 380px;
	height: 54px;
	float: left;
	margin-bottom: 16px;
}

/* input 박스 */
div > input {
	width: 380px;
	height: 54px;
	border: 1px solid #dddddd;
	border-radius: 4px;
	padding-left: 20px;
	position: absolute;
}

/* 인풋 글 작성시 */
input:focus{
	border: 2px solid #ffd925;
    outline: none;
}

/* 중복확인 버튼 */
#sameChk{
	position: absolute;
	z-index:2;
	float: right;
	right: 12px;
	top: 12px;
	
	width: 80px;
	height: 30px;
 	background-color: #ffde59; 
 	border: 1px solid #ffde59; 
	font-size: 13px;
	font-weight: 600;
	border-radius: 7px;
	color: #555555;
	
}


/* 버튼 부분ㄱ*/
#btnDiv {
	clear: both;
	width: 380px;
	height: 54px;
	position: relative;
}


#btnCancel {
	width: 185px;
	height: 54px;
	border-radius: 4px;
	font-size: 18px;
	font-weight: 600;
	text-align: center;
	line-height: 54px;
	margin-top: 10px;
	position: absolute;
	background-color: #ffffff;
	border: 1px solid #ffd925; 
	color: #ffde59; 
}

#btnJoin {
	width: 185px;
	height: 54px;
	background-color: #ffd925;
	border: none;
	border-radius: 4px;
	font-size: 18px;
	color: #ffffff;
	font-weight: 600;
	text-align: center;
	line-height: 54px;
	margin-top: 10px;
	position: absolute;
	float: right;
	right: 0;
}

/* 아이디화면 결과 텍스트 */
#checkIdBox {
	width: 380px;
	height: 17px;
	clear: both;
	position: relative;
}

#checkId {
	position: absolute;
	bottom: 11px;
	left: 2px;
}



.fa-solid{
	width: 32px;
	position: absolute;
	right: 10px;
 	top: 16px; 
	font-size: 22px;
	vertical-align: middle;
	text-align: center;
	color: #ffde59;
}





</style>

<!-- --------------------------------- 스타일 끝 ---------------------------------  -->


</head>
<body>

<form action="/homett/join" method="post" name="joinForm">
	
<div id="bg">

	<div id="mainTxt">회원가입</div>
	<p id="subTxt">HomeTT에 방문해주셔서 감사드립니다.</p>
	
	
	<!-- 아이디 -->
	<div class="input" id="input1">
		<button type="button" id="sameChk" value="1">중복 확인</button>
		<input type="text" id="userid" name="userid" placeholder="아이디"  autocomplete='off'>
	</div>
	<div id="checkIdBox" style=" display: none">
		<font id = "checkId" size = "2"></font>
	</div>
	

	<!-- 비밀번호 -->
	<div class="input">	
		<input type="password" id="userpw" name="userpw" placeholder="비밀번호" autocomplete='off'>
		<i class="fa-solid fa-eye" id="i1"></i>
	</div>
		
	
	<!-- 비밀번호 확인 -->	
	<div class="input">
		<input type="password" id="userpw_check" name="userpw" placeholder="비밀번호 확인" autocomplete='off'>
		<i class="fa-solid fa-eye" id="i2"></i>
	</div>

	<!-- 이름 -->
	<div class="input">
		<input type="text" id="username" name="username" placeholder="이름" autocomplete='off'>
	</div>

	<!-- 닉네임 -->	
	<div class="input">
		<input type="text" id="usernick" name="usernick" placeholder="닉네임" autocomplete='off'>
	</div>

	<!-- 이메일 -->	 
	<div class="input">
		<input type="text" id="useremail" name="useremail" placeholder="이메일" autocomplete='off'>
	</div>

	<!-- 휴대폰 번호 -->
	<div class="input">
		<input type="text" id="userphone" name="userphone" placeholder="휴대폰 번호 " autocomplete='off'>
	</div>


	<!-- 가입,취소 -->
	<br>
	<div id="btnDiv">
		<button type="button" id="btnCancel">가입취소</button>
		<button type="button" id="btnJoin" >가입하기</button>
	</div>

</div>
</form>

<jsp:include page="/WEB-INF/layout/footer.jsp" />
