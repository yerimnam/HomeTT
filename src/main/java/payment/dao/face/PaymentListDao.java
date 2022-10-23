package payment.dao.face;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import payment.dto.Payment;

public interface PaymentListDao {

	
	/**
	 * 회원이 선택한 날짜에 맞춰 결제내역 조회하기
	 * @param conn -DB연결
	 * @param userNo  - 세션에서 얻은 회원번호
	 * @param startDate - 선택한 시작날짜
	 * @param endDate -선택한 마지막 날짜
	 * @return -기간별 결제내역 조회 반환
	 */
	List<Payment> selectPayList(Connection conn, int userNo, Date startDate, Date endDate);

}
