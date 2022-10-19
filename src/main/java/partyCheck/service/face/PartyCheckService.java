package partyCheck.service.face;

import java.util.List;

import partyCheck.dto.PartyCheck;

public interface PartyCheckService {

	/**
	 * 파티 목록 전체 조회
	 * 
	 * @return - 파티 전제 조회 목록
	 */
	public List<PartyCheck> getList();
}
