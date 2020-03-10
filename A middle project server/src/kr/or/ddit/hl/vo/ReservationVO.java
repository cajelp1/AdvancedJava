package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class ReservationVO implements Serializable{
	private int pay_no;
	private int res_no;
	private String res_approval_id;
	private String pay_content;
	private String pay_date;
	private String pay_status;

	public int getPay_no() {
		return pay_no;
	}

	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}

	public int getRes_no() {
		return res_no;
	}

	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}

	public String getRes_approval_id() {
		return res_approval_id;
	}

	public void setRes_approval_id(String res_approval_id) {
		this.res_approval_id = res_approval_id;
	}

	public String getPay_content() {
		return pay_content;
	}

	public void setPay_content(String pay_content) {
		this.pay_content = pay_content;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}

}
