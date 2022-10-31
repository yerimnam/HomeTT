package admin.payment.dto;

import java.sql.Date;

public class Payment {

	private String payNo;
	private String orderNo;
	private int userNo;
	private int partyNo;
	private String paymentMethod;
	private String userCardcom;
	private int paymentAmount;
	private Date paymentDate;
	
	public Payment(){}

	public Payment(String payNo, String orderNo, int userNo, int partyNo, String paymentMethod, String userCardcom,
			int paymentAmount, Date paymentDate) {
		super();
		this.payNo = payNo;
		this.orderNo = orderNo;
		this.userNo = userNo;
		this.partyNo = partyNo;
		this.paymentMethod = paymentMethod;
		this.userCardcom = userCardcom;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Payment [payNo=" + payNo + ", orderNo=" + orderNo + ", userNo=" + userNo + ", partyNo=" + partyNo
				+ ", paymentMethod=" + paymentMethod + ", userCardcom=" + userCardcom + ", paymentAmount="
				+ paymentAmount + ", paymentDate=" + paymentDate + "]";
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

	public String getUserCardcom() {
		return userCardcom;
	}

	public void setUserCardcom(String userCardcom) {
		this.userCardcom = userCardcom;
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

}
