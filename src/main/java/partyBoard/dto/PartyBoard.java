package partyBoard.dto;

public class PartyBoard {
	
	private int partyBoardNo;
	private int partyNo;
	private int commentsNo;
	private int boardNo;
	private String partyBoardWrite;
	private String partyBoardWriter;
	private String partyBoardTitle;
	private String partyComments;
	private int userNo;
	private int boardCano;
	private int adminNo;
	
	public PartyBoard() { }

	public PartyBoard(int partyBoardNo, int partyNo, int commentsNo, int boardNo, String partyBoardWrite,
			String partyBoardWriter, String partyBoardTitle, String partyComments, int userNo, int boardCano,
			int adminNo) {
		super();
		this.partyBoardNo = partyBoardNo;
		this.partyNo = partyNo;
		this.commentsNo = commentsNo;
		this.boardNo = boardNo;
		this.partyBoardWrite = partyBoardWrite;
		this.partyBoardWriter = partyBoardWriter;
		this.partyBoardTitle = partyBoardTitle;
		this.partyComments = partyComments;
		this.userNo = userNo;
		this.boardCano = boardCano;
		this.adminNo = adminNo;
	}

	@Override
	public String toString() {
		return "partyBoard [partyBoardNo=" + partyBoardNo + ", partyNo=" + partyNo + ", commentsNo=" + commentsNo
				+ ", boardNo=" + boardNo + ", partyBoardWrite=" + partyBoardWrite + ", partyBoardWriter="
				+ partyBoardWriter + ", partyBoardTitle=" + partyBoardTitle + ", partyComments=" + partyComments
				+ ", userNo=" + userNo + ", boardCano=" + boardCano + ", adminNo=" + adminNo + "]";
	}

	public int getPartyBoardNo() {
		return partyBoardNo;
	}

	public void setPartyBoardNo(int partyBoardNo) {
		this.partyBoardNo = partyBoardNo;
	}

	public int getPartyNo() {
		return partyNo;
	}

	public void setPartyNo(int partyNo) {
		this.partyNo = partyNo;
	}

	public int getCommentsNo() {
		return commentsNo;
	}

	public void setCommentsNo(int commentsNo) {
		this.commentsNo = commentsNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getPartyBoardWrite() {
		return partyBoardWrite;
	}

	public void setPartyBoardWrite(String partyBoardWrite) {
		this.partyBoardWrite = partyBoardWrite;
	}

	public String getPartyBoardWriter() {
		return partyBoardWriter;
	}

	public void setPartyBoardWriter(String partyBoardWriter) {
		this.partyBoardWriter = partyBoardWriter;
	}

	public String getPartyBoardTitle() {
		return partyBoardTitle;
	}

	public void setPartyBoardTitle(String partyBoardTitle) {
		this.partyBoardTitle = partyBoardTitle;
	}

	public String getPartyComments() {
		return partyComments;
	}

	public void setPartyComments(String partyComments) {
		this.partyComments = partyComments;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getBoardCano() {
		return boardCano;
	}

	public void setBoardCano(int boardCano) {
		this.boardCano = boardCano;
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}
	
	
	
	

}
