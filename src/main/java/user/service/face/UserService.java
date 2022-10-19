package user.service.face;

import javax.servlet.http.HttpServletRequest;

import user.dto.Member;

public interface UserService {

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

}
