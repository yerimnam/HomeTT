package party.dto;

public class PartyRoom {
	
	private int party_room_no;
	private int user_no;
	private int party_no; //넷플은 1 티빙2이런거
	
	public PartyRoom() {
	}

	public PartyRoom(int party_room_no, int user_no, int party_no) {
		super();
		this.party_room_no = party_room_no;
		this.user_no = user_no;
		this.party_no = party_no;
	}

	@Override
	public String toString() {
		return "PartyRoom [party_room_no=" + party_room_no + ", user_no=" + user_no + ", party_no=" + party_no + "]";
	}

	public int getParty_room_no() {
		return party_room_no;
	}

	public void setParty_room_no(int party_room_no) {
		this.party_room_no = party_room_no;
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
	
	
	

}
