package com.greedy.company.dto;

public class EmployeeDTO {
	
	private String name;
	private String department;
	
	public EmployeeDTO() {}
	
	public EmployeeDTO(String name, String department) {
		this.name = name;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "EmployeeDTO [name=" + name + ", department=" + department  +  "]";
	}
	
	

}
