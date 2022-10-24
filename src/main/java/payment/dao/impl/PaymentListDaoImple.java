package payment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import payment.dao.face.PaymentListDao;
import payment.dto.Payment;

public class PaymentListDaoImple implements PaymentListDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	

	 @Override
	public List<Payment> selectPayList(Connection conn, int userNo, Date start, Date end) {
	
		 System.out.println("selectpaylist -start");
		 String sql ="";
		 sql +="SELECT p.order_no,p.paymentmethod,p.payment_amount,p.payment_date, a.party_name";
		 sql +=" FROM payment p";
		 sql +=" INNER JOIN party a";
		 sql +=" on p.party_no = a.party_no";
		 sql +=" WHERE p.user_no =? and p.payment_date BETWEEN TO_char(?,'YYYYMMDD') and TO_char(?,'YYYYMMDD') ";
		 
		 //반환 데이터
		 List<Payment> paymentList = new ArrayList<>();
		 
		try {
			ps  = conn.prepareStatement(sql);
			
		   ps.setInt(1, userNo);
		   ps.setDate(2, new java.sql.Date( start.getTime() ) );
		   ps.setDate(3, new java.sql.Date( end.getTime() ) );

		   rs = ps.executeQuery();
		   
		   
		   while(rs.next()) {
			   
			  
			   Payment pay = new Payment();
			   
			   pay.setOrderNo(rs.getString("order_no"));
			   pay.setPartyName(rs.getString("party_name"));
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
