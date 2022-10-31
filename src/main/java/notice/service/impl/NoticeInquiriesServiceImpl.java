package notice.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import notice.dao.face.NoticeInquiriesDao;
import notice.dao.impl.NoticeInquiriesDaoImpl;
import notice.dto.NoticeBoard;
import notice.service.face.NoticeInquiriesService;
import util.Paging;

public class NoticeInquiriesServiceImpl implements  NoticeInquiriesService {
	
	
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
		System.out.println("파람 테스트 : " + param);
		
		
		if(null != param && !"".equals(param)) {//전달 파리미터가 null또는 ""빈문자열이 아닐 때 처리
			noticeboard.setNoticeArticlenumber(Integer.parseInt(param));
		}
		
		
		return noticeboard;
	}

	
	@Override
	public Paging getSearchPaging(HttpServletRequest req, String searchType, String keyword) {
		int totalCount = boardDao.selectSearchCntAll(JDBCTemplate.getConnection() ,searchType ,keyword);
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		Paging searchpaging = new Paging(totalCount, curPage);
		return searchpaging;
	}
	
	@Override
	public List<NoticeBoard> getSearchList(Paging paging, String searchType, String keyword) {
		return boardDao.selectSearchList(JDBCTemplate.getConnection(), paging, searchType, keyword);
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
		
		System.out.println("board Test" + board);
		
		return board;
	}



	@Override
	public NoticeBoard getparam(HttpServletRequest req) {
		System.out.println("getparam 시작");

		NoticeBoard noticeBoard = new NoticeBoard();
		noticeBoard.setNoticeArticletitle(req.getParameter("noticeTitle")); //글제목
		
		noticeBoard.setNoticeContent(req.getParameter("content"));// 글 본문 
		
		System.out.println("getparam 끝");
		return noticeBoard; 
	}

	@Override
	public NoticeBoard setNotice(NoticeBoard param,int userNo) {
		System.out.println("setNotice start");
		
		
		
		Connection conn = JDBCTemplate.getConnection();
		
		//DTO 정보를 DB에 저장
		int Noticeinsert = boardDao.insertnotice(conn,param,userNo);
		
		if(Noticeinsert>0) {
			 
			System.out.println("Notice insert 성공");
			JDBCTemplate.commit(conn);
			return param;
		} else {//DB 삽입 실패
			System.out.println("Notice insert 실패");
			JDBCTemplate.rollback(conn);
			
			System.out.println("setNotice end");
			return null;
		}
		
	}

	

	@Override
	public NoticeBoard getdataforselect(HttpServletRequest req) {
	
		System.out.println("수정하기 파라미터");
		NoticeBoard noticeforselect = new NoticeBoard();
		
		
		int param = Integer.parseInt(String.valueOf(req.getParameter("noticeNo")));
		System.out.println("param : " + param);
		noticeforselect.setNoticeArticlenumber(param);
		
		return noticeforselect ;
	}

	@Override
	public NoticeBoard getdata(HttpServletRequest req) {
		System.out.println("수정완료를 위한 파라미터 ");
		NoticeBoard noticeUpdate = new NoticeBoard();
		
	
		
		noticeUpdate.setNoticeArticlenumber(Integer.parseInt(String.valueOf(req.getParameter("noticeNo"))));//<----임시
		noticeUpdate.setNoticeArticletitle(req.getParameter("noticeTitle"));	//<----임시
		noticeUpdate.setNoticeContent(req.getParameter("content"));
			
		return noticeUpdate;
		
	}
	

	@Override
	public NoticeBoard getUpdate(NoticeBoard noticeNo) {
		
		return boardDao.selectcontent(JDBCTemplate.getConnection(),noticeNo);
	}
	
	@Override
	public NoticeBoard setUpdate(NoticeBoard noticeNum) {

		Connection conn = JDBCTemplate.getConnection();
		
		int resultUpdate = boardDao.updateDo(conn,noticeNum);
		
		if(resultUpdate>0) {
			
			System.out.println("update 성공");
			JDBCTemplate.commit(conn);
			
			return noticeNum;
			
		}else {
			System.out.println("update 실패");
			JDBCTemplate.rollback(conn);
			return null;
		}
	}
		
		@Override
		public Void deleteNotice(NoticeBoard noticeNum) {

			Connection conn  =JDBCTemplate.getConnection();
		
			
			if( boardDao.deleteDo(conn,noticeNum) >0) {
				
				System.out.println("delete 성공");
				JDBCTemplate.commit(conn);
			}else {
				
				System.out.println("delete 실패");
				
			}
			return null;
			
		
	
	}
		

	
}


	


	
	



