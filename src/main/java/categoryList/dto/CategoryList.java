package categoryList.dto;

public class CategoryList {
	
	private int partyCano;
	private String partyKind;
	private int ntRoom;
	private int dpRoom;
	private int laRoom;
	private int wavRoom;
	private int whaRoom;
	private int appRoom;
	private int tvRoom;
	
	
	public CategoryList() {}

	public CategoryList(int partyCano, String partyKind, int ntRoom, int dpRoom, int laRoom, int wavRoom, int whaRoom,
			int appRoom, int tvRoom) {
		super();
		this.partyCano = partyCano;
		this.partyKind = partyKind;
		this.ntRoom = ntRoom;
		this.dpRoom = dpRoom;
		this.laRoom = laRoom;
		this.wavRoom = wavRoom;
		this.whaRoom = whaRoom;
		this.appRoom = appRoom;
		this.tvRoom = tvRoom;
	}


	@Override
	public String toString() {
		return "CategoryList [partyCano=" + partyCano + ", partyKind=" + partyKind + ", ntRoom=" + ntRoom + ", dpRoom="
				+ dpRoom + ", laRoom=" + laRoom + ", wavRoom=" + wavRoom + ", whaRoom=" + whaRoom + ", appRoom="
				+ appRoom + ", tvRoom=" + tvRoom + "]";
	}


	public int getPartyCano() {
		return partyCano;
	}


	public void setPartyCano(int partyCano) {
		this.partyCano = partyCano;
	}


	public String getPartyKind() {
		return partyKind;
	}


	public void setPartyKind(String partyKind) {
		this.partyKind = partyKind;
	}


	public int getNtRoom() {
		return ntRoom;
	}


	public void setNtRoom(int ntRoom) {
		this.ntRoom = ntRoom;
	}


	public int getDpRoom() {
		return dpRoom;
	}


	public void setDpRoom(int dpRoom) {
		this.dpRoom = dpRoom;
	}


	public int getLaRoom() {
		return laRoom;
	}


	public void setLaRoom(int laRoom) {
		this.laRoom = laRoom;
	}


	public int getWavRoom() {
		return wavRoom;
	}


	public void setWavRoom(int wavRoom) {
		this.wavRoom = wavRoom;
	}


	public int getWhaRoom() {
		return whaRoom;
	}


	public void setWhaRoom(int whaRoom) {
		this.whaRoom = whaRoom;
	}


	public int getAppRoom() {
		return appRoom;
	}


	public void setAppRoom(int appRoom) {
		this.appRoom = appRoom;
	}


	public int getTvRoom() {
		return tvRoom;
	}


	public void setTvRoom(int tvRoom) {
		this.tvRoom = tvRoom;
	}

	

}
