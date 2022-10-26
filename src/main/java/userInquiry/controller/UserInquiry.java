 package userInquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userInquiry.service.face.UserInquiryService;
import userInquiry.service.impl.UserInquiryServiceImpl;

@WebServlet("/homett/userinquiry")
public class UserInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스 객체
	private UserInquiryService userInpuiryService = new UserInquiryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/userinquiry [GET]");
		
		req.getRequestDispatcher("/WEB_INF/mapage/userinquiry.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 신고글 삽입
		userInpuiryService.write(req);
		
		// 목록으로 리다이렉트
		resp.sendRedirect("/mypage/userinquiry");
		
		
		
	}
	
}
