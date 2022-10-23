package payment.controller;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import coupon.dto.Coupon;
import party.dto.Party;
import payment.dto.Payment;
import payment.service.face.PaymentService;
import payment.service.impl.PaymentServiceImpl;
import user.dto.Member;

@WebServlet("/homett/paycomplete")
public class PaymentCompleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	PaymentService paymentService = new PaymentServiceImpl();
			
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("/homett/paycomeplete -[GET]");
	
	
			
		}

	
			
			
;	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		  System.out.println("/homett/paymentcal [POST}");
		  
		  //1) pay에서 아임포트가 넘겨준 정보를 받아서 인서트 해야한다 -> payment db에 
		 
		  //요청 정보에서 속성 추출(ajax가 넘겨준 값으로 받기)
		  
		  
		  Payment payment = paymentService.getParam(req);
//		  
		  
		 //추출한 값으로 insert하기
		  Payment payinsert = paymentService.setPayment(payment);
		  
		 req.setAttribute("paycomplete", payinsert);
		  
		  req.getRequestDispatcher("/WEB-INF/party/paycomplete.jsp").forward(req, resp);
	}
}
