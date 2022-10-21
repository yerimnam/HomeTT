package calculate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calculate.dto.Calculate;
import calculate.service.face.CalculateCheckService;
import calculate.service.impl.CalculateCheckServiceImpl;

@WebServlet("/homett/calculatecheck")
public class CalculateCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 서비스 객체
	private CalculateCheckService calculateCheckService = new CalculateCheckServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/calculatecheck [GET]");
		
		// 정산 내역 목록 전체 조회
		List<Calculate> calculateList = calculateCheckService.getList();
		
		// [TEST] 조회결과 확인
		for(Calculate c : calculateList)	System.out.println(c);
		
		// 조회결과 MODEL값 전달
		req.setAttribute("calculateList", calculateList);
			
		// View 지정
		req.getRequestDispatcher("/WEB-INF/mypage/calculatecheck.jsp").forward(req, resp);
	}

}
