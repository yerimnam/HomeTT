package user.service.impl;

import java.sql.Connection;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.JDBCTemplate;
import user.dao.face.UserDao;
import user.dao.impl.UserDaoImpl;
import user.dto.Member;
import user.dto.MailOk;
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

		System.out.println("MemberService getLoginParam() -  시작");
		
		Member member = new Member();

		member.setUserId( req.getParameter("userid") );
		member.setUserPw( req.getParameter("userpw") );

		System.out.println("MemberService getLoginParam() -  끝");
		return member;

	}


	@Override
	public boolean login(Member member) {

		System.out.println("MemberService login() -  시작");
		
		//로그인 인증 성공
		if( userDao.selectLoginIdPw(conn, member) > 0 ) {
			return true;
		}

		System.out.println("MemberService login() -  끝");
		//로그인 인증 실패
		return false;
		
		
	}
	
	
	@Override
	public Member loginInfo(Member member) {
		return userDao.selectLoginInfo(conn, member);
	}



	//	---------------------------------로그인 끝 -----------------------------------

	//	--------------------------------- 아이디찾기 시작 -----------------------------------


	@Override
	public Member searchId(Member member) {
		System.out.println("MemberService searchId() -  시작");
		return userDao.getMemberId(conn, member);
	}

	
	
	@Override
	public MailOk sendMailRandomNum(HttpServletRequest req) {
		
		MailOk RanNum = new MailOk();
		
		Random random = new Random();		//랜덤 함수 선언
		int createNum = 0;  			//1자리 난수
		String ranNum = ""; 			//1자리 난수 형변환 변수
        	int letter    = 6;			//난수 자릿수:6
		String resultNum = "";  		//결과 난수
		
		for (int i=0; i<letter; i++) { 
            		
			createNum = random.nextInt(9);		//0부터 9까지 올 수 있는 1자리 난수 생성
			ranNum =  Integer.toString(createNum);  //1자리 난수를 String으로 형변환
			resultNum += ranNum;			//생성된 난수(문자열)을 원하는 수(letter)만큼 더하며 나열
	}	
		
		
		String host = "smtp.naver.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
	        String user = "wheodus628@naver.com"; // 패스워드
	        String password = "aaa@4862795";

	        // SMTP 서버 정보를 설정한다.
	        Properties props = new Properties();
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", 587);
	        props.put("mail.smtp.auth", "true");
	        
	        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(user, password);
	            }
	        });
	        
	        try {
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(user));
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress("wheodus628@naver.com"));

	            // 메일 제목
	            message.setSubject("HomeTT 아디디찾기 인증메일입니다");

	            RanNum.setRanNum( resultNum );
	            
	            // 메일 내용
	            message.setText( req.getParameter("name") + "님의 인증번호는 " + resultNum + "입니다");

	            // send the message
	            Transport.send(message);
	            System.out.println("Success Message Send");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	        
	        return RanNum;
	}
	
	
	
	@Override
	public MailOk MailOkChk(HttpServletRequest req) {
		
		MailOk mailOk = new MailOk();
		HttpSession session = req.getSession();
		
//		mailOk.setInputOk( req.getParameter("mailOk") );
		
		//인증번호 작성한거 확인 잘나오는지 확인
		System.out.println("MemberService login() -   InputOk : " + req.getParameter("mailOk") );
		System.out.println("MemberService login() -   RanNum : " + session.getAttribute("rannum") );
		
		// 아이디 찾기 service
		
		if( !session.getAttribute("rannum").equals(req.getParameter("mailOk")) ) {
//			req.getRequestDispatcher("/WEB-INF/member/searchIdOk.jsp").forward(req, resp);
			System.out.println("둘이 같지 않을때");
			
			return null;
			
		} else {
			System.out.println("둘이 같을때");
			
			mailOk.setResultChk("1");
			return mailOk ;
		}
		
		
	}

}









