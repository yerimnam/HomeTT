package event.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import event.dao.face.EventInquiriesDao;
import event.dto.EventBoard;
import util.Paging;

public class EventInquiriesDaoImpl implements EventInquiriesDao {

	
	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	

	@Override
	public List<EventBoard> selectAll(Connection conn) {
		System.out.println("EventBoardDao selectAll - 시작");

		
		//SQL작성
		String sql = "";

		sql += "SELECT * FROM cs_event";
//        sql +=" SELECT N.*";
//        sql +=" ,m.user_nick";
//        sql +=" FROM cs_event N";
//        sql +=" inner join member m";
//        sql +=" on m.user_no = N.user_no";
        

		
		//결과 저장할 List
		List<EventBoard> eventboardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				EventBoard r = new EventBoard();//조회결과 행 저장 DTO 객체

				r.setEventArticlenumber(rs.getInt("event_articlenumber"));
//				r.setAdminNo(rs.getInt("admin_no"));
//				r.setBoardCode(rs.getInt("board_code"));
				r.setEventArticletitle(rs.getString("event_articletitle"));
				r.setEventContent(rs.getString("event_content"));
				r.setEventDate(rs.getDate("event_date"));
//				r.setUserNo(rs.getInt("user_no"));
				r.setHit(rs.getInt("hit"));
//				r.setUserName(rs.getString("user_nick"));
				
				//리스트에 결과값 저장하기
				eventboardList.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		System.out.println("EventBoardDao selectAll - 끝");
		return eventboardList; //최종 결과 반환
	}
	
	
	@Override
	public List<EventBoard> selectAll(Connection conn, Paging paging) {
		System.out.println("EventBoard selectAll - 시작");
		
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM ( ";
		sql += " 	SELECT rownum rnum, R.*FROM (";
		sql += "		SELECT * FROM cs_event";
//		sql += " 		SELECT RR.*,m.user_nick,m.user_name";
//		sql += " 		FROM cs_event RR";
//		sql += "		INNER JOIN member m";
//		sql += "		ON m.user_no = RR.user_no";
//		sql += " 	SELECT *";
//		sql += "		event_articlenumber,admin_no,board_code,event_articletitle ";
//		sql += " 		,event_content,event_date,user_no,hit";
//		sql += " 	FROM cs_event";
		sql += " 		ORDER BY event_articlenumber DESC";
		sql += " 	) R";
		sql += " ) eventBaord";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<EventBoard>eventboardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				EventBoard r = new EventBoard();//조회결과 행 저장 DTO 객체

				r.setEventArticlenumber(rs.getInt("event_articlenumber"));
//				r.setAdminNo(rs.getInt("admin_no"));
//				r.setBoardCode(rs.getInt("board_code"));
				r.setEventArticletitle(rs.getString("event_articletitle"));
				r.setEventContent(rs.getString("event_content")); 
				r.setEventDate(rs.getDate("event_date"));		
//				r.setEventWriter(rs.getString("user_nick"));
				r.setHit(rs.getInt("hit"));
//				r.setUserNo(rs.getInt("user_no"));
				//리스트에 결과값 저장하기
				eventboardList.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		System.out.println("EventBoard selectAll - 끝");
		return eventboardList; //최종 결과 반환
	}
	
	
//  
	@Override
	public int selectCntAll(Connection conn) {
		System.out.println("selectCntAll - 시작");	
		String sql = "";
		sql += "SELECT count(*) cnt FROM cs_event";
		
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
	public int updateHit(Connection conn, EventBoard eventArticlenumber) {
		
		System.out.println("updateHit - 시작");	
		String sql = "";
		sql += "UPDATE cs_event"; 
		sql += "	SET hit = hit + 1";
		sql += " WHERE event_Articlenumber = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eventArticlenumber.getEventArticlenumber());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("eventArticlenumber : " + eventArticlenumber);
		System.out.println("updateHit - 끝");	
		
		return res;
	}

	@Override
	public EventBoard selectBoardByeventArticlenumber(Connection conn, EventBoard eventArticlenumber) {
		System.out.println("selectBoardByEventArticlenumber - 시작");	
		System.out.println("EventArticlenumber.getEventArticlenumber() : " + eventArticlenumber.getEventArticlenumber());
		String sql = "";
	
//		sql += " SELECT * FROM (";
//        sql += " 	SELECT R.*";
//        sql += " 	,m.user_nick";
//        sql += " 	FROM cs_event R";
//        sql += " 	inner join member m";
//        sql += " 	on m.user_no = R.user_no";
//        sql += " ) R ";
		sql += "SELECT * FROM cs_event";
        sql += " WHERE event_articlenumber = ?";
		

		
		EventBoard board= null;
		
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, eventArticlenumber.getEventArticlenumber());
				rs = ps.executeQuery();
				
				while(rs.next() ) {
					board = new EventBoard();

					board.setEventArticlenumber(rs.getInt("event_articlenumber"));
//					board.setAdminNo(rs.getInt("admin_no"));
//					board.setBoardCode(rs.getInt("board_code"));
					board.setEventArticletitle(rs.getString("event_articletitle"));
					board.setEventContent(rs.getString("event_content")); 
					board.setEventDate(rs.getDate("event_date"));				
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

			System.out.println("selectBoardByEventArticlenumber - 끝");	
			System.out.println("board : " + board);
			System.out.println(board.getUserName());
		return board;
	}




	@Override
	public int insertevent(Connection conn, EventBoard param, int userNo) {
		System.out.println("insertevent시작");
		
		String sql ="";								
		sql +="INSERT INTO cs_event (event_articlenumber,event_articletitle,event_content,event_date, hit)";
		sql +=" VALUES(cs_event_SEQ.nextval,?,?,sysdate, 0)"; //<- 마지막 ?를 0으로 수정
		
		

		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
		
			ps.setString(1, param.getEventArticletitle());
			ps.setString(2, param.getEventContent());
		 result = ps.executeUpdate();
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("eventinsert_end");
		return result;
	}


	@Override
	public EventBoard selectcontent(Connection conn, EventBoard eventNo) {
		System.out.println("selectcontent -start");
		System.out.println("eventNo : " + eventNo.getEventArticlenumber());
		String sql ="";
		sql +="SELECT * FROM cs_event";
		sql +=" WHERE event_articlenumber =?";
		
		EventBoard updateContent = null;
		try {
			ps =conn.prepareStatement(sql);
			
			
			ps.setInt(1, eventNo.getEventArticlenumber());
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				
				updateContent = new EventBoard();
				updateContent.setEventArticlenumber(rs.getInt("event_articlenumber"));
				updateContent.setEventArticletitle(rs.getString("event_articletitle"));
				updateContent.setUserNo(rs.getInt("user_no"));
				updateContent.setEventContent(rs.getString("event_content"));
				updateContent.setEventDate(rs.getDate("event_date"));;
				
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
	public int updateDo(Connection conn, EventBoard eventNum) {
		System.out.println("updateDo 시작");
		
		String sql ="";
		sql +="UPDATE cs_event";
		sql +=" SET event_articletitle =?,event_content=?";
		sql +=" WHERE event_articlenumber =?";
		
		System.out.println(eventNum);
		
		int result =0;
		try {
			ps =conn.prepareStatement(sql);
			
			ps.setString(1, eventNum.getEventArticletitle());
			ps.setString(2, eventNum.getEventContent());
			ps.setInt(3, eventNum.getEventArticlenumber());
			
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
	public int deleteDo(Connection conn, EventBoard eventNo) {
	System.out.println("deleteDo 시작");
		
		String sql ="";
		sql +="DELETE cs_event";
		sql +=" WHERE event_articlenumber = ? ";
		
		int deleteevent  =0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eventNo.getEventArticlenumber());
			
			deleteevent = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(ps);
		}
		
		
		System.out.println("deleteDo 끝");
		return deleteevent;
	}

	
	@Override
	public List<EventBoard> selectSearchList(Connection conn, Paging paging, String searchType, String keyword) {
		System.out.println("selectSearchList searchpaging 시작" + paging);
		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += "		SELECT * FROM cs_event";
//		sql += " 		SELECT RR.*,m.user_nick,m.user_name";
//		sql += " 		FROM cs_event RR";
//		sql += "		INNER JOIN member m";
//		sql += "		ON m.user_no = RR.user_no";
		sql += "		WHERE " + searchType + " LIKE ?";
		sql += " 		ORDER BY Event_ARTICLENUMBER DESC";
		sql += " 		) R";
		sql += " 	) EVENT";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<EventBoard> eventBoardList = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				EventBoard r = new EventBoard();
				
				r.setEventArticlenumber(rs.getInt("event_articlenumber"));
//				r.setAdminNo(rs.getInt("admin_no"));
//				r.setBoardCode(rs.getInt("board_code"));
				r.setEventArticletitle(rs.getString("event_articletitle"));
				r.setEventContent(rs.getString("event_content"));
//				r.setEventWriter(rs.getString("user_nick"));
				r.setEventDate(rs.getDate("event_date"));
				r.setHit(rs.getInt("hit"));
//				r.setUserName(rs.getString("user_name"));
//				r.setUserNo(rs.getInt("user_no"));
				
				eventBoardList.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectSearchList searchpaging 끝" + paging);
		System.out.println("selectSearchList()" + eventBoardList);
		return eventBoardList;
	}
	
	@Override
	public int selectSearchCntAll(Connection conn, String searchType, String keyword) {
		System.out.println("selectSearchCntAll 시작" + searchType + keyword);
		keyword = '%' + keyword + '%';
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += "		SELECT * FROM cs_event";
//		sql += " 		SELECT RR.*,m.user_nick,m.user_name";
//		sql += " 		FROM cs_event RR";
//		sql += "		INNER JOIN member m";
//		sql += "		ON m.user_no = RR.user_no";
		sql += "		WHERE " + searchType + " LIKE ?";
		sql += "		) R";
		sql += "	) Event";
		
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


	@Override
	public int insertevent(Connection conn, EventBoard param) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
}
















