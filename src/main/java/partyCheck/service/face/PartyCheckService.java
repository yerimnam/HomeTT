package partyCheck.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import partyCheck.dto.PartyCheck;
import util.Paging5;

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
	public List<PartyCheck> getList(Paging5 paging);
	
	
	/**
	 * 파티 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<PartyCheck> - 파티 전체 조회 목록
	 */
	public Paging5 getPaging(HttpServletRequest req);

	
	/**
	 * 전달파라미터 partyNo를 partyCheck DTO로 저장하여 반환
	 * 
	 * @param req - 요청 정보 객체
	 * @return PartyExit - 전달파라미터 partyNo를 저장한 DTO객체
	 */
	public PartyCheck getPartyNo(HttpServletRequest req);
	
	/**
	 * 파티방 나가기(DB삭제)
	 * 
	 * @param partyCheck - 나갈 파티방 번호 객체
	 */
	public void delete(PartyCheck partyCheck);

}
