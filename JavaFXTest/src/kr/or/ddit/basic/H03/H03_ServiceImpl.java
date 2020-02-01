package kr.or.ddit.basic.H03;

import java.util.ArrayList;
import java.util.List;

public class H03_ServiceImpl implements H03_Service {
	
	public static H03_ServiceImpl instance;
	
	private H03_ServiceImpl() {}
	
	public static H03_ServiceImpl getInstance() {
		if(instance == null) {
			instance = new H03_ServiceImpl();
		}
		return instance;
	}
	
	H03_Dao dao = H03_DaoImpl.getInstance();

	@Override
	public List<H03_LprodVO> getCombo1() {
		List<H03_LprodVO> list = dao.getCombo1();
		return list;
	}

	@Override
	public List<H03_ProdVO> getCombo2(String name) {
		List<H03_ProdVO> list = dao.getCombo2(name);
		return list;
	}

	@Override
	public List<H03_ProdVO> getRealVO(String prod_id) {
		List<H03_ProdVO> list = dao.getRealVO(prod_id);
		return list;
	}
	
	
	
}
