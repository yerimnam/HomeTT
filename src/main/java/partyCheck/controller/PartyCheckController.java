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
import partyExit.dto.PartyExit;
import util.Paging;

@WebServlet("/homett/partycheck")
public class PartyCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 서비스 객체
	private PartyCheckService partyCheckService = new PartyCheckServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/partycheck [GET]");
		
		// 전달파라미터에서 현제 페이징 객체 계산하기
		Paging paging = partyCheckService.getPaging(req);
		
		// 페이징 객체를 MODEL값으로 전달
		req.setAttribute("paging", paging);
		
		// 파티 목록 전체 조회
//		List<PartyCheck> partyList = partyCheckService.getList();
		
		// 파티 페이징 목록 조회
		List<PartyCheck> partyList = partyCheckService.getList(paging);
		
		// [TEST] 조회결과 확인
		for(PartyCheck p : partyList)	System.out.println(p);
		
		// 조회결과를 MODEL값 전달
		req.setAttribute("partyList", partyList);
		
		PartyCheck partycheck = partyCheckService.getPartyNo(req);
		
		partyCheckService.delete(partycheck);
		
		
		// view 지정
		req.getRequestDispatcher("/WEB-INF/mypage/partycheck.jsp").forward(req, resp);
	}
		
	
}
