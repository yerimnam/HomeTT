package inquiry.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import inquiry.dto.InquiryBoard;
import inquiry.service.face.InquiryInquiriesService;
import inquiry.service.impl.InquiryInquiriesServiceImpl;
import util.Paging;


//1:1문의 조회
@WebServlet("/homett/inquirylist")
public class InquiryInquiriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private  InquiryInquiriesService inquiryService = new InquiryInquiriesServiceImpl();
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			System.out.println("/homett/inquiryList [GET] ");
			//한글 인코딩 설정
			req.setCharacterEncoding("UTF-8");
			
			//세션에서 회원 번호 얻어오기
			
			HttpSession session = req.getSession();
			//테스트를 위한 임의 번호 넣기 
			session.setAttribute("user_no", 2);
			
			//session 회원 번호 얻어오기 thr
			int userNo = (int) session.getAttribute("user_no");
			
			
			//전달 파라미터에서 현재 페이징 객체 계산하기
			Paging paging = inquiryService.getPaging(req,userNo);
			System.out.println("[TEST]" + paging);
			
			
			//페이징 객체를 model값 전달
			
			req.setAttribute("paging", paging);
			
			
			//조회결과 반환 list 
			List<InquiryBoard> inquiry =null;
			// 되어 있으면 세션에서 회원번호 가져와서 조회 화면 보여주기 
			if( userNo > 0 ) {
				
			inquiry = inquiryService.getinquiry(userNo,paging);
				
			}else {
//				// 로그인 안되어있으면 로그인 페이지로 리다이렉트
				resp.sendRedirect("/homett/login");
//				
			}
//			
			//제목으로 조회하기 구현하기 
			
			System.out.println(inquiry);
			req.setAttribute("inquiryview", inquiry);
			
			
			req.getRequestDispatcher("/WEB-INF/cs/inquiry/inquiryList.jsp").forward(req, resp);
	
	}
}
