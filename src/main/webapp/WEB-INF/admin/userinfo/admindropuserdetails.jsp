<%@page import="admin.userdetails.dto.Dmember"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<%	List<Dmember> dropuserinfo = (List) request.getAttribute("dropuserinfoList"); %>

<div style="margin-left:480px;">
	<h1 style="margin: 30px 0;">탈퇴 회원 정보 조회 페이지</h1>
</div>

<hr style="width: 1000px; margin: 30px auto; border:0; height:2px; background: #ccc;">

<div class="text-center">
	<h2>탈퇴 회원 정보 검색</h2>
</div>
<form action="/homett/addropuserdetails" method="POST">
<div style="width: 410px; margin: 20px auto;">
    <div class="form-group col-sm-3">
        <select class="form-control" name="searchType" id="searchType" style="width: 100px;">
            <option value="user_id" >아이디</option>
            <option value="user_nick" >닉네임</option>
        </select>
    </div>
    <div class="form-group col-sm-9">
        <div class="input-group">
            <input type="text" class="form-control" name="keyword" id="keywordInput">
            <span class="input-group-btn">
                <button type="submit" class="btn btn-primary btn-flat" id="searchBtn">
                    <i class="fa fa-search"></i> 검색
                </button>
            </span>
        </div>
    </div>
</div>
</form>

<hr style="width: 1000px; margin: 30px auto;">
	
<%	if( dropuserinfo != null ) { %>
<div>
	<table class="text-center table table-bordered" style="margin: 30px auto; width: 500px; font-size: 20px;">
	<%	for(int i=0; i<dropuserinfo.size(); i++) { %>
		<tr>
			<th class="text-center" style="width: 100px; height: 50px; border-right: 0; color:red;">탈퇴 회원번호</th>
			<td style="width: 200px; border-left: 0; color:red;"><%=dropuserinfo.get(i).getSecedeNo() %></td>
		</tr>
		<tr>
			<th class="text-center" style="width: 100px; height: 50px; border-right: 0; color:red;">탈퇴일</th>
			<td style="width: 200px; border-left: 0; color:red;"><%=dropuserinfo.get(i).getSecedeDate() %></td>
		</tr>
		<tr>
			<th class="text-center" style="width: 100px; height: 50px; border-right: 0;">회원번호</th>
			<td style="width: 200px; border-left: 0;"><%=dropuserinfo.get(i).getUserNo() %></td>
		</tr>
		<tr>
			<th class="text-center" style="width: 100px; height: 50px; border-right: 0;" >이름</th>
			<td style="width: 200px; border-left: 0;"><%=dropuserinfo.get(i).getUserName() %></td>
		</tr>
		<tr>
			<th class="text-center" style="width: 100px; height: 50px; border-right: 0;" >아이디</th>
			<td style="width: 200px; border-left: 0;"><%=dropuserinfo.get(i).getUserId() %></td>
		</tr>
		<tr>
			<th class="text-center" style="width: 100px; height: 50px; border-right: 0;" >닉네임</th>
			<td style="width: 200px; border-left: 0;"><%=dropuserinfo.get(i).getUserNick() %></td>
		</tr>
		<tr>
			<th class="text-center" style="width: 100px; height: 50px; border-right: 0;" >회원권한</th>
			<td style="width: 200px; border-left: 0;"><%=dropuserinfo.get(i).getMasterNo() %></td>
		</tr>
		<tr>
			<th class="text-center" style="width: 100px; height: 50px; border-right: 0;" >이메일</th>
			<td style="width: 200px; border-left: 0;"><%=dropuserinfo.get(i).getUserEmail() %></td>
		</tr>
		<tr>
			<th class="text-center" style="width: 100px; height: 50px; border-right: 0;" >휴대폰번호</th>
			<td style="width: 200px; border-left: 0;;">0<%=dropuserinfo.get(i).getUserPhone() %></td>
		</tr>
		<tr>
			<th class="text-center" style="width: 100px; height: 50px; border-right: 0;" >가입일</th>
			<td style="width: 200px; border-left: 0;"><%=dropuserinfo.get(i).getUserJoin() %></td>
		</tr>
		<tr>
			<th class="text-center" style="width: 100px; height: 50px; border-right: 0;" >결제수단</th>
			<td style="width: 200px; border-left: 0;"><%=dropuserinfo.get(i).getPaymentMethod() %></td>
		</tr>
		<tr>
			<th class="text-center" style="width: 100px; height: 50px; border-right: 0;" >파티번호</th>
			<td style="width: 200px; border-left: 0;"><%=dropuserinfo.get(i).getPartyNo() %></td>
		</tr>
	<%	} %>
	</table>
</div>
<%	} %>

</body>

<!-- 부트스트랩3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');
body{
	font-family: 'SUIT';
}
</style>

</html>