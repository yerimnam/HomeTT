package admin.payment.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.payment.dao.face.AdPaymentListDao;
import admin.payment.dao.impl.AdPaymentListDaoImpl;
import admin.payment.dto.Payment;
import admin.payment.service.face.AdPaymentListService;
import common.JDBCTemplate;
import util.Paging;

public class AdPaymentListServiceImpl implements AdPaymentListService {
	
	private static AdPaymentListDao adPaymentListDao = new AdPaymentListDaoImpl();
	
	@Override
	public List<Payment> getList(Paging paging) {
//		System.out.println("getList(paging) : " + paging);
		return adPaymentListDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		int totalCount = adPaymentListDao.selectCntAll(JDBCTemplate.getConnection());
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public Payment getPaymentno(HttpServletRequest req) {

		Payment payment = new Payment();
		
		String param = req.getParameter("reportno");
		if( null != param && !"".equals(param) ) { //전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리 
			payment.setPayNo( Integer.parseInt(param) );
		}
		
		return payment;
	}
	
	@Override
	public Payment view(Payment paymentno) {
		
		Connection conn = JDBCTemplate.getConnection();

		Payment payment = adPaymentListDao.selectPaymentByPaymentno(conn, paymentno);
		
		return payment;
	}
	
	@Override
	public Paging getSearchPaging(HttpServletRequest req, String searchType, String keyword) {
		int totalCount = adPaymentListDao.selectSearchCntAll(JDBCTemplate.getConnection() ,searchType ,keyword);
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		Paging searchpaging = new Paging(totalCount, curPage);
		return searchpaging;
	}
	
	@Override
	public List<Payment> getSearchList(Paging paging, String searchType, String keyword) {
		return adPaymentListDao.selectSearchList(JDBCTemplate.getConnection(), paging, searchType, keyword);
	}
	
}
