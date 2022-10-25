package user.dao.face;

import java.sql.Connection;
import java.sql.Date;

import user.dto.Member;

public interface UserDao {
 
//	---------------------------------회원가입 시작 -----------------------------------
	
	/**
	 * member_seq의 nextuserno을 조회한다
	 * 
	 * @param conn - DB연결 객체
	 * @return - userno로 사용될 member_seq의 nextuserno
	 */
	public int selectNextUserno(Connection conn);

	
	/**
	 * 전달된 파라미터 값을 테이블에 삽입한다
	 * 
	 * @param conn  - DB 연결 객체
	 * @param member - 테이블에 삽입할 정보 객체
	 * @return insert 수행 결과 ( 0 실패, 1 삽입 성공)
	 */
	public int insert(Connection conn, Member member);

//	---------------------------------회원가입 끝 -----------------------------------
	
//	---------------------------------로그인 시작 -----------------------------------
	
	/**
	 * userid와 userpw를 동시에 만족하는 회원의 수를 조회한다
	 * 	-> 로그인 인증값으로 사용한다
	 * 
	 * @param conn - DB연결 객체
	 * @param member - 조회할 회원의 정보
	 * @return int - 0: 존재하지 않는 회원, 1: 존재하는 회원
	 */
	public int selectLoginIdPw(Connection conn, Member member);


	/**
	 * userid를 이용해 회원정보 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @param member - 조회할 userid를 가진 객체
	 * @return Member - 조회된 회원 정보
	 */
	public Member selectLoginInfo(Connection conn, Member member);



//	---------------------------------로그인 끝 -----------------------------------
		
//	--------------------------------- 아이디 찾기 시작 -----------------------------------
	
	/**
	 * 
	 * username, useremail을 이용해 id알아내기
	 * 
	 * @param conn - DB연결 객체
	 * @param member - 조회할 name, email 가진 객체
	 * @return Member - 조회된 id
	 */
	public Member getMemberId(Connection conn, Member member);

	
//	--------------------------------- 아이디 찾기 끝 -----------------------------------

//	--------------------------------- 비밀번호 찾기 시작 -----------------------------------
	
	/**
	 * userid, username, userphone를 이용해 회원정보 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @param member - 조회할 userid를 가진 객체
	 * @return Member - 조회된 회원 정보
	 */
	public Member getIdNamePhone(Connection conn, Member member);


	/**
	 * 조회된 회원정보에 userphone 변경하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param member - 조회할 유저정보의 userphone를 가진 DTO객체
	 * @return int - UPDATE쿼리 수행 결과
	 */
	public int UpdatePwDao(Connection conn, Member member);

//	--------------------------------- 비밀번호 찾기 끝 -----------------------------------
	
//	--------------------------------- 회원탈퇴 시작 -----------------------------------
	
	
	/**
	 * 세션에있는 userId로 member의 userPw을 조회한다
	 * 
	 * @param conn - DB연결 객체
	 * @return userpw - userpw로 사용될 member의 pw
	 */
	public Member selectUserPw(Connection conn, Member member);


	/**
	 * 전달된 데이터를 통해 userinfo를 삭제한다
	 * 
	 * @param conn  - DB 연결 객체
	 * @param member - 테이블에서 삭제할 정보 객체
	 */
	public int deleteUserInfo(Connection conn, Member member);
	
	
	
//	--------------------------------- 회원탈퇴 끝 -----------------------------------
	

	
	
	
}










