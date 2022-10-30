package event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dto.EventBoard;
import event.service.face.EventInquiriesService;
import event.service.impl.EventInquiriesServiceImpl;

/**
 * Servlet implementation class FaqViewController
 */
@WebServlet("/homett/eventview")
public class EventViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private EventInquiriesService eventinquiriesService = new EventInquiriesServiceImpl();

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/homett/eventview [GET]");
		
		System.out.println("EventViewController doGet() - eventArticlenumber : " + req.getParameter("eventArticlenumber"));
		
		//전달 파라미터 객체 얻어오기
		EventBoard eventArticlenumber =eventinquiriesService.geteventArticlenumber(req);
		System.out.println("EventViewController doGet() - eventArticlenumber객체 : " + eventArticlenumber);
		
		//게시글 상세보기 조회 결과 얻어오기
		EventBoard viewBoard = eventinquiriesService.view(eventArticlenumber);
		System.out.println("FaqViewController doGet() - viewBoard : " + viewBoard);
		
//		//조회 결과를 MODEL값으로 전달
		req.setAttribute("viewBoard", viewBoard);
		req.getRequestDispatcher("/WEB-INF/cs/event/event_view.jsp").forward(req, resp);
		
		
	}
}
