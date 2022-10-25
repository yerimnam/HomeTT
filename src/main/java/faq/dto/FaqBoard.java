package faq.dto;

import java.sql.Date;

public class FaqBoard {

	
	private int faqArticlenumber;		//FAQ_ARTICLENUMBER		글 번호
	private int adminNo;				//ADMIN_NO				관리자 번호
	private int boardCode;				//BOARD_CODE			게시판 코드
	private String faqArticletitle;		//FAQ_ARTICLETITLE		글 제목
	private String faqContent;			//FAQ_CONTENT			글 내용
	private String faqWriter;			//FAQ_WRITER			작성자
	private Date faqDate;				//FAQ_DATE				작성일
	private int hit;					//HIT					조회수
	
	


	
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
