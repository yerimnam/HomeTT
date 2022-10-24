package party.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import party.dao.face.CommentDao;
import party.dto.Comments;

public class CommentDaoImpl implements CommentDao {
	

	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	
	
	@Override
	public int delete(Connection conn, Comments comments) {

		String sql = "";
		sql += "DELETE board";
		sql += " WHERE boardno = ?";

		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comments.getCommentsNo());

			res = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return res;

	}

}