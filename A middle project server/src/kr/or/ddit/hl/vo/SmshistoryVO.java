package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class SmshistoryVO implements Serializable {
	private int sms_no;
	private String sms_sender_hp;
	private String sms_receiver_hp;
	private String sms_content;
	private String sms_date;
	private String mem_sender_id;

	public int getSms_no() {
		return sms_no;
	}

	public void setSms_no(int sms_no) {
		this.sms_no = sms_no;
	}

	public String getSms_sender_hp() {
		return sms_sender_hp;
	}

	public void setSms_sender_hp(String sms_sender_hp) {
		this.sms_sender_hp = sms_sender_hp;
	}

	public String getSms_receiver_hp() {
		return sms_receiver_hp;
	}

	public void setSms_receiver_hp(String sms_receiver_hp) {
		this.sms_receiver_hp = sms_receiver_hp;
	}

	public String getSms_content() {
		return sms_content;
	}

	public void setSms_content(String sms_content) {
		this.sms_content = sms_content;
	}

	public String getSms_date() {
		return sms_date;
	}

	public void setSms_date(String sms_date) {
		this.sms_date = sms_date;
	}

	public String getMem_sender_id() {
		return mem_sender_id;
	}

	public void setMem_sender_id(String mem_sender_id) {
		this.mem_sender_id = mem_sender_id;
	}

}
