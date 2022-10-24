package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dto.Member;
import user.dto.MailOk;
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
		MailOk rannum = new MailOk();
		
		//이름, 이메일 파라미터 값 받기
		member.setUserName( req.getParameter("name") );
		member.setUserEmail( req.getParameter("email") );
	
		// 이름 이메일이 잘 넘어 오는지 확인
		System.out.println(req.getParameter("name") + req.getParameter("email")  );
		System.out.println( "member : " + member);
		
		// 아이디 찾기 service
		Member result = userService.searchId(member);
		
		System.out.println( "result : " + result );
		
		member.setUserId( result.getUserId() );
		
		HttpSession session = req.getSession();
		System.out.println("아이디값 : " + result.getUserId() ); //아이디값 확인
			
		session.setAttribute("userId", result.getUserId() );
		
		System.out.println("session" + session.getAttribute("userId") );
		
		rannum = userService.sendMailRandomNum(req);
			
		//RanNum 에 ranNum 값이 잘 들어온지 확인
		System.out.println("dto rannum값 " + rannum);
		
		

		session.setAttribute("rannum", rannum.getRanNum() );
		
//		req.setAttribute("ranNum", userService.sendMailRandomNum(req));

		
		
		
		
//		req.getRequestDispatcher("/WEB-INF/member/searchIdOk.jsp").forward(req, resp);
	}
	
}









