package event.dao.face;

import java.sql.Connection;
import java.util.List;

import event.dto.EventBoard;

public interface EventInquiriesDao {
	
	/**
	 * 게시글 테이블 전체 조회
	 * @param conn - DB연결 객체
	 * @return List<EventBoard> - 테이블 전체 조회 목록
	 */
	
	public List<EventBoard> selectAll(Connection conn);

}
