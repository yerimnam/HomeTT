package payment.service.impl;

import common.JDBCTemplate;
import member.dto.Member;
import payment.dao.face.PaymentDao;
import payment.dao.impl.PaymentDaoImpl;
import payment.dto.Payment;
import payment.service.face.PaymentService;

public class PaymentServiceImpl implements PaymentService {
	//dao 객체
	
	PaymentDao paymentDao = new PaymentDaoImpl();
	
	@Override
	public Payment getuserinfo(int userno) {
		return paymentDao.selectUserInfo(JDBCTemplate.getConnection(),userno);
	}

}
