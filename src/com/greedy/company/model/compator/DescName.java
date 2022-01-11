package com.greedy.company.model.compator;

import java.util.Comparator;

import com.greedy.company.dto.EmployeeDTO;

public class DescName implements Comparator<EmployeeDTO> {

	@Override
	public int compare(EmployeeDTO o1, EmployeeDTO o2) {
		
		return -o1.getName().compareTo(o2.getName());
	}

}
