package partyBoard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import partyBoard.dao.face.PartyRoomBoardDao;
import partyBoard.dto.PartyBoard;

public class PartyRoomBoardDaoImpl implements PartyRoomBoardDao {

	private PreparedStatement ps; // sql 수행 객체
	private ResultSet rs; // 조회 결과 객체

	// 시퀀스 설정
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
	public List<PartyBoard> selectAllBr(Connection conn) {
		System.out.println("PartyRoomBoardDao selectBrAll() - 시작");

		// SQL작성
		String sql = "";
		sql += "SELECT";
		sql += "	party_boardno, party_boardwriter, party_boardtitle";
		sql += " FROM party_board";
//		sql += " ORDER BY party_boardNo";

		// 결과 저장할 List
		List<PartyBoard> partyBoardList = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				PartyBoard pb = new PartyBoard();

				pb.setUserNo(rs.getInt("party_boardNo"));
				pb.setPartyBoardWriter(rs.getString("party_boardwriter"));
				pb.setPartyBoardTitle(rs.getString("party_boardtitle"));

				partyBoardList.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		System.out.println("PartyRoomBoardDao selectBrAll() - 끝");
		return partyBoardList;
	}


	@Override
	public int insert(Connection conn, PartyBoard partyBoard) {

		String sql = "";
		sql += " INSERT INTO party_board ( party_boardNo, party_boardwriter, party_boardtitle )";
		sql += " VALUES( ?, ?, ?)";

		// INSERT 수행 결과 변수
		int result = 0;

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, partyBoard.getPartyBoardNo());
			ps.setString(2, partyBoard.getPartyBoardWriter());
			ps.setString(3, partyBoard.getPartyBoardTitle());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}

		return result;
	}

	@Override
	public int selectNextBoardno(Connection conn) {
		String sql = "";
		sql += "SELECT party_board_seq.nextval FROM dual";

		int nextBoardno = 0;

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				nextBoardno = rs.getInt("nextval");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return nextBoardno;
	}


}
