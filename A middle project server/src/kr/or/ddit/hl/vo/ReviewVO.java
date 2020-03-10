package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class ReviewVO implements Serializable{
	private int review_no;
	private String review_title;
	private String review_content;
	private String review_writer;
	private int review_grade;
	private String review_date;
	private String review_deleteYN;

	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
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

	public int getReview_grade() {
		return review_grade;
	}

	public void setReview_grade(int review_grade) {
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
}
