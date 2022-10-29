package reviewBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reviewBoard.dao.face.ReviewInquiriesDao;
import reviewBoard.dto.ReviewBoard;
import reviewBoard.service.face.ReviewInquiriesService;
import reviewBoard.service.impl.ReviewInquiriesServiceImpl;

/**
 * Servlet implementation class ReviewDeleteController
 */
@WebServlet("/homett/reviewdelete")
public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	ReviewInquiriesService reviewinquiriesService = new ReviewInquiriesServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("homett/reviewdelete[GET]");
		
		//파라미터에서 글 번호 추출
		ReviewBoard reviewNo = reviewinquiriesService.getdata(req);
		
		//추출한 파라미터(글번호)로 삭제
		reviewinquiriesService.deleteReview(reviewNo);
		
		resp.sendRedirect("/homett/reviewlist");
	
	}
	
	

}
