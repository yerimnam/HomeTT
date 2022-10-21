package party.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import party.dao.face.PartyModifyDao;
import party.dto.Party;
import util.PrPaging;

public class PartyModifyDaoImpl implements PartyModifyDao {

	private PreparedStatement ps; // SQL수행 객체
	private ResultSet rs; // SQL 조회 결과 객체

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@Override
	public int selectNextUserno(Connection conn, Party party) {
		String sql = "SELECT party_seq.nextval FROM dual";

		int nextval = 0;

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery(); // select에서만 실행

			rs.next(); // 첫번째 행을 찾아라

			nextval = rs.getInt(1); // 첫번째 컬럼의 값 반환
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return nextval;
	}

	@Override
	public List<Party> selectAllPr(Connection conn) {
		System.out.println("PartyModifyDao selectAllPr() - 시작");

		// 일단 방 정보를 봐야지?
		// SQL작성
		String sql = "";
		sql += "SELECT";
		sql += "	party_no, party_kind, party_name, party_leader, party_creDate";
		sql += "	, party_endDate, party_period, party_member, paymentAmount";
		sql += " FROM party";
		sql += " ORDER BY party_no ASC";

		// 결과 저장할 List
		List<Party> partyList = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Party p = new Party();
				
				p.setPartyNo(rs.getInt("party_no"));
				p.setPartyKind(rs.getString("party_kind"));
				p.setPartyName(rs.getString("party_name"));
				p.setPartyLeader(rs.getString("party_leader"));
				p.setPartyCreDate(rs.getDate("party_creDate"));
				p.setPartyEndDate(rs.getDate("party_endDate"));
				p.setPartyPeriod(rs.getDate("party_period"));
				p.setPartyMember(rs.getInt("party_member"));
				p.setPaymentAmount(rs.getInt("paymentAmount"));

				// 리스트에 결과값 저장하기
				partyList.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("PartyModifyDao selectAllPr() - 끝");
		return partyList;
	}

	@Override
	public List<Party> selectAllPr(Connection conn, PrPaging paging) {
		System.out.println("PartyModifyDao selectAllPr()- 시작");
	
		
		// SQL작성
		String sql = "";
		sql += "SELECT * FROM(";    
		sql += "	SELECT rownum rnum, P.* FROM(";
		sql += "			SELECT";
		sql += "				party_no, party_kind, party_name, party_leader, party_creDate";      
		sql += "					, party_endDate, party_period, party_member, paymentAmount";
		sql += "	        FROM party";
		sql += " 		    ORDER BY party_no ASC";
		sql += "	)P";
		sql += "  )PARTY";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 저장할 List
		List<Party> partyList = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			while(rs.next()) {
				Party p = new Party(); //조회 결과 행 저장 DTO객체
				
				p.setPartyNo(rs.getInt("party_no"));
				p.setPartyKind(rs.getString("party_kind"));
				p.setPartyLeader(rs.getString("party_leader"));
				p.setPartyCreDate(rs.getDate("party_creDate"));
				p.setPartyEndDate(rs.getDate("party_endDate"));
				p.setPartyPeriod(rs.getDate("party_period"));
				p.setPartyMember(rs.getInt("party_member"));
				p.setPaymentAmount(rs.getInt("paymentAmount"));
				
				//리스트에 결과값 저장
				partyList.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		System.out.println("PartyModifyDao selectAllPr()- 끝");
		return partyList; // 최종 결과 반환
	}

	@Override
	public int selectPrAll(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM party";

		// 총 파티방 수 변수
		int count = 0;

		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장

			while (rs.next()) {
				count = rs.getInt("cnt");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		// 최종 결과 반환
		return count;
	}


}
