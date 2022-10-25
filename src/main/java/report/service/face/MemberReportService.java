package report.service.face;

import javax.servlet.http.HttpServletRequest;

import report.dto.Report;


public interface MemberReportService {

	
	/**
	 * 작성된 신고 정보 추출
	 * 
	 * @param req - 요청 정보 객체
	 * @return Report - 작성된 정보 객체
	 */
	public Report getReport (HttpServletRequest req);
	
	
	
	
	/**
	 * 신고글 작성
	 * 입력한 게시글을 DB에 저장함
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void write(HttpServletRequest req);
	
	
	
	

}
