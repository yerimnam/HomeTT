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

import com.google.gson.Gson;

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
			  
//			 List<Payment> returnData = paymentService.getData (req);
//			  
//			  System.out.println(returnData);
//			  
//			  //리턴 데이터를 DTO 에 저장
//			  
////			  = paymentService.getParam(req);
////			  
//			  
//			 //추출한 값으로 insert하기
//			  Payment payinsert = paymentService.setPayment(returnData);
//			  
//			 req.setAttribute("paycomplete", payinsert);
//			
			 req.getRequestDispatcher("/WEB-INF/party/paycomplete.jsp").forward(req, resp);

		}

	
			
			
;	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		  System.out.println("/homett/paycomplete [POST]");
		  
		  //GSON 객체
	
		  
		  //1) pay에서 아임포트가 넘겨준 정보를 받아서 인서트 해야한다 -> payment db에 
		 
		  //요청 정보에서 속성 추출(ajax가 넘겨준 값으로 받기)
		  
		  //1)JSOn으로->String으로.. 
		  
		  //데이터 정의 
		  
		  
		  //파라미터 정보 추출 
//		  Payment payment = paymentService.getParam(req);
		  List<Payment>returnData = paymentService.getData (req);
		  System.out.println(returnData);
		  
		  //리턴 데이터를 DTO 에 저장
		  
//		  Payment returnData= paymentService.getParam(req);
		  
		 //추출한 값으로 insert하기
		  Payment payinsert = paymentService.setPayment(returnData);
		  
		 req.setAttribute("paycomplete", payinsert);
		  
		  
		 req.getRequestDispatcher("/WEB-INF/party/paycomplete.jsp").forward(req, resp);
		 
	}
}
