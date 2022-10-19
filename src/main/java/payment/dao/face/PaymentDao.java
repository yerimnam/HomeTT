package payment.dao.face;

import java.sql.Connection;

import party.dto.Party;
import user.dto.Member;


public interface PaymentDao {
	
	/**
	 *  유저 정보 조회하기
	 * @param conn -DB 연결
	 * @param userno -유저 번호
	 * @return -유저 정보 조회 결과 
	 */
	

	public Member selectUserInfo(Connection conn, int userno);
	
	/**
	 * 파티 정보 조회하기
	 * 
	 * @param connection -DB연결
	 * @param partyno -파티 번호
	 * @return Party 파티 정보 조회 결과 
	 */

	public Party selectPartyInfo(Connection conn, int partyno);	

}
