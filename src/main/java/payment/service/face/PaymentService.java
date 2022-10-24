package payment.service.face;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import party.dto.Party;
import payment.dto.Payment;
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
	
	
	/**
	 * ajax가 전달한 파라미터 추출하기
	 * @param req -파라미터
	 * @return -전달한 정보 반환 
	 */
//	List<Payment> getData(HttpServletRequest req);

	
	
	
	Payment getParam(HttpServletRequest req);
	
	/**
	 * 전달한 정보로 insert하기 
	 * @param req -파라미터
	 * @return -저장된 payment dto 정보 
	 */
	
	Payment setPayment(Payment returnData);
	
	/**
	 * 
	 * 인서트 된 결과 조회해오기
	 * @param payinsert -인서트 된 결과
	 * @return
	 */
	
	Payment getresult(Payment payinsert);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
