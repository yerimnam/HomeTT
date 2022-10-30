package admin.party.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.party.dao.face.AdPartyListDao;
import admin.party.dto.Party;
import admin.report.dto.Report;
import common.JDBCTemplate;
import util.Paging;

public class AdPartyListDaoImpl implements AdPartyListDao {
	
	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	
	@Override
	public List<Party> selectAll(Connection conn, Paging paging) {
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, P.* FROM (";
		sql += "		SELECT * FROM party";
		sql += "		ORDER BY party_no DESC";
		sql += "	) P";
		sql += " ) PARTY";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Party> partyList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Party p = new Party(); 
				
				p.setPartyNo(rs.getInt("party_no"));
				p.setUserNo(rs.getInt("user_no"));
				p.setPartyRoomNo(rs.getInt("party_room_no"));
				p.setPartyKind(rs.getString("party_kind"));
				p.setPartyRule(rs.getString("party_rule"));
				p.setPaymentAmount(rs.getInt("paymentAmount"));
				p.setPartyPeriod(rs.getDate("party_period"));
				p.setPartyMember(rs.getInt("party_member"));
				p.setBoardCano(rs.getInt("board_cano"));
				p.setPartyCreDate(rs.getDate("party_creDate"));
				p.setPartyEndDate(rs.getDate("party_endDate"));
				p.setPartyName(rs.getString("party_name"));
				p.setPartyLeader(rs.getString("party_leader"));
				p.setOttId(rs.getString("ott_id"));
				p.setOttPw(rs.getString("ott_pw"));
				p.setPartyNotice(rs.getString("party_notice"));
				
				partyList.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return partyList;
	}

	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM party";
		
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return count;
	}

//	@Override
//	public Party selectPartyByPartyno(Connection conn, Party partyno) {
//		
//		String sql = "";
//		sql += "SELECT * FROM party";
//		sql += " WHERE party_no = ?";
//		
//		Party party = null;
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, partyno.getPartyNo());
//			
//			rs = ps.executeQuery();
//			
//			while( rs.next() ) {
//				party = new Party();
//				
//				party.setPartyNo(rs.getInt("party_no"));
//				party.setUserNo(rs.getInt("user_no"));
//				party.setPartyRoomNo(rs.getInt("party_room_no"));
//				party.setPartyKind(rs.getString("party_kind"));
//				party.setPartyRule(rs.getString("party_rule"));
//				party.setPaymentAmount(rs.getInt("paymentAmount"));
//				party.setPartyPeriod(rs.getDate("party_period"));
//				party.setPartyMember(rs.getInt("party_member"));
//				party.setBoardCano(rs.getInt("board_cano"));
//				party.setPartyCreDate(rs.getDate("party_creDate"));
//				party.setPartyEndDate(rs.getDate("party_endDate"));
//				party.setPartyName(rs.getString("party_name"));
//				party.setPartyLeader(rs.getString("party_leader"));
//				party.setOttId(rs.getString("ott_id"));
//				party.setOttPw(rs.getString("ott_pw"));
//				party.setPartyNotice(rs.getString("party_notice"));
//				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		return party;
//	}

	@Override
	public List<Party> selectSearchList(Connection conn, Paging paging, String searchType, String keyword) {
//		System.out.println("selectSearchList searchpaging 시작" + paging);
		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, P.* FROM (";
		sql += " 		SELECT * FROM party";
		sql += " 		WHERE " + searchType + " LIKE ?";
		sql += " 		ORDER BY party_no DESC";
		sql += " 		) P";
		sql += " 	) PARTY";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Party> partyList = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Party p = new Party();
				
				p.setPartyNo(rs.getInt("party_no"));
				p.setUserNo(rs.getInt("user_no"));
				p.setPartyRoomNo(rs.getInt("party_room_no"));
				p.setPartyKind(rs.getString("party_kind"));
				p.setPartyRule(rs.getString("party_rule"));
				p.setPaymentAmount(rs.getInt("paymentAmount"));
				p.setPartyPeriod(rs.getDate("party_period"));
				p.setPartyMember(rs.getInt("party_member"));
				p.setBoardCano(rs.getInt("board_cano"));
				p.setPartyCreDate(rs.getDate("party_creDate"));
				p.setPartyEndDate(rs.getDate("party_endDate"));
				p.setPartyName(rs.getString("party_name"));
				p.setPartyLeader(rs.getString("party_leader"));
				p.setOttId(rs.getString("ott_id"));
				p.setOttPw(rs.getString("ott_pw"));
				p.setPartyNotice(rs.getString("party_notice"));
				
				partyList.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
//		System.out.println("selectSearchList searchpaging 끝" + paging);
//		System.out.println("selectSearchList()" + reportList);
		return partyList;
	}
	
	@Override
	public int selectSearchCntAll(Connection conn, String searchType, String keyword) {
//		System.out.println("selectSearchCntAll 시작" + searchType + keyword);
		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM (";
		sql += "	SELECT rownum rnum, P.* FROM (";
		sql += "		SELECT * FROM party";
		sql += "		WHERE " + searchType + " LIKE ?";
		sql += "		) P";
		sql += "	) PARTY";
		
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);

			rs = ps.executeQuery();

			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
//		System.out.println("selectSearchCntAll 끝" + searchType + keyword);
//		System.out.println("selectSearchCntAll" + count);
		return count;
	}
	
}
