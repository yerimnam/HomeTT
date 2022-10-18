package partyCheck.service.face;

import java.util.List;

import partyCheck.dto.PartyCheck;

public interface CreatePartyCheckService {

	/**
	 *  생성한 파티 전체 조회
	 *  
	 * @return List<partyCheck> - 생성한 파티 전체 조회
	 */
	List<PartyCheck> getList();

}
