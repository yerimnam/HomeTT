package party.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import party.dto.Party;
import party.dto.PartyRoom;
import party.service.face.PartyExitService;
import party.service.impl.PartyExitServiceImpl;
import partyBoard.service.face.PartyRoomBoardService;
import partyBoard.service.impl.PartyRoomBoardServiceImpl;


@WebServlet("/homett/partyexit")
public class PartyExitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private PartyRoomBoardService partyRoomBoardService = new PartyRoomBoardServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/partyexit [GET]");
		req.setCharacterEncoding("UTF-8");

		//파티룸 객체 생성
		PartyRoom partyRoom = new PartyRoom();
		
		Party party = partyRoomBoardService.getPartyNo(req);
		
		partyRoomBoardService.dropParty(partyRoom);
		
		resp.sendRedirect("/homett/roomboard");
	}
}
