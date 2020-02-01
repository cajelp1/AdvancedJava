package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HW06_hotelDB {
	
	private Scanner sc;
	
	public HW06_hotelDB() {
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		
		System.out.println();
		System.out.println("************************");
		System.out.println("          호텔 문을 열었습니다.");
		System.out.println("************************");
		
		new HW06_hotelDB().work(); 
	}
	
	private void work() {
		
		int menu;
		
		do {
		System.out.println();
		System.out.println("**************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인.  2.체크아웃.  3.객실상태.  4.업무종료");
		System.out.println("**************************************");
		System.out.print("메뉴선택 : ");
		
		menu = sc.nextInt();
		
			switch(menu){
				case 1 : addOnServer();
					break;
				case 2 : removeFromServer();
					break;
				case 3 : checkServer();
					break;
				case 4 : 
					System.out.println();
					System.out.println("************************");
					System.out.println("          호텔 문을 닫았습니다.");
					System.out.println("************************");
					return;
				default :
					System.out.println("잘못 입력했습니다. 다시입력하세요.");
			}
		}while(true);
	}
/*

create table hotel_mng (
    room_num number not null,  -- 방번호
    guest_name varchar2(10) not null -- 투숙객 이름
	constraint pk_room primary key(room_num)
);

 */
	
	/////////////////////////////////////////////////////////////////////////
	
	private void addOnServer() {
		
		System.out.println();
		System.out.println("어느 방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 : ");
		int roomno = sc.nextInt();
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe", 
					"PC20",
					"java");
			
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO hotel_mng (room_num, guest_name) VALUES ("
					+ roomno+ ",'"+name+"')";
			int check = stmt.executeUpdate(sql);
			if(check>0) {
				System.out.println("체크인이 완료되었습니다.");
				System.out.println();
			}else {
				System.out.println("해당 객실에 이미 투숙객이 있습니다.");
				System.out.println();
			}
			
		}catch(ClassNotFoundException e) {e.printStackTrace();}
		catch(SQLException e) {e.printStackTrace();}
		finally {
			if(stmt != null)try {stmt.close();}catch(SQLException e) {}
			if(conn != null)try {conn.close();}catch(SQLException e) {}
			if(rn != null)try {rn.close();}catch(SQLException e) {}
		}
	}
	
	private void removeFromServer() {
		
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 : ");
		int roomno = sc.nextInt();
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe", 
					"PC20",
					"java");
			
			stmt = conn.createStatement();
			
			String sql = "DELETE FROM hotel_mng WHERE room_num = "+roomno;
			int check = stmt.executeUpdate(sql);
			if(check>0) {
				System.out.println("체크아웃이 완료되었습니다.");
				System.out.println();
			}else {
				System.out.println("해당 객실에 투숙객이 없습니다.");
				System.out.println();
			}
			
		}catch(ClassNotFoundException e) {e.printStackTrace();}
		catch(SQLException e) {e.printStackTrace();}
		finally {
			if(stmt != null)try {stmt.close();}catch(SQLException e) {}
			if(conn != null)try {conn.close();}catch(SQLException e) {}
			if(rn != null)try {rn.close();}catch(SQLException e) {}
		}
	}
	
	private void checkServer() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe", 
					"PC20",
					"java");
			
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM hotel_mng ORDER BY room_num";
			rs = stmt.executeQuery(sql);
			String temp = "";
			
			while(rs.next()) {
				temp = "방번호 : "+rs.getInt("room_num")+
						"\t 투숙객 : "+rs.getString("guest_name");
				System.out.println(temp);
			}
			if("".equals(temp)) {System.out.println("투숙객이 없습니다");}
			
//			if(rs == null) {System.out.println("투숙객이 없습니다");}
//			else {
//				while(rs.next()) {
//					System.out.println(
//							"방번호 : "+rs.getInt("room_num")+
//							"\t 투숙객 : "+rs.getString("guest_name"));
//				}
//			}
			
		}catch(ClassNotFoundException e) {e.printStackTrace();}
		catch(SQLException e) {e.printStackTrace();}
		finally {
			if(stmt != null)try {stmt.close();}catch(SQLException e) {}
			if(conn != null)try {conn.close();}catch(SQLException e) {}
			if(rs != null)try {rs.close();}catch(SQLException e) {}
		}
	}
	
}
