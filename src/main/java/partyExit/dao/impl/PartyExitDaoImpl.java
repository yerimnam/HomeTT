package partyExit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import partyExit.dao.face.PartyExitDao;
import partyExit.dto.PartyExit;

public class PartyExitDaoImpl implements PartyExitDao {

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int delete(Connection conn, PartyExit partyExit) {
		
		String sql = "";
		sql += "DELETE party";
		sql += " WHERE party_no = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, partyExit.getPartyNo());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);	
		}
		
		return res;
	}

}
