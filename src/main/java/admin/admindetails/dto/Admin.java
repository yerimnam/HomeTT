package admin.admindetails.dto;

public class Admin {
	private int adminNo;
	private int statiNo;
	private int reportNo;
	private String adminId;
	private String adminPw;
	private String adminName;
	private String adminEmail;
	private String adminPhone;
	private String adminTeam;
	private String adminPosition;
	private String adminProfile;
	
	public Admin() {}
	
	public Admin(int adminNo, int statiNo, int reportNo, String adminId, String adminPw, String adminName,
			String adminEmail, String adminPhone, String adminTeam, String adminPosition, String adminProfile) {
		super();
		this.adminNo = adminNo;
		this.statiNo = statiNo;
		this.reportNo = reportNo;
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPhone = adminPhone;
		this.adminTeam = adminTeam;
		this.adminPosition = adminPosition;
		this.adminProfile = adminProfile;
	}

	@Override
	public String toString() {
		return "Admin [adminNo=" + adminNo + ", statiNo=" + statiNo + ", reportNo=" + reportNo + ", adminId=" + adminId
				+ ", adminPw=" + adminPw + ", adminName=" + adminName + ", adminEmail=" + adminEmail + ", adminPhone="
				+ adminPhone + ", adminTeam=" + adminTeam + ", adminPosition=" + adminPosition + ", adminProfile="
				+ adminProfile + "]";
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}

	public int getStatiNo() {
		return statiNo;
	}

	public void setStatiNo(int statiNo) {
		this.statiNo = statiNo;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminTeam() {
		return adminTeam;
	}

	public void setAdminTeam(String adminTeam) {
		this.adminTeam = adminTeam;
	}

	public String getAdminPosition() {
		return adminPosition;
	}

	public void setAdminPosition(String adminPosition) {
		this.adminPosition = adminPosition;
	}

	public String getAdminProfile() {
		return adminProfile;
	}

	public void setAdminProfile(String adminProfile) {
		this.adminProfile = adminProfile;
	}
	
}
