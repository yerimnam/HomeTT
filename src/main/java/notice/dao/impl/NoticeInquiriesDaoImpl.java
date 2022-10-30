package notice.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import event.common.JDBCTemplate;
import notice.dao.face.NoticeInquiriesDao;
import notice.dto.NoticeBoard;
import util.Paging;

public class NoticeInquiriesDaoImpl implements NoticeInquiriesDao {
	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	
	
	@Override
	public List<NoticeBoard> selectAll(Connection conn) {
		System.out.println("FaqBoardDao selectAll - 시작");
		
		
		//SQL작성
		String sql = "";
		sql += "SELECT";
		sql += "	notice_articlenumber, admin_no, board_code, notice_articletitle ";
		sql += " ,notice_content,notice_writer,notice_date";
		sql += " FROM cs_notice"; 
		sql += " ORDER BY notice_Articlenumber DESC";
		
		//결과 저장할 List
		List<NoticeBoard> noticeboardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				NoticeBoard n = new NoticeBoard();//조회결과 행 저장 DTO 객체

				n.setNoticeArticlenumber(rs.getInt("notice_articlenumber"));
				n.setAdminNo(rs.getInt("admin_no"));
				n.setBoardCode(rs.getInt("board_code"));
				n.setNoticeArticletitle(rs.getString("notice_articletitle"));
				n.setNoticeContent(rs.getString("notice_content"));
				n.setNoticeWriter(rs.getString("notice_writer"));
				n.setNoticeDate(rs.getDate("notice_date"));
				n.setHit(rs.getInt("hit"));
				
				//리스트에 결과값 저장하기
				noticeboardList.add(n);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		System.out.println("FaqBoardDao selectAll - 끝");
		return noticeboardList; //최종 결과 반환
	}
	
	
	@Override
	public List<NoticeBoard> selectAll(Connection conn, Paging paging) {
		System.out.println("NoticeBoard selectAll - 시작");
		
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM ( ";
		sql += " 	SELECT rownum rnum, N.*FROM (";
		sql += " 	SELECT";
		sql += "		notice_articlenumber,admin_no,board_code,notice_articletitle ";
		sql += " 		,notice_content,notice_writer,notice_date,hit";
		sql += " 	FROM cs_notice"; 
		sql += " 	ORDER BY notice_articlenumber DESC";
		sql += " 	) N";
		sql += " ) noticeBaord";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<NoticeBoard> noticeboardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				NoticeBoard n = new NoticeBoard();//조회결과 행 저장 DTO 객체

				n.setNoticeArticlenumber(rs.getInt("notice_articlenumber"));
				n.setAdminNo(rs.getInt("admin_no"));
				n.setBoardCode(rs.getInt("board_code"));
				n.setNoticeArticletitle(rs.getString("notice_articletitle"));
				n.setNoticeContent(rs.getString("notice_content")); 
				n.setNoticeWriter(rs.getString("notice_writer"));
				n.setNoticeDate(rs.getDate("notice_date"));				
				n.setHit(rs.getInt("hit"));
				
				//리스트에 결과값 저장하기
				noticeboardList.add(n);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		System.out.println("FaqBoard selectAll - 끝");
		return noticeboardList; //최종 결과 반환
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
	public int updateHit(Connection conn, NoticeBoard noticeArticlenumber) {
		
		System.out.println("updateHit - 시작");	
		String sql = "";
		sql += "UPDATE cs_notice"; 
		sql += "	SET hit = hit +1";
		sql += " WHERE notice_Articlenumber = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, noticeArticlenumber.getNoticeArticlenumber());
			
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
	public NoticeBoard selectBoardBynoticeArticlenumber(Connection conn, NoticeBoard noticeArticlenumber) {
		System.out.println("selectBoardByfaqArticlenumber - 시작");	
		
		String sql = "";
		sql += "SELECT";
		sql +=" 	notice_articlenumber,admin_no,board_code,notice_articletitle";
		sql +="		 notice_content,notice_writer,notice_date,hit ";
		sql +=" FROM cs_notice";
		sql +=" WHERE notice_articlenumber = ?";
		
		NoticeBoard board= null;
		
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1 , noticeArticlenumber.getNoticeArticlenumber());
				
				rs = ps.executeQuery();
				
				while(rs.next() ) {
					board = new NoticeBoard();
					
					board.setNoticeArticlenumber(rs.getInt("notice_articlenumber"));
					board.setAdminNo(rs.getInt("admin_no"));
					board.setBoardCode(rs.getInt("boardcode"));
					board.setNoticeArticletitle(rs.getString("notice_articletitle"));
					board.setNoticeContent(rs.getString("notice_content"));
					board.setNoticeWriter(rs.getString("notice_writer"));
					board.setNoticeDate(rs.getDate("notice_date"));
					board.setHit(rs.getInt("hit"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}

			System.out.println("selectBoardBynoticeArticlenumber - 끝");	
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
