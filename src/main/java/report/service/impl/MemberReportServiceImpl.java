package report.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import report.dao.face.MemberReportDao;
import report.dao.impl.MemberReportDaoImpl;
import report.dto.Report;
import report.service.face.MemberReportService;

public class MemberReportServiceImpl implements MemberReportService {

	//DAO 객체
	private MemberReportDao memberReportDao = new MemberReportDaoImpl();
	
	
	@Override
	public Report getReport(HttpServletRequest req) {
		
		Report report = new Report();
		
		report.setBoardCano(0);
		report.setReportContent( req.getParameter("reportcontent"));
		report.setReportDate(null);
		report.setReporter(req.getParameter("reporter"));
		report.setReportParty(req.getParameter("partyname"));
		report.setReportTarget(req.getParameter("reporttarget"));
		
		return null;
	}
	
	
	
	@Override
	public void write(HttpServletRequest req) {
		
		//신고 dto 객체
		Report report = new Report();
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 번호 생성
		int reportno = memberReportDao.selectNextReportno(conn);
	
		//게시글 번호 삽입
		report.setReportNo(reportno);

		
		//작성자 Id 값 가져오기
		report.setReporter( (String) req.getSession().getAttribute("userid") );
		
		if( memberReportDao.insert(conn, report) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		
		
	}



}
