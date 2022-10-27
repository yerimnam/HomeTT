package payment.controller;

import java.io.IOException;
import java.util.List;

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
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/payamount[GET] - 결제 창");
		//세션 형성  ->세션에서 id get->속성으로 넣기
		 req.setCharacterEncoding("UTF-8");
		  HttpSession session =req.getSession();

				//테스트 데이터
//				session.setAttribute("user_no", 2);
//				session.setAttribute("partyNo", 1);

				
		  //테스트 데이터
//				session.setAttribute("user_no", 2);
//				session.setAttribute("partyNo", 1);
				System.out.println("파티넘버 : " + session.getAttribute("partyNo"));
				System.out.println("유저번호 : " + session.getAttribute("userNo"));
				
				int userno = Integer.parseInt(String.valueOf(session.getAttribute("userNo"))); 
				int partyno  = Integer.parseInt(String.valueOf(session.getAttribute("partyNo"))); 
				
				//로그인한 사람의 정보 조회
				System.out.println("info 전"); 
				Member user = paymentService.getuserinfo(userno);
				System.out.println("info 후");
				
				//결제하기 위한 파티 정보 조회 
				Party partyInfo = paymentService.getpartyNo(partyno);
				
				//테스트 콘솔 출력 
//				System.out.println(user);
//				System.out.println(partyinfo);
			
				req.setAttribute("userinfo", user);
				req.setAttribute("partyinfo", partyInfo);
		  
		req.getRequestDispatcher("/WEB-INF/party/pay.jsp").forward(req, resp);

		  

		}
	
	
//	//결제하기 눌렀을 때 여기다가 작성!
	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		  System.out.println("/homett/payamount [POST]");
		  

	
		  
		  req.getRequestDispatcher("/WEB-INF/party/paycomplete.jsp").forward(req, resp);
		  
	  }
	}

