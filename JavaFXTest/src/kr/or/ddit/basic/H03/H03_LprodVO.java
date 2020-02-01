package kr.or.ddit.basic.H03;

public class H03_LprodVO {
	
	private int lprod_id;
	private String lprod_gu;
	private String lprod_nm;
	
	public H03_LprodVO() {}
	
	public H03_LprodVO(int lprod_id, String lprod_gu, String lrpod_nm) {
		super();
		this.lprod_id = lprod_id;
		this.lprod_gu = lprod_gu;
		this.lprod_nm = lrpod_nm;
	}
	public int getLprod_id() {
		return lprod_id;
	}
	public void setLprod_id(int lprod_id) {
		this.lprod_id = lprod_id;
	}
	public String getLprod_gu() {
		return lprod_gu;
	}
	public void setLprod_gu(String lprod_gu) {
		this.lprod_gu = lprod_gu;
	}
	public String getLprod_nm() {
		return lprod_nm;
	}
	public void setLprod_nm(String lrpod_nm) {
		this.lprod_nm = lrpod_nm;
	}
	
}
