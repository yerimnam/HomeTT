package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.dto.NoticeBoard;
import notice.service.face.NoticeInquiriesService;
import notice.service.impl.NoticeInquiriesServiceImpl;

/**
 * Servlet implementation class FaqViewController
 */
@WebServlet("/homett/noticeview")
public class NoticeViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private NoticeInquiriesService noticeinquiriesService = new NoticeInquiriesServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	System.out.println("/homett/noticeview [GET]");
	
	System.out.println("NoticeViewController doGet() - noticeArticlenumber : " + req.getParameter("noticeArticlenumber"));

	
	
	//전달 파라미터 객체 얻어오기
	NoticeBoard noticeArticlenumber =noticeinquiriesService.getnoticeArticlenumber(req);
	System.out.println("NoticeViewController doGet() - noticeArticlenumber객체 : " + noticeArticlenumber);
	
	//게시글 상세보기 조회 결과 얻어오기
	NoticeBoard viewBoard = noticeinquiriesService.view(noticeArticlenumber);
	System.out.println("NoticeViewController doGet() - viewBoard : " + viewBoard);
	
//		//조회 결과를 MODEL값으로 전달
	req.setAttribute("viewBoard", viewBoard);
	req.getRequestDispatcher("/WEB-INF/cs/notice/notice_view.jsp").forward(req, resp);
		
	}
	
}
