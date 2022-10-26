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


@WebServlet("/homett/dropuser")
public class DropUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/login [GET]");

		
		req.getRequestDispatcher("/WEB-INF/member/dropUser.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/login [POST]");
		
		Member member = new Member();
		HttpSession session = req.getSession();
		//이름, 이메일 파라미터 값 받기
		
		member.setUserPw( req.getParameter("userPw") );
	
		member.setUserId( (String) session.getAttribute("userId") );
		System.out.println(member.getUserId());
		
		Member result = userService.getUserPw(member);
		
		System.out.println( result.getUserId() );
		
		
	}
	
}
