package adFaq.dao.face;

import java.sql.Connection;
import java.util.List;

import adFaq.dto.FaqBoard;
import util.Paging;

public interface FaqInquiriesDao {

	
	/**
	 * 게시글 테이블 전체 조회
	 * @param conn - DB연결 객체
	 * @param paging 
	 * @return List<FaqBoard> - 테이블 전체 조회 목록
	 */

	List<FaqBoard> selectAll(Connection connection);

	
	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB 연갤 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);


	
	 /**
	  *  게시글 테이블 전체 조회
	  * @param conn - DB 연결 객체
	  * @param paging - 페이징 정보 객체
	  * @return List<FaqBoard> - 테이블 페이징 목록 조회 결과
	  */
	
	
	List<FaqBoard> selectAll(Connection conn, Paging paging);




}
