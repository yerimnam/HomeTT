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

@WebServlet("/homett/adinquirydelete")
public class AdInquiryDeleteController extends HttpServlet {
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
			
			Inquiry inquiry = adInquiryListService.getInquiryno(req);
			
			adInquiryListService.delete(inquiry);
			
			resp.sendRedirect("/homett/adinquirylist");
		
	} else {
		resp.sendRedirect("./adminlogin");
	}
		
	}
		
}
