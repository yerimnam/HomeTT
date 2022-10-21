package invitation.dto;

public class Invitation {
	
	private String party_code;
	private int user_no;
	private int party_no;
	private String user_phone;
	
	public Invitation() {}

	public Invitation(String party_code, int user_no, int party_no, String user_phone) {
		super();
		this.party_code = party_code;
		this.user_no = user_no;
		this.party_no = party_no;
		this.user_phone = user_phone;
	}

	@Override
	public String toString() {
		return "Invitation [party_code=" + party_code + ", user_no=" + user_no + ", party_no=" + party_no
				+ ", user_phone=" + user_phone + "]";
	}

	public String getParty_code() {
		return party_code;
	}

	public void setParty_code(String party_code) {
		this.party_code = party_code;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getParty_no() {
		return party_no;
	}

	public void setParty_no(int party_no) {
		this.party_no = party_no;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	
	
}
