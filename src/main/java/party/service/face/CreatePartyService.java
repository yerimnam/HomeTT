package party.service.face;

import javax.servlet.http.HttpServletRequest;

import party.dto.Party;
import user.dto.Member;


public interface CreatePartyService {


//	/**
//	 * 생성한 파티 정보 추출
//	 * 
//	 * @param req - 요청 정보 객체
//	 * @return Party - 생성된 파티 정보 객체
//	 */
//	public Party getCreateParty(HttpServletRequest req);

	
	/**
	 * 게시글 작성
	 * 입력한 게시글 db에 저장해서 파티 생성 처리하기
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void create(HttpServletRequest req);


	/**
	 * 세션에서 얻은 유저 넘버로 유저 정보 가져 오기
	 * 
	 * @param userno 유저 넘버
	 * @return String  조회한 유저정보 반환
	 */
	public Member getuserinfo(int userno);


	Party getCreateParty(HttpServletRequest req);
	
	
}
