package com.work.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <pre>
 * 2차 접종 알림 신청자 DAO 클래스
 * 
 * # 메서드 목록
 *  1. 신청자 정보 등록
 *  2. 신청자 로그인
 *  3. 신청자 정보 조회
 *  4. 신청자 연락처 정보 변경
 *  5. 등록정보 삭제
 *  6. 관리자 - 신청자 정보 전체 조회
 *  7. 관리자 - 신청자 등록 정보 삭제
 * 
 * </pre>
 * 
 * @author 김기영
 * @version ver 2.0
 * @since jdk1.8
 * 
 * 
 */
public class ReserveDao {

	private FactoryDao factory = FactoryDao.getInstance();

	private static ReserveDao instance = new ReserveDao();

	private ReserveDao() {

	}

	public static ReserveDao getInstance() {
		return instance;
	}


	/**
	 * 신청자 정보 등록
	 * @param name 이름
	 * @param mobile 전화번호
	 * @param adress 주소
	 * @param idNumber 주민번호
	 * @param vaccineName 백신명
	 * @param firstVaccineDate 1차접종일
	 * @return 등록 성공하면 true, 실패하면 falses
	 */
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

	
	/**
	 * 2차 알림 신청자 로그인
	 * @param registrantName 신청자 이름
	 * @param idNumber 주민번호
	 * @return 백신명 
	 */
	
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

	
	/**
	 * 2차 알림 신청자 정보 조회
	 * @param name 이름
	 * @param idNumber 주민번호
	 * @return 신청자 정보 
	 */
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


	/**
	 * 연락처 정보 변경
	 * @param name 이름
	 * @param idNumber 주민번호
	 * @param phoneNumber 변경할 연락처
	 * @return 성공하면 true, 실패하면 false
	 */
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

	/**
	 * 등록 정보 삭제
	 * @param name 아이디
	 * @param idNumber 주민번호
	 * @return 성공하면 true, 실패하면 false
	 */ 
	public boolean deleteOne(String name, String idNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = factory.getConnection();

			String  sql = "delete from reserve where r_name = ? and id_number = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, name);
			stmt.setString(2, idNumber);

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				return true;	
			}
		
	} catch (SQLException e) {
		System.out.println("[오류] 등록 정보 삭제");
		e.printStackTrace();
	} finally {
		factory.close(conn, stmt);
	}

	return false;
}
	


	/**
	 * 관리자 - 신청자 정보 전체 죄회
	 * @return 신청자 정보
	 */
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
				String firstVaccination = rs.getString("f_vaccinedate");

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
	
	
	/**
	 * 관리자 - 등록 정보 삭제
	 * @param name 아이디
	 * @param idNumber 주민번호
	 * @return 성공하면 true, 실패하면 false
	 */
		public boolean deleteOneAdmin(String name, String idNumber) {
			Connection conn = null;
			PreparedStatement stmt = null;

			try {
				conn = factory.getConnection();

				String  sql = "delete from reserve where r_name = ? and id_number = ? ";
				stmt = conn.prepareStatement(sql);

				stmt.setString(1, name);
				stmt.setString(2, idNumber);

				int rows = stmt.executeUpdate();
				if (rows > 0) {
					return true;	
				}
			
		} catch (SQLException e) {
			System.out.println("[오류] 등록 정보 삭제");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt);
		}

		return false;
	}

}
