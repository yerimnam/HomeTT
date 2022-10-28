package admin.payment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.payment.dao.face.AdPaymentListDao;
import admin.payment.dto.Payment;
import admin.report.dto.Report;
import common.JDBCTemplate;
import util.Paging;

public class AdPaymentListDaoImpl implements AdPaymentListDao {
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public List<Payment> selectAll(Connection conn, Paging paging) {
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, P.* FROM (";
		sql += "		SELECT";
		sql += "			pay_no, user_no, order_no, party_no, paymentmethod, user_cardcom, payment_amount, payment_date";
		sql += "		FROM payment";
		sql += "		ORDER BY pay_no DESC";
		sql += "	) P";
		sql += " ) PAYMENT";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Payment> paymentList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Payment p = new Payment(); 
				
				p.setPayNo(rs.getInt("pay_no"));
				p.setOrderNo(rs.getString("order_no"));
				p.setUserNo(rs.getInt("user_no"));
				p.setPartyNo(rs.getInt("party_no"));
				p.setPaymentMethod(rs.getString("paymentmethod"));
				p.setUserCardcom(rs.getString("user_cardcom"));
				p.setPaymentAmount(rs.getInt("payment_amount"));
				p.setPaymentDate(rs.getDate("payment_date"));
				
				paymentList.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return paymentList;
	}

	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM payment";
		
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return count;
	}

	@Override
	public Payment selectPaymentByPaymentno(Connection conn, Payment paymentno) {
		
		String sql = "";
		sql += "SELECT";
		sql += "	pay_no, user_no, order_no, party_no, paymentmethod, user_cardcom, payment_amount, payment_date";
		sql += " FROM payment";
		sql += " WHERE pay_no = ?";
		
		Payment payment = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paymentno.getPayNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				payment = new Payment();
				
				payment.setPayNo(rs.getInt("pay_no"));
				payment.setOrderNo(rs.getString("order_no"));
				payment.setUserNo(rs.getInt("user_no"));
				payment.setPartyNo(rs.getInt("party_no"));
				payment.setPaymentMethod(rs.getString("paymentmethod"));
				payment.setUserCardcom(rs.getString("user_cardcom"));
				payment.setPaymentAmount(rs.getInt("payment_amount"));
				payment.setPaymentDate(rs.getDate("payment_date"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return payment;
	}

	@Override
	public List<Payment> selectSearchList(Connection conn, Paging paging, String searchType, String keyword) {
//		System.out.println("selectSearchList searchpaging 시작" + paging);
//		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, P.* FROM (";
		sql += " 		SELECT";
		sql += " 		pay_no, user_no, order_no, party_no, paymentmethod, user_cardcom, payment_amount, payment_date";
		sql += " 		FROM payment";
		sql += " 		WHERE " + searchType + " LIKE ?";
		sql += " 		ORDER BY pay_no DESC";
		sql += " 		) P";
		sql += " 	) PAYMENT";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Payment> paymentList = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Payment p = new Payment();
				
				p.setPayNo(rs.getInt("pay_no"));
				p.setOrderNo(rs.getString("order_no"));
				p.setUserNo(rs.getInt("user_no"));
				p.setPartyNo(rs.getInt("party_no"));
				p.setPaymentMethod(rs.getString("paymentmethod"));
				p.setUserCardcom(rs.getString("user_cardcom"));
				p.setPaymentAmount(rs.getInt("payment_amount"));
				p.setPaymentDate(rs.getDate("payment_date"));
				
				paymentList.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
//		System.out.println("selectSearchList searchpaging 끝" + paging);
//		System.out.println("selectSearchList()" + paymentList);
		return paymentList;
	}
	
	@Override
	public int selectSearchCntAll(Connection conn, String searchType, String keyword) {
//		System.out.println("selectSearchCntAll 시작" + searchType + keyword);
//		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM (";
		sql += "	SELECT rownum rnum, P.* FROM (";
		sql += "		SELECT";
		sql += "		pay_no, user_no, order_no, party_no, paymentmethod, user_cardcom, payment_amount, payment_date";
		sql += "		FROM payment";
		sql += "		WHERE " + searchType + " LIKE ?";
		sql += "		) P";
		sql += "	) PAYMENT";
		
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);

			rs = ps.executeQuery();

			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
//		System.out.println("selectSearchCntAll 끝" + searchType + keyword);
//		System.out.println("selectSearchCntAll" + count);
		return count;
	}
}
