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


@WebServlet("/homett/editprofile")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private UserService userService = new UserServiceImpl();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/type [GET]");
		
		req.getRequestDispatcher("/WEB-INF/member/EditProfile.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Member member = new Member();
		
		
		//요청 데이터의 한글 인코딩 방식 지정하기 : UTF-8
		req.setCharacterEncoding("UTF-8");
		
		member = userService.getEditInfo(req);
		
		//파라미터값이 비어있으면 세션에 있는 기본정보로 채우기
		userService.getEditInfoChange(req, member);
		 
		System.out.println(member);
		
		userService.UpdateInfo(member);
		
	
	}
	
}







