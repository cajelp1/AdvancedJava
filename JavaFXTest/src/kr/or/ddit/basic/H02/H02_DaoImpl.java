package kr.or.ddit.basic.H02;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class H02_DaoImpl implements H02_Dao {
	
	private static H02_DaoImpl instance;
	
	private SqlMapClient smc;

	public static H02_DaoImpl getInstance() {
		if(instance == null) {
			instance = new H02_DaoImpl();
		}
		return instance;
	}
	
	private H02_DaoImpl() {
		
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		}catch(IOException e) {
			System.out.println("SqlMapClinet 생성실패!!!");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<H02_ZipVO> searchDong(String txt) {
		List<H02_ZipVO> list = new ArrayList<>();
		
		try {
			
			list = smc.queryForList("H02_SqlMap.searchDong", txt);
			
		}catch(SQLException e) {
			System.out.println("Sql 쿼리 실행 실패!");
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<H02_ZipVO> searchZipcode(String txt) {
		List<H02_ZipVO> list = new ArrayList<>();
		
		try {
			
			list = smc.queryForList("H02_SqlMap.searchZipcode", txt);
			
		}catch(SQLException e) {
			System.out.println("Sql 쿼리 실행 실패!");
			e.printStackTrace();
		}
		
		return list;
	}
}
