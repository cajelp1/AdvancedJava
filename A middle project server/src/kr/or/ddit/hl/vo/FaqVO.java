package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class FaqVO implements Serializable{
	private int faq_no;
	private String faq_question_no;
	private String faq_answer_no;
	private String faq_content;
	private String faq_date;

	public int getFaq_no() {
		return faq_no;
	}

	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}

	public String getFaq_question_no() {
		return faq_question_no;
	}

	public void setFaq_question_no(String faq_question_no) {
		this.faq_question_no = faq_question_no;
	}

	public String getFaq_answer_no() {
		return faq_answer_no;
	}

	public void setFaq_answer_no(String faq_answer_no) {
		this.faq_answer_no = faq_answer_no;
	}

	public String getFaq_content() {
		return faq_content;
	}

	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}

	public String getFaq_date() {
		return faq_date;
	}

	public void setFaq_date(String faq_date) {
		this.faq_date = faq_date;
	}

}
