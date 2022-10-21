package partyBoard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import party.dto.Party;
import partyBoard.dao.face.PartyRoomBoardDao;
import partyBoard.dto.PartyBoard;

public class PartyRoomBoardDaoImpl implements PartyRoomBoardDao {
	
	private PreparedStatement ps;	//sql 수행 객체
	private ResultSet rs;	//조회 결과 객체
	
	//시퀀스 설정
	@Override
	public int selectNextUserno(Connection conn, PartyBoard partyBoard) {
		String sql = "SELECT party_board_seq.nextval FROM dual";

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
	public List<PartyBoard> selectBrAll(Connection conn) {
		System.out.println("PartyRoomBoardDao selectBrAll() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT";
		sql += "	party_boardNo, party_boardwriter, party_boardtitle";
		sql += " FROM party_board";
		
		// 결과 저장할 List
		List<PartyBoard> partyBoardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				PartyBoard pb = new PartyBoard();
				
				pb.setUserNo(rs.getInt("party_boardNo"));
				pb.setPartyBoardWriter(rs.getString("party_boardwriter"));
				pb.setPartyBoardTitle(rs.getString("party_boardtitle"));
				
				partyBoardList.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("PartyRoomBoardDao selectBrAll() - 끝");
		return partyBoardList;
	}

	
	//계정공유기간, 인원수 보여줌
	@Override
	public List<PartyBoard> selectHead(Connection conn) {
		System.out.println("PartyRoomBoardDao selectHead() - 시작");
		
		String sql = "";
		sql += "SELECT";
		sql += "	P.party_period, P.party_member";
		sql += " FROM party_board PB";
		sql += " JOIN party P ON(P.party_no = PB.party_no)";
		
		// 결과 저장할 List
		List<PartyBoard> headList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Party p = new Party();
				
				p.setPartyPeriod(rs.getDate("P.party_period"));
				p.setPartyMember(rs.getInt("P.party_member"));
				
				
				//@@@@@@@@@@@@@@@@@@@@@
//				headList.add(p);
				headList.addAll(headList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("PartyRoomBoardDao selectHead() - 끝");
		return headList;
	}


	
	

}
