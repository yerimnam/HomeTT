package party.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import party.dao.face.WishListDao;
import party.dto.WishList;


public class WishListDaoImpl implements WishListDao {


	private PreparedStatement ps; // SQL수행 객체
	private ResultSet rs; // SQL 조회 결과 객체
	
	@Override
	public WishList selectwishno(Connection conn, WishList wishno) {
		
		String sql ="";
		sql += "SELECT";
		sql += " * FROM wish_list";
		sql += " WHERE wish_no = ? ";
		
		WishList wishlist = new WishList();
		
		
		try {
			ps = conn.prepareStatement(sql);
		
			
			//?부분에 partyno 삽입
			ps.setInt(1, wishno.getWishNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				wishlist = new WishList();
				
				wishlist.setWishNo(( rs.getInt("wishno")));
				wishlist.setPartyNo(( rs.getInt("partyno")));
				wishlist.setBoardCano( rs.getInt("boardcano"));
				wishlist.setPartyLeader(( rs.getString("partyleader")));
				wishlist.setPartyName(( rs.getString("partyname")));
				wishlist.setPartyCredate(( rs.getDate("partycredate")));
				wishlist.setPartyEnddate(( rs.getDate("partyenddate")));
				wishlist.setPartyKind(( rs.getString("partykind")));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(rs);
		}
		return null;
	}

	@Override
	public int insert(Connection conn, WishList wishlist) {
		
		String sql = "";
		sql += "INSERT INTO wish_list ( wish_no, party_no, party_leader, party_name, party_credate, party_enddate, party_kind )";
		sql += " VALUES ( wishno_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		int res = 0;
		
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, wishlist.getPartyNo());
			ps.setString(2, wishlist.getPartyLeader());
			ps.setString(3, wishlist.getPartyName());
			ps.setDate(4, (Date) wishlist.getPartyCredate());
			ps.setDate(5, (Date) wishlist.getPartyEnddate());
			ps.setInt(6, res);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	
		return res;
	}

	@Override
	public int selectNextWishno(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, WishList wishlist) {
		// TODO Auto-generated method stub
		return 0;
	}




}
