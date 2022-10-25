package partyExit.dao.face;

import java.sql.Connection;

import partyExit.dto.PartyExit;

public interface PartyExitDao {

	/**
	 * 파티방 나가기
	 * 
	 * @param conn - DB 연결 객체
	 * @param partyExit - 삭제할 파티방 정보
	 * @return delete - 수행 결과
	 */
	public int delete(Connection conn, PartyExit partyExit);

}
