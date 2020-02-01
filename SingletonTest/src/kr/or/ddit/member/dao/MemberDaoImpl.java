package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import kr.or.ddit.member.MemberMain;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao {
	
	
	// log4j를 이용한 로그를 남기기 위해 로거 생성
	private static final Logger sqlLogger
		= Logger.getLogger("log4jexam.sql.Query");
	private static final Logger paramLogger
		= Logger.getLogger("log4jexam.sql.Parameter");
	private static final Logger resultLogger
		= Logger.getLogger(MemberDaoImpl.class);
	
	
	
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement prstm;
	private ResultSet rs;
	
	
	/**
	 * 자원반납 메서드
	 */
	private void disconnect() {
		if(rs!=null)try{ rs.close(); }catch(SQLException ee){}
		if(stmt!=null)try{ stmt.close(); }catch(SQLException ee){}
		if(prstm!=null)try{ prstm.close(); }catch(SQLException ee){}
		if(conn!=null)try{ conn.close(); }catch(SQLException ee){}
	}
	
	
	@Override
	public int insertMember(MemberVO mv) {
		
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into mymember (mem_id, mem_name, mem_tel, mem_addr) "+
						" values (?, ?, ?, ?)";
			
			sqlLogger.debug("쿼리 : "+sql);
			sqlLogger.warn("쿼리(워닝) : "+sql);
			
			prstm = conn.prepareStatement(sql);
			prstm.setString(1, mv.getMem_id());
			prstm.setString(2, mv.getMem_name());
			prstm.setString(3, mv.getMem_tel());
			prstm.setString(4, mv.getMem_addr());
			
			paramLogger.debug("파라미터 : ("+ mv.getMem_addr()+", "+
											mv.getMem_name()+", "+
											mv.getMem_tel()+", "+
											mv.getMem_addr());
			
			cnt = prstm.executeUpdate();
			
			resultLogger.warn("결과  : "+cnt);
			
		}catch(SQLException e) {System.out.println(mv.getMem_id() + "회원추가 실패 ---!!!");
								e.printStackTrace();
		}finally {disconnect();} //자원반납
		
		return cnt;
	}
	
	
	@Override
	public boolean getMember(String memId) {
		
		boolean chk = false;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select count(*) from mymember where mem_id = ?";
			
			prstm = conn.prepareStatement(sql);
			prstm.setString(1, memId);
			
			rs = prstm.executeQuery();
			
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
			if(cnt > 0) { chk = true;}
		}catch(SQLException e) {e.printStackTrace(); chk = false;}
		finally {disconnect();}
		
		return chk;
	}
	
	
	@Override
	public List<MemberVO> getAllMemberList() {

		List<MemberVO> memList = new ArrayList<>();
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select * from mymember";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				MemberVO mv = new MemberVO();
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_tel(rs.getString("mem_tel"));
				mv.setMem_addr(rs.getString("mem_addr"));
				
				memList.add(mv);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}finally {disconnect();} //자원반납
		
		return memList;
	}
	
	
	@Override
	public int updateMember(MemberVO mv) {
		
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "update mymember set "
					+ " mem_name = ?, "
					+ " mem_tel = ?, "
					+ " mem_addr = ? "
					+ " where mem_id = ?";
			
			prstm = conn.prepareStatement(sql);
			prstm.setString(1, mv.getMem_name());
			prstm.setString(2, mv.getMem_tel());
			prstm.setString(3, mv.getMem_addr());
			prstm.setString(4, mv.getMem_id());
			
			cnt = prstm.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {disconnect();}
		
		return cnt;
	}
	
	
	@Override
	public int deleteMember(String memId) {
		
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from mymember where mem_id = ?";
			
			prstm = conn.prepareStatement(sql);
			prstm.setString(1, memId);
			
			cnt = prstm.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {disconnect();}
		
		return cnt;
	}


	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		
		List<MemberVO> memList = new ArrayList<>();
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select * from mymember where 1=1";
			
			if(mv.getMem_id() != null && !mv.getMem_id().equals("")) {
				sql += " and mem_id = ?";						}
			if(mv.getMem_name() != null && !mv.getMem_name().equals("")) {
				sql += " and mem_name = ?";						}
			if(mv.getMem_tel() != null && !mv.getMem_tel().equals("")) {
				sql += " and mem_tel = ?";						}
			if(mv.getMem_addr() != null && !mv.getMem_addr().equals("")) {
				sql += " and mem_addr Like '%'|| ? ||'%'";		}
			
			prstm =  conn.prepareStatement(sql);
			int index = 1;
			
			if(mv.getMem_id() != null && !mv.getMem_id().equals("")) {
				prstm.setString(index++, mv.getMem_id());		}
			if(mv.getMem_name() != null && !mv.getMem_name().equals("")) {
				prstm.setString(index++, mv.getMem_name());		}
			if(mv.getMem_tel() != null && !mv.getMem_tel().equals("")) {
				prstm.setString(index++, mv.getMem_tel());		}
			if(mv.getMem_addr() != null && !mv.getMem_addr().equals("")) {
				prstm.setString(index++, mv.getMem_addr());		}
			
			rs = prstm.executeQuery();
			
			while(rs.next()) {
				MemberVO memVO = new MemberVO();
				memVO.setMem_id(rs.getString("mem_id"));
				memVO.setMem_name(rs.getString("mem_name"));
				memVO.setMem_tel(rs.getString("mem_tel"));
				memVO.setMem_addr(rs.getString("mem_addr"));
				
				memList.add(memVO);
			}
			
		}catch(SQLException e) {
			memList = null;
			e.printStackTrace();
		}finally {disconnect();}
		
		return memList;
	}
	
	
}
