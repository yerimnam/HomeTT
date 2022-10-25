package partyExit.service.face;

import javax.servlet.http.HttpServletRequest;

import partyExit.dto.PartyExit;

public interface PartyExitService {

	/**
	 * 전달파라미터 partyNo를 PartyExit DTO로 저장하여 반환
	 * 
	 * @param req - 요청 정보 객체
	 * @return PartyExit - 전달파라미터 partyNo를 저장한 DTO객체
	 */
	public PartyExit getPartyNo(HttpServletRequest req);

	/**
	 * 파티방 정보 삭제
	 * 
	 * @param partyexit - 나가고 싶은 파티방 번호 객체
	 */
	public void delete(PartyExit partyexit);

}
