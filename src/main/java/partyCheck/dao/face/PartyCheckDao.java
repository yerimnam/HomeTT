package partyCheck.dao.face;

import java.sql.Connection;
import java.util.List;

import partyCheck.dto.PartyCheck;
import util.Paging;

public interface PartyCheckDao {
	
	/**
	 * 파티 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<PartyCheck> - 테이블 전체 조회 목록
	 */
	public List<PartyCheck> selectAll(Connection conn);
	
	/**
	 * 파티 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging -  페이징 정보 객체
	 * @return List<PartyCheck> - 테이블 페이징 조회 결과
	 */
	public List<PartyCheck> selectAll(Connection conn, Paging paging);

	/**
	 * 총 파티 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행수 
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 * 파티방 나가기(DB삭제)
	 * 
	 * @param conn - DB연결 객체
	 * @param partyCheck - 나갈 파티방 번호
	 * @return delete 수행 결과
	 */
	public int delete(Connection conn, PartyCheck partyCheck);

}
