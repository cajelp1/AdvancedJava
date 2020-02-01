package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	문제1) 사용자로부터 lprod_id값을 입력받아 입력한 값보다 lprod_id가 큰 자료들을 출력하시오.
	문제2) lprod_id값을 2개 입력받아 두 값 중 작은 값부터 큰 값 사이의 자료를 출력하시오
 */

public class T02_JdbcTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("lprod_id값을 입력해주세요. 입력한 값보다 id가 큰 자료를 출력합니다.");
		System.out.print("입력하기 : ");
		int lId1 = sc.nextInt(); //sql1 에 들어갈 값
		System.out.println();
		System.out.println("lprod_id값을 두개 입력해주세요. 두 값 사이의 자료를 출력합니다.");
		System.out.println("입력하기 : ");
		int lId2 = sc.nextInt();
		int lId3 = sc.nextInt();
		
		if(lId2 > lId3) {int tmp = lId3; ;lId3=lId2; lId2=tmp;}
		
		System.out.println(lId1+ lId2+ lId3);
		
		Connection cn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		try {
			//드라이브찾기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//커넥션 만들기
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "PC20";
			String password = "java";
			cn = DriverManager.getConnection(url, userId, password);
			
			//스테이트먼트 만들기
			stmt = cn.createStatement();
			
			//sql쿼리 만들기
			String sql1 = "SELECT * FROM lprod WHERE lprod_id>"+lId1;
			String sql2 = "SELECT * FROM lprod WHERE lprod_id "
					+ "BETWEEN "+lId2+" AND "+lId3;
			
			//첫번째 쿼리 날리고 결과 출력
			rs = stmt.executeQuery(sql1);
			System.out.println("------------------------------------");
			System.out.println("첫번째 결과 출력 : ");
			while(rs.next()) {
				System.out.println(rs.getInt("lprod_id")
						+"\t"+rs.getString(2)
						+"\t"+rs.getString("lprod_nm"));
			}
			System.out.println("-------------------------------------");
			
			//두번째 쿼리 날리고 결과 출력
			rs2 = stmt.executeQuery(sql2);
			System.out.println("------------------------------------");
			System.out.println("두번째 결과 출력 : ");
			while(rs2.next()) {
				System.out.println(rs2.getInt("lprod_id")
						+"\t"+rs2.getString(2)
						+"\t"+rs2.getString("lprod_nm"));
			}
			System.out.println("-------------------------------------");
			
			
			
		}catch(ClassNotFoundException e) {e.printStackTrace();}
		catch(SQLException e) {e.printStackTrace();}
		finally {
			if(cn != null)try {cn.close();}catch(SQLException e) {}
			if(stmt != null)try {stmt.close();}catch(SQLException e) {}
			if(rs != null)try {rs.close();}catch(SQLException e) {}
			if(rs2 != null)try {rs2.close();}catch(SQLException e) {}
		}
		
	}
	
}
