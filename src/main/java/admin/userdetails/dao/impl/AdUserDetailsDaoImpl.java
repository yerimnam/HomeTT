package admin.userdetails.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.userdetails.dao.face.AdUserDetailsDao;
import admin.userdetails.dto.Member;
import common.JDBCTemplate;

public class AdUserDetailsDaoImpl implements AdUserDetailsDao {
	
	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	
	@Override
	public List<Member> selectUserInfo(Connection conn, String searchType, String keyword) {
//		System.out.println("selectUserInfo 시작");
//		System.out.println("searchType" + searchType + "keyword" + keyword);
//		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += " SELECT";
		sql += " user_no, paymentMethod, master_no, user_id, user_pw, user_name, user_nick, user_email, user_phone, user_join, party_no";
		sql += " FROM member";
		sql += " WHERE " + searchType + " LIKE ?";
		
		List<Member> userinfo = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Member m = new Member();
				
				m.setUserNo(rs.getInt("user_no"));
				m.setPaymentMethod(rs.getString("paymentMethod"));
				m.setMasterNo(rs.getInt("Master_no"));
				m.setUserId(rs.getString("user_id"));
				m.setUserPw(rs.getString("user_pw"));
				m.setUserName(rs.getString("user_name"));
				m.setUserNick(rs.getString("user_nick"));
				m.setUserEmail(rs.getString("user_email"));
				m.setUserPhone(rs.getInt("user_phone"));
				m.setUserJoin(rs.getDate("user_join"));
				m.setPartyNo(rs.getInt("party_no"));
				
				userinfo.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
//		System.out.println("selectUserInfo 끝()" + userinfo);
		return userinfo;
	}
}
