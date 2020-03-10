package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class LawyerProfileFileManagerVO implements Serializable{
	private int law_file_no;
	private String file_path;
	private String file_name;
	private String file_date;
	private String law_id;
	private String law_deleteYN;
	private String file_delete_date;

	public int getLaw_file_no() {
		return law_file_no;
	}

	public void setLaw_file_no(int law_file_no) {
		this.law_file_no = law_file_no;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_date() {
		return file_date;
	}

	public void setFile_date(String file_date) {
		this.file_date = file_date;
	}

	public String getLaw_id() {
		return law_id;
	}

	public void setLaw_id(String law_id) {
		this.law_id = law_id;
	}

	public String getLaw_deleteYN() {
		return law_deleteYN;
	}

	public void setLaw_deleteYN(String law_deleteYN) {
		this.law_deleteYN = law_deleteYN;
	}

	public String getFile_delete_date() {
		return file_delete_date;
	}

	public void setFile_delete_date(String file_delete_date) {
		this.file_delete_date = file_delete_date;
	}

}
