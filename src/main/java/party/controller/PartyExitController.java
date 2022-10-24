package party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import party.service.face.PartyExitService;
import party.service.impl.PartyExitServiceImpl;


@WebServlet("/homett/partyexit")
public class PartyExitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private PartyExitService partyExitService = new PartyExitServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
