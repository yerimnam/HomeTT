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

	
//	---------------------------------회원가입 시작 -----------------------------------
		
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

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}

		System.out.println("UserDao insert() - 끝");
		return result;
	}

	
//	---------------------------------회원가입 끝 -----------------------------------
	
//	---------------------------------로그인 시작 -----------------------------------
	
	
	@Override
	public int selectLoginIdPw(Connection conn, Member member) {

		System.out.println("UserDao selectLoginIdPw() - 시작");
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM member";
		sql += " WHERE user_id = ?";
		sql += "	AND user_pw = ?";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserId());
			ps.setString(2, member.getUserPw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("UserDao selectLoginIdPw() - 끝");
		return cnt;
		
	}
	
	
	@Override
	public Member selectLoginInfo(Connection conn, Member member) {

		System.out.println("UserDao selectLoginInfo() - 시작");
		
		String sql = "";
		sql += "SELECT user_no, master_no, user_id, user_pw, user_nick FROM member";
		sql += " WHERE user_id = ?";
		
		Member result = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserId());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new Member();
				
				result.setUserNo( rs.getInt("user_no") );
				result.setMasterNo( rs.getInt("master_no") );
				result.setUserId( rs.getString("user_id") );
				result.setUserPw( rs.getString("user_pw") );
				result.setUserNick( rs.getString("user_nick") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		System.out.println("UserDao selectLoginInfo() - 끝");
		return result;
		
	}
	
	
//	---------------------------------로그인 끝 -----------------------------------
	
}









