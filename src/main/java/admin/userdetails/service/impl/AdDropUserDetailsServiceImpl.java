package admin.userdetails.service.impl;

import java.sql.Connection;
import java.util.List;

import admin.userdetails.dao.face.AdDropUserDetailsDao;
import admin.userdetails.dao.impl.AdDropUserDetailsDaoImpl;
import admin.userdetails.dto.Dmember;
import admin.userdetails.service.face.AdDropUserDetailsService;
import common.JDBCTemplate;

public class AdDropUserDetailsServiceImpl implements AdDropUserDetailsService {
	
	private AdDropUserDetailsDao adDropUserDetailsDao = new AdDropUserDetailsDaoImpl();
	
	@Override
	public List<Dmember> getchUserinfo( String searchType, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<Dmember> userinfo = null;
		if( null != keyword && !"".equals(keyword) ) { //전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리 
			userinfo = adDropUserDetailsDao.selectUserInfo(conn, searchType, keyword);
		} 
		
//		System.out.println("getchUserinfo" + userinfo);
		return userinfo;
		
	}
	
}
