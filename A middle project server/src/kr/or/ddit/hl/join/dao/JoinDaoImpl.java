package kr.or.ddit.hl.join.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.hl.join.dao.JoinDaoImpl;
import kr.or.ddit.hl.vo.MemberVO;

public class JoinDaoImpl implements IJoinDao {
	
	private SqlMapClient smc;
	
	private static IJoinDao dao;
	
	private JoinDaoImpl() {
		
		try {
			
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
			
		}catch(IOException e){
			System.out.println("SqlMapClient 생성 실패!!!");
			e.printStackTrace();
		}
	}
	
	public static IJoinDao getInstance() {
		if (dao == null) {
			dao = new JoinDaoImpl();
		}
		return dao;
	}
	
	
	//아이디 중복 확인
	@Override
	public boolean selectId(String id) throws RemoteException {
		
		boolean result = false;
		
		try {
			String mem_id = (String)smc.queryForObject("join.selectId", id);
			if(mem_id == null) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//닉네임 중복 확인
	@Override
	public boolean selectNick(String id) throws RemoteException {
		
		boolean result = false;
		
		try {
			String mem_nick = (String)smc.queryForObject("join.selectNick", id);
			if(mem_nick == null) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//회원가입 완료
	@Override
	public boolean insertMember(MemberVO mv) throws RemoteException {
		
		boolean result = false;
		
		try {
			String res = (String)smc.insert("join.insertMember", mv);
			if(res != null) {
				result = true;
			}
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
}
