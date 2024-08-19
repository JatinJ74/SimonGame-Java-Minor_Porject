package com.gvacharya.lms.main.bookdao;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.jpa.event.internal.CallbacksFactory;
import org.hibernate.Session;

import com.gvacharya.lms.main.book.Book;

public class BookDAO {

	private SessionFactory sFactory;
	
	public BookDAO() {
		sFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	}
	
	public void saveBook(Book book) {
		try(Session session = sFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteBook(int id) {
		try(Session session = sFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			
			Book book = session.get(Book.class, id);
			if(book!=null) {
				session.delete(book);
				System.out.println("Book deleted successfully!");
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateBook(Book book) {
		try(Session session = sFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			
			
			session.update(book);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Book getBooks(int id) {
		try(Session session = sFactory.openSession()){
			
			return session.get(Book.class, id);

		}
	}
}
