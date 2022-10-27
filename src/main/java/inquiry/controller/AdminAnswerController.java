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


@WebServlet("/homett/adminAnswer")
public class AdminAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InquiryInquiriesService inquiryService = new InquiryInquiriesServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("homett/adminanswer [GET]");
		
	
	
	}
	
	
	//
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("homett/adminanswer [POST]");
	
	
	}
	
}
