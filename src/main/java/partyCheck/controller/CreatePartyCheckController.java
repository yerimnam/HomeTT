package partyCheck.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partyCheck.dto.PartyCheck;
import partyCheck.service.face.CreatePartyCheckService;
import partyCheck.service.impl.CreatePartyCheckServiceImpl;

@WebServlet("/homett/createpartycheck")
public class CreatePartyCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CreatePartyCheckService createPartyCheckservice = new CreatePartyCheckServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/createpartycheck [GET]");
		
		// 생성한 파티방 목록 조회
		List<PartyCheck> crePartyList = createPartyCheckservice.getList();
		
		// 테스트
		for(PartyCheck p : crePartyList)	System.out.println(p);
		
		// View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/mypage/inpartycheck.jsp").forward(req, resp);
		
		
		
	}
	
}
