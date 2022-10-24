package party.dao.face;

import java.sql.Connection;

import party.dto.Comments;

public interface CommentDao {
	
	
	/**
	 * 게시글 삭제
	 * 
	 * @param conn - DB연결 객체
	 * @param comments - 삭제할 게시글 번호
	 * @return UPDATE 수행 결과
	 */
	public int delete(Connection conn, Comments comments);

}
