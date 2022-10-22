package payment.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import common.JDBCTemplate;
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
	public List<Payment> getData(HttpServletRequest req) {

		
		
		//정보들을 담을 map
		List<Payment> payInfoList = new ArrayList<>();
		
		
		
		// ajax에서 보낸 json 정보 -> Payment객체로 언마샬링 
		//Gson 객체
		Gson gson = new Gson();
		Payment pay_no = gson.fromJson("imp_uid", Payment.class); //결제번호
	    
		//주문번호 나중에 추가하기
		Payment payamount = (Payment)gson.fromJson("paid_amount",Payment.class); //결제금액
		Payment party_no = (Payment)gson.fromJson("party_no", Payment.class); //파티넘
		Payment paymentMethod = (Payment)gson.fromJson("pay_method", Payment.class);
		Payment user_no = (Payment)gson.fromJson("user_no", Payment.class); //유저번호 
		Payment user_email = (Payment)gson.fromJson("user_no", Payment.class);// 유저 이메일
		Payment user_name = (Payment)gson.fromJson("user_name", Payment.class); //유저 이름
		Payment user_phone = (Payment)gson.fromJson("user_phone", Payment.class); //유저 전화번호 

	
		System.out.println("정보 출력 ----");
		System.out.println("결제 번호 : " +pay_no);
		System.out.println("결제 금액 : " +payamount);
		System.out.println("결제 수단 : " +paymentMethod);
		System.out.println("유저 번호 : " +user_no);
		System.out.println("유저 이메일 : " +user_email);
		System.out.println("유저 이름 : " +user_name);
		System.out.println("유저 전화번호  : " +user_phone);
		
		payInfoList.add(pay_no);
		payInfoList.add(payamount);
		payInfoList.add(party_no);
		payInfoList.add(paymentMethod);
		payInfoList.add(user_no);
		payInfoList.add(user_email);
		payInfoList.add(user_name);
		payInfoList.add(user_phone);
		
		
		return payInfoList;
	}
////
	
//	@Override
//	public Payment getParam(HttpServletRequest req) {
//		
//		
//		Payment payment = new Payment();
//		payment.setPayNo(req.getParameter("imp_uid"));
////		payment.setPayNo( req.getParameter("imp_uid"));
//		payment.setPaymentAmount(Integer.parseInt( req.getParameter("paid_amount")));
////		payment.setUserNo(Integer.parseInt(req.getParameter(" user_no")));
////		payment.setPartyNo(Integer.parseInt(req.getParameter("party_no")));
//		payment.setPaymentMethod(req.getParameter("pay_method"));
//		//있는 것만 넣고 팀원과 상의해서 이메일, 이름 전화번호 넣기 
//
//return payment;
//	}

	@Override
	public Payment setPayment(List<Payment> returnData) {

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
	
	
}
