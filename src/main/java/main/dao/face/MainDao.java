package main.dao.face;

import java.sql.Connection;
import java.util.List;

import party.dto.Party;

public interface MainDao {
	
	/**
	 * 
	 * 현재 열린 파티 목록 전체 조회
	 * @param connection -DB연결
	 * @return - 현재 열림 파티 목록 전체 조회
	 */

	List<Party> selectPartyList(Connection conn);

}
