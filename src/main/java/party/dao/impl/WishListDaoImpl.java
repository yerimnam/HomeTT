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
			
			//?부분에 wish_no 삽입
			ps.setInt(1, wishno.getWishNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
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
		return wishlist;
	}

	
	//선택한 wishno에 해당하는 글을 찜 목록으로 추가하기
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
			ps.setString(6, wishlist.getPartyKind());
			
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
		
		
		String sql = "";
		sql += "SELECT wishlist_seq.nextval FROM dual";
		
		int nextwishno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				nextwishno = rs.getInt("nextval");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextwishno;
	}

	
	//선택한 wishno에 해당하는 글을 찜 목록에서 삭제하기
	@Override
	public int delete(Connection conn, WishList wishlist) {
		
		String sql = "";
		sql += "DELETE wish_list";
		sql += " WHERE wish_no = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, wishlist.getWishNo());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}




}
