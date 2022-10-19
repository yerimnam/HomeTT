package user.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import user.dao.face.UserDao;
import user.dto.Member;

public class UserDaoImpl implements UserDao {

 
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //결과 집합 객체

	@Override
	public int selectNextUserno(Connection conn) {

		String sql = "SELECT member_seq.nextval FROM dual";

		//시퀀스 nextval을 저장할 변수
		int nextuserno = 0;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			rs.next();

			nextuserno = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return nextuserno;

	}
	
	


	@Override
	public int insert(Connection conn, Member member) {
		System.out.println("UserDao insert() - 시작");

		String sql = "";
		sql += "INSERT INTO member ( USER_NO, MASTER_NO, USER_ID, USER_PW, ";
		sql += " USER_NAME, USER_NICK, USER_EMAIL, USER_PHONE, USER_JOIN)"; //, USER_JOIN - 나중에 기입
		sql += " VALUES(?, ?, ?, ?, ?, ?, ?, ?, sysdate)";


		//INSERT 수행 결과 변수
		int result = 0;

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, member.getUserNo());
			ps.setInt(2, 2);
			ps.setString(3, member.getUserId());
			ps.setString(4, member.getUserPw());
			ps.setString(5, member.getUserName());
			ps.setString(6, member.getUserNick());
			ps.setString(7, member.getUserEmail());
			ps.setInt(8, member.getUserPhone());
//			ps.setDate(9, sysdate);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}

		System.out.println("UserDao insert() - 끝");
		return result;
	}


}









