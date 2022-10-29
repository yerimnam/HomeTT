<%@page import="user.dto.MailSmsOk"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/layout/header.jsp" />


<% MailSmsOk ranNum = (MailSmsOk) request.getAttribute("ranNum"); %>
<script type="text/javascript">
$(document).ready(function() {
	

	$("#idBtn").click(function() {
		$("#idsearch").css('display', 'block')
		$("#pwsearch").css('display', 'none')
		
		$("#idBtn").css('border', '2px solid #ffd925')
		$("#idBtn").css('border-style', 'solid solid none solid')
		$("#idBtn").css('color', '#ffd925')
		$("#idBtn").css('background-color', '#fffcee')
		
		$("#pwBtn").css('border', '2px solid #ffd925')
		$("#pwBtn").css('border-style', 'none none solid none')
		$("#pwBtn").css('color', '#333333')
		$("#pwBtn").css('background-color', '#ffffff')
		
		$("#backBg").css('height','550px')
		
		$("#username").val("")
		$("#useremail").val("")
		
		$("#userid").val("")
		$("#usernamepw").val("")
		$("#userphone").val("")
		
	})
	
	$("#pwBtn").click(function() {
		$("#idsearch").css('display', 'none')
		$("#pwsearch").css('display', 'block')
		
		$("#pwBtn").css('border', '2px solid #ffd925')
		$("#pwBtn").css('border-style', 'solid solid none solid')
		$("#pwBtn").css('color', '#ffd925')
		$("#pwBtn").css('background-color', '#fffcee')
		
		$("#idBtn").css('border', '2px solid #ffd925')
		$("#idBtn").css('border-style', 'none none solid none')
		$("#idBtn").css('color', '#333333')
		$("#idBtn").css('background-color', '#ffffff')
		
		$("#backBg").css('height','550px')
		
		$("#username").val("")
		$("#useremail").val("")
		
		$("#userid").val("")
		$("#usernamepw").val("")
		$("#userphone").val("")
		
		
		
	})
	
	
	$("#idbtnCalc").click(function() {
		console.log("#idbtnCalc 클릭")
		
		//아이디가 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("username").value==""){
			alert("이름을 입력해주세요");
			$("input").eq(0).focus()
			return;
		} 
		
		
		//이메일이 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("useremail").value==""){
			alert("이메일 입력해주세요");
			$("input").eq(1).focus()
 			return;
		}
		
		
		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/searchid"		//요청 URL
			, data: {		//요청 파라미터
				name : $("#username").val()	
				, email : $("#useremail").val()
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			$("#okHide").css('display', 'block')
			$("#idbtnCalc").css('display','none')
			alert("회원님의 이메일로 인증번호를 발송하였습니다");
			$("#backBg").css('height','650px')
			
			
		}
		, error: function() {
			console.log("AJAX 실패")
			alert("입력하신 회원정보가 일치하지 않습니다");
			$("#username").focus()
			
		}			
			
		})
	})
	
	$("#remail").click(function() {
		console.log("#remail 클릭")

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/searchid"		//요청 URL
			, data: {		//요청 파라미터
				name : $("#username").val()	
				, email : $("#useremail").val()
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			alert("인증메일을 재전송 하였습니다");
// 			console.log(ranNum)
			
			
		}
		, error: function() {
			console.log("AJAX 실패")			
		}			
			
		})
	})
	
	
	
	$("#mailchk").click(function() {
		console.log("#mailchk 클릭")

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/emailok"	//요청 URL
			, data: {		//요청 파라미터
				mailOk : $("#emailOk").val()	
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			 window.location.href='/homett/emailok';
			
		}
		, error: function() {
			console.log("AJAX 실패")
			alert("입력하신 인증번호가 일치하지 않습니다");
		}			
			
		})
	})
	
	/* -----------------------------아이디 끝--------------------------------- */	
	
	/* -----------------------------비밀번호 시작--------------------------------- */	
	
	$("#pwbtnCalc").click(function() {
		console.log("#pwbtnCalc 클릭")

		//아이디가 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("userid").value==""){
			alert("아이디를 입력해주세요");
			$("input").eq(3).focus()
			return;
		} 
		
		
		//이름이 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("usernamepw").value==""){
			alert("이름을 입력해주세요");
			$("input").eq(4).focus()
 			return;
		}
		
		//휴대폰 번호가 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("userphone").value==""){
			alert("휴대폰 번호를 입력해주세요");
			$("input").eq(5).focus()
 			return;
		}
		
		
		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/searchpw"		//요청 URL
			, data: {		//요청 파라미터
				id : $("#userid").val()	
				, namepw : $("#usernamepw").val()
				, phone : $("#userphone").val()
				
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			$("#okHidepw").css('display', 'block')
			$("#pwbtnCalc").css('display','none')
			alert("회원님의 휴대폰 번호로 인증번호를 발송하였습니다");
			$("#backBg").css('height','680px')
			
			
		}
		, error: function() {
			console.log("AJAX 실패")
			alert("입력하신 회원정보가 일치하지 않습니다");
			$("#userid").focus()
			
		}			
			
		})
	})
	
	
	$("#resms").click(function() {
		console.log("#resms 클릭")

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/searchpw"		//요청 URL
			, data: {		//요청 파라미터
				id : $("#userid").val()	
				, namepw : $("#usernamepw").val()
				, phone : $("#userphone").val()
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			alert("인증문자를 재전송 하였습니다");
			
			
		}
		, error: function() {
			console.log("AJAX 실패")			
		}			
			
		})
	})
	
	
	$("#smschk").click(function() {
		console.log("#smschk 클릭")

		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/emailok"	//요청 URL
			, data: {		//요청 파라미터
				mailOk : $("#smsOk").val()	
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			 window.location.href='/homett/smsok';
			
		}
		, error: function() {
			console.log("AJAX 실패")
			alert("입력하신 인증번호가 일치하지 않습니다");
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
	height: 550px;
	margin: 0 auto;
	text-align: center;
	background-color: #fffcee;
	padding: 0 0 80px 0;
	position: relative;
}

#idBtn{
	width: 380px;
	height: 60px;
	border: 2px solid #ffd925;
	border-style: solid solid none solid;
	display: block;
	text-align: center;
	line-height: 60px;
	text-decoration: none;
	font-size: 16px;
	font-weight: 500;
	color: #ffd925;
	position: absolute;
}

#pwBtn{
	width: 380px;
	height: 60px;
	background-color: #ffffff;
	border: 2px solid #ffd925;
	border-style: none none solid none;
	display: block;
	text-align: center;
	line-height: 60px;
	text-decoration: none;
	font-size: 16px;
	font-weight: 500;
	color: #333333;
	right: 0;
	position: absolute;
}

