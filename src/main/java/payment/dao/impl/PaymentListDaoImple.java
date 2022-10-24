package payment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import common.JDBCTemplate;
import oracle.sql.converter.JdbcCharacterConverters;
import payment.dao.face.PaymentListDao;
import payment.dto.Payment;
import util.PbPaging;

public class PaymentListDaoImple implements PaymentListDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int selectcntAll(Connection conn) {
		System.out.println("selectcntAll() start");
		String sql ="";
		sql +="SELECT count(*) cnt FROM payment";
		
		//결과값 저장
		int count =0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				
				count =rs.getInt("cnt");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		System.out.println("selectcntAll -end");
		return count;
	}

	
	
	
	 @Override
	public List<Payment> selectPayList(Connection conn, PbPaging paging, int userNo, Date start, Date end) {
		 System.out.println(userNo);
		 System.out.println("selectpaylist -start");
		 String sql ="";
		 sql  +="SELECT * FROM (";
		 sql  +=" 	SELECT rownum rnum,Y.* FROM(";
		 sql +="		SELECT p.user_no,p.order_no,p.paymentmethod,p.payment_amount,p.payment_date, a.party_name";
		 sql +=" 			FROM payment p";
		 sql +=" 				INNER JOIN party a";
		 sql +="				 on p.party_no = a.party_no";
		 sql +=" 				WHERE p.user_no =? and p.payment_date BETWEEN TO_char(TO_date(?),'YYYYMMDD') and TO_char(TO_date(?),'YYYYMMDD') ";
		 sql +="           )Y";
		 sql +="       )PAYLIST";
		 sql +=" WHERE rnum BETWEEN ? AND ? ";
		 //반환 데이터
		 List<Payment> paymentList = new ArrayList<>();
		 
		try {
			ps  = conn.prepareStatement(sql);
			
		   ps.setInt(1,userNo );
		   ps.setDate(2, new java.sql.Date( start.getTime() ) );
		   ps.setDate(3, new java.sql.Date( end.getTime() ) );
		   ps.setInt(4, paging.getStartNo());
		   ps.setInt(5, paging.getEndNo());

		   rs = ps.executeQuery();
		   
		   
		   while(rs.next()) {
			   
			  
			   Payment pay = new Payment();
			   pay.setUserNo(rs.getInt("user_no"));
			   pay.setOrderNo(rs.getString("order_no"));
			   pay.setPartyName(rs.getString("party_name"));
			   pay.setPaymentMethod(rs.getString("paymentmethod"));
			   pay.setPaymentAmount(rs.getInt("payment_amount"));
			   pay.setPaymentDate(rs.getDate("payment_date"));
		   
			   paymentList.add(pay);
		   }
				   
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			System.out.println(userNo);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		 System.out.println("selectpaylist end");
		return paymentList;
	}
}
