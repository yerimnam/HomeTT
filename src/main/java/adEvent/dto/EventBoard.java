package adEvent.dto;

import java.sql.Date;

public class EventBoard {

	
	private int eventArticlenumber;
	private int adminNo;
	private int boardCode;
	private String eventArticletitle;
	private String eventContent;
	private String eventWriter;
	private Date eventDate;
	
	
	public EventBoard() {}

	public EventBoard(int eventArticlenumber, int adminNo, int boardCode, String eventArticletitle, String eventContent,
			String eventWriter, Date eventDate) {
		super();
		this.eventArticlenumber = eventArticlenumber;
		this.adminNo = adminNo;
		this.boardCode = boardCode;
		this.eventArticletitle = eventArticletitle;
		this.eventContent = eventContent;
		this.eventWriter = eventWriter;
		this.eventDate = eventDate;
	}







	@Override
	public String toString() {
		return "EventBoard [eventArticlenumber=" + eventArticlenumber + ", adminNo=" + adminNo + ", boardCode="
				+ boardCode + ", eventArticletitle=" + eventArticletitle + ", eventContent=" + eventContent
				+ ", eventWriter=" + eventWriter + ", eventDate=" + eventDate + "]";
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
	
	
}
