package party.dao.face;

import java.sql.Connection;
import java.util.List;

import party.dto.Party;
import party.dto.WishList;
import util.PrPaging;

public interface WishListDao {


	
	/**
	 * 지정된 찜 게시글 조회
	 *  
	 * @param conn - DB 연결 객체
	 * @param wishno - 선택할 게시글 wishno를 가진 객체
	 * 
	 * @return WishList - 선택된 게시글의 상세정보 DTO 객체
	 */
	public WishList selectwishno(Connection conn, WishList wishno);
	
	
	/**
	 * 찜하기 (INSERT)
	 * 
	 * @param conn - DB 연결 객체
	 * @param wishlist - 삽입될 파티모집 내용
	 * @return int - INSERT 쿼리 수행 결과
	 */
	public int insert(Connection conn, WishList wishlist);
	
	
	/**
	 * 시퀀스 이용해서 다음 게시글 번호 조회하기
	 * @param conn - db 연결 객체
	 * @return int - 다음 찜목록 번호
	 */
	public int selectNextWishno (Connection conn);
	
	
	
	/**
	 * 게시글 삭제
	 * 
	 * @param conn - db연결 객체
	 * @param wishlist - 삭제될 내용
	 * @return int - DELETE 쿼리 수행 결과
	 */
	public int delete(Connection conn, WishList wishlist);
	

}
