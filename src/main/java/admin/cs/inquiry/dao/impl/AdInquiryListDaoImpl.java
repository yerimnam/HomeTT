package admin.cs.inquiry.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.cs.inquiry.dao.face.AdInquiryListDao;
import admin.cs.inquiry.dto.Inquiry;
import common.JDBCTemplate;
import util.Paging;

public class AdInquiryListDaoImpl implements AdInquiryListDao {
	
	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	
	@Override
	public List<Inquiry> selectAll(Connection conn, Paging paging) {
//		System.out.println("selectAll 시작");
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, I.* FROM (";
		sql += "		SELECT";
		sql += "			inquiry_articleNumber, user_no, admin_no, board_code, inquiry_articleTitle,";
		sql += "			 inquiry_content, inquiry_writer, inquiry_date, answer_writer, answer_content, answer_date";
		sql += "		FROM cs_inquiry";
		sql += "		ORDER BY inquiry_articleNumber DESC";
		sql += "	) I";
		sql += " ) Inquiry";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Inquiry> inquiryList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Inquiry i = new Inquiry(); 
				
				i.setInquiryArticleNumber(rs.getInt("inquiry_articleNumber"));
				i.setUserNo(rs.getInt("user_no"));
				i.setAdminNo(rs.getInt("admin_no"));
				i.setBoardCode(rs.getInt("board_code"));
				i.setInquiryArticleTitle(rs.getString("inquiry_articleTitle"));
				i.setInquiryContent(rs.getString("inquiry_content"));
				i.setInquiryWriter(rs.getString("inquiry_writer"));
				i.setInquiryDate(rs.getDate("inquiry_date"));
				i.setAnswerWriter(rs.getString("answer_writer"));
				i.setAnswerContent(rs.getString("answer_content"));
				i.setAnswerDate(rs.getDate("answer_date"));
				
				inquiryList.add(i);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
//		System.out.println("selectAll 끝 : " + inquiryList);
		return inquiryList;
	}

	@Override
	public int selectCntAll(Connection conn) {
//		System.out.println("selectCntAll 시작");
		String sql = "";
		sql += "SELECT count(*) cnt FROM cs_inquiry";
		
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
//		System.out.println("selectCntAll 끝 : " + count);
		return count;
	}

	@Override
	public Inquiry selectInquiryByInquiryno(Connection conn, Inquiry inquiryno) {
//		System.out.println("selectInquiryByInquiryno : " + inquiryno);
		String sql = "";
		sql += "SELECT";
		sql += "	inquiry_articleNumber, user_no, admin_no, board_code, inquiry_articleTitle, inquiry_content,";
		sql += "	inquiry_writer, inquiry_date, answer_writer, answer_content, answer_date";
		sql += " FROM cs_inquiry";
		sql += " WHERE inquiry_articleNumber = ?";
		
		Inquiry inquiry = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, inquiryno.getInquiryArticleNumber());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				inquiry = new Inquiry(); 
				
				inquiry.setInquiryArticleNumber(rs.getInt("inquiry_articleNumber"));
				inquiry.setUserNo(rs.getInt("user_no"));
				inquiry.setAdminNo(rs.getInt("admin_no"));
				inquiry.setBoardCode(rs.getInt("board_code"));
				inquiry.setInquiryArticleTitle(rs.getString("inquiry_articleTitle"));
				inquiry.setInquiryContent(rs.getString("inquiry_content"));
				inquiry.setInquiryWriter(rs.getString("inquiry_writer"));
				inquiry.setInquiryDate(rs.getDate("inquiry_date"));
				inquiry.setAnswerWriter(rs.getString("answer_writer"));
				inquiry.setAnswerContent(rs.getString("answer_content"));
				inquiry.setAnswerDate(rs.getDate("answer_date"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return inquiry;
	}

	@Override
	public List<Inquiry> selectSearchList(Connection conn, Paging paging, String searchType, String keyword) {
//		System.out.println("selectSearchList searchpaging 시작" + paging);
		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, I.* FROM (";
		sql += " 		SELECT";
		sql += "			inquiry_articleNumber, user_no, admin_no, board_code, inquiry_articleTitle,";
		sql += "			inquiry_content, inquiry_writer, inquiry_date, answer_writer, answer_content, answer_date";
		sql += " 		FROM cs_inquiry";
		sql += " 		WHERE " + searchType + " LIKE ?";
		sql += " 		ORDER BY inquiry_articleNumber DESC";
		sql += " 		) I";
		sql += " 	) Inquiry";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Inquiry> inquiryList = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Inquiry i = new Inquiry(); 
				
				i.setInquiryArticleNumber(rs.getInt("inquiry_articleNumber"));
				i.setUserNo(rs.getInt("user_no"));
				i.setAdminNo(rs.getInt("admin_no"));
				i.setBoardCode(rs.getInt("board_code"));
				i.setInquiryArticleTitle(rs.getString("inquiry_articleTitle"));
				i.setInquiryContent(rs.getString("inquiry_content"));
				i.setInquiryWriter(rs.getString("inquiry_writer"));
				i.setInquiryDate(rs.getDate("inquiry_date"));
				i.setAnswerWriter(rs.getString("answer_writer"));
				i.setAnswerContent(rs.getString("answer_content"));
				i.setAnswerDate(rs.getDate("answer_date"));
				
				inquiryList.add(i);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
//		System.out.println("selectSearchList searchpaging 끝" + paging);
//		System.out.println("selectSearchList()" + inquiryList);
		return inquiryList;
	}
	
	@Override
	public int selectSearchCntAll(Connection conn, String searchType, String keyword) {
//		System.out.println("selectSearchCntAll 시작" + searchType + keyword);
		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM (";
		sql += "	SELECT rownum rnum, I.* FROM (";
		sql += "		SELECT";
		sql += "			inquiry_articleNumber, user_no, admin_no, board_code, inquiry_articleTitle, inquiry_content,";
		sql += "			inquiry_writer, inquiry_date, answer_writer, answer_content, answer_date";
		sql += "		FROM cs_inquiry";
		sql += "		WHERE " + searchType + " LIKE ?";
		sql += "		) I";
		sql += "	) Inquiry";
		
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

	@Override
	public int updateAnswer(Connection conn, Inquiry inquiry) {

		String sql = "";
		sql += "UPDATE cs_inquiry";
		sql += " SET answer_writer = ?";
		sql += "	, answer_content = ?";
		sql += "	, answer_date = SYSDATE";
		sql += " WHERE inquiry_articleNumber = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, inquiry.getAnswerWriter());
			ps.setString(2, inquiry.getAnswerContent());
			ps.setInt(3, inquiry.getInquiryArticleNumber());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("insertAnswer : " + res);
		return res;
	}

	@Override
	public int delete(Connection conn, Inquiry inquiry) {
		
		String sql = "";
		sql += "DELETE cs_inquiry";
		sql += " WHERE inquiry_articleNumber = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, inquiry.getInquiryArticleNumber());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
		
	}

}
