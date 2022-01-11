package com.greedy.company.run;

import com.greedy.company.view.EmployeeList;

public class Application {

	/* MVC 패턴?
	 * 디자인 패턴 중 하나로 MVC는 Model, View, Controller를 뜻한다.
	 * Model : data, 정보의 가공을 책임지는 파트
	 * View : 사용자 인터페이스, 데이터 입출력 파트
	 * Controller : 데이터와 사용자 인터페이스를 잇는 다리 역할 
	 * 이러한 MVC 디자인 패턴을 사용하여 용도에 따른 구분을 두면 유지보수성, 확장성, 유연성이 증가한다.
	 * */
	
	public static void main(String[] args) {
		EmployeeList list = new EmployeeList();
		list.mainMenu();
	}

}
