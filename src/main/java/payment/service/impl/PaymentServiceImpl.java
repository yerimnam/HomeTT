package payment.service.impl;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import party.dto.Party;
import payment.dao.face.PaymentDao;
import payment.dao.impl.PaymentDaoImpl;
import payment.dto.Payment;
import payment.service.face.PaymentService;
import user.dto.Member;

public class PaymentServiceImpl implements PaymentService {
	//dao 객체
	
	private static PaymentDao paymentDao = new PaymentDaoImpl();
	
	@Override
	public Member getuserinfo(int userno) {
		System.out.println("Service getuserinfo");
		return paymentDao.selectUserInfo(JDBCTemplate.getConnection(),userno);
	}
	
	@Override
	public Party getpartyNo(int partyno) {
		return paymentDao.selectPartyInfo(JDBCTemplate.getConnection(), partyno);
	}

	 

	
	@Override
	public Payment getParam(HttpServletRequest req) {
		
		
		Payment payment = new Payment();
		payment.setPayNo(req.getParameter("imp_uid")); //결제번호
		payment.setOrderNo(req.getParameter("merchant_uid")); //주문번호
		payment.setUserNo(Integer.parseInt(req.getParameter("user_no"))); //유저번호
		payment.setPartyNo(Integer.parseInt(req.getParameter("party_no"))); //파티번호
		payment.setPaymentMethod(req.getParameter("pay_method")); //결제수단
		payment.setPaymentAmount(Integer.parseInt( req.getParameter("paid_amount"))); //결제금액
		payment.setUserCardCom(req.getParameter("card_name")); //카드 회사 
		//결제 시각은 sql에서 sysdate로 대체 
		return payment;
	}

	@Override
	public Payment setPayment(Payment returnData) {

		System.out.println("setpayment -시작 ");
		Connection conn = JDBCTemplate.getConnection();
		
		
		
		
		
		
		//DTO 정보를 db에 저장
		
		int payinsert = paymentDao.insertPayment(conn,returnData);
		
		//r결과 처리 -트랜젝셩 관리
		if(payinsert>0) {//DB삽입 성공
			System.out.println("insertPayment-성공");
			JDBCTemplate.commit(conn);
			return (Payment) returnData;
		}else {// DB삽입 실패 
			JDBCTemplate.rollback(conn);

			System.out.println("insertPayment-실패");
			return null ;
		}
		
		
	}
	
	@Override
	public Payment getresult(Payment payinsert) {
		return paymentDao.selectpayresult(JDBCTemplate.getConnection(), payinsert);
	}

	
	//@@@@@@파티부분@@@@@@@@
	@Override
	public int insertParty(Payment returnData) {
		Connection conn = JDBCTemplate.getConnection();
		
		return paymentDao.insertPartyM(conn,returnData);
	}
	
}
