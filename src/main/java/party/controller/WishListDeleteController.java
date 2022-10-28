package party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import party.service.face.PartyModifyService;
import party.service.face.WishListService;
import party.service.impl.PartyModifyServiceImpl;
import party.service.impl.WishListServiceImpl;

/**
 * Servlet implementation class WishListDeleteController
 */
@WebServlet("/homett/wishdelete")
public class WishListDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 객체 생성하기
	private WishListService wishlistService = new WishListServiceImpl();

	// 서비스객체
	private PartyModifyService partyModifyService = new PartyModifyServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/homett/wishdelete [GET]");

		// jsp 뷰 먼저 지정
		req.getRequestDispatcher("/WEB-INF/party/wishList.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/homett/wishdelete [POST]");

		// 글 삽입하기
		wishlistService.wishdelete(req);
			
		
		//이제 ajax 처리만 하면 된다.....
			
			
		}

}
