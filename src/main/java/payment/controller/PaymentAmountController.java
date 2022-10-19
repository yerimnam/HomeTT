package payment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import party.dto.Party;
import payment.dto.Payment;
import payment.service.face.PaymentService;
import payment.service.impl.PaymentServiceImpl;
import user.dto.Member;

//결제 하기 눌렀을 때 보여줄 정보 
@WebServlet("/homett/payamount")
public class PaymentAmountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	PaymentService paymentService = new PaymentServiceImpl();
	
	//결제 창
	//파티 가입하기 누르면 나오는 창 ->결제정보도 숨겨야하므로  post로 함
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		System.out.println("/homett/payamount - 결제 창");
	
		//세션 형성  ->세션에서 id get->속성으로 넣기

		HttpSession session =req.getSession();
		//테스트 데이터
		session.setAttribute("user_no", 2);
		session.setAttribute("partyNo", 1);
		
		
		//실제 코드 // session 은 Strin g..
		int userno = (int) session.getAttribute("user_no");
		int partyno  = (int)session.getAttribute("partyNo");
		
		//로그인한 사람의 정보 조회
		
		Member user = paymentService.getuserinfo(userno);
		//결제하기 위한 파티 정보 조회 
		Party partyinfo = paymentService.getpartyNo(partyno);
		
		//테스트 콘솔 출력 
//		System.out.println(user);
//		System.out.println(partyinfo);
		
		req.setAttribute("userinfo", user);
		req.setAttribute("partyinfo", partyinfo);
		//총 계산 금액 -jsp에서 구현하면 될듯..!
//		Payment paymentAmount = paymentService.calPaymentAmount(user);
		
		
		
		req.getRequestDispatcher("/WEB-INF/party/pay.jsp").forward(req, resp);
		
	}
		
	

	//결제 버튼 눌렀을 때 doPOST로 보내기
}
