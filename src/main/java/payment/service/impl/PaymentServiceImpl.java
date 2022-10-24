package payment.service.impl;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import coupon.dto.Coupon;
import party.dto.Party;
import payment.dao.face.PaymentDao;
import payment.dao.impl.PaymentDaoImpl;
import payment.dto.Payment;
import payment.service.face.PaymentService;

import user.dto.Member;

public class PaymentServiceImpl implements PaymentService {
	//dao 객체
	
	PaymentDao paymentDao = new PaymentDaoImpl();
	
	@Override
	public Member getuserinfo(int userno) {
		return paymentDao.selectUserInfo(JDBCTemplate.getConnection(),userno);
	}
	
	@Override
	public Party getpartyNo(int partyno) {
		return paymentDao.selectPartyInfo(JDBCTemplate.getConnection(), partyno);
	}

		
	@Override
	public Payment getParam(HttpServletRequest req) {
		
		//요청 정보 꺼내서  DTO 저장
		
				Payment payment = new Payment();
				
				payment.setPayNo(Integer.parseInt( req.getParameter("imp_uid")));
				payment.setPaymentAmount(Integer.parseInt(req.getParameter("paid_amount")));
				payment.setUserNo(Integer.parseInt(req.getParameter(" user_no")));
				payment.setPartyNo(Integer.parseInt(req.getParameter("party_no")));
				payment.setPaymentMethod(req.getParameter("pay_method"));
				//있는 것만 넣고 팀원과 상의해서 이메일, 이름 전화번호 넣기 
		
		return payment;
	}
	
 
	@Override
	public Payment setPayment(Payment payment) {

		System.out.println("setpayment -시작 ");
		Connection conn = JDBCTemplate.getConnection();
		
		
		
		
		
		//DTO 정보를 db에 저장
		
		int payinsert = paymentDao.insertPayment(conn,payment);
		
		//r결과 처리 -트랜젝셩 관리
		if(payinsert>0) {//DB삽입 성공
			System.out.println("insertPayment-성공");
			JDBCTemplate.commit(conn);
			return payment;
		}else {// DB삽입 실패 
			JDBCTemplate.rollback(conn);

			System.out.println("insertPayment-실패");
			return null ;
		}
		
		
	}
}
