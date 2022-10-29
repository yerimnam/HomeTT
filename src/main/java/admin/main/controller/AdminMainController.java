package admin.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.cs.inquiry.dto.Inquiry;
import admin.cs.inquiry.service.face.AdInquiryListService;
import admin.cs.inquiry.service.impl.AdInquiryListServiceImpl;
import admin.login.dto.Admin;
import admin.login.service.face.AdminLoginService;
import admin.login.service.impl.AdminLoginServiceImpl;
import admin.report.dto.Report;
import admin.report.service.face.AdReportListService;
import admin.report.service.impl.AdReportListServiceImpl;
import admin.statistics.service.face.MonthlyStatisticsService;
import admin.statistics.service.impl.MonthlyStatisticsServiceImpl;
import util.Paging;

@WebServlet("/homett/adminmain")
public class AdminMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminLoginService adminLoginService = new AdminLoginServiceImpl();
	private MonthlyStatisticsService monthlyStatisticsService = new MonthlyStatisticsServiceImpl();
	private AdInquiryListService adInquiryListService = new AdInquiryListServiceImpl();
	private AdReportListService adReportListService = new AdReportListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Admin admin = new Admin();
		admin.setAdminId((String) session.getAttribute("adminId"));
		admin.setAdminPw((String) session.getAttribute("adminPw"));
		
		boolean loginSt = adminLoginService.login(admin);
		
		if ( loginSt ) {
		
			//월 통계
			//1. 열린 파티
			int partycre = monthlyStatisticsService.getCntDPartyCre();
			req.setAttribute("partycre", partycre);
			
			//2. 닫힌 파티
			int partyend = monthlyStatisticsService.getCntDPartyEnd();
			req.setAttribute("partyend", partyend);
			
			//3. OTT별 파티 현황
			int netflix = monthlyStatisticsService.getCntNetflix();
			int disney = monthlyStatisticsService.getCntDisney();
			int tving = monthlyStatisticsService.getCntTving();
			int apple = monthlyStatisticsService.getCntApple();
			int wave = monthlyStatisticsService.getCntWave();
			int watcha = monthlyStatisticsService.getCntWatcha();
			int laftel = monthlyStatisticsService.getCntLaftel();
			
			req.setAttribute("netflix", netflix);
			req.setAttribute("disney", disney);
			req.setAttribute("tving", tving);
			req.setAttribute("apple", apple);
			req.setAttribute("wave", wave);
			req.setAttribute("watcha", watcha);
			req.setAttribute("laftel", laftel);
			
			//---------------------------------------------------------------
			
			//문의사항
			Paging inquirypaging = adInquiryListService.getPaging(req);
			List<Inquiry> inquiryList = adInquiryListService.getList(inquirypaging);
			req.setAttribute("inquiryList", inquiryList);
//			System.out.println(inquiryList);
			
			//---------------------------------------------------------------
			
			//신고목록
			Paging reportpaging = adReportListService.getPaging(req);
			List<Report> reportList = adReportListService.getList(reportpaging);
			req.setAttribute("reportList", reportList);
//			System.out.println(reportList);
			
			//---------------------------------------------------------------
			
			req.getRequestDispatcher("/WEB-INF/admin/main/adminmain.jsp").forward(req, resp);
		
		} else {
			resp.sendRedirect("./adminlogin");
		}
		
	}
	
}
