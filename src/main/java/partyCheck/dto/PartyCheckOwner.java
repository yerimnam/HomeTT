package partyCheck.dto;

import java.util.Date;

public class PartyCheckOwner {

	private int partyNo;
	private int userNo;
	private int partyCono;
	private String partyKind;
	private String parryRule;
	private int paymentamount;
	private Date partyPeriod;
	private int partyMember;
	private int boardCano;
	private Date partyCredate;
	private Date partyEnddate;
	private String partyName;
	private String partyLeader;
	private String partyMbrInfo;
	private String ottId;
	private String ottPw;
	private String partyNotice;
	
	public PartyCheckOwner() {}

	public PartyCheckOwner(int partyNo, int userNo, int partyCono, String partyKind, String parryRule, int paymentamount,
			Date partyPeriod, int partyMember, int boardCano, Date partyCredate, Date partyEnddate, String partyName,
			String partyLeader, String partyMbrInfo, String ottId, String ottPw, String partyNotice) {
		super();
		this.partyNo = partyNo;
		this.userNo = userNo;
		this.partyCono = partyCono;
		this.partyKind = partyKind;
		this.parryRule = parryRule;
		this.paymentamount = paymentamount;
		this.partyPeriod = partyPeriod;
		this.partyMember = partyMember;
		this.boardCano = boardCano;
		this.partyCredate = partyCredate;
		this.partyEnddate = partyEnddate;
		this.partyName = partyName;
		this.partyLeader = partyLeader;
		this.partyMbrInfo = partyMbrInfo;
		this.ottId = ottId;
		this.ottPw = ottPw;
		this.partyNotice = partyNotice;
	}

	@Override
	public String toString() {
		return "PartyCheck [partyNo=" + partyNo + ", userNo=" + userNo + ", partyCono=" + partyCono + ", partyKind="
				+ partyKind + ", parryRule=" + parryRule + ", paymentamount=" + paymentamount + ", partyPeriod="
				+ partyPeriod + ", partyMember=" + partyMember + ", boardCano=" + boardCano + ", partyCredate="
				+ partyCredate + ", partyEnddate=" + partyEnddate + ", partyName=" + partyName + ", partyLeader="
				+ partyLeader + ", partyMbrInfo=" + partyMbrInfo + ", ottId=" + ottId + ", ottPw=" + ottPw
				+ ", partyNotice=" + partyNotice + "]";
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

	public int getPartyCono() {
		return partyCono;
	}

	public void setPartyCono(int partyCono) {
		this.partyCono = partyCono;
	}

	public String getPartyKind() {
		return partyKind;
	}

	public void setPartyKind(String partyKind) {
		this.partyKind = partyKind;
	}

	public String getParryRule() {
		return parryRule;
	}

	public void setParryRule(String parryRule) {
		this.parryRule = parryRule;
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

	public Date getPartyEnddate() {
		return partyEnddate;
	}

	public void setPartyEnddate(Date partyEnddate) {
		this.partyEnddate = partyEnddate;
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

	public String getPartyMbrInfo() {
		return partyMbrInfo;
	}

	public void setPartyMbrInfo(String partyMbrInfo) {
		this.partyMbrInfo = partyMbrInfo;
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
	
}
