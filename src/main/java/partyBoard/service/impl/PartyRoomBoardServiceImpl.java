package partyBoard.service.impl;

import java.util.List;

import common.JDBCTemplate;
import partyBoard.dao.face.PartyRoomBoardDao;
import partyBoard.dao.impl.PartyRoomBoardDaoImpl;
import partyBoard.dto.PartyBoard;
import partyBoard.service.face.PartyRoomBoardService;

public class PartyRoomBoardServiceImpl implements PartyRoomBoardService {
	
	//DAO객체
	private PartyRoomBoardDao partyRoomBoardDao = new PartyRoomBoardDaoImpl();

	@Override
	public List<PartyBoard> getBrList() {
		System.out.println("PartyRoomBoardService getBrList() - 시작");
		
		System.out.println("PartyRoomBoardService getBrList() - 끝");
		
		//DB조회 결과 반환
		return partyRoomBoardDao.selectBrAll(JDBCTemplate.getConnection());
	}

	@Override
	public List<PartyBoard> getheadList() {
		return partyRoomBoardDao.selectHead(JDBCTemplate.getConnection());
	}
	
	

}
