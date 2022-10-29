package reviewBoard.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import reviewBoard.dto.ReviewBoard;
import util.Paging;

public interface ReviewInquiriesService {
	
	/**
	 * 게시글 전체 조회
	 * @return List<board> - 게시글 전체 조회 목록
	 */
	public List<ReviewBoard> getList();
	
	
	/**
	 * 게시글 페이징 목록 조회
	 * @return List<ReviewBoard> - 게시글 전체 조회
	 */
	public List<ReviewBoard> getList(Paging paging);
	
	/**
	 * 게시글 페이징 객체 생성
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
	 
	
	/**
	 *  전달 파라미터 reviewArticlenumber를 ReviewBoard DTO로 저장하여 반환한다
	 *  
	 * @param req - 요청 정보 객체
	 * @return Board - 전달 파라미터 reviewArticlenumber를 저장한 DTO객체
	 */
	public ReviewBoard getreviewArticlenumber(HttpServletRequest req);

	/**
	 * 전달된 reviewArticlenumber를 이용하여 게시글을 조회한다
	 * 조회된 게시글의 조회수를 1증가 시킨다
	 * @param reviewArticlenumber  조회할 reviewArticlenumber를 가진 DTO객체
	 * @return ReviewBoard - 조회된 게시글 정보
	 */
	public ReviewBoard view(ReviewBoard reviewArticlenumber);

	/**
	 * 전달된 Board객체의 id를 이용하여 nick 조회
	 * 
	 * @param viewBoard - 조회할 게시글 정보
	 * @return String - 게시글 작성자의 닉네임
	 */
//	public String getWriteNick(ReviewBoard viewBoard);

	/**
	 * 게시글 작성
	 * 입력한 게시글을 DB에 저장한다
	 * 
	 * @param req - 요청 정보 객체
	 */
//	public void write(HttpServletRequest req);


//	public void delete(ReviewBoard reviewboard);




	/**
	 * 
	 * 회원이 작성한 글의 파라미터 얻어오기
	 * @param req 
	 * @return 작성한 글 파라미터 
	 */
//	public ReviewBoard getparam(HttpServletRequest req);
	public ReviewBoard getparam(HttpServletRequest req);


	/**
	 * 이벤트 insrty
	 * @param param - 파라미터(글제목,글본문)
	 * @param userNo 
	 * @return - 이벤트글 저장
	 */
	public ReviewBoard setReview(ReviewBoard param, int userNo);

	/**
	 * 수정하기 파라미터 
	 * @param req- 요청 파라미터
	 * @return
	 */
	public ReviewBoard getdata(HttpServletRequest req);

	public ReviewBoard getdataforselect(HttpServletRequest req);


	/**
	 * 수정해야하는 글 가져와서 보여주기
	 * @param reviewNo -글 번호
	 * @return 글번호로 조회안 상세 내용
	 */
	public ReviewBoard getUpdate(ReviewBoard reviewNo);


	public ReviewBoard setUpdate(ReviewBoard reviewNum);

	/**
	 * 삭제하기
	 * @param reviewNo -글 번호
	 * @return
	 */
	public Void deleteReview(ReviewBoard reviewNo);


		
	
	
	


	
	


}
