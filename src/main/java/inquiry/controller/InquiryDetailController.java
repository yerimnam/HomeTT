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


@WebServlet("/homett/inquirydetail")
public class InquiryDetailController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	//서비스
	InquiryInquiriesService inquiryService = new InquiryInquiriesServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("inquirydtail -[GET]");
		
		req.setCharacterEncoding("UTF-8");
		
		//세션에서 회원 번호 얻어오기
		
		HttpSession session = req.getSession();
		//테스트를 위한 임의 번호 넣기 
		session.setAttribute("user_no", 2);
		
		//session 회원 번호 얻어오기 thr
		int userNo = (int) session.getAttribute("user_no");
		
		//파라미터에서 클릭한 글 제목 얻어 오기
		InquiryBoard inquiryTitle = inquiryService.getTitle(req);
		
		
		//글 상세 보기 
		InquiryBoard inquiryDetail = inquiryService.getDetail(userNo, inquiryTitle);
		
		System.out.println(inquiryDetail.getInquiryDate());
		//MODEL값 저장
		req.setAttribute("inquiryDetail", inquiryDetail);
		
		req.getRequestDispatcher("/WEB-INF/cs/inquiry/inquirydetail.jsp").forward(req, resp);
	}
	
}
