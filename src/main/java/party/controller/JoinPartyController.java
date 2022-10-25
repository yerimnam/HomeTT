package party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import party.dto.Party;
import party.service.face.JoinPartyService;
import party.service.impl.JoinPartyServiceImpl;

@WebServlet("/homett/joinparty")
public class JoinPartyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스객체
	private JoinPartyService joinPartyService = new JoinPartyServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/joinparty [GET]");

		req.getRequestDispatcher("/WEB-INF/party/joinParty.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 요청데이터 한글 인코딩 방식 지정하기 : UTF-8
		req.setCharacterEncoding("UTF-8");

		// 파티가입 전달파라미터 추출하기
		Party party = joinPartyService.getJoinParty(req);

		// 파티가입 처리
		joinPartyService.join(party);

		// 세션 객체 생성 -> user_no 세션값으로 유저 정보 조회하기 위해서
		HttpSession session = req.getSession();
		


	}

}
