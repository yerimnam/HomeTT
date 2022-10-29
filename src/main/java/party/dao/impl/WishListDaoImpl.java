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
				wishlist.setUserNo(( rs.getInt("userno")));

				
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
	public int insertWishNo(Connection conn, WishList wishlist) {
		
		String sql = "";
		sql += "INSERT INTO wish_list ( wish_no, party_no, user_no )";
		sql += " VALUES ( wish_list_seq.nextval, ?, ?)";
		
		int res = 0;
		
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, wishlist.getPartyNo());
			ps.setInt(2, wishlist.getUserNo());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	
		return res;
	}

	
//	@Override
//	public int selectNextWishno(Connection conn) {
//		
//		
//		String sql = "";
//		sql += "SELECT wishlist_seq.nextval FROM dual";
//		
//		int nextwishno = 0;
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			
//			rs = ps.executeQuery();
//			
//			while( rs.next() ) {
//				nextwishno = rs.getInt("nextval");
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		return nextwishno;
//	}

	
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
