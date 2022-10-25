package party.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import party.dao.face.JoinPartyDao;
import party.dto.Party;

public class JoinPartyDaoImpl implements JoinPartyDao {
	
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public int insert(Connection conn, Party party) {
		
		String sql = "";
		sql += "INSERT INTO party( party_kind, party_name, party_room_no)";
		sql += "	,party_leader, party_endDate, party_member, paymentAmount";
		sql += "	VALUES ( ?, ?, ?, ?, ?, ?, ?)";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, party.getPartyKind());
			ps.setString(2, party.getPartyName());
			ps.setInt(3, party.getPartyRoomNo());
			ps.setString(4, party.getPartyLeader());
			ps.setDate(5, (Date) party.getPartyEndDate());
			ps.setInt(6, party.getPartyMember());
			ps.setInt(7, party.getPaymentAmount());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

}
