package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class LawyerVO implements Serializable {
	private String law_id;
	private String law_password;
	private String law_name;
	private String law_nickname;
	private String law_jumin_no;
	private String law_email;
	private String law_hp;
	private String law_company_name;
	private String law_date;
	private String role_code;
	private String law_addr1;
	private String law_addr2;
	private String law_zipcode;
	
	public String getLaw_id() {
		return law_id;
	}

	public void setLaw_id(String law_id) {
		this.law_id = law_id;
	}

	public String getLaw_password() {
		return law_password;
	}

	public void setLaw_password(String law_password) {
		this.law_password = law_password;
	}

	public String getLaw_name() {
		return law_name;
	}

	public void setLaw_name(String law_name) {
		this.law_name = law_name;
	}

	public String getLaw_nickname() {
		return law_nickname;
	}

	public void setLaw_nickname(String law_nickname) {
		this.law_nickname = law_nickname;
	}

	public String getLaw_jumin_no() {
		return law_jumin_no;
	}

	public void setLaw_jumin_no(String law_jumin_no) {
		this.law_jumin_no = law_jumin_no;
	}

	public String getLaw_email() {
		return law_email;
	}

	public void setLaw_email(String law_email) {
		this.law_email = law_email;
	}

	public String getLaw_hp() {
		return law_hp;
	}

	public void setLaw_hp(String law_hp) {
		this.law_hp = law_hp;
	}

	public String getLaw_company_name() {
		return law_company_name;
	}

	public void setLaw_company_name(String law_company_name) {
		this.law_company_name = law_company_name;
	}

	public String getLaw_date() {
		return law_date;
	}

	public void setLaw_date(String law_date) {
		this.law_date = law_date;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public String getLaw_addr1() {
		return law_addr1;
	}

	public void setLaw_addr1(String law_addr1) {
		this.law_addr1 = law_addr1;
	}

	public String getLaw_addr2() {
		return law_addr2;
	}

	public void setLaw_addr2(String law_addr2) {
		this.law_addr2 = law_addr2;
	}

	public String getLaw_zipcode() {
		return law_zipcode;
	}

	public void setLaw_zipcode(String law_zipcode) {
		this.law_zipcode = law_zipcode;
	}

}
