package event.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import event.dto.EventBoard;
import event.service.face.EventInquiriesService;
import event.service.impl.EventInquiriesServiceImpl;




/**
 * Servlet implementation class AdFaqcreateController
 */
@WebServlet("/homett/eventcreate")
public class EventCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	//서비스 객체 
	EventInquiriesService eventinquiriesService = new EventInquiriesServiceImpl();
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//한글 인코딩
		req.setCharacterEncoding("UTF-8");
		//model값 저장하여 view전달		
		req.getRequestDispatcher("/WEB-INF/cs/event/event_create.jsp").forward(req, resp);
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
		
		//테스트용 세션
//		session.setAttribute("userNo", 0);						//<---지울것
		//실제 작동
//		int userNo = (int)session.getAttribute("userNo");

		//파라미터 추출하기 
		EventBoard param = eventinquiriesService.getparam(req);
		
		System.out.println(param);
		
		//회원번호 파라미터로 게시글 저장하기
//		EventBoard reBoard = eventinquiriesService.setEvent(param,userNo);
		EventBoard reBoard = eventinquiriesService.setEvent(param);
		System.out.println(reBoard);
		
		req.setAttribute("eventInsert", reBoard);


		resp.sendRedirect("/homett/eventlist");
	
	}
	
	

}
