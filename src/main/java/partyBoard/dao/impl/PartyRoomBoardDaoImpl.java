package partyBoard.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import partyBoard.dao.face.PartyRoomBoardDao;

public class PartyRoomBoardDaoImpl implements PartyRoomBoardDao {
	
	private PreparedStatement ps;	//sql 수행 객체
	private ResultSet rs;	//조회 결과 객체
	
	
	@Override
	public int insertPrBoard() {
		// TODO Auto-generated method stub
		return 0;
	}

}
