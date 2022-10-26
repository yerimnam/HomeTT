package admin.report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.report.dto.Report;
import admin.report.service.face.AdReportListService;
import admin.report.service.impl.AdReportListServiceImpl;
import util.Paging;

@WebServlet("/homett/adreportlist")
public class AdReportListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdReportListService adReportListService = new AdReportListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/adreportlist [GET]");
		
		//한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");
		
		Paging paging;
		if ( searchType != null && keyword != null ) {
			paging = adReportListService.getSearchPaging(req, searchType, keyword);
		} else {
			paging = adReportListService.getPaging(req);
		}
		
		req.setAttribute("paging", paging);
		
		List<Report> reportList;
		if(searchType != null && keyword != null) {
			// 검색한 결과
			reportList = adReportListService.getSearchList( paging, searchType, keyword );
			System.out.println("검색한 paging 결과 : " + paging);
		} else {
			// 검색 안한 결과
			reportList = adReportListService.getList( paging );
			System.out.println("검색 안한 paging 결과 : " + paging);
		}
		
		req.setAttribute("reportList", reportList);
		req.getRequestDispatcher("/WEB-INF/admin/report/adminreportlist.jsp").forward(req, resp);
		
	}
		
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
