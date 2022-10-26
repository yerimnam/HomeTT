package faq.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import event.common.JDBCTemplate;
import faq.dao.face.FaqInquiriesDao;
import faq.dao.impl.FaqInquiriesDaoImpl;
import faq.dto.FaqBoard;
import faq.service.face.FaqInquiriesService;
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
	public FaqBoard getfaqArticlenumber(HttpServletRequest req) {

		FaqBoard faqboard = new FaqBoard(); 
		
		//전달파라미터 faqArticlenumber 추출(파싱)
		String param = req.getParameter("faqArticlenumber");
		
		if(null != param && !"".equals(param)) {//전달 파리미터가 null또는 ""빈문자열이 아닐 때 처리
			faqboard.setFaqArticlenumber(Integer.parseInt(param));
		}
		
		
		return faqboard;
	}


	@Override
	public FaqBoard view(FaqBoard faqArticlenumber) {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//조회수 증가
		
		if(boardDao.updateHit(conn,faqArticlenumber)>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		//게시글 조회
		FaqBoard board = boardDao.selectBoardByfaqArticlenumber(conn, faqArticlenumber);
		
		
		return board;
	}


	
	
	





}
