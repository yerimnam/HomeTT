<%@page import="admin.report.dao.face.AdReportListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="/homett/adreportlist" method="GET">
<div class="box-footer" style="width: 500px;">
    <div class="form-group col-sm-3">
        <select class="form-control" name="searchType" id="searchType" style="width: 120px;">
            <option value="n" >검색 필터</option>
            <option value="report_content" >내용</option>
            <option value="reporter" >작성자(닉네임)</option>
        </select>
    </div>
    <div class="form-group col-sm-9">
        <div class="input-group">
            <input type="text" class="form-control" name="keyword" id="keywordInput" value="k" placeholder="검색어">
            <span class="input-group-btn">
                <button type="submit" class="btn btn-primary btn-flat" id="searchBtn">
                    <i class="fa fa-search"></i> 검색
                </button>
            </span>
        </div>
    </div>
</div>
</form>