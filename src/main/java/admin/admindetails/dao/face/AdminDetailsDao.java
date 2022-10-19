package admin.admindetails.dao.face;

import java.sql.Connection;
import java.util.List;

import admin.admindetails.dto.Admin;

public interface AdminDetailsDao {
	
	/**
	 * 게시글 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<Board> - 테이블 전체 조회 목록
	 */
	public List<Admin> selectAdmin(Connection conn, String id);
	
}
