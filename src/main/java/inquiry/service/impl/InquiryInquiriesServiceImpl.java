package inquiry.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import inquiry.dao.face.InquiryCreateDao;
import inquiry.dao.face.InquiryInquiriesDao;
import inquiry.dao.impl.InquiryInquiriesDaoImpl;
import inquiry.dto.InquiryBoard;
import inquiry.service.face.InquiryInquiriesService;
import util.Paging;

public class InquiryInquiriesServiceImpl implements InquiryInquiriesService {
	private InquiryInquiriesDao inquiryDao = new InquiryInquiriesDaoImpl();

	
	@Override
	public Paging getPaging(HttpServletRequest req) {

		
		//총게시글 수 
		int totalCount = inquiryDao.selectCntAll(JDBCTemplate.getConnection());
		
		//전달파라미터 curpage추출하기
		
		//전달파라미터 curPage추출하기
		
		String param =req.getParameter("curPage");
		int curPage=0;
		if(param !=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		System.out.println("getPaging: " + curPage);
		
		//페이지 객체 생성
		Paging paging = new Paging(totalCount,curPage);
		
		return paging;
	}
	
	@Override
	public List<InquiryBoard> getinquiry(int userNo, Paging paging) {
		
		
		System.out.println("getinquiry");
		
		System.out.println(userNo);
		return inquiryDao.selectAll(JDBCTemplate.getConnection(),paging,userNo);
	}
	

}
