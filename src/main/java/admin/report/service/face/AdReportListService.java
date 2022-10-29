package admin.report.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.report.dto.Report;
import util.Paging;

public interface AdReportListService {
	
	/**
	 * 게시글 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 게시글 전체 조회 목록
	 */
	public List<Report> getList(Paging paging);
	
	/**
	 * 게시글 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
	/**
	 * 전달파라미터 reportno를 Report DTO로 저장하여 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return Report - 전달파라미터 reportno를 저장한 DTO객체
	 */
	public Report getReportno(HttpServletRequest req);
	
	/**
	 * 전달된 reportno를 이용하여 게시글을 조회한다
	 * 
	 * @param reportno - 조회할 reportno를 가진 DTO객체
	 * @return Board - 조회된 게시글 정보
	 */
	public Report view(Report reportno);

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
	public List<Report> getSearchList(Paging paging, String searchType, String keyword);

}
