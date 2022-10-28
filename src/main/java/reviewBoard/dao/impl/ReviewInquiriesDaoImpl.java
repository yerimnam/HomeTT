package reviewBoard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import event.common.JDBCTemplate;
import reviewBoard.dao.face.ReviewInquiriesDao;
import reviewBoard.dto.ReviewBoard;
import util.Paging;

public class ReviewInquiriesDaoImpl implements ReviewInquiriesDao {

	
	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	

	@Override
	public List<ReviewBoard> selectAll(Connection conn) {
		System.out.println("ReviewBoardDao selectAll - 시작");
		
		
		//SQL작성
		String sql = "";
		sql += "SELECT";
		sql += "	review_articlenumber, admin_no, board_code, review_articletitle ";
		sql += " ,review_content,review_date,user_no,hit";
		sql += " FROM board_review"; 
		sql += " ORDER BY review_Articlenumber DESC";
		
		//결과 저장할 List
		List<ReviewBoard> reviewboardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				ReviewBoard r = new ReviewBoard();//조회결과 행 저장 DTO 객체

				r.setReviewArticlenumber(rs.getInt("review_articlenumber"));
				r.setAdminNo(rs.getInt("admin_no"));
				r.setBoardCode(rs.getInt("board_code"));
				r.setReviewArticletitle(rs.getString("review_articletitle"));
				r.setReviewContent(rs.getString("review_content"));
				r.setReviewDate(rs.getDate("review_date"));
				r.setUserNo(rs.getInt("user_no"));
				r.setHit(rs.getInt("hit"));
				
				//리스트에 결과값 저장하기
				reviewboardList.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		System.out.println("ReviewBoardDao selectAll - 끝");
		return reviewboardList; //최종 결과 반환
	}
	
	
	@Override
	public List<ReviewBoard> selectAll(Connection conn, Paging paging) {
		System.out.println("ReviewBoard selectAll - 시작");
		
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM ( ";
		sql += " 	SELECT rownum rnum, R.*FROM (";
		sql += " 	SELECT";
		sql += "		review_articlenumber,admin_no,board_code,review_articletitle ";
		sql += " 		,review_content,review_date,user_no,hit";
		sql += " 	FROM board_review"; 
		sql += " 	ORDER BY review_articlenumber DESC";
		sql += " 	) R";
		sql += " ) reviewBaord";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<ReviewBoard>reviewboardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				ReviewBoard r = new ReviewBoard();//조회결과 행 저장 DTO 객체

				r.setReviewArticlenumber(rs.getInt("review_articlenumber"));
				r.setAdminNo(rs.getInt("admin_no"));
				r.setBoardCode(rs.getInt("board_code"));
				r.setReviewArticletitle(rs.getString("review_articletitle"));
				r.setReviewContent(rs.getString("review_content")); 
				r.setReviewDate(rs.getDate("review_date"));				
				r.setHit(rs.getInt("hit"));
				r.setUserNo(rs.getInt("user_no"));
				//리스트에 결과값 저장하기
				reviewboardList.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		System.out.println("reviewBoard selectAll - 끝");
		return reviewboardList; //최종 결과 반환
	}
	
	
//  
	@Override
	public int selectCntAll(Connection conn) {
		System.out.println("selectCntAll - 시작");	
		String sql = "";
		sql += "SELECT count(*) cnt FROM board_review";
		
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
	public int updateHit(Connection conn, ReviewBoard reviewArticlenumber) {
		
		System.out.println("updateHit - 시작");	
		String sql = "";
		sql += "UPDATE board_review"; 
		sql += "	SET hit = hit +1";
		sql += " WHERE review_Articlenumber = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reviewArticlenumber.getReviewArticlenumber());
			
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
	public ReviewBoard selectBoardByreviewArticlenumber(Connection conn, ReviewBoard reviewArticlenumber) {
		System.out.println("selectBoardByreviewArticlenumber - 시작");	
		
		String sql = "";
		sql += "SELECT";
		sql +=" 	review_articlenumber,admin_no,board_code,review_articletitle,";
		sql +="		 review_content,review_date,user_no,hit ";
		sql +=" FROM board_review";
		sql +=" WHERE review_articlenumber = ?";
		
		ReviewBoard board= null;
		
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1 , reviewArticlenumber.getReviewArticlenumber());
				
				rs = ps.executeQuery();
				
				while(rs.next() ) {
					board = new ReviewBoard();
					

					

					board.setReviewArticlenumber(rs.getInt("review_articlenumber"));
					board.setAdminNo(rs.getInt("admin_no"));
					board.setBoardCode(rs.getInt("board_code"));
					board.setReviewArticletitle(rs.getString("review_articletitle"));
					board.setReviewContent(rs.getString("review_content")); 
					board.setReviewDate(rs.getDate("review_date"));				
					board.setHit(rs.getInt("hit"));
					board.setUserNo(rs.getInt("user_no"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}

			System.out.println("selectBoardByReviewArticlenumber - 끝");	
		return board;
	}




	@Override
	public int insertreview(Connection conn, ReviewBoard param,int userNo) {
		System.out.println("insertreview시작");
		
		String sql ="";								
		sql +="INSERT INTO board_review (review_articlenumber,user_no,review_articletitle,review_content,review_date)";
		sql +=" VALUES(review_seq.nextval,?,?,?,sysdate)";
		
		

		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
		
			ps.setInt(1, userNo);
			ps.setString(2, param.getReviewArticletitle());
			ps.setString(3, param.getReviewContent());
		 result = ps.executeUpdate();
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("reviewinsert_end");
		return result;
	}


	@Override
	public ReviewBoard selectcontent(Connection conn, ReviewBoard reviewNo) {
		System.out.println("selectcontent -start");
		
		String sql ="";
		sql +="SELECT * FROM board_review";
		sql +=" WHERE review_articlenumber =?";
		
		ReviewBoard updateContent = null;
		try {
			ps =conn.prepareStatement(sql);

			ps.setInt(1, reviewNo.getReviewArticlenumber());
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				
				updateContent = new ReviewBoard();
				updateContent.setReviewArticlenumber(rs.getInt("review_articlenumber"));
				updateContent.setReviewArticletitle(rs.getString("review_articletitle"));
				updateContent.setUserNo(rs.getInt("user_no"));
				updateContent.setReviewContent(rs.getString("review_content"));
				updateContent.setReviewDate(rs.getDate("review_date"));;
				
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
	public int updateDo(Connection conn, ReviewBoard reviewNum) {
		System.out.println("updateDo 시작");
		
		String sql ="";
		sql +="UPDATE board_review";
		sql +=" SET review_articletitle =?,review_content=?";
		sql +=" WHERE review_articlenumber =?";
		
		System.out.println(reviewNum);
		
		int result =0;
		try {
			ps =conn.prepareStatement(sql);
			
			ps.setString(1, reviewNum.getReviewArticletitle());
			ps.setString(2, reviewNum.getReviewContent());
			ps.setInt(3, reviewNum.getReviewArticlenumber());
			
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
	public int deleteDo(Connection conn, ReviewBoard reviewNo) {
	System.out.println("deleteDo 시작");
		
		String sql ="";
		sql +="DELETE board_review";
		sql +=" WHERE review_articlenumber =? ";
		
		int deletereview  =0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reviewNo.getReviewArticlenumber());
			
			deletereview = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(ps);
		}
		
		
		System.out.println("deleteDo 끝");
		return deletereview;
	}
	
}
















