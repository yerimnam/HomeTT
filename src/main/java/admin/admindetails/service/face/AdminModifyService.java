package admin.admindetails.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.admindetails.dto.Admin;

public interface AdminModifyService {
	
	/**
	 * 게시글 전체 조회
	 * 
	 * @return List<Board> - 게시글 전체 조회 목록
	 */
	public List<Admin> getAdminModify(String id);
	
	
}
