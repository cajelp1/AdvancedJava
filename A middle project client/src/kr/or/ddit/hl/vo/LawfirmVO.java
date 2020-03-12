package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class LawfirmVO implements Serializable {
	private String lawfirm_name ;
	private String lawfirm_code ;
	private String lawfirm_date;
	
	public String getLawfirm_name() {
		return lawfirm_name;
	}
	public void setLawfirm_name(String lawfirm_name) {
		this.lawfirm_name = lawfirm_name;
	}
	public String getLawfirm_code() {
		return lawfirm_code;
	}
	public void setLawfirm_code(String lawfirm_code) {
		this.lawfirm_code = lawfirm_code;
	}
	public String getLawfirm_date() {
		return lawfirm_date;
	}
	public void setLawfirm_date(String lawfirm_date) {
		this.lawfirm_date = lawfirm_date;
	}
	
}
