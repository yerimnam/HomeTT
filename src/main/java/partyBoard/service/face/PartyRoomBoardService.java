package partyBoard.service.face;

import java.util.List;

import partyBoard.dto.PartyBoard;

public interface PartyRoomBoardService {

	/** 
	 * 게시글 전치 조회
	 * 
	 * @return List<PartyBoard> - 게시글 전체 조회 목록
	 */
	public List<PartyBoard> getBrList();

	//계정공유기간, 인원수 조회
	public List<PartyBoard> getheadList();
	

}
