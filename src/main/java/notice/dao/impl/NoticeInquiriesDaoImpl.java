package notice.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import notice.dao.face.NoticeInquiriesDao;
import notice.dto.NoticeBoard;
import reviewBoard.dao.face.ReviewInquiriesDao;
import reviewBoard.dto.ReviewBoard;
import util.Paging;

public class NoticeInquiriesDaoImpl implements NoticeInquiriesDao {

	
	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	

	@Override
	public List<NoticeBoard> selectAll(Connection conn) {
		System.out.println("NoticeBoardDao selectAll - 시작");

		
		//SQL작성
		String sql = "";

		sql += "SELECT * FROM cs_notice";
//        sql +=" SELECT N.*";
//        sql +=" ,m.user_nick";
//        sql +=" FROM cs_notice N";
//        sql +=" inner join member m";
//        sql +=" on m.user_no = N.user_no";
        

		
		//결과 저장할 List
		List<NoticeBoard> noticeboardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				NoticeBoard r = new NoticeBoard();//조회결과 행 저장 DTO 객체

				r.setNoticeArticlenumber(rs.getInt("notice_articlenumber"));
//				r.setAdminNo(rs.getInt("admin_no"));
//				r.setBoardCode(rs.getInt("board_code"));
				r.setNoticeArticletitle(rs.getString("notice_articletitle"));
				r.setNoticeContent(rs.getString("notice_content"));
				r.setNoticeDate(rs.getDate("notice_date"));
//				r.setUserNo(rs.getInt("user_no"));
				r.setHit(rs.getInt("hit"));
//				r.setUserName(rs.getString("user_nick"));
				
				//리스트에 결과값 저장하기
				noticeboardList.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		System.out.println("NoticeBoardDao selectAll - 끝");
		return noticeboardList; //최종 결과 반환
	}
	
	
	@Override
	public List<NoticeBoard> selectAll(Connection conn, Paging paging) {
		System.out.println("NoticeBoard selectAll - 시작");
		
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM ( ";
		sql += " 	SELECT rownum rnum, R.*FROM (";
//		sql += " 		SELECT RR.*,m.user_nick,m.user_name";
		sql += "		SELECT * FROM cs_notice";
//		sql += " 		FROM cs_notice RR";
//		sql += "		INNER JOIN member m";
//		sql += "		ON m.user_no = RR.user_no";
//		sql += " 	SELECT *";
//		sql += "		notice_articlenumber,admin_no,board_code,notice_articletitle ";
//		sql += " 		,notice_content,notice_date,user_no,hit";
//		sql += " 	FROM cs_notice"; 
		sql += " 		ORDER BY notice_articlenumber DESC";
		sql += " 	) R";
		sql += " ) noticeBaord";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<NoticeBoard>noticeboardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				NoticeBoard r = new NoticeBoard();//조회결과 행 저장 DTO 객체

				r.setNoticeArticlenumber(rs.getInt("notice_articlenumber"));
//				r.setAdminNo(rs.getInt("admin_no"));
//				r.setBoardCode(rs.getInt("board_code"));
				r.setNoticeArticletitle(rs.getString("notice_articletitle"));
				r.setNoticeContent(rs.getString("notice_content")); 
				r.setNoticeDate(rs.getDate("notice_date"));		
//				r.setNoticeWriter(rs.getString("user_nick"));
				r.setHit(rs.getInt("hit"));
//				r.setUserNo(rs.getInt("user_no"));
				//리스트에 결과값 저장하기
				noticeboardList.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		System.out.println("NoticeBoard selectAll - 끝");
		return noticeboardList; //최종 결과 반환
	}
	
	
//  
	@Override
	public int selectCntAll(Connection conn) {
		System.out.println("selectCntAll - 시작");	
		String sql = "";
		sql += "SELECT count(*) cnt FROM cs_notice";
		
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
		sql += "	SET hit = hit + 1";
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
		
		System.out.println("noticeArticlenumber : " + noticeArticlenumber);
		System.out.println("updateHit - 끝");	
		
		return res;
	}

	@Override
	public NoticeBoard selectBoardBynoticeArticlenumber(Connection conn, NoticeBoard noticeArticlenumber) {
		System.out.println("selectBoardByNoticeArticlenumber - 시작");	
		System.out.println("NoticeArticlenumber.getNoticeArticlenumber() : " + noticeArticlenumber.getNoticeArticlenumber());
		String sql = "";
		
		sql += " SELECT * FROM cs_notice";
//		sql	+= "SELECT * FROM cs_notice";
//        sql += " 	SELECT R.*";
//        sql += " 	,m.user_nick";
//        sql += " 	FROM cs_notice R";
//        sql += " 	inner join member m";
//        sql += " 	on m.user_no = R.user_no";
//        sql += " ) R ";
//		sql += "SELECT * FROM cs_notice";
        sql += " WHERE notice_articlenumber = ?";
		
		NoticeBoard board= new NoticeBoard();
		
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, noticeArticlenumber.getNoticeArticlenumber());
				rs = ps.executeQuery();
				
				while( rs.next() ) {

					board.setNoticeArticlenumber(rs.getInt("notice_articlenumber"));
//					board.setAdminNo(rs.getInt("admin_no"));
//					board.setBoardCode(rs.getInt("board_code"));
					board.setNoticeArticletitle(rs.getString("notice_articletitle"));
					board.setNoticeContent(rs.getString("notice_content")); 
					board.setNoticeDate(rs.getDate("notice_date"));				
					board.setHit(rs.getInt("hit"));
//					board.setUserNo(rs.getInt("user_no"));
//					board.setUserName(rs.getString("user_nick"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}

			System.out.println("selectBoardByNoticeArticlenumber - 끝");	
			System.out.println("board : " + board);
			System.out.println(board.getUserName());
		return board;
	}




	@Override
	public int insertnotice(Connection conn, NoticeBoard param,int userNo) {
		System.out.println("insertnotice시작");
		
		String sql ="";								
		sql +="INSERT INTO cs_notice (notice_articlenumber,notice_articletitle,notice_content,notice_date, hit)";
		sql +=" VALUES(cs_notice_SEQ.nextval,?,?,sysdate, 0)"; //<- 마지막 ?를 0으로 수정
		
		

		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
		
			ps.setString(1, param.getNoticeArticletitle());
			ps.setString(2, param.getNoticeContent());
		 result = ps.executeUpdate();
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("noticeinsert_end");
		return result;
	}


	@Override
	public NoticeBoard selectcontent(Connection conn, NoticeBoard noticeNo) {
		System.out.println("selectcontent -start");
		System.out.println("리뷰노 " + noticeNo.getNoticeArticlenumber());
		String sql ="";
		sql +="SELECT * FROM cs_notice";
		sql +=" WHERE notice_articlenumber =?";
		
		NoticeBoard updateContent = null;
		try {
			ps =conn.prepareStatement(sql);
			
			
			ps.setInt(1, noticeNo.getNoticeArticlenumber());
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				
				updateContent = new NoticeBoard();
				updateContent.setNoticeArticlenumber(rs.getInt("notice_articlenumber"));
				updateContent.setNoticeArticletitle(rs.getString("notice_articletitle"));
				updateContent.setUserNo(rs.getInt("user_no"));
				updateContent.setNoticeContent(rs.getString("notice_content"));
				updateContent.setNoticeDate(rs.getDate("notice_date"));;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		
		return updateContent ;
	}


	@Override
	public int updateDo(Connection conn, NoticeBoard noticeNum) {
		System.out.println("updateDo 시작");
		
		String sql ="";
		sql +="UPDATE cs_notice";
		sql +=" SET notice_articletitle =?,notice_content=?";
		sql +=" WHERE notice_articlenumber =?";
		
		System.out.println(noticeNum);
		
		int result =0;
		try {
			ps =conn.prepareStatement(sql);
			
			ps.setString(1, noticeNum.getNoticeArticletitle());
			ps.setString(2, noticeNum.getNoticeContent());
			ps.setInt(3, noticeNum.getNoticeArticlenumber());
			
			result = ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(ps);
		}
		System.out.println("updateDo end");
	return result;
	}


	@Override
	public int deleteDo(Connection conn, NoticeBoard noticeNo) {
	System.out.println("deleteDo 시작");
		
		String sql ="";
		sql +="DELETE cs_notice";
		sql +=" WHERE notice_articlenumber = ? ";
		
		int deletenotice  =0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, noticeNo.getNoticeArticlenumber());
			
			deletenotice = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(ps);
		}
		
		
		System.out.println("deleteDo 끝");
		return deletenotice;
	}

	
	@Override
	public List<NoticeBoard> selectSearchList(Connection conn, Paging paging, String searchType, String keyword) {
		System.out.println("selectSearchList searchpaging 시작" + paging);
		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += " 		SELECT RR.*,m.user_nick,m.user_name";
		sql += " 		FROM cs_notice RR";
		sql += "		INNER JOIN member m";
		sql += "		ON m.user_no = RR.user_no";
		sql += "		WHERE " + searchType + " LIKE ?";
		sql += " 		ORDER BY Notice_ARTICLENUMBER DESC";
		sql += " 		) R";
		sql += " 	) RIVIEW";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<NoticeBoard> noticeBoardList = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				NoticeBoard r = new NoticeBoard();
				
				r.setNoticeArticlenumber(rs.getInt("notice_articlenumber"));
				r.setAdminNo(rs.getInt("admin_no"));
				r.setBoardCode(rs.getInt("board_code"));
				r.setNoticeArticletitle(rs.getString("notice_articletitle"));
				r.setNoticeContent(rs.getString("notice_content"));
				r.setNoticeWriter(rs.getString("user_nick"));
				r.setNoticeDate(rs.getDate("notice_date"));
				r.setHit(rs.getInt("hit"));
				r.setUserName(rs.getString("user_name"));
				r.setUserNo(rs.getInt("user_no"));
				
				noticeBoardList.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectSearchList searchpaging 끝" + paging);
		System.out.println("selectSearchList()" + noticeBoardList);
		return noticeBoardList;
	}
	
	@Override
	public int selectSearchCntAll(Connection conn, String searchType, String keyword) {
		System.out.println("selectSearchCntAll 시작" + searchType + keyword);
		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += " 		SELECT RR.*,m.user_nick,m.user_name";
		sql += " 		FROM cs_notice RR";
		sql += "		INNER JOIN member m";
		sql += "		ON m.user_no = RR.user_no";
		sql += "		WHERE " + searchType + " LIKE ?";
		sql += "		) R";
		sql += "	) Notice";
		
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
		System.out.println("selectSearchCntAll 끝" + searchType + keyword);
		System.out.println("selectSearchCntAll" + count);
		return count;
	}
	
	

	
}
















