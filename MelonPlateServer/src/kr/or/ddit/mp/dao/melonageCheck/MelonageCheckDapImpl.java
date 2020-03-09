package kr.or.ddit.mp.dao.melonageCheck;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.melonageCheck.MileageVO;

public class MelonageCheckDapImpl implements IMelonageCheckDao {

	private SqlMapClient smc;

	private static MelonageCheckDapImpl dao  = new MelonageCheckDapImpl();

	private MelonageCheckDapImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	public static MelonageCheckDapImpl getInstance() {
		if (dao == null) {
			dao = new MelonageCheckDapImpl();
		}
		return dao;
	}
	
	@Override
	public List<MileageVO> getAddUsedMelonage(MileageVO mvo) {
		ArrayList<MileageVO> addUsedMelonage = new ArrayList<MileageVO>();

		try {
			addUsedMelonage = (ArrayList<MileageVO>) smc.queryForList("getAddUsedMelonage",mvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return addUsedMelonage;
	}
	
	
	
	@Override
	public List<MileageVO> getAllMelonage(MileageVO mvo) {
		
		ArrayList<MileageVO> allMelonage = new ArrayList<MileageVO>();

		try {
			allMelonage = (ArrayList<MileageVO>) smc.queryForList("getAllMelonage",mvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allMelonage;
	}
	

}
