package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class RoleVO implements Serializable {
	private int role_code;
	private String role_name;
	private String role_date;

	public int getRole_code() {
		return role_code;
	}

	public void setRole_code(int role_code) {
		this.role_code = role_code;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_date() {
		return role_date;
	}

	public void setRole_date(String role_date) {
		this.role_date = role_date;
	}

}
