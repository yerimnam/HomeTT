package payment.service.impl;

import java.util.List;

import common.JDBCTemplate;
import coupon.dto.Coupon;
import party.dto.Party;
import payment.dao.face.PaymentDao;
import payment.dao.impl.PaymentDaoImpl;

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
	public List<Coupon> getCouponInfo(int userno) {
		return paymentDao.selectCouponInfo(JDBCTemplate.getConnection(),userno);
	}
	
	@Override
	public int getcntCoupon(int userno) {
		return paymentDao.cntCoupon(JDBCTemplate.getConnection(),userno);
	}

}
