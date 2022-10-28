package admin.userdetails.service.face;

import java.util.List;

import admin.userdetails.dto.Dmember;

public interface AdDropUserDetailsService {
	
	/**
	 * searchType, keyword 파라미터에 대한 조회 결과를 Dmember DTO로 저장하여 반환한다
	 * 
	 * @param searchType - 검색 카테고리 전달 파라미터
	 * @param keyword - 검색어 전달 파라미터
	 * @return Dmember - 전달파라미터를 저장한 DTO객체
	 */
	public List<Dmember> getchUserinfo(String searchType, String keyword );
	
}
