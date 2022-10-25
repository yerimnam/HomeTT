package admin.admindetails.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.admindetails.dao.face.AdminModifyDao;
import admin.admindetails.dto.Admin;
import common.JDBCTemplate;

public class AdminModifyDaoImpl implements AdminModifyDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<Admin> updateAdmin(Connection conn, String id) {
		System.out.println("AdminModifyDao updateAdmin() - 시작");
		
		//SQL 작성
		String sql = "";
		sql += "SELECT ";
		sql += " 	admin_id, admin_name, admin_email,";
		sql += " 	admin_phone, admin_team, admin_position, admin_profile";
		sql += " FROM admin";
		sql += " WHERE admin_id=?";
//		String sql = "";
//		sql += "UPDATE admin SET";
//		sql += " 	admin_name=?, admin_email=?,";
//		sql += " 	admin_phone=?, admin_team=?, admin_position=?, admin_profile=?";
//		sql += " WHERE admin_id=?";
		
		//결과 저장할 List
		List<Admin> AdminInfoList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
//			ps.setString(1, );
//			ps.setString(2, );
//			ps.setString(3, );
//			ps.setString(4, );
//			ps.setString(5, );
//			ps.setString(6, );
//			ps.setString(7, );
			ps.setString(1, id);
			
			rs = ps.executeQuery(); //SQL 수행 및 결과 집합 저장
			
			//조회 결과 처리
			while( rs.next() ) {
				Admin a = new Admin(); //조회 결과 행 저장 DTO객체
				
				a.setAdminId(rs.getString("admin_id"));
				a.setAdminName(rs.getString("admin_name"));
				a.setAdminEmail(rs.getString("admin_email"));
				a.setAdminPhone(rs.getString("admin_phone"));
				a.setAdminTeam(rs.getString("admin_team"));
				a.setAdminPosition(rs.getString("admin_position"));
				a.setAdminProfile(rs.getString("admin_profile"));
				
				//리스트에 결과값 저장하기
				AdminInfoList.add(a);
				System.out.println(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println(AdminInfoList);
		System.out.println("AdminModifyDao updateAdmin() - 끝");	
		return AdminInfoList; //최종 결과 반환
	}
	
}
