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
 * Servlet implementation class ReviewDeleteController
 */
@WebServlet("/homett/eventdelete")
public class EventDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	EventInquiriesService eventinquiriesService = new EventInquiriesServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("homett/eventdelete[GET]");
		
		//파라미터에서 글 번호 추출
		EventBoard eventNo = eventinquiriesService.getdata(req);
		
		//추출한 파라미터(글번호)로 삭제
		eventinquiriesService.deleteEvent(eventNo);
		
		resp.sendRedirect("/homett/eventlist");
	
	}
	
	

}
