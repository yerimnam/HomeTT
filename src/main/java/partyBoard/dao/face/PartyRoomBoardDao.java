package partyBoard.dao.face;

import java.sql.Connection;
import java.util.List;

import partyBoard.dto.PartyBoard;

public interface PartyRoomBoardDao {

	/**
	 * 게시글 테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return List<PartyBoard> - 테이블 전체 조회 목록
	 */
	public List<PartyBoard> selectBrAll(Connection conn);
	
	//시퀀스 설정
	public int selectNextUserno(Connection conn, PartyBoard partyBoard);

	
	//계정공유기간, 인원수 보여주는
	public List<PartyBoard> selectHead(Connection conn);
	

	
}
