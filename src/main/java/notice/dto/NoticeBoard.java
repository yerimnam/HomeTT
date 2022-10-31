package notice.dto;

import java.sql.Date;

public class NoticeBoard {

	
	private int noticeArticlenumber;		//Notice_ARTICLENUMBER		글 번호
	private int adminNo;					//ADMIN_NO					관리자 번호
	private int boardCode;					//BOARD_CODE				게시판 코드
	private String noticeArticletitle;		//Notice_ARTICLETITLE		글 제목
	private String noticeContent;			//Notice_CONTENT			글 내용
	private String noticeWriter;			//Notice_WRITER				작성자
	private Date noticeDate;				//Notice_DATE				작성일
	private int hit;						//HIT						조회수
	private String userName;
	private int userNo;
	@Override
	public String toString() {
		return "NoticeBoard [noticeArticlenumber=" + noticeArticlenumber + ", adminNo=" + adminNo + ", boardCode="
				+ boardCode + ", noticeArticletitle=" + noticeArticletitle + ", noticeContent=" + noticeContent
				+ ", noticeWriter=" + noticeWriter + ", noticeDate=" + noticeDate + ", hit=" + hit + ", userName="
				+ userName + ", userNo=" + userNo + "]";
	}
	public NoticeBoard(int noticeArticlenumber, int adminNo, int boardCode, String noticeArticletitle,
			String noticeContent, String noticeWriter, Date noticeDate, int hit, String userName, int userNo) {
		super();
		this.noticeArticlenumber = noticeArticlenumber;
		this.adminNo = adminNo;
		this.boardCode = boardCode;
		this.noticeArticletitle = noticeArticletitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.noticeDate = noticeDate;
		this.hit = hit;
		this.userName = userName;
		this.userNo = userNo;
	}
	public NoticeBoard() {
		// TODO Auto-generated constructor stub
	}
	public int getNoticeArticlenumber() {
		return noticeArticlenumber;
	}
	public void setNoticeArticlenumber(int noticeArticlenumber) {
		this.noticeArticlenumber = noticeArticlenumber;
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
	public String getNoticeArticletitle() {
		return noticeArticletitle;
	}
	public void setNoticeArticletitle(String noticeArticletitle) {
		this.noticeArticletitle = noticeArticletitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
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
