package payment.service.impl;



import java.sql.Date;
import java.util.List;

import common.JDBCTemplate;
import payment.dao.face.PaymentListDao;
import payment.dao.impl.PaymentListDaoImple;
import payment.dto.Payment;
import payment.service.face.PaymentListServcie;

public class PaymentListServiceImpl implements PaymentListServcie {
	
	PaymentListDao paymentListDao = new PaymentListDaoImple();
	
	
	@Override
	public List<Payment> getPaymentList(int userNo, Date startDate, Date endDate) {
		System.out.println("getPaymentList -start");
	
		System.out.println("getPaymentList-end");
		return paymentListDao.selectPayList(JDBCTemplate.getConnection(),userNo,startDate,endDate);
	}
	
	

}
