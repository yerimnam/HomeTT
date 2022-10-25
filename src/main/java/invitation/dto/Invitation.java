package invitation.dto;

public class Invitation {
	
	private String partyCode;
	private int userNo;
	private int partyNo; 
	private String userPhone;
	
	public Invitation() {}

	public Invitation(String partyCode, int userNo, int partyNo, String userPhone) {
		super();
		this.partyCode = partyCode;
		this.userNo = userNo;
		this.partyNo = partyNo;
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return "Invitation [partyCode=" + partyCode + ", userNo=" + userNo + ", partyNo=" + partyNo + ", userPhone="
				+ userPhone + "]";
	}

	public String getPartyCode() {
		return partyCode;
	}

	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
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

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	

	
	
}
