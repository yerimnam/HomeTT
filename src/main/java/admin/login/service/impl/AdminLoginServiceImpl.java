package admin.login.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import admin.login.dao.face.AdminLoginDao;
import admin.login.dao.impl.AdminLoginDaoImpl;
import admin.login.dto.Admin;
import admin.login.service.face.AdminLoginService;
import common.JDBCTemplate;
import user.dao.impl.UserDaoImpl;
import user.dto.Member;

public class AdminLoginServiceImpl implements AdminLoginService {

	//DAO 객체
	private AdminLoginDao adminLoginDao = new AdminLoginDaoImpl();

	//DB연결 객체
	Connection conn = JDBCTemplate.getConnection();
	
	
	@Override
	public Admin getLoginParam(HttpServletRequest req) {

		System.out.println("AdminLoginService getLoginParam() -  시작");
		
		Admin admin = new Admin();

		admin.setAdminId( req.getParameter("id") );
		admin.setAdminPw( req.getParameter("pw") );

		System.out.println("AdminLoginService getLoginParam() -  끝");
		return admin;
	}
	
	
	@Override
	public boolean login(Admin admin) {
		System.out.println("AdminLoginService login() -  시작");
		
		//로그인 인증 성공
		if( adminLoginDao.selectLoginIdPw(conn, admin) > 0 ) {
			return true;
		}

		System.out.println("AdminLoginService login() -  끝");
		//로그인 인증 실패
		return false;
	}
	
	
	@Override
	public Admin loginInfo(Admin admin) {
		return adminLoginDao.selectLoginInfo(conn, admin);
	}
	
	
}








