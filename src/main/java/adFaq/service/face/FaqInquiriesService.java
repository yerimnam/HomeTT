package adFaq.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import adFaq.dto.FaqBoard;
import util.Paging;

public interface FaqInquiriesService {
 
	/**
	 * 게시글 전체 조회
	 * @return List<board> - 게시글 전체 조회 목록
	 */
	public List<FaqBoard> getList();
	/**
	 * 게시글 페이징 목록 조회
	 * @return List<FaqBoard> - 게시글 전체 조회
	 */
	public List<FaqBoard> getList(Paging paging);
	
	/**
	 * 게시글 페이징 객체 생성
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
	
	/**
	 *  전달 파라미터 boardcode를 FaqBoard DTO로 저장하여 반환한다
	 *  
	 * @param req - 요청 정보 객체
	 * @return Board - 전달 파라미터 boardcode를 저장한 DTO객체
	 */
	public FaqBoard getBoardcode(HttpServletRequest req);




}   
