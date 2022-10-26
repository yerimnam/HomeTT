package inquiry.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import inquiry.dao.face.InquiryInquiriesDao;
import inquiry.dao.impl.InquiryInquiriesDaoImpl;
import inquiry.dto.InquiryBoard;
import inquiry.service.face.InquiryInquiriesService;
import util.Paging;

public class InquiryInquiriesServiceImpl implements InquiryInquiriesService {
	private InquiryInquiriesDao inquiryDao = new InquiryInquiriesDaoImpl();

	
	@Override
	public Paging getPaging(HttpServletRequest req,int userNo) {

		
		//총게시글 수 
		int totalCount = inquiryDao.selectCntAll(JDBCTemplate.getConnection(),userNo);
		
		//전달파라미터 curpage추출하기
		
		//전달파라미터 curPage추출하기
		
		String param =req.getParameter("curPage");
		int curPage=0;
		if(param !=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//페이지 객체 생성
		Paging paging = new Paging(totalCount,curPage);
		
		return paging;
	}
	
	
	@Override
	public List<InquiryBoard> getinquiry(int userNo, Paging paging) {
		
		
		System.out.println("getinquiry");
		
		return inquiryDao.selectAll(JDBCTemplate.getConnection(),paging,userNo);
	}
	

	
	@Override
	public InquiryBoard getTitle(HttpServletRequest req) {
		//전달파라미터를 저장할 객체 생성
		InquiryBoard inquiryBoard = new InquiryBoard();
		
		
		//요청정보에서 전달한 파라미터 추출
		String param = req.getParameter("inquiryTitle");
		
		if(param != null && !"".equals(param)) {
			inquiryBoard.setInquiryArticleTitle(param);
			
			
		}
		
		
		return inquiryBoard;
		
	}
	
	
	
	@Override
	public InquiryBoard getDetail(int userNo, InquiryBoard inquiryTitle) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		InquiryBoard inquiryBoard = inquiryDao.selectDetail(conn,userNo,inquiryTitle);
		System.out.println("문의글 상세");
		return inquiryBoard;
	}
	
	
	@Override
	public InquiryBoard getparam(HttpServletRequest req) {
		System.out.println("getparam 시작");
		InquiryBoard inquiryBoard = new InquiryBoard();
		
		inquiryBoard.setInquiryArticleTitle(req.getParameter("inquiryTitle")); //글제목
		inquiryBoard.setInquiryContent(req.getParameter("content"));// 글 본문 
		
		System.out.println("getparam 끝");
		return inquiryBoard;
		
		
	}
	
	@Override
	public InquiryBoard setInquiry(InquiryBoard param, int userNo) {
		System.out.println("setInquiry start");
		
		
		
		Connection conn = JDBCTemplate.getConnection();
		
		//DTO 정보를 DB에 저장
		int inquiryInsert = inquiryDao.insertinQuiry(conn,param,userNo);
		
		if(inquiryInsert>0) {
			
			System.out.println("inquiry insert 성공");
			JDBCTemplate.commit(conn);
			return param;
		} else {//DB 삽입 실패
			System.out.println("iuquiry insert 실패");
			JDBCTemplate.rollback(conn);
			
		}
		
		System.out.println("setInquiry end");
		return null;
	}
}
