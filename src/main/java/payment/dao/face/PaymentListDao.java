package payment.dao.face;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import payment.dto.Payment;
import util.PbPaging;

public interface PaymentListDao {

	
	/**
	 * 회원이 선택한 날짜에 맞춰 결제내역 조회하기
	 * @param conn -DB연결
	 * @param paging 
	 * @param userNo  - 세션에서 얻은 회원번호
	 * @param startDate - 선택한 시작날짜
	 * @param endDate -선택한 마지막 날짜
	 * @return -기간별 결제내역 조회 반환
	 */

	List<Payment> selectPayList(Connection connection, PbPaging paging, int userNo, Date start, Date end);
	
	/**
	 * 총 게시글 조회
	 * @param connection -DB 연결 객체
	 * @return -테이블의 전체 행수 
	 */
	
	
	int selectcntAll(Connection conn);



}
