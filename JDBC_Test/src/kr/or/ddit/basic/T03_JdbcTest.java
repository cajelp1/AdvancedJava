package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
	lprod_id : 10, lprod_gu : N101, lrpod_nm : 농산물
	lprod_id : 20, lprod_gu : N102, lrpod_nm : 수산물
	lprod_id : 30, lprod_gu : N103, lrpod_nm : 축산물
 */

public class T03_JdbcTest {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement prstm = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe", 
					"PC20",
					"java");
			
		/*
			//Statement 객체를 이용한 추가 방법
			stmt = conn.createStatement();
			String sql ="insert into lprod (lprod_id, lprod_gu, lprod_nm)"
					+" values(10, 'N101', '농산물')";
			//select 문이 아니므로 executeUpdate()를 사용함.
			//executeUpdate()는 실행 성공한 레코드 수를 반환한다.
			int cnt = stmt.executeUpdate(sql);
			System.out.println("첫번째 반환값 : "+cnt);
			//위의 과정 반복
			
			//-----------------------------------
			sql ="insert into lprod (lprod_id, lprod_gu, lprod_nm)"
					+" values(20, 'N102', '수산물')";
			cnt = stmt.executeUpdate(sql);
			System.out.println("두번째 반환값 : "+cnt);
			//-----------------------------------
			sql ="insert into lprod (lprod_id, lprod_gu, lprod_nm)"
					+" values(30, 'N103', '축산물')";
			cnt = stmt.executeUpdate(sql);
			System.out.println("세번째 반환값 : "+cnt);
			
			System.out.println("반환 끝");
		*/
		
		/*
			// PreparedStatement 객체를 이용한 자료 추가 방법
			// SQL작성 시 데이터가 들어갈 자리에 물음표 (?)를 넣는다.
			String sql =" insert into lprod (lprod_id, lprod_gu, lprod_nm) "
					+" values(?, ?, ?)";	//와! 와일드카드!
			// PreparedStatement 객체를 생성할 때 SQL문을 넣어서 생성한다.
			prstm = conn.prepareStatement(sql);
			
			// 쿼리문의 물음표 자리에 들어갈 데이터를 세팅한다.
			// 형식: prstm.set자료형이름(물음표순번, 데이터);
			//				물음표 순번은 1번부터.
			prstm.setInt(1, 10);
			prstm.setString(2, "N101");
			prstm.setString(3, "농산물");
			int cnt = prstm.executeUpdate();
			System.out.println("첫번째 반환값 : "+cnt);
			// 아 뭐야 이것도 똑같이 해줘야함 ㅡㅡ
			
			prstm.setInt(1, 20);
			prstm.setString(2, "N102");
			prstm.setString(3, "수산물");
			cnt = prstm.executeUpdate();
			System.out.println("두번째 반환값 : "+cnt);
			
			prstm.setInt(1, 30);
			prstm.setString(2, "N103");
			prstm.setString(3, "축산물");
			cnt = prstm.executeUpdate();
			System.out.println("세번째 반환값 : "+cnt);
			
			System.out.println("반환 끝");
		*/	
			
		// 1월 13일
		// SQL inject 예제
			stmt = conn.createStatement();
			String lprod_gu = "' or 1=1 --";
			String sql2 = "select * from lprod where lprod_gu = '"+lprod_gu+"' and lprod_nm='축산물'";
			
			System.out.println("실행할 쿼리 : select * from lprod where lprod_gu = '"+lprod_gu+"' and lprod_nm='축산물'");
			
			rs = stmt.executeQuery(sql2);
			
			while(rs.next()) {
				System.out.println(rs.getInt("lprod_id")
						+"\t"+rs.getString(2)
						+"\t"+rs.getString("lprod_nm"));
			}
			
		//보안에 취약하다!
		
			String sql3 = "select * from lprod where lprod_gu = ? and lprod_nm='축산물'";
			
			prstm = conn.prepareStatement(sql3);
			prstm.setString(1, "' or 1=1 --");
					
			System.out.println("실행할 쿼리 : "+sql3);
			
			rs = prstm.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("lprod_id")
						+"\t"+rs.getString(2)
						+"\t"+rs.getString("lprod_nm"));
			}
			//된건지 안 된건지 모르게꾸만...
		
		}
		catch(ClassNotFoundException e) {e.printStackTrace();}
		catch(SQLException e) {e.printStackTrace();}
		finally {
			if(prstm != null)try {prstm.close();}catch(SQLException e) {}
			if(conn != null)try {conn.close();}catch(SQLException e) {}
			if(stmt != null)try {stmt.close();}catch(SQLException e) {}
			if(rs != null)try {rs.close();}catch(SQLException e) {}
		}
	}
}
