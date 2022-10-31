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
	 * 검색 게시글 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 검색 게시글 페이징 계산이 완료된 객체
	 */
	public Paging getSearchPaging(HttpServletRequest req, String searchType, String keyword);
	
	/**
	 * 검색한 게시글 목록 조회
	 * 
	 * @param paging - 페이징 계산이 완료된 객체
	 * @param searchType - 검색 카테고리
	 * @param keyword - 검색어 내용
	 * @return 검색한 게시글 목록 전달
	 */
	public List<EventBoard> getSearchList(Paging paging, String searchType, String keyword);
	 
	
	/**
	 *  전달 파라미터 eventArticlenumber를 EventBoard DTO로 저장하여 반환한다
	 *  
	 * @param req - 요청 정보 객체
	 * @return Board - 전달 파라미터 eventArticlenumber를 저장한 DTO객체
	 */
	public EventBoard geteventArticlenumber(HttpServletRequest req);

	/**
	 * 전달된 eventArticlenumber를 이용하여 게시글을 조회한다
	 * 조회된 게시글의 조회수를 1증가 시킨다
	 * @param eventArticlenumber  조회할 eventArticlenumber를 가진 DTO객체
	 * @return EventBoard - 조회된 게시글 정보
	 */
	public EventBoard view(EventBoard eventArticlenumber);


	public EventBoard getparam(HttpServletRequest req);


	/**
	 * 이벤트 insrty
	 * @param param - 파라미터(글제목,글본문)
	 * @param userNo 
	 * @return - 이벤트글 저장
	 */
	public EventBoard setEvent(EventBoard param, int userNo);

	/**
	 * 수정하기 파라미터 
	 * @param req- 요청 파라미터
	 * @return
	 */
	public EventBoard getdata(HttpServletRequest req);

	public EventBoard getdataforselect(HttpServletRequest req);


	/**
	 * 수정해야하는 글 가져와서 보여주기
	 * @param eventNo -글 번호
	 * @return 글번호로 조회안 상세 내용
	 */
	public EventBoard getUpdate(EventBoard eventNo);


	public EventBoard setUpdate(EventBoard eventNum);

	/**
	 * 삭제하기
	 * @param eventNo -글 번호
	 * @return
	 */
	public Void deleteEvent(EventBoard eventNo);


		
	
	
	


	
	


}
