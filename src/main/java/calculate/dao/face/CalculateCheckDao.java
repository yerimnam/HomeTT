package calculate.dao.face;

import java.sql.Connection;
import java.util.List;

import calculate.dto.Calculate;

public interface CalculateCheckDao {

	/**
	 * 정산 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<Calculate> - 테이블 전체 조회 목록
	 */
	public List<Calculate> selectAll(Connection conn);
}
