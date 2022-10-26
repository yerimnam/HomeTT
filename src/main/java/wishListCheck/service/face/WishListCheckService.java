package wishListCheck.service.face;

import java.util.List;

import wishListCheck.dto.WishListCheck;

public interface WishListCheckService {

	/**
	 * 찜 목록 전체 조회
	 * 
	 * @return - 찜 전체 조회 목록
	 */
	public List<WishListCheck> getList();
	
	
	
}
