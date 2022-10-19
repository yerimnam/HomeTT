package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dto.Member;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;


@WebServlet("/homett/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/join [GET]");

		req.getRequestDispatcher("/WEB-INF/member/join.jsp").forward(req, resp);
	}
 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/join [POST]");
		
		//요청 데이터의 한글 인코딩 방식 지정하기 : UTF-8
		req.setCharacterEncoding("UTF-8");

		//회원가입 전달파라미터 추출하기
		Member member = userService.getJoinParam(req);
		//잘들어오는지 확인
		System.out.println("MemberController doPost() - member : " + member);


		Member result = userService.join(member);
		System.out.println("MemberController doPost() - result : " + result);

		//JSP view에 객체 전달하기
		req.setAttribute("result", result);

		//JSP View를 지정하고 포워드
		req.getRequestDispatcher("/WEB-INF/member/joinOk.jsp").forward(req, resp);

	}

}











