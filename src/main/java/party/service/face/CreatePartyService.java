package party.service.face;

import javax.servlet.http.HttpServletRequest;

import party.dto.Party;


public interface CreatePartyService {


	/**
	 * 파티만들기 했을 때 전달파라미터 추출
	 * @param req
	 * @return
	 */
	public Party setCreateParty(HttpServletRequest req);

	/**
	 * 파티 생성하고 처리하는 메소드
	 * @param party
	 */
	public Party create(Party party);
	
	
}
