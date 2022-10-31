package payment.service.face;





import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import payment.dto.Payment;
import util.PbPaging;

public interface PaymentListServcie {
	
	

	/**
	 * 
	 * 시작 날짜 yyyyMMdd 형식으로 변환
	 * @param startDate -입력된시작날짜
	 * @return -형식으로 변환된 날짜
	 */
	
	public Date changeDate(HttpServletRequest req, String div);
	
	
	
	
	
	/**
	 * 페이징하기
	 * @param req -요청정보 객체
	 * @return paging-페이징 계산이 완료된 객체
	 */
	
	
	public PbPaging getPaging(HttpServletRequest req, int userNo, Date start, Date end);
	
	

	/**
	 *  회원의 결제내역을 기간별로 조회하기 
	 * @param paging 
	 * @param userNo -회원번호
	 * @param start -설정한 시작날짜
	 * @param end -설정한 마지막 날짜
	 * @return 기가별 조회된 결제내역 리스트 
	 */
	
	public List<Payment> getPaymentList(PbPaging paging, int userNo,Date start, Date end);







}
