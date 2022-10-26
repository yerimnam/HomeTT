package admin.statistics.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.statistics.service.face.DailyStatisticsService;
import admin.statistics.service.impl.DailyStatisticsServiceImpl;

@WebServlet("/homett/dailystatistics")
public class DailyStatisticsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DailyStatisticsService dailyStatisticsService = new DailyStatisticsServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		//----------------------------------------------------------
		//OTT별 당일 통계
		
		int netflix = dailyStatisticsService.getCntNetflix();
		int disney = dailyStatisticsService.getCntDisney();
		int tving = dailyStatisticsService.getCntTving();
		int apple = dailyStatisticsService.getCntApple();
		int wave = dailyStatisticsService.getCntWave();
		int watcha = dailyStatisticsService.getCntWatcha();
		int laftel = dailyStatisticsService.getCntLaftel();
		
		req.setAttribute("netflix", netflix);
		req.setAttribute("disney", disney);
		req.setAttribute("tving", tving);
		req.setAttribute("apple", apple);
		req.setAttribute("wave", wave);
		req.setAttribute("watcha", watcha);
		req.setAttribute("laftel", laftel);
		
//		System.out.print("넷플릭스 방 수 : " + netflix + " ");
//		System.out.print("디즈니플러스 방 수 : " + disney + " ");
//		System.out.print("티빙 방 수 : " + tving + " ");
//		System.out.print("애플 방 수 : " + apple + " ");
//		System.out.print("웨이브 방 수 : " + wave + " ");
//		System.out.print("왓챠 방 수 : " + watcha + " ");
//		System.out.println("라프텔 방 수 : " + laftel);
		
		//------------------------------------------------------------
		//가입 유저 수, 탈퇴 유저 수, 신규 파티 수, 종료 파티 수 당일 통계
		
		int nuser = dailyStatisticsService.getCntDNuser();
		int duser = dailyStatisticsService.getCntDDuser();
		int partycre = dailyStatisticsService.getCntDPartyCre();
		int partyend = dailyStatisticsService.getCntDPartyEnd();
		
		req.setAttribute("nuser", nuser);
		req.setAttribute("duser", duser);
		req.setAttribute("partycre", partycre);
		req.setAttribute("partyend", partyend);
		
//		System.out.print("오늘 가입 회원 수 : " + nuser + " ");
//		System.out.print("오늘 탈퇴 회원 수 : " + duser + " ");
//		System.out.print("신규 생성 파티 수 : " + partycre + " ");
//		System.out.println("종료 파티 수 : " + partyend);
		
		req.getRequestDispatcher("/WEB-INF/admin/statistics/dailystatistics.jsp").forward(req, resp);
		
	}
	
}
