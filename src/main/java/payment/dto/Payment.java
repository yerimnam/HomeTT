package payment.dto;

import java.sql.Date;

public class Payment {

	private String payNo;
	private String orderNo;
	private int userNo;
	private int partyNo;
	private String paymentMethod;
	private String userCardCom;
	private int paymentAmount;
	private Date paymentDate;
	private String partyName;
	private String userId;
	private String userNick;
	private String userName;
	private String userEmail;
	private String userPhone;
	
	
	public Payment(){}


	public Payment(String payNo, String orderNo, int userNo, int partyNo, String paymentMethod, String userCardCom,
			int paymentAmount, Date paymentDate, String partyName, String userId, String userNick, String userName,
			String userEmail, String userPhone) {
		super();
		this.payNo = payNo;
		this.orderNo = orderNo;
		this.userNo = userNo;
		this.partyNo = partyNo;
		this.paymentMethod = paymentMethod;
		this.userCardCom = userCardCom;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
		this.partyName = partyName;
		this.userId = userId;
		this.userNick = userNick;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}


	@Override
	public String toString() {
		return "Payment [payNo=" + payNo + ", orderNo=" + orderNo + ", userNo=" + userNo + ", partyNo=" + partyNo
				+ ", paymentMethod=" + paymentMethod + ", userCardCom=" + userCardCom + ", paymentAmount="
				+ paymentAmount + ", paymentDate=" + paymentDate + ", partyName=" + partyName + ", userId=" + userId
				+ ", userNick=" + userNick + ", userName=" + userName + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + "]";
	}


	public String getPayNo() {
		return payNo;
	}


	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}


	public String getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
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


	public String getPartyName() {
		return partyName;
	}


	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserNick() {
		return userNick;
	}


	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	
	


}
