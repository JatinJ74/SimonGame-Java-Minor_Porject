package com.gvacharya.ems.main;

import javax.persistence.*;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_fname")
	private String firstName;
	
	@Column(name="emp_lname")
	private String LastName;
	
	@Column(name="emp_email")
	private String email;
	
	@Column(name="emp_salary")
	private Double salary;

	public Employee() {
		super();

	}

	public Employee(int empId, String firstName, String lastName, String email, Double salary) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.LastName = lastName;
		this.email = email;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", LastName=" + LastName + ", email=" + email
				+ ", salary=" + salary + "]";
	}
	
	
}
