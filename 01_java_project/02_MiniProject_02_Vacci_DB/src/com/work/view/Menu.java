package com.work.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.work.model.CenterList;
import com.work.model.ReserveMember;
import com.work.model.VaccineCount;
import com.work.service.CenterService;
import com.work.service.ReserveService;
import com.work.service.VaccineService;

public class Menu {


	CenterService service = new CenterService();
	VaccineService vacService = new VaccineService();
	ReserveService rService = new ReserveService();

	public void mainMenu() {

		printTitle("백신 도우미 메인메뉴");
		System.out.println("1. 접종자 수 조회"); 
		System.out.println("2. 우선 접종대상자 조회");
		System.out.println("3. 예방접종센터 조회");
		System.out.println("4. 백신별 2차 접종 대기기간 조회");
		System.out.println("5. 2차 접종 알림 신청");
		System.out.println("6. 2차 접종 알림 신청자 로그인");
		System.out.println("9. 관리자 메뉴");
		System.out.println("0. 프로그램 종료");
		printLine();
		System.out.println();
		System.out.print("메뉴번호 입력 : ");
		int menuNo = inputNumber();

		switch(menuNo) {
		case 1:
			vaccineCountMenu();
			break;
		case 2:
			prefferdMember();
			break;
		case 3:
			centerMenu();
			break;
		case 4:
			waitVaccine();
			break;
		case 5:
			addMember();
			break;
		case 6:
			rLogin();
			break;
		case 9:
			adminLogin();
			break;	
		case 0:
			exitMenu();
			break;		

		}
	}

	public void vaccineCountMenu() {

		printTitle("접종자 수 조회 메뉴");

		System.out.println("1. 1차, 2차 접종자 수 조회");
		System.out.println("2. 누적 1차, 2차 접종자 수 조회");
		System.out.println("0. 메인메뉴로 돌아가기");
		printLine();

		System.out.print("메뉴번호 입력 : ");

		int menuNo = inputNumber();

		switch(menuNo) { 

		case 1:
			selectVaccineCount();
			break;
		case 2:
			selectTotalVaccineCount();
			break;
		case 0:
			mainMenu();
			break;
		}
	}


	public void selectVaccineCount() {

		printTitle("1차, 2차 접종자 수 조회");
		System.out.print("날짜 : ");
		String day = inputString();
		System.out.print("지역 : ");
		String region = inputString();

		String vacci = vacService.getVaccineCount(day, region);
		if (vacci != null) {
			System.out.println(vacci);
			pause();
			vaccineCountMenu();
		} else {
			System.out.println("조회 실패 : 접종자 수 정보가 존재하지 않습니다.");
			pause();
			vaccineCountMenu();
		}
	}

	public void selectTotalVaccineCount() {

		printTitle("1차, 2차 누적 접종자 수 조회");
		System.out.print("날짜 : ");
		String day = inputString();
		System.out.print("지역 : ");
		String region = inputString();

		String vacci = vacService.getTotalVaccineCount(day, region);
		if (vacci != null) {
			System.out.println(vacci);
			pause();
			vaccineCountMenu();
		} else {
			System.out.println("조회 실패 : 누적 접종자 수 정보가 존재하지 않습니다.");
			pause();
			vaccineCountMenu();
		}
	}

	public void prefferdMember() {

		printTitle("우선 접종자 여부 조회 메뉴");
		System.out.print("나이 : ");
		int age = inputNumber();
		System.out.println("직업 목록 : [회사원, 학생, 의료, 경찰, 소방, 군인]");
		System.out.print("직업 : ");
		String job = inputString();

		String preffer = vacService.prefferdMember(age, job);
		if (preffer != null) {
			System.out.println(preffer);
			pause();
		} else {
			System.out.println("조회 실패 : 정보가 존재하지 않습니다.");
			pause();
		}
	}

	

	public void centerMenu() {

		printTitle("예방접종센터 조회 메뉴");

		System.out.println("1. 센터명으로 찾기");
		System.out.println("2. 시설명으로 찾기");
		System.out.println("3. 주소로 찾기");
		System.out.println("4. 전화번호로 찾기");
		System.out.println("0. 메인메뉴로 돌아가기");
		printLine();

		System.out.print("메뉴번호 입력 : ");

		int menuNo = inputNumber();

		switch(menuNo) { 

		case 1:
			selectCenterName();
			break;
		case 2:
			selectFacilityName();
			break;
		case 3:
			//selectAdress();
			selectAddressAll();
			break;
		case 4:
			selectPhoneNumber();
			break;
		case 0:
			mainMenu();
			break;
		}
	}



