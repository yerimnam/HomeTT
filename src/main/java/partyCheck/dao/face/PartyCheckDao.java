package partyCheck.dao.face;

import java.sql.Connection;
import java.util.List;

import partyCheck.dto.PartyCheck;

public interface PartyCheckDao {
	
	/**
	 * 파티 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<PartyCheck> - 테이블 전체 조회 목록
	 */
	public List<PartyCheck> selectAll(Connection conn);

}
