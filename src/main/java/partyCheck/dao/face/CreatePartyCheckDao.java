package partyCheck.dao.face;

import java.sql.Connection;
import java.util.List;

import partyCheck.dto.PartyCheck;

public interface CreatePartyCheckDao {

	/**
	 * 파티방 테이블 전제 조회
	 * 
	 * @param connection - DB 연결 객체
	 * @return List<Partycheck> - 테이블 전체 조회 목록
	 */
	List<PartyCheck> selectAll(Connection connection);

}
