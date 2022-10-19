package payment.service.face;

import member.dto.Member;
import payment.dto.Payment;

public interface PaymentService {
	
	/**
	 * 세션에서 얻은 유저 넘버로 유저 정보 가져 오기
	 * 
	 * @param userno 유저 넘버
	 * @return   조회한 유저정보 반환
	 */

	Payment getuserinfo(int userno);

}
