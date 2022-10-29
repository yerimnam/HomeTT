package admin.party.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.party.dto.Party;
import util.Paging;

public interface AdPartyListService {
	
	/**
	 * 파티 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Party> - 파티 전체 조회 목록
	 */
	public List<Party> getList(Paging paging);
	
	/**
	 * 파티 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
	/**
	 * 전달파라미터 partyno를 Party DTO로 저장하여 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return Party - 전달파라미터 partyno를 저장한 DTO객체
	 */
	public Party getPartyno(HttpServletRequest req);
	
	/**
	 * 전달된 partyno를 이용하여 파티를 조회한다
	 * 
	 * @param Partyno - 조회할 partyno를 가진 DTO객체
	 * @return Party - 조회된 파티 정보
	 */
	public Party view(Party partyno);

	/**
	 * 검색 게시글 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 검색 게시글 페이징 계산이 완료된 객체
	 */
	public Paging getSearchPaging(HttpServletRequest req, String searchType, String keyword);
	
	/**
	 * 검색한 파티 목록 조회
	 * 
	 * @param paging - 페이징 계산이 완료된 객체
	 * @param searchType - 검색 카테고리
	 * @param keyword - 검색어 내용
	 * @return 검색한 파티 목록 전달
	 */
	public List<Party> getSearchList(Paging paging, String searchType, String keyword);
	
}
