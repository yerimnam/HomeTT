package event.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dto.EventBoard;
import event.service.face.EventInquiriesService;
import event.service.impl.EventInquiriesServiceImpl;

/**
 * Servlet implementation class AdFaqInquiriesController
 */
@WebServlet("/homett/eventlist")
public class EventInquiriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private EventInquiriesService eventinquiriesService = new EventInquiriesServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/eventlist [GET]");

		//게시글 전체 조회
		List<EventBoard> eventboardList = eventinquiriesService.getList();
//		
//		//게시글 페이징 목록 조회
//		List<EventBoard> eventboardList = eventinquiriesService.getList( paging );
//		
		//[TEST] 조회결과 확인
		for(EventBoard b : eventboardList)	System.out.println(b);
		
		//조회결과를 MODEL값 전달
		req.setAttribute("eventboardList", eventboardList );
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/cs/event/event_inquiries.jsp").forward(req, resp);
	}
}
