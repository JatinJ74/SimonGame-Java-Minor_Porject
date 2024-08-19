package com.gvacharya.ems.main;

import java.util.ArrayList;
import java.util.List;

public class App{
	
	public static void main(String[] args) {
		
		EmployeeDAO emp_service = new  EmployeeDAO();
		
		Employee emp = new Employee(1,"Jatin","Jaiswal","Jaiswaljatin123@gmail.com",50000.0D);
		emp_service.saveEmployee(emp);
		
		Employee retrivedEmp = emp_service.getEmployee(emp.getEmpId());
		System.out.println(retrivedEmp);
		
	}
}
