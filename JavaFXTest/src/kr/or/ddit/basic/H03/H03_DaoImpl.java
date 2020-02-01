package kr.or.ddit.basic.H03;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class H03_DaoImpl implements H03_Dao {
	
	public static H03_DaoImpl instance;

	private SqlMapClient smc;
	
	private H03_DaoImpl() {
		
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
	
	public static H03_DaoImpl getInstance() {
		if(instance == null) {
			instance = new H03_DaoImpl();
		}
		return instance;
	}

	@Override
	public List<H03_LprodVO> getCombo1() {
		List<H03_LprodVO> list = new ArrayList<>();
		
		try {
			
			list= smc.queryForList("H03_SqlMap.getCombo1");
			
		}catch(SQLException e) {
			System.out.println("보드 목록 가져오기 실패 !!!");
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<H03_ProdVO> getCombo2(String name) {
		List<H03_ProdVO> list = new ArrayList<>();
		
		try {
			
			list= smc.queryForList("H03_SqlMap.getCombo2", name);
			
		}catch(SQLException e) {
			System.out.println("보드 목록 가져오기 실패 !!!");
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<H03_ProdVO> getRealVO(String prod_id) {
		List<H03_ProdVO> list = new ArrayList<>();
		
		try {
			
			list= smc.queryForList("H03_SqlMap.getRealVO", prod_id);
			
		}catch(SQLException e) {
			System.out.println("보드 목록 가져오기 실패 !!!");
			e.printStackTrace();
		}
		
		return list;
	}

	
	
}
