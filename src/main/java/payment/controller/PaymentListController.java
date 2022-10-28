package payment.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import payment.dto.Payment;
import payment.service.face.PaymentListServcie;
import payment.service.impl.PaymentListServiceImpl;
import util.PbPaging;


@WebServlet("/homett/paymentlist")
public class PaymentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static PaymentListServcie paymentListService = new PaymentListServiceImpl();
	
	//mypage에서 결제내역 조회하기 누렀을 때 요청을 받음 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/paymentList - [GET]");
		req.setCharacterEncoding("UTF-8");
		
		 
		
		HttpSession session = req.getSession();
		//테스트로 넣을 userno =2번 데이터


		session.setAttribute("userNo",24);  
//		session.setAttribute("user_no",2);  


		
		//실제로 작동 될 코드 
		int userNo = Integer.parseInt(String.valueOf(session.getAttribute("userNo"))); 
			
		
		
//		String startDate = req.getParameter("startdate");
//		String endDate = req.getParameter("enddate");
		
//		Date start = paymentListService.changestart(startDate);
//		Date end = paymentListService.changeend(endDate);

		Date start = paymentListService.changeDate(req, "start");
		Date end = paymentListService.changeDate(req, "end");

		System.out.println(start);
		System.out.println(end);
		
		
		//전달파라미터에서 현재 페이징 객체 계산하기
		PbPaging paging = paymentListService.getPaging(req, userNo, start, end);
		
		//페이징 객체를 MODEL값 전달
		req.setAttribute("paging", paging);
		System.out.println(paging);
		
		
		
		//기간과 이름을 으로 게시글 조회
		List<Payment> paymentList = paymentListService.getPaymentList(paging,userNo,start,end);

//		for( Payment p : paymentList )	System.out.println(p.getOrderNo() + " : " + p.getPartyNo());
		
		//model값을 view로 보내기
		req.setAttribute("paymentList", paymentList);

		
		
//		System.out.println(paymentList);
		req.getRequestDispatcher("/WEB-INF/mypage/paymentList.jsp").forward(req, resp);
	
	}
	
	


}
