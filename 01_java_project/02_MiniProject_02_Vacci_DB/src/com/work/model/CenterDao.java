package com.work.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CenterDao {

	private FactoryDao factory = FactoryDao.getInstance();

	private static CenterDao instance = new CenterDao();

	private CenterDao() {

	}

	public static CenterDao getInstance() {
		return instance;
	}

	// 센터명으로 정보 조회

	public CenterList selectOneByCenterName(String centerName) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();

			String  sql = "select * from center_list where center_name = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, centerName);

			rs = stmt.executeQuery();

			if(rs.next()) {
				String facilityName = rs.getString("facility_name");
				String postcode = rs.getString("postnumber");
				String address = rs.getString("adress");
				String addressDetail = rs.getString("adress_detail");
				String phoneNumber = rs.getString("phone_number");

				CenterList dto = new CenterList(centerName, facilityName, postcode, address, addressDetail, phoneNumber);
				return dto;
			}
		} catch (SQLException e) {
			System.out.println("[오류] 센터명으로 상세조회");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}

		return null;
	}

	// 시설명으로 정보 조회

	public CenterList selectOneByFacilityName(String facilityName) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();

			String  sql = "select * from center_list where facility_name = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, facilityName);

			rs = stmt.executeQuery();

			if(rs.next()) {
				String centerName = rs.getString("center_name");
				//String facilityName = rs.getString("facility_name");
				String postcode = rs.getString("postnumber");
				String address = rs.getString("adress");
				String addressDetail = rs.getString("adress_detail");
				String phoneNumber = rs.getString("phone_number");

				CenterList dto = new CenterList(centerName, facilityName, postcode, address, addressDetail, phoneNumber);
				return dto;
			}
		} catch (SQLException e) {
			System.out.println("[오류] 시설명으로 상세조회");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}

		return null;
	}

	// 센터 주소로 정보 조회

	public CenterList selectOneByAdress(String address) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();

			String  sql = "select * from center_list where adress = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, address);

			rs = stmt.executeQuery();

			if(rs.next()) {
				String centerName = rs.getString("center_name");
				String facilityName = rs.getString("facility_name");
				String postcode = rs.getString("postnumber");
				//String address = rs.getString("adress");
				String addressDetail = rs.getString("adress_detail");
				String phoneNumber = rs.getString("phone_number");

				CenterList dto = new CenterList(centerName, facilityName, postcode, address, addressDetail, phoneNumber);
				return dto;
			}
		} catch (SQLException e) {
			System.out.println("[오류] 주소로 센터 정보 상세조회");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}

		return null;
	}


	// 전화번호로 센터조회

	public CenterList selectOneByPhoneNumber(String phoneNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();

			String  sql = "select * from center_list where phone_number = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, phoneNumber);

			rs = stmt.executeQuery();

			if(rs.next()) {
				String centerName = rs.getString("center_name");
				String facilityName = rs.getString("facility_name");
				String postcode = rs.getString("postnumber");
				String address = rs.getString("adress");
				String addressDetail = rs.getString("adress_detail");
				//String phoneNumber = rs.getString("phone_number");

				CenterList dto = new CenterList(centerName, facilityName, postcode, address, addressDetail, phoneNumber);
				return dto;
			}
		} catch (SQLException e) {
			System.out.println("[오류] 전화번호로 센터정보 상세조회");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}

		return null;
	}
	
	
	
	
	// 관리자 로그인
	
	public String adminLogin(String adminId, String adminPw) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			
			String sql = "select admin_name from admin_member where admin_id = ? and admin_pw = ? ";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, adminId);
			stmt.setString(2, adminPw);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				String adminName = rs.getString("admin_name");
				return adminName;
			}
			
		} catch (SQLException e) {
			System.out.println("[오류] 로그인");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}
		
		return null;
	}
	
	
	
	

	// 관리자 - 전체 조회
	public ArrayList<CenterList> selectAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<CenterList> list = new ArrayList<CenterList>();

		try {
			conn = factory.getConnection();

			String  sql = "select * from center_list";
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			while(rs.next()) {
				int centerNo = rs.getInt("center_no");
				String centerName = rs.getString("center_name");
				String facilityName = rs.getString("facility_name");
				String postcode = rs.getString("postnumber");
				String adress = rs.getString("adress");
				String adressDetail = rs.getString("adress_detail");
				String phoneNumber = rs.getString("phone_number");

				CenterList dto = new CenterList(centerNo, centerName, facilityName, postcode, adress, adressDetail, phoneNumber);
				list.add(dto);
			}

		} catch (SQLException e) {
			System.out.println("[오류] 센터 전체 조회");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}

		return list;
	}

	// 관리자 - 현재 등록 센터 수 조회

	public int selectCenterCount() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		int count = 0;
		try {
			conn = factory.getConnection();

			String sql = "select count(phone_number) from center_list"; 
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				count = rs.getInt("count(phone_number)");
				return count;
			}


		} catch (SQLException e) {
			System.out.println("[오류] 등록 센터 수 조회");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}

		return 0;
	}
	
	// 관리자 - 추가 등록 
	
	// 관리자 - 센터 정보 전체 삭제 

	// 관리자 - 센터 하나 삭제 

	// 관리자 - 센터 정보 변경 


	// 초기 등록 센터 전달 

	// 초기 센터 등록 

	


}
