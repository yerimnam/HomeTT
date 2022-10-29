package admin.userdetails.dao.face;

import java.sql.Connection;
import java.util.List;

import admin.userdetails.dto.Dmember;

public interface AdDropUserDetailsDao {

	/**
	 * searchType, keyword 전달파라미터에 대한 조회 결과를 Dmember DTO로 저장하여 반환한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param searchType - 검색 카테고리 전달 파라미터
	 * @param keyword - 검색어 전달 파라미터
	 * @return Dmember - 전달파라미터를 저장한 DTO객체
	 */
	public List<Dmember> selectUserInfo(Connection conn, String searchType, String keyword);
	
	
	
}
