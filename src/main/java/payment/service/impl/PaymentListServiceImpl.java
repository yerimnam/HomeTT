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
	public Date changestart(String startDate) {

		Date start = null;

		//String ->Date로 형 변환
		try {
			start = format.parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		} 

		return start;
	}

	//형변환
	@Override
	public Date changeend(String endDate) {

		Date end = null;

		try {
			end = format.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return end;

	}
	
	
	
	@Override
	public PbPaging getPaging(HttpServletRequest req) {
		
		//총 게시글 수 
		int totalCount = paymentListDao.selectcntAll(JDBCTemplate.getConnection());
		
		//전달파라미터 curPage추출하기
		
		String param =req.getParameter("curPage");
		int curPage=0;
		if(param !=null && !"".equals(param)) {
			
			curPage = Integer.parseInt(param);
			
		}
		
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
