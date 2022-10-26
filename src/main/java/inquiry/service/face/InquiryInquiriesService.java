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
	 * @param userNo 
	 * @return
	 */

	Paging getPaging(HttpServletRequest req, int userNo);


	/**
	 * 
	 * @param req 요청 파라미터 -글제목
	 * @return 조회된 글제목 
	 */
	InquiryBoard getTitle(HttpServletRequest req);

	
	/**
	 * 클릭한 글 제목의 상세 내용 
	 * @param userNo 
	 * @param inquiryView -글 제목 파라미터 
	 * @return -글제목의 상세 내용 
	 */

	InquiryBoard getDetail(int userNo, InquiryBoard inquiryTitle);

	
	/**
	 * 
	 * 회원이 작성한 글의 파라미터 얻어오기
	 * @param req 
	 * @return 작성한 글 파라미터 
	 */

	InquiryBoard getparam(HttpServletRequest req);

	
	/**
	 * 문의글 insrty하기
	 * @param param -파라미터(글제목,글본문)
	 * @param userNo -유저번호
	 * @return 문의글 저장
	 */

	InquiryBoard setInquiry(InquiryBoard param, int userNo);



}
