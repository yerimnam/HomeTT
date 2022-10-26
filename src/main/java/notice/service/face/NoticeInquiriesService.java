package notice.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import notice.dto.NoticeBoard;
import util.Paging;

public interface NoticeInquiriesService {
 
	/**
	 * 게시글 전체 조회
	 * @return List<board> - 게시글 전체 조회 목록
	 */
	public List<NoticeBoard> getList();
	/**
	 * 게시글 페이징 목록 조회
	 * @return List<NoticeBoard> - 게시글 전체 조회
	 */
	public List<NoticeBoard> getList(Paging paging);
	
	/**
	 * 게시글 페이징 객체 생성
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
	
	
	/**
	 *  전달 파라미터 noticeArticlenumber를 NoticeBoard DTO로 저장하여 반환한다
	 *  
	 * @param req - 요청 정보 객체
	 * @return Board - 전달 파라미터 noticeArticlenumber를 저장한 DTO객체
	 */
	public NoticeBoard getnoticeArticlenumber(HttpServletRequest req);

	/**
	 * 전달된 noticeArticlenumber를 이용하여 게시글을 조회한다
	 * 조회된 게시글의 조회수를 1증가 시킨다
	 * @param noticeArticlenumber  조회할 noticeArticlenumber를 가진 DTO객체
	 * @return NoticeBoard - 조회된 게시글 정보
	 */
	public NoticeBoard view(NoticeBoard noticeArticlenumber);
	

}   
