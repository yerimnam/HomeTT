package payment.service.face;


import party.dto.Party;
import user.dto.Member;

public interface PaymentService {
	
	/**
	 * 세션에서 얻은 유저 넘버로 유저 정보 가져 오기
	 * 
	 * @param userno 유저 넘버
	 * @return   조회한 유저정보 반환
	 */

	Member getuserinfo(int userno);
	/**
	 * 세션에서 알아온 파티 번호로 파티 정보 추출
	 * @param partyno -파티번호
	 * @return -파티 정보 반환
	 */

	Party getpartyNo(int partyno);

}
