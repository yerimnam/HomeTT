package party.service.impl;

import java.sql.Connection;

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
	
//	@Override
//	public Party getCreateParty(HttpServletRequest req) {
//		
//		Party party = new Party();
//		
//		party.setPartyKind ( req.getParameter("partykind") );
//		party.setPartyRule ( req.getParameter("partyrule ") );
//		party.setPartyName ( req.getParameter("partyname") );
//		party.setPartyLeader ( req.getParameter("partyleader") );
//		party.setPartyMember( Integer.parseInt(req.getParameter("partymember")) );
//		party.setPartyCreDate(null);
//		party.setPartyEndDate(null);
//		
//		return party;
//	}
//	

	@Override
	public void create(HttpServletRequest req) {
		
		//dto 객체
		Party party = new Party();
		
		//DB 연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//partyno 생성
		int partyno = createpartyDao.selectNextPartyno(conn);
		System.out.println("CreatePartyService create() - partyno 생성 테스트 : " + partyno);
		
		//게시글 번호를 삽입한다
		party.setPartyNo(partyno);
		
		//작성자(파티리더가 될 사람) ID 처리하기
		party.setPartyLeader( (String) req.getSession().getAttribute("userid"));

		
		//결과 처리하기 - 트랜잭션 관리
//		if( result > 0 ) {	//DB 삽입 성공
//			JDBCTemplate.commit(conn);
//			return party;
//			
//		} else { //삽입 실패
//			JDBCTemplate.rollback(conn);
//			return null;
//		}
		
	}


	@Override
	public Member getuserinfo(int userno) {
	
		return createpartyDao.selectUserinfo(JDBCTemplate.getConnection(),userno);
	}

}
