package partyBoard.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import party.dto.Party;
import party.dto.PartyRoom;
import partyBoard.dao.face.PartyRoomBoardDao;
import partyBoard.dao.impl.PartyRoomBoardDaoImpl;
import partyBoard.dto.PartyBoard;
import partyBoard.service.face.PartyRoomBoardService;
import util.PbPaging;

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
	public List<PartyBoard> getBrList(PbPaging paging) {

		return partyRoomBoardDao.selectAllBr(JDBCTemplate.getConnection(), paging);
	}

//	@Override
//	public List<PartyBoard> getBrList(String searchCondition, String searchKeyword, PbPaging paging) {
//		return partyRoomBoardDao.selectAllBr(JDBCTemplate.getConnection(),searchCondition,searchKeyword, paging );
//	}

	@Override
	public PbPaging getBrPaging(HttpServletRequest req) {
		// 총 게시글 수 조회하기
		int totalCount = partyRoomBoardDao.selectPbAll(JDBCTemplate.getConnection());

		// 전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// Paging객체 생성
		PbPaging paging = new PbPaging(totalCount, curPage);

		return paging;
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
		partyBoard.setPartyBoardNo(partyboardNo);

		int result = partyRoomBoardDao.insert(conn, partyBoard);
		if (result > 0) {
			JDBCTemplate.commit(conn);
			return partyBoard;
		} else {
			JDBCTemplate.rollback(conn);
			return null;

		}
	}

	@Override
	public PartyBoard getpartyBoardno(HttpServletRequest req) {

		// 전달파라미터 저장할 객체 생성
		PartyBoard partyBoard = new PartyBoard();

		// 전달파라미터 partyboardno 파싱
		String param = req.getParameter("partyboardno");
		if (null != param && !"".equals(param)) { // 전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리
			partyBoard.setPartyBoardNo((Integer.parseInt(param)));
		}

		return partyBoard;
	}

	@Override
	public void delete(PartyBoard partyBoard) {

		Connection conn = JDBCTemplate.getConnection();

		// 게시글 삭제
		if (partyRoomBoardDao.delete(conn, partyBoard) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

	}

//	@Override
//	public List<PartyBoard> getPartySearchList(String searchType, String keyword) {
//		System.out.println("getPartySearchList() - 시작");
//		System.out.println("searchType" + searchType);
//		System.out.println("keyword" + keyword);
//		return partyRoomBoardDao.selectPbSearchList(JDBCTemplate.getConnection(), searchType, keyword);
//	}

	@Override
	public PartyRoom getPartyNo(HttpServletRequest req) {

		PartyRoom partyroom = new PartyRoom();

		String param = req.getParameter("partyRoomNo");

		if (null != param && !"".equals(param)) { // 전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리
			partyroom.setParty_room_no(Integer.parseInt(param));
		}

		return partyroom;
	}

//	@Override
//	public PartyRoom getPartyNo(HttpServletRequest req); {
//		// 전달파라미터를 저장할 객체 생성
//		PartyRoom partyRoom = new PartyRoom();
//
//		// 전달파라미터 partyno 추출(파싱)
//		String param = req.getParameter("partyRoomNo");
//		if (null != param && !"".equals(param)) { // 전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리
//			party.setPartyNo(Integer.parseInt(param));
//		}
//
//		return partyRoom;
//	}

	@Override
	public void dropParty(PartyRoom partyroomno) {
		Connection conn = JDBCTemplate.getConnection();

		if (partyRoomBoardDao.delete(conn, partyroomno) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

	}

}
