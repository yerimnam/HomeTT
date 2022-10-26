package admin.cs.inquiry.dao.face;

import java.sql.Connection;
import java.util.List;

import admin.cs.inquiry.dto.Inquiry;
import util.Paging;

public interface AdInquiryListDao {
	
	/**
	 * 게시글 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<Inquiry> - 테이블 페이징 목록 조회 결과
	 */
	public List<Inquiry> selectAll(Connection conn, Paging paging);
	
	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 * 지정된 inquiryno의 게시글 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param inquiryno - 조회할 게시글의 inquiryno를 가진 DTO객체
	 * @return inquiry - 조회된 게시글의 상세정보 DTO객체
	 */
	public Inquiry selectInquiryByInquiryno(Connection conn, Inquiry inquiryno);

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
	public List<Inquiry> selectSearchList(Connection conn, Paging paging, String searchType, String keyword);
	
	/**
	 * 게시글 답변 입력
	 * 
	 * @param conn - DB 연결 객체
	 * @param inquiry - 삽입될 게시글 답변 내용
	 * @return int - INSERT 쿼리 수행 결과
	 */
	public int updateAnswer(Connection conn, Inquiry inquiry);

	/**
	 * 게시글 삭제
	 * 
	 * @param conn - DB연결 객체
	 * @param inquiry - 삭제할 게시글 번호
	 * @return UPDATE 수행 결과
	 */
	public int delete(Connection conn, Inquiry inquiry);
	
	
}
