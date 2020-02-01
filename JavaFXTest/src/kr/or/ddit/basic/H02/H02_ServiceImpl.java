package kr.or.ddit.basic.H02;

import java.util.List;

public class H02_ServiceImpl implements H02_Service {
	
	private static H02_ServiceImpl instance;
	
	private H02_ServiceImpl() {}
	
	public static H02_ServiceImpl getInstance() {
		if(instance == null) {
			instance = new H02_ServiceImpl();
		}
		return instance;
	}
	
	H02_Dao dao = H02_DaoImpl.getInstance();

	@Override
	public List<H02_ZipVO> searchDong(String txt) {
		List<H02_ZipVO> list = dao.searchDong(txt);
		return list;
	}

	@Override
	public List<H02_ZipVO> searchZipcode(String txt) {
		List<H02_ZipVO> list = dao.searchZipcode(txt);
		return list;
	}
	
	
}
