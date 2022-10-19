package adEvent.service.impl;

import java.util.List;

import adEvent.common.JDBCTemplate;
import adEvent.dao.face.EventInquiriesDao;
import adEvent.dao.impl.EventInquiriesDaoImpl;
import adEvent.dto.EventBoard;
import adEvent.service.face.EventInquiriesService;

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

}
