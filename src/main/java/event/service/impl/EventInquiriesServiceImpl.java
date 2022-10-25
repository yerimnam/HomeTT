package event.service.impl;

import java.util.List;

import event.common.JDBCTemplate;
import event.dao.face.EventInquiriesDao;
import event.dao.impl.EventInquiriesDaoImpl;
import event.dto.EventBoard;
import event.service.face.EventInquiriesService;

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
