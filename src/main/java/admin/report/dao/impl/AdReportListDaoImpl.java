package admin.report.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.report.dao.face.AdReportListDao;
import admin.report.dto.Report;
import common.JDBCTemplate;
import util.Paging;

public class AdReportListDaoImpl implements AdReportListDao {
	
	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	
	@Override
	public List<Report> selectAll(Connection conn, Paging paging) {
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += "		SELECT";
		sql += "			report_no, board_cano, report_date, report_content, reporter, report_target, report_party";
		sql += "		FROM report";
		sql += "		ORDER BY report_no DESC";
		sql += "	) R";
		sql += " ) REPORT";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Report> reportList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Report r = new Report(); 
				
				r.setReportNo(rs.getInt("report_no"));
				r.setBoardCano(rs.getInt("board_cano"));
				r.setReportDate(rs.getDate("report_date"));
				r.setReportContent(rs.getString("report_content"));
				r.setReporter(rs.getString("reporter"));
				r.setReportTarget(rs.getString("report_target"));
				r.setReportParty(rs.getString("report_party"));
				
				reportList.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return reportList;
	}

	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM report";
		
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
	public Report selectReportByReportno(Connection conn, Report reportno) {
		
		String sql = "";
		sql += "SELECT";
		sql += "	report_no, board_cano, report_date, report_content";
		sql += "	, reporter, report_target, report_party";
		sql += " FROM report";
		sql += " WHERE report_no = ?";
		
		Report report = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reportno.getReportNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				report = new Report();
				
				report.setReportNo(rs.getInt("report_no"));
				report.setBoardCano(rs.getInt("board_cano"));
				report.setReportDate(rs.getDate("report_date"));
				report.setReportContent(rs.getString("report_content"));
				report.setReporter(rs.getString("reporter"));
				report.setReportTarget(rs.getString("report_target"));
				report.setReportParty(rs.getString("report_party"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return report;
	}

	@Override
	public List<Report> selectSearchList(Connection conn, Paging paging, String searchType, String keyword) {
//		System.out.println("selectSearchList searchpaging 시작" + paging);
		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += " 		SELECT";
		sql += " 		report_no, board_cano, report_date, report_content, reporter, report_target, report_party";
		sql += " 		FROM report";
		sql += " 		WHERE " + searchType + " LIKE ?";
		sql += " 		ORDER BY report_no DESC";
		sql += " 		) R";
		sql += " 	) REPORT";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Report> reportList = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Report r = new Report();
				
				r.setReportNo(rs.getInt("report_no"));
				r.setBoardCano(rs.getInt("board_cano"));
				r.setReportDate(rs.getDate("report_date"));
				r.setReportContent(rs.getString("report_content"));
				r.setReporter(rs.getString("reporter"));
				r.setReportTarget(rs.getString("report_target"));
				r.setReportParty(rs.getString("report_party"));
				
				reportList.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
//		System.out.println("selectSearchList searchpaging 끝" + paging);
//		System.out.println("selectSearchList()" + reportList);
		return reportList;
	}
	
	@Override
	public int selectSearchCntAll(Connection conn, String searchType, String keyword) {
//		System.out.println("selectSearchCntAll 시작" + searchType + keyword);
		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += "		SELECT";
		sql += "		report_no, board_cano, report_date, report_content, reporter, report_target, report_party";
		sql += "		FROM report";
		sql += "		WHERE " + searchType + " LIKE ?";
		sql += "		) R";
		sql += "	) REPORT";
		
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
