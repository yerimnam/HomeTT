package reviewBoard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
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

		
        sql +=" SELECT R.*";
        sql +=" ,m.user_nick";
        sql +=" FROM board_review R";
        sql +=" inner join member m";
        sql +=" on m.user_no = R.user_no";
        

		
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
				r.setUserName(rs.getString("user_nick"));
				
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
		sql += " 		SELECT RR.*,m.user_nick,m.user_name";
		sql += " 		FROM board_review RR";
		sql += "		INNER JOIN member m";
		sql += "		ON m.user_no = RR.user_no";
//		sql += " 	SELECT *";
//		sql += "		review_articlenumber,admin_no,board_code,review_articletitle ";
//		sql += " 		,review_content,review_date,user_no,hit";
//		sql += " 	FROM board_review"; 
		sql += " 		ORDER BY review_articlenumber DESC";
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
				r.setReviewWriter(rs.getString("user_nick"));
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
		sql += "	SET hit = hit + 1";
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
		
		System.out.println("reviewArticlenumber : " + reviewArticlenumber);
		System.out.println("updateHit - 끝");	
		
		return res;
	}

	@Override
	public ReviewBoard selectBoardByreviewArticlenumber(Connection conn, ReviewBoard reviewArticlenumber) {
		System.out.println("selectBoardByreviewArticlenumber - 시작");	
		System.out.println("reviewArticlenumber.getReviewArticlenumber() : " + reviewArticlenumber.getReviewArticlenumber());
		String sql = "";
	
		sql += " SELECT * FROM (";
        sql += " 	SELECT R.*";
        sql += " 	,m.user_nick";
        sql += " 	FROM board_review R";
        sql += " 	inner join member m";
        sql += " 	on m.user_no = R.user_no";
        sql += " ) R ";
        sql += " WHERE review_articlenumber = ?";


//		sql += "SELECT";
//		sql += " review_articlenumber,review_articletitle";
//		sql += " ,review_content,hit,review_date ";
//		sql += " FROM board_review";
//		sql += " WHERE review_articlenumber = ?";
		
		ReviewBoard board= null;
		
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, reviewArticlenumber.getReviewArticlenumber());
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
					board.setUserName(rs.getString("user_nick"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}

			System.out.println("selectBoardByReviewArticlenumber - 끝");	
			System.out.println("board : " + board);
			System.out.println(board.getUserName());
		return board;
	}




	@Override
	public int insertreview(Connection conn, ReviewBoard param,int userNo) {
		System.out.println("insertreview시작");
		
		String sql ="";								
		sql +="INSERT INTO board_review (review_articlenumber,user_no,review_articletitle,review_content,review_date, hit)";
		sql +=" VALUES(BOARD_REVIEW_SEQ.nextval,?,?,?,sysdate, 0)"; //<- 마지막 ?를 0으로 수정
		
		

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
		System.out.println("리뷰노 " + reviewNo.getReviewArticlenumber());
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
		sql +=" WHERE review_articlenumber = ? ";
		
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

	
	@Override
	public List<ReviewBoard> selectSearchList(Connection conn, Paging paging, String searchType, String keyword) {
		System.out.println("selectSearchList searchpaging 시작" + paging);
		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += " 		SELECT RR.*,m.user_nick,m.user_name";
		sql += " 		FROM board_review RR";
		sql += "		INNER JOIN member m";
		sql += "		ON m.user_no = RR.user_no";
		sql += "		WHERE " + searchType + " LIKE ?";
		sql += " 		ORDER BY REVIEW_ARTICLENUMBER DESC";
		sql += " 		) R";
		sql += " 	) RIVIEW";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<ReviewBoard> reviewBoardList = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ReviewBoard r = new ReviewBoard();
				
				r.setReviewArticlenumber(rs.getInt("review_articlenumber"));
				r.setAdminNo(rs.getInt("admin_no"));
				r.setBoardCode(rs.getInt("board_code"));
				r.setReviewArticletitle(rs.getString("review_articletitle"));
				r.setReviewContent(rs.getString("review_content"));
				r.setReviewWriter(rs.getString("user_nick"));
				r.setReviewDate(rs.getDate("review_date"));
				r.setHit(rs.getInt("hit"));
				r.setUserName(rs.getString("user_name"));
				r.setUserNo(rs.getInt("user_no"));
				
				reviewBoardList.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectSearchList searchpaging 끝" + paging);
		System.out.println("selectSearchList()" + reviewBoardList);
		return reviewBoardList;
	}
	
	@Override
	public int selectSearchCntAll(Connection conn, String searchType, String keyword) {
		System.out.println("selectSearchCntAll 시작" + searchType + keyword);
		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += " 		SELECT RR.*,m.user_nick,m.user_name";
		sql += " 		FROM board_review RR";
		sql += "		INNER JOIN member m";
		sql += "		ON m.user_no = RR.user_no";
		sql += "		WHERE " + searchType + " LIKE ?";
		sql += "		) R";
		sql += "	) REVIEW";
		
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
	
	
	//---------------------------------------------------------------------------------------
//	public ArrayList<ReviewBoard> getSearch(String reviewArticletitle, String userName){//특정한 리스트를 받아서 반환
//		List<ReviewBoard> reviewboardList = new ArrayList<ReviewBoard>();
//	      String SQL ="select * from board_review WHERE "+reviewArticletitle.trim();//trim 문자열 앞 공백 제거
//	      try {
//	            if(userName != null && !userName.equals("") ){	//이거 빼면 안 나온다
//	                SQL +=" LIKE '%"+ userName.trim()+"%' order by userName desc limit 10";
//	            }
////	            PreparedStatement pstmt=conn.prepareStatement(SQL);
//	            reviewinquies pstmt=conn.prepareStatement(SQL);
//				rs=pstmt.executeQuery();//select
//	         while(rs.next()) {
//	        	 ReviewBoard s = new ReviewBoard();
//	            
//	        	 
//					s.setReviewArticlenumber(rs.getInt(1));
//					s.setAdminNo(rs.getInt(2));
//					s.setBoardCode(rs.getInt(3));
//					s.setReviewArticletitle(rs.getString(4));
//					s.setReviewContent(rs.getString(5)); 
//					s.setReviewDate(rs.getDate(6));				
//					s.setHit(rs.getInt(7));
//					s.setUserNo(rs.getInt(8));
//					s.setUserName(rs.getString(9));
//	            list.add(s);//list에 해당 인스턴스를 담는다.
//	         }         
//	      } catch(Exception e) {
//	         e.printStackTrace();
//	      }
//	      return list;//게시글 리스트 반환
//	   }
	//---------------------------------------------------------------------------------------

	
}
















