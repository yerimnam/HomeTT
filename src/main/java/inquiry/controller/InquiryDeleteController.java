package inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inquiry.dto.InquiryBoard;
import inquiry.service.face.InquiryInquiriesService;
import inquiry.service.impl.InquiryInquiriesServiceImpl;

/**
 * Servlet implementation class InquiryDeleteController
 */
@WebServlet("/homett/inquirydelete")
public class InquiryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InquiryInquiriesService inquiryService = new InquiryInquiriesServiceImpl();
	 @Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 System.out.println("homett/inquirtydelte [GET]");
	 
		 //파라미터에서 글번호 추출
		 InquiryBoard inquiryNo = inquiryService.getdata(req);
		 
		 //추출한 파라미터(글번호)로 삭제 
		 inquiryService.deleteInquiry(inquiryNo);
		 
		 resp.sendRedirect("/homett/inquirylist");
	 }

}
