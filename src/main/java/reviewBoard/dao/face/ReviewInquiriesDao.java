package reviewBoard.dao.face;

import java.sql.Connection;
import java.util.List;

import event.dto.EventBoard;
import reviewBoard.dto.ReviewBoard;
import util.Paging;

public interface ReviewInquiriesDao {


	/**
	 * 게시글 테이블 전체 조회
	 * @param conn - DB연결 객체
	 * @param paging 
	 * @return List<ReviewBoard> - 테이블 전체 조회 목록
	 */

	List<ReviewBoard> selectAll(Connection connection);

	
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
	  * @return List<ReviewBoard> - 테이블 페이징 목록 조회 결과
	  */
	List<ReviewBoard> selectAll(Connection conn, Paging paging);

	
	/**
	 * 조회된 게시글의 조회수 증가시키기
	 * @param conn - DB연결 객체
	 * @param reviewArticlenumber - 조회할 게시글의 reviewArticlenumber를 가진 DTO객체
	 * @return int - UPDATE쿼리 수행 결과
	 */
	public int updateHit(Connection conn, ReviewBoard reviewArticlenumber);
	
	/**
	 * 지정된 eventArticlenumber의 게시글 조회하기
	 * @param conn - DB연결 객체
	 * @param reviewArticlenumber - 조회할 게시글의 reviewArticlenumber를 가진 DTO객체
	 * @return ReviewBoard - 조회된 게시글의 상세정보 DTO객체
	 */
	public ReviewBoard selectBoardByreviewArticlenumber(Connection conn, ReviewBoard eventArticlenumber);

	/**
	 * 게시글 작성자 ID를 이용하여 usernick 을 조회한다
	 * 
	 * @param conn - DB연결 객체
	 * @param viewBoard - 조회할 id를 가진 객체
	 * @return String - 작성자 닉네임
	 */
//	public String selectNickByBoard(Connection connection, ReviewBoard viewBoard);


//	public int delete(Connection conn, ReviewBoard reviewboard);

	/**
	 * 게시글 입력
	 * 
	 * @param conn - DB 연결 객체
	 * @param userNo 
	 * @param board - 삽입될 게시글 내용
	 * @return int - INSERT 쿼리 수행 결과
	 */
	public int insertreview(Connection conn, ReviewBoard param, int userNo);


	/**
	 * 수정할 내용 가져와서 먼저 보여주기
	 * @param connection -DB 연결
	 * @param reviewNo-이벤트 글번호
	 * @return 가져온 내용 
	 */
	public ReviewBoard selectcontent(Connection connection, ReviewBoard reviewNo);

	/**
	 * 이벤트 수정
	 * 
	 * @param conn -DB 연결
	 * @param reviewNum - 글번호 파람피터 정보
	 * @return 
	 */
	public int updateDo(Connection conn, ReviewBoard reviewNum);

	/**
	 * 이벤트 삭제
	 * @param conn -DB 연결
	 * @param reviewNo -이벤트 글 번호
	 * @return
	 */
	public int deleteDo(Connection conn, ReviewBoard reviewNo);
	



}


