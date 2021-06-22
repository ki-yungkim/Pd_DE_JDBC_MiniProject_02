package com.work.service;

import java.util.ArrayList;

import com.work.model.ReserveDao;
import com.work.model.ReserveMember;

/**
 * <pre>
 * 등록자 정보 서비스 클래스
 * </pre>
 * 
 * @author 김기영
 * @version ver 2.0
 * @since jdk1.8
 *
 */
public class ReserveService {

	private ReserveDao dao = ReserveDao.getInstance();
	
	public boolean updateReserveMember(String name, String mobile, String address, String idNumber, 
			String vaccineName, String firstVaccineDate) {
		
		
		return dao.updateReserveMember(name, mobile, address, idNumber, vaccineName, firstVaccineDate);
	}
	
	/** 등록자 로그인*/
	public String rLogin(String registrantName, String idNumber) {
		
		return dao.rLogin(registrantName, idNumber);
	}
	
	/** 등록 회원 정보 조회*/
	public ReserveMember getselectOne(String name, String idNumber) {
		
		return dao.selectOne(name, idNumber);
	}

	/** 전화번호 변경 */
	public boolean updateMobile(String name, String idNumber, String phoneNumber) {
		return dao.updateOne(name, idNumber, phoneNumber);
	}
	
	/** 정보 삭제*/
	public boolean deleteOne(String name, String idNumber) {
		return dao.deleteOne(name, idNumber);
	}
	/** 전체 조회*/
	public ArrayList<ReserveMember> selectAll() {
		return dao.selectAll();
		
	}

	/** 관리자- 정보 삭제 */
	public boolean deleteOneAdmin(String name, String idNumber) {
		return dao.deleteOneAdmin(name, idNumber);
	}
}
