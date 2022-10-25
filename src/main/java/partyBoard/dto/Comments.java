package partyBoard.dto;

import java.util.Date;

public class Comments {
	
	
	private int commentsNo;
	private int userNo;
	private Date commentsDate;
	private String commentsContent;
	
	
	
	public Comments() {	}
	
	
	public Comments(int commentsNo, int userNo, Date commentsDate, String commentsContent) {
		super();
		this.commentsNo = commentsNo;
		this.userNo = userNo;
		this.commentsDate = commentsDate;
		this.commentsContent = commentsContent;
	}


	@Override
	public String toString() {
		return "Comments [commentsNo=" + commentsNo + ", userNo=" + userNo + ", commentsDate=" + commentsDate
				+ ", commentsContent=" + commentsContent + "]";
	}


	public int getCommentsNo() {
		return commentsNo;
	}


	public void setCommentsNo(int commentsNo) {
		this.commentsNo = commentsNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public Date getCommentsDate() {
		return commentsDate;
	}


	public void setCommentsDate(Date commentsDate) {
		this.commentsDate = commentsDate;
	}


	public String getCommentsContent() {
		return commentsContent;
	}


	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}
	
	
	
	
	

}
