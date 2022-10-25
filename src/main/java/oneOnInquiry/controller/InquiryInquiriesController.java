package oneOnInquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1:1문의 조회
@WebServlet("/homett/inquirylist")
public class InquiryInquiriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			System.out.println("/homett/inquiryList [GET] ");
			
			
			
			//1)로그인 안되어 있으면 로그인 페이지로 리다이렉트
			
			//2)로그인 되어 있으면 세션에서 회원번호 가져와서 조회 화면 보여주기 
			
			
			
	
	}
}
