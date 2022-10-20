package party.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import party.dao.face.CreatePartyDao;
import party.dao.impl.CreatePartyDaoImpl;
import party.dto.Party;
import party.service.face.CreatePartyService;


public class CreatePartyServiceImpl implements CreatePartyService {

	//DAO 객체
	private CreatePartyDao createpartyDao = new CreatePartyDaoImpl();
	
	@Override
	public Party setCreateParty(HttpServletRequest req) {
		
		Party party = new Party();
		
		party.setPartyKind ( req.getParameter("party_kind") );
		party.setPartyRule ( req.getParameter("party_rule") );
		party.setPartyName ( req.getParameter("party_name") );
		party.setPartyLeader ( req.getParameter("party_leader") );

		
		return party;
	}

	@Override
	public Party create(Party party) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//seq의 nextval 조회하기
		int next = createpartyDao.selectNextUserno(conn);
		System.out.println("CreateParty create() - next : " + next);
		
		//조회디ㅗㄴ enxtval party객체 저장하기
		int result = createpartyDao.insert(conn, party);
		
		if( result > 0 ) {
			JDBCTemplate.commit(conn);
			return party;
		} else {
			JDBCTemplate.rollback(conn);
			return null;
		}
		
	}

}
