package reviewBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reviewBoard.dto.ReviewBoard;
import reviewBoard.service.face.ReviewInquiriesService;
import reviewBoard.service.impl.ReviewInquiriesServiceImpl;

/**
 * Servlet implementation class FaqViewController
 */
@WebServlet("/homett/reviewview")
public class ReviewViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private ReviewInquiriesService reviewinquiriesService = new ReviewInquiriesServiceImpl();

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/homett/reviewview [GET]");
		
		System.out.println("ReviewViewController doGet() - reviewArticlenumber : " + req.getParameter("reviewArticlenumber"));

		
		
		//전달 파라미터 객체 얻어오기
		ReviewBoard reviewArticlenumber =reviewinquiriesService.getreviewArticlenumber(req);
		System.out.println("ReviewViewController doGet() - reviewArticlenumber객체 : " + reviewArticlenumber);
		
		//게시글 상세보기 조회 결과 얻어오기
		ReviewBoard viewBoard = reviewinquiriesService.view(reviewArticlenumber);
		System.out.println("ReviewViewController doGet() - viewBoard : " + viewBoard);
		
//		//조회 결과를 MODEL값으로 전달
		req.setAttribute("viewBoard", viewBoard);
		req.getRequestDispatcher("/WEB-INF/board/review_view.jsp").forward(req, resp);
		
		
	}
}
