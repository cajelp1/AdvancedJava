package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class MenuVO implements Serializable{
	
	private String menu_code;
	private String menu_name;
	private int role_code;
	private String menu_date;

	public String getMenu_code() {
		return menu_code;
	}

	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getRole_code() {
		return role_code;
	}

	public void setRole_code(int role_code) {
		this.role_code = role_code;
	}

	public String getMenu_date() {
		return menu_date;
	}

	public void setMenu_date(String menu_date) {
		this.menu_date = menu_date;
	}

}
