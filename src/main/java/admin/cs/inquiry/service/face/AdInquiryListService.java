package admin.cs.inquiry.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.cs.inquiry.dto.Inquiry;
import util.Paging;

public interface AdInquiryListService {
	
	/**
	 * 게시글 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Inquiry> - 게시글 전체 조회 목록
	 */
	public List<Inquiry> getList(Paging paging);
	
	/**
	 * 게시글 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
	/**
	 * 전달파라미터 inquiryno를 inquiry DTO로 저장하여 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return inquiryno - 전달파라미터 inquiryno를 저장한 DTO객체
	 */
	public Inquiry getInquiryno(HttpServletRequest req);
	
	/**
	 * 전달된 inquiryno를 이용하여 게시글을 조회한다
	 * 
	 * @param inquiryno - 조회할 inquiryno를 가진 DTO객체
	 * @return inquiryno - 조회된 게시글 정보
	 */
	public Inquiry view(Inquiry inquiryno);

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
	public List<Inquiry> getSearchList(Paging paging, String searchType, String keyword);
	
	/**
	 * 게시글 작성
	 * 입력한 게시글을 DB에 저장한다
	 * 
	 * @param req - 요청 정보 객체
	 * @param inquiryArticleNumber - 1:1 문의 글 번호
	 * @param answerWriter - 답변 작성자
	 * @param answerContent - 답변 내용
	 */
	public void writeAnswer(HttpServletRequest req);

	/**
	 * 게시글 삭제
	 * 
	 * @param inquiryno - 삭제할 게시글 번호 객체
	 */
	public void delete(Inquiry inquiry);
	
}
