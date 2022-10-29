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
 * Servlet implementation class EventUpdateController
 */
@WebServlet("/homett/reviewupdate")
public class ReviewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReviewInquiriesService reviewinquiriesService = new ReviewInquiriesServiceImpl();   

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("reviewUpdate [GET]");
	
		//파라미터에서 글번호 가져오기 가져오기
		ReviewBoard reviewNo = reviewinquiriesService.getdataforselect(req);
		
		//글번호로 글 가져와서 보여주기
		
		ReviewBoard update =  reviewinquiriesService.getUpdate(reviewNo);
		
		req.setAttribute("updatecontent", update);
		
		
		req.getRequestDispatcher("/WEB-INF/board/review_update.jsp").forward(req, resp);
		
		
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("reviewUpdate [POST]");
		
		req.setCharacterEncoding("UTF-8");
		
		
		//파라미터에서 글번호 추출하기
		ReviewBoard reviewNum = reviewinquiriesService.getdata(req);

		//글번호로 업데이트하기 
		ReviewBoard updateReview = reviewinquiriesService.setUpdate(reviewNum);
		

		
		resp.sendRedirect("/homett/reviewlist");
		
		
		
	}

}
