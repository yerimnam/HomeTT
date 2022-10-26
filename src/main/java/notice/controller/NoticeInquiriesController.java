package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.dto.NoticeBoard;
import notice.service.face.NoticeInquiriesService;
import notice.service.impl.NoticeInquiriesServiceImpl;
import util.Paging;

/**
 * Servlet implementation class AdFaqInquiriesController
 */
@WebServlet("/homett/noticelist")
public class NoticeInquiriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//서비스 객체
	private NoticeInquiriesService NoticeinquiriesService = new NoticeInquiriesServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/Noticelist [GET]");
		
		//전달 파라미터에서 현재 페이징 객체 계산하기
		Paging paging = NoticeinquiriesService.getPaging(req);
		System.out.println("[TEST]" + paging);
		
			//게시글 전체 조회
//			List<NoticeBoard> noticeboardList = NoticeinquiriesService.getList();
			
			//게시글 페이징 목록 조회
			List<NoticeBoard> noticeboardList = NoticeinquiriesService.getList(paging);
				
			//[TEST] 조회결과 확인
			for(NoticeBoard b : noticeboardList)	System.out.println(b);
				
			//조회결과를 MODEL값 전달
			req.setAttribute("noticeboardList", noticeboardList );
				
			//View 지정 및 응답
			req.getRequestDispatcher("/WEB-INF/cs/faq/notice_inquiries.jsp").forward(req, resp);
	}
}
