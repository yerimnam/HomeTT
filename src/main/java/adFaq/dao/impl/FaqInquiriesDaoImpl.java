package adFaq.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import adEvent.common.JDBCTemplate;
import adFaq.dao.face.FaqInquiriesDao;
import adFaq.dto.FaqBoard;
import util.Paging;

public class FaqInquiriesDaoImpl implements FaqInquiriesDao {
	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	
	
	@Override
	public List<FaqBoard> selectAll(Connection conn) {
		System.out.println("FaqBoardDao selectAll - 시작");
		
		
		//SQL작성
		String sql = "";
		sql += "SELECT";
		sql += "	faq_articlenumber, admin_no, board_code, faq_articletitle ";
		sql += " ,faq_content,faq_writer,faq_date";
		sql += " FROM cs_faq"; 
		sql += " ORDER BY board_code DESC";
		
		//결과 저장할 List
		List<FaqBoard> faqboardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				FaqBoard b = new FaqBoard();//조회결과 행 저장 DTO 객체

				b.setFaqArticlenumber(rs.getInt("faq_articlenumber"));
				b.setAdminNo(rs.getInt("admin_no"));
				b.setBoardCode(rs.getInt("board_code"));
				b.setFaqArticletitle(rs.getString("faq_articletitle"));
				b.setFaqContent(rs.getString("faq_content"));
				b.setFaqWriter(rs.getString("faq_writer"));
				b.setFaqDate(rs.getDate("faq_date"));
				b.setHit(rs.getInt("hit"));
				
				//리스트에 결과값 저장하기
				faqboardList.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		System.out.println("FaqBoardDao selectAll - 끝");
		return faqboardList; //최종 결과 반환
	}
	
	
	@Override
	public List<FaqBoard> selectAll(Connection conn, Paging paging) {
		System.out.println("FaqBoardDao selectAll - 시작");
		
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM ( ";
		sql += " 	SELECT rownum rnum, B.*FROM (";
		sql += " 	SELECT";
		sql += "		faq_articlenumber, admin_no, board_code, faq_articletitle ";
		sql += " 		,faq_content,faq_writer,faq_date";
		sql += " 	FROM cs_faq"; 
		sql += " 	ORDER BY board_code DESC";
		sql += " 	) B";
		sql += " ) cs_faq";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<FaqBoard> faqboardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				FaqBoard b = new FaqBoard();//조회결과 행 저장 DTO 객체

				b.setFaqArticlenumber(rs.getInt("faq_articlenumber"));
				b.setAdminNo(rs.getInt("admin_no"));
				b.setBoardCode(rs.getInt("board_code"));
				b.setFaqArticletitle(rs.getString("faq_articletitle"));
				b.setFaqContent(rs.getString("faq_content"));
				b.setFaqWriter(rs.getString("faq_writer"));
				b.setFaqDate(rs.getDate("faq_date"));
				b.setHit(rs.getInt("hit"));
				
				//리스트에 결과값 저장하기
				faqboardList.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		System.out.println("FaqBoardDao selectAll - 끝");
		return faqboardList; //최종 결과 반환
	}
	
	
//  
	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM board";
		
		//총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			
			while(rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		//최종 결과 반환
		return count;
	}


		


}
