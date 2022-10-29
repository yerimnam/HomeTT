package admin.party.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.party.dao.face.AdPartyListDao;
import admin.party.dao.impl.AdPartyListDaoImpl;
import admin.party.dto.Party;
import admin.party.service.face.AdPartyListService;
import common.JDBCTemplate;
import util.Paging;

public class AdPartyListServiceImpl implements AdPartyListService {
	
private AdPartyListDao adPartyListDao = new AdPartyListDaoImpl();
	
	@Override
	public List<Party> getList(Paging paging) {
//		System.out.println("getList(paging) : " + paging);
		return adPartyListDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		int totalCount = adPartyListDao.selectCntAll(JDBCTemplate.getConnection());
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public Party getPartyno(HttpServletRequest req) {

		Party party = new Party();
		
		String param = req.getParameter("Partyno");
		if( null != param && !"".equals(param) ) { //전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리 
			party.setPartyNo( Integer.parseInt(param) );
		}
		
		return party;
	}
	
	@Override
	public Party view(Party partyno) {
		
		Connection conn = JDBCTemplate.getConnection();

		Party party = adPartyListDao.selectPartyByPartyno(conn, partyno);
		
		return party;
	}
	
	@Override
	public Paging getSearchPaging(HttpServletRequest req, String searchType, String keyword) {
		int totalCount = adPartyListDao.selectSearchCntAll(JDBCTemplate.getConnection() ,searchType ,keyword);
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		Paging searchpaging = new Paging(totalCount, curPage);
		return searchpaging;
	}
	
	@Override
	public List<Party> getSearchList(Paging paging, String searchType, String keyword) {
		return adPartyListDao.selectSearchList(JDBCTemplate.getConnection(), paging, searchType, keyword);
	}
	
}
