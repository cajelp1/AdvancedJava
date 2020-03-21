package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class ReviewVO implements Serializable{
	private Integer review_no;
	private String review_title;
	private String review_content;
	private String review_writer;
	private String review_writer_id;
	private Integer review_grade;
	private String review_date;
	private String review_deleteYN;
	private Integer res_no;
	
	//평점을 스트링타입에도 저장할 변수
	private String review_grade_st;
	
	
	public Integer getReview_no() {
		return review_no;
	}
	public void setReview_no(Integer review_no) {
		this.review_no = review_no;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public String getReview_writer() {
		return review_writer;
	}
	public void setReview_writer(String review_writer) {
		this.review_writer = review_writer;
	}
	public String getReview_writer_id() {
		return review_writer_id;
	}
	public void setReview_writer_id(String review_writer_id) {
		this.review_writer_id = review_writer_id;
	}
	public Integer getReview_grade() {
		return review_grade;
	}
	public void setReview_grade(Integer review_grade) {
		this.review_grade = review_grade;
	}
	public String getReview_date() {
		return review_date;
	}
	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}
	public String getReview_deleteYN() {
		return review_deleteYN;
	}
	public void setReview_deleteYN(String review_deleteYN) {
		this.review_deleteYN = review_deleteYN;
	}
	public Integer getRes_no() {
		return res_no;
	}
	public void setRes_no(Integer res_no) {
		this.res_no = res_no;
	}
	public String getReview_grade_st() {
		return review_grade_st;
	}
	public void setReview_grade_st(String review_grade_st) {
		this.review_grade_st = review_grade_st;
	}
	
}
