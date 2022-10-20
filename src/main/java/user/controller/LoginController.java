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

@WebServlet("/homett/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/login [GET]");

		req.getRequestDispatcher("/WEB-INF/member/login.jsp").forward(req, resp);

	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/login [POST]");

		//요청 데이터의 한글 인코딩 방식 지정하기 : UTF-8
		req.setCharacterEncoding("UTF-8");

		//회원가입 전달파라미터 가져오기
		Member member = userService.getLoginParam(req);

		//잘들어오는지 확인
		System.out.println("MemberController doPost() - member : " + member);

		//로그인 인증
		boolean loginTF = userService.login(member);

		//로그인 인증 성공
		if( loginTF ) {

			//로그인 사용자 정보 조회
			member = userService.loginInfo(member);

			//세션정보 객체
			HttpSession session = req.getSession();

			session.setAttribute("login", loginTF);
			session.setAttribute("masterNo", member.getMasterNo());
			session.setAttribute("userId", member.getUserId());
			session.setAttribute("userNick", member.getUserNick());

		}

		resp.sendRedirect("./main");
	}

}
















