package partyExit.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import partyExit.dto.PartyExit;
import partyExit.service.face.PartyExitService;

public class PartyExitServiceImpl implements PartyExitService {

	@Override
	public PartyExit getPartyNo(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PartyExit partyexit) {

		Connection conn = JDBCTemplate.getConnection();
		
	}

}
