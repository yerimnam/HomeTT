package admin.cs.inquiry.dto;

import java.util.Date;

public class Inquiry {
	
	private int inquiryArticleNumber; //게시판 글 번호
	private int userNo; //회원번호
	private int adminNo; //관리자번호
	private int boardCode; //게시판코드
	private String inquiryArticleTitle; // 글 제목
	private String inquiryContent; //글 내용
	private String inquiryWriter; // 작성자
	private Date inquiryDate; //작성일
	private String answerWriter; //답변자 
	private String answerContent; //답변내용
	private Date answerDate; //답변작성일

	public Inquiry() {}
	
	public Inquiry(int inquiryArticleNumber, int userNo, int adminNo, int boardCode, String inquiryArticleTitle,
			String inquiryContent, String inquiryWriter, Date inquiryDate, String answerWriter, String answerContent,
			Date answerDate) {
		super();
		this.inquiryArticleNumber = inquiryArticleNumber;
		this.userNo = userNo;
		this.adminNo = adminNo;
		this.boardCode = boardCode;
		this.inquiryArticleTitle = inquiryArticleTitle;
		this.inquiryContent = inquiryContent;
		this.inquiryWriter = inquiryWriter;
		this.inquiryDate = inquiryDate;
		this.answerWriter = answerWriter;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
	}

	@Override
	public String toString() {
		return "Inquiry [inquiryArticleNumber=" + inquiryArticleNumber + ", userNo=" + userNo + ", adminNo=" + adminNo
				+ ", boardCode=" + boardCode + ", inquiryArticleTitle=" + inquiryArticleTitle + ", inquiryContent="
				+ inquiryContent + ", inquiryWriter=" + inquiryWriter + ", inquiryDate=" + inquiryDate
				+ ", answerWriter=" + answerWriter + ", answerContent=" + answerContent + ", answerDate=" + answerDate
				+ "]";
	}

	public int getInquiryArticleNumber() {
		return inquiryArticleNumber;
	}

	public void setInquiryArticleNumber(int inquiryArticleNumber) {
		this.inquiryArticleNumber = inquiryArticleNumber;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
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

	public String getInquiryArticleTitle() {
		return inquiryArticleTitle;
	}

	public void setInquiryArticleTitle(String inquiryArticleTitle) {
		this.inquiryArticleTitle = inquiryArticleTitle;
	}

	public String getInquiryContent() {
		return inquiryContent;
	}

	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}

	public String getInquiryWriter() {
		return inquiryWriter;
	}

	public void setInquiryWriter(String inquiryWriter) {
		this.inquiryWriter = inquiryWriter;
	}

	public Date getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	public String getAnswerWriter() {
		return answerWriter;
	}

	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}
	
}
