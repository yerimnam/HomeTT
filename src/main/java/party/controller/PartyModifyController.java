package party.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import party.dto.Party;
import party.service.face.PartyModifyService;
import party.service.impl.PartyModifyServiceImpl;
import util.PrPaging;

@WebServlet("/homett/partymodify")
public class PartyModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스객체
	private PartyModifyService partyModifyService = new PartyModifyServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/partymodify [GET]");

		// 전달파라미터에서 현재 페이징 객체 계산하기
		PrPaging paging = partyModifyService.getPrPaging(req);
//		System.out.println("[Test]" + paging);

		//페이징 객체를 MODEL값 전달
		req.setAttribute("paging", paging);
		
		// 파티방 전체 조회
//		List<Party> partyList = partyModifyService.getPrList();

		System.out.println(paging);
		// 파티방 페이징 목록 조회
		List<Party> partyList = partyModifyService.getPrList(paging);

		// [Test] 조회결과 확인
//		for(Party p : partyList) System.out.println(p);

		// 조회 결과를 MODEL값 전달
		req.setAttribute("partyList", partyList);

		// View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/party/partyModify.jsp").forward(req, resp);
	}

}
