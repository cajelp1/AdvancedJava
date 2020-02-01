package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
	LPROD 테이블에 새로운 데이터를 추가하기
	
	lprod_gu와 lprod_nm은 직접 입력받아서 처리하고
	lprod_id는 현재의 lprod_id중 제일 큰 값보다 1 증가된 값으로 한다.
	(기타사항 : lprod_gu도 중복되는지 검사한다.)
	
 */

public class T04_JdbcTest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("추가하실 lprod_gu 값을 입력해주세요 -");
		String guVal = sc.nextLine();
		System.out.println("추가하실 lprod_nm 값을 입력해주세요 -");
		String nmVal = sc.nextLine();
		
		

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		
		try {
		/*
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","PC20", "java");
		*/
		//DBUtil을 만들고 난 후
			conn = DBUtil.getConnection(); //conn 객체를 자동으로 만들어준다.
			
			stmt = conn.createStatement();
			
			String sql = "select * from lprod where lprod_gu = '"+guVal+"'";
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {System.out.println("lprod_gu값이 중복되어 추가할 수 없습니다.");}
			else {
				
				sql = "select MAX(lprod_id) id from lprod";
				rs2 = stmt.executeQuery(sql);
				
				rs2.next();
				System.out.println(rs2.getInt(1));
				
				String sql2 = "insert into lprod (lprod_id, lprod_gu, lprod_nm) values ("+
						+(rs2.getInt(1)+1)+" , '" +guVal+ "' , '" +nmVal+ "'";
				stmt.executeUpdate(sql2);
				
				System.out.println("추가된 후의 값은 다음과 같습니다.");
			
				// 으ㅔㅔㅔㅔㅔㅔㅔ 몰라ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ
			}
			
			
			
		}//catch(ClassNotFoundException e) {e.printStackTrace();}
		catch(SQLException e) {e.printStackTrace();}
		finally {
			if(conn != null)try {conn.close();}catch(SQLException e) {}
			if(stmt != null)try {stmt.close();}catch(SQLException e) {}
			if(rs != null)try {rs.close();}catch(SQLException e) {}
			if(rs2 != null)try {rs2.close();}catch(SQLException e) {}
		}
		
		
		
	}
	
}
