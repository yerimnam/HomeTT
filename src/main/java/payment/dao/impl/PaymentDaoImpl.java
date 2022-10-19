package payment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import party.dto.Party;
import payment.dao.face.PaymentDao;
import payment.dto.Payment;
import user.dto.Member;


public class PaymentDaoImpl implements PaymentDao {

    private PreparedStatement ps; // SQL 수행 객체
    private ResultSet rs; // SQL 결과 
	
	
	@Override
	public Member selectUserInfo(Connection conn, int userno) {
		
		String sql ="";
		sql +="SELECT user_no,user_id,user_name";
		sql +=" FROM member";
		sql +=" WHERE user_no =?";
		
		//조회 결과 저장할 객체  
		
		Member userinfo = new Member();
		try {
			//sql수행 객체 생성
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, userno);
			 //수행 결과 저장
			 rs = ps.executeQuery();
			 
			 //조회 결과 처리 
			 while(rs.next()) {
				 userinfo.setUserNo(rs.getInt("user_no"));
			 }
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
			
		}
		 
				
		return  userinfo;
	}
	 @Override
	public Party selectPartyInfo(Connection conn, int partyno) {

		 String sql ="";
		 sql +="SELECT party_no,paymentAmount,party_endDate,party_name";
		 sql +=" FROM party";
		 sql +=" WHERE partyno =?";
		 
		 Party party = new Party();
		 
		 
		 try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, partyno);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				party.setPartyNo(rs.getInt("party_no"));
				party.setPaymentAmount(rs.getInt("paymentAmount"));
				party.setPartyEndDate(rs.getDate("party_endDate"));
				party.setPartyName(rs.getString("party_name"));
			}
		 
		 } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
			
		}
		 
		 
		 
		 return party;
	}
}
