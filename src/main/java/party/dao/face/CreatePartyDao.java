package party.dao.face;

import java.sql.Connection;

import party.dto.Party;

public interface CreatePartyDao {

	
	/**
	 * 
	 * @param conn
	 * @param party
	 * @return
	 */
	int insert(Connection conn, Party party);
	
	
	int selectNextUserno(Connection conn);
	

}
