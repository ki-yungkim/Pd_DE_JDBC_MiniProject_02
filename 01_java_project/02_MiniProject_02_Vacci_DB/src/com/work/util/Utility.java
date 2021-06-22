package com.work.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**

 * 
 *
 */
/**
 * <pre>
 *  유틸리티 클래스
 * </pre>
 * @author 김기영
 * @version ver 2.0
 * @since jdk1.8
 */
public class Utility {
	
	/**
	 * 천 단위 콤마 찍어주는 메서드
	 * @param number 입력 숫자
	 * @return 천 단위 컴마 찍힌 숫자
	 */
	public static String commaThousand(int number) {
		return NumberFormat.getInstance().format(number);
	}
	
	/**
	 * 날짜 더해주는 메서드
	 * @param vaccineName 백신명
	 * @param fisrtDate 1차 접종일
	 * @return 백신별 2차 접종일
	 */
	public static String addDate(String vaccineName, String fisrtDate) {
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		Date date = null;
		try {
			date = format.parse(fisrtDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.setTime(date);
		
		switch(vaccineName) {
		case "화이자" :
			cal.add(Calendar.YEAR, 0);
			cal.add(Calendar.MONTH, 0);
			cal.add(Calendar.DATE, 21);
			break;
		case "모더나" :
			cal.add(Calendar.YEAR, 0);
			cal.add(Calendar.MONTH, 1);
			cal.add(Calendar.DATE, 0);
			break;
		case "아스트라제네카" :
			cal.add(Calendar.MONTH, 3);
			cal.add(Calendar.DATE, 0);
			break;
		
		}
		return format.format(cal.getTime()) ;
	}
	
}









