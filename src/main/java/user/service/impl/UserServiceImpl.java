package user.service.impl;

import java.sql.Connection;
import java.util.HashMap;
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

import org.json.simple.JSONObject;

import common.JDBCTemplate;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import user.dao.face.UserDao;
import user.dao.impl.UserDaoImpl;
import user.dto.MailSmsOk;
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

		System.out.println("MemberService getLoginParam() -  시작");
		
		Member member = new Member();

		member.setUserId( req.getParameter("id") );
		member.setUserPw( req.getParameter("pw") );

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
	public MailSmsOk sendMailRandomNum(HttpServletRequest req) {
		
		MailSmsOk RanNum = new MailSmsOk();
		
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
	public MailSmsOk MailOkChk(HttpServletRequest req) {
		
		MailSmsOk mailOk = new MailSmsOk();
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
	
	
//	--------------------------------- 아이디찾기 끝 -----------------------------------

//	--------------------------------- 비밀번호찾기 시작 -----------------------------------
	
	@Override
	public Member searchPw(Member member) {
		System.out.println("MemberService searchPw() -  시작");
		return userDao.getIdNamePhone(conn, member);
		
	}
	
	
	@Override
	public MailSmsOk sendSmsRandomNum(HttpServletRequest req) {

	Member member = new Member();
	MailSmsOk RanNum = new MailSmsOk();
	HttpSession session = req.getSession();
	
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
	
	 RanNum.setRanNum( resultNum );
	
	String api_key = "NCSJRBFEKEKSCM0W";
    String api_secret = "M2RBGRE1LFLGGNZWUAW4MNBNCMVRZH7Y";
    net.nurigo.java_sdk.api.Message coolsms = new net.nurigo.java_sdk.api.Message(api_key, api_secret);

    // 4 params(to, from, type, text) are mandatory. must be filled
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to", "0" + session.getAttribute("userphone"));	// 수신전화번호
    params.put("from", "01093425749");	// 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
    params.put("type", "SMS");
    params.put("text", "HomeTT 인증번호 [" + resultNum +"]을 입력해주세요.");
    params.put("app_version", "test app 1.2"); // application name and version

    try {
      JSONObject obj = (JSONObject) coolsms.send(params);
      System.out.println(obj.toString());
    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
    }
    return RanNum;
	
	} 
	
	
	@Override
	public MailSmsOk SmsOkChk(HttpServletRequest req) {
		
		MailSmsOk mailOk = new MailSmsOk();
		HttpSession session = req.getSession();
		
//		mailOk.setInputOk( req.getParameter("mailOk") );
		
		//인증번호 작성한거 확인 잘나오는지 확인
		System.out.println("MemberService login() -   InputOk : " + req.getParameter("smsOk") );
		System.out.println("MemberService login() -   RanNum : " + session.getAttribute("rannum") );
		
		
		if( !session.getAttribute("rannum").equals(req.getParameter("smsOk")) ) {
//			req.getRequestDispatcher("/WEB-INF/member/searchIdOk.jsp").forward(req, resp);
			System.out.println("둘이 같지 않을때");
			
			return null;
			
		} else {
			System.out.println("둘이 같을때");
			
			mailOk.setResultChk("1");
			return mailOk ;
		}
		
	}
	
	
	@Override
	public Member UpdatePw(Member member) {
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
				
		//비밀번호 변경
		if( userDao.UpdatePwDao(conn, member) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
				
		//조회된 게시글 리턴
		return member;
	}
	
	 
//	--------------------------------- 비밀번호찾기 끝 -----------------------------------

//	--------------------------------- 회원탈퇴 시작 -----------------------------------


	@Override
	public Member getUserPw(Member member) {
		System.out.println("UserService getUserPw() -  시작");

		//파라미터값인 비밀번호를 userpw에 저장
		String userpw = member.getUserPw();
		System.out.println("UserService join() - userpw : " + userpw);
		
		
		//테이블에 있는 pw를 userPw에 저장
		Member result = userDao.selectUserPw(conn, member);
		
		System.out.println("UserService getUserPw() - result.getUserPw() : " + result.getUserPw());
		
		member.setUserPw( result.getUserPw() );
		
		//완성된 member객체를 DB에 삽입
		userDao.deleteUserInfo(conn, member);

		//결과 처리 - 트랜잭션 관리
		if( userpw.equals(result.getUserPw()) ) { // DB삽입 성공
			JDBCTemplate.commit(conn);
			return member;

		} else { // DB삽입 실패
			JDBCTemplate.rollback(conn);
			
			return null;
		}
//		return member;
	}
	


//	--------------------------------- 회원탈퇴 끝 -----------------------------------


}



