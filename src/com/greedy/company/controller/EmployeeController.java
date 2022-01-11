package com.greedy.company.controller;

import java.util.ArrayList;
import java.util.List;

import com.greedy.company.dto.EmployeeDTO;

public class EmployeeController {
	
	/* 직원 목록이 저장되는 리스트 */
	private List<EmployeeDTO> list = new ArrayList<>();
	
	/* 직원 추가*/
	public void addList(EmployeeDTO name) {
		list.add(name);
	}
	
	/* 전체 직원 조회*/
	public List<EmployeeDTO> selecList() {
		return list;
	}

	/* 직원 이름으로 조회*/
	public List<EmployeeDTO> searchName(String name) {
		List<EmployeeDTO> searchList = new ArrayList<EmployeeDTO>();
		
		for(EmployeeDTO emp : list) {
			if(emp.getName().contains(name)) {
				searchList.add(emp);
			}
		}
		
		return searchList;
	}

	public List<EmployeeDTO> seachDepartment(String department) {
		/* 부서를 검색해서 해당 키워드가 포함 되는 사람들을 리턴 받기 위한 리스트 */
		List<EmployeeDTO> searchList = new ArrayList<EmployeeDTO>();
		
		for(EmployeeDTO dep : list) {
			if(dep.getDepartment().contains(department)) {
				searchList.add(dep);
			}
		}
		
		return searchList;
	}
	/*이름 수정 - 이름 기준으로 조회해서 수정*/
	public int upDateEmployee(String name, EmployeeDTO updateEmployee) {
		EmployeeDTO old = null;
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getName().equals(name)) {
				old = list.set(i, updateEmployee);
			}
		}
		//old의 값이 반환되면 result는 1, 반환되지 않은경우엔 0 
		return old != null? 1 : 0;
	}
	/* 이름 기준으로 직원 정보 삭제 */
	public int removerEmployee(String name) {
		EmployeeDTO old = null;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(name)) {
				old = list.remove(i);
			}
		}
		//old의 값이 반환되면 result는 1, 반환되지 않은경우엔 0 
		return old != null ? 1 : 0;
	}

}
