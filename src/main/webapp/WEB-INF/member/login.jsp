<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnLogin").click(function() {
		console.log("#btnLogin 클릭")

		//아이디가 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("userid").value==""){
			alert("아이디를 입력해주세요");
			$("input").eq(0).focus()
			return;
		} 
		
		
		//비밀번호가 빈칸일때~~~~~~~~~~~~~~~~~!
		if(document.getElementById("userpw").value==""){
			alert("비밀번호를 입력해주세요");
			$("input").eq(1).focus()
 			return;
		}
		
		$.ajax({
			type:"post"			//요청 메소드
			, url: "/homett/login"		//요청 URL
			, data: {		//요청 파라미터
				id : $("#userid").val()	
				, pw : $("#userpw").val()
				
			}
		, dataType: "html"		//응답 데이터 형식
		, success: function( res ) {
			console.log("AJAX 성공")
			 window.location.href='/homett/main';
			
		}
		, error: function() {
			console.log("AJAX 실패")
			alert("로그인 회원정보가 일치하지 않습니다");
			$("#userid").focus()
			
		}			
			
		})
	})

	
	//아이디 입력창에 포커스주기
	$("input").eq(0).focus()
	
	//패스워드 입력창에 엔터키 입력 시 submit
	$("input").eq(1).keydown(function(e) {
		if( e.keyCode == 13 ) { //엔터키
			$("#btnLogin").click();
		}
	})
	
// 	//로그인 버튼
// 	$("#btnLogin").click(function() {
// 		$("#loginform").submit();
// 	})

})
</script>


<!-- <script src="https://developers.kakao.com/sdk/js/kakao.js"></script> 
    <script>
//         window.Kakao.init('498edbe67ebc25de922b6eddadd1ba05');

//         //로그인
//         function kakaoLogin() {
//             window.Kakao.Auth.login({
//                 scope: 'profile_nickname, account_email, gender', //동의항목 페이지에 있는 개인정보 보호 테이블의 활성화된 ID값을 넣습니다.
//                 success: function(response) {
//                     console.log(response) // 로그인 성공하면 받아오는 데이터
//                     window.Kakao.API.request({ // 사용자 정보 가져오기 
//                         url: '/v2/user/me',
//                         success: (res) => {
//                             const kakao_account = res.kakao_account;
//                             console.log(kakao_account)
//                             window.location.href='./main'
//                         }
//                     });
//                     // window.location.href='/ex/kakao_login.html' //리다이렉트 되는 코드
//                 },
//                 fail: function(error) {
//                     console.log(error);
//                 }
//             });
//         }
        
//         //로그아웃
//         function kakaoLogout() {
        	
//         	if (!Kakao.Auth.getAccessToken()) {
//     		    console.log('Not logged in.');
//     		    return;
//     	    }
        	
//     	    Kakao.Auth.logout(function(response) {
//     	    	window.Kakao.API.request({ // 사용자 정보 가져오기 
//                     url: '/oauth/logout'
//                     , data: {
//                     	client_id:'df076bd4ac86c0d0c941fdedd98976ba'
//                     	, logout_redirect_uri:'http://localhost:8888/homett/main'
//                     }
//                 });
//     	    	window.Kakao.API.request({ // 사용자 정보 가져오기 
//                     url: '/v1/user/unlik'                  
//                 });
//         		alert(response +' logout');
//     		    window.location.href='./main'
//     	    });
//     }; 
    
</script>-->

<!-- --------------------------------- 스타일 스크립트 시작 ---------------------------------  -->
<script type="text/javascript">
$(document).ready(function(){
	
// 	$(".gnb > a").mouseover(function(){
// // 		alert("마우스 Over");
// // 		$(this).css("color", "#ffffff");
// 		event.target.style.color = "#000000";
// 		});
	
// 	$(".gnb").mouseout(function(){
// 		event.target.style.color = "#666666";
// 	});
	
	
})


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
	color: #ffd925;
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
#divId, #divPw {
	position: relative;
	width: 380px;
	height: 54px;
	float: left;
	
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
	border: 2px solid #ffd925;
    outline: none;
}

/* 인풋 사이 간격 */
#divId {
	margin-bottom: 16px;
}

