package report.dto;

import java.util.Date;

public class Report {
	
	private int reportNo;
	private int boardCano;
	private Date reportDate;
	private String reportContent;
	private String reporter;
	private String reportTarget;
	private String reportParty;
	
	public Report() {	}

	public Report(int reportNo, int boardCano, Date reportDate, String reportContent, String reporter,
			String reportTarget, String reportParty) {
		super();
		this.reportNo = reportNo;
		this.boardCano = boardCano;
		this.reportDate = reportDate;
		this.reportContent = reportContent;
		this.reporter = reporter;
		this.reportTarget = reportTarget;
		this.reportParty = reportParty;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", boardCano=" + boardCano + ", reportDate=" + reportDate
				+ ", reportContent=" + reportContent + ", reporter=" + reporter + ", reportTarget=" + reportTarget
				+ ", reportParty=" + reportParty + "]";
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public int getBoardCano() {
		return boardCano;
	}

	public void setBoardCano(int boardCano) {
		this.boardCano = boardCano;
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

	
	
	
}
