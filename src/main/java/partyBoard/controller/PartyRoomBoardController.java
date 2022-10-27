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
import util.PbPaging;

@WebServlet("/homett/roomboard")
public class PartyRoomBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스 객체
	private PartyRoomBoardService partyRoomBoardService = new PartyRoomBoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/roomboard [GET]");


		// 전달파라미터에서 현재 페이징 객체 계산하기
		PbPaging paging = partyRoomBoardService.getBrPaging(req);
//		System.out.println("[Test]" + paging);

		// 페이징 객체를 MODEL값 전달
		req.setAttribute("paging", paging);

		// 게시글 전체 조회
//		List<PartyBoard> partyBoardList = partyRoomBoardService.getBrList();

		// 파티게시판 전체 조회
		List<PartyBoard> partyBoardList = partyRoomBoardService.getBrList(paging);

		// 조회결과를 MODEL값 전달
		req.setAttribute("partyBoardList", partyBoardList);
//		for(PartyBoard pb : partyBoardList) System.out.println(pb);

		req.getRequestDispatcher("/WEB-INF/party/partyRoomBoard.jsp").forward(req, resp);


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/roomboard [POST]");

		// 전달 파라미터 한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");

		// 전달파라미터를 PartyBoard DTO에 객체 저장하기 - partyRoomBoardService이용
		PartyBoard partyBoard = partyRoomBoardService.getParam(req);
		System.out.println("PartyRoomBoardController doPost() - partyBoard : " + partyBoard);

		// 전달 파라미터를 저장한 DTO객체를 DB에 입력한다 - PartyRoomBoardService이용

		// JSP View에 객체 전달하기
		req.setAttribute("partyBoard", partyBoard);

		// JSP에 객체 전달
		req.getRequestDispatcher("/WEB-INF/party/partyRoomBoard.jsp").forward(req, resp);
	}

}
