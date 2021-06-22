package com.work.view;

/**
 * <pre>
 * 백신도우미 시스템 CUI 시작 클래스
 * </pre>
 *  
 * @author 김기영
 * @version ver.2.0
 * @since jdk1.8
 */
public class CUI {

	/**
	 * 백신도우미 시스템 CUI 시작 메서드
	 * @param args 메인
	 */
	public static void main(String[] args) {
		Menu view = new Menu();

		while(true) {
				view.mainMenu();
		}

	}
}
