package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class ReportVO implements Serializable{
	private Integer report_no ;
	private String report_id ;
	private String report_reason ;
	private String report_date ;
	private Integer review_no ;
	private String report_status ;
	
	public Integer getReport_no() {
		return report_no;
	}
	public void setReport_no(Integer report_no) {
		this.report_no = report_no;
	}
	public String getReport_id() {
		return report_id;
	}
	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	public String getReport_reason() {
		return report_reason;
	}
	public void setReport_reason(String report_reason) {
		this.report_reason = report_reason;
	}
	public String getReport_date() {
		return report_date;
	}
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	public Integer getReview_no() {
		return review_no;
	}
	public void setReview_no(Integer review_no) {
		this.review_no = review_no;
	}
	public String getReport_status() {
		return report_status;
	}
	public void setReport_status(String report_status) {
		this.report_status = report_status;
	}
	
	

}
