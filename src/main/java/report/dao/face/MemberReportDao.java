package report.dao.face;

import java.sql.Connection;

import report.dto.Report;

public interface MemberReportDao {
	
	
	/**
	 * 신고글 입력
	 * 
	 * @param conn - DB 연결 객체
	 * @param board - 삽입될 게시글 내용
	 * @return int - INSERT 쿼리 수행 결과
	 */
	public int insert(Connection conn, Report report);
	
	

	/**
	 * 시퀀스를 이용하여 다음 게시글 번호 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @return int - 다음 게시글 번호
	 */
	public int selectNextReportno(Connection conn);
	

}
