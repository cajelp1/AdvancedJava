package kr.or.ddit.mp.service.zone;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.mp.dao.zone.ZoneDaoImpl;
import kr.or.ddit.mp.vo.mypage.ZiptbVO;
import kr.or.ddit.mp.vo.mypage.ZoneVO;

public class ZoneServiceImpl extends UnicastRemoteObject implements IZoneService{

	ZoneDaoImpl zoneDao; //사용할 Dao의  멤버변수를 선언
	
	private static ZoneServiceImpl service;//Singleton패턴
	
	private ZoneServiceImpl() throws RemoteException {
		super();
		zoneDao =  ZoneDaoImpl.getInstance();//Singleton패턴
	}
	
	public static ZoneServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new ZoneServiceImpl();
		}
		return service;
	}

	@Override
	public List<ZiptbVO> selectZone(String dong) throws RemoteException {
		
		return zoneDao.selectZone(dong);
	}

	@Override
	public int insertZone1(ZoneVO zone1) throws RemoteException {
		
		return zoneDao.insertZone1(zone1);
	}

	@Override
	public int updateZone2(ZoneVO zone2) throws RemoteException {
		
		return zoneDao.updateZone2(zone2);
	}

	@Override
	public int updateZone3(ZoneVO zone3) throws RemoteException {
		
		return zoneDao.updateZone3(zone3);
	}

	@Override
	public int deleteZone3(ZoneVO zone3) throws RemoteException {
		
		return zoneDao.deleteZone3(zone3);
	}

	@Override
	public int deleteZone2(ZoneVO zone2) throws RemoteException {
		
		return zoneDao.deleteZone2(zone2);
	}

	@Override
	public int deleteZone1(ZoneVO zone1) throws RemoteException {
		
		return zoneDao.deleteZone1(zone1);
	}

	@Override
	public List<ZoneVO> selectZoneChoice(ZoneVO vo) throws RemoteException {

		return zoneDao.selectZoneChoice(vo);
	}

	

	
	 
	 
}