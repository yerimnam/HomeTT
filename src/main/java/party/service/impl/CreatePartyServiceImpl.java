package party.service.impl;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import party.dao.face.CreatePartyDao;
import party.dao.impl.CreatePartyDaoImpl;
import party.dto.Party;
import party.service.face.CreatePartyService;
import user.dto.Member;


public class CreatePartyServiceImpl implements CreatePartyService {

	//DAO 객체
	private CreatePartyDao createpartyDao = new CreatePartyDaoImpl();
	
	@Override
	public Party getCreateParty(HttpServletRequest req) {
		
		Party party = new Party();
		
		party.setPartyKind(req.getParameter("partyKind"));
		party.setPartyRule(req.getParameter("partyRule"));
		party.setPartyName(req.getParameter("partyName"));
		party.setPartyLeader(req.getParameter("partyLeader"));
		party.setPartyMember(Integer.parseInt(req.getParameter("partyMember")));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		
		String endtDate = req.getParameter("endtDate");
		try {
			party.setPartyEndDate( sdf.parse(endtDate) );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return party;
	}
	

	@Override
	public Party create(Party party) {
		
		//DB 연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//party_seq의 nextval(nextpartyno) 조회하기
		
		int next = createpartyDao.selectNextPartyno(conn);
		System.out.println("CreatePartyService create() - next : " + next);
		
		//조회디ㅗㄴ enxtval party객체 저장하기
		party.setPartyNo(next);
		System.out.println("CreatePartyService create() - next : " + party);
		
		//완성된 party객체 DB에 삽ㅇㅂ
		int result = createpartyDao.insert(conn, party);
		
		System.out.println("CreatePartyService create() - 끝 ");

		
		//결과 처리하기 - 트랜잭션 관리
		if( result > 0 ) {	//DB 삽입 성공
			JDBCTemplate.commit(conn);
			return party;
			
		} else { //삽입 실패
			JDBCTemplate.rollback(conn);
			return null;
		}
		
	}


	@Override
	public Member getuserinfo(int userno) {
	
		return createpartyDao.selectUserinfo(JDBCTemplate.getConnection(),userno);
	}

}
