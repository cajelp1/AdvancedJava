package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class FilemanagerVO implements Serializable{
	private int file_no;
	private int no;
	private String file_path;
	private String file_name;
	private String file_upload_id;
	private String file_date;

	public int getFile_no() {
		return file_no;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getFile_upload_id() {
		return file_upload_id;
	}

	public void setFile_upload_id(String file_upload_id) {
		this.file_upload_id = file_upload_id;
	}

	public String getFile_date() {
		return file_date;
	}

	public void setFile_date(String file_date) {
		this.file_date = file_date;
	}

}
