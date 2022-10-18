package party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import party.service.face.PartyModifyService;
import party.service.impl.PartyModifyServiceImpl;


@WebServlet("/homett/partymodify")
public class PartyModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스객체
	private PartyModifyService partyModifyService = new PartyModifyServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/partymodify [GET]");
		
		//파티방 전체 조회
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/party/partyModify.jsp").forward(req, resp);
	}

}
