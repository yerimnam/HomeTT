package party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import party.service.face.WishListService;
import party.service.impl.WishListServiceImpl;

@WebServlet("/homett/wishlist")
public class WishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	//객체 생성하기
	WishListService wishlistService = new WishListServiceImpl();
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			System.out.println("/homett/wishlist [GET]");
			
			//jsp 뷰 먼저 지정
			req.getRequestDispatcher("/homett/wishlist - doget() TEST");
			
			
		}
		
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			System.out.println("/homett/wishlist [POST]");
			

			//전달 파라미터 먼저 추출
			
			
			
			
			
			
			
		}

}
