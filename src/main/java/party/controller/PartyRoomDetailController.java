package party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import party.dto.Party;
import party.service.face.PartyModifyService;
import party.service.impl.PartyModifyServiceImpl;


@WebServlet("/homett/partyroomdetail")
public class PartyRoomDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private PartyModifyService partyModifyService = new PartyModifyServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("homett/partyroomdetail [GET]");
		
		System.out.println("PartyRoomDetailController doGet() - partyRoomNo : " + req.getParameter("partyRoomNo").trim());

		//전달파라미터 객체 얻어오기
		Party partyRoomNo = partyModifyService.getPartyRoomNo(req);
		
		System.out.println("PartyRoomDetailController doGet() - partyRoomNo객체 : " + partyRoomNo);
		
		
		//게시글 상세보기 조회 결과 얻어오기
		Party viewParty = partyModifyService.view(partyRoomNo);
		System.out.println("PartyRoomDetailController doGet() - viewParty : " + viewParty);
		
		
		
		//조회결과를 MODEL값으로 전달
		req.setAttribute("viewParty", viewParty); 
		
		//View지정 및 응답
		req.getRequestDispatcher("/WEB-INF/party/partyRoomDetail.jsp").forward(req, resp);
		
		String partyNo = req.getParameter("partyRoomNo");

		//세션 객체 생성 -> user_no 세션값으로 유저정보 조회
		HttpSession session = req.getSession();
		session.setAttribute("partyNo",partyNo);
		//세션값 넣기
//		int userno = (int)session.getAttribute("user_no");
		int partyno = (int)session.getAttribute("party_no");
	}
	
}
