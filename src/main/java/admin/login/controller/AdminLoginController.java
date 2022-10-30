package admin.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.login.dto.Admin;
import admin.login.service.face.AdminLoginService;
import admin.login.service.impl.AdminLoginServiceImpl;

@WebServlet("/homett/adminlogin")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private AdminLoginService adminLoginService = new AdminLoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/homett/adminlogin [GET]");

		req.getRequestDispatcher("/WEB-INF/admin/login/adminlogin.jsp").forward(req, resp);

	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/homett/login [POST]");

		//요청 데이터의 한글 인코딩 방식 지정하기 : UTF-8
		req.setCharacterEncoding("UTF-8");

		//회원가입 전달파라미터 가져오기
		Admin admin = adminLoginService.getLoginParam(req);

		//잘들어오는지 확인
//		System.out.println("MemberController doPost() - admin : " + admin);

		//관리자로그인 인증
		boolean loginTF = adminLoginService.login(admin);

		//로그인 인증 성공
		if( loginTF ) {

			//로그인 사용자 정보 조회
			admin = adminLoginService.loginInfo(admin);
			
			//세션정보 객체
			HttpSession session = req.getSession();

			session.setAttribute("login", loginTF);
			session.setAttribute("adminNo", admin.getAdminNo());
			session.setAttribute("adminId", admin.getAdminId());
			session.setAttribute("adminPw", admin.getAdminPw());

		} else {
			resp.sendRedirect("error");
		}
		
		

	}
}
