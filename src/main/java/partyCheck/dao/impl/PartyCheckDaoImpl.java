package partyCheck.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import partyCheck.dao.face.PartyCheckDao;
import partyCheck.dto.MypageMember;
import partyCheck.dto.PartyCheck;
import user.dto.Member;
import util.Paging5;

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
	public List<PartyCheck> selectAll(Connection conn, Paging5 paging5) {
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
		sql += "	) P";
		sql += " ) PARTY";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 저장 List
		List<PartyCheck> partyList = new ArrayList<>();
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging5.getStartNo());
			ps.setInt(2, paging5.getEndNo());
			
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


	@Override
	public int delete(Connection conn, PartyCheck partyCheck) {

		String sql = "";
		sql += "DELETE party";
		sql += " WHERE party_no = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, partyCheck.getPartyNo());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		
		return res;
	}


	@Override
	public List<PartyCheck> selectOwner(Connection conn) {

		System.out.println("PartyCheckDao selectOwner() - start");
		
		// SQL 작성
		String sql = "";
		sql += "SELECT";
		sql += "	p.party_no, p.user_no, p.party_kind, p.party_name";
		sql += "	, p.party_leader, p.party_enddate, p.party_credate";
		sql	+= "	, p.party_member, p.paymentamount, m.user_no";
		sql += " FROM party p, member m";
		sql += " WHERE p.user_no = m.user_no";
		
		// 결과 저장 List
		List<PartyCheck> ownerPartyList = new ArrayList<>();
		
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
				ownerPartyList.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("PartyCheckDao selectOwner() - end");
		return ownerPartyList;
	}

	@Override
	public Member selectMemberInfo(Connection conn, MypageMember mypageMember) {

		System.out.println("MyPageDao selectLoginInfo() - 시작");
		
		String sql = "";
		sql += "SELECT user_no, master_no, user_id, user_pw, user_name, user_nick,";
		sql += " user_email, user_phone FROM member";
		sql += " WHERE user_id = ?";
		
		Member result = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mypageMember.getUserId());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new Member();
				
				result.setUserNo( rs.getInt("user_no") );
				result.setMasterNo( rs.getInt("master_no") );
				result.setUserId( rs.getString("user_id") );
				result.setUserPw( rs.getString("user_pw") );
				result.setUserName( rs.getString("user_name") );
				result.setUserNick( rs.getString("user_nick") );
				result.setUserEmail( rs.getString("user_email") );
				result.setUserPhone( rs.getInt("user_phone") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		System.out.println("MypageDao selectLoginInfo() - 끝");
		return result;
		
	}


}
