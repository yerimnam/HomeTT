package partyBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partyBoard.dto.PartyBoard;
import partyBoard.service.face.PartyRoomBoardService;
import partyBoard.service.impl.PartyRoomBoardServiceImpl;

/**
 * Servlet implementation class CommentController
 */
@WebServlet("/homett/comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체 가져오기
	private PartyRoomBoardService partyroomboardService = new PartyRoomBoardServiceImpl();

	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/comment GET()");
		
	
		PartyBoard partyboard = partyroomboardService.getpartyBoardno(req);
		
		partyroomboardService.delete(partyboard);
		
		resp.sendRedirect("/homett/roomboard");
		
		
		
		}
	
	

}
