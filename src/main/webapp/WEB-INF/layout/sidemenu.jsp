<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">

@import url('https://webfontworld.github.io/sunn/SUIT.css');


#sidemenu{

    width: 240px;
    position: absolute;
    left: 160px;
    height: 1000px;
    top:170px;
    color:#666666;
    
}


#myinfo,#party,#pay,#wishlist,#inquiry{
	border-bottom: 1px solid #dddddd;
	padding-bottom: 10px;
}

.area{

    margin: 10px 0 0;
    font-size: 16px;
}
.area li a:hover{
	color:#ff8c11;
	font-weight: 600;
}


.manage{
	 margin: 18px 0 0;
	 font-size: 20px;
	 font-weight: 800;
	 color: #222222;
	 
}

.area li a {
	font-weight: 400;
}

.area li{
    margin: 0 0 4px;

}



a{
	color:#666666;
}
a:hover{
	text-decoration: none;
}
a:visited{
	color:#666666;
}
</style>






</head>
<body>


	<div id="sidemenu">
	
	<div id="myinfo">
			<ul>
				<li class="myinfo manage">회원정보
					<ul class="area">
						<li><a href="/homett/editprofile">회원 정보 수정</a> </li>
						<li><a href="/homett/dropuser">회원 탈퇴</a> </li>
						
					</ul>
				</li>
			</ul>
		
		</div>
	
	
	
		<div id="party">
			<ul>
				<li class="party manage">PARTY
					<ul class="area">
						<li><a href="/homett/type">파티장으로 권한 변경 </a> </li>
						<li><a href="/homett/partycheck">파티 조회</a> </li>
						
					</ul>
				</li>
			</ul>
		
		</div>
	
		<div id="pay">
			<ul>
				<li class="pay manage">결제관리
					<ul class="area">
						<li><a href="/homett/paymentlist">결제 내역</a> </li>
					</ul>
				</li>
			</ul>
		
		</div>
		
		
	<div id="wishlist">
		<ul>
			<li class="wishlist manage">찜하기관리
			
				<ul class="area">
					<li><a href="/homett/wishcheck">찜 목록 조회 </a></li>
				
				</ul>
			
			</li>
				
		</ul>
		
	</div>		
	
	<div id="inquiry">
	
		<ul>
			<li class="inquiry manage"> 1:1 문의
			
			
				<ul class="area">
				
					<li id="inquirylist"><a href="/homett/inquirylist">1:1 문의 내역</a></li>
					<li id="askinquiry"><a href="/homett/inquirycreate">1:1 문의하기</a></li>
				</ul>
			
			</li>
		
		</ul>	
	
	
	</div>

	
</div>
	



</body>
</html>