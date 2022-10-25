package wishListCheck.service.impl;

import java.util.List;

import common.JDBCTemplate;
import wishListCheck.dao.face.WishListCheckDao;
import wishListCheck.dao.impl.WishListCheckDaoImpl;
import wishListCheck.dto.WishListCheck;
import wishListCheck.service.face.WishListCheckService;

public class WishListCheckServiceImpl implements WishListCheckService {

	// DAO 객체
	private WishListCheckDao wishListCheckDao = new WishListCheckDaoImpl();
	
	@Override
	public List<WishListCheck> getList() {
		System.out.println("wishListCheckService getList() - start");
		
		System.out.println("wishListCheckService getList() - end");
		
		return wishListCheckDao.selectAll(JDBCTemplate.getConnection());
	}

}
