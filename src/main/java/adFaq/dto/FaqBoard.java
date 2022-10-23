package adFaq.dto;

import java.sql.Date;

public class FaqBoard {

	
	private int faqArticlenumber;
	private int adminNo;
	private int boardCode;
	private String faqArticletitle;
	private String faqContent;
	private String faqWriter;
	private Date faqDate;
	private int hit;
	
	
	public FaqBoard() {	}

	
	

	public FaqBoard(int faqArticlenumber, int adminNo, int boardCode, String faqArticletitle, String faqContent,
			String faqWriter, Date faqDate, int hit) {
		super();
		this.faqArticlenumber = faqArticlenumber;
		this.adminNo = adminNo;
		this.boardCode = boardCode;
		this.faqArticletitle = faqArticletitle;
		this.faqContent = faqContent;
		this.faqWriter = faqWriter;
		this.faqDate = faqDate;
		this.hit = hit;
	}




	@Override
	public String toString() {
		return "FaqBoard [faqArticlenumber=" + faqArticlenumber + ", adminNo=" + adminNo + ", boardCode=" + boardCode
				+ ", faqArticletitle=" + faqArticletitle + ", faqContent=" + faqContent + ", faqWriter=" + faqWriter
				+ ", faqDate=" + faqDate + ", hit=" + hit + "]";
	}


	public int getFaqArticlenumber() {
		return faqArticlenumber;
	}


	public void setFaqArticlenumber(int faqArticlenumber) {
		this.faqArticlenumber = faqArticlenumber;
	}


	public int getAdminNo() {
		return adminNo;
	}


	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}


	public int getBoardCode() {
		return boardCode;
	}


	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}


	public String getFaqArticletitle() {
		return faqArticletitle;
	}


	public void setFaqArticletitle(String faqArticletitle) {
		this.faqArticletitle = faqArticletitle;
	}


	public String getFaqContent() {
		return faqContent;
	}


	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}


	public String getFaqWriter() {
		return faqWriter;
	}


	public void setFaqWriter(String faqWriter) {
		this.faqWriter = faqWriter;
	}


	public Date getFaqDate() {
		return faqDate;
	}


	public void setFaqDate(Date faqDate) {
		this.faqDate = faqDate;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}

	
	
}
