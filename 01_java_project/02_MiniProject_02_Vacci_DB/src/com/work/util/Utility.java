package com.work.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * <pre>
 * -- 공통으로 사용하는 메서드를 위한 유틸리티 클래스
 * -- 모든 메서드는 객체생성없이 사용가능 Class Method 선언(static method)
 * </pre>
 * 
 *
 */
public class Utility {
	public static void main(String[] args) {
//		System.out.println("현재날짜");
		
//		print("현재날짜");
//		System.out.println(Utility.getCurrentDate());
//		System.out.println(Utility.getCurrentDate("MM-dd-yyyy"));
//		System.out.println(Utility.getCurrentDate("MM/dd/yyyy [a] hh:mm"));
//		System.out.println(Utility.getCurrentDate("MM/dd/yyyy [a] hh:mm", Locale.US));
//		System.out.println(Utility.getCurrentDate("MM/dd/yyyy [a] hh:mm", Locale.CHINA));
//		System.out.println(Utility.getCurrentDate("HH:mm"));
//		System.out.println(Utility.getCurrentDate("[a]hh:mm"));
//		System.out.println(Utility.getCurrentDate("[a]hh:mm", Locale.US));
//		
//		print("숫자형식");
//		int mileage = 1234567;
//		NumberFormat numberFormat = NumberFormat.getInstance();
//		NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance();
//		NumberFormat numberFormat3 = NumberFormat.getCurrencyInstance(Locale.US);
//		
//		System.out.println(numberFormat.format(mileage));
//		System.out.println(numberFormat2.format(mileage));
//		System.out.println(numberFormat3.format(mileage));
		
		print("임시발급숫자");
		System.out.println(Utility.getSecureNumberString());
		System.out.println(Utility.getSecureNumberString(6));
		System.out.println(Utility.getSecureNumberString(10));
		
		System.out.println(Utility.getSecureAlphabetString());
		System.out.println(Utility.getSecureAlphabetString(6));
		System.out.println(Utility.getSecureAlphabetString(10));
	}
	
	/** 
	 * 테스트시에 테스트 항목을 출력하기 위한 메서드
	 * @param message 테스트 문자열
	 */
	public static void print(String message) {
		System.out.println("\n### " + message);
	}
	
	/**
	 * 현재 날짜를 기본날짜형식 년도 4자리.월2자리.일2자리 형식의 문자열 변환 반환 메서드
	 * @return 기본 형식의 현자낼짜 문자열
	 */
	public static String getCurrentDate() {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
//		String currentDate = simpleDateFormat.format(new Date());
//		return currentDate;
		
		//return new SimpleDateFormat("yyyy.MM.dd").format(new Date());
		return getCurrentDate("yyyy-MM-dd");
	};
	
	
	/**
	 * 아규먼트로 전달받은 날짜 형식의 현재날짜 변환 반환 메서드 
	 * @param pattern 날짜형식
	 * @return 날짜형식의 현재날짜 문자열
	 */
	public static String getCurrentDate(String pattern) {
		//return new SimpleDateFormat(pattern).format(new Date());
		return getCurrentDate(pattern, Locale.KOREA);
	}
	
	/**
	 * <pre>
	 * 아규먼트로 전달받은 날짜 형식, 로케일 형식의 현재날짜 변환 반환 메서드
	 * 로케일 : java.util.Locale => FIELD 참고
	 * java.util.SimpleDateFormat 생성자 중복정의 => public SimpleDateFormat(String, Locale)
	 * 
	 * </pre>
	 * @see java.util.Locale
	 * @see java.util.SimpleDateFormat
	 * @param pattern  날짜형식  및 시간 형식
	 * @param locale 로케일형식
	 * @return  날짜 형식, 로케일 형식의 현재날짜 문자열
	 */
	public static String getCurrentDate(String pattern, Locale locale) {
		return new SimpleDateFormat(pattern, locale).format(new Date());
	}
	

	
	// TODO 5 : 보안문자 발급 메서드 : 기본으로 4자리 숫자형식의 문자열 반환 메서드
	public static String getSecureNumberString() {
		return getSecureNumberString(4);
	}
	
	public static String getSecureNumberString(int length) {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		StringBuilder secureString = new StringBuilder();
		
		for (int index = 0; index < length; index++) {
			secureString.append(random.nextInt(10));
		}
		return secureString.toString();
	}

	/** 보안 영문 대문자 */
	public static String getSecureAlphabetString() {
		return getSecureAlphabetString(4);
	}
	
	public static String getSecureAlphabetString(int length) {
//		Random random = new Random((long)(Math.random() * System.nanoTime()));
//		StringBuilder secureString = new StringBuilder();
//		
//		for (int index = 0; index < length; index++) {
//			secureString.append((char)(random.nextInt(26) + 97)); // + 65, + 97
//		}
//		return secureString.toString();
		
		return getSecureAlphabetString(length, true);
	}

	public static String getSecureAlphabetString(int length, boolean isUpper) {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		StringBuilder secureString = new StringBuilder();
		
		for (int index = 0; index < length; index++) {
			if (isUpper) {
				secureString.append((char)(random.nextInt(26) + 'A')); // + 65
			} else {
				secureString.append((char)(random.nextInt(26) + 'a'));	// + 97
			}
		}
		return secureString.toString();
	}

	public static String getSecureAlphabetString(int length, boolean isUpper, boolean isMixed) {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		StringBuilder secureString = new StringBuilder();
		
		for (int index = 0; index < length; index++) {
			if (isMixed) {
				if(random.nextBoolean()) {
					if (isUpper) {
						secureString.append((char)(random.nextInt(26) + 'A')); 
					} else {
						secureString.append((char)(random.nextInt(26) + 'a'));	
					}
				} else {
					secureString.append(random.nextInt(10));
				}
			} else {
				if (isUpper) {
					secureString.append((char)(random.nextInt(26) + 'A')); 
				} else {
					secureString.append((char)(random.nextInt(26) + 'a'));	
				}
			}
		}
		return secureString.toString();
	}
	
	public static int getLottoNo() {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		return random.nextInt(45) + 1; // 0 ~ 44 , 46:0~45, 45:0~44+1 => 1~45
	}
	

	public static String commaThousand(int number) {
		return NumberFormat.getInstance().format(number);
	}
	
	public static String addDate(String vaccineName, String fisrtDate) {
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		Date date = null;
		try {
			date = format.parse(fisrtDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
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









