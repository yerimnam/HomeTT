package event.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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



	@Override
	public EventBoard getparam(HttpServletRequest req) {
		System.out.println("getparam 시작");

		EventBoard eventBoard = new EventBoard();
		eventBoard.setEventArticletitle(req.getParameter("title")); //글제목
		
		
		
		eventBoard.setEventContent(req.getParameter("content"));// 글 본문 
		
		System.out.println("getparam 끝");
		return eventBoard; 
	}

	@Override
	public EventBoard setEvent(EventBoard param,int userNo) {
		System.out.println("setEvent start");
		
		
		
		Connection conn = JDBCTemplate.getConnection();
		
		//DTO 정보를 DB에 저장
		int Eventinsert = boardDao.insertevent(conn,param,userNo);
		
		if(Eventinsert>0) {
			 
			System.out.println("event insert 성공");
			JDBCTemplate.commit(conn);
			return param;
		} else {//DB 삽입 실패
			System.out.println("event insert 실패");
			JDBCTemplate.rollback(conn);
			
			System.out.println("setevent end");
			return null;
		}
		
	}

	

	@Override
	public EventBoard getdataforselect(HttpServletRequest req) {
	
		System.out.println("수정하기 파라미터");
		EventBoard eventforselect = new EventBoard();
		
		
		int param = Integer.parseInt(req.getParameter("eventNo"));
		eventforselect.setEventArticlenumber(param);
		
		return eventforselect ;
	}

	@Override
	public EventBoard getdata(HttpServletRequest req) {
		System.out.println("수정완료를 위한 파라미터 ");
		EventBoard eventUpdate = new EventBoard();
		
	
		
		eventUpdate.setEventArticlenumber(Integer.parseInt( req.getParameter("eventNo")));//<----임시
		eventUpdate.setEventArticletitle(req.getParameter("eventTitle"));	//<----임시
		eventUpdate.setEventContent(req.getParameter("content"));
			
		return eventUpdate;
		
	}
	

	@Override
	public EventBoard getUpdate(EventBoard eventNo) {
		
		return boardDao.selectcontent(JDBCTemplate.getConnection(),eventNo);
	}
	
	@Override
	public EventBoard setUpdate(EventBoard eventNum) {

		Connection conn = JDBCTemplate.getConnection();
		
		int resultUpdate = boardDao.updateDo(conn,eventNum);
		
		if(resultUpdate>0) {
			
			System.out.println("update 성공");
			JDBCTemplate.commit(conn);
			
			return eventNum;
			
		}else {
			System.out.println("update 실패");
			JDBCTemplate.rollback(conn);
			return null;
		}
	}
		
		@Override
		public Void deleteEvent(EventBoard eventNum) {

			Connection conn  =JDBCTemplate.getConnection();
		
			
			if( boardDao.deleteDo(conn,eventNum) >0) {
				
				System.out.println("delete 성공");
				JDBCTemplate.commit(conn);
			}else {
				
				System.out.println("delete 실패");
				
			}
			return null;
			
		
	
	}


	
}


	


	
	



