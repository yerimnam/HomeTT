package report.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import report.dao.face.MemberReportDao;
import report.dto.Report;

public class MemberReportDaoImpl implements MemberReportDao {


	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	
	
	@Override
	public int selectNextReportno(Connection conn) {
		
		String sql = "";
		sql += "SELECT reportno_seq.nextval FROM dual";
		
		int nextReportno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				nextReportno = rs.getInt("nextval");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextReportno;
		
	}
	
	@Override
	public int insert(Connection conn, Report report) {
		
		String sql = "";
		sql += "INSERT INTO board ( report_no, board_cano, report_date, report_content, reporter, report_target, report_party )";
		sql += " VALUES ( reportno_seq.nextval, boardcano_seq.nextval, ?, ?, ?, ?, ?)";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, report.getReportContent());
			ps.setString(2, report.getReporter());
			ps.setString(3, report.getReportTarget());
			ps.setString(4, report.getReportParty());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}


	
	

}
