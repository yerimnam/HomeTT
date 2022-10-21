package partyBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partyBoard.dto.PartyBoard;
import partyBoard.service.face.PartyRoomBoardService;
import partyBoard.service.impl.PartyRoomBoardServiceImpl;

@WebServlet("/homett/roomboard")
public class PartyRoomBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private PartyRoomBoardService partyRoomBoardService = new PartyRoomBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/roomboard [GET]");
		
		//게시글 전체 조회
		List<PartyBoard> partyBoardList = partyRoomBoardService.getBrList();
		
		//계정공유기간, 인원수
		List<PartyBoard> headList = partyRoomBoardService.getheadList();
		
		req.setAttribute("headList", headList);
		
		
		
		//조회결과를 MODEL값 전달
		req.setAttribute("partyBoardList", partyBoardList);
//		for(PartyBoard pb : partyBoardList) System.out.println(pb);
		
		req.getRequestDispatcher("/WEB-INF/party/partyRoomBoard.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/roomboard [POST]");
		
		//전달 파라미터 한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
				
	}

}
