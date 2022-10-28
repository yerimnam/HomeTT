package main.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import main.dao.face.MainDao;
import party.dto.Party;

public class MainDaoImpl implements MainDao {
	private PreparedStatement ps;
	private ResultSet rs; 
	
	
	@Override
	public List<Party> selectPartyList(Connection conn) {
		System.out.println("selectPartylist start");
		String sql ="";
		sql +="SELECT * FROM party";
		sql +=" ORDER BY party_no DESC  ";
		
		
		List<Party> partyList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				//DTO에 조회 정보 넣기 
				Party party= new Party();
				party.setPartyNo(rs.getInt("party_no"));
				party.setPartyRoomNo(rs.getInt("party_room_no"));
				party.setUserNo(rs.getInt("user_no"));
				party.setPartyKind(rs.getString("party_kind"));
				party.setPartyRule(rs.getString("party_rule"));
				party.setPaymentAmount(rs.getInt("paymentamount"));
				party.setPartyPeriod(rs.getDate("party_period"));
				party.setPartyMember(rs.getInt("party_member"));
				party.setBoardCano(rs.getInt("board_cano"));
				party.setPartyCreDate(rs.getDate("party_credate"));
				party.setPartyEndDate(rs.getDate("party_enddate"));
				party.setPartyName(rs.getString("party_name"));
				party.setPartyLeader(rs.getString("party_leader"));
				party.setOttId(rs.getString("ott_id"));
				party.setOttPw(rs.getString("ott_pw"));
				party.setPartyNotice(rs.getString("party_notice"));
				
				
				partyList.add(party);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
			
		}
		
		
		System.out.println("selectPartylist end");
		return partyList;
	}

}
