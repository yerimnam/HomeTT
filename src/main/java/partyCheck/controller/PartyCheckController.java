package partyCheck.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partyCheck.dto.PartyCheck;
import partyCheck.service.face.PartyCheckService;
import partyCheck.service.impl.PartyCheckServiceImpl;

@WebServlet("/homett/partycheck")
public class PartyCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 서비스 객체
	private PartyCheckService partyCheckService = new PartyCheckServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/partycheck [GET]");
		
		// 파티 목록 전체 조회
		List<PartyCheck> partyList = partyCheckService.getList();
		
		// [TEST] 조회결과 확인
		for(PartyCheck p : partyList)	System.out.println(p);
		
		// 조회결과를 MODEL값 전달
		req.setAttribute("partyList", partyList);
		
		// view 지정
		req.getRequestDispatcher("/WEB-INF/mypage/partycheck.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
