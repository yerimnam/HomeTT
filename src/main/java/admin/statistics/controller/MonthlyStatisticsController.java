package admin.statistics.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.login.dto.Admin;
import admin.login.service.face.AdminLoginService;
import admin.login.service.impl.AdminLoginServiceImpl;
import admin.statistics.service.face.MonthlyStatisticsService;
import admin.statistics.service.impl.MonthlyStatisticsServiceImpl;

@WebServlet("/homett/monthlystatistics")
public class MonthlyStatisticsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminLoginService adminLoginService = new AdminLoginServiceImpl();
	private MonthlyStatisticsService monthlyStatisticsService = new MonthlyStatisticsServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("monthlystatistics [GET]");
		//한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		Admin admin = new Admin();
		admin.setAdminId((String) session.getAttribute("adminId"));
		admin.setAdminPw((String) session.getAttribute("adminPw"));
		
		boolean loginSt = adminLoginService.login(admin);
		
		if ( loginSt ) {
		
			//OTT별 월 통계
			
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
			
//			System.out.print("당월 넷플릭스 방 수 : " + netflix + " ");
//			System.out.print("당월 디즈니플러스 방 수 : " + disney + " ");
//			System.out.print("당월 티빙 방 수 : " + tving + " ");
//			System.out.print("당월 애플 방 수 : " + apple + " ");
//			System.out.print("당월 웨이브 방 수 : " + wave + " ");
//			System.out.print("당월 왓챠 방 수 : " + watcha + " ");
//			System.out.println("당월 라프텔 방 수 : " + laftel);
			
			//------------------------------------------------------------
			//가입 유저 수, 탈퇴 유저 수, 신규 파티 수, 종료 파티 수 월 통계
			
			int nuser = monthlyStatisticsService.getCntDNuser();
			int duser = monthlyStatisticsService.getCntDDuser();
			int partycre = monthlyStatisticsService.getCntDPartyCre();
			int partyend = monthlyStatisticsService.getCntDPartyEnd();
			
			req.setAttribute("nuser", nuser);
			req.setAttribute("duser", duser);
			req.setAttribute("partycre", partycre);
			req.setAttribute("partyend", partyend);
			
//			System.out.print("당월 가입 회원 수 : " + nuser + " ");
//			System.out.print("당월 탈퇴 회원 수 : " + duser + " ");
//			System.out.print("당월 생성 파티 수 : " + partycre + " ");
//			System.out.println("당월 종료 파티 수 : " + partyend);
					
			req.getRequestDispatcher("/WEB-INF/admin/statistics/monthlystatistics.jsp").forward(req, resp);;
			
		} else {
				resp.sendRedirect("./adminlogin");
		}
			
	}
	
}
