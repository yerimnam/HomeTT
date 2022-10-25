package invitation.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import invitation.dao.face.InvitationDao;
import invitation.dao.impl.InvitationDaoImpl;
import invitation.dto.Invitation;
import invitation.service.face.InvitationService;

public class InvitationServiceImpl implements InvitationService {

	// DAO 객체
	private InvitationDao invitationDao = new InvitationDaoImpl();
	
	@Override
	public Invitation view(Invitation partyNo) {

		// DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		// 파티방 조회
		Invitation invitation = invitationDao.selectInvitationByPartyno(conn, partyNo);
		
		// 조회된 파티방 리턴
		return invitation;
	}

	@Override
	public Invitation getPartyNo(HttpServletRequest req) {

		// 전달파라미터를 저장할 객체 생성
		Invitation invitation = new Invitation();
		
		// 전달파라미터 partyNo 추출
		String param = req.getParameter("partyNo");
		if(null != param && !"".equals(param)) {
			invitation.setPartyNo(Integer.parseInt(param));
		}
		
		return invitation;
	}

}
