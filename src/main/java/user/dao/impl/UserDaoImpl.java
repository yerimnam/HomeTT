package user.dao.impl;

import java.sql.Connection;
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
	
	
@Override
	public int checkId(Connection conn, Member member) {
	System.out.println("UserDao checkId() - 시작");

		String sql = "";
		sql += "SELECT * FROM member WHERE user_id = ?";
		
		int idCheck = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserId());
			
			rs = ps.executeQuery();
			
			if(rs.next() || member.getUserId().equals("")) {
				idCheck = 0;  // 이미 존재하는 경우, 생성 불가능
			} else {
				idCheck = 1;  // 존재하지 않는 경우, 생성 가능
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return idCheck;
	
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
		sql += "SELECT user_no, master_no, user_id, user_pw, user_name, user_nick,";
		sql += " user_email, user_phone FROM member";
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
				result.setUserName( rs.getString("user_name") );
				result.setUserNick( rs.getString("user_nick") );
				result.setUserEmail( rs.getString("user_email") );
				result.setUserPhone( rs.getInt("user_phone") );
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
	
//	---------------------------------아이디찾기 시작 -----------------------------------
	
	
	@Override
	public Member getMemberId(Connection conn, Member member) {
		System.out.println("UserDao getMemberId() - 시작");
		
		String sql = "";
		sql += "SELECT user_id FROM member";
		sql += " WHERE user_name = ?";
		sql += " AND user_email = ?";
		
		Member result = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserName());
			ps.setString(2, member.getUserEmail());
			 
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new Member();
				
				result.setUserId( rs.getString("user_id") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("getMemberId result : " + result);
		System.out.println("UserDao getMemberId() - 끝");
		return result;
	}
	
//	---------------------------------아이디찾기 끝 -----------------------------------	
	
//	---------------------------------비밀번호찾기 시작 -----------------------------------	
	
	@Override
	public Member getIdNamePhone(Connection conn, Member member) {
		String sql = "";
		sql += "SELECT user_id, user_name, user_phone FROM member";
		sql += " WHERE user_id = ?";
		sql += " AND user_name = ?";
		sql += " AND user_phone = ?";
		
		Member result = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserId());
			ps.setString(2, member.getUserName());
			ps.setInt(3, member.getUserPhone());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new Member();
				
				result.setUserId( rs.getString("user_id") );
				result.setUserName( rs.getString("user_name") );
				result.setUserPhone( rs.getInt("user_phone") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return result;
	}
	
	
	@Override
	public int UpdatePwDao(Connection conn, Member member) {

		System.out.println("UpdatePwDao : " + member.getUserId());
		System.out.println("UpdatePwDao : " + member.getUserName());
		
		String sql = "";
		sql += "UPDATE member";
		sql += "	SET user_pw = ?";
		sql += " WHERE user_id = ?";
		sql += " AND user_name = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserPw());
			ps.setString(2, member.getUserId());
			ps.setString(3, member.getUserName());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
		
	}
	
	
//	---------------------------------비밀번호찾기 끝 -----------------------------------	
	
//	---------------------------------회원탈퇴 시작 -----------------------------------	
	
	@Override
	public Member selectUserPw(Connection conn, Member member) {
		
		System.out.println("UserDao selectUserPw() - 시작");
		
		String sql = "";
		sql += "SELECT user_pw FROM member";
		sql += " WHERE user_id = ?";
		
		Member result = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserId());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new Member();
				
				result.setUserPw( rs.getString("user_pw") );

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		System.out.println("UserDao selectUserPw() - 끝");
		return result;

	}
	
	
	@Override
	public int deleteUserInfo(Connection conn, Member member) {
		System.out.println("UserDao deleteUserInfo() - 시작");

		System.out.println(member.getUserId() + " ++++ " + member.getUserPw());
		String sql = "";
		sql += "DELETE FROM member";
		sql += " WHERE user_id = ?"; 
		sql += " AND user_pw = ?";

		//INSERT 수행 결과 변수
		int result = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserId());
			ps.setString(2, member.getUserPw());
			
			result = ps.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}

		System.out.println("UserDao deleteUserInfo() - 끝");
		return result;
		
	} 

//	---------------------------------회원탈퇴 끝 -----------------------------------	
	
//	---------------------------------회원정보 수정 시작 -----------------------------------	
	
	@Override
	public int UpdateUserInfo(Connection conn, Member member) {
		System.out.println("UpdateUserInfo getUserPw : " + member.getUserPw());
		System.out.println("UpdateUserInfo getUserNick : " + member.getUserNick());
		System.out.println("UpdateUserInfo getUserEmail : " + member.getUserEmail());
		System.out.println("UpdateUserInfo getUserPhone : " + member.getUserPhone());
		
		String sql = "";
//		sql += "UPDATE member";
//		sql += "	SET (user_pw, user_nick, user_email, user_phone) = (?, ?, ?, ?)";
//		sql += "	FROM member";
		
		sql += "UPDATE member";
		sql += "	SET user_pw = ?";
		sql += "	, user_nick = ?";
		sql += "	, user_email = ?";
		sql += "	, user_phone = ?";
		sql += "	WHERE user_id = ? ";

		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserPw());
			ps.setString(2, member.getUserNick());
			ps.setString(3, member.getUserEmail());
			ps.setInt(4, member.getUserPhone());
			ps.setString(5, member.getUserId());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
//	---------------------------------회원정보 수정 끝 -----------------------------------	
	
//	---------------------------------유저타입 변환 시작 -----------------------------------	
	
	
	@Override
	public int UpdateUserType(Connection conn, Member member) {
		System.out.println("UserDao UpdateUserType() - 시작");

		System.out.println("member.getUserId() : " + member.getUserId());
		System.out.println("member.getUserName() : "+ member.getUserName());
		
		String sql = "";
		
		sql += "UPDATE member";
		sql += "	SET master_no = '1'";
		sql += "	WHERE user_id = ? ";
		sql += "	AND user_name = ? ";

		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserId());
			ps.setString(2, member.getUserName());
			
			res = ps.executeUpdate();
			
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("UserDao UpdateUserType() - 끝");
		return res;
		
		
	}

//	---------------------------------유저타입 변환 끝 -----------------------------------	
	
}









