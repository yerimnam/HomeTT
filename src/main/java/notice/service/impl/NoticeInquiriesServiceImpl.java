package notice.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import event.common.JDBCTemplate;
import notice.dao.face.NoticeInquiriesDao;
import notice.dao.impl.NoticeInquiriesDaoImpl;
import notice.dto.NoticeBoard;
import notice.service.face.NoticeInquiriesService;
import util.Paging;

public class NoticeInquiriesServiceImpl implements NoticeInquiriesService {

	
	//DAO객체
	private NoticeInquiriesDao boardDao = new NoticeInquiriesDaoImpl();
	@Override
	public List<NoticeBoard> getList() {
		
		
		System.out.println("NoticeBoardService getList() - 시작");
		
		
		
		System.out.println("NoticeBoardService getList() - 끝");
//		DB조회결과 반환
		return boardDao.selectAll(JDBCTemplate.getConnection());
	}
	
	
	@Override
	public List<NoticeBoard> getList(Paging paging) {
		
		
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
	public NoticeBoard getnoticeArticlenumber(HttpServletRequest req) {

		NoticeBoard noticeboard = new NoticeBoard(); 
		
		//전달파라미터 noticeArticlenumber 추출(파싱)
		String param = req.getParameter("noticeArticlenumber");
		
		if(null != param && !"".equals(param)) {//전달 파리미터가 null또는 ""빈문자열이 아닐 때 처리
			noticeboard.setNoticeArticlenumber(Integer.parseInt(param));
		}
		
		
		return noticeboard;
	}


	@Override
	public NoticeBoard view(NoticeBoard noticeArticlenumber) {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//조회수 증가
		
		if(boardDao.updateHit(conn,noticeArticlenumber)>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		//게시글 조회
		NoticeBoard board = boardDao.selectBoardBynoticeArticlenumber(conn, noticeArticlenumber);
		
		
		return board;
	}


	
	
	





}
