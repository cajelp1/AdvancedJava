package kr.or.ddit.mp.vo.cs;

import java.io.Serializable;

public class ChatVO implements Serializable{

	private String chat_no;
	private String mem_no;
	private String chat_cont;
	private String chat_update;
	public ChatVO() {
		// TODO Auto-generated constructor stub
	}
	public ChatVO(String chat_no, String mem_no, String chat_cont, String chat_update) {
		super();
		this.chat_no = chat_no;
		this.mem_no = mem_no;
		this.chat_cont = chat_cont;
		this.chat_update = chat_update;
	}
	
	public String getChat_no() {
		return chat_no;
	}
	public void setChat_no(String chat_no) {
		this.chat_no = chat_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getChat_cont() {
		return chat_cont;
	}
	public void setChat_cont(String chat_cont) {
		this.chat_cont = chat_cont;
	}
	public String getChat_update() {
		return chat_update;
	}
	public void setChat_update(String chat_update) {
		this.chat_update = chat_update;
	}
	
	
}
