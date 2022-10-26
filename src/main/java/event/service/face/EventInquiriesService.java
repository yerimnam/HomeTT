package event.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import event.dto.EventBoard;
import util.Paging;

public interface EventInquiriesService {
	
	/**
	 * 게시글 전체 조회
	 * @return List<board> - 게시글 전체 조회 목록
	 */
	public List<EventBoard> getList();
	
	
	/**
	 * 게시글 페이징 목록 조회
	 * @return List<EventBoard> - 게시글 전체 조회
	 */
	public List<EventBoard> getList(Paging paging);
	
	/**
	 * 게시글 페이징 객체 생성
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
	
	
	/**
	 *  전달 파라미터 eventArticlenumber를 EventBoard DTO로 저장하여 반환한다
	 *  
	 * @param req - 요청 정보 객체
	 * @return Board - 전달 파라미터 eventArticlenumber를 저장한 DTO객체
	 */
	public EventBoard geteventArticlenumber(HttpServletRequest req);

	/**
	 * 전달된 faqArticlenumber를 이용하여 게시글을 조회한다
	 * 조회된 게시글의 조회수를 1증가 시킨다
	 * @param eventArticlenumber  조회할 eventArticlenumber를 가진 DTO객체
	 * @return EventBoard - 조회된 게시글 정보
	 */
	public EventBoard view(EventBoard eventArticlenumber);


	

}
