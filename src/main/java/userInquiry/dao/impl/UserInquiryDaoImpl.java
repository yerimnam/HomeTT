package userInquiry.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import userInquiry.dao.face.UserInquiryDao;
import userInquiry.dto.UserInquiry;
import userInquiry.dto.UserInquiryFile;

public class UserInquiryDaoImpl implements UserInquiryDao {

	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	
	@Override
	public int selectNextBoardno(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Connection conn, UserInquiry userInquiry) {
		String sql = "";
		sql += "INSERT INTO report( board_no, reporter, report_content)";
		sql += " VALUES( boardfile_seq.nextval, ?, ?, ? )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userInquiry.getBoardNo());
			ps.setString(2, userInquiry.getReporter());
			ps.setString(3, userInquiry.getReportContent());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public int insertFile(Connection conn, UserInquiryFile userInquiryFile) {
		// TODO Auto-generated method stub
		return 0;
	}

}
