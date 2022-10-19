package partyCheck.service.impl;

import java.util.List;

import common.JDBCTemplate;
import partyCheck.dao.face.CreatePartyCheckDao;
import partyCheck.dao.impl.CreatePartyCheckDaoImpl;
import partyCheck.dto.PartyCheck;
import partyCheck.service.face.CreatePartyCheckService;

public class CreatePartyCheckServiceImpl implements CreatePartyCheckService {

	// DAO 객체 생성
	private CreatePartyCheckDao createPartyCheckDao = new CreatePartyCheckDaoImpl();
	
	@Override
	public List<PartyCheck> getList() {
		System.out.println("CreatePartyCheck getList()");
		
		return createPartyCheckDao.selectAll(JDBCTemplate.getConnection());
	}
	
	

}
