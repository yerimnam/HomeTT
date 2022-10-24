package partyBoard.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partyBoard.dto.PartyBoard;
import partyBoard.service.face.PartyRoomBoardService;
import partyBoard.service.impl.PartyRoomBoardServiceImpl;

/**
 * Servlet implementation class PartyRoomWriteBoard
 */
@WebServlet("/homett/roomboardwrite")
public class PartyRoomBoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PartyRoomBoardService partyRoomBoardService = new PartyRoomBoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		System.out.println("/homett/roomboardwrite [POST]");

		System.out.println("partyBoardTitle : " + req.getParameter("partyBoardTitle"));

		PrintWriter out = resp.getWriter();

		PartyBoard partyBaord = partyRoomBoardService.write(req);
		if (partyBaord != null) {
			out.print(true);
		} else {
			out.print(false);
		}

		// resp.sendRedirect("/homett/roomboard");

	}

}
