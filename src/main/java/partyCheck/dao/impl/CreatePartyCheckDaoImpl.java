package partyCheck.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import partyCheck.dao.face.CreatePartyCheckDao;
import partyCheck.dto.PartyCheck;

public class CreatePartyCheckDaoImpl implements CreatePartyCheckDao {

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<PartyCheck> selectAll(Connection conn) {
		System.out.println("createPartyCheckDao selectAll() Strat");
		
		// SQL 작성
		String sql ="";
		sql += "SELECT";
		sql += "	user_no, party_name, party_leader, party_enddate, party_member, paymentamount";
		sql += " FROM party";
		sql += " ORDER BY user_no DESC";
		
		// 결과 저장 List
		List<PartyCheck> crePartyList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				PartyCheck p = new PartyCheck();
				
				p.setPartyName(rs.getString("party_name"));
				p.setPartyLeader(rs.getString("party_leader"));
				p.setPartyEnddate(rs.getDate("party_enddate"));
				p.setPartyMember(rs.getInt("party_member"));
				p.setPaymentamount(rs.getInt("paymentamount"));
				
				crePartyList.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("createPartyCheckDao selectAll() End");

		// 최종결과 반환
		return crePartyList;
	}

}
