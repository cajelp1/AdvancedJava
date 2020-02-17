package vo;

/**
 * 클라이언트의 정보를 담기위한 VO
 * @author PC-20
 *
 */
public class ClientVO {
	private String ip;		//ip주소
	private String name;	//채팅에서 쓰는 유저 이름
	private int port;		//접속하는 서버의 포트번호
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public ClientVO(String ip, int port, String name) {
		super();
		this.ip = ip;
		this.name = name;
		this.port = port;
	}
	
}
