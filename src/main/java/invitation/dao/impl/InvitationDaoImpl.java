package invitation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import invitation.dao.face.InvitationDao;
import invitation.dto.Invitation;

public class InvitationDaoImpl implements InvitationDao {

	// SQL수행 객체
	private PreparedStatement ps;
	// SQL조회 결과 객체
	private ResultSet rs;
	
	@Override
	public Invitation selectInvitationByPartyno(Connection conn, Invitation partyNo) {

		// SQL구문 작성
		String sql = "";
		sql += "SELECT";
		sql += "	party_no, user_no";
		sql += " FROM invitation";
		sql += " WHERE party_no = ?";
		
		Invitation invitation = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, partyNo.getPartyNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				invitation = new Invitation();
				
				invitation.setPartyNo(rs.getInt("party_no"));
				invitation.setUserNo(rs.getInt("user_no"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return invitation;
	}

}
