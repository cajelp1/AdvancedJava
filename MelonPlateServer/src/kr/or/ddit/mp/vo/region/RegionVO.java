package kr.or.ddit.mp.vo.region;

import java.io.Serializable;

public class RegionVO implements Serializable {

	private String reg_no;
	private String reg_sido;
	private String reg_dong;
	public RegionVO() {
		// TODO Auto-generated constructor stub
	}
	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}

	public String getReg_sido() {
		return reg_sido;
	}

	public void setReg_sido(String reg_sido) {
		this.reg_sido = reg_sido;
	}

	public String getReg_dong() {
		return reg_dong;
	}

	public void setReg_dong(String reg_dong) {
		this.reg_dong = reg_dong;
	}

	public RegionVO(String reg_no, String reg_sido, String reg_dong) {
		super();
		this.reg_no = reg_no;
		this.reg_sido = reg_sido;
		this.reg_dong = reg_dong;
	}

}
