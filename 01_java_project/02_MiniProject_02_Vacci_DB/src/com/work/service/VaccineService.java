package com.work.service;

import java.io.IOException;
import java.util.ArrayList;

import com.work.model.VaccineDao;
import com.work.util.Utility;

public class VaccineService {

	public VaccineDao dao = VaccineDao.getInstance();
	public Utility utility = new Utility();
	
	// 접종자 수 조회
	public String getVaccineCount(String day, String region) {
		ArrayList list = new ArrayList();
		list = dao.selectVaccineCount(day, region);
		int first = (int) list.get(0); 
		int second = (int) list.get(1);
		String vacciCount = day + " 기준 " + region + " 지역의 1차 접종자 수는 " +  utility.commaThousand(first) 
							+ "명, 2차 접종자 수는 " + utility.commaThousand(second) + "명 입니다. ";
 		
		return vacciCount;
	}
	
	// 누적 접종자 수 조회
	public String getTotalVaccineCount(String day, String region) {
		ArrayList list = new ArrayList();
		list = dao.selectTotalVaccineCount(day, region);
		int first = (int) list.get(0); 
		int second = (int) list.get(1);
		String vacciCount = day + " 기준 " + region + " 지역의  누적 1차 접종자 수는 " +  utility.commaThousand(first) 
							+ "명, 누적 2차 접종자 수는 " + utility.commaThousand(second) + "명 입니다. ";
 		
		return vacciCount;
	}
	
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
}
