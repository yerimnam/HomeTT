package userInquiry.service.face;

import javax.servlet.http.HttpServletRequest;

public interface UserInquiryService {

	/**
	 * 신고 작성
	 * 입력한 신고글을 DB에 저장한다
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void write(HttpServletRequest req);

}
