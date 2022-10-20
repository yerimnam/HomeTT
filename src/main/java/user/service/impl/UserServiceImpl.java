package user.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import user.dao.face.UserDao;
import user.dao.impl.UserDaoImpl;
import user.dto.Member;
import user.service.face.UserService;

public class UserServiceImpl implements UserService {

	//DAO 객체
	private UserDao userDao = new UserDaoImpl();

	//DB연결 객체
	Connection conn = JDBCTemplate.getConnection();

	//	---------------------------------회원가입 시작 -----------------------------------

	@Override
	public Member getJoinParam(HttpServletRequest req) {
		Member member = new Member();

		member.setUserId( req.getParameter("userid") );
		member.setUserPw( req.getParameter("userpw") );
		member.setUserName( req.getParameter("username") );
		member.setUserNick( req.getParameter("usernick") );
		member.setUserEmail( req.getParameter("useremail") );
		member.setUserPhone( Integer.parseInt(req.getParameter("userphone")) );

		return member;

	}


	@Override
	public Member join(Member member) {
		System.out.println("UserService join() -  시작");
		

		//member_seq의 nextval을 조회한다
		int next = userDao.selectNextUserno(conn);
		System.out.println("UserService join() - next : " + next);

		//조회된 nextval을 member객체에 저장한다
		member.setUserNo(next);
		System.out.println("MemberService join() - next : " + member);


		//완성된 member객체를 DB에 삽입
		int result = userDao.insert(conn, member);

		System.out.println("UserService join() -  끝");

		//결과 처리 - 트랜잭션 관리
		if( result > 0 ) { // DB삽입 성공
			JDBCTemplate.commit(conn);
			return member;

		} else { // DB삽입 실패
			JDBCTemplate.rollback(conn);
			return null;
		}
	}


	//	---------------------------------회원가입 끝 -----------------------------------

	//	---------------------------------로그인 시작 -----------------------------------

	@Override
	public Member getLoginParam(HttpServletRequest req) {

		System.out.println("getLoginParam join() -  시작");
		
		Member member = new Member();

		member.setUserId( req.getParameter("userid") );
		member.setUserPw( req.getParameter("userpw") );

		System.out.println("getLoginParam join() -  끝");
		return member;

	}


	@Override
	public boolean login(Member member) {

		System.out.println("getLoginParam login() -  시작");
		
		//로그인 인증 성공
		if( userDao.selectLoginIdPw(conn, member) > 0 ) {
			return true;
		}

		System.out.println("getLoginParam login() -  끝");
		//로그인 인증 실패
		return false;
		
		
	}
	
	
	@Override
	public Member loginInfo(Member member) {
		return userDao.selectLoginInfo(conn, member);
	}



	//	---------------------------------로그인 끝 -----------------------------------



}










