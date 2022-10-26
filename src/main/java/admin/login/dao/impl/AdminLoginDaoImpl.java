package admin.login.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import admin.login.dao.face.AdminLoginDao;
import admin.login.dto.Admin;
import common.JDBCTemplate;
import user.dto.Member;

public class AdminLoginDaoImpl implements AdminLoginDao {

	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //결과 집합 객체
	
	@Override
	public int selectLoginIdPw(Connection conn, Admin admin) {

		System.out.println("AdminLoginDao selectLoginIdPw() - 시작");
		System.out.println("admin.getAdminId() : " + admin.getAdminId());
		System.out.println("admin.getAdminPw() : " + admin.getAdminPw());
		
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM admin";
		sql += " WHERE admin_id = ?";
		sql += "	AND admin_pw = ?";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getAdminId());
			ps.setString(2, admin.getAdminPw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDao selectLoginIdPw() - 끝");
		return cnt;
	}
	
	
	@Override
	public Admin selectLoginInfo(Connection conn, Admin admin) {
		System.out.println("AdminLoginDao selectLoginInfo() - 시작");

		String sql = "";
		sql += "SELECT admin_no, admin_id, admin_pw FROM admin";
		sql += " WHERE admin_id = ?";
		
		Admin result = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getAdminId());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new Admin();
				
				result.setAdminNo( rs.getInt("admin_no") );
				result.setAdminId( rs.getString("admin_id") );
				result.setAdminPw( rs.getString("admin_pw") );

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		System.out.println("AdminLoginDao selectLoginInfo() - 끝");
		return result;
	}
	
	
	
	
	
	
}
