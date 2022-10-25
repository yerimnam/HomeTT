package wishListCheck.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import wishListCheck.dao.face.WishListCheckDao;
import wishListCheck.dto.WishListCheck;

public class WishListCheckDaoImpl implements WishListCheckDao {

	// SQL 수행 객체
	private PreparedStatement ps;
	
	// SQL 조회 결과 객체
	private ResultSet rs;
	
	@Override
	public List<WishListCheck> selectAll(Connection conn) {
		System.out.println("WishListCheckDao selectAll() - start");
		
		// SQL 작성
		String sql = "";
		sql += "SELECT DISTINCT";
		sql += "	w.wish_no, w.party_cano, w.board_cano, w.party_leader";
		sql	+= "	, w.party_name, w.party_credate, w.party_enddate, w.user_no";
		sql += "	, w.party_no, w.party_kind, p.party_member, p.paymentamount";
		sql += " FROM wish_list w, party p";
		sql += " WHERE w.party_no = p.party_no"; 
		sql += " ORDER BY user_no DESC";
		
		// 결과 저장 List
		List<WishListCheck> wishList = new ArrayList<>();
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			// SQL 수행 및 결과 집합 저장
			rs = ps.executeQuery();
			
			while(rs.next()) {
				WishListCheck w = new WishListCheck();
				
				w.setPartyKind(rs.getString("party_kind"));
				w.setPartyName(rs.getString("party_name"));
				w.setPartyLeader(rs.getString("party_leader"));
				w.setPartyEnddate(rs.getDate("party_enddate"));
				w.setPartyMember(rs.getInt("party_member"));
				w.setPaymentamount(rs.getInt("paymentamount"));
				
				wishList.add(w);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		System.out.println("WishListCheckDao selectAll() - end");
		return wishList;
	}

	
	
}
