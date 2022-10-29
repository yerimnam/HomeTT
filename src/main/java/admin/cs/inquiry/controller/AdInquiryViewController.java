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

@WebServlet("/homett/adinquiryview")
public class AdInquiryViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminLoginService adminLoginService = new AdminLoginServiceImpl();
	private AdInquiryListService adInquiryListService = new AdInquiryListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/homett/adinquiryview [GET]");
//		System.out.println("AdInquiryViewController doGet() - inquiryno : " + req.getParameter("inquiryArticleNumber"));
		
		//한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		Admin admin = new Admin();
		admin.setAdminId((String) session.getAttribute("adminId"));
		admin.setAdminPw((String) session.getAttribute("adminPw"));
		
		boolean loginSt = adminLoginService.login(admin);
		
		if ( loginSt ) {
		
			//전달파라미터 객체 얻어오기
			Inquiry inquiryno = adInquiryListService.getInquiryno(req);
//			System.out.println("AdInquiryViewController doGet() - inquiryno객체 : " + inquiryno);
			
			//게시글 상세보기 조회 결과 얻어오기
			Inquiry viewinquiry = adInquiryListService.view( inquiryno );
//			System.out.println("AdInquiryViewController doGet() - viewinquiry : " + viewinquiry);
		
			req.setAttribute("viewinquiry", viewinquiry);
			
			req.getRequestDispatcher("/WEB-INF/admin/cs/inquiry/admininquiryview.jsp").forward(req, resp);
		
		} else {
			resp.sendRedirect("./adminlogin");
	}
		
	}
	
}

























