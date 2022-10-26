package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/homett/dropuserok")
public class DropUserOkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//세션 정보 삭제 - 로그아웃
		req.getSession().invalidate();
				
		//메인페이지로 리다이렉트
//		resp.sendRedirect("./main");
		
		req.getRequestDispatcher("/WEB-INF/member/dropUserOk.jsp").forward(req, resp);
		
	}
}
