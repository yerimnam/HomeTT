package payment.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coupon.dto.Coupon;
import party.dto.Party;
import payment.service.face.PaymentService;
import payment.service.impl.PaymentServiceImpl;
import user.dto.Member;

/**
 * Servlet implementation class PaymentCalController
 */
@WebServlet("/homett/paymodule")
public class PaymentCalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	PaymentService paymentService = new PaymentServiceImpl()
;	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		  System.out.println("/homett/paymentcal [POST}");
//		  HttpSession session =req.getSession();
//		//테스트 데이터
//			session.setAttribute("user_no", 2);
////			session.setAttribute("partyNo", 1);
//			
//			
//			//실제 코드 // session 은 Strin g..
////			int userno = (int) session.getAttribute("user_no");
//			int partyno  = (int)session.getAttribute("partyNo");
//			
//			//로그인한 사람의 정보 조회
//			
//			
//			//결제하기 위한 파티 정보 조회 
//			Party partyInfo = paymentService.getpartyNo(partyno);
//			
//			//보유 쿠폰 조회하기 
//		  
//		  
//		  
//		  //쿠폰 번호 값이 담긴 list 
//		  String[] list = req.getParameterValues("couponval[]");
////		  for( String s : list )	System.out.println(s);
////		  
////		  System.out.println(list[0]);
////
////		  
////		  
////		  //사용하려고 체크한 쿠폰 번호
////		  int couponNo = Integer.parseInt(list[0]);
////		  
//		  //DB에서 쿠폰 금액 조회 (coupon_no 이용)
//		  //금액 계산 해서 반환하는 서비스 메소드 작성 (호출)
//		  //	-> 반환값은 req.setAttribute
//
////			//보유 쿠폰 조회하기 
////			List<Coupon> couponInfo = paymentService.getCouponInfo(userno);
////			
////			int couponValue = paymentService.calCoupon(couponInfo);
////
////		  
//		  req.setAttribute("payval", partyInfo);
//		  req.setAttribute("couponval", list);
//		  
		  
		  req.getRequestDispatcher("/WEB-INF/party/paymodule.jsp").forward(req, resp);
	}
}
