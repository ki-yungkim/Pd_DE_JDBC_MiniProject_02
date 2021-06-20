package com.work.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReserveDao {

	private FactoryDao factory = FactoryDao.getInstance();

	private static ReserveDao instance = new ReserveDao();

	private ReserveDao() {

	}

	public static ReserveDao getInstance() {
		return instance;
	}

	// 등록 

	public boolean updateReserveMember(String name, String mobile, String adress, String idNumber, 
			String vaccineName, String firstVaccineDate) {
		Connection conn = null;
		PreparedStatement stmt = null;


		try {
			conn = factory.getConnection();

			String sql = "insert into reserve values(?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, name);
			stmt.setString(2, mobile);
			stmt.setString(3, adress);
			stmt.setString(4, idNumber);
			stmt.setString(5, vaccineName);
			stmt.setString(6, firstVaccineDate);

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				return true;	
			}

		} catch (SQLException e) {
			System.out.println("[오류] 예약자 등록");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt);
		}

		return false;
	}


	// 2차 알림 신청자 로그인
	public String rLogin(String registrantName, String idNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();

			String sql = "select vaccine_name from reserve where r_name = ? and id_number = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, registrantName);
			stmt.setString(2, idNumber);

			rs = stmt.executeQuery();

			if(rs.next()) {
				String vaccineName = rs.getString("vaccine_name");
				return vaccineName;
			}

		} catch (SQLException e) {
			System.out.println("[오류] 로그인");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}

		return null;
	}




	// 2차 알림 신청자 정보  조회
	public ReserveMember selectOne(String name, String idNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();

			String  sql = "select * from reserve where r_name = ? and id_number = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, name);
			stmt.setString(2, idNumber);

			rs = stmt.executeQuery();

			if(rs.next()) {
				String phoneNumber = rs.getString("mobile");
				String address = rs.getString("address");
				String vaccineName = rs.getString("vaccine_name");
				String firstVaccination = rs.getString("f_vaccinedate");

				ReserveMember dto = new ReserveMember(name, phoneNumber, address, idNumber, vaccineName, firstVaccination);
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


	// 연락처 정보 변경 
	public boolean updateOne(String name, String idNumber, String phoneNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = factory.getConnection();

			String  sql = "update reserve set mobile = ? where r_name = ? and id_number = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, phoneNumber);
			stmt.setString(2, name);
			stmt.setString(3, idNumber);

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				return true;	
			}
		
	} catch (SQLException e) {
		System.out.println("[오류] 연락처 정보 변경");
		e.printStackTrace();
	} finally {
		factory.close(conn, stmt);
	}

	return false;
}


// 관리자 - 신청자 정보 전체 조회

	public ArrayList<ReserveMember> selectAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<ReserveMember> list = new ArrayList<ReserveMember>();
		try {
			conn = factory.getConnection();

			String  sql = "select * from reserve";
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			while(rs.next()) {
				String name = rs.getString("r_name");
				String phoneNumber = rs.getString("mobile");
				String address = rs.getString("address");
				String idNumber = rs.getString("id_number");
				String vaccineName = rs.getString("vaccine_name");
				String firstVaccination = rs.getString("f_vaccindate");

				ReserveMember dto = new ReserveMember(name, phoneNumber, address, idNumber, vaccineName, firstVaccination);
				list.add(dto);
			}

		} catch (SQLException e) {
			System.out.println("[오류] 신청자 정보 전체 조회");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}

		return list;
		
	}
	
	
// 관리자 - 정보 수 조회

// 관리자 - 데이터 전체 삭제 

// 관리자 - 하나 삭제 

// 관리자 - 데이터 변경 













}
