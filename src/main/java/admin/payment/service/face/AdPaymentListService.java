package admin.payment.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.payment.dto.Payment;
import util.Paging;

public interface AdPaymentListService {
	
	/**
	 * 결제내역 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Payment> - 결제내역 전체 조회 목록
	 */
	public List<Payment> getList(Paging paging);
	
	/**
	 * 결제내역 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
	/**
	 * 전달파라미터 Paymnetno를 Payment DTO로 저장하여 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return Board - 전달파라미터 Paymnetno를 저장한 DTO객체
	 */
	public Payment getPaymentno(HttpServletRequest req);
	
	/**
	 * 전달된 Paymnetno를 이용하여 결제내역을 조회한다
	 * 
	 * @param reportno - 조회할 Paymnetno를 가진 DTO객체
	 * @return Payment - 조회된 결제내역 정보
	 */
	public Payment view(Payment Paymnetno);

	/**
	 * 검색 결제내역 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 검색 결제내역 페이징 계산이 완료된 객체
	 */
	public Paging getSearchPaging(HttpServletRequest req, String searchType, String keyword);
	
	/**
	 * 검색한 결제내역 목록 조회
	 * 
	 * @param paging - 페이징 계산이 완료된 객체
	 * @param searchType - 검색 카테고리
	 * @param keyword - 검색어 내용
	 * @return 검색한 결제내역 목록 전달
	 */
	public List<Payment> getSearchList(Paging paging, String searchType, String keyword);
	
}
