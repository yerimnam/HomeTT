package coupon.dto;

import java.util.Date;

public class Coupon {
	
	private String couponNo;
	private String userNo;
	private String couponCode;
	private String couponName;
	private Date couponExpiry;
	private int couponAmount;
	private String couponCom;
	private String partyName;
	private int partyNo;
	private String userId;
	private Date couponDate; //쿠폰 사용 날짜 
	
	
	public Coupon() {}


	public Coupon(String couponNo, String userNo, String couponCode, String couponName, Date couponExpiry,
			int couponAmount, String couponCom, String partyName, int partyNo, String userId, Date couponDate) {
		super();
		this.couponNo = couponNo;
		this.userNo = userNo;
		this.couponCode = couponCode;
		this.couponName = couponName;
		this.couponExpiry = couponExpiry;
		this.couponAmount = couponAmount;
		this.couponCom = couponCom;
		this.partyName = partyName;
		this.partyNo = partyNo;
		this.userId = userId;
		this.couponDate = couponDate;
	}


	@Override
	public String toString() {
		return "Coupon [couponNo=" + couponNo + ", userNo=" + userNo + ", couponCode=" + couponCode + ", couponName="
				+ couponName + ", couponExpiry=" + couponExpiry + ", couponAmount=" + couponAmount + ", couponCom="
				+ couponCom + ", partyName=" + partyName + ", partyNo=" + partyNo + ", userId=" + userId
				+ ", couponDate=" + couponDate + "]";
	}


	public String getCouponNo() {
		return couponNo;
	}


	public void setCouponNo(String couponNo) {
		this.couponNo = couponNo;
	}


	public String getUserNo() {
		return userNo;
	}


	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}


	public String getCouponCode() {
		return couponCode;
	}


	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}


	public String getCouponName() {
		return couponName;
	}


	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}


	public Date getCouponExpiry() {
		return couponExpiry;
	}


	public void setCouponExpiry(Date couponExpiry) {
		this.couponExpiry = couponExpiry;
	}


	public int getCouponAmount() {
		return couponAmount;
	}


	public void setCouponAmount(int couponAmount) {
		this.couponAmount = couponAmount;
	}


	public String getCouponCom() {
		return couponCom;
	}


	public void setCouponCom(String couponCom) {
		this.couponCom = couponCom;
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


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public Date getCouponDate() {
		return couponDate;
	}


	public void setCouponDate(Date couponDate) {
		this.couponDate = couponDate;
	}
	
	
}
