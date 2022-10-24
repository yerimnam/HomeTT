package report.service.face;

import javax.servlet.http.HttpServletRequest;

public interface MemberReportService {

	
	/**
	 * 신고글 작성
	 * 입력한 게시글을 DB에 저장함
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void write(HttpServletRequest req);

}
