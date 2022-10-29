package partyExit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partyExit.dto.PartyExit;
import partyExit.service.face.PartyExitService;
import partyExit.service.impl.PartyExitServiceImpl;

@WebServlet("/homett/exit")
public class PartyExitContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스 객체
	private PartyExitService partyExitService = new PartyExitServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/exit [GET]");
		
		PartyExit partyexit = partyExitService.getPartyNo(req);
		
		partyExitService.delete(partyexit);
				
		resp.sendRedirect("./partycheck");
//		req.getRequestDispatcher("/WEB-INF/mypage/partyExit.jsp").forward(req, resp);
		 
	}
	
}
