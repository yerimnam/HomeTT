package payment.dao.face;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import party.dto.Party;
import payment.dto.Payment;
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
	 * @return Party 파티 정보 조회 결과 
	 */
	public Party selectPartyInfo(Connection conn, int partyno);

	
	/**
	 * DTO 정보를 DB에 삽입 
	 * @param conn -DB연결
	 * @param payment - DTO 정보 
	 * @return 인서트 결과
	 */
	

	public int insertPayment(Connection conn, Payment returnData);

	
	/**
	 * 인서트 된 정보 조회해오기
	 * @param conn -DB 연결
	 * @return
	 */
	public Payment selectpayresult(Connection conn, Payment payinsert);

	
	//@@@@@@파티부분@@@@@@@
	public int insertPartyM(Connection conn, Payment returnData);


	
	

}
