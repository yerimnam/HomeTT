package payment.service.face;


import java.sql.Date;
import java.util.List;

import payment.dto.Payment;

public interface PaymentListServcie {

	
	/**
	 *  회원의 결제내역을 기간별로 조회하기 
	 * @param userNo -회원번호
	 * @param startDate -설정한 시작날짜
	 * @param endDate -설정한 마지막 날짜
	 * @return 기가별 조회된 결제내역 리스트 
	 */
	
	List<Payment> getPaymentList(int userNo, Date startDate, Date endDate);

}
