package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import user.dto.Member;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;


@WebServlet("/homett/searchidpw")
public class SearchIdPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/searchid [GET]");

		req.getRequestDispatcher("/WEB-INF/member/searchIdPw.jsp").forward(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Member member = new Member();
		
		//이름, 이메일 파라미터 값 받기
		member.setUserName( req.getParameter("name") );
		member.setUserEmail( req.getParameter("email") );
	
		System.out.println(req.getParameter("name") + req.getParameter("email")  );
		System.out.println( member);
		
		
		Member result = userService.searchId(member);
		
		System.out.println( result );
		
		req.setAttribute("result", result);
		
		
		if( result.getUserId() == null ){
			System.out.println("잘못입력하셨습니다");
			
		} else {
			
			System.out.println("아이디값 : " + result.getUserId() );
		}
		
		
		
//		req.getRequestDispatcher("/WEB-INF/member/searchIdOk.jsp").forward(req, resp);
	}
	
}









