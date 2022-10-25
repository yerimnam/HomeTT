package userInquiry.dto;

import java.sql.Connection;
import java.util.Date;

public class UserInquiry {

	private int reportNo;
	private int boardNo;
	private Date reportDate;
	private String reportContent;
	private String reporter;
	private String reportTarget;
	private String reportParty;
	
	public UserInquiry() {}

	public UserInquiry(int reportNo, int boardNo, Date reportDate, String reportContent, String reporter,
			String reportTarget, String reportParty) {
		super();
		this.reportNo = reportNo;
		this.boardNo = boardNo;
		this.reportDate = reportDate;
		this.reportContent = reportContent;
		this.reporter = reporter;
		this.reportTarget = reportTarget;
		this.reportParty = reportParty;
	}

	@Override
	public String toString() {
		return "UserInquiry [reportNo=" + reportNo + ", boardNo=" + boardNo + ", reportDate=" + reportDate
				+ ", reportContent=" + reportContent + ", reporter=" + reporter + ", reportTarget=" + reportTarget
				+ ", reportParty=" + reportParty + "]";
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getReportTarget() {
		return reportTarget;
	}

	public void setReportTarget(String reportTarget) {
		this.reportTarget = reportTarget;
	}

	public String getReportParty() {
		return reportParty;
	}

	public void setReportParty(String reportParty) {
		this.reportParty = reportParty;
	}

	public int selectNextBoardno(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	} 
	
	
}
