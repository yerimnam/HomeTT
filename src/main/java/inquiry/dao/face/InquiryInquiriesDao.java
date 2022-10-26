package inquiry.dao.face;

import java.sql.Connection;
import java.util.List;

import inquiry.dto.InquiryBoard;
import util.Paging;

public interface InquiryInquiriesDao {
	
	
	
	/**
	 * 
	 * 1:1문의 게시판 내용 조회하기
	 * @param paging 
	 * @param connection -DB연결
	 * @param userNo - 회원 번호 
	 * @return 조회된 결과 반환 
	 */

	public List<InquiryBoard> selectAll(Connection conn, Paging paging, int userNo);
	
	
	/**
	 * 총 글수 selecㅅ 학
	 * @param userNo 
	 * @param userNo 
	 * @param connection -db연결
	 * @return - 총 데이터 수 
	 */

	public int selectCntAll(Connection conn, int userNo);


	/**
	 * 게시판 상세 글 내용
	 * @param conn -DB 연결
	 * @param userNo 
	 * @param inquiryTitle -글제목 파라미터 추출
	 * @return 상세 글내용 반환
	 */
	public InquiryBoard selectDetail(Connection conn, int userNo, InquiryBoard inquiryTitle);


	
	/**
	 * 문의글 DB에 저장하기
	 * @param conn -DB 저장
	 * @param param -글제목 글내용을 담은 DTO 정보
	 * @param userNo -유저번호
	 * @return  문의글 DB 저장 결과 
	 */
	public int insertinQuiry(Connection conn, InquiryBoard param, int userNo);

	
	/**
	 * 수정할 내용 가져와서 먼저 보여주기
	 * @param connection -DB 연결
	 * @param inquiryNo-1:1문의하기 글번호
	 * @return 가져온 내용 
	 */

	public InquiryBoard selectcontent(Connection conn, InquiryBoard inquiryNo);


	
	/**
	 * 문의사항 수정
	 * 
	 * @param conn -DB 연결
	 * @param inquiryNum - 글번호 파람피터 정보
	 * @return 
	 */
	public int updateDo(Connection conn, InquiryBoard inquiryNum);


	/**
	 * 문의사항 삭제
	 * @param conn -DB 연결
	 * @param inquiryNo -문의사항 글 번호
	 * @return
	 */
	public int deleteDo(Connection conn, InquiryBoard inquiryNo);

}
