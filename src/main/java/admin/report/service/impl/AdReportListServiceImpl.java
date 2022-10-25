package admin.report.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.report.dao.face.AdReportListDao;
import admin.report.dao.impl.AdReportListDaoImpl;
import admin.report.dto.Report;
import admin.report.service.face.AdReportListService;
import common.JDBCTemplate;
import util.Paging;

public class AdReportListServiceImpl implements AdReportListService {
	
	private AdReportListDao adReportListDao = new AdReportListDaoImpl();
	
	@Override
	public List<Report> getList(Paging paging) {
		System.out.println("getList(paging) : " + paging);
		return adReportListDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		int totalCount = adReportListDao.selectCntAll(JDBCTemplate.getConnection());
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public List<Report> getSearchList(Paging paging, String searchType, String keyword) {
		System.out.println("getSearchList() - 시작");
		System.out.println("searchType" + searchType);
		System.out.println("keyword" + keyword);
		return adReportListDao.selectSearchList(JDBCTemplate.getConnection(), paging, searchType, keyword);
	}
	
	@Override
	public Report getReportno(HttpServletRequest req) {

		Report report = new Report();
		
		String param = req.getParameter("reportno");
		if( null != param && !"".equals(param) ) { //전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리 
			report.setReportNo( Integer.parseInt(param) );
		}
		
		return report;
	}
	
	@Override
	public Report view(Report reportno) {
		
		Connection conn = JDBCTemplate.getConnection();

		Report report = adReportListDao.selectReportByReportno(conn, reportno);
		
		return report;
	}
	
}