	public void selectCenterName() {
		printTitle("센터명으로 상세 조회");
		System.out.print("센터명 : ");
		String centerName = inputString();
		CenterList dto = service.getCenterByCenterName(centerName);
		if (dto != null) {
			System.out.println(dto);
			pause();
			centerMenu();
		} else {
			System.out.println("조회 실패 : 센터정보가 존재하지 않습니다.");
			pause();
			centerMenu();
		}

	}


	public void selectFacilityName() {
		printTitle("시설명으로 상세 조회");
		System.out.print("시설명 : ");
		String facilityName = inputString();
		CenterList dto = service.getCenterByFacilityName(facilityName);
		if (dto != null) {
			System.out.println(dto);
			pause();
			centerMenu();
		} else {
			System.out.println("조회 실패 : 센터정보가 존재하지 않습니다.");
			pause();
			centerMenu();
		}

	}

	// 여러개 있으면 다 나오게 처리 필요 
	public void selectAdress() {
		printTitle("주소로 상세 조회");
		System.out.print("주소 : ");
		String address = inputString();
		CenterList dto = service.getCenterByAdress(address);
		if (dto != null) {
			System.out.println(dto);
			pause();
			centerMenu();
		} else {
			System.out.println("조회 실패 : 센터정보가 존재하지 않습니다.");
			pause();
			centerMenu();
		}

	}
	
	public void selectAddressAll() {
		printTitle("주소로 상세 조회 - 여러 개 ");
		System.out.print("주소 : ");
		String address = inputString();
		ArrayList<CenterList> list = service.getAddressAll(address);
		if (list != null) {
			for (CenterList center : list) {
				System.out.println(center);
			}
			pause();
			adminMenu();
		} else {
			System.out.println("조회 실패 : 센터정보가 존재하지 않습니다.");
			pause();
			centerMenu();
		}
		
	}


	public void selectPhoneNumber() {
		printTitle("전화번호로 상세 조회");
		System.out.print("전화번호 : ");
		String address = inputString();
		CenterList dto = service.getCenterByPhoneNumber(address);
		if (dto != null) {
			System.out.println(dto);
			pause();
			centerMenu();
		} else {
			System.out.println("조회 실패 : 센터정보가 존재하지 않습니다.");
			pause();
			centerMenu();
		}

	}
	
	public void waitVaccine() {
		printTitle("백신별 2차 접종 대기기간 조회");
		System.out.print("백신명 : ");
		String vaccineName = inputString();
		System.out.print("1차 접종 : ");
		String firstDay = inputString();
		
		String result = vacService.waitVaccine(vaccineName, firstDay);
		if (result != null) {
			System.out.println();
			System.out.println("2차 접종일 알림을 받으시겠습니까? [O, X] ");
			String ox = inputString();
			if (ox.equals("O")) {
				addMember();
			}
			
		} else {
			System.out.println("조회 실패 : 정보가 존재하지 않습니다.");
			pause();
		}

	}

	public void addMember() {
		printTitle("2차 접종 알림 신청");
		System.out.print("이름 : ");
		String name = inputString();
		
		System.out.print("전화번호 : ");
		String mobile = inputString();
		
		System.out.print("주소 : ");
		String address = inputString();
		
		System.out.print("주민번호 : ");
		String idNumber = inputString();
		
		System.out.print("맞은 백신명 : ");
		String vaccineName = inputString();
		
		System.out.print("1차 접종일 : ");
		String firstVaccineDate = inputString();
		
		boolean result = rService.updateReserveMember(name, mobile, address, idNumber, vaccineName, firstVaccineDate);
		
		if (result != false) {
			System.out.println("등록 성공");
			pause();
		} else {
			System.out.println("조회 실패 : 정보가 존재하지 않습니다.");
			pause();
		}

	}
	
