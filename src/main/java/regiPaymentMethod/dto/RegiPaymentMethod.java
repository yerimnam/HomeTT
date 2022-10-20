package regiPaymentMethod.dto;

import java.util.Date;

public class RegiPaymentMethod {
	
	private String paymentMethod;
	private int userNo;
	private String userId;
	private int userCardNo;
	private String userCardCom;
	private String bankAccount;
	private String bank;
	private Date expiryM;
	private Date expiryY;
	
	//생성자
	public RegiPaymentMethod() {}

	//매개변수 있는 생성자
	public RegiPaymentMethod(String paymentMethod, int userNo, String userId, int userCardNo, String userCardCom,
			String bankAccount, String bank, Date expiryM, Date expiryY) {
		super();
		this.paymentMethod = paymentMethod;
		this.userNo = userNo;
		this.userId = userId;
		this.userCardNo = userCardNo;
		this.userCardCom = userCardCom;
		this.bankAccount = bankAccount;
		this.bank = bank;
		this.expiryM = expiryM;
		this.expiryY = expiryY;
	}

	//toString
	@Override
	public String toString() {
		return "RegiPaymentMethod [paymentMethod=" + paymentMethod + ", userNo=" + userNo + ", userId=" + userId
				+ ", userCardNo=" + userCardNo + ", userCardCom=" + userCardCom + ", bankAccount=" + bankAccount
				+ ", bank=" + bank + ", expiryM=" + expiryM + ", expiryY=" + expiryY + "]";
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getUserCardNo() {
		return userCardNo;
	}

	public void setUserCardNo(int userCardNo) {
		this.userCardNo = userCardNo;
	}

	public String getUserCardCom() {
		return userCardCom;
	}

	public void setUserCardCom(String userCardCom) {
		this.userCardCom = userCardCom;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Date getExpiryM() {
		return expiryM;
	}

	public void setExpiryM(Date expiryM) {
		this.expiryM = expiryM;
	}

	public Date getExpiryY() {
		return expiryY;
	}

	public void setExpiryY(Date expiryY) {
		this.expiryY = expiryY;
	}
   
	
}
