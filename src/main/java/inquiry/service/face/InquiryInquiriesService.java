package inquiry.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import inquiry.dto.InquiryBoard;
import util.Paging;

public interface InquiryInquiriesService {
	
	
	/**
	 * 1:1 문의 게시판 화면 보여주기 (조회하기)
	 * @param userNo -유저번호
	 * @param paging -패에징 객체 
	 * @return 조회 결과 반환 
	 */

	List<InquiryBoard> getinquiry(int userNo, Paging paging);
	
	
	/**
	 *  현재 페이징 객체 계산하기 
	 * @param req 파라미터
	 * @param userNo 
	 * @return
	 */

	Paging getPaging(HttpServletRequest req);

}
