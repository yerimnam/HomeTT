package report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import report.service.face.MemberReportService;
import report.service.impl.MemberReportServiceImpl;

@WebServlet("/homett/mbrreport")
public class MemberReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private MemberReportService memberReportService = new MemberReportServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/homett/mbrreport GET()");
		
		req.getRequestDispatcher("/WEB-INF/party/memberReport.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/mbrreport POST()");
		
		//작성글 삽입
		memberReportService.write(req);
		
		
		//파티게시판으로 리다이렉트 하기
		resp.sendRedirect("/homett/partyroom");
		
		
	}
}
