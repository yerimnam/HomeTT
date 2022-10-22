package payment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import coupon.dto.Coupon;
import party.dto.Party;
import payment.dao.face.PaymentDao;
import payment.dto.Payment;
import user.dto.Member;


public class PaymentDaoImpl implements PaymentDao {

    private PreparedStatement ps; // SQL 수행 객체
    private ResultSet rs; // SQL 결과 
	
	
	@Override
	public Member selectUserInfo(Connection conn, int userno) {
		System.out.println("SelectuserInf- start");
		String sql ="";
		sql +="SELECT user_no,user_id,user_name,user_email,user_phone";
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
				 userinfo.setUserId(rs.getString("user_id"));
				 userinfo.setUserName(rs.getString("user_name"));
				 userinfo.setUserEmail(rs.getString("user_email"));
				 userinfo.setUserPhone(rs.getInt("user_phone"));
			 }
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		 
				
		System.out.println("SelectuserInf- end");
		return  userinfo;
	}
	 @Override
	public Party selectPartyInfo(Connection conn, int partyno) {
		 System.out.println("selectPartyInfo-start");
		 String sql ="";
		 sql +="SELECT party_no,user_no,paymentAmount,party_name,party_leader";
		 sql +=" FROM party";
		 sql +=" WHERE party_no =?";
		 
		 Party party = new Party();
		 
		 
		 try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, partyno);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				party.setPartyNo(rs.getInt("party_no"));
				party.setUserNo(rs.getInt("user_no"));
				party.setPaymentAmount(rs.getInt("paymentAmount"));
				party.setPartyName(rs.getString("party_name"));
				party.setPartyLeader(rs.getString("party_leader"));
			}
		 
		 } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		 
		 
		 
		 System.out.println("selectPartyInfo-end");
		 return party;
	}
	 
	 @Override
	public int insertPayment(Connection conn, List<Payment> returnData) {
		 System.out.println("insertPayment -start");
		 String sql ="";
		 sql +="INSERT INTO payment (pay_no,user_no,paymentmethod,party_no,payment_amount";
		 sql +=" values(?,?,?,?,?)";
		 
		 //insert 결과 변수
		 int result = 0;
		 
		 try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,returnData.get(0).getPayNo() );
			ps.setInt(2, returnData.get(1).getPaymentAmount());
			ps.setInt(3, returnData.get(2).getPartyNo());
			ps.setString(4, returnData.get(3).getPaymentMethod());
			ps.setInt(5,returnData.get(4).getUserNo());
			
			
			//나중에 이름, 이메일 연락처 추가하
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		 System.out.println("insert-payment-end");
		return result;
	}
	 

	 
}
