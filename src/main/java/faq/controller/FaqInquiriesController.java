package faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.dto.FaqBoard;
import faq.service.face.FaqInquiriesService;
import faq.service.impl.FaqInquiriesServiceImpl;
import util.Paging;

/**
 * Servlet implementation class AdFaqInquiriesController
 */
@WebServlet("/homett/faqlist")
public class FaqInquiriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//서비스 객체
	private FaqInquiriesService FaqinquiriesService = new FaqInquiriesServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/faqlist [GET]");
		
		//전달 파라미터에서 현재 페이징 객체 계산하기
		Paging paging = FaqinquiriesService.getPaging(req);
		System.out.println("[TEST]" + paging);
		
			//게시글 전체 조회
//			List<FaqBoard> faqboardList = FaqinquiriesService.getList();
			
			//게시글 페이징 목록 조회
			List<FaqBoard> faqboardList = FaqinquiriesService.getList(paging);
				
			//[TEST] 조회결과 확인
			for(FaqBoard b : faqboardList)	System.out.println(b);
				
			//조회결과를 MODEL값 전달
			req.setAttribute("faqboardList", faqboardList );
				
			//View 지정 및 응답
			req.getRequestDispatcher("/WEB-INF/cs/faq/faq_inquiries.jsp").forward(req, resp);
	}
}
