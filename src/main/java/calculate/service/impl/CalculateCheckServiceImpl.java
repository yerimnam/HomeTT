package calculate.service.impl;

import java.util.List;

import calculate.dao.face.CalculateCheckDao;
import calculate.dao.impl.CalculateCheckDaoImpl;
import calculate.dto.Calculate;
import calculate.service.face.CalculateCheckService;
import common.JDBCTemplate;

public class CalculateCheckServiceImpl implements CalculateCheckService {

	// DAO 객체
	private CalculateCheckDao calculateCheckDao = new CalculateCheckDaoImpl();
	
	@Override
	public List<Calculate> getList() {
		System.out.println("CalculateCheckService getList() - start");

		System.out.println("CalculateCheckService getList() - end");
		return calculateCheckDao.selectAll(JDBCTemplate.getConnection());
	}

}
