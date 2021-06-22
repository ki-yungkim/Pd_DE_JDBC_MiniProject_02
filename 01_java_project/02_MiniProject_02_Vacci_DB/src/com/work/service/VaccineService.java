package com.work.service;

import java.util.ArrayList;

import com.work.model.VaccineCount;
import com.work.model.VaccineDao;
import com.work.util.Utility;

/**
 * <pre>
 * 접종자 정보 서비스 클래스
 * </pre>
 * 
 * @author 김기영
 * @version ver 2.0
 * @since jdk1.8
 *
 */
public class VaccineService {

	public VaccineDao dao = VaccineDao.getInstance();
	public Utility utility = new Utility();

	/**
	 * 접종자 수 조회
	 * @param day 날짜
	 * @param region 지역
	 * @return vacciCOunt
	 */
	public String getVaccineCount(String day, String region) {
		ArrayList list = new ArrayList();
		list = dao.selectVaccineCount(day, region);
		if(list != null) {
			int first = (int) list.get(0); 
			int second = (int) list.get(1);
			String vacciCount = day + " 기준 " + region + " 지역의 1차 접종자 수는 " +  utility.commaThousand(first) 
			+ "명, 2차 접종자 수는 " + utility.commaThousand(second) + "명 입니다. ";

			return vacciCount;
		}
		return null;
	}

	/**
	 * 누적 접종자 수 조회
	 * @param day 날짜
	 * @param region 지역
	 * @return vacciCount
	 */
	public String getTotalVaccineCount(String day, String region) {
		ArrayList list = new ArrayList();
		list = dao.selectTotalVaccineCount(day, region);
		if (list != null) {
			int first = (int) list.get(0); 
			int second = (int) list.get(1);
			String vacciCount = day + " 기준 " + region + " 지역의  누적 1차 접종자 수는 " +  utility.commaThousand(first) 
			+ "명, 누적 2차 접종자 수는 " + utility.commaThousand(second) + "명 입니다. ";

			return vacciCount;
		}

		return null;
	}

	/**
	 * 누적 접종율 조회
	 * @param day 날짜
	 * @param region 지역
	 * @return 접종률
	 */
	public String getTotalVaccinePercent(String day, String region) {
		ArrayList list = new ArrayList();
		list = dao.selectTotalVaccinePercent(day, region);
		if (list != null) {
			int first = (int) list.get(0); 
			int second = (int) list.get(1);
			int firstPercent = 0;
			int secondPercent = 0;

			switch (region) {
			case "전국" :
				firstPercent = (first*100)/51821669;
				secondPercent = (second*100)/51821669;
				break;
			case "서울특별시":
				firstPercent = (first*100)/9588711;
				secondPercent = (second*100)/9588711;
				break;

			case "부산광역시":
				firstPercent = (first*100)/3369704;
				secondPercent = (second*100)/3369704;
				break;

			case "대구광역시":
				firstPercent = (first*100)/2406296;
				secondPercent = (second*100)/2406296;
				break;

			case "인천광역시":
				firstPercent = (first*100)/2936214;
				secondPercent = (second*100)/2936214;
				break;

			case "광주광역시":
				firstPercent = (first*100)/1444787;
				secondPercent = (second*100)/1444787;
				break;

			case "대전광역시":
				firstPercent = (first*100)/1457619;
				secondPercent = (second*100)/1457619;
				break;

			case "울산광역시":
				firstPercent = (first*100)/1128163;
				secondPercent = (second*100)/1128163;
				break;

			case "세종특별자치시":
				firstPercent = (first*100)/362036;
				secondPercent = (second*100)/362036;
				break;

			case "경기도":
				firstPercent = (first*100)/13479798;
				secondPercent = (second*100)/13479798;
				break;

			}

			String vacciCount = day + " 기준 " + region + " 지역의 1차 접종률은 " +   utility.commaThousand(firstPercent) 
			+ "%, 2차 접종률은 " +   utility.commaThousand(secondPercent) + "% 입니다. ";

			return vacciCount;
		}

		return null;
	}


	/**
	 * 우선접종대상자 조회
	 * @param age 연령
	 * @param job 직업
	 * @return result
	 */
	public String prefferdMember(int age, String job) { 

		String result = null;
		if (age >= 50) {
			result = "우선 접종대상자입니다.";
		} else {
			switch(job) {
			case "의료" :
				result = "우선 접종대상자입니다.";
				break;
			case "경찰" :
				result = "우선 접종대상자입니다.";
				break;
			case "소방" :
				result = "우선 접종대상자입니다.";
				break;
			case "군인" : 
				result = "우선 접종대상자입니다.";
				break;
			default :
				result = "우선 접종대상자가 아닙니다.";
			}
		}
		return result;
	}



	/**
	 * 백신 2차 접종 대기기간 조회
	 * @param vaccineName 백신명 
	 * @param firstDay 1차 접종일
	 * @return
	 */
	public String waitVaccine(String vaccineName, String firstDay) {

		String result = null;

		switch(vaccineName) {

		case "화이자" :
			System.out.println("화이자 백신은 1차 접종 3주 후 2차 접종입니다.");
			result = utility.addDate(vaccineName, firstDay);
			System.out.println("예정일 : " + result);
			break;
		case "모더나" :
			System.out.println("모더나 백신은 1차 접종 4주 후 2차 접종입니다.");
			result = utility.addDate(vaccineName, firstDay);
			System.out.println("예정일 : " + result);
			break;
		case "아스트라제네카" :
			System.out.println("아스트라제네카 백신은 1차 접종 12주 후 2차 접종입니다.");
			result = utility.addDate(vaccineName, firstDay);
			System.out.println("예정일 : " + result);
			break;

		default :
			System.out.println("백신 이름과 1차 접종일을 정확하게 입력해주십시오.");
		}
		return result;

	}


	/** 전체 조회*/
	public ArrayList<VaccineCount> getSelectAll(){
		return dao.selectAll();

	}
	/** 정보 등록 */
	public boolean insertVaccienCount(String day, String region, int yFirst, int ySecond, int tFirst, int tSecond) {

		return dao.insertVaccienCount(day, region, yFirst, ySecond, tFirst, tSecond);
	}

	/** 정보 변경 */
	public boolean updateVaccienCount(String day, String region, int yFirst, int ySecond, int tFirst, int tSecond) {

		return dao.updateVaccineCount(day, region, yFirst, ySecond, tFirst, tSecond);
	}

	/** 정보 삭제*/
	public boolean deleteVaccienCount(String day, String region) {

		return dao.deleteVaccineCount(day, region);
	}
}
