package admin.userdetails.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.login.dto.Admin;
import admin.login.service.face.AdminLoginService;
import admin.login.service.impl.AdminLoginServiceImpl;
import admin.userdetails.dto.Member;
import admin.userdetails.service.face.AdUserDetailsService;
import admin.userdetails.service.impl.AdUserDetailsServiceImpl;

@WebServlet("/homett/aduserdetails")
public class AdUserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminLoginService adminLoginService = new AdminLoginServiceImpl();
	private AdUserDetailsService adUserDetailsService = new AdUserDetailsServiceImpl(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//한글 인코딩
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		Admin admin = new Admin();
		admin.setAdminId((String) session.getAttribute("adminId"));
		admin.setAdminPw((String) session.getAttribute("adminPw"));
		
		boolean loginSt = adminLoginService.login(admin);
		
		if ( loginSt ) {
		
			String searchType = req.getParameter("searchType");
			String keyword = req.getParameter("keyword");
			
			List<Member> userinfoList = null;
			if(searchType != null && keyword != null) {
				 //검색한 결과
				userinfoList = adUserDetailsService.getchUserinfo(searchType, keyword );
			} 
			
			//TEST 조회결과 확인
//			for(Member m : userinfoList) System.out.println("controller 조회 결과 :" + m);
			
			req.setAttribute("userinfoList", userinfoList);
			req.getRequestDispatcher("/WEB-INF/admin/userinfo/adminuserdetails.jsp").forward(req, resp);
		
		} else {
			resp.sendRedirect("./adminlogin");
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
