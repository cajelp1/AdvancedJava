package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class MailhistoryVO implements Serializable {
	private int mail_no;
	private String mail_sender_address;
	private String mail_receiver_address;
	private String mail_title;
	private String mail_content;
	private String mail_date;
	private String mem_sender_id;

	public int getMail_no() {
		return mail_no;
	}

	public void setMail_no(int mail_no) {
		this.mail_no = mail_no;
	}

	public String getMail_sender_address() {
		return mail_sender_address;
	}

	public void setMail_sender_address(String mail_sender_address) {
		this.mail_sender_address = mail_sender_address;
	}

	public String getMail_receiver_address() {
		return mail_receiver_address;
	}

	public void setMail_receiver_address(String mail_receiver_address) {
		this.mail_receiver_address = mail_receiver_address;
	}

	public String getMail_title() {
		return mail_title;
	}

	public void setMail_title(String mail_title) {
		this.mail_title = mail_title;
	}

	public String getMail_content() {
		return mail_content;
	}

	public void setMail_content(String mail_content) {
		this.mail_content = mail_content;
	}

	public String getMail_date() {
		return mail_date;
	}

	public void setMail_date(String mail_date) {
		this.mail_date = mail_date;
	}

	public String getMem_sender_id() {
		return mem_sender_id;
	}

	public void setMem_sender_id(String mem_sender_id) {
		this.mem_sender_id = mem_sender_id;
	}

}
