package partyExit.dto;

import java.util.Date;

public class PartyExit {

	private int partyNo;
	private int userNo;
	private String partyKind;
	private String partyRule;
	private int paymentamount;
	private Date partyPeriod;
	private int partyMember;
	private int boardCano;
	private Date partyCredate;
	private Date partyEndDate;
	private String partyName;
	private String partyLeader;
	private String ottId;
	private String ottPw;
	private String partyNotice;
	private int partyRoomNo;
	
	public PartyExit() {}

	public PartyExit(int partyNo, int userNo, String partyKind, String partyRule, int paymentamount, Date partyPeriod,
			int partyMember, int boardCano, Date partyCredate, Date partyEndDate, String partyName, String partyLeader,
			String ottId, String ottPw, String partyNotice, int partyRoomNo) {
		super();
		this.partyNo = partyNo;
		this.userNo = userNo;
		this.partyKind = partyKind;
		this.partyRule = partyRule;
		this.paymentamount = paymentamount;
		this.partyPeriod = partyPeriod;
		this.partyMember = partyMember;
		this.boardCano = boardCano;
		this.partyCredate = partyCredate;
		this.partyEndDate = partyEndDate;
		this.partyName = partyName;
		this.partyLeader = partyLeader;
		this.ottId = ottId;
		this.ottPw = ottPw;
		this.partyNotice = partyNotice;
		this.partyRoomNo = partyRoomNo;
	}

	@Override
	public String toString() {
		return "PartyExit [partyNo=" + partyNo + ", userNo=" + userNo + ", partyKind=" + partyKind + ", partyRule="
				+ partyRule + ", paymentamount=" + paymentamount + ", partyPeriod=" + partyPeriod + ", partyMember="
				+ partyMember + ", boardCano=" + boardCano + ", partyCredate=" + partyCredate + ", partyEndDate="
				+ partyEndDate + ", partyName=" + partyName + ", partyLeader=" + partyLeader + ", ottId=" + ottId
				+ ", ottPw=" + ottPw + ", partyNotice=" + partyNotice + ", partyRoomNo=" + partyRoomNo + "]";
	}

	public int getPartyNo() {
		return partyNo;
	}

	public void setPartyNo(int partyNo) {
		this.partyNo = partyNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getPartyKind() {
		return partyKind;
	}

	public void setPartyKind(String partyKind) {
		this.partyKind = partyKind;
	}

	public String getPartyRule() {
		return partyRule;
	}

	public void setPartyRule(String partyRule) {
		this.partyRule = partyRule;
	}

	public int getPaymentamount() {
		return paymentamount;
	}

	public void setPaymentamount(int paymentamount) {
		this.paymentamount = paymentamount;
	}

	public Date getPartyPeriod() {
		return partyPeriod;
	}

	public void setPartyPeriod(Date partyPeriod) {
		this.partyPeriod = partyPeriod;
	}

	public int getPartyMember() {
		return partyMember;
	}

	public void setPartyMember(int partyMember) {
		this.partyMember = partyMember;
	}

	public int getBoardCano() {
		return boardCano;
	}

	public void setBoardCano(int boardCano) {
		this.boardCano = boardCano;
	}

	public Date getPartyCredate() {
		return partyCredate;
	}

	public void setPartyCredate(Date partyCredate) {
		this.partyCredate = partyCredate;
	}

	public Date getPartyEndDate() {
		return partyEndDate;
	}

	public void setPartyEndDate(Date partyEndDate) {
		this.partyEndDate = partyEndDate;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyLeader() {
		return partyLeader;
	}

	public void setPartyLeader(String partyLeader) {
		this.partyLeader = partyLeader;
	}

	public String getOttId() {
		return ottId;
	}

	public void setOttId(String ottId) {
		this.ottId = ottId;
	}

	public String getOttPw() {
		return ottPw;
	}

	public void setOttPw(String ottPw) {
		this.ottPw = ottPw;
	}

	public String getPartyNotice() {
		return partyNotice;
	}

	public void setPartyNotice(String partyNotice) {
		this.partyNotice = partyNotice;
	}

	public int getPartyRoomNo() {
		return partyRoomNo;
	}

	public void setPartyRoomNo(int partyRoomNo) {
		this.partyRoomNo = partyRoomNo;
	}
	
	
	
}
