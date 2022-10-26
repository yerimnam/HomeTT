package event.dao.face;

import java.sql.Connection;
import java.util.List;

import event.dto.EventBoard;
import util.Paging;

public interface EventInquiriesDao {


	/**
	 * 게시글 테이블 전체 조회
	 * @param conn - DB연결 객체
	 * @param paging 
	 * @return List<EventBoard> - 테이블 전체 조회 목록
	 */

	List<EventBoard> selectAll(Connection connection);

	
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
	  * @return List<EventBoard> - 테이블 페이징 목록 조회 결과
	  */
	List<EventBoard> selectAll(Connection conn, Paging paging);

	
	/**
	 * 조회된 게시글의 조회수 증가시키기
	 * @param conn - DB연결 객체
	 * @param eventArticlenumber - 조회할 게시글의 eventArticlenumber를 가진 DTO객체
	 * @return int - UPDATE쿼리 수행 결과
	 */
	public int updateHit(Connection conn, EventBoard eventArticlenumber);
	
	/**
	 * 지정된 eventArticlenumber의 게시글 조회하기
	 * @param conn - DB연결 객체
	 * @param eventArticlenumber - 조회할 게시글의 eventArticlenumber를 가진 DTO객체
	 * @return EventBoard - 조회된 게시글의 상세정보 DTO객체
	 */
	public EventBoard selectBoardByeventArticlenumber(Connection conn, EventBoard eventArticlenumber);



//	/**
//	 * 게시글 입력
//	 * 
//	 * @param conn - DB 연결 객체
//	 * @param board - 삽입될 게시글 내용
//	 * @return int - INSERT 쿼리 수행 결과
//	 */
//	int insert(Connection conn, FaqBoard board);
//
//	
//	/**
//	 * 시퀀스를 이용하여 다음 게시글 번호 조회하기
//	 * 
//	 * @param conn - DB연결 객체
//	 * @return int - 다음 게시글 번호
//	 */
//	int selectNextFaqArticlenumber(Connection conn);



}


