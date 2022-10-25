package partyBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partyBoard.service.face.PartyRoomBoardService;
import partyBoard.service.impl.PartyRoomBoardServiceImpl;

@WebServlet("/homett/roommember")
public class PartyRoomMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스 객체
	private PartyRoomBoardService partyRoomBoardService = new PartyRoomBoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/roommember [GET]");
		
		//해당 파티의 멤버 조회
	}

}
