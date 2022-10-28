package payment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import payment.dto.Payment;
import payment.service.face.PaymentService;
import payment.service.impl.PaymentServiceImpl;

@WebServlet("/homett/paycomplete")
public class PaymentCompleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	PaymentService paymentService = new PaymentServiceImpl();
			
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("/homett/paycomeplete -[GET]");
			  
			 req.getRequestDispatcher("/WEB-INF/party/paycomplete.jsp").forward(req, resp);

		}

	
			
;	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		  System.out.println("/homett/paycomplete [POST]");
		  
		  req.setCharacterEncoding("UTF-8");
		  
		  //파라미터 데이터를 DTO 에 저장
		  
		  Payment returnData= paymentService.getParam(req);
		  
		 //추출한 값으로 insert하기
		  Payment payinsert = paymentService.setPayment(returnData);
		  
		  //@@@@@@@@파티부분@@@@@@@@
		  int result = paymentService.insertParty(returnData);
		  
		  //인서트 된 값 조회해오기
		  
		 Payment payresult = paymentService.getresult(payinsert);
		  
		 req.setAttribute("paycomplete", payresult);
		  
		  
		 req.getRequestDispatcher("/WEB-INF/party/paycomplete.jsp").forward(req, resp);
		 
	}
}
