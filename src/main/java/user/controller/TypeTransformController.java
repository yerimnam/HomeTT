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

@WebServlet("/homett/type")
public class TypeTransformController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/type [GET]");
		
		req.getRequestDispatcher("/WEB-INF/member/typeTransform.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/type [POST]");
		
		Member member = new Member();
		
		member = userService.getUserParam(req);
		
		System.out.println("member : " + member);
		
		Member result = userService.UpdateType(member);
		
		result.setMasterNo(1);
		
		System.out.println("result : " + result);
	
		HttpSession session = req.getSession();
		session.setAttribute("masterNo", result.getMasterNo());
		
		req.getRequestDispatcher("/WEB-INF/member/typeTransformOk.jsp").forward(req, resp);
	}
	
	
	
}
