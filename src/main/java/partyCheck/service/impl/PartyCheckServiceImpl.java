package partyCheck.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import partyCheck.dao.face.PartyCheckDao;
import partyCheck.dao.impl.PartyCheckDaoImpl;
import partyCheck.dto.PartyCheck;
import partyCheck.service.face.PartyCheckService;
import util.Paging5;

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
	public List<PartyCheck> getList(Paging5 paging5) {
		return partyCheckDao.selectAll(JDBCTemplate.getConnection(), paging5);
	}

	@Override
	public Paging5 getPaging(HttpServletRequest req) {
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
		Paging5 paging = new Paging5(totalCount, curPage);
		
		System.out.println("PartyCheckService getPaging() - end");
		return paging;
	}

	@Override
	public PartyCheck getPartyNo(HttpServletRequest req) {

		// 전달파라미터를 저장할 객체 생성
		PartyCheck partycheck = new PartyCheck();
		
		// 전달파라미터 partyNo 추출
		String param = req.getParameter("partyNo");
		if(null != param && !"".equals(param)) {
			partycheck.setPartyNo(Integer.parseInt(param));
		}
		
		return partycheck;
	}

	@Override
	public void delete(PartyCheck partyCheck) {
		Connection conn = JDBCTemplate.getConnection();
		
		// 파티방 나가기(DB삭제)
		if(partyCheckDao.delete(conn, partyCheck) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}

}
