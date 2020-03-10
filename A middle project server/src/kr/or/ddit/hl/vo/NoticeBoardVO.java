package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class NoticeBoardVO implements Serializable{
	private int no;
	private String not_title;
	private String not_content;
	private String not_writer;
	private String not_date;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getNot_title() {
		return not_title;
	}

	public void setNot_title(String not_title) {
		this.not_title = not_title;
	}

	public String getNot_content() {
		return not_content;
	}

	public void setNot_content(String not_content) {
		this.not_content = not_content;
	}

	public String getNot_writer() {
		return not_writer;
	}

	public void setNot_writer(String not_writer) {
		this.not_writer = not_writer;
	}

	public String getNot_date() {
		return not_date;
	}

	public void setNot_date(String not_date) {
		this.not_date = not_date;
	}

}
