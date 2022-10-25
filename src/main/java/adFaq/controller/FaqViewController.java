package adFaq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adFaq.dto.FaqBoard;
import adFaq.service.face.FaqInquiriesService;
import adFaq.service.impl.FaqInquiriesServiceImpl;

/**
 * Servlet implementation class FaqViewController
 */
@WebServlet("/homett/faqview")
public class FaqViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private FaqInquiriesService faqinquieiesService = new FaqInquiriesServiceImpl();

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/homett/faqview [GET]");
		
		System.out.println("FaqViewController doGet() - boardcode : " + req.getParameter("boardcode"));
		
		//전달 파라미터 객체 얻어오기
		FaqBoard boardcode = faqinquieiesService.getBoardcode(req);
		System.out.println("FaqViewController doGet() - boardcode객체 : " + boardcode);
		
		//게시글 상세보기 조회 결과 얻어오기
		FaqBoard viewBoard = faqinquieiesService.view(boardcode);
		System.out.println("FaqViewController doGet() - viewBoard : " + viewBoard);
		
		//조회 결과를 MODEL값으로 전달
		req.setAttribute("viewBoard", viewBoard);
		req.getRequestDispatcher("/WEB-INF/cs/faq/faq_view.jsp").forward(req, resp);
		
		
	}
}
