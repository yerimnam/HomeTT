<%@page import="inquiry.dto.InquiryBoard"%>
<%@page import="java.util.List"%>
<%@page import="util.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 모델값 전달받기 --%>
<% Paging paging = (Paging) request.getAttribute("paging"); %>

<div class="text-center">
   <ul class="pagination">
   
      <%-- 첫 페이지로 이동 --%>
      <%   if( paging.getCurPage() != 1) { %>
      <li><a href="./inquirylist">&larr;처음</a></li>
      <%  } %>
      
   
      <%-- 이전 페이지로 이동 --%>
      <%   if( paging.getCurPage() != 1) { %>
      <li><a href="./inquirylist?curPage=<%=paging.getCurPage() - 1 %>">&lt;</a></li>
      <%   } %>
   
   
      <%   for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
      <%      if( i == paging.getCurPage() ) { %>
      <li class="active"><a href="./inquirylist?curPage=<%=i %>"><%=i %></a></li>
      <%      } else { %>
      <li><a href="./inquirylist?curPage=<%=i %>"><%=i %></a></li>
      <%      } %>
      <%   } %>
      
      <%-- 다음 페이지로 이동 --%>
      <%   if( paging.getCurPage() != paging.getTotalPage() ) { %>
      <li><a href="./inquirylist?curPage=<%=paging.getCurPage() + 1 %>">&gt;</a></li>
      <%   } %>
      
      <%-- 마지막 페이지로 이동 --%>
      <%   if( paging.getCurPage() != paging.getTotalPage() ) { %>
      <li><a href="./inquirylist?curPage=<%=paging.getTotalPage() %>">&rarr;끝</a></li>
      <%   } %>
      
   </ul>
</div>