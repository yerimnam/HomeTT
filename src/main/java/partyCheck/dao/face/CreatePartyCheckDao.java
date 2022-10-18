package partyCheck.dao.face;

import java.sql.Connection;
import java.util.List;

import partyCheck.dto.PartyCheck;

public interface CreatePartyCheckDao {

	/**
	 * 
	 * @param connection
	 * @return
	 */
	List<PartyCheck> selectAll(Connection connection);

}
