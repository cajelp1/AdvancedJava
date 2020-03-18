package kr.or.ddit.hl.dao.qna;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.hl.util.SqlMapClientFactory;
import kr.or.ddit.hl.vo.QnaBoardVO;

public class QnaDaoImpl implements IQnaDao {
	
	private SqlMapClient smc;
	private static IQnaDao dao;
	
	private QnaDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IQnaDao getInstance() {
		if(dao == null) {
			dao = new QnaDaoImpl();
		}
		return dao;
	}
	
	
	
	//Qna 글 추가
	//성공하면 seq 리턴, 실패하면 0 리턴
	@Override
	public boolean insertQna(QnaBoardVO qna) {
		
		boolean result = false;
		
		try {
			int res = (Integer)smc.insert("qna.insertQna", qna);
			if(res > 0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//Qna 답글추가
	@Override
	public boolean answerQna(QnaBoardVO qna) {
		
		boolean result = false;
		
		try {
			int res = (Integer)smc.insert("qna.answerQna", qna);
			if(res > 0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//Qna 글 수정
	//성공하면 1 리턴, 실패하면 0 리턴
	@Override
	public boolean updateQna(QnaBoardVO qna) {
		
		boolean result = false;
		
		try {
			int res = smc.update("qna.updateQna", qna);
			if(res > 0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//Qna 글 삭제
	//성공하면 삭제한 열의 수만큼 리턴, 실패하면 0 리턴
	@Override
	public boolean deleteQna(int no) {
		
		boolean result = false;
		
		try {
			int res = smc.delete("qna.deleteQna", no);
			if(res > 0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//Qna 리스트 가져오기
	@Override
	public List<QnaBoardVO> getAllQnaList() {
		
		List<QnaBoardVO> list = null;
		
		try {
			list = (List<QnaBoardVO>)smc.queryForList("qna.getAllQnaList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//Qna 검색하기
	@Override
	public List<QnaBoardVO> getSearchQna(QnaBoardVO qna) {
		
		List<QnaBoardVO> list = null;
		
		try {
			list = (List<QnaBoardVO>)smc.queryForList("qna.getSearchQna", qna);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//변호사 비밀글 접근가능 여부 확인하기
	@Override
	public String secretCheck(int no) {
		
		String qna_writer_id = "";
		
		try {
			qna_writer_id = (String)smc.queryForObject("qna.secretCheck", no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return qna_writer_id;
	}
	
}
