package com.work.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <pre>
 * 예방접종센터 DAO 클래스 
 * 
 * # Pattern Programming
 *  - DAO Pattern
 *  - Singleton Pattern
 *  - Factory Pattern 
 *
 * # 메서드 목록
 *  1. 센터명으로 상세 정보 조회
 *  2. 시설명으로 상세 정보 조회
 *  3. 주소로 상세 정보 조회
 *  4. 전화번호로 상세 조회
 *  5. 관리자 - 로그인
 *  6. 관리자 - 센터 전체조회
 *  7. 관리자 - 현재 등록 센터 수 조회
 *  8. 관리자 - 센터 정보 등록
 *  9. 관리자 - 센터 연락처 정보 변경
 *  10. 관리자 - 센터 삭제 
 *  
 *  
 * </pre>
 * @author 김기영
 * @version ver 2.0
 * @since jdk1.8
 *
 *
 */
public class CenterDao {

	private FactoryDao factory = FactoryDao.getInstance();

	private static CenterDao instance = new CenterDao();

	private CenterDao() {

	}

	/**
	 * <pre>
	 * Singleton pattern
	 * </pre>
	 * @return instance
	 */
	public static CenterDao getInstance() {
		return instance;
	}

	/**
	 * <pre>
	 * 센터명 입력하여 상세 정보 조회
	 * </pre>
	 * @param centerName 센터명
	 * @return 상세 정보
	 */
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


	/**
	 * 시설명으로 센터 정보 상세 조회
	 * @param facilityName 시설명
	 * @return 센터 상세 정보 
	 */
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


	/**
	 * 센터 주소로 센터 정보 상세 조회
	 * @param address 주소
	 * @return 센터 상세 정보
	 */
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

	/**
	 * 센터 주소로 상세 정보 조회 
	 * 대상이 되는 여러 센터 출력 
	 * @param address 주소
	 * @return 센터 정보들 
	 */
	public ArrayList<CenterList> selectAddressAll(String address) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<CenterList> list = new ArrayList<CenterList>();

		try {
			conn = factory.getConnection();

			String  sql = "select * from center_list where adress = ?";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, address);
			
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
			System.out.println("[오류] 주소로 센터 정보 상세조회");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}

		return list;
	}

	/**
	 * 전화번호로 센터 상세 조회
	 * @param phoneNumber 전화번호
	 * @return 센터 상세 정보
	 */
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
	
	
	/**
	 * 관리자 로그인 기능 
	 * @param adminId 관리자 아이디
	 * @param adminPw 관리자 비밀번호
	 * @return 관리자명 
	 */
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
	
	
	
	

	/**
	 * 센터 정보 전체 조회
	 * @return 센터정보 list
	 */
	public ArrayList<CenterList> selectAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<CenterList> list = new ArrayList<CenterList>();

		try {
			conn = factory.getConnection();

			String  sql = "select * from center_list order by center_no";
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

	
	/** 
	 * 현재 등록 센터 수 조회
	 * @return 센터 수
	 */
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
	
	/**
	 * 센터 정보 등록 기능
	 * @param centerName 센터명 
	 * @param facilityName 시설명
	 * @param postcode 우편번호
	 * @param address 주소
	 * @param addressDetail 상세주소
	 * @param phoneNumber 전화번호
	 * @return 성공하면 true, 실패하면 false
	 */
	public boolean insertCenter(String centerName, String facilityName, String postcode, String address, String addressDetail, String phoneNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;


		try {
			conn = factory.getConnection();

			String sql = "insert into center_list values(seq_center.nextval, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, centerName);
			stmt.setString(2, facilityName);
			stmt.setString(3, postcode);
			stmt.setString(4, address);
			stmt.setString(5, addressDetail);
			stmt.setString(6, phoneNumber);

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				return true;	
			} else {
				System.out.println("정보가 없습니다");
				return false;
			}

		} catch (SQLException e) {
			System.out.println("[오류] 센터 등록");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt);
		}

		return false;
	}

	
	/**
	 * 센터 연락처 정보 변경 기능
	 * @param centerName 센터명
	 * @param phoneNumber 전화번호
	 * @return 변경 성공하면 true, 실패하면 false
	 */
	public boolean updateCenterPhone(String centerName, String phoneNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;


		try {
			conn = factory.getConnection();

			String sql = "update center_list set phone_number = ? where center_Name = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, phoneNumber);
			stmt.setString(2, centerName);
			

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				return true;	
			}

		} catch (SQLException e) {
			System.out.println("[오류] 센터 연락처 정보 변경");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt);
		}

		return false;
	}
	
	/**
	 * 센터 정보 1개 삭제 
	 * @param centerName 센터명
	 * @return 삭제 성공하면 true, 실패하면 false
	 */
	public boolean deleteCenterOne(String centerName) {
		Connection conn = null;
		PreparedStatement stmt = null;


		try {
			conn = factory.getConnection();

			String sql = "delete from center_list where center_Name = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, centerName);
			

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				return true;	
			}

		} catch (SQLException e) {
			System.out.println("[오류] 센터 정보 삭제");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt);
		}

		return false;
	}
	

}
