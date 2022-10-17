package partyBoard.service.impl;

import partyBoard.dao.face.PartyRoomBoardDao;
import partyBoard.dao.impl.PartyRoomBoardDaoImpl;
import partyBoard.dto.PartyBoard;
import partyBoard.service.face.PartyRoomBoardService;

public class PartyRoomBoardServiceImpl implements PartyRoomBoardService {
	
	private PartyRoomBoardDao prBoardDao = new PartyRoomBoardDaoImpl();

	@Override
	public PartyBoard setPrBoard() {
		return null;
	}
	

}
