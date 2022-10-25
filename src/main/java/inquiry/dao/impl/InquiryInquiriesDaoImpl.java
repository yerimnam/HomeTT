package inquiry.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import inquiry.dao.face.InquiryInquiriesDao;
import inquiry.dto.InquiryBoard;

public class InquiryInquiriesDaoImpl implements InquiryInquiriesDao {
	
		private PreparedStatement ps;
		private ResultSet rs;
	@Override
	public List<InquiryBoard> selectAll(Connection conn, int userNo) {
		System.out.println("inquiryBoard select 시작");
		String sql ="";
		sql +="select I.*,m.user_nick from cs_inquiry I";
		sql +=" inner join member m";
		sql +=" on m.user_no = I.user_no";
		sql +=" where I.user_no = ?";		
	
		
		//반환데이터 
		List<InquiryBoard> inquiryList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			//?에 unserno삽입
			ps.setInt(1, userNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				InquiryBoard inquiryBaord = new InquiryBoard();
				
				
				

				inquiryBaord.setInquiryArticleNumber(rs.getInt("inquiry_articlenumber"));
				inquiryBaord.setUserNo(rs.getInt("user_no"));
				inquiryBaord.setAdminNo(rs.getInt("admin_no"));
				inquiryBaord.setBoardCode(rs.getInt("board_code"));
				inquiryBaord.setInquiryArticleTitle(rs.getString("inquiry_articletitle"));
				inquiryBaord.setInquiryContent(rs.getString("inquiry_content"));
				inquiryBaord.setInquiryWriter(rs.getString("inquiry_writer"));
				inquiryBaord.setInquiryDate(rs.getDate("inquiry_date"));
				inquiryBaord.setAnswerWriter(rs.getString("answer_writer"));
				inquiryBaord.setAnswercontent(rs.getString("answer_content"));
				inquiryBaord.setAnswerdate(rs.getDate("answer_date"));
				inquiryBaord.setUserNick(rs.getString("user_nick"));
			
			inquiryList.add(inquiryBaord);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println(inquiryList);
		System.out.println("inquiryBoard select 끝");
		return inquiryList;
	}

}
