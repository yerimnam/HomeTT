package admin.admindetails.service.impl;

import java.util.List;

import admin.admindetails.dao.face.AdminModifyDao;
import admin.admindetails.dao.impl.AdminModifyDaoImpl;
import admin.admindetails.dto.Admin;
import admin.admindetails.service.face.AdminModifyService;
import common.JDBCTemplate;

public class AdminModifyServiceImpl implements AdminModifyService {
	
	//DAO 객체
	private AdminModifyDao adminModifyDao = new AdminModifyDaoImpl();
		
	@Override
	public List<Admin> getAdminModify(String id) {
		System.out.println("AdminModifyService getAdminModify()");
		
		//DB 조회결과 반환
		return adminModifyDao.updateAdmin(JDBCTemplate.getConnection(), id);
	}
	
}