/*---------------------------------- 아이디 구역 -------------------------------- */
#idsearch{
	padding-top: 120px;
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

/* 인풋 글 작성시 */
input:focus{
	border: 2px solid #ffd925;
    outline: none;
}

#btnDiv {
	clear: both;
	margin-top: 10px;
	text-align: center;
}	

#idbtnCalc {
	width: 380px;
	height: 54px;
	background-color: #ffd925;
	border: none;
	border-radius: 4px;
	font-size: 18px;
	color: #ffffff;
	font-weight: 600;
	line-height: 54px;
	
}


#remail{
 	background-color: #ffffff;
	border: 1px solid #ffd925;
	width: 380px;
	height: 54px;
	border-radius: 4px;
	font-size: 18px;
	color: #ffd925;
	font-weight: 600;
	line-height: 54px;
	margin-bottom: 6px;
	margin-top: 8px;
}

#mailchk{
	width: 380px;
	height: 54px;
	background-color: #ffd925;
	border: none;
	border-radius: 4px;
	font-size: 18px;
	color: #ffffff;
	font-weight: 600;
	line-height: 54px;
}

/*---------------------------------- 비밀번호 구역 -------------------------------- */

#pwsearch{
	padding-top: 120px;
}


#pwbtnCalc {
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


#btnDiv {
	clear: both;
	margin-top: 10px;
/* 	text-align: center; */
}	

#resms{
	background-color: #ffffff;
	border: 1px solid #ffd925;
	width: 380px;
	height: 54px;
	border-radius: 4px;
	font-size: 18px;
	color: #ffd925;
	font-weight: 600;
	line-height: 54px;
	margin-bottom: 6px;
	margin-top: 8px;
}

#smschk{
	width: 380px;
	height: 54px;
	background-color: #ffd925;
	border: none;
	border-radius: 4px;
	font-size: 18px;
	color: #ffffff;
	font-weight: 600;
	line-height: 54px;
}




</style>


</head>
<body>

<div id="backBg">

	<div id="textArea1">
	
	<a id="idBtn">아이디 찾기</a>
	<a id="pwBtn">비밀번호 찾기</a>
	
	<div id= "idsearch">
			<p id="mainTxt">아이디찾기</p>
			
			<P id="subTxt">아이디는 가입시 입력하신 이름과 이메일을 통해 찾을 수 있습니다.</P>
			
			<div>
				<input type="text" id="username"name="username" placeholder="이름" >
			</div>
		
			<div>
				<input type="text" id="useremail"name="useremail" placeholder="이메일">
			</div>
			
			<div id="okHide" style=" display: none">
				<input type="text" id="emailOk"name="emailOk"  autocomplete="off">
				<div class="re">
					<button id="remail">재전송</button>
					<button id="mailchk">인증 확인</button>
				</div>
			</div>
			
			<div id="btnDiv">
				<button id="idbtnCalc" style="display:inline-block;">아이디 찾기</button>
			</div>
		</div>
	
	</div> <!-- "idsearch" -->
	
	
	<div id= "pwsearch" style="display:none;">
		<p id="mainTxt">비밀번호찾기</p>
			
		<P id="subTxt">비밀번호는 가입시 입력하신 아이디와 이메일과 휴대폰번호를 통해 찾을 수 있습니다.</P>
	
		<div>
			<input type="text" id="userid"name="userid" placeholder="아이디">
		</div>

		<div>
			<input type="text" id="usernamepw"name="usernamepw" placeholder="이름">
		</div>
	
		<div>
			<input type="text" id="userphone"name="userphone" placeholder="휴대폰 번호">
		</div>
	
	
		<div id="okHidepw" style=" display: none">
			<input type="text" id="smsOk"name="smsOk" placeholder="인증번호를 입력해주세요.">
			<div class="re">
				<button id="resms">재전송</button>
				<button id="smschk">인증 확인</button>
			</div>
		</div>
	
		<div id="btnDiv">
			<button id="pwbtnCalc" style="display:inline-block;">비밀번호 찾기</button>
		</div>
	</div><!-- "pwsearch" -->
	

</div>



<jsp:include page="/WEB-INF/layout/footer.jsp" />















