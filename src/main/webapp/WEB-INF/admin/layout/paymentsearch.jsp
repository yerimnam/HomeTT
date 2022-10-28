<%@page import="admin.report.dao.face.AdReportListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="/homett/adpaymentlist" method="POST">
<div class="box-footer" style="width: 570px;">
    <div class="form-group col-sm-3">
        <select class="form-control" name="searchType" id="searchType" style="width: 135px;">
<!--             <option value="null" >검색 필터</option> -->
            <option value="order_no" >주문번호</option>
            <option value="user_no" >회원번호</option>
        </select>
    </div>
    <div class="form-group col-sm-9">
        <div class="input-group">
            <input type="text" class="form-control" name="keyword" id="keywordInput" placeholder="검색어">
            <span class="input-group-btn">
                <button type="submit" class="btn btn-primary btn-flat" id="searchBtn">
                    <i class="fa fa-search"></i> 검색
                </button>
            </span>
        </div>
    </div>
</div>
</form>