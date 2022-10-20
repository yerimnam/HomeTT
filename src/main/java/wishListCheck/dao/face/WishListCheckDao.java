package wishListCheck.dao.face;

import java.sql.Connection;
import java.util.List;

import wishListCheck.dto.WishListCheck;

public interface WishListCheckDao {
	
	/**
	 * 찜 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<WishListCheck> - 테이블 전체 조회 목록
	 */
	public List<WishListCheck> selectAll(Connection conn);

}
