package kr.or.ddit.mp.dao.eatdeal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mp.util.SqlMapClientFactory;
import kr.or.ddit.mp.vo.eatdeal.EatqaVO;

public class EatdealQADaoImpl implements IEatdealQADao{

	private SqlMapClient smc; //revservation_option.xml 연결
	
	//외부에서 객체를 생성하는 것을 막음
	public static EatdealQADaoImpl dao = new EatdealQADaoImpl(); 
	
	private EatdealQADaoImpl() { 
		smc = SqlMapClientFactory.getInstance();
	}

	//객체 생성 및 제공
	public static EatdealQADaoImpl getInstance() { 
		if(dao == null) {
			dao = new EatdealQADaoImpl();
		}
		return dao;
	}
	
	public static void main(String[] args) {
		
		EatqaVO vo = new EatqaVO();
		vo.setEat_no("9");
//		vo.setEatqa_no("3");
		
		ArrayList<EatqaVO> list = new ArrayList<>();
		list = (ArrayList<EatqaVO>) dao.selectQA("9");
		
		System.out.println(list.get(0).getEatqa_title()+" -> 글제목");
		System.out.println(list.get(0).getMem_nick()+" -> 작성자");
	}

	/**
	 * 1. 잇딜 게시판 전체 보기
	 */
	@Override
	public List<EatqaVO> selectQA(String eat_no) {
		
		ArrayList<EatqaVO> qaList = new ArrayList<EatqaVO>();
		
		try {
			qaList = (ArrayList<EatqaVO>) smc.queryForList("selectQA", eat_no);
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		return qaList;
	}

	/**
	 * 2. 잇딜 게시판 상세 보기
	 */
	@Override
	public List<EatqaVO> selectQAdetail(EatqaVO eatqa_no) {
		
		ArrayList<EatqaVO> qaList = new ArrayList<EatqaVO>();
		
		try {
			qaList = (ArrayList<EatqaVO>) smc.queryForList("selectQAdetail", eatqa_no);
		} catch (SQLException e) {
			System.out.println("에러네");
			e.printStackTrace();
		}
		return qaList;
	}

	/**
	 * 3. 잇딜 게시글 작성하기
	 */
	@Override
	public int insertQA(EatqaVO vo) {
		
		int cnt = 0;
		
		try {
			Object obj = smc.insert("insertQA", vo);
			
			if(obj == null) {
				cnt = 1;
			}else {
				
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}		
		return cnt;
	}

	

	
}
