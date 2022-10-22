package party.service.face;

import javax.servlet.http.HttpServletRequest;

import party.dto.Party;
import user.dto.Member;


public interface CreatePartyService {


	/**
	 * 생성한 파티 정보 추출
	 * 
	 * @param req - 요청 정보 객체
	 * @return Party - 생성된 파티 정보 객체
	 */
	public Party getCreateParty(HttpServletRequest req);

	
	/**
	 * 전달된 데이터로 파티 생성 처리하기
	 * 
	 * @param party - 클라이언트가 입력 후 전달된 파티방 정보
	 * @return - DB에 삽입된 파티 정보
	 */
	public Party create(Party party);


	/**
	 * 멤버 dto 가져오기
	 * @param req - 요청 정보 객체
	 * @return - 멤버 dto 데이터 가져오기
	 */
	public Member getmember(HttpServletRequest req);
	
	
}
