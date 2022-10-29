package admin.cs.inquiry.controller;

import java.io.IOException;

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

@WebServlet("/homett/adinquirywrite")
public class AdInquiryWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminLoginService adminLoginService = new AdminLoginServiceImpl();
	private AdInquiryListService adInquiryListService = new AdInquiryListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Admin admin = new Admin();
		admin.setAdminId((String) session.getAttribute("adminId"));
		admin.setAdminPw((String) session.getAttribute("adminPw"));
		
		boolean loginSt = adminLoginService.login(admin);
		
		if ( loginSt ) {
		
			Inquiry inquiryno = adInquiryListService.getInquiryno(req);
			Inquiry viewinquiry = adInquiryListService.view( inquiryno );
			req.setAttribute("viewinquiry", viewinquiry);
			
			req.getRequestDispatcher("/WEB-INF/admin/cs/inquiry/admininquirywrite.jsp").forward(req, resp);
		
		} else {
			resp.sendRedirect("./adminlogin");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		Admin admin = new Admin();
		admin.setAdminId((String) session.getAttribute("adminId"));
		admin.setAdminPw((String) session.getAttribute("adminPw"));
		
		boolean loginSt = adminLoginService.login(admin);
		
		if ( loginSt ) {
			
			//답변글 삽입
			adInquiryListService.writeAnswer(req);
			
			//목록으로 리다이렉트
			resp.sendRedirect("/homett/adinquirylist");
		
		} else {
			resp.sendRedirect("./adminlogin");
		}
		
	}
	
}
