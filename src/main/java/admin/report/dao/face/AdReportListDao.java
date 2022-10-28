package admin.report.dao.face;

import java.sql.Connection;
import java.util.List;

import admin.report.dto.Report;
import util.Paging;

public interface AdReportListDao {
	
	/**
	 * 게시글 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 테이블 페이징 목록 조회 결과
	 */
	public List<Report> selectAll(Connection conn, Paging paging);
	
	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 * 지정된 reportno의 게시글 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param boardno - 조회할 게시글의 reportno를 가진 DTO객체
	 * @return Board - 조회된 게시글의 상세정보 DTO객체
	 */
	public Report selectReportByReportno(Connection conn, Report reportno);

	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectSearchCntAll(Connection conn, String searchType, String keyword);
	
	/**
	 * 검색한 게시글 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param searchpaging - 페이징 정보 객체
	 * @param searchType - 검색 카테고리
	 * @param keyword - 검색어 내용
	 * @return 검색한 게시글 목록 전달
	 */
	public List<Report> selectSearchList(Connection conn, Paging paging, String searchType, String keyword);
	
}
