package reviewBoard.dto;

import java.sql.Date;

public class ReviewBoard {

	
	private int reviewArticlenumber;
	private int adminNo;
	private int boardCode;
	private String reviewArticletitle;
	private String reviewContent;
	private String reviewWriter;
	private Date reviewDate;
	private int hit;					//HIT					조회수
	private String userName;
	private int userNo;
	 
	public ReviewBoard() {	}

	@Override
	public String toString() {
		return "ReviewBoard [reviewArticlenumber=" + reviewArticlenumber + ", adminNo=" + adminNo + ", boardCode="
				+ boardCode + ", reviewArticletitle=" + reviewArticletitle + ", reviewContent=" + reviewContent
				+ ", reviewWriter=" + reviewWriter + ", reviewDate=" + reviewDate + ", hit=" + hit + ", userName="
				+ userName + ", userNo=" + userNo + "]";
	}

	public ReviewBoard(int reviewArticlenumber, int adminNo, int boardCode, String reviewArticletitle,
			String reviewContent, String reviewWriter, Date reviewDate, int hit, String userName, int userNo) {
		super();
		this.reviewArticlenumber = reviewArticlenumber;
		this.adminNo = adminNo;
		this.boardCode = boardCode;
		this.reviewArticletitle = reviewArticletitle;
		this.reviewContent = reviewContent;
		this.reviewWriter = reviewWriter;
		this.reviewDate = reviewDate;
		this.hit = hit;
		this.userName = userName;
		this.userNo = userNo;
	}

	public int getReviewArticlenumber() {
		return reviewArticlenumber;
	}

	public void setReviewArticlenumber(int reviewArticlenumber) {
		this.reviewArticlenumber = reviewArticlenumber;
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

	public String getReviewArticletitle() {
		return reviewArticletitle;
	}

	public void setReviewArticletitle(String reviewArticletitle) {
		this.reviewArticletitle = reviewArticletitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	
	 
	 
	
}