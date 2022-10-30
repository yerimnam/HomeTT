package partyCheck.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partyCheck.dto.MypageMember;
import partyCheck.dto.PartyCheck;
import partyCheck.service.face.PartyCheckService;
import partyCheck.service.impl.PartyCheckServiceImpl;
import util.Paging5;

@WebServlet("/homett/mypage")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 서비스 객체
	private PartyCheckService partyCheckService = new PartyCheckServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/partycheck [GET]");
		
		// 전달파라미터에서 현제 페이징 객체 계산하기
		Paging5 paging = partyCheckService.getPaging(req);
		
		// 페이징 객체를 MODEL값으로 전달
		req.setAttribute("paging", paging);
		
		// 파티 목록 전체 조회
//		List<PartyCheck> partyList = partyCheckService.getList();
		
		// 방장인 파티 목록 조회
		List<PartyCheck> ownerPartyList = partyCheckService.getOwnerList();
		
		// 파티 페이징 목록 조회
		List<PartyCheck> partyList = partyCheckService.getList(paging);
		
		
		
		// [TEST] 조회결과 확인
		for(PartyCheck p : partyList)	System.out.println(p);
		System.out.println("-------------------");
		for(PartyCheck o : ownerPartyList) System.out.println(o);
		
		// 조회결과를 MODEL값 전달
		req.setAttribute("partyList", partyList);
		req.setAttribute("ownerPartyList", ownerPartyList);
		
		PartyCheck partycheck = partyCheckService.getPartyNo(req);
		
		partyCheckService.delete(partycheck);	
		
		
		// view 지정
		req.getRequestDispatcher("/WEB-INF/mypage/mypage.jsp").forward(req, resp);
	}
	

}
