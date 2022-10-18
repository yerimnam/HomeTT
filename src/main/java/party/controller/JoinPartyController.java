package party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinPartyController
 */
@WebServlet("/homett/joinparty")
public class JoinPartyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			System.out.println("/homett/joinparty [GET]");
		
		}

}
