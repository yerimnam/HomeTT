package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dto.Member;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;


@WebServlet("/homett/updatepw")
public class UpdatePwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/updatepw [GET]");
		
		req.getRequestDispatcher("/WEB-INF/member/searchPwOk.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/updatepw [POST]");
		
		Member member = new Member();
		HttpSession session = req.getSession();
		
		member.setUserPw( req.getParameter("newPw") );
		member.setUserId((String)session.getAttribute("userid"));
		member.setUserName((String)session.getAttribute("username"));
		
		System.out.println("member : " + member);
		userService.UpdatePw(member);
		
		req.setAttribute("member", member);

		req.getRequestDispatcher("/WEB-INF/member/updatePwOk.jsp").forward(req, resp);
		
	}
	
	
	
	
}
