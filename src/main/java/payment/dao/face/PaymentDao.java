package payment.dao.face;

import java.sql.Connection;

import member.dto.Member;
import payment.dto.Payment;

public interface PaymentDao {
	
	/**
	 *  유저 정보 반환하기
	 * @param conn -DB 연결
	 * @param userno -유저 번호
	 * @return -유저 정보 조회 결과 
	 */
	

	public Payment selectUserInfo(Connection conn, int userno);	

}
