package adEvent.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import adEvent.common.JDBCTemplate;
import adEvent.dao.face.EventInquiriesDao;
import adEvent.dto.EventBoard;

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
		sql += " ,event_content,event_writer,event_date";
		sql += " FROM cs_event"; 
		sql += " ORDER BY board_code DESC";
		
		//결과 저장할 List
		List<EventBoard> eventboardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				EventBoard b = new EventBoard();//조회결과 행 저장 DTO 객체

				b.setEventArticlenumber(rs.getInt("event_articlenumber"));
				b.setAdminNo(rs.getInt("admin_no"));
				b.setBoardCode(rs.getInt("board_code"));
				b.setEventArticletitle(rs.getString("event_articletitle"));
				b.setEventContent(rs.getString("event_content"));
				b.setEventWriter(rs.getString("event_writer"));
				b.setEventDate(rs.getDate("event_date"));
				
				
				//리스트에 결과값 저장하기
				eventboardList.add(b);
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

}




