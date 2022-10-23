package payment.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import payment.dao.face.PaymentListDao;
import payment.dto.Payment;

public class PaymentListDaoImple implements PaymentListDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	

	 @Override
	public List<Payment> selectPayList(Connection conn, int userNo, Date startDate, Date endDate) {
	
		 System.out.println("selectpaylist -start");
		 String sql ="";
		 sql +="SELECT pay_no,order_no,party_no,paymentmethod,payment_amount,payment_date ";
		 sql +=" FROM payment";
		 sql +=" WHERE user_no =? and payment_date BETWEEN TO_DATE(?,'YYYYMMDD') and TO_DATE(?,'YYYYMMDD') ";
		 
		 //반환 데이터
		 List<Payment> paymentList = null;
		 
		try {
			ps  = conn.prepareStatement(sql);
			
		   ps.setInt(1, userNo);
		   ps.setDate(2, (java.sql.Date)startDate);
		   ps.setDate(3, (java.sql.Date)endDate);

		   rs = ps.executeQuery();
		   
		   
		   while(rs.next()) {
			   
			  
			   Payment pay = new Payment();
			   
			   pay.setPayNo(rs.getString("pay_no"));
			   pay.setOrderNo(rs.getString("order_no"));
			   pay.setPartyNo(rs.getInt("party_no"));
			   pay.setPaymentMethod(rs.getString("paymentmethod"));
			   pay.setPaymentAmount(rs.getInt("payment_amount"));
			   pay.setPaymentDate(rs.getDate("payment_date"));
		   
			   paymentList.add(pay);
		   }
				   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		 
		return paymentList;
	}
}
