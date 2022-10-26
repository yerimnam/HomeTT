package admin.login.service.face;

import javax.servlet.http.HttpServletRequest;

import admin.login.dto.Admin;

public interface AdminLoginService {

	/**
	 * 관리자로그인 정보 추출하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Member - 로그인 정보
	 */
	public Admin getLoginParam(HttpServletRequest req);

	
	/**
	 * 로그인 인증 처리
	 * 
	 * @param member - 로그인 정보
	 * @return boolean - true: 인증성공, false: 인증실패
	 */
	public boolean login(Admin admin);


	/**
	 * 유저 정보 가져오기
	 * 
	 * @param member - 조회할 회원 아이디를 가진 객체
	 * @return Member - 조회된 회원 정보(adminid, adminpw, adminno)
	 */
	public Admin loginInfo(Admin admin);

}
