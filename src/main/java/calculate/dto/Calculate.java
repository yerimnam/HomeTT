package calculate.dto;

import java.util.Date;

public class Calculate {
	
	private int calculateNo;
	private String payNo;
	private int calculateAccount;
	private String calculateBank;
	private int partyNo;
	private int userNo;
	private int paymentAmount;
	private Date paymentDate;
	private Date calculateDate;
	
	public Calculate() {}

	public Calculate(int calculateNo, String payNo, int calculateAccount, String calculateBank, int partyNo, int userNo,
			int paymentAmount, Date paymentDate, Date calculateDate) {
		super();
		this.calculateNo = calculateNo;
		this.payNo = payNo;
		this.calculateAccount = calculateAccount;
		this.calculateBank = calculateBank;
		this.partyNo = partyNo;
		this.userNo = userNo;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
		this.calculateDate = calculateDate;
	}

	@Override
	public String toString() {
		return "Calculate [calculateNo=" + calculateNo + ", payNo=" + payNo + ", calculateAccount=" + calculateAccount
				+ ", calculateBank=" + calculateBank + ", partyNo=" + partyNo + ", userNo=" + userNo
				+ ", paymentAmount=" + paymentAmount + ", paymentDate=" + paymentDate + ", calculateDate="
				+ calculateDate + "]";
	}

	public int getCalculateNo() {
		return calculateNo;
	}

	public void setCalculateNo(int calculateNo) {
		this.calculateNo = calculateNo;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public int getCalculateAccount() {
		return calculateAccount;
	}

	public void setCalculateAccount(int calculateAccount) {
		this.calculateAccount = calculateAccount;
	}

	public String getCalculateBank() {
		return calculateBank;
	}

	public void setCalculateBank(String calculateBank) {
		this.calculateBank = calculateBank;
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

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getCalculateDate() {
		return calculateDate;
	}

	public void setCalculateDate(Date calculateDate) {
		this.calculateDate = calculateDate;
	}

	
	
	
	

}
