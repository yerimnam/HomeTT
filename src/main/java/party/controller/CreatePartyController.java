package party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import party.dto.Party;
import party.service.face.CreatePartyService;
import party.service.impl.CreatePartyServiceImpl;
import user.dto.Member;
import util.Paging;

@WebServlet("/homett/createparty")
public class CreatePartyController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	//서비스 객체
	private CreatePartyService createpartyService = new CreatePartyServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/createparty - doget() TEST");
		
		//jsp 뷰 지정
		req.getRequestDispatcher("/WEB-INF/party/createParty.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/createparty [POST]");
		
		//요청데이터 한글 인코딩 방식 지정하기 : UTF-8
		req.setCharacterEncoding("UTF-8");

		
		
		//파티 생성 전달 파라미터 추출
		Party party = createpartyService.getCreateParty(req);
	
		
		System.out.println("CreatePartyController doPost() - party : " + party);
		
		Party partyNo = createpartyService.create(party);
		System.out.println("CreatePartyController doPost() - result : " + partyNo);
		
		
		//JSP View로 객체 전달하기
		req.setAttribute("partyNo", partyNo);
		
		
		//세션 객체 생성	-> user_no 세션값으로 유저 정보 조회하기 위해서
		HttpSession session =req.getSession();

		
		//세션 객체 가져오기
		session.getAttribute("userNo");
		
//		boolean loginSt = adminLoginService.login(admin);
//		
//		if ( loginSt ) {
//		
//			String searchType = req.getParameter("searchType");
//			String keyword = req.getParameter("keyword");
//			
//			Paging paging;
//			if ( searchType != null && keyword != null ) {
//				paging = adReportListService.getSearchPaging(req, searchType, keyword);
//			} else {
//				paging = adReportListService.getPaging(req);
//			}
		
		
		
		//실제 코드 // session 은 String타입
		int userno = (int) session.getAttribute("u");

		
		//로그인한 사람의 정보 조회
		Member user = createpartyService.getuserinfo(userno);		
//		System.out.println("CreatePartyController doPost() - member : " + userinfo);
		
		
		//JSP View 객체 전달하기
		req.setAttribute("userinfo", user);
		
		
		//
		resp.sendRedirect("./partymodify");
	}
}
