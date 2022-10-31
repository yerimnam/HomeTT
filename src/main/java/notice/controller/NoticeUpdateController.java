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
 * Servlet implementation class EventUpdateController
 */
@WebServlet("/homett/noticeupdate")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NoticeInquiriesService noticeinquiriesService = new NoticeInquiriesServiceImpl();   

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("noticeUpdate [GET]");
	
		//파라미터에서 글번호 가져오기 가져오기
		NoticeBoard noticeNo = noticeinquiriesService.getdataforselect(req);
		
		//글번호로 글 가져와서 보여주기
		
		NoticeBoard update =  noticeinquiriesService.getUpdate(noticeNo);
		
		req.setAttribute("updatecontent", update);
		
		
		req.getRequestDispatcher("/WEB-INF/cs/notice/notice_update.jsp").forward(req, resp);
		
		
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("noticeUpdate [POST]");
		
		req.setCharacterEncoding("UTF-8");
		
		
		//파라미터에서 글번호 추출하기
		NoticeBoard noticeNum = noticeinquiriesService.getdata(req);

		//글번호로 업데이트하기 
		NoticeBoard updatenotice = noticeinquiriesService.setUpdate(noticeNum);
		

		
		resp.sendRedirect("/homett/noticelist");
		
		
		
	}

}