	public boolean rLogin() {
		printTitle("2차 접종 알림 신청자 로그인");
		System.out.print("이름 : ");
		String registrantName = inputString();

		System.out.print("주민번호 : ");
		String idNumber = inputString();
		
		String vaccineName = rService.rLogin(registrantName, idNumber);
		if (vaccineName != null) {
			System.out.println("로그인 성공");
			reserveMenu();
			return true;
		} else {
			System.out.println("로그인 실패");
			pause();
		}

		return false;
		
	}

	public void reserveMenu() {

		printTitle("2차 접종 알림 신청자 메뉴");

		System.out.println("1. 등록 정보 조회");
		System.out.println("2. 등록 연락처 변경");
		System.out.println("3. 등록 정보 삭제");
		System.out.println("0. 로그아웃하고 메인메뉴로 돌아가기");
		printLine();

		System.out.print("메뉴번호 입력 : ");

		int menuNo = inputNumber();

		switch(menuNo) { 

		case 1:
			selectReserveOne();
			break;
		case 2:
			updateReservePhoneNumber();
			break;
		case 3:
			deleteReserveOne();
			break;
		case 0:
			mainMenu();
			break;
		}
	}
	
	public void selectReserveOne() {
		printTitle("등록 정보 조회");
		System.out.println("정보를 다시 한번 확인합니다.");
		System.out.print("이름 : ");
		String name = inputString();
		System.out.print("주민번호 : ");
		String idNumber = inputString();
		ReserveMember dto = rService.getselectOne(name, idNumber);
		if (dto != null) {
			System.out.println(dto);
			pause();
			reserveMenu();
		} else {
			System.out.println("조회 실패 : 정보가 존재하지 않습니다.");
			pause();
			reserveMenu();
		}

	}
	
	public void updateReservePhoneNumber() {
		printTitle("등록 연락처 변경");
		System.out.println("정보를 다시 한번 확인합니다.");
		System.out.print("이름 : ");
		String name = inputString();
		
		System.out.print("주민번호 : ");
		String idNumber = inputString();
		
		System.out.print("변경할 연락처: ");
		String phoneNumber = inputString();
		
		boolean result = rService.updateMobile(name, idNumber, phoneNumber);
				
		if (result != false) {
			pause();
			System.out.println("변경 완료");
			reserveMenu();
		} else {
			System.out.println("변경 실패 : 정보가 존재하지 않습니다.");
			pause();
			reserveMenu();
		}

	}
	
	//신청자 - 등록 정보 삭제
	public void deleteReserveOne() {
		printTitle("등록 정보 삭제");
		System.out.println("정보를 다시 한번 확인합니다.");
		System.out.print("이름 : ");
		String name = inputString();
		
		System.out.print("주민번호 : ");
		String idNumber = inputString();
		
		
		boolean result = rService.deleteOne(name, idNumber);
				
		if (result != false) {
			pause();
			System.out.println("삭제 완료");
			reserveMenu();
		} else {
			System.out.println("삭제 실패 : 정보가 존재하지 않습니다.");
			pause();
			reserveMenu();
		}

	}
	
	
	public boolean adminLogin() {
		printTitle("관리자 로그인");

		System.out.print("관리자 아이디 : ");
		String adminId = inputString();

		System.out.print("관리자 비밀번호 : ");
		String adminPw = inputString();

		String adminName = service.adminLogin(adminId, adminPw);
		if (adminName != null) {
			System.out.println("관리자 로그인 성공");
			adminMenu();
			return true;
		} else {
			System.out.println("관리자 로그인 실패");
			pause();
		}

		return false;
	}


