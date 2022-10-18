package oderList.dto;

import java.util.Date;

public class OrderList {
	
	private int userNo;
	private String partyName;
	private int partyNo;
	private String partyKind;
	private Date partyPeriod;
	private Date partyCreDate;
	private Date partyEndDate;
	private int paymentAmount;
	
	public OrderList() {}

	public OrderList(int userNo, String partyName, int partyNo, String partyKind, Date partyPeriod, Date partyCreDate,
			Date partyEndDate, int paymentAmount) {
		super();
		this.userNo = userNo;
		this.partyName = partyName;
		this.partyNo = partyNo;
		this.partyKind = partyKind;
		this.partyPeriod = partyPeriod;
		this.partyCreDate = partyCreDate;
		this.partyEndDate = partyEndDate;
		this.paymentAmount = paymentAmount;
	}

	@Override
	public String toString() {
		return "OrderList [userNo=" + userNo + ", partyName=" + partyName + ", partyNo=" + partyNo + ", partyKind="
				+ partyKind + ", partyPeriod=" + partyPeriod + ", partyCreDate=" + partyCreDate + ", partyEndDate="
				+ partyEndDate + ", paymentAmount=" + paymentAmount + "]";
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
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

	public Date getPartyPeriod() {
		return partyPeriod;
	}

	public void setPartyPeriod(Date partyPeriod) {
		this.partyPeriod = partyPeriod;
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

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
 
	
}
