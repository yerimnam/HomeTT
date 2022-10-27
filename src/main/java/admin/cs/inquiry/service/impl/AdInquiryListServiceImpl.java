package admin.cs.inquiry.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.cs.inquiry.dao.face.AdInquiryListDao;
import admin.cs.inquiry.dao.impl.AdInquiryListDaoImpl;
import admin.cs.inquiry.dto.Inquiry;
import admin.cs.inquiry.service.face.AdInquiryListService;
import common.JDBCTemplate;
import util.Paging;

public class AdInquiryListServiceImpl implements AdInquiryListService {
	
private AdInquiryListDao adInquiryListDao = new AdInquiryListDaoImpl();
	
	@Override
	public List<Inquiry> getList(Paging paging) {
//		System.out.println("getList(paging) : " + paging);
		return adInquiryListDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
//		System.out.println("getList(paging) 시작");
		int totalCount = adInquiryListDao.selectCntAll(JDBCTemplate.getConnection());
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		Paging paging = new Paging(totalCount, curPage);
		
//		System.out.println("getList(paging) 끝 : " + paging);
		return paging;
	}
	
	@Override
	public Inquiry getInquiryno(HttpServletRequest req) {

		Inquiry inquiry = new Inquiry();
		
		String param = req.getParameter("inquiryArticleNumber");
		if( null != param && !"".equals(param) ) { //전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리 
			inquiry.setInquiryArticleNumber( Integer.parseInt(param) );
		}
		return inquiry;
	}
	
	@Override
	public Inquiry view(Inquiry inquiryno) {
		
		Connection conn = JDBCTemplate.getConnection();

		Inquiry inquiry = adInquiryListDao.selectInquiryByInquiryno(conn, inquiryno);
		
		return inquiry;
	}
	
	@Override
	public Paging getSearchPaging(HttpServletRequest req, String searchType, String keyword) {
		int totalCount = adInquiryListDao.selectSearchCntAll(JDBCTemplate.getConnection() ,searchType ,keyword);
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		Paging searchpaging = new Paging(totalCount, curPage);
		return searchpaging;
	}
	
	@Override
	public List<Inquiry> getSearchList(Paging paging, String searchType, String keyword) {
		return adInquiryListDao.selectSearchList(JDBCTemplate.getConnection(), paging, searchType, keyword);
	}
	
	@Override
	public void writeAnswer(HttpServletRequest req) {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();

		//게시글 정보 DTO객체
		Inquiry inquiry = new Inquiry();
		
		String param = req.getParameter("inquiryArticleNumber");
		System.out.println("param : " + param);
		if( null != param && !"".equals(param) ) { //전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리 
		inquiry.setInquiryArticleNumber( Integer.parseInt(param) );
		}
		inquiry.setAnswerWriter(req.getParameter("answer_writer"));
		inquiry.setAnswerContent(req.getParameter("answer_content"));
		
//		inquiry.setInquiryWriter( (String) req.getSession().getAttribute("userNo") );
		System.out.println("writeAnswer : " + inquiry);
		if( adInquiryListDao.updateAnswer(conn, inquiry) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}
	
	@Override
	public void delete(Inquiry inquiry) {
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 삭제
		if(adInquiryListDao.delete(conn, inquiry) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}
	
}
