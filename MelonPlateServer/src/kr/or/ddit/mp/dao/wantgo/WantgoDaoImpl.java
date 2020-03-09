package kr.or.ddit.mp.dao.wantgo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.mypage.WantgoVO;

public class WantgoDaoImpl implements IWantgoDao {
	private SqlMapClient smc;
	
	private static WantgoDaoImpl dao;
	
	private WantgoDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	public static WantgoDaoImpl getInstance() {
		if(dao == null) {
			dao = new WantgoDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<WantgoVO> selectWantgo(WantgoVO wv) {
		ArrayList<WantgoVO> wantList = new ArrayList<WantgoVO>();
		try {
			wantList = (ArrayList<WantgoVO>) smc.queryForList("wantGo.selectWantgo", wv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wantList;
	}

	@Override
	public boolean isEmptyWantgo(WantgoVO wv) {
		
		boolean flag_rtn = false; 
		ArrayList<Integer> wantList = new ArrayList<>();
		try {
			wantList = (ArrayList<Integer>) smc.queryForList("wantGo.isEmptyWantgo", wv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(wantList.get(0) == 0) {
			flag_rtn = true;
			return flag_rtn;
		}
		return flag_rtn;
	}

	@Override
	public int deleteWantgo(WantgoVO wv) {
		int cnt = 0;
		try {
			cnt = smc.delete("wantGo.deleteWantgo", wv);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int insertWantgo(WantgoVO wv) {
		int cnt = 0;
		try {
			cnt = smc.update("wantGo.insertWantgo", wv);
		}catch(SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		
		WantgoVO vo = new WantgoVO();
		WantgoDaoImpl dao = new WantgoDaoImpl();
		
		vo.setMem_no("6");
		vo.setCom_name("시범용");
//		ArrayList<WantgoVO> list = (ArrayList<WantgoVO>) dao.selectWantgo(vo);
//		System.out.println(list.get(0).getCom_name());
//		boolean chk = dao.isEmptyWantgo(vo);
//		System.out.println(chk);
		
		vo.setCom_addr("dd");
		vo.setCom_id("2");
		vo.setWantgo_no("2");
		
		int cnt = 0;
		cnt = dao.deleteWantgo(vo);
		
		System.out.println("성공시:" + cnt);
		
	}
}
