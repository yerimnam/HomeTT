package user.service.face;

import javax.servlet.http.HttpServletRequest;

import user.dto.Member;

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

//	---------------------------------로그인 끝 -----------------------------------	
	
}
