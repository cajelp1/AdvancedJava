package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class LawfrimVO implements Serializable {
	private String lawfirm_name ;
	private String lawfirm_representative ;
	private String lawfirm_date;
	public String getLawfirm_name() {
		return lawfirm_name;
	}
	public void setLawfirm_name(String lawfirm_name) {
		this.lawfirm_name = lawfirm_name;
	}
	public String getLawfirm_representative() {
		return lawfirm_representative;
	}
	public void setLawfirm_representative(String lawfirm_representative) {
		this.lawfirm_representative = lawfirm_representative;
	}
	public String getLawfirm_date() {
		return lawfirm_date;
	}
	public void setLawfirm_date(String lawfirm_date) {
		this.lawfirm_date = lawfirm_date;
	}
	
}
