package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class QnaBoardVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8787147087972785086L;
	
	private Integer no                   ;
	private String qna_title         ;
	private String qna_content       ;
	private String qna_writer        ;
	private String qna_secret_yn     ;
	private String qna_writer_id	 ;
	private String qna_delete_yn     ;
	private String qna_date          ;
	private int qna_group            ;
	
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public String getQna_writer() {
		return qna_writer;
	}
	public void setQna_writer(String qna_writer) {
		this.qna_writer = qna_writer;
	}
	public String getQna_secret_yn() {
		return qna_secret_yn;
	}
	public void setQna_secret_yn(String qna_secret_yn) {
		this.qna_secret_yn = qna_secret_yn;
	}
	public String getQna_writer_id() {
		return qna_writer_id;
	}
	public void setQna_writer_id(String qna_writer_id) {
		this.qna_writer_id = qna_writer_id;
	}
	public String getQna_delete_yn() {
		return qna_delete_yn;
	}
	public void setQna_delete_yn(String qna_delete_yn) {
		this.qna_delete_yn = qna_delete_yn;
	}
	public String getQna_date() {
		return qna_date;
	}
	public void setQna_date(String qna_date) {
		this.qna_date = qna_date;
	}
	public int getQna_group() {
		return qna_group;
	}
	public void setQna_group(int qna_group) {
		this.qna_group = qna_group;
	}
	
}
