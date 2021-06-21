package com.work.service;

import java.util.ArrayList;

import com.work.model.CenterDao;
import com.work.model.CenterList;

public class CenterService {
	
	private CenterDao dao = CenterDao.getInstance();
	
	public CenterList getCenterByCenterName(String centerName) {
		return dao.selectOneByCenterName(centerName);
	}

	public CenterList getCenterByFacilityName(String facilityName) {
		return dao.selectOneByFacilityName(facilityName);
	}
	
	public CenterList getCenterByAdress(String adress) {
		return dao.selectOneByAdress(adress);
	}
	
	public ArrayList<CenterList> getAddressAll(String address) {
		return dao.selectAddressAll(address);
	}
	
	public CenterList getCenterByPhoneNumber(String phoneNumber) {
		return dao.selectOneByPhoneNumber(phoneNumber);
	}

	
	public ArrayList<CenterList> getCenterAll() {
		return dao.selectAll();
	}

	public int getCenterCount()  {
		return dao.selectCenterCount();
	}
	
	public String adminLogin(String adminId, String adminPw)  {
		return dao.adminLogin(adminId, adminPw);
	}
	
	public boolean insertCenter(String centerName, String facilityName, String postcode, String address, 
								String addressDetail, String phoneNumber) {
		
		return dao.insertCenter(centerName, facilityName, postcode, address, addressDetail, phoneNumber);
	}
	
	public boolean updateCenterPhone(String centerName, String phoneNumber) {
		return dao.updateCenterPhone(centerName, phoneNumber);
	}
	
	
	public boolean deleteCenterOne(String centerName) {
		return dao.deleteCenterOne(centerName);
	}
	
}


