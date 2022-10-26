package admin.cs.inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.cs.inquiry.dto.Inquiry;
import admin.cs.inquiry.service.face.AdInquiryListService;
import admin.cs.inquiry.service.impl.AdInquiryListServiceImpl;

@WebServlet("/homett/adinquirydelete")
public class AdInquiryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private AdInquiryListService adInquiryListService = new AdInquiryListServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Inquiry inquiry = adInquiryListService.getInquiryno(req);
		
		adInquiryListService.delete(inquiry);
		
		resp.sendRedirect("/homett/adinquirylist");
		
	}
		
}
