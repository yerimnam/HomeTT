package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dto.MailOk;
import user.dto.Member;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;



@WebServlet("/homett/emailok")
public class EmailOkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/emailok [GET]");
		
		req.getRequestDispatcher("/WEB-INF/member/searchIdOk.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		
		MailOk result = userService.MailOkChk(req);
		
		System.out.println("result : " + result);
		
		result.getResultChk();  //getResultChk 안에 값이 담겨있다면 인증이 됬다는거
		
		
//		MailOk ranNum = new MailOk();
//		HttpSession session = req.getSession();
//		
//		ranNum.setInputOk( req.getParameter("mailOk") );
//		
//		//인증번호 작성한거 확인 잘나오는지 확인
//		System.out.println("InputOk : " + ranNum.getInputOk());
//		System.out.println("RanNum : " + session.getAttribute("rannum") );
//		
//		// 아이디 찾기 service
//		
//		if( !(session.getAttribute("rannum") == ranNum.getInputOk()) ) {
////			req.getRequestDispatcher("/WEB-INF/member/searchIdOk.jsp").forward(req, resp);
//			
//			resp.sendRedirect("/searchIdOk.jsp");
//		} else {
//			System.out.println("둘이 같을때");
//		}
		
	
	
	}
	

}
