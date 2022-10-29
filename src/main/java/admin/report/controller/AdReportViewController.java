package admin.report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.login.dto.Admin;
import admin.login.service.face.AdminLoginService;
import admin.login.service.impl.AdminLoginServiceImpl;
import admin.report.dto.Report;
import admin.report.service.face.AdReportListService;
import admin.report.service.impl.AdReportListServiceImpl;

@WebServlet("/homett/adreportview")
public class AdReportViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminLoginService adminLoginService = new AdminLoginServiceImpl();
	private AdReportListService adReportListService = new AdReportListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/homett/adreportview [GET]");
//		System.out.println("AdReportViewController doGet() - reportno : " + req.getParameter("reportno"));
		
		HttpSession session = req.getSession();
		
		Admin admin = new Admin();
		admin.setAdminId((String) session.getAttribute("adminId"));
		admin.setAdminPw((String) session.getAttribute("adminPw"));
		
		boolean loginSt = adminLoginService.login(admin);
		
		if ( loginSt ) {
		
			//전달파라미터 객체 얻어오기
			Report reportno = adReportListService.getReportno(req);
//			System.out.println("AdReportViewController doGet() - reportno객체 : " + reportno);
			
			//게시글 상세보기 조회 결과 얻어오기
			Report viewreport = adReportListService.view( reportno );
//			System.out.println("AdReportViewController doGet() - viewReport : " + viewreport);
		
			req.setAttribute("viewreport", viewreport);
			req.getRequestDispatcher("/WEB-INF/admin/report/adminreportview.jsp").forward(req, resp);
	
		} else {
			resp.sendRedirect("./adminlogin");
		}
		
	}
	
}