/* 아이디,비밀번호 찾기, 회원가입 찾기 박스 */
#searchJoin{
	display: block;
	width: 380px;
	height: 40px;
	clear: both;
	padding-top: 10px;
}

#search {
	float: left;

}

#search > a {
	letter-spacing :-0.5px;
	padding: 0;
}

#search :nth-child(1) {
	padding-left: 0;
}

#search > span {
	margin: 0 7px 0 7px;
	padding: 0;
	color: #cccccc;
	vertical-align: middle;
}

#join {
	float: right;
}

#join > a {
	letter-spacing :-0.5px;
	padding: 0;
}

a:hover {
	color: #ffd925; 
	font-weight: bold;
}


#loginDiv {
	clear: both;
	margin-top: 20px;
}

#loginDiv button {
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

#moveImg {
	position: absolute;
/* 	right: 800px; */
}

#moveImg > img {
	margin: 0 40px 0 40px;
}


</style>
<!-- --------------------------------- 스타일 끝 ---------------------------------  -->

</head>
<body>

<div id="bg">

	<div id="mainTxt">로그인</div>
	<p id="subTxt">HomeTT에 방문해주셔서 감사드립니다.</p>
	

	<!-- 아이디 비밀번호 인풋 -->
	<div id="divId">
		<input type="text" id="userid" name="userid" placeholder="아이디" autocomplete="off">
	</div>

	<div id="divPw">
		<input type="text" id="userpw" name="userpw" placeholder="비밀번호" autocomplete="off">
	</div>
	
	<!-- input 하단 메뉴 버튼 -->
	<div id = "searchJoin">
		<div id="search">
			<a href="/homett/searchid" class="btn" id="btnSearchId">아이디 비밀번호 찾기</a>
		</div>
		
		<div id="join">
			<a href="/homett/join" class="btn" id="btnJoin">회원가입</a>
		</div>
	</div>
	
	<!-- 로그인 버튼 -->
	<div id="loginDiv">
		<button id="btnLogin">로그인</button>
	</div>
</div>

