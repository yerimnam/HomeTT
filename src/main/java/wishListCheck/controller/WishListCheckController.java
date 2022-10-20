package wishListCheck.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/homett/wishcheck")
public class WishListCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/wishcheck [GET]");
		
		req.getRequestDispatcher("/WEB-INF/mypage/wishlist.jsp").forward(req, resp);
	}

}
