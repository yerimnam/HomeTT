package calculate.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import calculate.dao.face.CalculateCheckDao;
import calculate.dto.Calculate;

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
		sql += "	pm.payment_date, pm.payment_amaount, pm.user_no, pm.party_no";
		sql	+= "	, ps.party_name";
		sql += " FROM payment pm, paryt, py";
		sql += " WHERE pm.user_no = ps.user.no";
		
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
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("CalculateCheckDao selectAll() - end");
		return null;
	}

}
