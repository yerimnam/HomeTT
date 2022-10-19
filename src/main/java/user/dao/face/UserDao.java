package user.dao.face;

import java.sql.Connection;
import java.sql.Date;

import user.dto.Member;

public interface UserDao {
 
	/**
	 * member_seq의 nextuserno을 조회한다
	 * 
	 * @param conn - DB연결 객체
	 * @return - userno로 사용될 member_seq의 nextuserno
	 */
	public int selectNextUserno(Connection conn);

	
	/**
	 * 전달된 파라미터 값을 테이블에 삽입한다
	 * 
	 * @param conn  - DB 연결 객체
	 * @param member - 테이블에 삽입할 정보 객체
	 * @return insert 수행 결과 ( 0 실패, 1 삽입 성공)
	 */
	public int insert(Connection conn, Member member);


	
}
