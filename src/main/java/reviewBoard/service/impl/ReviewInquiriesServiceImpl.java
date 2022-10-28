package reviewBoard.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import reviewBoard.dao.face.ReviewInquiriesDao;
import reviewBoard.dao.impl.ReviewInquiriesDaoImpl;
import reviewBoard.dto.ReviewBoard;
import reviewBoard.service.face.ReviewInquiriesService;
import util.Paging;

public class ReviewInquiriesServiceImpl implements ReviewInquiriesService {
	
	
	//DAO객체
	private ReviewInquiriesDao boardDao = new ReviewInquiriesDaoImpl();
	@Override
	public List<ReviewBoard> getList() {
		
		System.out.println("ReviewBoardService getList() - 시작");
		
		
		
		System.out.println("ReviewBoardService getList() - 끝");
//		DB조회결과 반환
		return boardDao.selectAll(JDBCTemplate.getConnection());
	}

	@Override
	public List<ReviewBoard> getList(Paging paging) {
		
		
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
	public ReviewBoard getreviewArticlenumber(HttpServletRequest req) {

		ReviewBoard reviewboard = new ReviewBoard(); 
		
		//전달파라미터 reviewArticlenumber 추출(파싱)
		String param = req.getParameter("reviewArticlenumber");
		
		System.out.println( "창민 : " + param);		//----------------------------------
		
		if(null != param && !"".equals(param)) {//전달 파리미터가 null또는 ""빈문자열이 아닐 때 처리
			reviewboard.setReviewArticlenumber(Integer.parseInt(param));
		}
		
		
		return reviewboard;
	}

	

	@Override
	public ReviewBoard view(ReviewBoard reviewArticlenumber) {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//조회수 증가
		
		if(boardDao.updateHit(conn,reviewArticlenumber)>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		//게시글 조회
		ReviewBoard board = boardDao.selectBoardByreviewArticlenumber(conn, reviewArticlenumber);
		
		
		return board;
	}



	@Override
	public ReviewBoard getparam(HttpServletRequest req) {
		System.out.println("getparam 시작");

		ReviewBoard reviewBoard = new ReviewBoard();
		reviewBoard.setReviewArticletitle(req.getParameter("title")); //글제목
		
		
		
		reviewBoard.setReviewContent(req.getParameter("content"));// 글 본문 
		
		System.out.println("getparam 끝");
		return reviewBoard; 
	}

	@Override
	public ReviewBoard setReview(ReviewBoard param,int userNo) {
		System.out.println("setReview start");
		
		
		
		Connection conn = JDBCTemplate.getConnection();
		
		//DTO 정보를 DB에 저장
		int Reviewinsert = boardDao.insertreview(conn,param,userNo);
		
		if(Reviewinsert>0) {
			 
			System.out.println("review insert 성공");
			JDBCTemplate.commit(conn);
			return param;
		} else {//DB 삽입 실패
			System.out.println("review insert 실패");
			JDBCTemplate.rollback(conn);
			
			System.out.println("setreview end");
			return null;
		}
		
	}

	

	@Override
	public ReviewBoard getdataforselect(HttpServletRequest req) {
	
		System.out.println("수정하기 파라미터");
		ReviewBoard reviewforselect = new ReviewBoard();
		
		
		int param = Integer.parseInt(req.getParameter("reviewNo"));
		reviewforselect.setReviewArticlenumber(param);
		
		return reviewforselect ;
	}

	@Override
	public ReviewBoard getdata(HttpServletRequest req) {
		System.out.println("수정완료를 위한 파라미터 ");
		ReviewBoard reviewUpdate = new ReviewBoard();
		
	
		
		reviewUpdate.setReviewArticlenumber(Integer.parseInt( req.getParameter("reviewNo")));//<----임시
		reviewUpdate.setReviewArticletitle(req.getParameter("reviewTitle"));	//<----임시
		reviewUpdate.setReviewContent(req.getParameter("content"));
			
		return reviewUpdate;
		
	}
	

	@Override
	public ReviewBoard getUpdate(ReviewBoard reviewNo) {
		
		return boardDao.selectcontent(JDBCTemplate.getConnection(),reviewNo);
	}
	
	@Override
	public ReviewBoard setUpdate(ReviewBoard reviewNum) {

		Connection conn = JDBCTemplate.getConnection();
		
		int resultUpdate = boardDao.updateDo(conn,reviewNum);
		
		if(resultUpdate>0) {
			
			System.out.println("update 성공");
			JDBCTemplate.commit(conn);
			
			return reviewNum;
			
		}else {
			System.out.println("update 실패");
			JDBCTemplate.rollback(conn);
			return null;
		}
	}
		
		@Override
		public Void deleteReview(ReviewBoard reviewNum) {

			Connection conn  =JDBCTemplate.getConnection();
		
			
			if( boardDao.deleteDo(conn,reviewNum) >0) {
				
				System.out.println("delete 성공");
				JDBCTemplate.commit(conn);
			}else {
				
				System.out.println("delete 실패");
				
			}
			return null;
			
		
	
	}


	
}


	


	
	



