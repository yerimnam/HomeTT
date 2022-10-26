package admin.cs.inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.cs.inquiry.dto.Inquiry;
import admin.cs.inquiry.service.face.AdInquiryListService;
import admin.cs.inquiry.service.impl.AdInquiryListServiceImpl;

@WebServlet("/homett/adinquirywrite")
public class AdInquiryWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private AdInquiryListService adInquiryListService = new AdInquiryListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession session = req.getSession();
		//adminNo 테스트 데이터
//		session.setAttribute("adminNo", 2);
//		int adminNo = (int)session.getAttribute("adminNo");
		
		Inquiry inquiryno = adInquiryListService.getInquiryno(req);
		Inquiry viewinquiry = adInquiryListService.view( inquiryno );
		req.setAttribute("viewinquiry", viewinquiry);
		
		req.getRequestDispatcher("/WEB-INF/admin/cs/inquiry/admininquirywrite.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		int inquiryArticleNumber = Integer.parseInt(req.getParameter("inquiry_articleNumber"));
//		Inquiry inquiryno = adInquiryListService.getInquiryno(req);
//		String inquiryArticleNumber = req.getParameter("inquiry_articleNumber");
//		System.out.println("inquiryno" + inquiryArticleNumber);
//		String answerWriter = req.getParameter("answer_writer");
//		String answerContent = req.getParameter("answer_content");
		
		//답변글 삽입
		adInquiryListService.writeAnswer(req);
		
		//목록으로 리다이렉트
		resp.sendRedirect("/homett/adinquirylist");
		
	}
	
}
