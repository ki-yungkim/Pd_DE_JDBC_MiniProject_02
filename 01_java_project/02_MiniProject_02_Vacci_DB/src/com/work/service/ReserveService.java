package com.work.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.work.model.ReserveDao;
import com.work.model.ReserveMember;

public class ReserveService {

	private ReserveDao dao = ReserveDao.getInstance();
	
	public boolean updateReserveMember(String name, String mobile, String address, String idNumber, 
			String vaccineName, String firstVaccineDate) {
		
		
		return dao.updateReserveMember(name, mobile, address, idNumber, vaccineName, firstVaccineDate);
	}
	
	public String rLogin(String registrantName, String idNumber) {
		
		return dao.rLogin(registrantName, idNumber);
	}
	
	
	public ReserveMember getselectOne(String name, String idNumber) {
		
		return dao.selectOne(name, idNumber);
	}

	
	public boolean updateMobile(String name, String idNumber, String phoneNumber) {
		return dao.updateOne(name, idNumber, phoneNumber);
	}

	
	public ArrayList<ReserveMember> selectAll() {
		return dao.selectAll();
		
	}

}
