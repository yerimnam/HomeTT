package admin.admindetails.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.admindetails.dao.face.AdminDetailsDao;
import admin.admindetails.dao.impl.AdminDetailsDaoImpl;
import admin.admindetails.dto.Admin;
import admin.admindetails.service.face.AdminDetailsService;
import common.JDBCTemplate;

public class AdminDetailsServiceImpl implements AdminDetailsService {
	
	//DAO 객체
	private AdminDetailsDao adminDao = new AdminDetailsDaoImpl();
		
	@Override
	public List<Admin> getAdminInfo(String id) {
		System.out.println("AdminDetailsService getAdminInfoList()");
		
		//DB 조회결과 반환
		return adminDao.selectAdmin(JDBCTemplate.getConnection(), id);
	}
	
}
