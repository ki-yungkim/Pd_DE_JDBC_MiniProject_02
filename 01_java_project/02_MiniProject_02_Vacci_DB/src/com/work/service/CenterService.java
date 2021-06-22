package com.work.service;

import java.util.ArrayList;

import com.work.model.CenterDao;
import com.work.model.CenterList;

/**
 * 센터정보 서비스 클래스
 * @author 김기영
 * @version ver 2.0
 * @since jdk1.8
 *
 */
public class CenterService {
	/** 초기 생성자 */
	private CenterDao dao = CenterDao.getInstance();
	
	/** 센터 명으로 정보 조회*/
	public CenterList getCenterByCenterName(String centerName) {
		return dao.selectOneByCenterName(centerName);
	}

	/** 시설명으로 정보 조회*/
	public CenterList getCenterByFacilityName(String facilityName) {
		return dao.selectOneByFacilityName(facilityName);
		
	}
	/** 주소로 정보조회 */
	public CenterList getCenterByAdress(String adress) {
		return dao.selectOneByAdress(adress);
	}
	
	/** 주소로 정보 여러개 조회 */
	public ArrayList<CenterList> getAddressAll(String address) {
		return dao.selectAddressAll(address);
	}
	
	/** 전화번호로 정보 조회*/
	public CenterList getCenterByPhoneNumber(String phoneNumber) {
		return dao.selectOneByPhoneNumber(phoneNumber);
	}

	/** 센터 정보 전체 조회*/
	public ArrayList<CenterList> getCenterAll() {
		return dao.selectAll();
	}

	/** 센터 수 조회*/
	public int getCenterCount()  {
		return dao.selectCenterCount();
	}
	
	
	/**관리자 - 로그인*/
	public String adminLogin(String adminId, String adminPw)  {
		return dao.adminLogin(adminId, adminPw);
	}
	
	/** 관리자 - 센터 정보 등록 */
	public boolean insertCenter(String centerName, String facilityName, String postcode, String address, 
								String addressDetail, String phoneNumber) {
		
		return dao.insertCenter(centerName, facilityName, postcode, address, addressDetail, phoneNumber);
	}
	
	/** 연락처 변경*/
	public boolean updateCenterPhone(String centerName, String phoneNumber) {
		return dao.updateCenterPhone(centerName, phoneNumber);
	}
	
	/** 센터 정보 삭제*/
	public boolean deleteCenterOne(String centerName) {
		return dao.deleteCenterOne(centerName);
	}
	
}


