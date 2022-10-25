package invitation.dao.face;

import java.sql.Connection;

import invitation.dto.Invitation;

public interface InvitationDao {

	/**
	 * 지정된 partyNo의 파티방 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param partyNo - 조회할 파티방의 partyNo를 가진 DTO 객체
	 * @return Invitation - 조회된 파티방의 상세 정보 DTO 객체
	 */
	public Invitation selectInvitationByPartyno(Connection conn, Invitation partyNo);

}
