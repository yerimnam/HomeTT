package inquiry.service.face;

import java.util.List;

import inquiry.dto.InquiryBoard;

public interface InquiryInquiriesService {
	
	
	/**
	 * 1:1 문의 게시판 화면 보여주기 (조회하기)
	 * @param userNo -유저번호
	 * @return 조회 결과 반환 
	 */

	List<InquiryBoard> getinquiry(int userNo);

}
