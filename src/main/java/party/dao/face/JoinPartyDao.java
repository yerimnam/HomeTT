package party.dao.face;

import java.sql.Connection;

import party.dto.Party;

public interface JoinPartyDao {

	/**
	 * 파티정보 삽입
	 * 
	 * @param conn - DB연결객체
	 * @param party - 파티가입 정보 객체
	 * @return int - INSERT 수행결과
	 */
	public int insert(Connection conn, Party party);
	
	
	

}
