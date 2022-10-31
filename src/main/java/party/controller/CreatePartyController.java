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
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;

@WebServlet("/homett/createparty")
public class CreatePartyController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	//서비스 객체
	private CreatePartyService createpartyService = new CreatePartyServiceImpl();
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/createparty - doget() TEST");
		
		HttpSession session = req.getSession();
		
		Member member = new Member();
		member.setUserId((String) session.getAttribute("userId"));
		
		if ( member.getUserId() != null ) {
			System.out.println(member.getUserId());
			//jsp 뷰 지정
			req.getRequestDispatcher("/WEB-INF/party/createParty.jsp").forward(req, resp);
		
		} else {
			resp.sendRedirect("./login");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/createparty [POST]");
		
		//요청데이터 한글 인코딩 방식 지정하기 : UTF-8
		req.setCharacterEncoding("UTF-8");
		
		
		//파티 생성 전달 파라미터 추출
		Party party = createpartyService.getCreateParty(req);
		
		Party partyNo = createpartyService.create(party);
		System.out.println("CreatePartyController doPost() - result : " + partyNo);
		
		
		String partyNum = req.getParameter("partyNo");
		
		//세션 객체 생성
		HttpSession session =req.getSession();
		session.setAttribute("partyNo", partyNo);

		System.out.println("------session " + session.getAttribute("partyNo"));
		
		
		//세션 객체 가져오기
		Member member = new Member();
		member.setUserId((String) session.getAttribute("userId"));
		
		if ( member.getUserId() != null ) {
			
			System.out.println("로그인됨");
			
		} else {
			resp.sendRedirect("./login");
		}
		
		//partyLeader 파라미터 꺼내오기
		
		
		
		
		//로그인한 사람의 정보 조회
//		Member user = createpartyService.getuserinfo(userno);		
//		System.out.println("CreatePartyController doPost() - member : " + userinfo);
		//JSP View 객체 전달하기
//		req.setAttribute("userinfo", user);
		
		
		//
		resp.sendRedirect("./partymodify");
	}
}
