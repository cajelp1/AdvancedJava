package kr.or.ddit.mp.dao.qnacomeatdeal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.eatdeal.EatqaVO;

public class QnacomEatdealDaoImpl implements IQnacomEatdealDao {
	private SqlMapClient smc;
	
	private static QnacomEatdealDaoImpl dao;
	
	private QnacomEatdealDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static QnacomEatdealDaoImpl getInstance() {
		if(dao == null) {
			dao = new QnacomEatdealDaoImpl();
		}
		return dao;	
	}

	@Override
	public List<EatqaVO> getAllQnaComeatdealList(String com_id) {
		ArrayList<EatqaVO> List = new ArrayList<EatqaVO>();
		try {
			List = (ArrayList<EatqaVO>) smc.queryForList("qnacomeatdeal.qnaAllList", com_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}

	@Override
	public List<EatqaVO> getNotQnaComeatdealList(String com_id) {
		ArrayList<EatqaVO> List = new ArrayList<EatqaVO>();
		try {
			List = (ArrayList<EatqaVO>) smc.queryForList("qnacomeatdeal.qnaNotList", com_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List;
	}

	@Override
	public int ansQna(EatqaVO vo) {
		int cnt = 0;
		try {
			cnt = smc.update("qnacomeatdeal.ansQna", vo);
			if(cnt > 0) {
				System.out.println("답변 성공");
			}else {
				System.out.println("답변 실패!");
			}
		}catch(SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	
//	public static void main(String[] args) {
//		EatqaVO vo = new EatqaVO();
//		QnacomEatdealDaoImpl dao = new QnacomEatdealDaoImpl();
//		String com_id = "366-45-90024";
//		ArrayList<EatqaVO> list = (ArrayList<EatqaVO>) dao.getNotQnaComeatdealList(com_id);
//		System.out.println(list.size());
//		vo.setEatqa_com("아이바티스 실험중");
//		vo.setEatqa_no("2");
//		int cnt = dao.ansQna(vo);
//	}

}
