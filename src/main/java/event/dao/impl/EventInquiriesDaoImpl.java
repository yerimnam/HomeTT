package event.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import event.common.JDBCTemplate;
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
		sql += "SELECT";
		sql += "	event_articlenumber, admin_no, board_code, event_articletitle ";
		sql += " ,event_content,event_date,user_no,hit";
		sql += " FROM cs_event"; 
		sql += " ORDER BY event_Articlenumber DESC";
		
		//결과 저장할 List
		List<EventBoard> eventboardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				EventBoard e = new EventBoard();//조회결과 행 저장 DTO 객체

				e.setEventArticlenumber(rs.getInt("event_articlenumber"));
				e.setAdminNo(rs.getInt("admin_no"));
				e.setBoardCode(rs.getInt("board_code"));
				e.setEventArticletitle(rs.getString("event_articletitle"));
				e.setEventContent(rs.getString("event_content"));
				e.setEventDate(rs.getDate("event_date"));
				e.setUserNo(rs.getInt("user_no"));
				e.setHit(rs.getInt("hit"));
				
				//리스트에 결과값 저장하기
				eventboardList.add(e);
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
		sql += " 	SELECT rownum rnum, E.*FROM (";
		sql += " 	SELECT";
		sql += "		event_articlenumber,admin_no,board_code,event_articletitle ";
		sql += " 		,event_content,event_date,user_no,hit";
		sql += " 	FROM cs_event"; 
		sql += " 	ORDER BY event_articlenumber DESC";
		sql += " 	) B";
		sql += " ) eventBaord";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<EventBoard> eventboardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				EventBoard e = new EventBoard();//조회결과 행 저장 DTO 객체

				e.setEventArticlenumber(rs.getInt("event_articlenumber"));
				e.setAdminNo(rs.getInt("admin_no"));
				e.setBoardCode(rs.getInt("board_code"));
				e.setEventArticletitle(rs.getString("event_articletitle"));
				e.setEventContent(rs.getString("event_content")); 
				e.setEventDate(rs.getDate("event_date"));				
				e.setHit(rs.getInt("hit"));
				e.setUserNo(rs.getInt("user_no"));
				//리스트에 결과값 저장하기
				eventboardList.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		System.out.println("FaqBoard selectAll - 끝");
		return eventboardList; //최종 결과 반환
	}
	
	
//  
	@Override
	public int selectCntAll(Connection conn) {
		System.out.println("selectCntAll - 시작");	
		String sql = "";
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
	public int updateHit(Connection conn, EventBoard eventArticlenumber) {
		
		System.out.println("updateHit - 시작");	
		String sql = "";
		sql += "UPDATE cs_event"; 
		sql += "	SET hit = hit +1";
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
		
		System.out.println("updateHit - 끝");	
		
		return res;
	}

	@Override
	public EventBoard selectBoardByeventArticlenumber(Connection conn, EventBoard eventArticlenumber) {
		System.out.println("selectBoardByfaqArticlenumber - 시작");	
		
		String sql = "";
		sql += "SELECT";
		sql +=" 	event_articlenumber,admin_no,board_code,event_articletitle,";
		sql +="		 event_content,event_date,user_no,hit ";
		sql +=" FROM cs_event";
		sql +=" WHERE event_articlenumber = ?";
		
		EventBoard board= null;
		
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1 , eventArticlenumber.getEventArticlenumber());
				
				rs = ps.executeQuery();
				
				while(rs.next() ) {
					board = new EventBoard();
					

					

					board.setEventArticlenumber(rs.getInt("event_articlenumber"));
					board.setAdminNo(rs.getInt("admin_no"));
					board.setBoardCode(rs.getInt("board_code"));
					board.setEventArticletitle(rs.getString("event_articletitle"));
					board.setEventContent(rs.getString("event_content")); 
					board.setEventDate(rs.getDate("event_date"));				
					board.setHit(rs.getInt("hit"));
					board.setUserNo(rs.getInt("user_no"));
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




	@Override
	public int insertevent(Connection conn, EventBoard param,int userNo) {
		System.out.println("insertevent시작");
		
		String sql ="";								
		sql +="INSERT INTO cs_event (event_articlenumber,user_no,event_articletitle,event_content,event_date)";
		sql +=" VALUES(event_seq.nextval,?,?,?,sysdate)";
		
		

		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
		
			ps.setInt(1, userNo);
			ps.setString(2, param.getEventArticletitle());
			ps.setString(3, param.getEventContent());
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
		sql +=" WHERE event_articlenumber =? ";
		
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
	
}
















