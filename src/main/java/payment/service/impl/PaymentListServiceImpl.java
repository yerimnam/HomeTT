package payment.service.impl;





import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import payment.dao.face.PaymentListDao;
import payment.dao.impl.PaymentListDaoImple;
import payment.dto.Payment;
import payment.service.face.PaymentListServcie;
import util.PbPaging;

public class PaymentListServiceImpl implements PaymentListServcie {

	private static PaymentListDao paymentListDao = new PaymentListDaoImple();


	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	
	
	
	
	
	
	
	//형변환
	@Override
	public Date changeDate(HttpServletRequest req, String div) {
		
		String dateStr = null;
		if( "start".equals(div) ) {
			dateStr = req.getParameter("startdate");
		}
		if( "end".equals(div) ) {
			dateStr = req.getParameter("enddate");
		}
		if( dateStr == null ) {
			return null;
		}
		
		//String ->Date로 형 변환
		Date date = null;
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		return date;
	}
	
	
	
	@Override
	public PbPaging getPaging(HttpServletRequest req, int userNo, Date start, Date end) {
		
		//총 게시글 수 
		int totalCount = paymentListDao.selectcntAll(JDBCTemplate.getConnection(), userNo, start, end);
		System.out.println("getPaging totalCount: " + totalCount);
		
		//전달파라미터 curPage추출하기
		
		String param =req.getParameter("curPage");
		int curPage=0;
		if(param !=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		System.out.println("getPaging: " + curPage);
		
		//페이지 객체 생성
		PbPaging paging = new PbPaging(totalCount,curPage);
		
		return paging;
	}
	



@Override
	public List<Payment> getPaymentList(PbPaging paging, int userNo, Date start, Date end) {
	System.out.println("getPaymentList -start");
		System.out.println("getPaymentList-end");
		return paymentListDao.selectPayList(JDBCTemplate.getConnection(),paging,userNo,start,end);
	}	

}
