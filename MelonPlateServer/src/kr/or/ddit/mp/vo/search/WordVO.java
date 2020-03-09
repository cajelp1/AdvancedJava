package kr.or.ddit.mp.vo.search;

import java.io.Serializable;

public class WordVO implements Serializable {
	private String his_no;
	private String mem_no;
	private String word_sc;
	private String word_date;
	public WordVO() {
		// TODO Auto-generated constructor stub
	}
	public WordVO(String his_no, String mem_no, String word_sc, String word_date) {
		super();
		this.his_no = his_no;
		this.mem_no = mem_no;
		this.word_sc = word_sc;
		this.word_date = word_date;
	}

	public String getHis_no() {
		return his_no;
	}

	public void setHis_no(String his_no) {
		this.his_no = his_no;
	}

	public String getMem_no() {
		return mem_no;
	}

	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}

	public String getWord_sc() {
		return word_sc;
	}

	public void setWord_sc(String word_sc) {
		this.word_sc = word_sc;
	}

	public String getWord_date() {
		return word_date;
	}

	public void setWord_date(String word_date) {
		this.word_date = word_date;
	}
	
	
}
