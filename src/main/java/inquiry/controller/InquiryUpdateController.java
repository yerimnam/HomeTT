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


@WebServlet("/homett/inquiryupdate")
public class InquiryUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InquiryInquiriesService inquiryService = new InquiryInquiriesServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("inquiryUpdate [GET]");
		req.setCharacterEncoding("UTF-8");
		
		
		//파라미터에서 글번호 가져오기 가져오기
		InquiryBoard inquiryNo = inquiryService.getdataforselect(req);
		
		//글번호로 글 가져와서 보여주기
		
		InquiryBoard update =  inquiryService.getUpdate(inquiryNo);
		
		req.setAttribute("updatecontent", update);
		
		
		req.getRequestDispatcher("/WEB-INF/cs/inquiry/inquiryUpdate.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			System.out.println("inquiryUpdate [POST]");
	
			req.setCharacterEncoding("UTF-8");
			
			
			//파라미터에서 글번호 추출하기
			InquiryBoard inquiryNum = inquiryService.getdata(req);

			InquiryBoard updateInquiry = inquiryService.setUpdate(inquiryNum);
			

			
			resp.sendRedirect("/homett/inquirylist");
			
	}
	
	

}
