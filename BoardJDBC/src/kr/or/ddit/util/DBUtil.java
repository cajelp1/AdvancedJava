package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	
	// ResourceBundle 객체를 선언한다
	static ResourceBundle bundle; 
	
	// ResourceBundle 객체를 실제로 생성한다
	static {
		
		// 리소스 폴더 중에 db라는 properties를 찾아서 내용을 읽어 ResourceBundle 객체를 만든다.
		bundle = ResourceBundle.getBundle("db");
		
		// ResourceBundle의 driver키를 이용하여 
		// OracleDriver의 클래스 정보를 읽어서 가상머신의 메모리에 탑재한다.
		try {
			Class.forName(bundle.getString("driver"));
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	// OracleDriver안의 DriverManager 클래스의 getConnection 메소드에
	// ResourceBundle의 url, user, pass키를 이용한 value를 넘겨주어 connection 객체를 생성한다
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("user"),
					bundle.getString("pass"));
		}catch(SQLException e) {
			System.out.println("DB연결 실패----------");
			e.printStackTrace();
			return null;
		}
	}
	
}

