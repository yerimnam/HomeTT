package party.dto;

import java.util.Date;


public class Party {
	
	    private int partyNo;
	      private int userNo;
	      private int partyCano;
	      private String partyKind;
	      private String partyRule;
	      private int paymentAmount;
	      private Date partyPeriod;
	      private int partyMember;
	      private int boardCano;
	      private Date partyCreDate;
	      private Date partyEndDate;
	      private String partyName;
	      private String partyLeader;
	      private String partyMbrInfo;
	      private String ottId;
	      private String ottPw;
	      private String partyNotice;
	      
	      public Party() {
	   }

	   public Party(int partyNo, int userNo, int partyCano, String partyKind, String partyRule, int paymentAmount,
	         Date partyPeriod, int partyMember, int boardCano, Date partyCreDate, Date partyEndDate, String partyName,
	         String partyLeader, String partyMbrInfo, String ottId, String ottPw, String partyNotice) {
	      super();
	      this.partyNo = partyNo;
	      this.userNo = userNo;
	      this.partyCano = partyCano;
	      this.partyKind = partyKind;
	      this.partyRule = partyRule;
	      this.paymentAmount = paymentAmount;
	      this.partyPeriod = partyPeriod;
	      this.partyMember = partyMember;
	      this.boardCano = boardCano;
	      this.partyCreDate = partyCreDate;
	      this.partyEndDate = partyEndDate;
	      this.partyName = partyName;
	      this.partyLeader = partyLeader;
	      this.partyMbrInfo = partyMbrInfo;
	      this.ottId = ottId;
	      this.ottPw = ottPw;
	      this.partyNotice = partyNotice;
	   }

	   @Override
	   public String toString() {
	      return "Party [partyNo=" + partyNo + ", userNo=" + userNo + ", partyCano=" + partyCano + ", partyKind="
	            + partyKind + ", partyRule=" + partyRule + ", paymentAmount=" + paymentAmount + ", partyPeriod="
	            + partyPeriod + ", partyMember=" + partyMember + ", boardCano=" + boardCano + ", partyCreDate="
	            + partyCreDate + ", partyEndDate=" + partyEndDate + ", partyName=" + partyName + ", partyLeader="
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

	   public int getPartyCano() {
	      return partyCano;
	   }

	   public void setPartyCano(int partyCano) {
	      this.partyCano = partyCano;
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

	   public int getPaymentAmount() {
	      return paymentAmount;
	   }

	   public void setPaymentAmount(int paymentAmount) {
	      this.paymentAmount = paymentAmount;
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

	   public Date getPartyCreDate() {
	      return partyCreDate;
	   }

	   public void setPartyCreDate(Date partyCreDate) {
	      this.partyCreDate = partyCreDate;
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