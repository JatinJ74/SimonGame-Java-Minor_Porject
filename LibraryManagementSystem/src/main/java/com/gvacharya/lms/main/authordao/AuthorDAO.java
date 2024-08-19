package com.gvacharya.lms.main.authordao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gvacharya.lms.main.authors.Authors;

public class AuthorDAO {

	private SessionFactory sFactory;
	
	public AuthorDAO() {
		sFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public void saveAuthor(Authors author) {
		try(Session session = sFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			session.save(author);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAuthor(int id) {
		try(Session session = sFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			Authors author = session.get(Authors.class,id);
			session.delete(author);
			transaction.commit();
		}
	}
	
	public Authors getAuthors(int id) {
		try(Session session = sFactory.openSession()){
			return session.get(Authors.class, id);
		}
	}
	
	public void updateAuthors(Authors author) {
		try(Session session = sFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			session.update(author);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
