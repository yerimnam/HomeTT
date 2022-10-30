package party.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import party.dao.face.PartyModifyDao;
import party.dao.impl.PartyModifyDaoImpl;
import party.dto.Party;
import party.service.face.PartyModifyService;
import util.Paging;
import util.PrPaging;

public class PartyModifyServiceImpl implements PartyModifyService {

	// DAO객체
	private PartyModifyDao partyModifyDao = new PartyModifyDaoImpl();

	@Override
	public List<Party> getPrList() {
		System.out.println("PartyModifyService getPrList() - 시작");

		System.out.println("PartyModifyService getPrList() - 끝");

		// DB조회결과 반환
		return partyModifyDao.selectAllPr(JDBCTemplate.getConnection());
	}

	@Override
	public List<Party> getPrList(PrPaging paging) {
		return partyModifyDao.selectAllPr(JDBCTemplate.getConnection(), paging);
	}
	
	
	@Override
	public PrPaging getPrPaging(HttpServletRequest req) {

		// 총 게시글 수 조회하기
		int totalCount = partyModifyDao.selectPrAll(JDBCTemplate.getConnection());

		// 전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// Paging객체 생성
		PrPaging paging = new PrPaging(totalCount, curPage);

		return paging;
	}

	@Override
	public Party getPartyNo(HttpServletRequest req) {

		//전달파라미터를 저장할 객체 생성
		Party party = new Party();
		
		//전달파라미터 partyRoomNo 추출(파싱)
		String param = req.getParameter("partyNo"); 
		System.out.println(param);
		
		if( null != param && !"".equals(param)) {//전달파라미터가 null또는 ""빈문자열 아닐때
			party.setPartyRoomNo(Integer.parseInt(param));
		}
		return party;
	}

	@Override
	public Party view(Party partyNo) {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		if(partyModifyDao.selectPartyByPartyRoomNo(conn, partyNo) != null) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//게시글 조회
		Party party = partyModifyDao.selectPartyByPartyRoomNo(conn, partyNo);
		
		
		
		return party;
	}

	@Override
	public PrPaging getSearchPaging(HttpServletRequest req, String searchType, String keyword) {
		int totalCount = partyModifyDao.selectSearchCntAll(JDBCTemplate.getConnection() ,searchType ,keyword);
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		PrPaging searchpaging = new PrPaging(totalCount, curPage);
		return searchpaging;
	}




	@Override
	public List<Party> getSearchList(PrPaging paging, String searchType, String keyword) {
		return partyModifyDao.selectSearchList(JDBCTemplate.getConnection(),paging, searchType, keyword);
	}

}
