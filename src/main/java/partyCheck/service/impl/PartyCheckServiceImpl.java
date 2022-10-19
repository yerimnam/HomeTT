package partyCheck.service.impl;

import java.util.List;

import common.JDBCTemplate;
import partyCheck.dao.face.PartyCheckDao;
import partyCheck.dao.impl.PartyCheckDaoImpl;
import partyCheck.dto.PartyCheck;
import partyCheck.service.face.PartyCheckService;

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

}
