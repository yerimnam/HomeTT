package user.dto;

public class MailOk {

	private String ranNum;
	private String inputOk;
	private String resultChk;
	
	public MailOk() {}

	public MailOk(String ranNum, String inputOk, String resultChk) {
		super();
		this.ranNum = ranNum;
		this.inputOk = inputOk;
		this.resultChk = resultChk;
	}

	

	@Override
	public String toString() {
		return "MailOk [ranNum=" + ranNum + ", inputOk=" + inputOk + ", resultChk=" + resultChk + "]";
	}

	public String getRanNum() {
		return ranNum;
	}

	public void setRanNum(String ranNum) {
		this.ranNum = ranNum;
	}

	public String getInputOk() {
		return inputOk;
	}

	public void setInputOk(String inputOk) {
		this.inputOk = inputOk;
	}

	public String getResultChk() {
		return resultChk;
	}

	public void setResultChk(String resultChk) {
		this.resultChk = resultChk;
	}

	
	
	
	
}
