package kr.or.ddit.mp.vo.cs;

import java.io.Serializable;

public class QaVO implements Serializable{

	private String qa_no;
	private String qa_title;
	private String qa_cont;
	private String qa_com;
	private String qa_com_st;
	public QaVO() {
		// TODO Auto-generated constructor stub
	}
	public String getQa_no() {
		return qa_no;
	}
	public void setQa_no(String qa_no) {
		this.qa_no = qa_no;
	}
	public String getQa_title() {
		return qa_title;
	}
	public void setQa_title(String qa_title) {
		this.qa_title = qa_title;
	}
	public String getQa_cont() {
		return qa_cont;
	}
	public void setQa_cont(String qa_cont) {
		this.qa_cont = qa_cont;
	}
	public String getQa_com() {
		return qa_com;
	}
	public void setQa_com(String qa_com) {
		this.qa_com = qa_com;
	}
	public String getQa_com_st() {
		return qa_com_st;
	}
	public void setQa_com_st(String qa_com_st) {
		this.qa_com_st = qa_com_st;
	}
	
	public QaVO(String qa_no, String qa_title, String qa_cont, String qa_com, String qa_com_st) {
		super();
		this.qa_no = qa_no;
		this.qa_title = qa_title;
		this.qa_cont = qa_cont;
		this.qa_com = qa_com;
		this.qa_com_st = qa_com_st;
	}

		
	
	
	
}
