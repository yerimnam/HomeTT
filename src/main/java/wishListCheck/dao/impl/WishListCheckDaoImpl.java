package wishListCheck.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import wishListCheck.dao.face.WishListCheckDao;
import wishListCheck.dto.WishListCheck;

public class WishListCheckDaoImpl implements WishListCheckDao {

	// SQL 수행 객체
	private PreparedStatement ps;
	
	// SQL 조회 결과 객체
	private ResultSet rs;
	
	@Override
	public List<WishListCheck> selectAll(Connection conn) {	
		
		// SQL 작성
		String sql = "";
		sql += "";
		
		
		return null;
	}

	
	
}
