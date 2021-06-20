package com.work.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VaccineDao {
	
	private FactoryDao factory = FactoryDao.getInstance();
	
	private static VaccineDao instance = new VaccineDao();
	
	private VaccineDao() {
		
	}
	
	public static VaccineDao getInstance() {
		return instance;
	}

	
	
	// 날짜, 지역으로 1차, 2차 접종자 수 조회	
	
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

	
	
	// 날짜, 지역으로 누적 1차, 2차 접종자 수 조회
	
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
	
	
	// 관리자 - 추가 등록 
	
	
	// 관리자 - 전체 조회
		
	// 관리자 - 정보 수 조회
		
	
	// 관리자 - 데이터 전체 삭제 
	
	// 관리자 - 하나 삭제 
	
	// 관리자 - 데이터 변경 
	
	
	// 관리자 - 초기 접종 수 정보 입력
	
	// 관리자 - 초기 접종 수 등록
	
	
}


