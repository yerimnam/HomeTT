package partyBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/homett/roomboard")
public class PartyRoomBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/roomboard [GET]");
		
		req.getRequestDispatcher("/WEB-INF/party/partyRoomBoard.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/roomboard [POST]");
		
		//전달 파라미터 한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
				
		System.out.println("data : " + req.getParameter("data"));
	}

}
