package invitation.service.face;

import javax.servlet.http.HttpServletRequest;

import invitation.dto.Invitation;

public interface InvitationService {
	
	/**
	 * 전달된 partyNo를 이용하여 파티방을 조회
	 * 
	 * @param partyno - 조회할 partyno를 가진 DTO 객체
	 * @return Invitation - 조회된 파티방 번호
	 */
	public Invitation view(Invitation partyNo);

	/**
	 * 전달파라미터 partyNo를 Invitation DTO로 저장하여 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return Invitation - 전달파라미터 partyNo를 저장한 DTO객체
	 */
	public Invitation getPartyNo(HttpServletRequest req);

}
