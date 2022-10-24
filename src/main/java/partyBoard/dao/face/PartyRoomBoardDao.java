package partyBoard.dao.face;

import java.sql.Connection;
import java.util.List;

import partyBoard.dto.PartyBoard;
import util.PbPaging;

public interface PartyRoomBoardDao {

	/**
	 * 게시글 테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return List<PartyBoard> - 테이블 전체 조회 목록
	 */
	public List<PartyBoard> selectAllBr(Connection conn);
	
	//시퀀스 설정
	public int selectNextUserno(Connection conn, PartyBoard partyBoard);

	/**
	 * 게시글 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<PartyBoard> - 테이블 페이징 목록 조회 결과
	 */
	public List<PartyBoard> selectAllBr(Connection conn, PbPaging paging);
	

	/**
	 * 전달된 파라미터 값을 테이블에 삽입한다
	 * 
	 * @param conn - DB 연결 객체 
	 * @param partyBoard - 테이블에 삽입할 정보 객체
	 * @return insert 수행 결과 ( 0 - 삽입 실패, 1 - 삽입 성공 )
	 */
	public int insert(Connection conn, PartyBoard partyBoard);

	public int selectNextBoardno(Connection conn);

	/**
	 * 총 파티게시글 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectPbAll(Connection conn);




	
}
