package user.dto;

import java.util.Date;

public class Member {
	
	private int userNo;
	private String paymentMethod;
	private int masterNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userNick;
	private String userEmail;
	private int userPhone;
	private Date joinDate;
	private int partyNo;
 
	public Member() {}

	public Member(int userNo, String paymentMethod, int masterNo, String userId, String userPw, String userName,
			String userNick, String userEmail, int userPhone, Date joinDate, int partyNo) {
		super();
		this.userNo = userNo;
		this.paymentMethod = paymentMethod;
		this.masterNo = masterNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userNick = userNick;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.joinDate = joinDate;
		this.partyNo = partyNo;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", paymentMethod=" + paymentMethod + ", masterNo=" + masterNo + ", userId="
				+ userId + ", userPw=" + userPw + ", userName=" + userName + ", userNick=" + userNick + ", userEmail="
				+ userEmail + ", userPhone=" + userPhone + ", joinDate=" + joinDate + ", partyNo=" + partyNo + "]";
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getMasterNo() {
		return masterNo;
	}

	public void setMasterNo(int masterNo) {
		this.masterNo = masterNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public int getPartyNo() {
		return partyNo;
	}

	public void setPartyNo(int partyNo) {
		this.partyNo = partyNo;
	}
	
	
	
	
}
