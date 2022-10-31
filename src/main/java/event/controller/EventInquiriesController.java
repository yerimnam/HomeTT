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
import util.Paging;

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
		

		
		//한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");
		
		Paging paging;
		if ( searchType != null && keyword != null ) {
			paging = eventinquiriesService.getSearchPaging(req, searchType, keyword);
		} else {
			paging = eventinquiriesService.getPaging(req);
		}
		
		req.setAttribute("paging", paging);
		
		List<EventBoard> eventboardList;
		if(searchType != null && keyword != null) {
			// 검색한 결과
			eventboardList = eventinquiriesService.getSearchList( paging, searchType, keyword );
			System.out.println("검색한 paging 결과 : " + paging);
		} else {
			// 검색 안한 결과
			eventboardList = eventinquiriesService.getList(paging);
			System.out.println("검색 안한 paging 결과 : " + paging);
		}
		
		req.setAttribute("eventboardList", eventboardList);
		//-------------------------------------------------------------------
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/cs/event/event_inquiries.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
