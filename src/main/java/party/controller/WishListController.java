package party.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import party.dto.WishList;
import party.service.face.PartyModifyService;
import party.service.face.WishListService;
import party.service.impl.PartyModifyServiceImpl;
import party.service.impl.WishListServiceImpl;
import user.dto.Member;

@WebServlet("/homett/wishlist")
public class WishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	//객체 생성하기
	private WishListService wishlistService = new WishListServiceImpl();
	
	// 서비스객체
	private PartyModifyService partyModifyService = new PartyModifyServiceImpl();
	
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			System.out.println("/homett/wishlist [GET]");
			
			HttpSession session = req.getSession();
//			session.setAttribute("user_no", 1); // 테스트용 유저 정보 받아오기
//			int userNo = Integer.parseInt(String.valueOf(session.getAttribute("userNo")));
//			int userNo = (int) session.getAttribute("user_no");
			
			
			//jsp 뷰 먼저 지정
			req.getRequestDispatcher("/WEB-INF/party/partyModify.jsp").forward(req, resp);
		
			
		}
		
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			System.out.println("/homett/wishlist [POST]");

			
			HttpSession session = req.getSession();
			
			
			Member member = new Member();
			member.setUserId((String) session.getAttribute("userNo"));
			
//			session.setAttribute("userNo", 1); // 테스트용 유저 정보 받아오기
//			int userNo = Integer.parseInt(String.valueOf(session.getAttribute("userNo")));
			
			//추후 세션값으로 대치
//			int userNo = 1;
			String partyNo = req.getParameter("partyNo"); //파티 정보 받아오기
			
			System.out.println("partyNo :"+ partyNo);
			
			//글 삽입하기
			wishlistService.wishinsert(req);
			
//			PrintWriter out = resp.getWriter();
			
			
			req.getRequestDispatcher("/WEB-INF/party/wishList.jsp").forward(req, resp);
//			doGet(req, resp);
			
		}

}
