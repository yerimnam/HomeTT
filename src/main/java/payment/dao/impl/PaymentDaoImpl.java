package payment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import payment.dao.face.PaymentDao;
import payment.dto.Payment;


public class PaymentDaoImpl implements PaymentDao {

    private PreparedStatement ps; // SQL 수행 객체
    private ResultSet rs; // SQL 결과 
	
	
	@Override
	public Payment selectUserInfo(Connection conn, int userno) {
		
		String sql ="";
		sql +="SELECT user_no,user_id,user_name";
		sql +=" FROM member";
		sql +=" WHERE user_no =?";
		
		//조회 결과 저장할 객체  ->멤버로 바꿔라.. 
		
		Payment userinfo = new Payment();
		try {
			//sql수행 객체 생성
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, userno);
			 //수행 결과 저장
			 rs = ps.executeQuery();
			 
			 //조회 결과 처리 
			 while(rs.next()) {
				 userinfo.setUserNo(rs.getInt("user_no"));
				 userinfo.setUserId(rs.getString("user_id")); 
				 userinfo.setUserName(rs.getString("user_name"));
				 
			 }
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
			
		}
		 
				
		return  userinfo;
	}
}
