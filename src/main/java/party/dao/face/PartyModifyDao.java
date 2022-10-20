package party.dao.face;

import java.sql.Connection;
import java.util.List;

import party.dto.Party;
import util.PrPaging;

public interface PartyModifyDao {

	/**
	 * 파티방 테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return List<Party> - 테이블 전체 조회 목록
	 */
	public List<Party> selectAllPr(Connection conn);
	
	
	//시퀀스 설정
	public int selectNextUserno(Connection conn, Party party);
	
	
	/**
	 * 게시글 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 테이블 페이징 목록 조회 결과
	 */
	public List<Party> selectAllPr(Connection conn, PrPaging paging);
	/**
	 * 총 파티룸 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectPrAll(Connection conn);


	
	
	

	



	

}
