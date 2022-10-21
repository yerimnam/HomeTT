package wishListCheck.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wishListCheck.dto.WishListCheck;
import wishListCheck.service.face.WishListCheckService;
import wishListCheck.service.impl.WishListCheckServiceImpl;

@WebServlet("/homett/wishcheck")
public class WishListCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스 객체
	private WishListCheckService wishListCheckservice =  new WishListCheckServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/homett/wishcheck [GET]");
		
		// 찜 목록 전체 조회
		List<WishListCheck> wishList = wishListCheckservice.getList();
		
		// [TEST] 조회결과 확인
		for(WishListCheck w : wishList)	System.out.println(w);
		
		// 조회결과를 MODEL값 전달
		req.setAttribute("wishList", wishList);
		
		req.getRequestDispatcher("/WEB-INF/mypage/wishlist.jsp").forward(req, resp);
	}

}
