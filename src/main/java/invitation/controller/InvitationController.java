package invitation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import invitation.dto.Invitation;
import invitation.service.face.InvitationService;
import invitation.service.impl.InvitationServiceImpl;

@WebServlet("/homett/invitation")
public class InvitationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스 객체
	private InvitationService invitationService = new InvitationServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/invitation [GET]");
	
		
		// 전달파라미터 객체 얻어오기
		Invitation partyno = invitationService.getPartyNo(req);
		System.out.println("invitation partyNo = " + partyno);
		
		// 객체를 MODEL값으로 전달
		req.setAttribute("partyno", partyno);
		
		req.getRequestDispatcher("/WEB-INF/mypage/invitation.html").forward(req, resp);
	}
	
}
