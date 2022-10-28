package event.dto;

import java.sql.Date;

public class EventBoard {

	
	private int eventArticlenumber;
	private int adminNo;
	private int boardCode;
	private String eventArticletitle;
	private String eventContent;
	private String eventWriter;
	private Date eventDate;
	private int hit;					//HIT					조회수
	private String userName;
	private int userNo;
	 
	public EventBoard() {	}

	@Override
	public String toString() {
		return "EventBoard [eventArticlenumber=" + eventArticlenumber + ", adminNo=" + adminNo + ", boardCode="
				+ boardCode + ", eventArticletitle=" + eventArticletitle + ", eventContent=" + eventContent
				+ ", eventWriter=" + eventWriter + ", eventDate=" + eventDate + ", hit=" + hit + ", userName="
				+ userName + ", userNo=" + userNo + "]";
	}

	public EventBoard(int eventArticlenumber, int adminNo, int boardCode, String eventArticletitle, String eventContent,
			String eventWriter, Date eventDate, int hit, String userName, int userNo) {
		super();
		this.eventArticlenumber = eventArticlenumber;
		this.adminNo = adminNo;
		this.boardCode = boardCode;
		this.eventArticletitle = eventArticletitle;
		this.eventContent = eventContent;
		this.eventWriter = eventWriter;
		this.eventDate = eventDate;
		this.hit = hit;
		this.userName = userName;
		this.userNo = userNo;
	}

	public int getEventArticlenumber() {
		return eventArticlenumber;
	}

	public void setEventArticlenumber(int eventArticlenumber) {
		this.eventArticlenumber = eventArticlenumber;
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

	public String getEventArticletitle() {
		return eventArticletitle;
	}

	public void setEventArticletitle(String eventArticletitle) {
		this.eventArticletitle = eventArticletitle;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	public String getEventWriter() {
		return eventWriter;
	}

	public void setEventWriter(String eventWriter) {
		this.eventWriter = eventWriter;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
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