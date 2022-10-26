package event.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import event.common.JDBCTemplate;
import event.dao.face.EventInquiriesDao;
import event.dao.impl.EventInquiriesDaoImpl;
import event.dto.EventBoard;
import event.service.face.EventInquiriesService;
import util.Paging;

public class EventInquiriesServiceImpl implements EventInquiriesService {
	
	
	//DAO객체
	private EventInquiriesDao boardDao = new EventInquiriesDaoImpl();
	@Override
	public List<EventBoard> getList() {
		
		System.out.println("EventBoardService getList() - 시작");
		
		
		
		System.out.println("EventBoardService getList() - 끝");
//		DB조회결과 반환
		return boardDao.selectAll(JDBCTemplate.getConnection());
	}

	@Override
	public List<EventBoard> getList(Paging paging) {
		
		
		return boardDao.selectAll(JDBCTemplate.getConnection(),paging);
	}

	
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		//총게시글 수 조회하기
		int totalCount = boardDao.selectCntAll(JDBCTemplate.getConnection());
		
		//전달파라미터 curPage추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param); 
		}
		//Paging 객체 생성
		Paging paging = new Paging(totalCount,curPage);
		return paging;
	}

	@Override
	public EventBoard geteventArticlenumber(HttpServletRequest req) {

		EventBoard eventboard = new EventBoard(); 
		
		//전달파라미터 faqArticlenumber 추출(파싱)
		String param = req.getParameter("eventArticlenumber");
		
		if(null != param && !"".equals(param)) {//전달 파리미터가 null또는 ""빈문자열이 아닐 때 처리
			eventboard.setEventArticlenumber(Integer.parseInt(param));
		}
		
		
		return eventboard;
	}

	

	@Override
	public EventBoard view(EventBoard eventArticlenumber) {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//조회수 증가
		
		if(boardDao.updateHit(conn,eventArticlenumber)>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		//게시글 조회
		EventBoard board = boardDao.selectBoardByeventArticlenumber(conn, eventArticlenumber);
		
		
		return board;
	}



	
	
	


}
