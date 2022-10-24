package party.service.face;

import javax.servlet.http.HttpServletRequest;

import party.dto.Party;
import user.dto.Member;

public interface JoinPartyService {

	/**
	 * 파티가입 정보 추출하기
	 * 
 	 * @param req- 요청 정보 객체
	 * @return Party - 파티가입 정보 객체()
	 */
	Party getJoinParty(HttpServletRequest req);

	/**
	 * 파티가입 처리
	 * 
	 * @param party - 파티가입 정보 객체
	 */
	public void join(Party party);
	
	
}
