package kr.or.ddit.mp.vo.notice;

import java.io.Serializable;

public class NoticeVO implements Serializable{
	private String notice_no;
	private String notice_title;
	private String notice_date;
	private String notice_cont;
	public NoticeVO() {
		// TODO Auto-generated constructor stub
	}
	public NoticeVO(String notice_no, String notice_title, String notice_date, String notice_cont) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_date = notice_date;
		this.notice_cont = notice_cont;
	}
	public String getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	public String getNotice_cont() {
		return notice_cont;
	}
	public void setNotice_cont(String notice_cont) {
		this.notice_cont = notice_cont;
	}
}
