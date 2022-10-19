package payment.dto;

import java.util.Date;

public class Payment {

	private int payNo;
	private int userNo;
	private int couponNo;
	private String paymentMethod;
	private String userId;
	private int userCardNo;
	private String userCardCom;
	private int paymentAmount;
	private Date paymentDate;
	private String bankAccount;
	private String bank;
	private Date expirtyM;
	private Date expirtyY;
	private int payCode;
	private int pointUse; //사용 포인트
	private int couponUse;
	private String partyName;
	private int partyNo;
	
	public Payment() {}

	public Payment(int payNo, int userNo, int couponNo, String paymentMethod, String userId, int userCardNo,
			String userCardCom, int paymentAmount, Date paymentDate, String bankAccount, String bank, Date expirtyM,
			Date expirtyY, int payCode, int pointUse, int couponUse, String partyName, int partyNo) {
		super();
		this.payNo = payNo;
		this.userNo = userNo;
		this.couponNo = couponNo;
		this.paymentMethod = paymentMethod;
		this.userId = userId;
		this.userCardNo = userCardNo;
		this.userCardCom = userCardCom;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
		this.bankAccount = bankAccount;
		this.bank = bank;
		this.expirtyM = expirtyM;
		this.expirtyY = expirtyY;
		this.payCode = payCode;
		this.pointUse = pointUse;
		this.couponUse = couponUse;
		this.partyName = partyName;
		this.partyNo = partyNo;
	}

	@Override
	public String toString() {
		return "Payment [payNo=" + payNo + ", userNo=" + userNo + ", couponNo=" + couponNo + ", paymentMethod="
				+ paymentMethod + ", userId=" + userId + ", userCardNo=" + userCardNo + ", userCardCom=" + userCardCom
				+ ", paymentAmount=" + paymentAmount + ", paymentDate=" + paymentDate + ", bankAccount=" + bankAccount
				+ ", bank=" + bank + ", expirtyM=" + expirtyM + ", expirtyY=" + expirtyY + ", payCode=" + payCode
				+ ", pointUse=" + pointUse + ", couponUse=" + couponUse + ", partyName=" + partyName + ", partyNo="
				+ partyNo + "]";
	}

	public int getPayNo() {
		return payNo;
	}

	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
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

	public Date getExpirtyM() {
		return expirtyM;
	}

	public void setExpirtyM(Date expirtyM) {
		this.expirtyM = expirtyM;
	}

	public Date getExpirtyY() {
		return expirtyY;
	}

	public void setExpirtyY(Date expirtyY) {
		this.expirtyY = expirtyY;
	}

	public int getPayCode() {
		return payCode;
	}

	public void setPayCode(int payCode) {
		this.payCode = payCode;
	}

	public int getPointUse() {
		return pointUse;
	}

	public void setPointUse(int pointUse) {
		this.pointUse = pointUse;
	}

	public int getCouponUse() {
		return couponUse;
	}

	public void setCouponUse(int couponUse) {
		this.couponUse = couponUse;
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

	


}
