package partyCheck.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import partyCheck.dto.PartyCheck;
import util.Paging;

public interface PartyCheckService {

	/**
	 * 파티 목록 전체 조회
	 * 
	 * @return - 파티 전제 조회 목록
	 */
	public List<PartyCheck> getList();
	
	/**
	 * 파티 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return - 파티 전제 조회 목록
	 */
	public List<PartyCheck> getList(Paging paging);
	
	
	/**
	 * 파티 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<PartyCheck> - 파티 전체 조회 목록
	 */
	public Paging getPaging(HttpServletRequest req);

}
