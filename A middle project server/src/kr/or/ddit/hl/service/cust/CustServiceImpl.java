package kr.or.ddit.hl.service.cust;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.hl.dao.cust.CustDaoImpl;
import kr.or.ddit.hl.dao.cust.ICustDao;
import kr.or.ddit.hl.vo.CustomerCenterVO;

public class CustServiceImpl extends UnicastRemoteObject implements ICustService {
	
	private static ICustService service;
	private ICustDao dao;
	
	
	protected CustServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
		dao = CustDaoImpl.getInstance();
	}
	
	public static ICustService getInstance() throws RemoteException {
		if(service == null) {
			service = new CustServiceImpl();
		}
		return service;
	}
	
	@Override
	public boolean insertCust(CustomerCenterVO cust) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.insertCust(cust);
	}

	@Override
	public boolean updateCust(CustomerCenterVO cust) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.updateCust(cust);
	}

	@Override
	public boolean deleteCust(int no) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.deleteCust(no);
	}

	@Override
	public CustomerCenterVO selectCust(int no) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.selectCust(no);
	}

	@Override
	public List<CustomerCenterVO> getAllCustList() throws RemoteException {
		// TODO Auto-generated method stub
		return dao.getAllCustList();
	}

	@Override
	public List<CustomerCenterVO> getSearchCust(CustomerCenterVO cust) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.getSearchCust(cust);
	}

}
