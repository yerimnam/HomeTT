package partyCheck.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import partyCheck.dao.face.PartyCheckDao;
import partyCheck.dto.PartyCheck;
import util.Paging;

public class PartyCheckDaoImpl implements PartyCheckDao {

	// SQL 수행 객체
	private PreparedStatement ps;
	// SQL 조회 결과 객체
	private ResultSet rs;
	
	
	@Override
	public List<PartyCheck> selectAll(Connection conn) {
		System.out.println("PartyCheckDao selectAll() - start");
		
		// SQL 작성
		String sql = "";
		sql += "SELECT";
		sql += "	party_no, user_no, party_kind, party_name";
		sql += "	, party_leader, party_enddate, party_credate";
		sql	+= "	, party_member, paymentamount";
		sql += " FROM party";
		sql += " ORDER BY user_no DESC";
		
		// 결과 저장 List
		List<PartyCheck> partyList = new ArrayList<>();
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			// SQL 수행 및 결과 집합 저장
			rs = ps.executeQuery();
			
			// 조회 결과 처리
			while(rs.next()) {
				PartyCheck p = new PartyCheck(); // 조회결과 행 저장 DTO객체
				
				p.setPartyNo(rs.getInt("party_no"));
				p.setUserNo(rs.getInt("user_no"));
				p.setPartyKind(rs.getString("party_kind"));
				p.setPartyName(rs.getString("party_name"));
				p.setPartyLeader(rs.getString("party_leader"));
				p.setPartyEnddate(rs.getDate("party_enddate"));
				p.setPartyCredate(rs.getDate("party_credate"));
				p.setPartyMember(rs.getInt("party_member"));
				p.setPaymentamount(rs.getInt("paymentamount"));
				
				// 리스트에 결과값 저장
				partyList.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("PartyCheckDao selectAll() - end");
		return partyList;
	}


	@Override
	public int selectCntAll(Connection conn) {
		System.out.println("PartyCheckDao selectCntAll() - start");
		
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM party";
		
		// 총 파티수 저장 변수
		int count = 0;
			
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			// SQL 수행 및 결과 집합 저장
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				count = rs.getInt("cnt");
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("PartyCheckDao selectCntAll() - end");
		return count;
	}


	@Override
	public List<PartyCheck> selectAll(Connection conn, Paging paging) {
		System.out.println("PartyCheckDao selectAll(paging) - start");
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, P.* FROM (";
		sql += "		SELECT";
		sql += "			party_no, user_no, party_kind, party_name";
		sql += "			, party_leader, party_enddate, party_credate";
		sql	+= "			, party_member, paymentamount";
		sql += "		FROM party";
		sql += "		ORDER BY party_no DESC";
		sql += "	) P";
		sql += " ) PARTY";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 저장 List
		List<PartyCheck> partyList = new ArrayList<>();
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			// SQL 수행 및 결과 집합 저장
			rs = ps.executeQuery();
			
			// 조회 결과 처리
			while(rs.next()) {
				PartyCheck p = new PartyCheck(); // 조회결과 행 저장 DTO객체
				
				p.setPartyNo(rs.getInt("party_no"));
				p.setUserNo(rs.getInt("user_no"));
				p.setPartyKind(rs.getString("party_kind"));
				p.setPartyName(rs.getString("party_name"));
				p.setPartyLeader(rs.getString("party_leader"));
				p.setPartyEnddate(rs.getDate("party_enddate"));
				p.setPartyCredate(rs.getDate("party_credate"));
				p.setPartyMember(rs.getInt("party_member"));
				p.setPaymentamount(rs.getInt("paymentamount"));
				
				// 리스트에 결과값 저장
				partyList.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("PartyCheckDao selectAll(paging) - end");
		return partyList;
		
		
	}

}
