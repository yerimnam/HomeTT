package faq.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import event.common.JDBCTemplate;
import faq.dao.face.FaqInquiriesDao;
import faq.dto.FaqBoard;
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
		sql += " ORDER BY faq_Articlenumber DESC";
		
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
		System.out.println("FaqBoard selectAll - 시작");
		
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM ( ";
		sql += " 	SELECT rownum rnum, B.*FROM (";
		sql += " 	SELECT";
		sql += "		faq_articlenumber,admin_no,board_code,faq_articletitle ";
		sql += " 		,faq_content,faq_writer,faq_date,hit";
		sql += " 	FROM cs_faq"; 
		sql += " 	ORDER BY faq_articlenumber DESC";
		sql += " 	) B";
		sql += " ) faqBaord";
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

//				b.setFaqArticlenumber(rs.getInt("faq_articlenumber"));
				b.setFaqArticlenumber(rs.getInt("faq_articlenumber"));
//				b.setAdminNo(rs.getInt("admin_no"));
				b.setAdminNo(rs.getInt("admin_no"));
//				b.setBoardCode(rs.getInt("board_code"));
				b.setBoardCode(rs.getInt("board_code"));
//				b.setFaqArticletitle(rs.getString("faq_articletitle"));
				b.setFaqArticletitle(rs.getString("faq_articletitle"));
//				b.setFaqContent(rs.getString("faq_content"));
				b.setFaqContent(rs.getString("faq_content")); 
//				b.setFaqWriter(rs.getString("faq_writer"));
				b.setFaqWriter(rs.getString("faq_writer"));
//				b.setFaqDate(rs.getDate("faq_write"));		<--에러 (잘못적음)
				b.setFaqDate(rs.getDate("faq_date"));				
//				b.setHit(rs.getInt("hit"));
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
				
		System.out.println("FaqBoard selectAll - 끝");
		return faqboardList; //최종 결과 반환
	}
	
	
//  
	@Override
	public int selectCntAll(Connection conn) {
		System.out.println("selectCntAll - 시작");	
		String sql = "";
//		sql += "SELECT count(*) cnt FROM board";
		sql += "SELECT count(*) cnt FROM cs_faq";
		
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
		System.out.println("selectCntAll - 끝");	
		//최종 결과 반환
		return count;
	}


	@Override
	public int updateHit(Connection conn, FaqBoard faqArticlenumber) {
		
		System.out.println("updateHit - 시작");	
		String sql = "";
		sql += "UPDATE cs_faq"; 
		sql += "	SET hit = hit +1";
		sql += " WHERE faq_Articlenumber = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, faqArticlenumber.getFaqArticlenumber());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("updateHit - 끝");	
		
		return res;
	}
 

	@Override
	public FaqBoard selectBoardByfaqArticlenumber(Connection conn, FaqBoard faqArticlenumber) {
		System.out.println("selectBoardByfaqArticlenumber - 시작");	
		
		String sql = "";
		sql += "SELECT";
		sql +=" 	faq_articlenumber,admin_no,board_code,faq_articletitle";
		sql +="		 faq_content,faq_writer,faq_date,hit ";
		sql +=" FROM cs_Faq";
		sql +=" WHERE faq_articlenumber = ?";
		
		FaqBoard board= null;
		
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1 , faqArticlenumber.getFaqArticlenumber());
				
				rs = ps.executeQuery();
				
				while(rs.next() ) {
					board = new FaqBoard();
					
					board.setFaqArticlenumber(rs.getInt("faq_articlenumber"));
					board.setAdminNo(rs.getInt("admin_no"));
					board.setBoardCode(rs.getInt("boardcode"));
					board.setFaqArticletitle(rs.getString("faq_articletitle"));
					board.setFaqContent(rs.getString("faq_content"));
					board.setFaqWriter(rs.getString("faq_writer"));
					board.setFaqDate(rs.getDate("faq_date"));
					board.setHit(rs.getInt("hit"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}

			System.out.println("selectBoardByfaqArticlenumber - 끝");	
		return board;
	}
//	
////	@Override
////	public String selectNickByBoard(Connection conn, Board viewBoard) {
////		
////		String sql = "";
////		sql += "SELECT usernick FROM member";
////		sql += " WHERE userid = ?";
////		
////		//결과 저장할 변수
////		String usernick = null;
////		
////		try {
////			ps = conn.prepareStatement(sql);
////			ps.setString(1, viewBoard.getUserid());
////
////			rs = ps.executeQuery();
////			
////			while( rs.next() ) {
////				usernick = rs.getString("usernick");
////			}
////			
////		} catch (SQLException e) {
////			e.printStackTrace();
////		} finally {
////			JDBCTemplate.close(rs);
////			JDBCTemplate.close(ps);
////		}
////		
////		return usernick;
////	}
//	@Override
//	public int insert(Connection conn, FaqBoard board) {
//
//		String sql = "";
//		sql += "INSERT INTO board ( faqArticlenumber, faqArticletitle, faqWriter, faqContent, hit )";
//		sql += " VALUES ( ?, ?, ?, ?, 0 )";
//		
//		int res = 0;
//
//		try {
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, board.getFaqArticlenumber());
//			ps.setString(2, board.getFaqArticletitle());
//			ps.setString(3, board.getFaqWriter());
//			ps.setString(4, board.getFaqContent());
//			
//			res = ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(ps);
//		}
//		
//		return res;
//	}
//		
//	
//	@Override
//	public int selectNextFaqArticlenumber(Connection conn) {
//		
//		String sql = "";
//		sql += "SELECT board_seq.nextval FROM dual";	//<--수정해야하는 부분
//		
//		int nextfaqarticlenumber = 0;
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			
//			rs = ps.executeQuery();
//			
//			while( rs.next() ) {
//				nextfaqarticlenumber = rs.getInt("nextval");
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		return nextfaqarticlenumber;
//	}
//	
//
//	@Override
//	public int insertFile(Connection conn, BoardFile boardFile) {
//		
//		String sql = "";
//		sql += "INSERT INTO boardfile( fileno, boardno, originname, storedname, filesize )";
//		sql += " VALUES( boardfile_seq.nextval, ?, ?, ?, ? )";
//		
//		int res = 0;
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, boardFile.getBoardno());
//			ps.setString(2, boardFile.getOriginname());
//			ps.setString(3, boardFile.getStoredname());
//			ps.setInt(4, boardFile.getFilesize());
//			
//			res = ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(ps);
//		}
//		
//		return res;
//	}


}
