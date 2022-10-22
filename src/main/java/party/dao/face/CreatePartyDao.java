package party.dao.face;

import java.sql.Connection;

import party.dto.Party;
import user.dto.Member;

public interface CreatePartyDao {

	
	/**
	 * party_seq의 nextpartyno 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @return - partyno로 사용될 party_seq의 nextpartyno
	 */
	int selectNextPartyno(Connection conn);
	

	
	
	/**
	 * 
	 * @param conn
	 * @param userno
	 * @return
	 */
	Member selectUser(Connection conn, int userno);
	
	
	
	/**
	 *전달된 파라미터 값 테이블에 삽입하기
	 * 
	 * @param conn -DB 연결 객체
	 * @param party - 테이블에 삽입할 정보 객체
	 * @return INSERT 수행 결과(0이면 실패, 1이면 삽입 성공)
	 */
	int insert(Connection conn, Party party);
	
	
	
	
	

}
