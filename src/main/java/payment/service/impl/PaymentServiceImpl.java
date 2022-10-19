package payment.service.impl;

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

}
