package wishListCheck.dto;

import java.util.Date;

public class WishListCheck {

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
	private int partyMember;
	private int paymentamount;
	
	public WishListCheck() {}

	public WishListCheck(int wishNo, int partyCano, int boardCano, String partyLeader, String partyName,
			Date partyCredate, Date partyEnddate, int userNo, int partyNo, String partyKind, int partyMember, int paymentamount) {
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
		this.partyMember = partyMember;
		this.paymentamount = paymentamount;
	}



	@Override
	public String toString() {
		return "WishListCheck [wishNo=" + wishNo + ", partyCano=" + partyCano + ", boardCano=" + boardCano
				+ ", partyLeader=" + partyLeader + ", partyName=" + partyName + ", partyCredate=" + partyCredate
				+ ", partyEnddate=" + partyEnddate + ", userNo=" + userNo + ", partyNo=" + partyNo + ", partyKind="
				+ partyKind + ", partyMember=" + partyMember + ", paymentamount=" + paymentamount + "]";
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

	public int getPaymentamount() {
		return paymentamount;
	}

	public void setPaymentamount(int paymentamount) {
		this.paymentamount = paymentamount;
	}

	public void setBoardCano(int boardCano) {
		this.boardCano = boardCano;
	}

	public String getPartyLeader() {
		return partyLeader;
	}

	public int getPartyMember() {
		return partyMember;
	}

	public void setPartyMember(int partyMember) {
		this.partyMember = partyMember;
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
