package reviewBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reviewBoard.dto.ReviewBoard;
import reviewBoard.service.face.ReviewInquiriesService;
import reviewBoard.service.impl.ReviewInquiriesServiceImpl;

/**
 * Servlet implementation class AdFaqInquiriesController
 */
@WebServlet("/homett/reviewlist")
public class ReviewInquiriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private ReviewInquiriesService reviewinquiriesService = new ReviewInquiriesServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/reviewlist [GET]");

		//게시글 전체 조회
		List<ReviewBoard> reviewboardList = reviewinquiriesService.getList();
//		
//		//게시글 페이징 목록 조회
//		List<ReviewBoard> reviewboardList = reviewinquiriesService.getList( paging );
//		
		//[TEST] 조회결과 확인
		for(ReviewBoard r : reviewboardList)	System.out.println(r);    
		
		//조회결과를 MODEL값 전달
		req.setAttribute("reviewboardList", reviewboardList );
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/board/review_inquiries.jsp").forward(req, resp);
	}
}
