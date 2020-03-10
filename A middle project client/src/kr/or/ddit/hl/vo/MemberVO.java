package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class MemberVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4474525627317280352L;
	
	private String mem_id      ;
	private String mem_password;
	private String mem_name    ;
	private String mem_nickname;
	private String mem_jumin_no;
	private String mem_email   ;
	private String mem_hp      ;
	private String mem_status  ;
	private String mem_date    ;
	private int mem_mileage    ;
	private int role_code      ;
	private String mem_addr1;
	private String mem_addr2;
	private String mem_zipcode;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_password() {
		return mem_password;
	}
	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMen_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}
	public String getMem_jumin_no() {
		return mem_jumin_no;
	}
	public void setMem_jumin_no(String mem_jumin_no) {
		this.mem_jumin_no = mem_jumin_no;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_hp() {
		return mem_hp;
	}
	public void setMem_hp(String mem_hp) {
		this.mem_hp = mem_hp;
	}
	public String getMem_status() {
		return mem_status;
	}
	public void setMem_status(String mem_status) {
		this.mem_status = mem_status;
	}
	public String getMem_date() {
		return mem_date;
	}
	public void setMem_date(String mem_date) {
		this.mem_date = mem_date;
	}
	public int getMem_mileage() {
		return mem_mileage;
	}
	public void setMem_mileage(int mem_mileage) {
		this.mem_mileage = mem_mileage;
	}
	public int getRole_code() {
		return role_code;
	}
	public void setRole_code(int role_code) {
		this.role_code = role_code;
	}
	public String getMem_addr1() {
		return mem_addr1;
	}
	public void setMem_addr1(String mem_addr1) {
		this.mem_addr1 = mem_addr1;
	}
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	public String getMem_zipcode() {
		return mem_zipcode;
	}
	public void setMem_zipcode(String mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
	}
	
}
