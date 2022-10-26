package party.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import party.dao.face.WishListDao;
import party.dao.impl.WishListDaoImpl;
import party.dto.WishList;
import party.service.face.WishListService;


public class WishListServiceImpl implements WishListService {

	// DAO객체
	private WishListDao wishlistdao = new WishListDaoImpl();


	
	@Override
	public WishList getwishNo(HttpServletRequest req) {
		
		//전달파라미터를 저장할 객체 생성
		WishList wishlist = new WishList();
		
		//전달파라미터 boardno 추출하기
		String param = req.getParameter("wishno");
		if( null != param && !"".equals(param) ) { //전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리 
			wishlist.setWishNo(Integer.parseInt(param));
		}
		
		return wishlist;
	}

	
	
	@Override
	public void wishinsert(HttpServletRequest req) {
		
		WishList wishlist = new WishList();
		
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 번호 생성하기
		int wishno = wishlistdao.selectNextWishno(conn);
		
		//찜 번호 삽입
		wishlist.setWishNo(wishno);
		
		
		//이용자 ID 처리하기
		wishlist.setUserNo( (int) req.getSession().getAttribute("userno")); 
		
		if( wishlistdao.insert(conn, wishlist) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}
	
	


	
}

