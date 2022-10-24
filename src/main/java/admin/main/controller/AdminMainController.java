package admin.main.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.statistics.service.face.MonthlyStatisticsService;
import admin.statistics.service.impl.MonthlyStatisticsServiceImpl;

@WebServlet("/homett/adminmain")
public class AdminMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MonthlyStatisticsService monthlyStatisticsService = new MonthlyStatisticsServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//월 통계
		//1. 열린 파티
		int partycre = monthlyStatisticsService.getCntDPartyCre();
		req.setAttribute("partycre", partycre);
		
		//2. 닫힌 파티
		int partyend = monthlyStatisticsService.getCntDPartyEnd();
		req.setAttribute("partyend", partyend);
		
		//3. OTT별 파티 현황
		int netflix = monthlyStatisticsService.getCntNetflix();
		int disney = monthlyStatisticsService.getCntDisney();
		int tving = monthlyStatisticsService.getCntTving();
		int apple = monthlyStatisticsService.getCntApple();
		int wave = monthlyStatisticsService.getCntWave();
		int watcha = monthlyStatisticsService.getCntWatcha();
		int laftel = monthlyStatisticsService.getCntLaftel();
		
		req.setAttribute("netflix", netflix);
		req.setAttribute("disney", disney);
		req.setAttribute("tving", tving);
		req.setAttribute("apple", apple);
		req.setAttribute("wave", wave);
		req.setAttribute("watcha", watcha);
		req.setAttribute("laftel", laftel);
		
		//---------------------------------------------------------------
		
		//문의사항
//		List<Inquiry> inquiryList = InquiryService.getList();
//		req.setAttribute("inquiryList", inquiryList);
		
		//---------------------------------------------------------------
		
		//이벤트
//		List<Event> eventList = EventService.getList();
//		req.setAttribute("eventList", eventList);
		
		//---------------------------------------------------------------
		
		req.getRequestDispatcher("/WEB-INF/admin/main/adminmain.jsp").forward(req, resp);
	}
	
}
