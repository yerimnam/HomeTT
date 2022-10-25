package inquiry.service.impl;

import java.util.List;

import common.JDBCTemplate;
import inquiry.dao.face.InquiryCreateDao;
import inquiry.dao.face.InquiryInquiriesDao;
import inquiry.dao.impl.InquiryInquiriesDaoImpl;
import inquiry.dto.InquiryBoard;
import inquiry.service.face.InquiryInquiriesService;

public class InquiryInquiriesServiceImpl implements InquiryInquiriesService {
	private InquiryInquiriesDao inquiryDao = new InquiryInquiriesDaoImpl();
	
	
	@Override
	public List<InquiryBoard> getinquiry(int userNo) {
		
		
		System.out.println("getinquiry");
		
		System.out.println(userNo);
		return inquiryDao.selectAll(JDBCTemplate.getConnection(),userNo);
	}

}
