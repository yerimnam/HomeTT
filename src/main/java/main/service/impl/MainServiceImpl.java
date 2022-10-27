package main.service.impl;

import java.util.List;

import common.JDBCTemplate;
import main.dao.face.MainDao;
import main.dao.impl.MainDaoImpl;
import main.service.face.MainServcie;
import party.dto.Party;

public class MainServiceImpl implements MainServcie {
	private MainDao mainDao = new MainDaoImpl();
	
	@Override
	public List<Party> getList() {
		System.out.println("getList ");
		return mainDao.selectPartyList(JDBCTemplate.getConnection());
	}

}
