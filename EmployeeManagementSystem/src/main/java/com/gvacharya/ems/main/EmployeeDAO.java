package com.gvacharya.ems.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

public class EmployeeDAO {

	
	private SessionFactory factory;
	
	public EmployeeDAO(){
		
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public void saveEmployee(Employee employee) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		session.close();
	}
	
	public Employee getEmployee(int id) {
		Session session = factory.openSession();
		Employee employee = session.get(Employee.class, id);
		
		session.close();
		return employee;
	}
	
	public void updateEmployee(Employee employee) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(employee);
		transaction.commit();
		session.close();
	}
	
	public void deleteEmployee(int id) {
		Session session =  factory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = session.get(Employee.class, id);
		if(employee!=null) {
			session.delete(employee);
		}
		transaction.commit();
		session.close();
	}
	
	public void closeFactory() {
		factory.close();
	}
}
