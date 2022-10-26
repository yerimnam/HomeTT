<%@page import="util.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 모델값 전달받기 --%>
<%	Paging paging = (Paging) request.getAttribute("paging"); %>

<%---------------------------------------------------------------------------%>
<%	String searchType = request.getParameter("searchType");
	String keyword = request.getParameter("keyword");
%>
<%---------------------------------------------------------------------------%>

<div class="text-center">
	<ul class="pagination">
		
		<% if ( keyword != null && !"".equals(keyword) ) { %>	<%--검색 했을 때 paging 결과 --%>
			
			<%-- 첫 페이지로 이동 --%>
			<%	if( paging.getCurPage() != 1) { %>
				<li><a href="./adinquirylist?curPage=<%=paging.getStartPage()%>
				&searchType=<%=searchType %>&keyword=<%=keyword %>">&lt;&lt;</a></li>
			<%	} %>
		
		
			<%-- 이전 페이지로 이동 --%>
			<%	if( paging.getCurPage() != 1) { %>
				<li><a href="./adinquirylist?curPage=<%=paging.getCurPage() - 1 %>
					&searchType=<%=searchType %>&keyword=<%=keyword %>">&lt;</a></li>
			<%	} %>
			
		
			<%-- 페이지 번호 리스트 --%>
			<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
			<%		if( i == paging.getCurPage() ) { %>
				<li class="active"><a href="./adinquirylist?curPage=<%=i %>
					&searchType=<%=searchType %>&keyword=<%=keyword %>"><%=i %></a></li>
			<%		} else { %>
				<li><a href="./adinquirylist?curPage=<%=i %>
					&searchType=<%=searchType %>&keyword=<%=keyword %>"><%=i %></a></li>
			<%		} %>
			<%	} %>
	
	
			<%-- 다음 페이지로 이동 --%>
			<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
				<li><a href="./adinquirylist?curPage=<%=paging.getCurPage() + 1 %>
					&searchType=<%=searchType %>&keyword=<%=keyword %>">&gt;</a></li>
			<%	} %>
			
			
			<%-- 마지막 페이지로 이동 --%>
			<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
				<li><a href="./adinquirylist?curPage=<%=paging.getTotalPage() %>
					&searchType=<%=searchType %>&keyword=<%=keyword %>">&gt;&gt;</a></li>
			<%	} %>
			
		<%	} else { %>	<%--검색하지 않았을 때 paging 결과 --%>
		
			
			<%-- 첫 페이지로 이동 --%>
			<%	if( paging.getCurPage() != 1) { %>
				<li><a href="./adinquirylist?curPage=<%=paging.getStartPage()%>">&lt;&lt;</a></li>
			<%	} %>
		
		
			<%-- 이전 페이지로 이동 --%>
			<%	if( paging.getCurPage() != 1) { %>
				<li><a href="./adinquirylist?curPage=<%=paging.getCurPage() - 1 %>">&lt;</a></li>
			<%	} %>
			
		
			<%-- 페이지 번호 리스트 --%>
			<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
			<%		if( i == paging.getCurPage() ) { %>
				<li class="active"><a href="./adinquirylist?curPage=<%=i %>"><%=i %></a></li>
			<%		} else { %>
				<li><a href="./adinquirylist?curPage=<%=i %>"><%=i %></a></li>
			<%		} %>
			<%	} %>
	
	
			<%-- 다음 페이지로 이동 --%>
			<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
				<li><a href="./adinquirylist?curPage=<%=paging.getCurPage() + 1 %>">&gt;</a></li>
			<%	} %>
			
			
			<%-- 마지막 페이지로 이동 --%>
			<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
				<li><a href="./adinquirylist?curPage=<%=paging.getTotalPage() %>">&gt;&gt;</a></li>
			<%	} %>
		<%	} %>
	</ul>
</div>







