package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dto.MailSmsOk;
import user.dto.Member;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;

@WebServlet("/homett/searchpw")
public class SearchPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/searchid [GET]");

		req.getRequestDispatcher("/WEB-INF/member/searchPw.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/searchpw [POST]");
		
		Member member = new Member();
		MailSmsOk rannum = new MailSmsOk();
		
		//이름, 이메일 파라미터 값 받기
		member.setUserId( req.getParameter("id") );
		member.setUserName( req.getParameter("namepw") );
		member.setUserPhone( Integer.parseInt(req.getParameter("phone")) );
	
		System.out.println( "member : " + member);
		
		// 회원 정보 찾기
		Member result = userService.searchPw(member);
		
		System.out.println("핸드폰 번호 : " + result.getUserPhone() );
		
		System.out.println("result :" + result);
		
		HttpSession session = req.getSession();
		session.setAttribute("userid", result.getUserId() );
		session.setAttribute("username", result.getUserName() );
		session.setAttribute("userphone", result.getUserPhone() );
		
		rannum = userService.sendSmsRandomNum(req);

		//RanNum 에 ranNum 값이 잘 들어온지 확인
		System.out.println("dto rannum값 " + rannum);
				
		session.setAttribute("rannum", rannum.getRanNum() );
		
		
	}

}









