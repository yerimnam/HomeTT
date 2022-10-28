package admin.payment.dao.face;

import java.sql.Connection;
import java.util.List;

import admin.payment.dto.Payment;
import util.Paging;

public interface AdPaymentListDao {
	
	/**
	 * 결제내역 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<Payment> - 테이블 페이징 목록 조회 결과
	 */
	public List<Payment> selectAll(Connection conn, Paging paging);
	
	/**
	 * 총 결제내역 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 * 지정된 paymentno의 결제내역 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param paymentno - 조회할 결제내역의 paymentno를 가진 DTO객체
	 * @return Payment - 조회된 결제내역의 상세정보 DTO객체
	 */
	public Payment selectPaymentByPaymentno(Connection conn, Payment paymentno);

	/**
	 * 총 결제내역 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectSearchCntAll(Connection conn, String searchType, String keyword);
	
	/**
	 * 검색한 결제내역 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param searchpaging - 페이징 정보 객체
	 * @param searchType - 검색 카테고리
	 * @param keyword - 검색어 내용
	 * @return 검색한 결제내역 목록 전달
	 */
	public List<Payment> selectSearchList(Connection conn, Paging paging, String searchType, String keyword);
	
}