<!-- <MARQUEE id="moveImg" scrollamount="14"> -->
<!-- 	<img src= "/resources/img/NETFLIX.png" height="40px"> -->
<!-- 	<img src= "/resources/img/COUPANGPLAY.png" height="40px"> -->
<!-- 	<img src= "/resources/img/TVING.png" height="34px"> -->
<!-- 	<img src= "data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTk2IiBoZWlnaHQ9IjU5IiB2aWV3Qm94PSIwIDAgMTk2IDU5IiBmaWxsPSJub25lIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgo8cGF0aCBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGNsaXAtcnVsZT0iZXZlbm9kZCIgZD0iTTc4LjI3MTMgMTIuOTE4NFYyMC43NzFIODYuMDk0NlY1Ni4xOTU2SDk1Ljg0MzJWMjAuNzcxSDEwMy4yMThWMTIuOTE4NEg3OC4yNzEzWk0xNTMuNDY0IDI5LjYzODlIMTQ2LjAwNFYxMi45NzYzSDEzNi4yODVWNTYuMjUzMkgxNDYuMDA0VjM3LjQ5MTJIMTUzLjQ2NFY1Ni4yNTMySDE2My4xODNWMTIuOTc2M0gxNTMuNDY0VjI5LjYzODlaTTExOS42MTMgMTIuNDUyN0gxMTcuOTJDMTA5LjE0MiAxMi40NTI3IDEwNS42MzEgMTYuOTMxNiAxMDUuNjMxIDI0LjIwM1Y0NC44NTIxQzEwNS42MzEgNTIuMTIzOSAxMDkuMTQyIDU2Ljc3NyAxMTguMTA4IDU2Ljc3N0gxMTkuODAxQzEyOC43MDQgNTYuNzc3IDEzMS44MzkgNTEuNDI1MiAxMzEuODM5IDQ1LjM3NjNWMzcuOTg5MUgxMjIuMzA5VjQ0Ljg1MjFDMTIyLjMwOSA0Ny40MTIzIDEyMS40MzEgNDguOTgyNiAxMTguOTIzIDQ4Ljk4MjZDMTE2LjQ3NyA0OC45ODI2IDExNS42NjMgNDcuNTI4NiAxMTUuNjYzIDQ0Ljc5NDZWMjQuMTQ0NkMxMTUuNjYzIDIxLjQxMDUgMTE2LjQ3NyAyMC4wMTUgMTE4LjkyMyAyMC4wMTVDMTIxLjQ5MyAyMC4wMTUgMTIyLjMwOSAyMS41MjY5IDEyMi4zMDkgMjQuMTQ0NlYyOS4xNDdIMTMxLjgzOVYyMy42MjFDMTMxLjgzOSAxNi40MDg3IDEyOC40NTMgMTIuNDUyNyAxMTkuNjEzIDEyLjQ1MjdaTTY4Ljc4MiA0MS40MjI0TDY1Ljk1NTggMjMuMzMxNkg2NC4yODQxTDYxLjQ1NzYgNDEuNDIyNEg2OC43ODJaTTcyLjMyNjIgMTIuOTE4NEw3OS45NzU5IDU2LjE5NTZINzEuMDkwMkw3MC4wMDkgNDkuMjc1M0g2MC4yMzA4TDU5LjE0OTMgNTYuMTk1Nkg1MC4yNjM2TDU3LjkxMzYgMTIuOTE4NEg3Mi4zMjYyWk0xODQuMzkxIDQxLjQyMjRMMTgxLjU2NCAyMy4zMzE2SDE3OS44OTNMMTc3LjA2NiA0MS40MjI0SDE4NC4zOTFaTTE4Ny45MzUgMTIuOTE4NEwxOTUuNTg1IDU2LjE5NTZIMTg2LjY5OUwxODUuNjE4IDQ5LjI3NTNIMTc1Ljg0TDE3NC43NTkgNTYuMTk1NkgxNjUuODczTDE3My41MjIgMTIuOTE4NEgxODcuOTM1WiIgZmlsbD0iI0ZGMDU1OCIvPgo8cGF0aCBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGNsaXAtcnVsZT0iZXZlbm9kZCIgZD0iTTQyLjI1MDEgMC43NTc4MTJMMzkuMzUyMSA0Mi4yMDY3TDM4LjU3MzMgNDIuMjQ2NkwzMS42ODA3IDEyLjkyMjRIMjMuMTY0TDE4LjAwNzggNDMuMzA3MkwxNi45MDI3IDQzLjM2MzlMMTIuMjg2MiAxMi45MjI0SDAuNDE0MDYyTDExLjIxNTEgNTguMjM5N0wyMy4yODkxIDU3LjQ1NTdMMjcuMjE3MyAyOS4zMjY4TDI4LjM2OTQgMjkuMjY1M0wzMy42Mjk1IDU2Ljc3NjFMNDUuMTg1NSA1Ni4wMjA2TDU0LjM2MjUgMC43NTc4MTJINDIuMjUwMVoiIGZpbGw9IiNGRjA1NTgiLz4KPC9zdmc+Cg==" height="40px"> -->
<!-- 	<img src= "https://w.namu.la/s/95e5f2c35a862a7cc599dcb8b3c385a9cf67a45967350973baf9f77c62bca575107bfcf4b1318b1c95af5a8faeb2bb1cae918a7745feea0b42f1b8ba495ad75a020b96491c0d4d404328a6c3c213082093f4fd545bccf3ac5aeecee2673c3198" height="40px"> -->
<!-- 	<img src= "/resources/img/SEEZN.png" height="30px"> -->
<!-- 	<img src= "/resources/img/Disney.png" height="40px"> -->
<!-- 	<img src= "/resources/img/Apple.png" height="40px"> -->
<!-- </MARQUEE> -->




<!-- 	<button class="btn" id="btnJoin" onclick="location.href='/homett/main'">메인페이지</button><br><br> -->
<!-- <a href="javascript:kakaoLogin();"><img src="//k.kakaocdn.net/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg" alt="카카오계정 로그인" width="20%" height="20%"/></a> -->
<!-- <a href="javascript:kakaoLogout();">로그아웃</a> -->
<!-- <a href="https://kauth.kakao.com/oauth/logout?client_id=df076bd4ac86c0d0c941fdedd98976ba&logout_redirect_uri=http://localhost:8888/homett/main">로그아웃11</a> -->

    
    
<jsp:include page="/WEB-INF/layout/footer.jsp" />



