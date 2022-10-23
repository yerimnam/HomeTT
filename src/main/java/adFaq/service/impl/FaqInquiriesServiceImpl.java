package adFaq.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import adEvent.common.JDBCTemplate;
import adFaq.dao.face.FaqInquiriesDao;
import adFaq.dao.impl.FaqInquiriesDaoImpl;
import adFaq.dto.FaqBoard;
import adFaq.service.face.FaqInquiriesService;
import util.Paging;

public class FaqInquiriesServiceImpl implements FaqInquiriesService {

	
	//DAO객체
	private FaqInquiriesDao boardDao = new FaqInquiriesDaoImpl();
	@Override
	public List<FaqBoard> getList() {
		
		
		System.out.println("EventBoardService getList() - 시작");
		
		
		
		System.out.println("EventBoardService getList() - 끝");
//		DB조회결과 반환
		return boardDao.selectAll(JDBCTemplate.getConnection());
	}
	
	
	@Override
	public List<FaqBoard> getList(Paging paging) {
		
		
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
	public FaqBoard getBoardcode(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	





}
