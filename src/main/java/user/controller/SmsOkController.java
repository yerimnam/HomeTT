package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dto.MailSmsOk;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;

@WebServlet("/homett/smsok")
public class SmsOkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/smsok [GET]");
		
		resp.sendRedirect("./updatepw");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/smsok [POST]");
		
		req.setCharacterEncoding("UTF-8");
		
		MailSmsOk result = userService.SmsOkChk(req);
		
		System.out.println("result : " + result);
		
		result.getResultChk();  //getResultChk 안에 값이 담겨있다면 인증이 됬다는거
	
	}
	
	
}
