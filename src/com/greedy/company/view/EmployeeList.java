package com.greedy.company.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.greedy.company.controller.EmployeeController;
import com.greedy.company.dto.EmployeeDTO;
import com.greedy.company.model.compator.DescName;

public class EmployeeList {
	
	private EmployeeController controller = new EmployeeController();
	Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		
		main:
		while(true) {
			System.out.println("=======메뉴=======");
			System.out.println("1. 직원 정보 추가");
			System.out.println("2. 전체 직원정보 조회");
			System.out.println("3. 정렬하여 조회");
			System.out.println("4. 직원 이름으로 조회");
			System.out.println("5. 부서명으로 조회");
			System.out.println("6. 직원 정보 수정");
			System.out.println("7. 직원 정보 삭제");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 :
				addList();
				break;
			case 2 :
				selectList();
				break;
			case 3 :
				sortMenu();
				break;
			case 4 :
				searchName();
				break;
			case 5 :
				searchdepartment();
				break;
			case 6 :
				updateEmployee();
				break;
			case 7 :
				removeEmployee();
				break;
			case 0 :
				System.out.println("프로그램을 종료합니다.");
				break main;
			default:
				System.out.println("잘못 선택하셨습니다. 번호를 다시 입력해주세요.");
				break;
				
			}
		}
		
		
	}

	private void addList() {
		System.out.println("==== 직원 정보 추가 ====");
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		System.out.print("부서 입력 : ");
		String department = sc.nextLine();
		
		controller.addList(new EmployeeDTO(name, department));
		
	}

	private void selectList() {
		System.out.println("==== 전체 직원정보 조회 ====");
		List<EmployeeDTO> employeeList = controller.selecList();
		if(!employeeList.isEmpty()) {
			for(EmployeeDTO emp : employeeList) {
				System.out.println(emp);
			}
		} else {
			System.out.println("목록이 존재하지 않습니다.");
		}
		
	}

	private void sortMenu() {
		System.out.println("==== 정렬 메뉴 ====");
		System.out.println("1. 직원명 오름차순 정렬");
		System.out.println("2. 직원명 내림차순 정렬");
		System.out.print("메뉴 선택 : ");
		int num = sc.nextInt();
		
		ascDesc(num);	
	}

	private void ascDesc(int num) {
		System.out.println("==== 정렬하여 조회 ====");
		List<EmployeeDTO> employeeList = controller.selecList();
		
		/* 정렬 시 원본 데이터 변경을 하므로 사본 데이터를 저장*/
		List<EmployeeDTO> sortList = new ArrayList<EmployeeDTO>();
		sortList.addAll(employeeList);
		
		if(num == 1) {
			sortList.sort(new Comparator<EmployeeDTO>() {

				@Override
				public int compare(EmployeeDTO o1, EmployeeDTO o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
		} else {
			sortList.sort(new DescName());
		}
		
		for(int i = 0; i <sortList.size(); i++) {
			System.out.println(sortList.get(i));
		}
		
	}
	/* 직원명 조회*/
	private void searchName() {
		System.out.println("==== 이름으로 조회 ====");
		System.out.print("직원이름 입력 : ");
		List<EmployeeDTO> searchList = controller.searchName(sc.nextLine());
		
		if(!searchList.isEmpty()) {
			for(int i = 0; i < searchList.size(); i++) {
				System.out.println(searchList.get(i));
			}
			
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
		
	}

	private void searchdepartment() {
		System.out.println("==== 부서명으로 조회 ====");
		System.out.println("부서명 입력 : ");
		List<EmployeeDTO> searchList = controller.seachDepartment(sc.nextLine());
		
		if(!searchList.isEmpty()) {
			for(int i = 0; i < searchList.size(); i++) {
				System.out.println(searchList.get(i));
			}
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
	}

	private void updateEmployee() {
		System.out.println("==== 직원 정보 수정 ====");
		System.out.print("수정할 직원의 이름 : ");
		String name = sc.nextLine();
		
		System.out.print("수정할 이름 : ");
		String rename = sc.nextLine();
		System.out.print("수정할 부서 : ");
		String redep = sc.nextLine();
		
		EmployeeDTO updateEmployee = new EmployeeDTO(rename, redep);
		int result = controller.upDateEmployee(name,updateEmployee);
		
		if(result > 0) {
			System.out.println("성공적으로 수정 되었습니다.");
		}else {
			System.out.println("수정할 직원을 찾지 못했습니다.");
		}
		
		
	}

	private void removeEmployee() {
		System.out.println("==== 직원 정보 삭제 ====");
		System.out.print("삭제할 직원의 이름 : ");
		int delname = controller.removerEmployee(sc.nextLine());
		
		if(delname > 0) {
			System.out.println("성공적으로 삭제 되었습니다.");
		}else {
			System.out.println("삭제할 직원을 찾지 못했습니다.");
		}
	}

}
