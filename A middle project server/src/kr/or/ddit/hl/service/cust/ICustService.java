package kr.or.ddit.hl.service.cust;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.hl.vo.CustomerCenterVO;

public interface ICustService extends Remote{
	

	//고객센터 글 추가 및 답글추가
	public boolean insertCust(CustomerCenterVO cust) throws RemoteException;
	
	//고객센터 글 수정
	public boolean updateCust(CustomerCenterVO cust)throws RemoteException;
	
	//고객센터 글 삭제
	public boolean deleteCust(int no) throws RemoteException;
	
	//고객센터 글 가져오기
	public CustomerCenterVO selectCust(int no) throws RemoteException;
	
	//고객센터 리스트 가져오기
	public List<CustomerCenterVO> getAllCustList() throws RemoteException;
	
	//고객센터 검색하기
	public List<CustomerCenterVO> getSearchCust(CustomerCenterVO cust) throws RemoteException;
	
}
