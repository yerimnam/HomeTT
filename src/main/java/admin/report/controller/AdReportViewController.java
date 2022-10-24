package admin.report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.report.dto.Report;
import admin.report.service.face.AdReportListService;
import admin.report.service.impl.AdReportListServiceImpl;

@WebServlet("/homett/adreportview")
public class AdReportViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdReportListService adReportListService = new AdReportListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/adreportview [GET]");
		
		System.out.println("AdReportViewController doGet() - reportno : " + req.getParameter("reportno"));
		
		//전달파라미터 객체 얻어오기
		Report reportno = adReportListService.getReportno(req);
		System.out.println("AdReportViewController doGet() - reportno객체 : " + reportno);
		
		//게시글 상세보기 조회 결과 얻어오기
		Report viewreport = adReportListService.view( reportno );
		System.out.println("AdReportViewController doGet() - viewReport : " + viewreport);
	
		//조회결과를 MODEL값으로 전달
		req.setAttribute("viewreport", viewreport);
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/admin/report/adminreportview.jsp").forward(req, resp);
	
	}
	
}
