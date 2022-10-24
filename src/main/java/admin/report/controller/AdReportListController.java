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
		
		Paging paging = adReportListService.getPaging(req);
		System.out.println("[TEST] " + paging);
		
		//페이징 객체를 MDOEL값 전달
		req.setAttribute("paging", paging);
		
		String searchType_ = req.getParameter("searchType");
		String keyword_ = req.getParameter("keyword");
		
		String searchType = "";
		if( searchType_ != null )
			searchType = searchType_;
		
		String keyword = "";
		if(keyword_ != null)
			keyword = keyword_;
		
		//게시글 페이징 목록 조회
		List<Report> reportList = adReportListService.getList( paging );	//전체 목록
		List<Report> reportSearchList = adReportListService.getSearchList( searchType, keyword );	//검색 목록
		
		//[TEST] 조회결과 확인
//		for(Report r : reportList)	System.out.println(r);
		
		//조회결과를 MODEL값 전달
		req.setAttribute("reportList", reportList);
		req.setAttribute("reportSearchList", reportSearchList);
		System.out.println("reportSearchList" + reportSearchList);
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/admin/report/adminreportlist.jsp").forward(req, resp);
//		req.getRequestDispatcher("/WEB-INF/admin/report/adminreportsearchlist.jsp").forward(req, resp);
	}
	
}
