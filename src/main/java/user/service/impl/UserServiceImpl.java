package user.service.impl;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import user.dao.face.UserDao;
import user.dao.impl.UserDaoImpl;
import user.dto.Member;
import user.service.face.UserService;

public class UserServiceImpl implements UserService {

	//DAO 객체
	private UserDao userDao = new UserDaoImpl();

	LocalDate now = LocalDate.now();
	  
	@Override
	public Member getJoinParam(HttpServletRequest req) {
		Member member = new Member();

		member.setUserId( req.getParameter("userid") );
		member.setUserPw( req.getParameter("userpw") );
		member.setUserName( req.getParameter("username") );
		member.setUserNick( req.getParameter("usernick") );
		member.setUserEmail( req.getParameter("useremail") );
		member.setUserPhone( Integer.parseInt(req.getParameter("userphone")) );
//		member.setMasterNo( Integer.parseInt(req.getParameter("masterno")) );
		
		return member;
		
	}


	@Override
	public Member join(Member member) {
		System.out.println("UserService join() -  시작");

		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();

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

}










