package com.work.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * <pre>
 * 백신 접종자 수 DAO 클래스 
 * 
 * # 메서드 목록
 *  1. 날짜, 지역으로 1차, 2차 접종자 수 조회
 * 	2. 날짜, 지역으로  누적 1차, 2차 접종자 수 조회
 *  3. 날짜, 지역으로 1차, 2차 접종률 조회
 *  4. 관리자 - 전체 조회
 *  5. 관리자 - 접종 수 등록
 *  6. 관리자 - 접종 수 변경
 *  7. 관리자 - 접종 수 삭제
 * 
 * @author kky
 * @version ver 2.0
 * @since jdk1.8
 */
public class VaccineDao {

	private FactoryDao factory = FactoryDao.getInstance();

	private static VaccineDao instance = new VaccineDao();

	private VaccineDao() {

	}

	public static VaccineDao getInstance() {
		return instance;
	}




	/**
	 * 날짜, 지역으로 1차, 2차 접종자 수 조회	
	 * @param day 날짜
	 * @param region 지역
	 * @return list
	 */
	public ArrayList selectVaccineCount(String day, String region) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList list = new ArrayList();
		try {
			conn = factory.getConnection();

			String  sql = "select y_first, y_second from vaccine_count where day = ? and region = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, day);
			stmt.setString(2, region);

			rs = stmt.executeQuery();

			if(rs.next()) {
				int yFirst = rs.getInt("y_first");
				int ySecond = rs.getInt("y_second");

				list.add(yFirst);
				list.add(ySecond);

				return list;
			}
		} catch (SQLException e) {
			System.out.println("[오류] 날짜, 지역으로 접종자 수 조회");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}

		return null;
	}



	/**
	 * 날짜, 지역으로 누적 1차, 2차 접종자 수 조회
	 * @param day 날짜
	 * @param region 지역
	 * @return list
	 */
	public ArrayList selectTotalVaccineCount(String day, String region) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList list = new ArrayList();
		try {
			conn = factory.getConnection();

			String  sql = "select t_first, t_second from vaccine_count where day = ? and region = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, day);
			stmt.setString(2, region);

			rs = stmt.executeQuery();

			if(rs.next()) {
				int tFirst = rs.getInt("t_first");
				int tSecond = rs.getInt("t_second");

				list.add(tFirst);
				list.add(tSecond);

				return list;
			}
		} catch (SQLException e) {
			System.out.println("[오류] 날짜, 지역으로 누적 접종자 수 조회");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}

		return null;
	}


	/**
	 * 날짜, 지역으로 1차, 2차 접종률 조회
	 * @param day 날짜
	 * @param region 지역
	 * @return list
	 */
	public ArrayList selectTotalVaccinePercent(String day, String region) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList list = new ArrayList();
		try {
			conn = factory.getConnection();

			String  sql = "select t_first, t_second from vaccine_count where day = ? and region = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, day);
			stmt.setString(2, region);

			rs = stmt.executeQuery();

			if(rs.next()) {
				int tFirst = rs.getInt("t_first");
				int tSecond = rs.getInt("t_second");

				list.add(tFirst);
				list.add(tSecond);

				return list;
			}
		} catch (SQLException e) {
			System.out.println("[오류] 날짜, 지역으로 접종률 조회");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}

		return null;
	}



	/**
	 * 관리자 - 전체조회
	 * @return list
	 */
	public ArrayList<VaccineCount> selectAll() {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;


		ArrayList<VaccineCount> list = new ArrayList<VaccineCount>();
		try {
			conn = factory.getConnection();

			String  sql = "select * from vaccine_count order by vacci_count_no ";
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			while(rs.next()) {
				int vacciCountNo = rs.getInt("vacci_count_no");
				String day = rs.getString("day");
				String region = rs.getString("region");
				int yFirst = rs.getInt("y_first");
				int ySecond = rs.getInt("y_second");
				int tFirst = rs.getInt("t_first");
				int tSecond = rs.getInt("t_second");

				VaccineCount dto = new VaccineCount(vacciCountNo, day, region, yFirst, ySecond, tFirst, tSecond);
				list.add(dto);
			}

		} catch (SQLException e) {
			System.out.println("[오류] 접종자 수 전체 조회");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt, rs);
		}

		return list;
	}


	/**
	 * 관리자 - 정보 등록
	 * @param day 날짜
	 * @param region 지역
	 * @param yFirst 1차 접종
	 * @param ySecond 2차 접종
	 * @param tFirst 누적 1차 접종
	 * @param tSecond 누적 2차 접종 
	 * @return
	 */
	public boolean insertVaccienCount(String day, String region, int yFirst, int ySecond, int tFirst, int tSecond) {
		Connection conn = null;
		PreparedStatement stmt = null;


		try {
			conn = factory.getConnection();

			String sql = "insert into vaccine_count values(seq_vaccine.nextval, ?, ?, ?, ?, ?, ? )";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, day);
			stmt.setString(2, region);
			stmt.setInt(3, yFirst);
			stmt.setInt(4, ySecond);
			stmt.setInt(5, tFirst);
			stmt.setInt(6, tSecond);

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				return true;	
			}

		} catch (SQLException e) {
			System.out.println("[오류] 백신 접종 수 등록");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt);
		}

		return false;
	}


	/**
	 * 관리자 : 데이터 변경
	 * @param day 날짜
	 * @param region 지역
	 * @param yFirst 1차 접종
	 * @param ySecond 2차 접종
	 * @param tFirst 누적 1차 접종
	 * @param tSecond 누적 2차 접종
	 * @return
	 */

	public boolean updateVaccineCount(String day, String region, int yFirst, int ySecond, int tFirst, int tSecond ) {
		Connection conn = null;
		PreparedStatement stmt = null;


		try {
			conn = factory.getConnection();

			String sql = "update vaccine_count set y_first = ?, y_second = ?, t_first = ?, t_second = ?   where day  = ? and region = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, yFirst);
			stmt.setInt(2, ySecond);
			stmt.setInt(3, tFirst);
			stmt.setInt(4, tSecond);
			stmt.setString(5, day);
			stmt.setString(6, region);

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				return true;	
			}

		} catch (SQLException e) {
			System.out.println("[오류] 접종자 수 정보 변경");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt);
		}

		return false;
	}

	/**
	 * 관리자 - 정보 하나 삭제
	 * @param day
	 * @param region
	 * @return
	 */
	public boolean deleteVaccineCount(String day, String region) {

		Connection conn = null;
		PreparedStatement stmt = null;


		try {
			conn = factory.getConnection();

			String sql = "delete from vaccine_count  where day = ? and region = ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, day);
			stmt.setString(2, region);

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				return true;	
			}

		} catch (SQLException e) {
			System.out.println("[오류] 접종자 수 정보 삭제");
			e.printStackTrace();
		} finally {
			factory.close(conn, stmt);
		}

		return false;
	}

}



