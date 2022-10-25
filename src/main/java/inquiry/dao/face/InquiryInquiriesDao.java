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

	List<InquiryBoard> selectAll(Connection conn, Paging paging, int userNo);
	
	
	/**
	 * 총 글수 selecㅅ 학
	 * @param userNo 
	 * @param connection -db연결
	 * @return - 총 데이터 수 
	 */

	int selectCntAll(Connection conn);

}
