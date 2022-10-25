package partyBoard.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
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
		System.out.println(partyboardNo);
		partyBoard.setPartyBoardNo(partyboardNo);

		System.out.println(partyBoard);
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
		
		//전달파라미터 저장할 객체 생성
		PartyBoard partyBoard = new PartyBoard();
		
		//전달파라미터 partyboardno 파싱
		String param = req.getParameter("partyboardno");
		if( null != param && !"".equals(param) ) { // 전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리 
			partyBoard.setPartyBoardNo((Integer.parseInt(param)));
		}
		
		return partyBoard;
	}


	@Override
	public void delete(PartyBoard partyBoard) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 삭제
		if(partyRoomBoardDao.delete(conn, partyBoard) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}





}
