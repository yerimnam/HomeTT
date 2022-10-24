<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 카카오 로그인 -->
<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
// 	$("form").submit(function(){
// 		console.log("submit event")
		
// 		//유효성 검증 후 submit
// 		if( validate() ) {
			
// 			$(this).submit();
// 		}
// 		//submit 중단시키기(새로고침 되는거 방지)
// 		alert("회원정보를 전부 입력해주세요")
// 		return false;
// 	})
	

	//아이디 입력창에 포커스주기
	$("input").eq(0).focus()
	
	//패스워드 입력창에 엔터키 입력 시 submit
	$("input").eq(1).keydown(function(e) {
		if( e.keyCode == 13 ) { //엔터키
			$("#btnLogin").click();
		}
	})
	
	//로그인 버튼
	$("#btnLogin").click(function() {
		$("#loginform").submit();
	})

})
</script>


<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script>
        window.Kakao.init('498edbe67ebc25de922b6eddadd1ba05');

        //로그인
        function kakaoLogin() {
            window.Kakao.Auth.login({
                scope: 'profile_nickname, account_email, gender', //동의항목 페이지에 있는 개인정보 보호 테이블의 활성화된 ID값을 넣습니다.
                success: function(response) {
                    console.log(response) // 로그인 성공하면 받아오는 데이터
                    window.Kakao.API.request({ // 사용자 정보 가져오기 
                        url: '/v2/user/me',
                        success: (res) => {
                            const kakao_account = res.kakao_account;
                            console.log(kakao_account)
                            window.location.href='./main'
                        }
                    });
                    // window.location.href='/ex/kakao_login.html' //리다이렉트 되는 코드
                },
                fail: function(error) {
                    console.log(error);
                }
            });
        }
        
        //로그아웃
        function kakaoLogout() {
        	
        	if (!Kakao.Auth.getAccessToken()) {
    		    console.log('Not logged in.');
    		    return;
    	    }
        	
    	    Kakao.Auth.logout(function(response) {
    	    	window.Kakao.API.request({ // 사용자 정보 가져오기 
                    url: '/oauth/logout'
                    , data: {
                    	client_id:'df076bd4ac86c0d0c941fdedd98976ba'
                    	, logout_redirect_uri:'http://localhost:8888/homett/main'
                    }
                });
//     	    	window.Kakao.API.request({ // 사용자 정보 가져오기 
//                     url: '/v1/user/unlik'                  
//                 });
        		alert(response +' logout');
    		    window.location.href='./main'
    	    });
    };
    
    </script>


<style>
li{
	list-style:none;
}

</style>

</head>
<body>
<h1>로그인</h1>
<hr>

<form action="/homett/login" method="post" id="loginform">

	<div>
		<label for="userid">아이디</label>
		<input type="text" id="userid"name="userid" placeholder="아이디">
	</div>

	<div>
		<label for="userpw">비밀번호</label>
		<input type="text" id="userpw"name="userpw">
	</div>

	<div>
		<button type="button" id="btnLogin">로그인</button>
	</div>

</form>

	<button class="btn" id="btnJoin" onclick="location.href='/homett/join'">회원가입</button>
	<a href="/homett/searchid" class="btn" id="btnJoin">아이디 찾기</a> I
	<a href="/homett/searchpw" class="btn" id="btnJoin">비밀번호 찾기</a><br>
	<button class="btn" id="btnJoin" onclick="location.href='/homett/main'">메인페이지</button><br><br>
<a href="javascript:kakaoLogin();"><img src="//k.kakaocdn.net/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg" alt="카카오계정 로그인" width="20%" height="20%"/></a>
<a href="javascript:kakaoLogout();">로그아웃</a>
<a href="https://kauth.kakao.com/oauth/logout?client_id=df076bd4ac86c0d0c941fdedd98976ba&logout_redirect_uri=http://localhost:8888/homett/main">로그아웃11</a>

    
    
</body>
</html>