	public void adminMenu() {

		printTitle("관리자 메뉴");

		
		System.out.println("1. 백신 접종 수 전체 조회");
		System.out.println("2. 백신 접종 수 등록");
		System.out.println("3. 백신 접종 수 변경");
		System.out.println("4. 백신 접종 수 삭제");
		
		System.out.println("5. 전체센터조회");
		System.out.println("6. 등록 센터 수 조회");
		System.out.println("7. 센터 등록");
		System.out.println("8. 센터 연락처 정보 변경");
		System.out.println("9. 센터 정보 삭제");
		
		
		
		System.out.println("10. 2차 접종 알림 신청자 전체 조회");
		System.out.println("11. 2차 접종 알림 신청자 삭제");
		
		System.out.println("0. 메인메뉴로 돌아가기");
		printLine();

		System.out.print("메뉴번호 입력 : ");

		int menuNo = inputNumber();

		switch(menuNo) { 

		case 1:
			selectVaccineAll();
			break;
		case 2:
			insertVaccineCunt();
			break;
		case 3:
			updateVaccineCunt();
			break;
		case 4:
			deleteVaccineCount();
			break;	
		
		case 5:
			selectCenterAll();
			break;
		case 6:
			selectCount();
			break;
		case 7:
			insertCeneter();
			break;
		case 8:
			updateCenterPhone();
			break;
		case 9:
			deleteCenterOne();
			break;
			
		
			
		case 10:
			selectR();
			break;
		case 11:
			deleteReserveOneAdmin();
			break;
			
		case 0:
			mainMenu();
			break;
		}
	}

	//1
	public void selectCenterAll() {
		printTitle("관리자 - 전체 센터 조회");
		ArrayList<CenterList> list = service.getCenterAll();
		for (CenterList center : list) {
			System.out.println(center);
		}
		pause();
		adminMenu();
	}

	//2
	public int selectCount() {
		printTitle("관리자 - 등록 센터 수 조회");
		int count = service.getCenterCount();
		if (count != 0) {
			System.out.println(count);
			pause();
			adminMenu();
		} else {
			System.out.println("센터정보가 존재하지 않습니다.");
			pause();
			adminMenu();
		}
		return 0;
	}
	

	//3 
	
	public void insertCeneter() {
		printTitle("관리자 - 센터 등록");
		System.out.print("센터명 : ");
		String centerName = inputString();
		
		System.out.print("시설명 : ");
		String facilityName = inputString();
		
		System.out.print("우편번호 : ");
		String postcode = inputString();
		
		System.out.print("주소 : ");
		String address = inputString();
		
		System.out.print("세부 주소 : ");
		String addressDetail = inputString();
		
		System.out.print("전화번호 : ");
		String phoneNumber = inputString();
		
		boolean result = service.insertCenter(centerName, facilityName, postcode, address, addressDetail, phoneNumber);
		
		if (result != false) {
			System.out.println("등록 성공");
			pause();
			adminMenu();
		} else {
			System.out.println("등록 실패");
			pause();
			adminMenu();
		}

	}
	
	//4 센터 정보 변경
	
	public void updateCenterPhone() {
		printTitle("센터 연락처 변경");
		System.out.print("센터명 : ");
		String centerName = inputString();
		
		System.out.print("변경할 연락처: ");
		String phoneNumber = inputString();
		
		boolean result = service.updateCenterPhone(centerName, phoneNumber);
				
		if (result != false) {
			pause();
			System.out.println("변경 완료");
			adminMenu();
		} else {
			System.out.println("변경 실패 : 정보가 존재하지 않습니다.");
			pause();
			adminMenu();
		}

	}
	
	//5 센터 정보 삭제
	public void deleteCenterOne() {
		printTitle("센터 정보 삭제");
		System.out.print("센터명 : ");
		String centerName = inputString();
		
		boolean result = service.deleteCenterOne(centerName);
				
		if (result != false) {
			pause();
			System.out.println("삭제 완료");
			adminMenu();
		} else {
			System.out.println("삭제 실패 : 정보가 존재하지 않습니다.");
			pause();
			adminMenu();
		}

	}
	
	//6 백신 접종수 정보 전체 조회
	
	public void selectVaccineAll() {
		printTitle("관리자 - 접종자 수 정보 전체 조회");
		ArrayList<VaccineCount> list = vacService.getSelectAll();
		for (VaccineCount vaccineDate : list) {
			System.out.println(vaccineDate);
		}
		pause();
		adminMenu();
	}
	
