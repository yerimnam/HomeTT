package party.dto;

import java.util.Date;

public class WishList {
	
	private int wishNo;
	private int partyCano;
	private int boardCano;
	private String partyLeader;
	private String partyName;
	private Date partyCredate;
	private Date partyEnddate;
	private int userNo;
	private int partyNo;
	private String partyKind;
	
	
	public WishList() {	}
	
	
	public WishList(int wishNo, int partyCano, int boardCano, String partyLeader, String partyName, Date partyCredate,
			Date partyEnddate, int userNo, int partyNo, String partyKind) {
		super();
		this.wishNo = wishNo;
		this.partyCano = partyCano;
		this.boardCano = boardCano;
		this.partyLeader = partyLeader;
		this.partyName = partyName;
		this.partyCredate = partyCredate;
		this.partyEnddate = partyEnddate;
		this.userNo = userNo;
		this.partyNo = partyNo;
		this.partyKind = partyKind;
	}


	@Override
	public String toString() {
		return "WishList [wishNo=" + wishNo + ", partyCano=" + partyCano + ", boardCano=" + boardCano + ", partyLeader="
				+ partyLeader + ", partyName=" + partyName + ", partyCredate=" + partyCredate + ", partyEnddate="
				+ partyEnddate + ", userNo=" + userNo + ", partyNo=" + partyNo + ", partyKind=" + partyKind + "]";
	}


	public int getWishNo() {
		return wishNo;
	}


	public void setWishNo(int wishNo) {
		this.wishNo = wishNo;
	}


	public int getPartyCano() {
		return partyCano;
	}


	public void setPartyCano(int partyCano) {
		this.partyCano = partyCano;
	}


	public int getBoardCano() {
		return boardCano;
	}


	public void setBoardCano(int boardCano) {
		this.boardCano = boardCano;
	}


	public String getPartyLeader() {
		return partyLeader;
	}


	public void setPartyLeader(String partyLeader) {
		this.partyLeader = partyLeader;
	}


	public String getPartyName() {
		return partyName;
	}


	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}


	public Date getPartyCredate() {
		return partyCredate;
	}


	public void setPartyCredate(Date partyCredate) {
		this.partyCredate = partyCredate;
	}


	public Date getPartyEnddate() {
		return partyEnddate;
	}


	public void setPartyEnddate(Date partyEnddate) {
		this.partyEnddate = partyEnddate;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public int getPartyNo() {
		return partyNo;
	}


	public void setPartyNo(int partyNo) {
		this.partyNo = partyNo;
	}


	public String getPartyKind() {
		return partyKind;
	}


	public void setPartyKind(String partyKind) {
		this.partyKind = partyKind;
	}
	
	
	
	
	
	

}
