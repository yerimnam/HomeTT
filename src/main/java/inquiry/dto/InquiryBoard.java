package inquiry.dto;

import java.util.Date;

public class InquiryBoard {
	
    private int inquiryArticleNumber ;
    private int userNo;
    private int adminNo;
    private int boardCode;
    private String inquiryArticleTitle;
    private String inquiryContent;
    private String inquiryWriter;
    private Date inquiryDate;
    private String answerWriter;
    private String answercontent;
    private Date answerdate;
    private String userNick;
    
    
    public InquiryBoard() 	{}


	public InquiryBoard(int inquiryArticleNumber, int userNo, int adminNo, int boardCode, String inquiryArticleTitle,
			String inquiryContent, String inquiryWriter, Date inquiryDate, String answerWriter, String answercontent,
			Date answerdate, String userNick) {
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
		this.answercontent = answercontent;
		this.answerdate = answerdate;
		this.userNick = userNick;
	}


	@Override
	public String toString() {
		return "InquiryBoard [inquiryArticleNumber=" + inquiryArticleNumber + ", userNo=" + userNo + ", adminNo="
				+ adminNo + ", boardCode=" + boardCode + ", inquiryArticleTitle=" + inquiryArticleTitle
				+ ", inquiryContent=" + inquiryContent + ", inquiryWriter=" + inquiryWriter + ", inquiryDate="
				+ inquiryDate + ", answerWriter=" + answerWriter + ", answercontent=" + answercontent + ", answerdate="
				+ answerdate + ", userNick=" + userNick + "]";
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


	public String getAnswercontent() {
		return answercontent;
	}


	public void setAnswercontent(String answercontent) {
		this.answercontent = answercontent;
	}


	public Date getAnswerdate() {
		return answerdate;
	}


	public void setAnswerdate(Date answerdate) {
		this.answerdate = answerdate;
	}


	public String getUserNick() {
		return userNick;
	}


	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}




    

}
