<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	

	//아이디 입력창에 포커스주기
	$("input").eq(0).focus()
	
	//회원가입 버튼
	$("#btnJoin").click(function() {
		$(this).parents("form").submit();
	})
	
	//가입취소 버튼
	$("#btnCancel").click(function() {
		history.go(-1) //뒤로가기
	})
	
})

//input 데이터의 유효성 검증
function validate() {
	
	//--- ID 유효성 검증 ---
	
	//아이디가 비어있을때 
	if( $("#userid").val() == '') {
		
// 		alert("아이디를 입력해주세요!")
		document.getElementById("idCheckMsg1").style.display = 'block';
		return false;
	} else {
		document.getElementById("idCheckMsg1").style.display = 'none';
	}
	
	//아이디 입력값 검증
	if( !/^[a-zA-Z0-9]{4,12}$/.test( $("#uid").val() ) ) {
		$('#uid_msg').html("아이디는 4~12글자의 영문자, 숫자가 가능합니다");
		
		return false;
	}
	
	//----------------------------
	
	//--- PASSWORD 유효성 검증 ---
	
	//패스워드를 입력하지 않았을 때
	if( $("#upw").val() == '' ) {
		$("#upw_msg").html("패스워드를 입력해주세요!")
		
		return false;
	}
	
	//패스워드 입력값 검증
	if( !/^[a-zA-Z]{4,8}$/.test( $("#upw").val() ) ) {
		$('#upw_msg').html("패스워드는 영어 대소문자 4~8자만 입력하세요!");
		
		return false;
	}
	
	if( $("#upw").val() != $("#upw_check").val() ) {
		$("#upw_check_msg").html("비밀번호 확인 입력이 동일하지 않흡니다")
		
		return false;
	}
	
	//----------------------------
	
	return true;
	
}

</script>


<!-- --------------------------------- 스타일 시작 ---------------------------------  -->
<style type="text/css">

@import url('https://webfontworld.github.io/sunn/SUIT.css');


html, body, pre, h1, h2, h3, h4, h5, h6, dl, dt, dd, ul, li, ol, th, td, p, blockquote, form, fieldset, legend, menu, nav, section, hgroup, article, header, aside, footer, input, select, textarea, button {
    margin: 0;
    padding: 0;
    font-family: 'SUIT';
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
	font-family: 'Montserrat';
	font-weight: 700;
	color: #ffde59;
}

/* 서브텍스트 */
#subTxt {
	font-size: 16px;
	text-align: center;
	margin: 15px 0 40px 0;
	color: #888888;
 	font-weight: 400;
 	font-family: 'SUIT';
}

/* input 상위 박스 */
.input {
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
/* 	background-color: #eeeeee; */
	border: 1px solid #dddddd;
	border-radius: 4px;
	padding-left: 20px;
	position: absolute;
}

/* 인풋 글 작성시 */
input:focus{
	border: 2px solid #ffde59;
    outline: none;
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
	margin-top: 18px;
	position: absolute;
	background-color: #ffffff;
	border: 1px solid #ffde59; 
	color: #ffde59; 
}

#btnJoin {
	width: 185px;
	height: 54px;
	background-color: #ffde59;
	border: none;
	border-radius: 4px;
	font-size: 18px;
	color: #ffffff;
	font-weight: 600;
	text-align: center;
	line-height: 54px;
	margin-top: 18px;
	position: absolute;
	float: right;
	right: 0;
}






</style>

<!-- --------------------------------- 스타일 끝 ---------------------------------  -->


</head>
<body>


<form action="/homett/join" method="post">
	
<div id="bg">

	<div id="mainTxt">회원가입</div>
	<p id="subTxt">HomeTT에 방문해주셔서 감사드립니다.</p>
	
	
	<!-- 아이디 -->
	<div class="input">
		<input type="text" id="userid" name="userid" placeholder="아이디를 입력해 주세요">
	</div>
	<em class="msgInvalid" id="idCheckMsg1" style="display:none">4~20자의 영문, 숫자와 특수문자'_'만 사용해주세요.</em>

	<!-- 비밀번호 -->
	<div class="input">	
		<input type="text" id="userpw" name="userpw" placeholder="비밀번호를 입력해 주세요">
	</div>

	<!-- 비밀번호 확인 -->	
	<div class="input">
		<input type="text" id="userpw_check" name="userpw" placeholder="입력하신 비밀번호를 입력해 주세요">
	</div>

	<!-- 이름 -->
	<div class="input">
		<input type="text" id="username" name="username" placeholder="이름을 입력해 주세요">
	</div>

	<!-- 닉네임 -->	
	<div class="input">
		<input type="text" id="usernick" name="usernick" placeholder="닉네임을 입력해 주세요">
	</div>

	<!-- 이메일 -->	 
	<div class="input">
		<input type="text" id="useremail" name="useremail" placeholder="이메일을 입력해 주세요">
	</div>

	<!-- 휴대폰 번호 -->
	<div class="input">
		<input type="text" id="userphone" name="userphone" placeholder="휴대폰 번호를 입력해 주세요">
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
