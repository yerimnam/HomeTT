package partyCheck.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import partyCheck.dao.face.PartyCheckDao;
import partyCheck.dao.impl.PartyCheckDaoImpl;
import partyCheck.dto.PartyCheck;
import partyCheck.service.face.PartyCheckService;
import util.Paging;

public class PartyCheckServiceImpl implements PartyCheckService {

	// DAO객체
	private PartyCheckDao partyCheckDao = new PartyCheckDaoImpl();
	
	@Override
	public List<PartyCheck> getList() {
		System.out.println("PartyCheckService getList() - Start");
		
		
		System.out.println("PartyCheckService getList() - end");
		
		// DB조회결과 반환
		return partyCheckDao.selectAll(JDBCTemplate.getConnection());
	}
	
	@Override
	public List<PartyCheck> getList(Paging paging) {
		return partyCheckDao.selectAll(JDBCTemplate.getConnection(), paging);
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		System.out.println("PartyCheckService getPaging() - Start");
		
		// 총 파티수 조회
		int totalCount = partyCheckDao.selectCntAll(JDBCTemplate.getConnection());
		
		// 전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		System.out.println("PartyCheckService getPaging() - end");
		return paging;
	}

}
