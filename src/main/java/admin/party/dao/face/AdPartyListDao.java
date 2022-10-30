package admin.party.dao.face;

import java.sql.Connection;
import java.util.List;

import admin.party.dto.Party;
import util.Paging;

public interface AdPartyListDao {
	
	/**
	 * 파티 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<Party> - 테이블 페이징 목록 조회 결과
	 */
	public List<Party> selectAll(Connection conn, Paging paging);
	
	/**
	 * 총 파티 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 * 지정된 partyno의 파티 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param partyno - 조회할 게시글의 partyno를 가진 DTO객체
	 * @return Party - 조회된 파티의 상세정보 DTO객체
	 */
//	public Party selectPartyByPartyno(Connection conn, Party partyno);

	/**
	 * 총 파티 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectSearchCntAll(Connection conn, String searchType, String keyword);
	
	/**
	 * 검색한 파티 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param searchpaging - 페이징 정보 객체
	 * @param searchType - 검색 카테고리
	 * @param keyword - 검색어 내용
	 * @return 검색한 파티 목록 전달
	 */
	public List<Party> selectSearchList(Connection conn, Paging paging, String searchType, String keyword);
	
}
