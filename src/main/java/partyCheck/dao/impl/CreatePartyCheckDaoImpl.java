package partyCheck.dao.impl;

import java.sql.Connection;
import java.util.List;

import partyCheck.dao.face.CreatePartyCheckDao;
import partyCheck.dto.PartyCheck;

public class CreatePartyCheckDaoImpl implements CreatePartyCheckDao {
	

	@Override
	public List<PartyCheck> selectAll(Connection connection) {
		System.out.println("createPartyCheckDao selectAll() Strat");
		
		// SQL 작성
		String sql ="";
		sql += "SELECT";
		sql += "";
		
		return null;
	}

}
