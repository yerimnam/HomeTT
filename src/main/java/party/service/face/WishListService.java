package party.service.face;

import javax.servlet.http.HttpServletRequest;

import party.dto.WishList;

public interface WishListService {
	
	
	/**
	 * 전달파라미터 wishNo를 wishlist DTO객체로 저장해서 반환
	 * 
	 * @param req - 요청 정보 객체
	 * @return WishList - 전달파라미터 wishNo를 저장한 DTO 객체
	 */
	public WishList getwishNo(HttpServletRequest req);
	
	
	/**
	 * 버튼 클릭해서 입력처리 (=작성)
	 * 클릭한 게시글 DB에 저장
	 *
	 * @param req - 요청정보 객체
	 */
	public void wishinsert(HttpServletRequest req);
	

}
