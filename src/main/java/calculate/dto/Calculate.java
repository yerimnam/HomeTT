package calculate.dto;

import java.util.Date;

public class Calculate {
	
	private int pay_no;
	private int user_no;
	private int point_no;
	private int coupon_no;
	private String paymentmethod;
	private String user_id;
	private int user_cardno;
	private String user_cardcom;
	private int payment_amount;
	private Date payment_Date;
	private String payment_accont;
	private String bank;
	private Date Expiry_m;
	private Date Expiry_y;
	private int pay_code;
	private int point_user;
	private int coupon_user;
	private String party_name;
	private int party_no;
	
	public Calculate() {}

	public Calculate(int pay_no, int user_no, int point_no, int coupon_no, String paymentmethod, String user_id,
			int user_cardno, String user_cardcom, int payment_amount, Date payment_Date, String payment_accont,
			String bank, Date expiry_m, Date expiry_y, int pay_code, int point_user, int coupon_user, String party_name,
			int party_no) {
		super();
		this.pay_no = pay_no;
		this.user_no = user_no;
		this.point_no = point_no;
		this.coupon_no = coupon_no;
		this.paymentmethod = paymentmethod;
		this.user_id = user_id;
		this.user_cardno = user_cardno;
		this.user_cardcom = user_cardcom;
		this.payment_amount = payment_amount;
		this.payment_Date = payment_Date;
		this.payment_accont = payment_accont;
		this.bank = bank;
		this.Expiry_m = expiry_m;
		this.Expiry_y = expiry_y;
		this.pay_code = pay_code;
		this.point_user = point_user;
		this.coupon_user = coupon_user;
		this.party_name = party_name;
		this.party_no = party_no;
	}

	@Override
	public String toString() {
		return "Calculate [pay_no=" + pay_no + ", user_no=" + user_no + ", point_no=" + point_no + ", coupon_no="
				+ coupon_no + ", paymentmethod=" + paymentmethod + ", user_id=" + user_id + ", user_cardno="
				+ user_cardno + ", user_cardcom=" + user_cardcom + ", payment_amount=" + payment_amount
				+ ", payment_Date=" + payment_Date + ", payment_accont=" + payment_accont + ", bank=" + bank
				+ ", Expiry_m=" + Expiry_m + ", Expiry_y=" + Expiry_y + ", pay_code=" + pay_code + ", point_user="
				+ point_user + ", coupon_user=" + coupon_user + ", party_name=" + party_name + ", party_no=" + party_no
				+ "]";
	}

	public int getPay_no() {
		return pay_no;
	}

	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getPoint_no() {
		return point_no;
	}

	public void setPoint_no(int point_no) {
		this.point_no = point_no;
	}

	public int getCoupon_no() {
		return coupon_no;
	}

	public void setCoupon_no(int coupon_no) {
		this.coupon_no = coupon_no;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getUser_cardno() {
		return user_cardno;
	}

	public void setUser_cardno(int user_cardno) {
		this.user_cardno = user_cardno;
	}

	public String getUser_cardcom() {
		return user_cardcom;
	}

	public void setUser_cardcom(String user_cardcom) {
		this.user_cardcom = user_cardcom;
	}

	public int getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(int payment_amount) {
		this.payment_amount = payment_amount;
	}

	public Date getPayment_Date() {
		return payment_Date;
	}

	public void setPayment_Date(Date payment_Date) {
		this.payment_Date = payment_Date;
	}

	public String getPayment_accont() {
		return payment_accont;
	}

	public void setPayment_accont(String payment_accont) {
		this.payment_accont = payment_accont;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Date getExpiry_m() {
		return Expiry_m;
	}

	public void setExpiry_m(Date expiry_m) {
		Expiry_m = expiry_m;
	}

	public Date getExpiry_y() {
		return Expiry_y;
	}

	public void setExpiry_y(Date expiry_y) {
		Expiry_y = expiry_y;
	}

	public int getPay_code() {
		return pay_code;
	}

	public void setPay_code(int pay_code) {
		this.pay_code = pay_code;
	}

	public int getPoint_user() {
		return point_user;
	}

	public void setPoint_user(int point_user) {
		this.point_user = point_user;
	}

	public int getCoupon_user() {
		return coupon_user;
	}

	public void setCoupon_user(int coupon_user) {
		this.coupon_user = coupon_user;
	}

	public String getParty_name() {
		return party_name;
	}

	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}

	public int getParty_no() {
		return party_no;
	}

	public void setParty_no(int party_no) {
		this.party_no = party_no;
	}
	
	
	
	

}
