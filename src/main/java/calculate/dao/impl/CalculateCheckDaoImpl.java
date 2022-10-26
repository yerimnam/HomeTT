package calculate.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import calculate.dao.face.CalculateCheckDao;
import calculate.dto.Calculate;
import common.JDBCTemplate;

public class CalculateCheckDaoImpl implements CalculateCheckDao {

	// SQL 수행 객체
	private PreparedStatement ps;
	
	// SQL 조회 결과 객체
	private ResultSet rs;
	
	@Override
	public List<Calculate> selectAll(Connection conn) {
		System.out.println("CalculateCheckDao selectAll() - Start");
		
		// SQL 작성
		String sql = "";
		sql += "SELECT";
		sql += "	calculate_no, pay_no, calculate_account, calculate_bank";
		sql += "	, party_no, user_no, payment_amount, payment_date, calculate_date";	
		sql += " FROM calculate";
		sql += " ORDER BY calculate_no DESC";
		
		// 결과 저장 List
		List<Calculate> calculateList = new ArrayList<>();
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			// SQL 수행 결과 집합 저장
			rs = ps.executeQuery();
			
			// 조회 결과 처리
			while(rs.next()) {
				Calculate c = new Calculate();
				
				c.setCalculateDate(rs.getDate("calculate_date"));
				c.setPaymentAmount(rs.getInt("payment_amount"));
				c.setPartyNo(rs.getInt(rs.getInt("party_no")));
				
				// 리스트에 결과값 저장
				calculateList.add(c);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		System.out.println("CalculateCheckDao selectAll() - end");
		return calculateList;
	}

}
