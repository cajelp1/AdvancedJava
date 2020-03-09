package kr.or.ddit.mp.vo.chat;

import kr.or.ddit.mp.service.chat.ChatClient;

public class ChattingVO {
	
	private ChatClient client; // 클라이언트 객체
	private String nickName;   // 닉네임
	
	public ChattingVO(ChatClient client, String nickName) {
		super();
		this.client = client;
		this.nickName = nickName;
	}
	
	public ChatClient getClient() {
		return client;
	}
	public void setClient(ChatClient client) {
		this.client = client;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}
