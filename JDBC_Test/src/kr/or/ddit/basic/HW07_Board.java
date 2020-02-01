package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;

/*

위의 테이블을 작성하고 게시판을 관리하는
다음 기능들을 구현하시오.

기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
 
------------------------------------------------------------

게시판 테이블 구조 및 시퀀스

create table jdbc_board(
    board_no number not null,  -- 번호(자동증가)
    board_title varchar2(100) not null, -- 제목
    board_writer varchar2(50) not null, -- 작성자
    board_date date not null,   -- 작성날짜
    board_content clob,     -- 내용
    constraint pk_jdbc_board primary key (board_no)
);
create sequence board_seq
    start with 1   -- 시작번호
    increment by 1; -- 증가값
		
----------------------------------------------------------

// 시퀀스의 다음 값 구하기
//  시퀀스이름.nextVal


 */

public class HW07_Board {
	

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner sc = new Scanner(System.in); 
	
	public static void main(String[] args) {
		HW07_Board board = new HW07_Board();
		board.start();
	}
	
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체 목록 출력");
		System.out.println("  2. 새 글 작성");
		System.out.println("  3. 글 수정");
		System.out.println("  4. 글 삭제");
		System.out.println("  5. 글 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	public void start(){
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = sc.nextInt(); // 메뉴번호 입력받기
			sc.nextLine();
			switch(choice){
				case 1 :  // 목록 출력
					boardList();
					break;
				case 2 :  // 글 작성
					writePost();
					break;
				case 3 :  // 글 수정
					modifyPost();
					break;
				case 4 :  // 글 삭제
					deletePost();
					break;
				case 5 :  // 글 검색
					searchPost();
					break;
				case 6 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=6);
	}
	
	/**
	 * 글 작성
	 */
	private void writePost() {
		System.out.println();
		sc.nextLine();
		System.out.println("글 제목을 적어주세요 ");
		String title = sc.nextLine();
		System.out.println("글 작성자를 적어주세요 ");
		String writer = sc.nextLine();
		System.out.println("글 내용을 적어주세요 ");
		String content = sc.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "insert into jdbc_board (board_no, board_title, board_writer, board_date, board_content) "
					+ "values ( board_seq.nextVal , ? , ? , sysdate , ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			
			int check = pstmt.executeUpdate();
			if(check > 0 ) {System.out.println("게시글 작성이 완료되었습니다 . . .");}
			else {System.out.println("!ㅡㅡ 게시글 작성에 실패했습니다");}
			
		}catch(SQLException e) {
			System.out.println("!ㅡㅡ 게시글 작성에 실패했습니다");
			e.printStackTrace();
		}finally {disconnect();}
	}
	
	/**
	 * 글 수정
	 */
	private void modifyPost() {
		System.out.println();
		sc.nextLine();
		System.out.print("수정할 글의 게시번호를 적어주세요 : ");
		int boardno = sc.nextInt();
		
		try {
			conn = DBUtil2.getConnection();
			
			String sql = "select * from jdbc_baord where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardno);
			rs = pstmt.executeQuery();
			
			int count = 0;
			while(rs.next()) {count++;}
			if(count==0) {System.out.println("!ㅡㅡ "+boardno+"번 게시글을 찾을 수 없습니다."); return;}
			
			System.out.println();
			sc.nextLine();
			System.out.println("수정할 글의 제목을 적어주세요 ");
			String title = sc.nextLine();
			System.out.println("수정할 글의 작성자를 적어주세요 ");
			String writer = sc.nextLine();
			System.out.println("수정할 글의 내용을 적어주세요 ");
			String content = sc.nextLine();
			
			sql = "update jdbc_board set "
					+ " board_title = '?', "
					+ " board_writer = '?', "
					+ " board_date = sysdate, "
					+ " board_content = '?' "
					+ " where board_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			pstmt.setInt(4, boardno);
			
			int check = pstmt.executeUpdate();
			if(check>0) {
				System.out.println("게시글 수정이 완료되었습니다 . . .");
			}else {System.out.println("!ㅡㅡ "+boardno+"번 게시글 수정에 실패했습니다.");}
			
		}catch(SQLException e) {
			System.out.println("!ㅡㅡ 수정할 게시글을 찾을 수 없습니다.");
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	/**
	 * 글 삭제
	 */
	private void deletePost() {
		System.out.println();
		sc.nextLine();
		System.out.print("삭제할 글의 게시번호를 적어주세요 : ");
		int boardno = sc.nextInt();
		
		try {
			conn = DBUtil2.getConnection();
			
			String sql = "delete from jdbc_board where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardno);
			int check = pstmt.executeUpdate();
			
			if(check > 0) {
				System.out.println(boardno+"번 게시글이 삭제되었습니다 . . .");
			}else {
				System.out.println("!ㅡㅡ "+boardno+"번 게시글을 찾을 수 없습니다.");
			}
			
		}catch(SQLException e) {
			System.out.println("!ㅡㅡ 삭제할 게시글을 찾을 수 없습니다.");
			e.printStackTrace();
		}finally {disconnect();}
	}
	
	/**
	 * 목록 출력
	 */
	private void boardList() {
		
		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println("번호\t제목\t작성자\t작성날짜\t\t내용"); 
		System.out.println("----------------------------------------------------");
		
		try {
			conn = DBUtil2.getConnection();
			
			String sql = "select * from jdbc_board";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+
									rs.getString(2)+"\t"+
									rs.getString(3)+"\t"+
									rs.getDate(4)+"\t"+
									rs.getString(5)+"\t");
			}
			System.out.println("----------------------------------------------------");
			System.out.println("출력 완료 . . .");
			
		}catch(SQLException e) {
			System.out.println("!ㅡㅡ 목록을 가져오지 못했습니다 .");
			e.printStackTrace();
		}finally {disconnect();}
	}
	
	/**
	 * 글 검색
	 */
	private void searchPost() {
		System.out.println();
		System.out.println("검색할 글의 작성자 이름을 적어주세요 : ");
		String name = sc.nextLine().replace(" ", "");
		
		try {
			conn = DBUtil2.getConnection();
			
			String sql = "select * from jdbc_board where board_writer like ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+
									rs.getString(2)+"\t"+
									rs.getString(3)+"\t"+
									rs.getDate(4)+"\t"+
									rs.getString(5)+"\t");
			}
			System.out.println("-----------------------------------");
			System.out.println("출력 완료 . . .");
			
		}catch(SQLException e) {
			System.out.println("!ㅡㅡ 목록을 가져오지 못했습니다 .");
			e.printStackTrace();
		}finally {disconnect();}
	}
	
	/**
	 * 작성자 이름을 이용하여 게시글이 있는지 알려주는 메서드
	 * @param memId
	 * @return
	 */
	public boolean getPost(String name) {
		
		boolean chk = false;
		try {
			conn = DBUtil2.getConnection();
			String sql = "select count(*) from jdbc_board where board_writer like ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
			if(cnt > 0) { chk = true;}
		}catch(SQLException e) {e.printStackTrace(); chk = false;}
		finally {disconnect();}
		return chk;
	}
	
	/**
	 * 자원반납 메서드
	 */
	private void disconnect() {
		if(rs!=null)try{ rs.close(); }catch(SQLException ee){}
		if(stmt!=null)try{ stmt.close(); }catch(SQLException ee){}
		if(pstmt!=null)try{ pstmt.close(); }catch(SQLException ee){}
		if(conn!=null)try{ conn.close(); }catch(SQLException ee){}
	}
	
}
