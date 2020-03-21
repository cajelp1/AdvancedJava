package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class ReservationVO implements Serializable {
	private Integer res_no;
	private String res_client;
	private String res_lawyer_id;
	private String res_status;
	private String res_location;
	private String res_date;
	private String res_type;
	
	public Integer getRes_no() {
		return res_no;
	}
	public void setRes_no(Integer res_no) {
		this.res_no = res_no;
	}
	public String getRes_client() {
		return res_client;
	}
	public void setRes_client(String res_client) {
		this.res_client = res_client;
	}
	public String getRes_lawyer_id() {
		return res_lawyer_id;
	}
	public void setRes_lawyer_id(String res_lawyer_id) {
		this.res_lawyer_id = res_lawyer_id;
	}
	public String getRes_status() {
		return res_status;
	}
	public void setRes_status(String res_status) {
		this.res_status = res_status;
	}
	public String getRes_location() {
		return res_location;
	}
	public void setRes_location(String res_location) {
		this.res_location = res_location;
	}
	public String getRes_date() {
		return res_date;
	}
	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}
	public String getRes_type() {
		return res_type;
	}
	public void setRes_type(String res_type) {
		this.res_type = res_type;
	}
	
}
