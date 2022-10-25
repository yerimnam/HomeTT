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
		System.out.println("AdReportListDao selectAll() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT";
		sql += "			report_no, board_cano, report_date, report_content, reporter, report_target, report_party";
		sql += "		FROM report";
		sql += "		ORDER BY report_no DESC";
		sql += "	) B";
		sql += " ) REPORT";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		//결과 저장할 List
		List<Report> reportList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Report r = new Report(); //조회 결과 행 저장 DTO객체
				
				r.setReportNo(rs.getInt("report_no"));
				r.setBoardCano(rs.getInt("board_cano"));
				r.setReportDate(rs.getDate("report_date"));
				r.setReportContent(rs.getString("report_content"));
				r.setReporter(rs.getString("reporter"));
				r.setReportTarget(rs.getString("report_target"));
				r.setReportParty(rs.getString("report_party"));
				
				//리스트에 결과값 저장하기
				reportList.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdReportListDao selectAll() - 끝");
		return reportList; //최종 결과 반환
	}

	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM report";
		
		//총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장

			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
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
	public List<Report> selectSearchList(Connection conn, String searchType, String keyword) {
		
		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT";
		sql += "	report_no, board_cano, report_date, report_content, reporter, report_target, report_party";
		sql += " FROM report";
		sql += " WHERE " + searchType + " LIKE ?";
		sql += " ORDER BY report_no DESC";
		
		//결과 저장할 List
		List<Report> reportList = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql); //SQL수행 객체
			ps.setString(1, keyword);
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Report r = new Report(); //조회 결과 행 저장 DTO객체
				
				r.setReportNo(rs.getInt("report_no"));
				r.setBoardCano(rs.getInt("board_cano"));
				r.setReportDate(rs.getDate("report_date"));
				r.setReportContent(rs.getString("report_content"));
				r.setReporter(rs.getString("reporter"));
				r.setReportTarget(rs.getString("report_target"));
				r.setReportParty(rs.getString("report_party"));
				
				//리스트에 결과값 저장하기
				reportList.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("searchType" + searchType);
		System.out.println("keyword" + keyword);
		System.out.println("selectSearchList()" + reportList);
		return reportList;
	}
	
}
