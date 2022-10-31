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
 * Servlet implementation class EventUpdateController
 */
@WebServlet("/homett/eventupdate")
public class EventUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EventInquiriesService eventinquiriesService = new EventInquiriesServiceImpl();   

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("eventUpdate [GET]");
	
		//파라미터에서 글번호 가져오기 가져오기
		EventBoard eventNo = eventinquiriesService.getdataforselect(req);
		
		//글번호로 글 가져와서 보여주기
		
		EventBoard update =  eventinquiriesService.getUpdate(eventNo);
		
		req.setAttribute("updatecontent", update);
		
		
		req.getRequestDispatcher("/WEB-INF/cs/event/event_update.jsp").forward(req, resp);
		
		
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("eventUpdate [POST]");
		
		req.setCharacterEncoding("UTF-8");
		
		
		//파라미터에서 글번호 추출하기
		EventBoard eventNum = eventinquiriesService.getdata(req);

		//글번호로 업데이트하기 
		EventBoard updateevent = eventinquiriesService.setUpdate(eventNum);
		

		
		resp.sendRedirect("/homett/eventlist");
		
		
		
	}

}
