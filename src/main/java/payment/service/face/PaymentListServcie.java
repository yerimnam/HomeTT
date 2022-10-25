package payment.service.face;





import java.util.Date;
import java.util.List;

import payment.dto.Payment;

public interface PaymentListServcie {
	
	
	/**
	 * 
	 * 시작 날짜 yyyyMMdd 형식으로 변환
	 * @param startDate -입력된시작날짜
	 * @return -형식으로 변환된 날짜
	 */

	Date changestart(String startDate);
	
	
	Date changeend(String endDate);

	/**
	 *  회원의 결제내역을 기간별로 조회하기 
	 * @param userNo -회원번호
	 * @param start -설정한 시작날짜
	 * @param end -설정한 마지막 날짜
	 * @return 기가별 조회된 결제내역 리스트 
	 */
	
	List<Payment> getPaymentList(int userNo,Date start, Date end);





}
