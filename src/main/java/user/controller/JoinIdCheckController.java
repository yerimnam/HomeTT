package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dto.Member;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;


@WebServlet("/homett/joinidchk")
public class JoinIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private UserService userService = new UserServiceImpl();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/joinidchk [GET]");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/joinchk [POST]");
		
		//요청 데이터의 한글 인코딩 방식 지정하기 : UTF-8
		req.setCharacterEncoding("UTF-8");
		Member member = userService.getIdChk(req);
		
		PrintWriter out = resp.getWriter();
		
		int result = userService.checkId(member);
		
		if (result == 0) {
			System.out.println("이미 존재하는 아이디입니다.");
		} else if (result == 1) {
			System.out.println("사용 가능한 아이디입니다.");
		}
	
		out.write(result + "");
	}
	
}




