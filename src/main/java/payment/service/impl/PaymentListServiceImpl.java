package payment.service.impl;





import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import common.JDBCTemplate;
import payment.dao.face.PaymentListDao;
import payment.dao.impl.PaymentListDaoImple;
import payment.dto.Payment;
import payment.service.face.PaymentListServcie;

public class PaymentListServiceImpl implements PaymentListServcie {

	private static PaymentListDao paymentListDao = new PaymentListDaoImple();


	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	//형변환
	@Override
	public Date changestart(String startDate) {

		Date start = null;

		//String ->Date로 형 변환
		try {
			start = format.parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		} 

		return start;
	}

	//형변환
	@Override
	public Date changeend(String endDate) {

		Date end = null;

		try {
			end = format.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return end;

	}



	//리스트 얻기 
	@Override
	public List<Payment> getPaymentList(int userNo, Date start, Date end) {
		System.out.println("getPaymentList -start");

		System.out.println("getPaymentList-end");
		return paymentListDao.selectPayList(JDBCTemplate.getConnection(),userNo,start,end);
	}



}
