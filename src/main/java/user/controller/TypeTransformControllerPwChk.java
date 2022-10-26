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


@WebServlet("/homett/typepwchk")
public class TypeTransformControllerPwChk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
		private UserService userService = new UserServiceImpl();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("/homett/ttpwchk [GET]");
			
			req.getRequestDispatcher("/WEB-INF/member/typeTransformPwChk.jsp").forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			Member member = new Member();
			HttpSession session = req.getSession();
			//이름, 이메일 파라미터 값 받기
			
			System.out.println( req.getParameter("userPw") );
			member.setUserPw( req.getParameter("userPw") );
			
			member.setUserId( (String) session.getAttribute("userId") );
			System.out.println("member" + member );
			
			Member result = userService.getTTUserPw(member);
			
			System.out.println(result.getUserId());
			
		}
}
