package admin.userdetails.service.impl;

import java.sql.Connection;
import java.util.List;

import admin.userdetails.dao.face.AdUserDetailsDao;
import admin.userdetails.dao.impl.AdUserDetailsDaoImpl;
import admin.userdetails.dto.Member;
import admin.userdetails.service.face.AdUserDetailsService;
import common.JDBCTemplate;

public class AdUserDetailsServiceImpl implements AdUserDetailsService {
	
	private AdUserDetailsDao adUserDetailsDao = new AdUserDetailsDaoImpl();
	
	@Override
	public List<Member> getchUserinfo( String searchType, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<Member> userinfo = null;
		if( null != keyword && !"".equals(keyword) ) { //전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리 
			userinfo = adUserDetailsDao.selectUserInfo(conn, searchType, keyword);
		} 
		
//		System.out.println("getchUserinfo" + userinfo);
		return userinfo;
		
	}
	
}
