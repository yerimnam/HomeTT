package inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import inquiry.dto.InquiryBoard;
import inquiry.service.face.InquiryInquiriesService;
import inquiry.service.impl.InquiryInquiriesServiceImpl;
import invitation.dto.Invitation;

//1:1 문의 작성
@WebServlet("/homett/inquirycreate")
public class InquiryCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체 
	InquiryInquiriesService inquiryService = new InquiryInquiriesServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/inquiertcreate [GET]");
		
		//한글 인코딩
		req.setCharacterEncoding("UTF-8");
		
		//model값 저장하여 view전달
		
		req.getRequestDispatcher("/WEB-INF/cs/inquiry/inquiryCreate.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

	//센션에서 회원번호 
		
		HttpSession session = req.getSession();
		
		//테스트용 세션
//		session.setAttribute("userNo", 24);
		
		
		//실제 작동
		int userNo = (int)session.getAttribute("userNo");
		
		
		//파라미터 추출하기 
		InquiryBoard param = inquiryService.getparam(req);
		
		//회원번호,파라미터로 게시글 저장하기
		InquiryBoard insertInquiry = inquiryService.setInquiry(param,userNo);
		
		resp.sendRedirect("/homett/inquirylist");
	
	}
}
