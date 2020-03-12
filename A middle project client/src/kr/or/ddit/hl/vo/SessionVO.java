package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class SessionVO implements Serializable{
	private String id;
	private String name;
	private int roleCode;
	private static SessionVO session = new SessionVO();

	private SessionVO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}

	public static SessionVO getInstance() {
		return session;
	}
}
