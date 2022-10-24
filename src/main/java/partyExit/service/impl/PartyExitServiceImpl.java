package partyExit.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import partyExit.dao.face.PartyExitDao;
import partyExit.dao.impl.PartyExitDaoImpl;
import partyExit.dto.PartyExit;
import partyExit.service.face.PartyExitService;

public class PartyExitServiceImpl implements PartyExitService {

	// DAO 객체
	private PartyExitDao partyExitDao = new PartyExitDaoImpl();
	
	@Override
	public PartyExit getPartyNo(HttpServletRequest req) {

		// 전달파라미터를 저장할 객체 생성
		PartyExit partyExit = new PartyExit();
		
		// 전달파라미터 partyNo 추출
		String param = req.getParameter("partyNo");
		if(null != param && !"".equals(param)) {
			partyExit.setPartyNo(Integer.parseInt(param));
		}
		
		return partyExit;
	} 

	@Override
	public void delete(PartyExit partyExit) {

		Connection conn = JDBCTemplate.getConnection();
		
		// 파티방 나가기
		if(partyExitDao.delete(conn, partyExit) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}

}