	//7 백신 접종수 정보 등록
	public void insertVaccineCunt() {
		printTitle("백신 접종 수 등록");
		System.out.print("날짜 : ");
		String day = inputString();
		
		System.out.print("지역 : ");
		String region = inputString();
		
		System.out.print("1차 접종수 : ");
		int yFirst = inputNumber();
		
		System.out.print("2차 접종수 : ");
		int ySecond = inputNumber();
		
		System.out.print("누적 1차 접종수 : ");
		int tFirst = inputNumber();
		
		System.out.print("누적 2차 접종수 : ");
		int tSecond = inputNumber();
		
		boolean result = vacService.insertVaccienCount(day, region, yFirst, ySecond, tFirst, tSecond);
		
		if (result != false) {
			System.out.println("등록 성공");
			pause();
			adminMenu();
		} else {
			System.out.println("등록 실패");
			pause();
			adminMenu();
		}

	}
	//8 백신 접종수 정보 변경 
	public void updateVaccineCunt() {
		printTitle("백신 접종 수 정보 변경");
		System.out.print("날짜 : ");
		String day = inputString();
		
		System.out.print("지역 : ");
		String region = inputString();
		
		System.out.print("변경할 1차 접종수 : ");
		int yFirst = inputNumber();
		
		System.out.print("변경할 2차 접종수 : ");
		int ySecond = inputNumber();
		
		System.out.print("변경할 누적 1차 접종수 : ");
		int tFirst = inputNumber();
		
		System.out.print("변경할 누적 2차 접종수 : ");
		int tSecond = inputNumber();
		
		boolean result = vacService.updateVaccienCount(day, region, yFirst, ySecond, tFirst, tSecond);
		
		if (result != false) {
			System.out.println("변경 성공");
			pause();
			adminMenu();
		} else {
			System.out.println("등록 실패");
			pause();
			adminMenu();
		}

	}
	//9 백신 접종수 정보 삭제 
	public void deleteVaccineCount() {
		printTitle("백신 접종 수 정보 삭제");
		System.out.print("날짜 : ");
		String day = inputString();
		
		System.out.print("지역 : ");
		String region = inputString();
		
		boolean result = vacService.deleteVaccienCount(day, region);
		
		if (result != false) {
			System.out.println("삭제 성공");
			pause();
			adminMenu();
		} else {
			System.out.println("등록 실패");
			pause();
			adminMenu();
		}

	}
	
	
	
	//10
	public void selectR() {
		printTitle("관리자 - 신청자 정보 전체 조회");
		ArrayList<ReserveMember> list = rService.selectAll();
		for (ReserveMember member : list) {
			System.out.println(member);
		}
		pause();
		adminMenu();
	}
	
	
	//11 관리자 - 신청자 정보 삭제 
		public void deleteReserveOneAdmin() {
			printTitle("등록 정보 삭제");
			System.out.println("정보를 다시 한번 확인합니다.");
			System.out.print("이름 : ");
			String name = inputString();
			
			System.out.print("주민번호 : ");
			String idNumber = inputString();
			
			
			boolean result = rService.deleteOneAdmin(name, idNumber);
					
			if (result != false) {
				pause();
				System.out.println("삭제 완료");
				adminMenu();
			} else {
				System.out.println("삭제 실패 : 정보가 존재하지 않습니다.");
				pause();
				adminMenu();
			}

		}
	


	public static void print(String message) {
		System.out.println("\n### " + message);
	}


	/**
	 * 구분선 출력
	 */
	public void printLine() {
		System.out.println("********************************");
	}

	/**
	 * 제목 출력
	 * @param title 제목
	 */
	public void printTitle(String title) {
		System.out.println();
		printLine();
		System.out.println(title);
		printLine();
	}

	/**
	 * 문자열 입력 반환
	 * @return 입력 문자열
	 */
	public String inputString() {
		String data = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			data = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 숫자 입력 반환
	 * @return 입력 정수형 숫자
	 */
	public int inputNumber() {
		String data = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			data = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
			return Integer.parseInt(data);
		} catch (NumberFormatException e) {

		}
		return -1;
	}

	/**
	 * 바로 메인 메뉴로 넘어가지 않게 대기 시켜주는 메서드
	 */
	private void pause()  {
		System.out.println();
		System.out.println();
		System.out.println("계속하시려면 엔터를, 종료하시려면 0번을 입력해주세요");
		int menuNo = inputNumber();
		switch(menuNo) {
		case 1:
			break;
		case 0:
			exitMenu();
			break;
		default:
			break;
		}
	}

	/** 프로그램 종료 메뉴 */
	public void exitMenu() {

		printTitle("백신 도우미 프로그램 정상 종료");
		System.exit(0);
	}

}
