package admin.admindetails.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.admindetails.dto.Admin;
import admin.admindetails.service.face.AdminDetailsService;
import admin.admindetails.service.impl.AdminDetailsServiceImpl;

@WebServlet("/homett/admindetails")
public class AdminDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminDetailsService adminDetailsService = new AdminDetailsServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//한글 인코딩
		req.setCharacterEncoding("UTF-8");
		
		//세션에서 ID값 가져오기
//		HttpSession session = req.getSession();
//		String id = (String) session.getAttribute("id");
		
		//테스트용 ID값
		String id = "admin1"; 
		
		//ID와 일치하는 관리자 정보 가져오기
		List<Admin> admininfo = adminDetailsService.getAdminInfo(id);
		
		//[TEST] 조회결과 확인
		for(Admin a : admininfo) System.out.println(a);
		
		//조회 결과를 MODEL값 전달
		req.setAttribute("admininfo", admininfo);
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/admin/admininfo/admindetails.jsp").forward(req, resp);
		
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
////		doGet(req, resp);
//		
//		req.getRequestDispatcher("/homett/adminmodify").forward(req, resp);
//		
//	}
	
}
