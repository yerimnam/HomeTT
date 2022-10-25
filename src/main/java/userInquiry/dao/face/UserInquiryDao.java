package userInquiry.dao.face;

import java.sql.Connection;

import userInquiry.dto.UserInquiry;
import userInquiry.dto.UserInquiryFile;

public interface UserInquiryDao {

	/**
	 * 시퀀스를 이용하여 다음 신고글 번호 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @return int - 다음 신고글 번호
	 */
	int selectNextBoardno(Connection conn);

	/**
	 * 신고글 입력
	 * 
	 * @param conn - DB 연결 객체
	 * @param board - 삽입될 신고글 내용
	 * @return int - INSERT 쿼리 수행 결과
	 */
	int insert(Connection conn, UserInquiry userInquiry);

	
	/**
	 * 첨부파일 삽입
	 * 
	 * @param conn - DB연결 객체
	 * @param boardFile - 첨부파일 정보
	 * @return int - INSERT 수행 결과
	 */
	int insertFile(Connection conn, UserInquiryFile userInquiryFile);

}
