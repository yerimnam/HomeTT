package user.service.face;

import javax.servlet.http.HttpServletRequest;

import user.dto.Member;
import user.dto.MailSmsOk;

public interface UserService {
	
	//	---------------------------------회원가입 시작 -----------------------------------
	
	/**
	 * 회원가입 정보 추출하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Member - 회원가입 정보 객체
	 */
	public Member getJoinParam(HttpServletRequest req);

	
	/**
	 * 전달된 데이터를 이용해 회원가입 처리하기
	 * 
	 * @param member - 클라이언트가 입력하여 전달된 회원정보
	 * @return Member - DB에 삽입된 회원 정보 객체
	 */
	public Member join(Member member);

	
//	---------------------------------회원가입 끝 -----------------------------------
	
//	---------------------------------로그인 시작 -----------------------------------	
	
	/**
	 * 로그인 정보 추출하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Member - 로그인 정보
	 */
	public Member getLoginParam(HttpServletRequest req);


	/**
	 * 로그인 인증 처리
	 * 
	 * @param member - 로그인 정보
	 * @return boolean - true: 인증성공, false: 인증실패
	 */
	public boolean login(Member member);

	
	/**
	 * 유저 정보 가져오기
	 * 
	 * @param member - 조회할 회원 아이디를 가진 객체
	 * @return Member - 조회된 회원 정보(userid, userpw, usernick)
	 */
	public Member loginInfo(Member member);


//	--------------------------------- 로그인 끝 -----------------------------------	
	
//	--------------------------------- 아이디찾기 시작 -----------------------------------	

	/**
	 * 유저 아이디 찾아오기
	 * 
	 * @param member - 조회할 회원 아이디
	 * @return Member - 조회된 회원 정보
	 */
	public Member searchId(Member member);


	/**
	 * 랜덤 난수 이메일로 보내고 가져오기
	 * 
	 * @param req - 요청 정보 객체
	 * @return MailOk - 메일로 보낼 랜덤 난수
	 */
	public MailSmsOk sendMailRandomNum(HttpServletRequest req);


	/**
	 * 메일 인증 처리
	 * 
	 * @param req - 요청 정보 객체
	 * @return MailOk -  resultChk 정보 ( 1 : 성공, 2 : 실패 )
	 */
	public MailSmsOk MailOkChk(HttpServletRequest req);
	
	
//	--------------------------------- 아이디찾기 끝 -----------------------------------	
	
//	--------------------------------- 비밀번호찾기 시작 -----------------------------------
	
	
	/**
	 * 유저 정보 가져오기
	 * 
	 * @param member - 조회할 회원 정보
	 * @return Member - 조회된 회원 정보
	 */
	public Member searchPw(Member member);

	/**
	 * 랜덤 난수 이메일로 보내고 가져오기
	 * 
	 * @param req - 요청 정보 객체
	 * @return MailOk - 메일로 보낼 랜덤 난수
	 */
	public MailSmsOk sendSmsRandomNum(HttpServletRequest req);


	
	/**
	 * 문자 인증 처리
	 * 
	 * @param req - 요청 정보 객체
	 * @return MailOk -  resultChk 정보 ( 1 : 성공, 2 : 실패 )
	 */
	public MailSmsOk SmsOkChk(HttpServletRequest req);


	/**
	 * 전달된 userphone를 이용하여 비밀번호를 변경한다
	 * 
	 * @param member - 수정할 객체 
	 * @return Member - 수정한 멤버 정보
	 */
	public Member UpdatePw(Member member);

//	--------------------------------- 비밀번호찾기 끝 -----------------------------------

//	--------------------------------- 회원탈퇴 시작 -----------------------------------

	
	/**
	 * 유저 비밀번호 찾아오기
	 * 
	 * @param member - 조회할 회원 아이디
	 * @return Member - 조회된 회원 비밀번호
	 */
	public Member getUserPw(Member member);

	
//	--------------------------------- 회원탈퇴 끝 -----------------------------------

//	--------------------------------- 개인정보 수정 시작 -----------------------------------

	
	/**
	 * 유저 비밀번호 찾아오기
	 * 
	 * @param member - 조회할 회원 아이디
	 * @return Member - 조회된 회원 비밀번호
	 */
	public Member getTTUserPw(Member member);


	/**
	 * 회원수정 정보 추출하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Member - 회원수정 정보 객체
	 */
	public Member getEditInfo(HttpServletRequest req);


	/**
	 * 회원수정 정보를 수정하여 추출하기
	 * 
	 * @param req - 요청 세션정보 객체 member - 요청 정보 객체
	 * @return Member - 회원수정 정보를 수정한 객체
	 */
	public Member getEditInfoChange(HttpServletRequest req, Member member);


	
	/**
	 * 전달된 멤더 데이터를 이용하여 개인정보를 변경한다
	 * 
	 * @param member - 수정할 객체 
	 * @return Member - 수정한 멤버 정보
	 */
	public Member UpdateInfo(Member member);
	
	


//	--------------------------------- 개인정보 수정 끝 -----------------------------------






}
