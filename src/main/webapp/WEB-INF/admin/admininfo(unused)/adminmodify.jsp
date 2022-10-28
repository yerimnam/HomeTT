<%@page import="admin.admindetails.dto.Admin"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

<%	List<Admin> admininfo = (List) request.getAttribute("admininfo"); %>

<container class="container">
	<div style="display: flex; justify-content: right; width: 1350px;">
		<h3 class="h3">관리자 계정</h3>
	</div>
	
	<div>
		<h4 class="h4">관리자 계정 정보 및 수정</h4>
	</div>
	
	<div class="text-center">
		<form action="/homett/admindetails" method="post">
		
		<div>프로필
<!-- 		<input type="text" maxlength="20" name="AdminID" style="width: 200px"  -->
<%-- 			value="<%=admininfo.get(6).getAdminProfile() %>" > --%>
		</div>
		
		<table>
		<%	for(int i=0; i<admininfo.size(); i++) { %>
			<tr>
				<td class="text-center" style="width: 100px; height: 50px;">아이디</td>
				<td><input type="text" maxlength="20" name="AdminID" style="width: 200px" 
					value="<%=admininfo.get(i).getAdminId() %>" readonly></td>
			</tr>
			<tr>
				<td class="text-center" style="width: 100px; height: 50px;" >이름</td>
				<td><input type="text" maxlength="20" name="AdminName" style="width: 200px" 
					value="<%=admininfo.get(i).getAdminName() %>" ></td>
			</tr>
			<tr>
				<td class="text-center" style="width: 100px; height: 50px;" >이메일</td>
				<td><input type="text" maxlength="20" name="AdminEmail" style="width: 200px" 
					value="<%=admininfo.get(i).getAdminEmail() %>" ></td>
			</tr>
			<tr>
				<td class="text-center" style="width: 100px; height: 50px;" >전화번호</td>
				<td><input type="text" maxlength="20" name="AdminPhone" style="width: 200px" 
					value="<%=admininfo.get(i).getAdminPhone() %>" ></td>
			</tr>
			<tr>
				<td class="text-center" style="width: 100px; height: 50px;" >소속팀</td>
				<td><input type="text" maxlength="20" name="AdminTeam" style="width: 200px" 
					value="<%=admininfo.get(i).getAdminTeam() %>" ></td>
			</tr>
			<tr>
				<td class="text-center" style="width: 100px; height: 50px;" >직급</td>
				<td><input type="text" maxlength="20" name="AdminPosition" style="width: 200px" 
					value="<%=admininfo.get(i).getAdminPosition() %>" ></td>
			</tr>
			
		<%	} %>
		
		</table>
		
		<div class="text-center">
			<button type="submit" class="btn btn-success">계정 정보 수정 완료</button>
		</div>
		
		</form>
	</div>
	
</container>

</body>
</html>