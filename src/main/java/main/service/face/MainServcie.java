package main.service.face;

import java.util.List;

import party.dto.Party;

public interface MainServcie {

	
	/**
	 * 현재 열린 방 목록 조회
	 * @return - 현재 열린 방 목록 
	 */
	List<Party> getList();

}
