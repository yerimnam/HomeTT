package party.service.impl;

import java.sql.Connection;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.websocket.Transformation;

import common.JDBCTemplate;
import party.dao.face.JoinPartyDao;
import party.dao.impl.JoinPartyDaoImpl;
import party.dto.Party;
import party.service.face.JoinPartyService;

public class JoinPartyServiceImpl implements JoinPartyService {

	//DAO객체
	private JoinPartyDao joinPartyDao = new JoinPartyDaoImpl();
	
	@Override
	public Party getJoinParty(HttpServletRequest req) {
		
		Party party = new Party();
		
		party.setPartyKind(req.getParameter("party_kind"));
		party.setPartyName(req.getParameter("party_name"));
		party.setPartyRoomNo(Integer.parseInt(req.getParameter("party_room_no")));
		party.setPartyLeader(req.getParameter("party_leader"));
//		party.setPartyEndDate(format.(req.getParameter("party_endDate")));
		party.setPartyMember(Integer.parseInt(req.getParameter("party_member")));
		party.setPaymentAmount(Integer.parseInt("paymentAmount"));
		
		return party;
	}

	@Override
	public void join(Party party) {

		Connection conn = JDBCTemplate.getConnection();
		
		if(joinPartyDao.insert(conn,party) > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
	}

}
