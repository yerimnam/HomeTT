package partyBoard.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import partyBoard.dao.face.PartyRoomBoardDao;
import partyBoard.dao.impl.PartyRoomBoardDaoImpl;
import partyBoard.dto.PartyBoard;
import partyBoard.service.face.PartyRoomBoardService;

public class PartyRoomBoardServiceImpl implements PartyRoomBoardService {

	// DAO객체
	private PartyRoomBoardDao partyRoomBoardDao = new PartyRoomBoardDaoImpl();

	@Override
	public List<PartyBoard> getBrList() {
		System.out.println("PartyRoomBoardService getBrList() - 시작");

		System.out.println("PartyRoomBoardService getBrList() - 끝");

		// DB조회 결과 반환
		return partyRoomBoardDao.selectAllBr(JDBCTemplate.getConnection());
	}
	
	@Override
	public PartyBoard getParam(HttpServletRequest req) {
		PartyBoard partyBoard = new PartyBoard();

		partyBoard.setPartyBoardNo(Integer.parseInt(req.getParameter("party_boardNo")));
		partyBoard.setPartyBoardWriter(req.getParameter("party_boardWriter"));
		partyBoard.setPartyBoardTitle(req.getParameter("party_boardtitle"));

		return partyBoard;
	}

	@Override
	public PartyBoard write(HttpServletRequest req) {
		// DB연결 객체
		Connection conn = JDBCTemplate.getConnection();

		PartyBoard partyBoard = new PartyBoard();

		String userId = (String) req.getSession().getAttribute("userId");
		partyBoard.setPartyBoardWriter(userId);

		String title = (String) req.getParameter("partyBoardTitle");
		partyBoard.setPartyBoardTitle(title);

		int partyboardNo = partyRoomBoardDao.selectNextBoardno(conn);
		partyBoard.setBoardNo(partyboardNo);

		int result = partyRoomBoardDao.insert(conn, partyBoard);
		if (result > 0) {
			JDBCTemplate.commit(conn);
			return partyBoard;
		} else {
			JDBCTemplate.rollback(conn);
			return null;

		}
	}



}
