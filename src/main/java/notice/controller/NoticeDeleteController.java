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
 * Servlet implementation class ReviewDeleteController
 */
@WebServlet("/homett/noticedelete")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	NoticeInquiriesService noticeinquiriesService = new NoticeInquiriesServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("homett/noticedelete[GET]");
		
		//파라미터에서 글 번호 추출
		NoticeBoard noticeNo = noticeinquiriesService.getdata(req);
		
		//추출한 파라미터(글번호)로 삭제
		noticeinquiriesService.deleteNotice(noticeNo);
		
		resp.sendRedirect("/homett/noticelist");
	
	}
	
	

}
