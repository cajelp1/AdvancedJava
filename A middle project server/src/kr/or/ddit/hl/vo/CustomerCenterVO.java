package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class CustomerCenterVO implements Serializable {
	private int no;
	private String cust_title;
	private String cust_content;
	private String cust_writer;
	private String cust_date;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCust_title() {
		return cust_title;
	}

	public void setCust_title(String cust_title) {
		this.cust_title = cust_title;
	}

	public String getCust_content() {
		return cust_content;
	}

	public void setCust_content(String cust_content) {
		this.cust_content = cust_content;
	}

	public String getCust_writer() {
		return cust_writer;
	}

	public void setCust_writer(String cust_writer) {
		this.cust_writer = cust_writer;
	}

	public String getCust_date() {
		return cust_date;
	}

	public void setCust_date(String cust_date) {
		this.cust_date = cust_date;
	}

}
